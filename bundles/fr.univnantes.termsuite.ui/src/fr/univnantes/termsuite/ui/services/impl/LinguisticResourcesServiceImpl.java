package fr.univnantes.termsuite.ui.services.impl;

import java.io.IOException;
import java.util.Collection;

import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;

public class LinguisticResourcesServiceImpl implements LinguisticResourcesService {

	@Override
	public void loadCustomResources(String resourcePath) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void unloadCustomResources() {
		throw new UnsupportedOperationException("Not yet implemented");		
	}

	@Override
	public Collection<ELinguisticResourceSet> getLinguisticResourceSets(String resourcePath) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public boolean isValidLinguisticResourceDirectory(String resourcePath) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public boolean createLinguisticResourceDirectory(String resourcePath) throws IOException {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
