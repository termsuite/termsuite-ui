package fr.univnantes.termsuite.ui.handlers;

import java.io.IOException;

import javax.inject.Named;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.dialogs.NewPipelineDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.util.CommandUtil;

@SuppressWarnings("restriction")
public class NewPipelineHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.NewPipeline";

	@Execute
	public void execute(EPartService partService, 
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			EModelService modelService,
			PipelineService pipelineService,
			ResourceService resourceService,
			ECommandService commandService,
			EHandlerService handlerService,

			IEclipseContext context,
			MApplication mApplication) {
		
		NewPipelineDialog dialog = new NewPipelineDialog(shell, pipelineService);
		if(dialog.open() == Dialog.OK) {
			
			String filename = dialog.getFilename();
			EPipeline pipeline;
			try {
				pipeline = pipelineService.createPipeline(filename);
				ParameterizedCommand command = commandService.createCommand(
						OpenResourceHandler.COMMAND_ID, 
						CommandUtil.params(OpenResourceHandler.PARAM_INPUT_OBJECT_ID, resourceService.getResourceId(pipeline)));
				if(handlerService.canExecute(command))
					handlerService.executeHandler(command);

			} catch (IOException e) {
				MessageDialog.openError(shell, "Filename error", e.getMessage());
			}
		}
		
	}
	
}
