package fr.univnantes.termsuite.ui.model;

import fr.univnantes.termsuite.ui.util.LangUtil;
import fr.univnantes.termsuite.uima.ResourceType;

public class LinguisticResource {

	private LinguisticResourceSet resourceSet;
	private ResourceType resourceType;
	
	public LinguisticResource(LinguisticResourceSet resourceSet, ResourceType resourceType) {
		super();
		this.resourceSet = resourceSet;
		this.resourceType = resourceType;
	}
	
	public LinguisticResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public ResourceType getResourceType() {
		return resourceType;
	}
	
	@Override
	public String toString() {
		String path = resourceType.getPath(LangUtil.getTermsuiteLang(resourceSet.getLang()));
		return String.format("LinguisticResource-%s", path);
	}
}
