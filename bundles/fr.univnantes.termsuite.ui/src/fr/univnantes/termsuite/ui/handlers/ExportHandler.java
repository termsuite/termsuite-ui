package fr.univnantes.termsuite.ui.handlers;

import java.io.IOException;
import java.nio.file.Paths;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.framework.service.TerminologyService;
import fr.univnantes.termsuite.io.IndexedCorpusExporter;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.parts.TerminologyPart;

public abstract class ExportHandler {

	
	private String formatName;
	private boolean withOptionDialog = false;

	public ExportHandler(String formatName, boolean withOptionDialog) {
		super();
		this.formatName = formatName;
		this.withOptionDialog = withOptionDialog;
	}

	@Execute
	public void execute(
			@Optional @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Optional TerminologyService terminologyService,
			@Optional ETerminology terminology,
			@Optional IndexedCorpus indexedCorpus
			) throws IOException {
		
		FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setText("Exporting terminology "+ TerminologyPart.toPartLabel(terminology) +" to " + formatName);
		String path = fileDialog.open();
		if(path != null) {
			if(withOptionDialog) {
				Dialog dialog = getDialog(shell);
				if(dialog.open() == Dialog.OK) 
					export(shell, terminology, getExporter(dialog), indexedCorpus, path);
			} else
				// no option dialog
				export(shell, terminology, getExporter(), indexedCorpus, path);
		}
	}

	private void export(Shell shell, ETerminology terminology, IndexedCorpusExporter exporter, IndexedCorpus indexedCorpus, String path) {
		try {
			exporter.export(indexedCorpus, Paths.get(path));
			MessageDialog.openInformation(shell, "Information", "The terminology "+TerminologyPart.toPartLabel(terminology)+" has been successfully exported to "+formatName+" file " + path + ".");
		} catch(Exception e) {
			MessageDialog.openError(shell, "Error during "+formatName+" export", e.getMessage());
		}
	}

	protected Dialog getDialog(Shell shell) {
		throw new IllegalStateException("Should not be invoked for exporter without option dialog");		
	}

	protected IndexedCorpusExporter getExporter() {
		throw new UnsupportedOperationException("Must be overriden for exporter without option dialog");
	}
	
	protected IndexedCorpusExporter getExporter(Dialog optionDialog){
		throw new UnsupportedOperationException("Must be overriden for exporter with option dialog");
	};

}
