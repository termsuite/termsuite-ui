package fr.univnantes.termsuite.ui.handlers;

import javax.annotation.PostConstruct;
import javax.inject.Named;

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
import fr.univnantes.termsuite.ui.parts.PipelinePart2;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ExtractorService;
import fr.univnantes.termsuite.ui.services.TaggerService;

public class RunPipelineHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.RunPipeline";

	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_PART) MPart part, 
			ExtractorService extractorService,
			CorpusService corpusService) {
		EPipeline pipeline = (EPipeline) part.getContext().get(TermSuiteUI.INPUT_OBJECT);

		ESingleLanguageCorpus[] selectedCorpus = corpusService.selectCorpus(shell);
		extractorService.runPipelineOnSeveralCorpus(pipeline, Lists.newArrayList(selectedCorpus));

	}
	
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MPart part, 
			TaggerService taggerService, 
			ExtractorService extractorService) {
		
		EPipeline pipeline = (EPipeline) part.getContext().get(TermSuiteUI.INPUT_OBJECT);
		boolean a = pipeline != null && part.getObject() instanceof PipelinePart2;
		boolean b = extractorService.isPipelineValid(pipeline);
		boolean c = !taggerService.getTaggerConfigNames().isEmpty();
		return a && b && c;
	}	


}
