package fr.univnantes.termsuite.ui.handlers;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.framework.TermSuiteFactory;
import fr.univnantes.termsuite.io.IndexedCorpusExporter;
import fr.univnantes.termsuite.io.json.JsonOptions;
import fr.univnantes.termsuite.ui.dialogs.JSONOptionsDialog;

public class ExportToJsonHandler extends ExportHandler {
	public static final String ID="fr.univnantes.termsuite.ui.handler.ExportToJSON";
	
	public ExportToJsonHandler() {
		super("JSON", true);
	}

	@Override
	protected Dialog getDialog(Shell shell) {
		return new JSONOptionsDialog(shell);
	}
	
	@Override
	protected IndexedCorpusExporter getExporter(Dialog dialog) {
		JsonOptions jsonOptions = ((JSONOptionsDialog)dialog).getJsonOptions();
		return TermSuiteFactory.createJsonExporter(jsonOptions);
	}
}
