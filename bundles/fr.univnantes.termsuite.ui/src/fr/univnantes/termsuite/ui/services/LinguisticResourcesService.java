package fr.univnantes.termsuite.ui.services;

import java.util.Collection;

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


	public boolean areCustomResourcesActivated();


	public String getCustomResourcesPath();
}
