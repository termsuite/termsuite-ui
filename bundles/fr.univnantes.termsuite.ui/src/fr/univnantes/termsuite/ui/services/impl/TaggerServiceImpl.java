package fr.univnantes.termsuite.ui.services.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import fr.univnantes.termsuite.model.Tagger;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.TaggerUtil;

public class TaggerServiceImpl implements TaggerService {
	@Override
	public Collection<ETaggerConfig> getTaggerConfigs() {
		return getTaggerConfigMap().values(); 
	}

	private Map<String, ETaggerConfig> getTaggerConfigMap() {
		String taggerStr = Platform.getPreferencesService().getString(
				TermSuiteUI.PLUGIN_ID,
				TermSuiteUIPreferences.TAGGERS, 
				"", null);
		Map<String, ETaggerConfig> taggerConfigs = Maps.newHashMap();
		if(!taggerStr.trim().isEmpty()) {
			List<String> list = Splitter.on(TermSuiteUIPreferences.LIST_SEPARATOR_CHAR).splitToList(taggerStr);
			for(String s:list) 
				if(!s.trim().isEmpty()) {
					ETaggerConfig taggerConfig = TaggerUtil.fromPreferenceString(s);
					taggerConfigs.put(taggerConfig.getName(), taggerConfig);
				}
		}
		return taggerConfigs;
	}

	@Override
	public ETaggerConfig getTaggerConfig(EPipeline pipeline) {
		return getTaggerConfig(pipeline.getTaggerConfigName());
	}

	@Override
	public ETaggerConfig getTaggerConfig(String configName) {
		return getTaggerConfigMap().get(configName);
	}

	@Override
	public Collection<String> getTaggerConfigNames() {
		return getTaggerConfigMap().keySet(); 
	}

	@Override
	public Tagger getTermSuiteTagger(EPipeline pipeline) {
		switch(getTaggerConfig(pipeline).getTaggerType()) {
		case MATE:
			return Tagger.MATE;
		case TREE_TAGGER:
			return Tagger.TREE_TAGGER;
		default:
			return Tagger.TREE_TAGGER;
		}
	}
	
	@Override
	public Path getTaggerPath(EPipeline pipeline) {
		return Paths.get(getTaggerConfig(pipeline).getPath());
	}
	
}
