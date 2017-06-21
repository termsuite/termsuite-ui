package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import fr.univnantes.termsuite.api.TXTCorpus;
import fr.univnantes.termsuite.api.TermSuiteException;
import fr.univnantes.termsuite.model.Document;
import fr.univnantes.termsuite.model.Lang;
import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.CorpusService;
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
	
	@Inject @Preference(nodePath=TermSuiteUIPreferences.NODE_GENERAL, value = TermSuiteUIPreferences.OUTPUT_DIRECTORY)
	protected String outputDirectory;
	
	private Logger logger;
	
	private Map<URI, EDocument> documentCache = null;
	
	private static final String JSON_EXTENSION = "json";


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
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#asFile(fr.univnantes.termsuite.ui.model.termsuiteui.EDocument)
	 */
	@Override
	public File asFile(EDocument d) {
		Path path = getSourcePath(d);
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
			ESingleLanguageCorpus slc = TermsuiteuiFactory.eINSTANCE.createESingleLanguageCorpus();
			slc.setCorpus(corpus);
			slc.setLanguage(LangUtil.getLangByNameUC(sl.getName()));
			corpus.getSingleLanguageCorpora().add(slc);
		}
		corpora.getCorpora().add(corpus);
		resetCache();
		try {
			saveCorpus(corpus);
		} catch (IOException e) {
			throw new TermSuiteException(e);
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
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getCollectionPath(fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus)
	 */
	@Override
	public String getCollectionPath(ESingleLanguageCorpus corpus) {
		return Paths.get(
				corpus.getCorpus().getPath(), 
				LangUtil.getTermsuiteLang(corpus.getLanguage()).getNameUC(),
				"txt"
				).toString();
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
	public ETerminology createTerminology(ESingleLanguageCorpus corpus, String terminologyName, EOccurrenceMode occMode, boolean hasContexts) {
		/*
		 * Ensure that any termino with the same name is removed. 
		 * (Override behaviour)
		 */
		
		for(Iterator<ETerminology> it = corpus.getTerminologies().iterator(); it.hasNext(); )
			if(it.next().getName().equals(terminologyName))
				it.remove();
		ETerminology terminology = TermsuiteuiFactory.eINSTANCE.createETerminology();
		terminology.setName(terminologyName);
		terminology.setHasOccurrences(occMode != EOccurrenceMode.DO_NOT_KEEP);
		terminology.setHasContexts(hasContexts);
		
		corpus.getTerminologies().add(terminology);
		
		return terminology;
	}
	
	
	@Override
	public void removeTerminology(ETerminology s) {
		ECorpus corpus = s.getCorpus().getCorpus();
		s.getCorpus().getTerminologies().remove(s);
		try {
			context.get(CorpusService.class).saveCorpus(corpus);
			getWorkspacePath(s).toFile().delete();
			eventBroker.post(TermSuiteEvents.TERMINOLOGY_REMOVED, s);
		} catch (IOException e) {
			MessageDialog.openError(parent, "Error", "Could not remove the terminology. Error: " + e.getMessage());
		}
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
				pipeline.getName()).toString();
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
					for (EDocument d : getDocuments(slc)) {
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
			throw new TermSuiteException(e);
		}
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

	@Override
	public TXTCorpus asTxtCorpus(ESingleLanguageCorpus corpus) {
		return new TXTCorpus(
				Lang.forName(corpus.getLanguage().getName().toLowerCase()), 
				getSourcePath(corpus));
	}

	private Path getOutputPath() {
		checkOutput();
		Path output = Paths.get(outputDirectory);
		output.toFile().mkdirs();
		return output;
	}
	@Override
	public Path getWorkspacePath(ECorpus corpus) {
		return createParents(getOutputPath().resolve(corpus.getName()));
	}

	private void checkOutput() {
		Preconditions.checkNotNull(outputDirectory, "Output path not defined");
		Preconditions.checkState(Paths.get(outputDirectory).toFile().exists(), "Output path does not exist: %s", outputDirectory);
		Preconditions.checkState(Paths.get(outputDirectory).toFile().isDirectory(), "Output path is not a valid directory: %s", outputDirectory);
	}

	@Override
	public Path getWorkspacePath(ESingleLanguageCorpus slc) {
		return createParents(getWorkspacePath(slc.getCorpus()).resolve(slc.getLanguage().toString()));
	}

	@Override
	public Path getWorkspacePath(ETerminology resource) {
		Path path = getWorkspacePath(resource.getCorpus()).resolve(resource.getName() + "." + JSON_EXTENSION);
		return createParents(path);
	}
	
	private Path createParents(Path path) {
		path.toFile().getParentFile().mkdirs();
		return path;
	}

	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getPath(fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus)
	 */
	@Override
	public Path getSourcePath(ESingleLanguageCorpus slc) {
		Lang termsuiteLang = LangUtil.getTermsuiteLang(slc.getLanguage());
		return getSourcePath(slc.getCorpus()).resolve(termsuiteLang.getNameUC());
	}
	
	@Override
	public Path getSourcePath(ECorpus corpus) {
		return Paths.get(corpus.getPath());
	}

	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getPath(fr.univnantes.termsuite.ui.model.termsuiteui.EDocument)
	 */
	@Override
	public Path getSourcePath(EDocument d) {
		return getSourceTxtPath(d.getSingleLanguageCorpus()).resolve(d.getFilename());
	}

	@Override
	public Path getSourceTxtPath(ESingleLanguageCorpus slc) {
		return getSourcePath(slc).resolve("txt");	
	}

	LoadingCache<ESingleLanguageCorpus, List<EDocument>> corpusCache = CacheBuilder.newBuilder()
			.build(new CacheLoader<ESingleLanguageCorpus, List<EDocument>>() {
				@Override
				public List<EDocument> load(ESingleLanguageCorpus slc) throws Exception {
					List<EDocument> documents = new ArrayList<>();
					for(File f:getSourceTxtPath(slc).toFile().listFiles()) {
						EDocument doc = TermsuiteuiFactory.eINSTANCE.createEDocument();
						doc.setFilename(f.getName());
						doc.setSingleLanguageCorpus(slc);
						documents.add(doc);
					}
					return documents;
				}
			});
	
	@Override
	public List<EDocument> getDocuments(ESingleLanguageCorpus slc) {
		return corpusCache.getUnchecked(slc);
	}

	@Override
	public List<ETerminology> getTerminologies(ESingleLanguageCorpus slc) {
		List<ETerminology> terminologies = new ArrayList<>();
		for(File f:getWorkspacePath(slc).toFile().listFiles(f -> f.getName().endsWith("."+JSON_EXTENSION))) {
			ETerminology termino = WorkspaceUtil.loadResource(f.getPath(), ETerminology.class);
			terminologies.add(termino);	
		}
		return terminologies;
	}
}
