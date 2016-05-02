package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.services.TaggerService;

public class NewTaggerConfigHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.NewTaggerConfig";

	@Execute
	public void execute(TaggerService taggerService, 
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
	}
}
