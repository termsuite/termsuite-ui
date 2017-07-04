package fr.univnantes.termsuite.ui.handlers;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.dialogs.ImportCorpusDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class ImportCorpusHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.ImportCorpus";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell parentShell, 
			IEclipseContext context, 
			ResourceService resourceService,
			CorpusService corpusService) {
		Set<String> existingNames = resourceService.getCorporaList().getCorpora().stream().map(ECorpus::getName).collect(Collectors.toSet());
		ImportCorpusDialog dialog = new ImportCorpusDialog(parentShell, existingNames, corpusService);
		if(dialog.open() == Dialog.OK)
			corpusService.createCorpus(
					dialog.getCorpus().getName(), 
					dialog.getCorpus().getPath(),
					dialog.getCorpus().getEncoding()
				);
	}
}
