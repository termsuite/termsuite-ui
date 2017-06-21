package fr.univnantes.termsuite.ui.services;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

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

}
