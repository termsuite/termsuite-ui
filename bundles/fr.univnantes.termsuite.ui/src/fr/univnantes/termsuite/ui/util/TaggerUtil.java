package fr.univnantes.termsuite.ui.util;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import eu.project.ttc.engines.desc.Lang;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;

public class TaggerUtil {
	private static final String TREE_TAGGER_NAME = "Tree Tagger";
	private static final String MATE_NAME = "Mate";

	public static final String getTaggerName(ETagger tagger) {
		switch (tagger) {
		case TREE_TAGGER:
			return TREE_TAGGER_NAME;
		case MATE:
			return MATE_NAME;
		default:
			return "Unknown tagger";
		}
	}

	public static ETagger getTaggerByName(String taggerName) {
		switch (taggerName) {
		case TREE_TAGGER_NAME:
			return ETagger.TREE_TAGGER;
		case MATE_NAME:
			return ETagger.MATE;
		default:
			throw new IllegalArgumentException("Unknown tagger name: " + taggerName);
		}
	}

	public static ETaggerConfig fromPreferenceString(String string) {
		List<String> l = Splitter.on("\t").splitToList(string);
		ETaggerConfig taggerConfig = TermsuiteuiFactory.eINSTANCE.createETaggerConfig();
		taggerConfig.setName(l.get(0).trim());
		taggerConfig.setTaggerType(ETagger.getByName(l.get(1).trim()));
		taggerConfig.setPath(l.get(2));
		return taggerConfig;
	}
	
	public static String toPreferenceString(ETaggerConfig config) {
		String format = String.format("%-15s\t%-17s\t%s", 
				config.getName(),
				config.getTaggerType().getName(),
				config.getPath()
				);
		return format;
	}
	
	public static Collection<ELang> getSupportedLanguages(ETaggerConfig config) {
		Set<ELang> languages = Sets.newHashSet();
		if(config.getTaggerType() == ETagger.TREE_TAGGER) {
			File modelsDir = Paths.get(config.getPath(), "models").toFile();
			if(modelsDir.exists() && modelsDir.isDirectory()) {
				for(File f:modelsDir.listFiles()) {
					String fileName = f.getName();
					for(ELang l:ELang.values()) {
						if(LangUtil.isLangSupported(l)) {
							Lang termsuiteLang = LangUtil.getTermsuiteLang(l);
							String langName = termsuiteLang.getName().toLowerCase();
							String expectedFilename = String.format("%s.par", langName);
							if(fileName.equals(expectedFilename))
								languages.add(l);
						}
					}
				}
			}
			return languages;
		} else if(config.getTaggerType() == ETagger.MATE) {
			for (ELang l : ELang.values()) {
				String lemmaFilename = String.format("mate-lemma-%s.model", l.getName().toLowerCase());
				String posFilename = String.format("mate-pos-%s.model", l.getName().toLowerCase());
				if (Paths.get(config.getPath(), lemmaFilename).toFile().exists()
						&& Paths.get(config.getPath(), posFilename).toFile().exists())
					languages.add(l);
			}
			return languages;
		} else
			return Lists.newArrayList();
	}

	public static String isValidInstallDir(ETaggerConfig config) {
		if(config.getPath() == null)
			return "No install directory selected";
		File f = new File(config.getPath());
		if(!f.exists())
			return String.format("Directory %s does not exists", f.getPath());
		else if(!f.isDirectory())
			return String.format("Not a directory: %s", f.getPath());
			
		if(config.getTaggerType()== ETagger.TREE_TAGGER) {
			if(!Paths.get(f.getPath(), "bin").toFile().exists())
				return String.format("Missing subdirectory \"bin/\"");
			else if(!Paths.get(f.getPath(), "bin", getTreeTaggerExecutableName()).toFile().exists())
				return String.format("Missing file \"%s\"", 
						Paths.get("bin", getTreeTaggerExecutableName()).toString(), 
						f.getPath());
			File modelsDir = Paths.get(f.getPath(), "models").toFile();
			if(!modelsDir.exists()
					|| !modelsDir.isDirectory())
				return String.format("Missing directory \"models/\"", 
						f.getPath());				
		} else if(config.getTaggerType()== ETagger.MATE) {
			// Nothing to check
		}
		if(TaggerUtil.getSupportedLanguages(config).isEmpty())
			return "No language model found. Make sure you follow TermSuite's official naming and encoding conventions. See " + TermSuiteUI.WEB_SITE_TAGGER_DOC_URL;
		return null;
	}
	
	private static String getTreeTaggerExecutableName() {
		return OSUtil.isWindows() ? "tree-tagger.exe" : "tree-tagger";
	}

	
}
