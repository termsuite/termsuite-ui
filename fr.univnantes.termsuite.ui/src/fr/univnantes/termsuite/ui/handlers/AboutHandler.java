package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.dialogs.AboutDialog;

public class AboutHandler {
	public static final String ID = "fr.univnantes.termsuite.ui.handler.About";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell parent) {
		new AboutDialog(parent).open();
	}

}
