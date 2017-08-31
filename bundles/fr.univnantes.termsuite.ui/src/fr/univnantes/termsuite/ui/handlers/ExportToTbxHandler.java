package fr.univnantes.termsuite.ui.handlers;

import fr.univnantes.termsuite.framework.TermSuiteFactory;
import fr.univnantes.termsuite.io.IndexedCorpusExporter;

public class ExportToTbxHandler extends ExportHandler {
	public static final String ID="fr.univnantes.termsuite.ui.handler.ExportToTBX";

	public ExportToTbxHandler() {
		super("TBX", false);
	}

	@Override
	protected IndexedCorpusExporter getExporter() {
		return TermSuiteFactory.createTbxExporter();
	}

}
