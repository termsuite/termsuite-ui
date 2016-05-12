package fr.univnantes.termsuite.ui.services;

import java.util.Collection;

import org.osgi.framework.Bundle;

import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet;

public interface LinguisticResourcesService {
	
	/**
	 * Loads all the resource sets from a given path into memory.
	 * 
	 * @return
	 */
	public Collection<ELinguisticResourceSet> getLinguisticResourceSets();
	
	
	/**
	 * Gets a resource by path.
	 */
	public ELinguisticResource getResource(String path);
	

	/**
	 * 
	 * Returns the plugin of the active 
	 * linguistic resources sets.
	 * 
	 * @return
	 */
	public Bundle getLinguisticResourceBundle();


}
