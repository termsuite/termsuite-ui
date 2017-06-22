package fr.univnantes.termsuite.ui.services;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;
import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;

public interface ResourceService {
	public static final String MODEL_TAG_PREFIX = "model:";
	
	public String getResourceId(EResource termsuiteUIObject);
	public EResource getResource(String resourceId);
	
	/**
	 * Converts a resource to a tag string so as to be reloaded from a handler.
	 * 
	 * @param targetTerminology
	 * @return
	 *      the string tag
	 */
	public String toModelTag(ETerminology targetTerminology);

	/**
	 * Retrieves and loads a resource from its model tag.
	 * 
	 * @param modelTags
	 * @return
	 * 		the resource, or <code>null</code> if not found
	 */
	public EResource fromModelTag(List<String> modelTags);
	
	
	public boolean isRenameable(Class<? extends EObject> cls);

	public void rename(EObject object, String newName);
	public String getResourceName(EObject object);
	public String canRename(EObject object, String newName);
	public Path asFilePath(EObject object);
	public void save(EResource resource);
	public Path getOutputDirectory();


	public static final String PIPELINE_EXTENSION = "pipeline";
	public static final String PIPELINE_DIR = "pipelines";

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

	public Path getPath(EPipeline resource);
}
