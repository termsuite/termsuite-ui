package fr.univnantes.termsuite.ui.model;

import java.util.List;

import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;

public class LinguisticResourceSet {
	
	private ELang lang;
	private List<LinguisticResource> resources;

	public LinguisticResourceSet(ELang lang, List<LinguisticResource> resources) {
		super();
		this.lang = lang;
		this.resources = resources;
	}
	
	public ELang getLang() {
		return lang;
	}
	
	public List<LinguisticResource> getResources() {
		return resources;
	}
	
	@Override
	public String toString() {
		return "LinguisticResourceSet-" + lang;
	}
}
