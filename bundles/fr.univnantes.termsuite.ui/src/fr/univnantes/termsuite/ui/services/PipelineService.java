package fr.univnantes.termsuite.ui.services;

import java.io.IOException;
import java.util.Optional;

import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;

public interface PipelineService {


	public static final String PIPELINE_EXTENSION = "pipeline";
	public static final String PIPELINE_DIR = "pipelines";
	public static final String DEFAULT_TERMINO_DIR = "terminologies";

	public void savePipeline(EPipeline pipeline) throws IOException;

	public EPipelineList getPipelineList();

	public EPipeline createPipeline(String filename) throws IOException;

	public boolean canCreatePipeline(String string);

	public void remove(EPipeline s);

	/**
	 * Gets an existing pipeline by name.
	 * 
	 * @param pipelineName
	 * 			The pipeline name
	 * @return
	 * 			The pipeline as an {@link Optional}
	 */
	public Optional<EPipeline> getPipeline(String pipelineName);

}