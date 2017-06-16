package fr.univnantes.termsuite.ui.handlers;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.services.ExtractorService;

public class RunPipelineOnSelectedCorpusHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.RunPipelineOnSelectedCorpus";

	@Execute
	public void execute(IEclipseContext context, 
			final ExtractorService extractorService
			) {

		final EPipeline pipeline = context.get(EPipeline.class);
		final ESingleLanguageCorpus corpus = context.get(ESingleLanguageCorpus.class);
		
		extractorService.runPipelineOnCorpus(pipeline, corpus);
	}
}
