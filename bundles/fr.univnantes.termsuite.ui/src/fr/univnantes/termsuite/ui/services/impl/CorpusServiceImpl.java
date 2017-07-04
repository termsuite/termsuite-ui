package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import fr.univnantes.termsuite.api.TXTCorpus;
import fr.univnantes.termsuite.api.TermSuiteException;
import fr.univnantes.termsuite.model.Document;
import fr.univnantes.termsuite.model.Lang;
import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.NLPService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.util.FileUtil;
import fr.univnantes.termsuite.ui.util.LangUtil;


@Singleton
@SuppressWarnings("restriction")
public class CorpusServiceImpl implements CorpusService {

	@Inject 
	private IEclipseContext context;
	
	private Map<Path, ESingleLanguageCorpus> singleLanguageCorpora;

	private LoadingCache<EDocument, String> documentContentStrings = CacheBuilder.newBuilder()
			.maximumSize(10)
			.build(new CacheLoader<EDocument, String>() {
				@Override
				public String load(EDocument doc) throws Exception {
					return FileUtil.toString(asFile(doc));
				}
			});


	private LoadingCache<EDocument, List<Integer>> breakLineOffsets = CacheBuilder.newBuilder()
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
	
	private LoadingCache<ESingleLanguageCorpus, Map<String, EDocument>> sldDocuments = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.build(new CacheLoader<ESingleLanguageCorpus, Map<String, EDocument>>() {
				@Override
				public Map<String, EDocument> load(ESingleLanguageCorpus slc) throws Exception {
					Map<String, EDocument> documents = new HashMap<>();
					for(File f:getSourcePath(slc).toFile().listFiles()) {
						EDocument doc = TermsuiteuiFactory.eINSTANCE.createEDocument();
						doc.setFilename(f.getName());
						doc.setSingleLanguageCorpus(slc);
						documents.put(f.getAbsolutePath(), doc);
					}
					return documents;
				}
			});
	
	
	private Logger logger;
	
	
	@PostConstruct
	public void init(ILoggerProvider loggerProvider, ResourceService resourceService) {
		this.logger = loggerProvider.getClassLogger(this.getClass());
		this.logger.debug("Initalizing service " + this.getClass());
		singleLanguageCorpora = new HashMap<>();
		for(ECorpus corpus:resourceService.getCorporaList().getCorpora())
			cacheSlc(corpus);
	}


	private void cacheSlc(ECorpus corpus) {
		for(ESingleLanguageCorpus slc:corpus.getSingleLanguageCorpora())
			singleLanguageCorpora.put(getSourcePath(slc).toAbsolutePath(), slc);
	}
	
	
	@Override
	public File asFile(EDocument d) {
		Path path = getSourcePath(d);
		return path.toFile();
	}


	@Override
	public File[] candidateSLCChildrenForPath(String path) {
		return new File(path).listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File child) {
					if(!child.isDirectory())
						return false;
					for(ELang l:NLPService.SUPPORTED_LANGUAGES) {
						if(LangUtil.getTermsuiteLang(l).getNameUC().equals(child.getName())) 
							return true;
					}
					return false;
				}
			});
	}

	
	@Override
	public EDocument resolveEDocument(Document sourceDocument) {
		Path filePath = Paths.get(sourceDocument.getUrl()).toAbsolutePath();
		Path parent;
		do {
			parent = filePath.getParent();
		} while(!singleLanguageCorpora.containsKey(parent) && parent != null);
		if(parent == null)
			throw new IllegalStateException("Could not find the corpus that document " + sourceDocument.getUrl() + " belongs to");
		else {
			ESingleLanguageCorpus slc = singleLanguageCorpora.get(parent);
			Map<String, EDocument> documents = sldDocuments.getUnchecked(slc);
			if(documents.containsKey(sourceDocument.getUrl()))
				return documents.get(sourceDocument.getUrl());
			else 
				throw new IllegalStateException("Found no document with url " + sourceDocument.getUrl() + " in slc corpus " + parent.toString());
		}
	}


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
	public TXTCorpus asTxtCorpus(ESingleLanguageCorpus corpus) {
		TXTCorpus txtCorpus = new TXTCorpus(
				Lang.forName(corpus.getLanguage().getName().toLowerCase()), 
				getSourcePath(corpus));
		txtCorpus.setEncoding(Charset.forName(corpus.getCorpus().getEncoding()));
		return txtCorpus;
	}

	@Override
	public Path getSourcePath(ESingleLanguageCorpus slc) {
		Lang termsuiteLang = LangUtil.getTermsuiteLang(slc.getLanguage());
		return getSourcePath(slc.getCorpus()).resolve(termsuiteLang.getNameUC()).resolve("txt");
	}
	
	@Override
	public Path getSourcePath(ECorpus corpus) {
		return Paths.get(corpus.getPath());
	}

	
	@Override
	public Path getSourcePath(EDocument d) {
		return getSourcePath(d.getSingleLanguageCorpus()).resolve(d.getFilename());
	}

	
	@Override
	public Collection<EDocument> getDocuments(ESingleLanguageCorpus slc) {
		return sldDocuments.getUnchecked(slc).values();
	}
	
	@Override
	public ECorpus createCorpus(String name, String corpusPath, String encoding) {
		ECorpus corpus = TermsuiteuiFactory.eINSTANCE.createECorpus();
		corpus.setName(name);
		corpus.setEncoding(encoding);
		corpus.setPath(Paths.get(corpusPath).toString());
		for(File sl:candidateSLCChildrenForPath(corpus.getPath())) {
			ESingleLanguageCorpus slc = TermsuiteuiFactory.eINSTANCE.createESingleLanguageCorpus();
			slc.setCorpus(corpus);
			slc.setLanguage(LangUtil.getLangByNameUC(sl.getName()));
			corpus.getSingleLanguageCorpora().add(slc);
		}
		context.get(ResourceService.class).getCorporaList().getCorpora().add(corpus);
		context.get(ResourceService.class).saveCorpus(corpus);
		cacheSlc(corpus);
		return corpus;
	}
}
