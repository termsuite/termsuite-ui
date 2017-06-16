package fr.univnantes.termsuite.ui.services;

import java.nio.file.Path;

import org.eclipse.core.runtime.jobs.Job;

import com.google.common.base.Optional;

import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;

public interface PreprocessorService {

	public Job getPreparedCorpusJob(EPipeline pipeline, ESingleLanguageCorpus corpus);

	public Optional<IndexedCorpus> getCachedPreparedCorpus(ESingleLanguageCorpus corpus, String taggerConfigName);

	public Path getCachePath(ESingleLanguageCorpus corpus, String taggerConfigName);
}
