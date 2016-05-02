package fr.univnantes.termsuite.ui.services;

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
			String filepath, boolean spotWithOccurrences, boolean contextualizerEnabled);

	public void removeTerminology(ETerminology s);

	/**
	 * Returns <code>true</code> if contexts have been computed 
	 * and stored in the JSON terminology.
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasContexts(ETerminology element);

	/**
	 * Returns <code>true</code> if occurrences have been
	 * stored in the JSON terminology.
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasOccurrences(ETerminology element);

}
