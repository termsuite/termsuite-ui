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

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.Shell;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import fr.univnantes.termsuite.api.TXTCorpus;
import fr.univnantes.termsuite.model.Document;
import fr.univnantes.termsuite.model.Lang;
import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.dialogs.CorpusSelectionDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
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
		Path path = Paths.get(getPath(slc).toString(), "txt");
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
			ESingleLanguageCorpus slc = TermsuiteuiFactory.eINSTANCE.createESingleLanguageCorpus();
			slc.setCorpus(corpus);
			slc.setLanguage(LangUtil.getLangByNameUC(sl.getName()));
			
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
	public String getTerminoOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline, String extension) {
		Path path = Paths.get(getOutputDirectory(corpus, pipeline), pipeline.getName() + "." + extension);
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

	@Override
	public TXTCorpus asTxtCorpus(ESingleLanguageCorpus corpus) {
		return new TXTCorpus(
				Lang.forName(corpus.getLanguage().getName().toLowerCase()), 
				getDocumentPath(corpus));
	}

}
