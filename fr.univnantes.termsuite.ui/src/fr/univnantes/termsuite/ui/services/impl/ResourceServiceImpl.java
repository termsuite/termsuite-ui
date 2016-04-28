package fr.univnantes.termsuite.ui.services.impl;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class ResourceServiceImpl implements ResourceService {

	BiMap<String, EResource> resources = HashBiMap.create();
	
	@Override
	public String getResourceId(EResource termsuiteUIObject) {
		String id = resources.inverse().get(termsuiteUIObject);
		if(id == null) {
//			id = UUID.randomUUID().toString();
			id = EcoreUtil.getURI(termsuiteUIObject).toString();
			resources.put(id, termsuiteUIObject);
		}
		return id;
	}

	@Override
	public EResource getResource(String resourceId) {
		return resources.get(resourceId);
	}

	@Override
	public String toModelTag(ETerminology targetTerminology) {
		return MODEL_TAG_PREFIX + getResourceId(targetTerminology);
	}

	@Override
	public EResource fromModelTag(List<String> modelTags) {
		for(String modelTag:modelTags) {
			if(modelTag.startsWith(MODEL_TAG_PREFIX)) {
				String resourceId = modelTag.replaceFirst(MODEL_TAG_PREFIX, "");
				return getResource(resourceId);
			}
		}
		
		return null;
	}
}
