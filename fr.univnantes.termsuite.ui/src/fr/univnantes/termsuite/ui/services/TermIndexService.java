package fr.univnantes.termsuite.ui.services;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import eu.project.ttc.models.TermIndex;
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
public interface TermIndexService {
	
	/**
	 * Gets the TermSuite {@link TermIndex} associated to the
	 * <code>terminology</code> object, or loads it from local drive
	 * if not in memory.
	 * 
	 * @param terminology
	 * 			The terminology object
	 * 
	 * @return
	 * @throws ExecutionException 
	 * 				if an {@link IOException} occurs while loading the {@link TermIndex} from file.
	 */
	public TermIndex getTermIndex(ETerminology terminology) throws ExecutionException;
	
	/**
	 * 
	 * 
	 * @param terminology
	 * @return
	 * @throws ExecutionException
	 */
	public TermIndex getTermIndexMetadata(ETerminology terminology) throws IOException;

	

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
	public void saveTermIndex(ETerminology terminology, TermIndex termIndex, boolean withOccurrences, boolean withContexts) throws IOException;
	
	/**
	 * Removes from file system the term index associated with the 
	 * terminology object.
	 * 
	 * @param terminology
	 * 			The terminology object
	 * @return
	 * 			<code>true</code> if removed properly, <code>false</code> otherwise.
	 */
	public boolean removeTerminology(ETerminology terminology);


}
