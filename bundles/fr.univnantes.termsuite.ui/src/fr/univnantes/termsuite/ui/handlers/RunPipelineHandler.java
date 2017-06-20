package fr.univnantes.termsuite.ui.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.dialogs.CorpusSelectionDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ExtractorService;
import fr.univnantes.termsuite.ui.services.PipelineService;

public class RunPipelineHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.RunPipeline";

	@Execute
	public void execute(ParameterizedCommand command, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			ExtractorService extractorService,
			PipelineService pipelineService,
			CorpusService corpusService) {
		Map<String, Object> parameterMap = command.getParameterMap();
		if(!parameterMap.containsKey(TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_PIPELINE_ID))
			return;
		else {
			String pipelineName = parameterMap.get(TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_PIPELINE_ID).toString();
			Optional<EPipeline> pipeline = pipelineService.getPipeline(pipelineName);
			if(pipeline.isPresent()) {
				CorpusSelectionDialog dialog = new CorpusSelectionDialog(shell, corpusService.getCorporaList().getCorpora());
				List<ESingleLanguageCorpus> selectedCorpora = new ArrayList<>();
				if(dialog.open() == Window.OK) {
					for(Object o:dialog.getResult()) {
						if(o instanceof ESingleLanguageCorpus)
							selectedCorpora.add(((ESingleLanguageCorpus)o));
					}
				} 
				extractorService.runPipelineOnSeveralCorpus(pipeline.get(), Lists.newArrayList(selectedCorpora));
			}
		}
	}
	
	@CanExecute
	public boolean canExecute(ParameterizedCommand command, PipelineService pipelineService) {
		Map<String, Object> parameterMap = command.getParameterMap();
		Object pipelineName = parameterMap.get(TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_PIPELINE_ID);
		return pipelineName != null
					&& pipelineService.getPipeline(pipelineName.toString()).isPresent();
	}	
}
