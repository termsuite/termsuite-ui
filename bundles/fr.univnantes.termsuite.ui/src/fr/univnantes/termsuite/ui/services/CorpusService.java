package fr.univnantes.termsuite.ui.services;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;

import fr.univnantes.termsuite.api.TXTCorpus;
import fr.univnantes.termsuite.model.Document;
import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;

public interface CorpusService {

	public File asFile(EDocument d);

	public ECorpus createCorpus(String name, String corpusPath, String encoding);


	/**
	 * Return the workspace {@link EDocument} object associated with a TermSuite {@link Document} object.
	 * 
	 * @param sourceDocument
	 * 			The TermSuite {@link Document} object to find.
	 * 
	 * @return the {@link EDocument} found, or <code>null</code> otherwise.
	 */
	public EDocument resolveEDocument(Document sourceDocument);


	/**
	 * Retrieves the line number of a {@link TermOccurrence} 
	 * in a document.
	 * 
	 * @param doc
	 * @param occ
	 * @return
	 */
	public int getLineNumber(EDocument doc, TermOccurrence occ);
	


	/**
	 * Return the covered text of two begin/end indexes in a {@link EDocument}.
	 * 
	 * @param document
	 * 			the input document
	 * @param begin
	 * 			the begin index (inclusive) of the substring
	 * @param end
	 * 			the end index (exclusive) of the substring
	 * @return
	 * 			the substring denoted by the two indexes in the document
	 */
	public String getDocumentExcerpt(EDocument document, int begin, int end);


	public File[] candidateSLCChildrenForPath(String path);

	public TXTCorpus asTxtCorpus(ESingleLanguageCorpus corpus);


	/**
	 * The root path of the comparable corpus, where the document files actually are, in the filesystem.
	 * 
	 * @param corpus
	 * @return
	 * 
	 */
	public Path getSourcePath(ECorpus corpus);
	
	public Path getSourcePath(ESingleLanguageCorpus slc);

	public Path getSourcePath(EDocument d);

	public Collection<EDocument> getDocuments(ESingleLanguageCorpus corpus);


}