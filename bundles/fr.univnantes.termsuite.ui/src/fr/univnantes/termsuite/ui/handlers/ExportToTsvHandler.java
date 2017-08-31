package fr.univnantes.termsuite.ui.handlers;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.framework.TermSuiteFactory;
import fr.univnantes.termsuite.io.IndexedCorpusExporter;
import fr.univnantes.termsuite.ui.dialogs.TSVOptionsDialog;

public class ExportToTsvHandler extends ExportHandler {
	public static final String ID="fr.univnantes.termsuite.ui.handler.ExportToTSV";
	
	public ExportToTsvHandler() {
		super("TSV", true);
	}

	@Override
	protected Dialog getDialog(Shell shell) {
		return new TSVOptionsDialog(shell);
	}
	
	@Override
	protected IndexedCorpusExporter getExporter(Dialog dialog) {
		return TermSuiteFactory.createTsvExporter(((TSVOptionsDialog)dialog).getTsvOptions());
	}
}
