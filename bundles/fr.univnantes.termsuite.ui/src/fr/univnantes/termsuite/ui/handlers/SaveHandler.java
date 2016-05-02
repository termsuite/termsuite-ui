package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SaveHandler {
	
	public static final String ID = "fr.univnantes.termsuite.ui.handler.Save";

	@Execute
	void execute(EPartService partService,@Named(IServiceConstants.ACTIVE_PART) MPart part) {
		partService.savePart(part, false);
	}
	
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_PART)
	                      	@Optional MPart part) {
	   if (part!=null && part.isDirty()) 
		   return true;
	   return false;
	}
}
