package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import eu.project.ttc.models.TermIndex;
import eu.project.ttc.models.index.JSONTermIndexIO;
import eu.project.ttc.models.index.io.LoadOptions;
import eu.project.ttc.models.index.io.SaveOptions;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.TermIndexService;

public class TermIndexServiceImpl implements TermIndexService {


	private LoadingCache<ETerminology, TermIndex> terminoCache = CacheBuilder.newBuilder().maximumSize(1).recordStats()
			.build(new CacheLoader<ETerminology, TermIndex>() {
				public TermIndex load(ETerminology terminology) throws IOException {
					return JSONTermIndexIO.load(new FileReader(terminology.getFilepath()), new LoadOptions());
				}
			});

	@Override
	public TermIndex getTermIndex(ETerminology terminology) throws ExecutionException {
		return terminoCache.get(terminology);
	}

	@Override
	public void saveTermIndex(ETerminology terminology, TermIndex termIndex, boolean withOccurrences, boolean withContexts) throws IOException {
		JSONTermIndexIO.save(new FileWriter(terminology.getFilepath()), 
				termIndex, 
				new SaveOptions().withOccurrences(withOccurrences).withContexts(withContexts));
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
		return JSONTermIndexIO.load(
				new FileReader(terminology.getFilepath()),
				new LoadOptions().metadataOnly(true));
	}

}
