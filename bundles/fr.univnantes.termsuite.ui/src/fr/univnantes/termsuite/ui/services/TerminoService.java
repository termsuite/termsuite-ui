package fr.univnantes.termsuite.ui.services;

import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;

public interface TerminoService {
	
	/**
	 * Adds a terminology to the single language corpus, or 
	 * overrides it if it exists.
	 * 
	 * @param corpus
	 * @param terminologyName
	 * @param filepath
	 * @param spotWithOccurrences
	 * @param contextualizerEnabled
	 * @return
	 */
	public ETerminology createTerminology(ESingleLanguageCorpus corpus, String terminologyName,
			String filepath, EOccurrenceMode occMode, boolean contextualizerEnabled);

	public void removeTerminology(ETerminology s);
}
