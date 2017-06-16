package fr.univnantes.termsuite.ui.services;

import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;

public interface ExtractorService {

	public void runPipelineOnCorpus(EPipeline pipeline, ESingleLanguageCorpus corpus);

	public void runPipelineOnSeveralCorpus(EPipeline pipeline, Iterable<ESingleLanguageCorpus> corpusList);

}
