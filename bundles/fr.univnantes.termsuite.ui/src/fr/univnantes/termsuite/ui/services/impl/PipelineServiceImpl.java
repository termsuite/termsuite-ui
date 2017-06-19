package fr.univnantes.termsuite.ui.services.impl;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.WorkspaceUtil;

public class PipelineServiceImpl implements PipelineService {
	
	@Inject
	private IEclipseContext context;

	@Inject
	private IEventBroker eventBroker;
	
	private EPipelineList pipelines = TermsuiteuiFactory.eINSTANCE.createEPipelineList();

	
	public PipelineServiceImpl() {
		// Register the XMI resource factory for the .pipeline extension
		loadPipelines();
	}
	

	private void loadPipelines() {
		List<EPipeline> list = WorkspaceUtil.loadResources(PIPELINE_DIR, PIPELINE_EXTENSION, EPipeline.class);
		pipelines.getPipelines().addAll(list);
	}



	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.PipelineService#savePipeline(fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline)
	 */
	@Override
	public void savePipeline(EPipeline pipeline) throws IOException {
		WorkspaceUtil.saveResource(pipeline, PIPELINE_DIR, pipeline.getName(), PIPELINE_EXTENSION);
	}


	
	
	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.PipelineService#getPipelineList()
	 */
	@Override
	public EPipelineList getPipelineList() {
		return pipelines;
	}

	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.PipelineService#createPipeline(java.lang.String)
	 */
	@Override
	public EPipeline createPipeline(String name) throws IOException {
		EPipeline p = TermsuiteuiFactory.eINSTANCE.createEPipeline();
		p.setName(name);
		TaggerService taggerService = this.context.get(TaggerService.class);
		if(taggerService.getTaggerConfigs().size() > 0) {
			ETaggerConfig treeTagger = null;
			for(ETaggerConfig config:taggerService.getTaggerConfigs())
				if(config.getTaggerType() == ETagger.TREE_TAGGER)
					treeTagger = config;
			ETaggerConfig selectedConfig = treeTagger != null ? treeTagger : taggerService.getTaggerConfigs().iterator().next();
			p.setTaggerConfigName(selectedConfig.getName());
		}
		pipelines.getPipelines().add(p);
		savePipeline(p);
		return p;
	}

	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.PipelineService#canCreatePipeline(java.lang.String)
	 */
	@Override
	public boolean canCreatePipeline(String string) {
		for(EPipeline p:pipelines.getPipelines()) {
			if(p.getName().equals(string))
				return false;
		}
		return true;
	}


	@Override
	public void remove(EPipeline s) {
		pipelines.getPipelines().remove(s);
		WorkspaceUtil.removeResource(PIPELINE_DIR, s.getName(), PIPELINE_EXTENSION);
		eventBroker.post(TermSuiteEvents.PIPELINE_REMOVED, s);
	}
}
