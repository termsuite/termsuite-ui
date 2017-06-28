package fr.univnantes.termsuite.ui.services;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.index.TermIndex;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;

/**
 * 
 * A service API for handling TermSuite terminologies ({@link TermIndex} objects)
 * and their interaction with {@link TermSuiteUI}'s model and local drive.
 * 
 * 
 * @author Damien Cram
 * 
 * @see ETerminology
 * 
 */
public interface ETerminologyService {
	
	/**
	 * Gets the TermSuite {@link IndexedCorpus} associated to the
	 * <code>terminology</code> object, or loads it from local drive
	 * if not in memory.
	 * 
	 * @param terminology
	 * 			The terminology object
	 * 
	 * @return
	 */
	public IndexedCorpus readTerminology(ETerminology terminology);
	
	/**
	 * 
	 * 
	 * @param terminology
	 * @return
	 * @throws ExecutionException
	 */
	public IndexedCorpus getMetadata(ETerminology terminology) throws IOException;

	

	/**
	 * 
	 * Serialize a TermIndex into JSON and save it to disk.
	 * 
	 * @param terminology
	 * 			The terminology object holding the file path where to store the {@link TermIndex}.
	 * @param termIndex
	 * 			The {@link TermIndex} object to store.
	 * @param withOccurrences
	 * 			Set it to <code>true</code> if occurrences should be stored.
	 * @param withContexts
	 *  		Set it to <code>true</code> if context vectors should be stored.
	 * @throws IOException 
	 */
	public void saveTerminologyJson(ETerminology terminology, IndexedCorpus termIndex, boolean withOccurrences, boolean withContexts) throws IOException;
	
	/**
	 * Removes from file system the term index associated with the 
	 * terminology object.
	 * 
	 * @param terminology
	 * 			The terminology object
	 * @return
	 * 			<code>true</code> if removed properly, <code>false</code> otherwise.
	 */
	public boolean removeTerminologyJson(ETerminology terminology);

	public TerminologyStats getStats(ETerminology termino);

	public void invalidateCaches(ETerminology terminology);


}
