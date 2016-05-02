package fr.univnantes.termsuite.ui.handlers;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.parts.PipelinePart;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.TaggerService;

public class RunPipelineHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.RunPipeline";

	@PostConstruct
	void tata(IEclipseContext context) {
	}
	
	@CanExecute
	boolean isVisible(@Named(IServiceConstants.ACTIVE_PART) MPart part) {
		return part != null && part.getObject() instanceof PipelinePart;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_PART) MPart part, CorpusService corpusService) {
		EPipeline pipeline = (EPipeline) part.getContext().get(TermSuiteUI.INPUT_OBJECT);

		ESingleLanguageCorpus[] selectedCorpus = corpusService.selectCorpus(shell);
		corpusService.runPipelineOnSeveralCorpus(pipeline, Lists.newArrayList(selectedCorpus));

	}
	
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_PART) MPart part, CorpusService corpusService,
			TaggerService taggerService) {
		EPipeline pipeline = (EPipeline) part.getContext().get(TermSuiteUI.INPUT_OBJECT);
		boolean a = pipeline != null;
		boolean b = pipeline.getTaggerConfigName() != null;
		boolean c = !taggerService.getTaggerConfigNames().isEmpty();
		ETaggerConfig taggerConfig = taggerService.getTaggerConfig(pipeline.getTaggerConfigName());
		boolean d = taggerConfig != null;
		return a && b && c && d;
	}	


}
