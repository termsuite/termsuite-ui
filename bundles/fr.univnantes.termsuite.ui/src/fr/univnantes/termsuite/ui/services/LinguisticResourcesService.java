package fr.univnantes.termsuite.ui.services;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import fr.univnantes.termsuite.api.ResourceConfig;
import fr.univnantes.termsuite.ui.model.LinguisticResource;
import fr.univnantes.termsuite.ui.model.LinguisticResourceSet;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.uima.ResourceType;

public interface LinguisticResourcesService {
	
	public Collection<ResourceType> getEditableResources();
	
	public boolean areCustomResourcesActivated();

	public Path getCustomResourceDirectoryPath();

	public ResourceConfig getResourceConfig(ELang lang);

	public List<LinguisticResourceSet> getResourceSets();

	public File asFile(LinguisticResource r, boolean createIfAbsent);

	public LinguisticResource getResourceFromString(String linguisticResourceString);
	
	public String getResourceAsString(LinguisticResource linguisticResource);
}
