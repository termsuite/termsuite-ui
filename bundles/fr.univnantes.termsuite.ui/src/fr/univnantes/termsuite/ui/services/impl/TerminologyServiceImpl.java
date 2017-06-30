package fr.univnantes.termsuite.ui.services.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.framework.service.TerminologyService;
import fr.univnantes.termsuite.io.json.JsonOptions;
import fr.univnantes.termsuite.io.json.JsonTerminologyIO;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.ETerminologyService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.util.IOUtil;

public class TerminologyServiceImpl implements ETerminologyService {

	@Inject
	private IEclipseContext context;
	

	private LoadingCache<ETerminology, TerminologyService> terminoServiceCache = CacheBuilder
			.newBuilder()
			.maximumSize(1)
			.recordStats()
			.build(new CacheLoader<ETerminology, TerminologyService>() {
				public TerminologyService load(ETerminology terminology) throws IOException {
					return TermSuite.getTerminologyService(terminoCache.getUnchecked(terminology));
				}
			});
	
	private LoadingCache<ETerminology, IndexedCorpus> terminoCache = CacheBuilder
			.newBuilder()
			.maximumSize(1)
			.recordStats()
			.build(new CacheLoader<ETerminology, IndexedCorpus>() {
				public IndexedCorpus load(ETerminology terminology) throws IOException {
					FileInputStream fis = new FileInputStream(getPath(terminology).toFile());
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					IndexedCorpus termino = JsonTerminologyIO.load(
							isr, 
							new JsonOptions());
					IOUtil.closeSilently(fis, isr);
					return termino;
				}
			});

	@Override
	public IndexedCorpus readTerminology(ETerminology terminology) {
		return terminoCache.getUnchecked(terminology);
	}

	@Override
	public void saveTerminologyJson(ETerminology terminology, IndexedCorpus termIndex, boolean withOccurrences, boolean withContexts) throws IOException {
		FileOutputStream fos;
		fos = new FileOutputStream(getPath(terminology).toFile());
		Writer writer2 = new OutputStreamWriter(fos, "UTF-8");
		JsonTerminologyIO.save(
				writer2, 
				termIndex, 
				new JsonOptions().withOccurrences(withOccurrences).withContexts(withContexts));
		IOUtil.closeSilently(fos, writer2);
	}

	private Path getPath(ETerminology terminology) {
		return context.get(ResourceService.class).getWorkspacePath(terminology);
	}


	@Override
	public boolean removeTerminologyJson(ETerminology terminology) {
		terminology.getCorpus().getTerminologies().remove(terminology);
		context.get(ResourceService.class).saveCorpus(terminology.getCorpus().getCorpus());
		terminoCache.invalidate(terminology);
		return getPath(terminology).toFile().delete();
	}

	@Override
	public IndexedCorpus getMetadata(ETerminology terminology) throws IOException {
		FileInputStream fis = new FileInputStream(getPath(terminology).toFile());
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		IndexedCorpus termino = JsonTerminologyIO.load(
				isr, 
				new JsonOptions().metadataOnly(true));
		IOUtil.closeSilently(fis, isr);
		return termino;
	}

	/*
	 * A five sec cache for ensuring that multiple notifications 
	 * of active terminology change do not recompute multiple times the stats for nothing.
	 */
	private LoadingCache<ETerminology, TerminologyStats> statCache = CacheBuilder.newBuilder()
			.expireAfterWrite(5, TimeUnit.SECONDS)
			.concurrencyLevel(1)
			.build(new CacheLoader<ETerminology, TerminologyStats>() {
				@Override
				public TerminologyStats load(ETerminology terminology) throws Exception {
					TerminologyService terminologyService = getTerminologyService(terminology);
					TerminologyStats stats = terminologyService.computeStats();
					return stats;
				}
			});

	@Override
	public TerminologyStats getStats(ETerminology termino) {
		return statCache.getUnchecked(termino);
	}

	@Override
	public void invalidateCaches(ETerminology terminology) {
		terminoCache.invalidate(terminology);
		terminoServiceCache.invalidate(terminology);
		statCache.invalidate(terminology);
	}

	@Override
	public TerminologyService getTerminologyService(ETerminology terminology) {
		return terminoServiceCache.getUnchecked(terminology);
	}
}
