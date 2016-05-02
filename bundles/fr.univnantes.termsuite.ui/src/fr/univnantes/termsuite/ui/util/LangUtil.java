package fr.univnantes.termsuite.ui.util;

import java.util.Collection;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import eu.project.ttc.engines.desc.Lang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;

public class LangUtil {
	private static Map<ELang, String> countries = Maps.newHashMap();
	private static Map<ELang, Lang> tsLangs = Maps.newHashMap();

	
	static {
		countries.put(ELang.FR, "France");
		countries.put(ELang.EN, "United-Kingdom");
		countries.put(ELang.DE, "Germany");
		countries.put(ELang.ES, "Spain");
//		countries.put(ELang.LV, "Latvia");
		countries.put(ELang.RU, "Russia");
//		countries.put(ELang.DA, "Denmark");
//		countries.put(ELang.ZH, "China");
		countries = ImmutableMap.copyOf(countries);
		
		tsLangs.put(ELang.FR, Lang.FR);
		tsLangs.put(ELang.EN, Lang.EN);
		tsLangs.put(ELang.ES, Lang.ES);
		tsLangs.put(ELang.DE, Lang.DE);
		tsLangs.put(ELang.RU, Lang.RU);
//		tsLangs.put(ELang.DA, Lang.DA);
//		tsLangs.put(ELang.LV, Lang.LV);
//		tsLangs.put(ELang.ZH, Lang.ZH);
		tsLangs = ImmutableMap.copyOf(tsLangs);
	}
	
	public static Lang getTermsuiteLang(ELang lang) {
		Preconditions.checkArgument(isLangSupported(lang), "Language not found: %s", lang.getName());
		return tsLangs.get(lang);
	}

	public static Collection<ELang> getSupportedLanguages() {
		return tsLangs.keySet();
	}
	public static boolean isLangSupported(ELang lang) {
		return tsLangs.containsKey(lang);
	}

	public static String getCountry(ELang lang) {
		return countries.get(lang);
	}
		
	public static ELang getLangByCode(String code) {
		return ELang.getByName(code.toUpperCase());
	}
	
	public static ELang getLangByNameUC(String name) {
		for(Lang l:Lang.values())
			if(l.getNameUC().equals(name))
				return ELang.getByName(l.getCode().toUpperCase());
		return null;
	}
	public static ELang getLangByNameDC(String name) {
		for(Lang l:Lang.values())
			if(l.getName().equals(name))
				return ELang.getByName(l.getCode().toUpperCase());
		return null;
	}

	public static ELang getLanguageByString(String target) {
		ELang targetLang = getLangByCode(target);
		if(targetLang == null)
			targetLang = getLangByNameDC(target);
		if(targetLang == null)
			targetLang = getLangByNameUC(target);
		
		return targetLang;
	}

}
