package fr.univnantes.termsuite.ui.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;

import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.ImmutableSet;

import fr.univnantes.termsuite.api.TXTCorpus;
import fr.univnantes.termsuite.model.Document;
import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;

public interface CorpusService {
	public static final String CORPUS_EXTENSION = "corpus";
	public static final String CORPUS_DIR = "corpora";

	public static final Set<ELang> SUPPORTED_LANGUAGES = ImmutableSet.of(ELang.FR, ELang.EN, ELang.ES, ELang.DE, ELang.RU);

	public ECorporaList getCorporaList();

	/**
	 * Iterates over all terminologies.
	 * 
	 * @return
	 */
	public Collection<ETerminology> getTerminologies();

	public Path getDocumentPath(ESingleLanguageCorpus slc);

	public Path getPath(ESingleLanguageCorpus slc);

	public Path getPath(EDocument d);

	public File asFile(EDocument d);

	public ECorpus createCorpus(String name, String corpusPath);


	/**
	 * Gives the root output directory of a given pipeline 
	 * for a corpus, based on the <code>outputDirectory</code> preference.
	 * 
	 * @param corpus
	 * @return
	 */
	public String getOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline);


	public String getTerminoOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline, String extension);
	public String getTerminoJsonFile(ESingleLanguageCorpus corpus, EPipeline pipeline);
	public String getTerminoTsvFile(ESingleLanguageCorpus corpus, EPipeline pipeline);
	public String getTerminoTbxFile(ESingleLanguageCorpus corpus, EPipeline pipeline);

	
	public String getCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline, String casDirname);
	public String getXmiCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline);
	public String getTsvCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline);
	public String getJsonCasOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline);
	
	public String getCollectionPath(ESingleLanguageCorpus corpus);

	
	public void saveCorpus(ECorpus corpus) throws IOException;


	public void removeCorpus(ECorpus s);

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
	 * The output root directory for the given corpus.
	 * 
	 * @param corpus
	 * @return
	 */
	public String getOutputDirectory(ESingleLanguageCorpus corpus);

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

	public boolean isLanguageSupported(ELang language);

	public File[] candidateSLCChildrenForPath(String path);

	public TXTCorpus asTxtCorpus(ESingleLanguageCorpus corpus);

}