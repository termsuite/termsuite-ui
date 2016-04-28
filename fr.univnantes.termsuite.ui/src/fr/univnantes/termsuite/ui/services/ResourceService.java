package fr.univnantes.termsuite.ui.services;

import java.util.List;

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
	
}
