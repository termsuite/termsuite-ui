package fr.univnantes.termsuite.ui.services.impl;

import java.nio.file.Path;

import javax.inject.Inject;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;

import com.google.common.base.Optional;

import fr.univnantes.termsuite.api.IndexedCorpusIO;
import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.PreprocessorService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.Jobs;
import fr.univnantes.termsuite.ui.util.WorkspaceUtil;

public class PreprocessorServiceImpl implements PreprocessorService {


	public static final int MAX_SIZE = 500000;

	@Inject
	IEventBroker eventBroker;
	
	@Inject
	IEclipseContext context;
	
	@Inject
	UISynchronize sync;

	@Override
	public Job getPreparedCorpusJob(EPipeline pipeline, ESingleLanguageCorpus corpus) {
		String jobName = String.format("Preprocessing corpus %s - %s (%d documents)", 
				corpus.getCorpus().getName(), 
				corpus.getLanguage().getName(), 
				corpus.getDocuments().size());
		Job job = Job.create(jobName, monitor -> {
			final int totalWork = 1000;
			CorpusService corpusService = context.get(CorpusService.class);
			final SubMonitor subMonitor = SubMonitor.convert(monitor, totalWork);
			try {
				IndexedCorpus preparedCorpus = TermSuite.preprocessor()
					.setTagger(context.get(TaggerService.class).getTermSuiteTagger(pipeline))
					.setTaggerPath(context.get(TaggerService.class).getTaggerPath(pipeline))
					.setListener(new WorkbenchPipelineListener(subMonitor, sync, totalWork))
				 	.toIndexedCorpus(
						corpusService.asTxtCorpus(corpus), 
						PreprocessorServiceImpl.MAX_SIZE);
				eventBroker.post(TermSuiteEvents.CORPUS_PREPROCESSED, preparedCorpus);
				return Status.OK_STATUS;
			} catch(Exception e) {
				if(e.getCause() != null && e.getCause() instanceof OperationCanceledException)
					return Status.CANCEL_STATUS;
				else if(e.getCause() != null && e.getCause().getCause() != null && e.getCause().getCause() instanceof OperationCanceledException)
					return Status.CANCEL_STATUS;
				else
					return new Status(Status.ERROR, TermSuiteUI.PLUGIN_ID, e.getMessage(), e);
			} finally {
				subMonitor.done();
			}
		});
		job.setRule(Jobs.MUTEX_RULE);
		job.setPriority(Job.BUILD);
		return job;
	}

	@Override
	public Optional<IndexedCorpus> getCachedPreparedCorpus(ESingleLanguageCorpus corpus, String taggerConfigName) {
		if(getCachePath(corpus, taggerConfigName).toFile().isFile())
			return Optional.of(IndexedCorpusIO.fromJson(getCachePath(corpus, taggerConfigName)));
		else
			return Optional.absent();
	}
	
	@Override
	public Path getCachePath(ESingleLanguageCorpus corpus, String taggerConfigName) {
		Path dir = WorkspaceUtil.getWorkspacePath()
				.resolve(".termsuite-cache")
				;
		if(!dir.toFile().isDirectory())
			dir.toFile().mkdirs();
		return dir
				.resolve(corpus.getCorpus().getName() + "-" + corpus.getLanguage().getName() + "-" + taggerConfigName)
				;
	}
}
