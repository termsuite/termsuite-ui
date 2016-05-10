package fr.univnantes.termsuite.ui.services;

import java.io.IOException;
import java.util.Collection;

import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet;

public interface LinguisticResourcesService {
	
	
	/**
	 * 
	 * Creates an OSGi bundle from a linguistic resources 
	 * directory and loads the bundler on the platform in
	 * the place of the built-in resources bundle. 
	 * 
	 * @param resourcePath
	 * 			The path to the resources to load.
	 */
	public void loadCustomResources(String resourcePath);
	
	
	/**
	 * 
	 * Uninstall the OSGi bundle containing the custom resources
	 * and reload the built-in bundle for linguistic resources.
	 * 
	 */
	public void unloadCustomResources();

	
	/**
	 * Loads all the resource sets from a given path into memory.
	 * 
	 * @param resourcePath
	 * @return
	 */
	public Collection<ELinguisticResourceSet> getLinguisticResourceSets(String resourcePath);
	
	/**
	 * 
	 * Return <code>true</code> if the directory has at least one 
	 * non-empty language resource set.
	 * 
	 * @param resourcePath
	 * @return
	 */
	public boolean isValidLinguisticResourceDirectory(String resourcePath);

	/**
	 * 
	 * Copies all resources from the built-in resource set of TermSuite
	 * to an target directory in local file sytem.
	 * 
	 * @param resourcePath
	 * @return
	 * 
	 * @throws IllegalArgumentException if the resourcePath is not empty
	 */
	public boolean createLinguisticResourceDirectory(String resourcePath) throws IOException;


}
