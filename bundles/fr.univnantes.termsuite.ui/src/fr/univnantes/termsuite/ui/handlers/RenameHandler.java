package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.dialogs.RenameDialog;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ExtractorService;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class RenameHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.Rename";

	@Execute
	public void execute(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EObject selectedObject,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			ResourceService resourceService,
			ExtractorService extractorService,
			PipelineService pipelineService,
			CorpusService corpusService) {
		RenameDialog dialog = new RenameDialog(shell, resourceService, selectedObject);
		if(dialog.open() == Window.OK) 
			resourceService.rename(selectedObject, dialog.getNewName());
	}
	
	@CanExecute
	public boolean canExecute(
			ResourceService resourceService,
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EObject selectedObject) {
		return selectedObject != null && (
				resourceService.isRenameable(selectedObject.getClass()));
	}
}
