package fr.univnantes.termsuite.ui.services;

import java.nio.file.Path;
import java.util.Collection;

import fr.univnantes.termsuite.model.Tagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;

public interface TaggerService {
	public Collection<ETaggerConfig> getTaggerConfigs();
	
	public ETaggerConfig getTaggerConfig(EPipeline pipeline);
	public ETaggerConfig getTaggerConfig(String configName);

	public Collection<String> getTaggerConfigNames();

	public Tagger getTermSuiteTagger(EPipeline pipeline);

	public Path getTaggerPath(EPipeline pipeline);

}
