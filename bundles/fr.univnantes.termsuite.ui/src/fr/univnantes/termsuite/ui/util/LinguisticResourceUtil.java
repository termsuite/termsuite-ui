package fr.univnantes.termsuite.ui.util;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.uima.ResourceType;

public class LinguisticResourceUtil {

	public static List<ELinguisticResourceSet> getLinguisticResourceSets(String resourcePath, boolean allowEmptyDirectory) {
		if(resourcePath == null || resourcePath.trim().isEmpty())
			throw new ValidationException("Empty resource path.");			
		File f = new File(resourcePath);
		if(!f.exists())
			throw new ValidationException("Directory " + resourcePath + " does not exists.");
		else if(!f.isDirectory())
			throw new ValidationException("Not a directory: " + resourcePath);
		else {
			List<ELinguisticResourceSet> resourceSets = Lists.newArrayList();
			
			if(f.listFiles().length > 0) {
				
				for(File langDir:f.listFiles()) {
					ELang lang = LangUtil.getLangByCode(langDir.getName());
					if(langDir.isDirectory() 
							&& lang != null 
							&& LangUtil.isLangSupported(lang)) {
						ELinguisticResourceSet resourceSet = TermsuiteuiFactory.eINSTANCE.createELinguisticResourceSet(); 
						resourceSet.setLanguage(lang);
						
						for (File candidateResourceFile : Files.fileTreeTraverser().preOrderTraversal(langDir)) {
						    Path relativePath = langDir.toPath().getParent().relativize(candidateResourceFile.toPath());
						    ResourceType tsResource = ResourceType.forFileName(
					    			relativePath.toString());
					    	if(tsResource != null) {
					    		ELinguisticResource res = TermsuiteuiFactory.eINSTANCE.createELinguisticResource();
					    		resourceSet.getResources().add(res);
					    		res.setDescription(tsResource.getDescription());
					    		res.setName(tsResource.getTitle());
					    		res.setPath(candidateResourceFile.getAbsolutePath());
					    	}
						}
						if(!resourceSet.getResources().isEmpty())
							resourceSets.add(resourceSet);
					}
				}
				if(resourceSets.isEmpty()) 
					throw new ValidationException("No language resource set found in " + resourcePath);
				else
					return resourceSets;
			} else {
				if(allowEmptyDirectory)
					return resourceSets;
				else
					throw new ValidationException("Empty directory: " + resourcePath);
			}
				
		}
	}
}
