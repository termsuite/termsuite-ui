package fr.univnantes.termsuite.ui.services;

import java.nio.file.Path;
import java.util.Set;

import org.eclipse.core.runtime.jobs.Job;

import com.google.common.collect.ImmutableSet;

import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;

public interface NLPService {
	public static final int MAX_SIZE = 500000;

	public static final Set<ELang> SUPPORTED_LANGUAGES = ImmutableSet.of(ELang.FR, ELang.EN, ELang.ES, ELang.DE, ELang.RU, ELang.IT);

	public void runPipelineOnCorpus(EPipeline pipeline, ESingleLanguageCorpus corpus, boolean useCache);

	public void runPipelineOnSeveralCorpus(EPipeline pipeline, Iterable<ESingleLanguageCorpus> corpusList, boolean useCache);

	/**
	 * 
	 * Tells if the pipeline object is ready for run or not.
	 * 
	 * @param pipeline
	 * @return
	 * 		<code>null</code> if the pipeline is valide, the error msg otherwise
	 */
	public String validatePipeline(EPipeline pipeline);

	public boolean isLanguageSupported(ELang language);

	public boolean isPipelineValid(EPipeline pipeline);
	
	public Job getPrepareCorpusJob(EPipeline pipeline, ESingleLanguageCorpus corpus);

	public Path getCachePath(ESingleLanguageCorpus corpus, String taggerConfigName, int maxSize);
	
	public boolean clearNlpCache();
	
	public Path getNlpCachePath();

}
