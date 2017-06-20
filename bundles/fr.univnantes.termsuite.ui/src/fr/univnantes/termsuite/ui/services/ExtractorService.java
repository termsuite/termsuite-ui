package fr.univnantes.termsuite.ui.services;

import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;

public interface ExtractorService {

	public void runPipelineOnCorpus(EPipeline pipeline, ESingleLanguageCorpus corpus);

	public void runPipelineOnSeveralCorpus(EPipeline pipeline, Iterable<ESingleLanguageCorpus> corpusList);

	/**
	 * 
	 * Tells if the pipeline object is ready for run or not.
	 * 
	 * @param pipeline
	 * @return
	 * 		<code>null</code> if the pipeline is valide, the error msg otherwise
	 */
	public String validatePipeline(EPipeline pipeline);

	public boolean isPipelineValid(EPipeline pipeline);

}
