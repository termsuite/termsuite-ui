package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import eu.project.ttc.engines.cleaner.TermProperty;
import eu.project.ttc.engines.desc.Lang;
import eu.project.ttc.engines.desc.TermSuiteCollection;
import eu.project.ttc.models.Document;
import eu.project.ttc.models.OccurrenceType;
import eu.project.ttc.models.TermIndex;
import eu.project.ttc.models.TermOccurrence;
import eu.project.ttc.tools.TermSuitePipeline;
import eu.project.ttc.tools.TermSuiteResourceManager;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.dialogs.CorpusSelectionDialog;
import fr.univnantes.termsuite.ui.jobs.RunPipelineJob;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.services.TerminoService;
import fr.univnantes.termsuite.ui.util.FileUtil;
import fr.univnantes.termsuite.ui.util.LangUtil;
import fr.univnantes.termsuite.ui.util.WorkspaceUtil;


@Singleton
@SuppressWarnings("restriction")
public class CorpusServiceImpl implements CorpusService {

	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL) Shell activeShell;

	@Inject UISynchronize sync;

	@Inject 
	IEventBroker eventBroker;
	
	@Inject 
	IEclipseContext context;
	
	@Inject EPartService partService;
	
	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL) 
	private Shell parent;
	
	private Logger logger;
	
	private Map<URI, EDocument> documentCache = null;
	
	
	private static final String CAS_JSON_DIR = "json";
	private static final String CAS_XMI_DIR = "xmi";
	private static final String CAS_TSV_DIR = "tsv";
	
	private static final String JSON_EXTENSION = "json";
	private static final String TBX_EXTENSION = "tbx";
	private static final String TSV_EXTENSION = "tsv";

	
	private ECorporaList corpora = TermsuiteuiFactory.eINSTANCE.createECorporaList();

	public CorpusServiceImpl() {
		Map<String, Object> m = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		// Register the XMI resource factory for the .pipeline extension
		m.put(CORPUS_EXTENSION, new XMIResourceFactoryImpl());
	
		loadCorpora();
	}
	
	@PostConstruct
	public void init(ILoggerProvider loggerProvider) {
		this.logger = loggerProvider.getClassLogger(this.getClass());
		this.logger.debug("Initalizing service " + this.getClass());
	}
	
	
	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getCorporaList()
	 */
	@Override
	public ECorporaList getCorporaList() {
		return corpora;
	}

	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getDocumentPath(fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus)
	 */
	@Override
	public Path getDocumentPath(ESingleLanguageCorpus slc) {
		Path path = Paths.get(getPath(slc).toString(), slc.getCollectionType().toString().toLowerCase());
		return path;
	}
	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getPath(fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus)
	 */
	@Override
	public Path getPath(ESingleLanguageCorpus slc) {
		Lang termsuiteLang = LangUtil.getTermsuiteLang(slc.getLanguage());
		String corpusPath = slc.getCorpus().getPath();
		Path path = Paths.get(corpusPath, termsuiteLang.getNameUC());
		return path;
	}
	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getPath(fr.univnantes.termsuite.ui.model.termsuiteui.EDocument)
	 */
	@Override
	public Path getPath(EDocument d) {
		String string = getDocumentPath(d.getSingleLanguageCorpus()).toString();
		Path path = Paths.get(string, d.getFilename());
		return path;
	}

	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#asFile(fr.univnantes.termsuite.ui.model.termsuiteui.EDocument)
	 */
	@Override
	public File asFile(EDocument d) {
		Path path = getPath(d);
		return path.toFile();
	}

	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#createCorpus(java.lang.String)
	 */
	@Override
	public ECorpus createCorpus(String name, String corpusPath) {
		ECorpus corpus = TermsuiteuiFactory.eINSTANCE.createECorpus();
		corpus.setName(name);
		corpus.setPath(Paths.get(corpusPath).toString());
		for(File sl:candidateSLCChildrenForPath(corpus.getPath())) {
			ECollectionType type = Files.exists(Paths.get(sl.getAbsolutePath(), "tei")) ?
					ECollectionType.TEI:
							ECollectionType.TXT;
								
			ESingleLanguageCorpus slc = TermsuiteuiFactory.eINSTANCE.createESingleLanguageCorpus();
			slc.setCorpus(corpus);
			slc.setLanguage(LangUtil.getLangByNameUC(sl.getName()));
			slc.setCollectionType(type);
			
			for(File f:getDocumentPath(slc).toFile().listFiles()) {
				EDocument doc = TermsuiteuiFactory.eINSTANCE.createEDocument();
				doc.setFilename(f.getName());
				slc.getDocuments().add(doc);
			}
			corpus.getSingleLanguageCorpora().add(slc);
		}
		corpora.getCorpora().add(corpus);
		resetCache();
		try {
			saveCorpus(corpus);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return corpus;
	}

	@Override
	public File[] candidateSLCChildrenForPath(String path) {
		return new File(path).listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File child) {
					if(!child.isDirectory())
						return false;
					for(ELang l:SUPPORTED_LANGUAGES) {
						if(LangUtil.getTermsuiteLang(l).getNameUC().equals(child.getName())) 
							return true;
					}
					return false;
				}
			});
	}

	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getCollectionType(fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus)
	 */
	@Override
	public TermSuiteCollection getCollectionType(ESingleLanguageCorpus corpus) {
		switch (corpus.getCollectionType()) {
		case TEI:
			return TermSuiteCollection.TEI;
		default:
			return TermSuiteCollection.TXT;
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getCollectionPath(fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus)
	 */
	@Override
	public String getCollectionPath(ESingleLanguageCorpus corpus) {
		return Paths.get(
				corpus.getCorpus().getPath(), 
				LangUtil.getTermsuiteLang(corpus.getLanguage()).getNameUC(),
				getCollectionType(corpus).toString().toLowerCase()
				).toString();
	}


	@Override
	public void runPipelineOnCorpus(EPipeline pipeline, ESingleLanguageCorpus corpus) {
		List<ESingleLanguageCorpus> l = Lists.newArrayList();
		l.add(corpus);
		runPipelineOnCorpus(pipeline, l);
	}



	@Override
	public void runPipelineOnSeveralCorpus(EPipeline pipeline, Iterable<ESingleLanguageCorpus> corpusList) {
		runPipelineOnCorpus(pipeline, corpusList);		
	}
	
	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#runPipelineOnCorpus(fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline, fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus)
	 */
	private void runPipelineOnCorpus(final EPipeline pipeline, final Iterable<ESingleLanguageCorpus> corpusList) {

		for(final ESingleLanguageCorpus corpus:corpusList) {
			final TermSuitePipeline tsp = toTermSuitePipeline(pipeline, corpus);
	
			String jobName = "Running pipeline " + pipeline.getFilename() + " on corpus " + corpus.getCorpus().getPath() + "/" + corpus.getLanguage().getName();
			
			Job job = new RunPipelineJob(jobName, tsp, sync) {
				@Override
				public void terminologyCreated(final TermIndex termIndex) {
					sync.asyncExec(new Runnable() {
						@Override
						public void run() {
							ETerminology terminology = context.get(TerminoService.class).createTerminology(
									corpus, 
									pipeline.getTargetTerminologyName(), 
									getTerminoJsonFile(corpus, pipeline),
									pipeline.isSpotWithOccurrences(),
									pipeline.isContextualizerEnabled());
							try {
								saveCorpus(corpus.getCorpus());
								eventBroker.post(TermSuiteEvents.NEW_TERMINOLOGY, terminology);
							} catch(IOException e) {
								MessageDialog.openError(activeShell, "Error saving terminology", e.getMessage());
							}
						}
					});
				}
			};
			job.schedule();
			sync.asyncExec(new Runnable() {
				@Override
				public void run() {
					partService.showPart(TermSuiteUI.PROGRESS_VIEW_ID, PartState.VISIBLE);
				}
			});
		}

	}



	private TermSuitePipeline toTermSuitePipeline(EPipeline pipeline, ESingleLanguageCorpus corpus) {
		TermSuiteResourceManager.getInstance().clear();
		TaggerService taggerService = context.get(TaggerService.class);
		Lang tsLang = LangUtil.getTermsuiteLang(corpus.getLanguage());
		
		TermSuitePipeline tsp = TermSuitePipeline.create(tsLang.getCode());

		LinguisticResourcesService resService = context.get(LinguisticResourcesService.class);
		
		
		if(resService.areCustomResourcesActivated())
			tsp.setResourceDir(resService.getCustomResourcesPath());
		
		tsp
			.setCollection(
					this.getCollectionType(corpus), 
					this.getCollectionPath(corpus), 
					"UTF-8");
		
		tsp.aeWordTokenizer();
		
		ETaggerConfig taggerConfig = taggerService.getTaggerConfig(pipeline);
		if(taggerConfig.getTaggerType() == ETagger.TREE_TAGGER) {
			tsp.setTreeTaggerHome(taggerConfig.getPath())
				.aeTreeTagger();
		} else if(taggerConfig.getTaggerType() == ETagger.MATE) {
			tsp.setMateModelPath(taggerConfig.getPath())
				.aeMateTaggerLemmatizer();
		}
		
		tsp.aeUrlFilter()
			.aeStemmer()
			.setSpotWithOccurrences(pipeline.isSpotWithOccurrences())
			.aeRegexSpotter()
			.aeSpecificityComputer();
			
		if(pipeline.isMorphosyntacticAnalysisEnabled()) {
			tsp.aeCompostSplitter();
		}

		if(pipeline.isSyntacticVariationEnabled()) {
			tsp.aeSyntacticVariantGatherer();
		}

		
		
		/*
		 * Placement of filtering is strategic:
		 *  - before graphical variant gathering that tend to be long for some languages
		 *  - before contextualizer
		 *  - before Scorer, which needs to remove some terms and make take some time if TermIndex is huge.
		 */
		if(pipeline.isFilteringEnabled()) {
			tsp.haeCasStatCounter("Before Filtering");
			
			TermProperty termProperty = TermProperty.forName(pipeline.getFilteringProperty());
			/*
			 * TODO Set as GUI param
			 */
			tsp.setKeepVariantsWhileCleaning(true); 
			switch(pipeline.getFilteringMode()) {
			case THRESHOLD: 
				tsp.aeThresholdCleaner(termProperty, (float)pipeline.getFilteringThreshold());
				break;
			case TOP_N: 
				tsp.aeTopNCleaner(termProperty, pipeline.getFilteringTopN());
			}
			
			tsp.haeCasStatCounter("After Filtering");

		}

		
		if(pipeline.isGraphicalVariationAnalysisEnabled()) {
			tsp.setGraphicalVariantSimilarityThreshold((float)pipeline.getGraphicalSimilarityThreshhold())
				.aeGraphicalVariantGatherer();
		}
		
		if(pipeline.isContextualizerEnabled()) {
			tsp.setContextualizeCoTermsType(pipeline.isContextAllowMWTAsCooc() ? OccurrenceType.ALL : OccurrenceType.SINGLE_WORD)
				/*
				 * TODO Set as GUI param
				 */
			  .setContextualizeWithCoOccurrenceFrequencyThreshhold(2)
			  .aeContextualizer(pipeline.getContextScope(), !pipeline.isContextualizeOnSWTOnly());
		}

		tsp.aeExtensionDetector()
			.aeScorer()
			.aeRanker(TermProperty.SPECIFICITY, true);

		
		
		if(pipeline.isBigCorporaHandlingEnabled()) {
			TermProperty termProperty = TermProperty.forName(pipeline.getBigCorporaFilteringProperty());
			switch(pipeline.getBigCorporaCleaningMode()) {
			case DOCUMENT_PERIOD: 
				tsp.aeThresholdCleanerPeriodic(
						termProperty, 
						(float)pipeline.getBigCorporaFilteringPropertyThreshold(), 
						pipeline.getBigCorporaDocumentPeriod());
				break;
			case MAX_NUMBER_OF_TERMS: 
				tsp.aeMaxSizeThresholdCleaner(termProperty, pipeline.getBigCorporaMaxNumberOfTerms());
			}
		}
		
		/* CAS export */
		if(pipeline.isExportCasToJsonEnabled())
			tsp.haeXmiCasExporter(getCasOutputDirectory(corpus, pipeline, CAS_JSON_DIR));
		if(pipeline.isExportCasToTsvEnabled())
			tsp.haeSpotterTSVWriter(getCasOutputDirectory(corpus, pipeline, CAS_TSV_DIR));
		if(pipeline.isExportCasToXmiEnabled())
			tsp.haeJsonExporter(getCasOutputDirectory(corpus, pipeline, CAS_XMI_DIR));

		/* termino export */
		if(pipeline.isExportTerminoToJsonEnabled()) {
			tsp.setExportJsonWithContext(true);
			tsp.setExportJsonWithOccurrences(true);
			tsp.haeJsonExporter(getTerminoOutputDirectory(corpus, pipeline, JSON_EXTENSION));
		}
		if(pipeline.isExportTerminoToTbxEnabled())
			tsp.haeTbxExporter(getTerminoOutputDirectory(corpus, pipeline, TBX_EXTENSION));
		if(pipeline.isExportTerminoToTsvEnabled())
			/*
			 * TODO Set as GUI params
			 */
			tsp.setTsvShowHeaders(true)
			   .setTsvShowScores(false)
			   .setTsvExportProperties(TermProperty.PATTERN, TermProperty.PILOT, TermProperty.FREQUENCY, TermProperty.WR_LOG)
			   .haeTsvExporter(getTerminoOutputDirectory(corpus, pipeline, TSV_EXTENSION));
		return tsp;
	}

	private void loadCorpora() {
		List<ECorpus> list = WorkspaceUtil.loadResources(CORPUS_DIR, CORPUS_EXTENSION, ECorpus.class);
		corpora.getCorpora().addAll(list);
	}

	
	@Override
	public void saveCorpus(ECorpus corpus) throws IOException {
		resetCache();
		WorkspaceUtil.saveResource(corpus, CORPUS_DIR, corpus.getName(), CORPUS_EXTENSION);
	}


	@Override
	public String getOutputDirectory(ESingleLanguageCorpus corpus) {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(TermSuiteUI.PLUGIN_ID);
		String rootOutputDir = preferences.get(
				TermSuiteUIPreferences.OUTPUT_DIRECTORY, 
				WorkspaceUtil.getWorkspacePath( "output").toString());
		Path path = Paths.get(
				rootOutputDir, 
				corpus.getCorpus().getName(), 
				corpus.getLanguage().getName());
		return path.toString();		
	}

	@Override
	public String getOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return Paths.get(getOutputDirectory(corpus), 
				pipeline.getTargetTerminologyName()).toString();
	}

	@Override
	public String getTerminoOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline, String extension) {
		Path path = Paths.get(getOutputDirectory(corpus, pipeline), pipeline.getTargetTerminologyName() + "." + extension);
		FileUtil.mkdirs(path.toFile());
		return path.toString();
	}
	
	@Override
	public String getCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline, String casDirname) {
		Path path = Paths.get(getOutputDirectory(corpus, pipeline), casDirname);
		FileUtil.mkdirs(path.toFile());
		return path.toString();		
	}



	@Override
	public String getTerminoJsonFile(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return getTerminoOutputDirectory(corpus, pipeline, JSON_EXTENSION);
	}



	@Override
	public String getTerminoTsvFile(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return getTerminoOutputDirectory(corpus, pipeline, TSV_EXTENSION);
	}



	@Override
	public String getTerminoTbxFile(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return getTerminoOutputDirectory(corpus, pipeline, TBX_EXTENSION);
	}



	@Override
	public String getXmiCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return getCasOutputDirectory(corpus, pipeline, CAS_XMI_DIR);
	}



	@Override
	public String getTsvCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return getCasOutputDirectory(corpus, pipeline, CAS_TSV_DIR);
	}



	@Override
	public String getJsonCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return getCasOutputDirectory(corpus, pipeline, CAS_JSON_DIR);
	}



	@Override
	public void removeCorpus(ECorpus s) {
		corpora.getCorpora().remove(s);
		WorkspaceUtil.removeResource(CORPUS_DIR, s.getName(), CORPUS_EXTENSION);
		resetCache();
		eventBroker.post(TermSuiteEvents.CORPUS_REMOVED, s);

	}



	private void resetCache() {
		documentCache = null;
	}

	private Map<URI, EDocument> getDocumentCache() {
		if (documentCache == null) {
			documentCache = Maps.newHashMap();
			for (ECorpus corpus : getCorporaList().getCorpora()) {
				for (ESingleLanguageCorpus slc : corpus.getSingleLanguageCorpora()) {
					for (EDocument d : slc.getDocuments()) {
						File file = asFile(d);
						documentCache.put(file.toURI(), d);
						documentCache.put(file.toURI(), d);
					}
				}
			}
		}
		return documentCache;
	}


	
	@Override
	public EDocument resolveEDocument(Document sourceDocument) {
		URI uri;
		try {
			uri = new URI(sourceDocument.getUrl());
			EDocument doc = getDocumentCache().get(uri);
			
			if(doc == null)
				this.logger.warn("Could not resolve document with url " + sourceDocument.getUrl());
			return doc;
		} catch (URISyntaxException e) {
			this.logger.error(e);			
			return null;
		}
		
	}


	LoadingCache<EDocument, String> documentContentStrings = CacheBuilder.newBuilder()
			.maximumSize(10)
			.build(new CacheLoader<EDocument, String>() {
				@Override
				public String load(EDocument doc) throws Exception {
					return FileUtil.toString(asFile(doc));
				}
			});


	LoadingCache<EDocument, List<Integer>> breakLineOffsets = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.build(new CacheLoader<EDocument, List<Integer>>() {
				@Override
				public List<Integer> load(EDocument doc) throws Exception {
					// return getLineVersion1(doc);
					List<Integer> lineBreaks = Lists.newArrayList();
					byte[] asText = Files.readAllBytes(Paths.get(asFile(doc).getAbsolutePath()));
					Matcher m = Pattern.compile("\\r*\\n").matcher(new String(asText));
					while (m.find())
						lineBreaks.add(m.start());
					return lineBreaks;
				}
			});
	
	@Override
	public int getLineNumber(EDocument doc, TermOccurrence occ) {
		int line = 1;
		try {
			for(int lineBreakOffset:breakLineOffsets.get(doc)) {
				if(lineBreakOffset > occ.getBegin())
					return line;
				else 
					line++;
			}
			return line;
		} catch (ExecutionException e) {
			e.printStackTrace();
			return 0;
		}
	}


	@Override
	public ESingleLanguageCorpus[] selectCorpus(Shell shell) {
		
		CorpusSelectionDialog dialog = new CorpusSelectionDialog(shell, getCorporaList().getCorpora());
		if(dialog.open() == org.eclipse.jface.window.Window.OK) {
			List<ESingleLanguageCorpus> selectedCorpus = Lists.newArrayList();
			for(Object o:dialog.getResult()) {
				if(o instanceof ESingleLanguageCorpus)
					selectedCorpus.add(((ESingleLanguageCorpus)o));
			}
			return selectedCorpus.toArray(new ESingleLanguageCorpus[selectedCorpus.size()]);
		} else
			return new ESingleLanguageCorpus[0];
		
	}


	@Override
	public String getDocumentExcerpt(EDocument document, int begin, int end) {
		String str = "Could not read excerpt from document " + document.getFilename();
		try {
			str = documentContentStrings.get(document);
		} catch (ExecutionException e) {
			str+= ". " + e.getCause().getMessage();
			
		}
		return str.substring(Ints.max(begin, 0), Ints.min(end, str.length()));
	}



	@Override
	public Collection<ETerminology> getTerminologies() {
		List<ETerminology> terminologies = Lists.newArrayList();
		for(ECorpus corpus:getCorporaList().getCorpora()) {
			for(ESingleLanguageCorpus slc:corpus.getSingleLanguageCorpora()) {
				terminologies.addAll(slc.getTerminologies());
			}
		}
		return terminologies;
	}

	@Override
	public boolean isLanguageSupported(ELang language) {
		return SUPPORTED_LANGUAGES.contains(language);
	}
}
