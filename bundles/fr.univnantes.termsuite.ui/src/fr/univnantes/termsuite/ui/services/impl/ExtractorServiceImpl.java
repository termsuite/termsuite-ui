package fr.univnantes.termsuite.ui.services.impl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import fr.univnantes.termsuite.api.ExtractorOptions;
import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.engines.cleaner.TerminoFilterOptions;
import fr.univnantes.termsuite.engines.contextualizer.AssociationRate;
import fr.univnantes.termsuite.engines.contextualizer.LogLikelihood;
import fr.univnantes.termsuite.engines.contextualizer.MutualInformation;
import fr.univnantes.termsuite.framework.PipelineStats;
import fr.univnantes.termsuite.metrics.Cosine;
import fr.univnantes.termsuite.metrics.Jaccard;
import fr.univnantes.termsuite.metrics.SimilarityDistance;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.model.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ExtractorService;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.services.PreprocessorService;
import fr.univnantes.termsuite.ui.services.TerminoService;
import fr.univnantes.termsuite.ui.util.Jobs;

public class ExtractorServiceImpl implements ExtractorService {
	
	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL) Shell activeShell;

	@Inject UISynchronize sync;

	
	@Inject EPartService partService;

	@Inject
	IEclipseContext context;
	
	@Inject
	IEventBroker eventBroker;

	@Inject
	LinguisticResourcesService resourceService;
	
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
	private void runPipelineOnCorpus(
			final EPipeline pipeline, 
			final Iterable<ESingleLanguageCorpus> corpusList) {

		for(final ESingleLanguageCorpus corpus:corpusList) {
			PreprocessorService preprocessorService = context.get(PreprocessorService.class);
			Optional<IndexedCorpus> cachedPreparedCorpus = preprocessorService.getCachedPreparedCorpus(corpus, pipeline.getTaggerConfigName());
			if(cachedPreparedCorpus.isPresent())
				runPipelineOnPreprocessedCorpus(pipeline, corpus, cachedPreparedCorpus.get());
			else {
				Job preprocessCorpusJob = preprocessorService.getPreparedCorpusJob(pipeline, corpus);
				eventBroker.subscribe(TermSuiteEvents.CORPUS_PREPROCESSED, new EventHandler() {
					@Override
					public void handleEvent(Event event) {
						IndexedCorpus indexedCorpus = (IndexedCorpus)event.getProperty(IEventBroker.DATA);
						runPipelineOnPreprocessedCorpus(pipeline, corpus, indexedCorpus);
					}
				});
				preprocessCorpusJob.schedule();
				eventBroker.post(TermSuiteEvents.JOB_STARTED, preprocessCorpusJob.getName());
			}
		}
	}



	public void runPipelineOnPreprocessedCorpus(EPipeline pipeline, ESingleLanguageCorpus corpus, IndexedCorpus preparedCorpus) {
		String jobName = "Extracting terminology with pipeline " + pipeline.getName() + " on corpus " + preparedCorpus.getTerminology().getName() + "("+preparedCorpus.getTerminology().getLang()+")";

		Job job = Job.create(jobName, (ICoreRunnable) monitor -> {
			int totalWork = 10000;
			SubMonitor subMonitor = SubMonitor.convert(monitor, totalWork);
			PipelineStats stats = TermSuite.terminoExtractor()
					.setOptions(toExtractorOptions(pipeline))
					.setListener(new WorkbenchPipelineListener(subMonitor, sync, totalWork))
					.setResourceConfig(resourceService.getResourceConfig())
					.execute(preparedCorpus);
		});
		job.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				TerminoService terminoService = context.get(TerminoService.class);
				CorpusService corpusService = context.get(CorpusService.class);
				ETerminology terminology = terminoService.createTerminology(
						corpus, 
						pipeline.getName(), 
						corpusService.getTerminoJsonFile(corpus, pipeline),
						pipeline.getOccurrenceMode(),
						pipeline.isContextualizerEnabled());
				try {
					context.get(CorpusService.class).saveCorpus(corpus.getCorpus());
					eventBroker.post(TermSuiteEvents.NEW_TERMINOLOGY, terminology);
				} catch(IOException e) {
					MessageDialog.openError(activeShell, "Error saving terminology", e.getMessage());
				}
			}
		});
		job.setPriority(Job.LONG);
		job.setRule(Jobs.MUTEX_RULE);
		job.schedule();
		eventBroker.post(TermSuiteEvents.JOB_STARTED, job.getName());

		// Set a better priority than preprocess
		sync.asyncExec(new Runnable() {
			@Override
			public void run() {
				partService.showPart(TermSuiteUI.PROGRESS_VIEW_ID, PartState.VISIBLE);
			}
		});
	}




	private ExtractorOptions toExtractorOptions(EPipeline pipeline) {
		ExtractorOptions options = new ExtractorOptions();
		if(pipeline.getFilter() != null) 
			options.setPostFilterConfig(toTerminoFilterOptions(pipeline.getFilter()));
		else
			options.getPostFilterConfig().setEnabled(false);
		

		options.getContextualizerOptions().setEnabled(pipeline.isContextualizerEnabled());
		options.getContextualizerOptions().setMinimumCooccFrequencyThreshold(2);
		options.getContextualizerOptions().setScope(pipeline.getContextScope());
		options.getContextualizerOptions().setAssociationRate(toAssocRate(pipeline.getContextAssocMeasure()));

		options.getGathererConfig().setSemanticEnabled(pipeline.isSemEnabled());
		options.getGathererConfig().setSemanticDicoOnly(pipeline.isSemDicoOnly());
		options.getGathererConfig().setSemanticSimilarityDistance(toSimilarityDistance(pipeline.getSemMeasure()));
		options.getGathererConfig().setSemanticNbCandidates(pipeline.getSemNumCandidates());

		return options;
	}

	public Class<? extends SimilarityDistance> toSimilarityDistance(ESimilarityMeasure measure) {
		switch(measure){
		case COSINE: return Cosine.class;
		case JACCARD: return Jaccard.class;
		}
		throw new IllegalStateException("Unkown similarity measure: " + measure);
		
	}


	public Class<? extends AssociationRate> toAssocRate(EAssocMeasure measure) {
		switch(measure){
		case LOG_LIKELYHOOD: return LogLikelihood.class;
		case MUTUAL_INFORMATION: return MutualInformation.class;
		}
		throw new IllegalStateException("Unkown association measure: " + measure);
		
	}
	public TerminoFilterOptions toTerminoFilterOptions(ETerminoFilter filter) {
		TerminoFilterOptions options = new TerminoFilterOptions();
		options.setProperty(TermProperty.forName(filter.getPropertyName()));
		options.setKeepVariants(filter.isKeepVariants());
		switch(filter.getMode()) {
		case THRESHOLD: 
			options.keepOverTh(filter.getThreshold());
			break;
		case TOP_N: 
			options.keepTopN(filter.getTopN());
		}
		options.setEnabled(true);
		return options;
	}



	@Override
	public String validatePipeline(EPipeline pipeline) {
		if(!pipeline.isContextualizerEnabled() && pipeline.isSemEnabled() && !pipeline.isSemDicoOnly())
				return "The contextualizer must be enabled when semantic variant detection is enabled.";
		if(pipeline.getTaggerConfigName() == null)
			return "A POS tagger must be selected.";			
		return null;
	}



	@Override
	public boolean isPipelineValid(EPipeline pipeline) {
		return validatePipeline(pipeline) == null;
	}

}
