package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.wizards.ImportCorpusWizard;

public class ImportCorpusHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.ImportCorpus";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell parentShell, IEclipseContext context, CorpusService corpusService) {
		ImportCorpusWizard wizard = ContextInjectionFactory.make(ImportCorpusWizard.class, context);
		if(new WizardDialog(parentShell, wizard).open() == Window.OK)
			corpusService.createCorpus(wizard.getCorpusName(), wizard.getCorpusPath());
	}
}
