package fr.univnantes.termsuite.ui.services;

import java.util.Collection;
import java.util.List;

import fr.univnantes.termsuite.alignment.TranslationCandidate;
import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;

public interface AlignmentService {

	
	/**
	 * Returns <code>true</code> if a bilingual dictionary
	 * for these two source and target languages has been loaded
	 * in TermSuite.
	 * 
	 * @param sourceLang
	 * @param targetLang
	 * @return
	 */
	public boolean canAlignWith(ELang sourceLang, ELang targetLang);
	
	/**
	 * Lists all the terminologies that can be used as the target 
	 * in alignment with a given source terminology.
	 * 
	 * @param element
	 * 			the source terminology
	 * @return
	 * 		the collection of all possible target {@link ETerminology}s 
	 *      for this source terminology.
	 */
	public Collection<ETerminology> canAlignWith(ETerminology element);

	
	/**
	 * Returns all available dictionaries.
	 * 
	 * @return
	 */
	public Collection<EBilingualDictionary> getDictionaries();

	/**
	 * Returns all bilingual dictionaries the source 
	 * language of which is given as a parameter.
	 * 
	 * @param sourceLanguage
	 * @return
	 */
	public Collection<EBilingualDictionary> getTargetDictionaries(ELang sourceLanguage);

	/**
	 * Returns all bilingual dictionaries the target 
	 * language of which is given as a parameter.
	 * 
	 * @param targetLanguage
	 * @return
	 */
	public Collection<EBilingualDictionary> getSourceDictionaries(ELang targetLanguage);

	
	/**
	 * Reads the input directory for bilingual dictionaries from 
	 * the {@link TermSuiteUIPreferences#BILINGUAL_DICTIONARY_DIRECTORY} preference
	 * value and reload all dictionaries from that directory.
	 * 
	 */
	public void reloadDictionaries();

	/**
	 * Returns the bilingual dictionary for the two languages
	 * if it exists.
	 * 
	 * @param source
	 * @param target
	 * @return
	 * 		The dico if exists, <code>null</code> otherwise
	 */
	public EBilingualDictionary getSynonymDictionary(ELang source, ELang target);

	
	/**
	 * 
	 * @param term
	 * @param sourceTerminology
	 * @param targetTerminology
	 * @return
	 */
	public List<TranslationCandidate> align(TermService term, ETerminology sourceTerminology, ETerminology targetTerminology);
}
