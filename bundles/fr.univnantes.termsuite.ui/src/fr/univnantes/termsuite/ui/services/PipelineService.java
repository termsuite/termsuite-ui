package fr.univnantes.termsuite.ui.services;

import java.io.IOException;

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

}