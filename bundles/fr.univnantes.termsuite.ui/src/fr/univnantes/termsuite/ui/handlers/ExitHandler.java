package fr.univnantes.termsuite.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitHandler {
	public static final String ID = "fr.univnantes.termsuite.ui.handler.Exit";
	
	@Execute
	public void execute(IWorkbench workbench) {
		workbench.close();
	}
}
