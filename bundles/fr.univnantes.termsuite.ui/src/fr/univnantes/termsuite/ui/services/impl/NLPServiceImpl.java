package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.api.ExtractorOptions;
import fr.univnantes.termsuite.api.IndexedCorpusIO;
import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.engines.cleaner.TerminoFilterOptions;
import fr.univnantes.termsuite.engines.contextualizer.AssociationRate;
import fr.univnantes.termsuite.engines.contextualizer.LogLikelihood;
import fr.univnantes.termsuite.engines.contextualizer.MutualInformation;
import fr.univnantes.termsuite.metrics.Cosine;
import fr.univnantes.termsuite.metrics.Jaccard;
import fr.univnantes.termsuite.metrics.SimilarityDistance;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.model.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.services.NLPService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.Jobs;
import fr.univnantes.termsuite.ui.util.LangUtil;

public class NLPServiceImpl implements NLPService {

	@Inject
	private IEclipseContext context;
	
	@Inject
	private UISynchronize sync;

	@Inject
	private IEventBroker eventBroker;

	@Inject
	private LinguisticResourcesService resourceService;
	

	@Override
	public boolean isLanguageSupported(ELang language) {
		return SUPPORTED_LANGUAGES.contains(language);
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
	private void runPipelineOnCorpus(
			final EPipeline pipeline, 
			final Iterable<ESingleLanguageCorpus> corpusList) {

		for(final ESingleLanguageCorpus corpus:corpusList) {
			Path preprocessedCorpusPath = getCachePath(corpus, pipeline.getTaggerConfigName(), pipeline.getMaxNumTermsMemory());

			if(preprocessedCorpusPath.toFile().isFile())
				runPipelineOnPreprocessedCorpus(pipeline, corpus, IndexedCorpusIO.fromJson(preprocessedCorpusPath));
			else {
				Job preprocessCorpusJob = getPrepareCorpusJob(pipeline, corpus);
				preprocessCorpusJob.addJobChangeListener(new JobChangeAdapter(){
					@Override
					public void done(IJobChangeEvent event) {
						if(event.getResult().isOK()) {
							runPipelineOnPreprocessedCorpus(
									pipeline, 
									corpus, 
									IndexedCorpusIO.fromJson(preprocessedCorpusPath));
						}
			            event.getJob().removeJobChangeListener(this);
					}
				});
				preprocessCorpusJob.schedule();
				eventBroker.post(TermSuiteEvents.JOB_STARTED, preprocessCorpusJob.getName());
			}
		}
	}

	public void runPipelineOnPreprocessedCorpus(EPipeline pipeline, ESingleLanguageCorpus corpus, IndexedCorpus preparedCorpus) {
		String jobName = "Extracting terminology with pipeline " + pipeline.getName() + " on corpus " + corpus.getCorpus().getName() + " - "+preparedCorpus.getTerminology().getLang().getNameUC()+"";

		Job job = Job.create(jobName, (ICoreRunnable) monitor -> {
			int totalWork = 10000;
			SubMonitor subMonitor = SubMonitor.convert(monitor, totalWork);
			TermSuite.terminoExtractor()
					.setOptions(toExtractorOptions(pipeline, corpus.getLanguage()))
					.setListener(new WorkbenchPipelineListener(subMonitor, sync, totalWork))
					.setResourceConfig(resourceService.getResourceConfig())
					.execute(preparedCorpus);
		});
		job.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				ResourceService resourceService = context.get(ResourceService.class);
				ETerminology terminology = resourceService.createTerminology(
						corpus, 
						pipeline.getName(), 
						pipeline.getOccurrenceMode(),
						pipeline.isContextualizerEnabled());
				try {
					resourceService.saveCorpus(corpus.getCorpus());
					Path terminoPath = resourceService.getWorkspacePath(terminology);
					try(FileWriter fileWriter = new FileWriter(terminoPath.toFile())) {
						IndexedCorpusIO.toJson(preparedCorpus, fileWriter);
					}
					eventBroker.post(TermSuiteEvents.NEW_TERMINOLOGY, terminology);
				} catch(IOException e) {
					context.get(ILoggerProvider.class).getClassLogger(this.getClass()).error(e, "Could not save corpus after terminology creation: " + e.getMessage());
				} finally {
		            event.getJob().removeJobChangeListener(this);
				}
			}
		});
		job.setPriority(Job.LONG);
		job.setRule(Jobs.MUTEX_RULE);
		job.schedule();
		eventBroker.post(TermSuiteEvents.JOB_STARTED, job.getName());

		// Set a better priority than preprocess
		sync.asyncExec(()->context.get(EPartService.class).showPart(TermSuiteUI.PROGRESS_VIEW_ID, PartState.VISIBLE));
	}




	private ExtractorOptions toExtractorOptions(EPipeline pipeline, ELang lang) {
		ExtractorOptions options = TermSuite.getDefaultExtractorConfig(LangUtil.getTermsuiteLang(lang));
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
	
	
	@Override
	public Job getPrepareCorpusJob(EPipeline pipeline, ESingleLanguageCorpus corpus) {
		String jobName = String.format("Preprocessing corpus %s - %s (%d documents)", 
				corpus.getCorpus().getName(), 
				corpus.getLanguage().getName(), 
				context.get(CorpusService.class).getDocuments(corpus).size());
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
						MAX_SIZE);
				
				// save preprocessed corpus to cache
				Path cachePath = getCachePath(corpus, pipeline.getTaggerConfigName(), pipeline.getMaxNumTermsMemory());
				IndexedCorpusIO.toJson(preparedCorpus, new FileWriter(cachePath.toFile()));
				
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

	public static final String PREPROCESS_CACHE_DIR_NAME = "nlp-cache";
	
	@Override
	public Path getCachePath(ESingleLanguageCorpus corpus, String taggerConfigName, int maxSize) {
		Path dir = getNlpCachePath();
		return dir.resolve(String.format("%s-%s-%s-%d.json", 
				corpus.getCorpus().getName(),
				corpus.getLanguage(),
				taggerConfigName,
				maxSize
				))
		;
	}
	
	@Override
	public Path getNlpCachePath() {
		ResourceService resourceService = context.get(ResourceService.class);
		Path dir = resourceService
				.getOutputDirectory()
				.resolve(PREPROCESS_CACHE_DIR_NAME);
		dir.toFile().mkdirs();
		return dir;
	}


	@Override
	public boolean clearNlpCache() {
		boolean delete = true;
		for(File f:getNlpCachePath().toFile().listFiles()) 
			delete = delete && f.delete();
		eventBroker.post(TermSuiteEvents.CACHE_CLEARED, null);
		return delete;
	}

}
