package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import eu.project.ttc.api.JsonOptions;
import eu.project.ttc.api.TermIndexIO;
import eu.project.ttc.models.TermIndex;
import eu.project.ttc.models.index.JsonTermIndexIO;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.TermIndexService;
import fr.univnantes.termsuite.ui.util.IOUtil;

public class TermIndexServiceImpl implements TermIndexService {


	private LoadingCache<ETerminology, TermIndex> terminoCache = CacheBuilder.newBuilder().maximumSize(1).recordStats()
			.build(new CacheLoader<ETerminology, TermIndex>() {
				public TermIndex load(ETerminology terminology) throws IOException {
					FileInputStream fis = new FileInputStream(terminology.getFilepath());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					TermIndex termino = JsonTermIndexIO.load(
							isr, 
							new JsonOptions());
					IOUtil.closeSilently(fis, isr);
					return termino;
				}
			});

	@Override
	public TermIndex getTermIndex(ETerminology terminology) throws ExecutionException {
		return terminoCache.get(terminology);
	}

	@Override
	public void saveTermIndex(ETerminology terminology, TermIndex termIndex, boolean withOccurrences, boolean withContexts) throws IOException {
		FileOutputStream fos = new FileOutputStream(terminology.getFilepath());
		Writer writer2 = new OutputStreamWriter(fos, "UTF-8");
		TermIndexIO.toJson(
				termIndex, 
				writer2, 
				new JsonOptions().withOccurrences(withOccurrences).withContexts(withContexts));
		writer2.flush();
		IOUtil.closeSilently(fos, writer2);
	}

	@Inject
	private IEclipseContext context;

	@Override
	public boolean removeTerminology(ETerminology terminology) {
		terminology.getCorpus().getTerminologies().remove(terminology);
		try {
			context.get(CorpusService.class).saveCorpus(terminology.getCorpus().getCorpus());
			terminoCache.invalidate(terminology);
			return new File(terminology.getFilepath()).delete();
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public TermIndex getTermIndexMetadata(ETerminology terminology) throws IOException {
		FileInputStream fis = new FileInputStream(terminology.getFilepath());
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		TermIndex termino = JsonTermIndexIO.load(
				isr, 
				new JsonOptions().metadataOnly(true));
		IOUtil.closeSilently(fis, isr);
		return termino;
	}

}
