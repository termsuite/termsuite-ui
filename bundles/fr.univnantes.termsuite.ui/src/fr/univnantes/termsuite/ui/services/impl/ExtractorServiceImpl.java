package fr.univnantes.termsuite.ui.services.impl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.ICoreRunnable;
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
import fr.univnantes.termsuite.api.TerminoExtractor;
import fr.univnantes.termsuite.engines.contextualizer.MutualInformation;
import fr.univnantes.termsuite.framework.PipelineStats;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.model.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ExtractorService;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.services.PreprocessorService;
import fr.univnantes.termsuite.ui.services.TerminoService;

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
	private void runPipelineOnCorpus(final EPipeline pipeline, final Iterable<ESingleLanguageCorpus> corpusList) {

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
			}
		}
	}


	public void runPipelineOnPreprocessedCorpus(EPipeline pipeline, ESingleLanguageCorpus corpus, IndexedCorpus preparedCorpus) {
		String jobName = "Running pipeline " + pipeline.getFilename() + " on corpus " + preparedCorpus.getTerminology().getName() + "("+preparedCorpus.getTerminology().getLang()+")";
		final TerminoExtractor extractor = toExtractor(pipeline);

		Job job = Job.create(jobName, (ICoreRunnable) monitor -> {
			PipelineStats stats = extractor.execute(preparedCorpus);
		});
		// Set a better priority than preprocess
		job.setPriority(Job.LONG);
		job.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				TerminoService terminoService = context.get(TerminoService.class);
				CorpusService corpusService = context.get(CorpusService.class);
				ETerminology terminology = terminoService.createTerminology(
						corpus, 
						pipeline.getTargetTerminologyName(), 
						corpusService.getTerminoJsonFile(corpus, pipeline),
						pipeline.isSpotWithOccurrences(),
						pipeline.isContextualizerEnabled());
				try {
					context.get(CorpusService.class).saveCorpus(corpus.getCorpus());
					eventBroker.post(TermSuiteEvents.NEW_TERMINOLOGY, terminology);
				} catch(IOException e) {
					MessageDialog.openError(activeShell, "Error saving terminology", e.getMessage());
				}
			}
		});
		job.schedule();
		sync.asyncExec(new Runnable() {
			@Override
			public void run() {
				partService.showPart(TermSuiteUI.PROGRESS_VIEW_ID, PartState.VISIBLE);
			}
		});
	}



	private TerminoExtractor toExtractor(EPipeline pipeline) {
		return TermSuite.terminoExtractor()
			.setOptions(toExtractorOptions(pipeline))
			.setResourceConfig(resourceService.getResourceConfig());

	}

	private ExtractorOptions toExtractorOptions(EPipeline pipeline) {
		ExtractorOptions options = new ExtractorOptions();
		options.getMorphologicalConfig().setEnabled(pipeline.isMorphosyntacticAnalysisEnabled());
		options.getGathererConfig().setEnabled(pipeline.isSyntacticVariationEnabled());
		options.getPostFilterConfig().setEnabled(pipeline.isFilteringEnabled());
		options.getPostFilterConfig().setProperty(TermProperty.forName(pipeline.getFilteringProperty()));
		options.getPostFilterConfig().setKeepVariants(true);
		switch(pipeline.getFilteringMode()) {
		case THRESHOLD: 
			options.getPostFilterConfig().keepOverTh(pipeline.getFilteringThreshold());
			break;
		case TOP_N: 
			options.getPostFilterConfig().keepTopN(pipeline.getFilteringTopN());
		}

		options.getContextualizerOptions().setEnabled(pipeline.isContextualizerEnabled());
		options.getContextualizerOptions().setMinimumCooccFrequencyThreshold(2);
		options.getContextualizerOptions().setScope(pipeline.getContextScope());
		options.getContextualizerOptions().setAssociationRate(MutualInformation.class);

		return options;
	}

}
