package fr.univnantes.termsuite.ui.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.dialogs.CorpusSelectionDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.services.NLPService;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class RunPipelineHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.RunPipeline";

	@Execute
	public void execute(ParameterizedCommand command, 
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EPipeline selectedPipeline,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			NLPService extractorService,
			ResourceService resourceService) {
		Map<String, Object> parameterMap = command.getParameterMap();
		if(!parameterMap.containsKey(TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_PIPELINE_ID)
				&& selectedPipeline != null) {
			// run handler from selected pipeline
			runPipeline(shell, extractorService, resourceService, selectedPipeline);
		} else {
			// run handler from parameterized command
			String pipelineName = parameterMap.get(TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_PIPELINE_ID).toString();
			java.util.Optional<EPipeline> pipeline = resourceService.getPipeline(pipelineName);
			if(pipeline.isPresent()) 
				runPipeline(shell, extractorService, resourceService, pipeline.get());
		}
	}

	private void runPipeline(Shell shell, NLPService extractorService, ResourceService resourceService,
			EPipeline pipeline) {
		CorpusSelectionDialog dialog = new CorpusSelectionDialog(shell, resourceService.getCorporaList().getCorpora());
		List<ESingleLanguageCorpus> selectedCorpora = new ArrayList<>();
		if(dialog.open() == Window.OK) {
			for(Object o:dialog.getResult()) {
				if(o instanceof ESingleLanguageCorpus)
					selectedCorpora.add(((ESingleLanguageCorpus)o));
			}
		} 
		extractorService.runPipelineOnSeveralCorpus(pipeline, Lists.newArrayList(selectedCorpora));
	}
	
	@CanExecute
	public boolean canExecute(
			@Optional ParameterizedCommand command, 
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EPipeline selectedPipeline,
			ResourceService resourceService,
			NLPService extractorService) {
		if(command == null || command.getParameterMap().isEmpty()) {
			// try to run handler from selected EPipeline
			if(selectedPipeline != null)
				return extractorService.isPipelineValid(selectedPipeline);
			else 
				return false;
		} else {
			// try to run handler from parameterized command
			Map<String, Object> parameterMap = command.getParameterMap();
			Object pipelineName = parameterMap.get(TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_PIPELINE_ID);
			return pipelineName != null
						&& resourceService.getPipeline(pipelineName.toString()).isPresent()
						&& extractorService.isPipelineValid(resourceService.getPipeline(pipelineName.toString()).get())
						;
		}
	}	
}
