package fr.univnantes.termsuite.ui.services.impl;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import fr.univnantes.termsuite.api.TermSuiteException;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;
import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.WorkspaceUtil;

public class ResourceServiceImpl implements ResourceService {
	@Inject
	IEventBroker eventBroker;
	
	private EPipelineList pipelines = TermsuiteuiFactory.eINSTANCE.createEPipelineList();
	
	public ResourceServiceImpl() {
		// Register the XMI resource factory for the .pipeline extension
		loadPipelines();
	}
	
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
	public Path getOutputDirectory() {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(TermSuiteUI.PLUGIN_ID);
		String path = preferences.get(
				TermSuiteUIPreferences.OUTPUT_DIRECTORY, 
				WorkspaceUtil.getWorkspacePath( TermSuiteUIPreferences.OUTPUT_DIRECTORY_DEFAULT).toString());
		Path path2 = Paths.get(path);
		path2.toFile().mkdirs();
		return path2;
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

	private static final Class<?>[] RENAMEABLE_RESOURCES = new Class<?>[]{
		ECorpus.class,
		EPipeline.class,
		ETerminology.class
	};
	
	@Override
	public boolean isRenameable(Class<? extends EObject> cls) {
		for(Class<?> editableResource:RENAMEABLE_RESOURCES)
			if(editableResource.isAssignableFrom(cls))
				return true;
		return false;
	}

	@Inject
	IEventBroker broker;

	@Inject
	IEclipseContext context;

	@Override
	public String getResourceName(EObject resource) {
		Optional<EAttribute> att = getNameEAttribute(resource.eClass());
		if(att.isPresent())
			return resource.eGet(att.get()) == null ? null :resource.eGet(att.get()).toString();
		else
			return null;
	}

	@Override
	public String canRename(EObject resource, String newName) {
		if(!isRenameable(resource.getClass()) || getResourceName(resource) == null)
			return "Renaming object of type " + resource.getClass().getSimpleName() + " is not allowed";
		else if(getResourceName(resource).equals(newName))
			return "New name must be different from current name";
		else if(asFilePath(resource).resolve(newName).toFile().exists())
			return "File or directory " + asFilePath(resource).resolve(newName).toAbsolutePath() + " already exists";
		else {
			if(resource instanceof ECorpus) {
				List<String> corpusNames = context.get(CorpusService.class).getCorporaList().getCorpora().stream().map(ECorpus::getName).collect(toList());
				if(corpusNames.contains(newName))
					return "A corpus named " + newName + " already exists";
			} else if(resource instanceof EPipeline) {
				List<String> pipelineNames = getPipelineList().getPipelines().stream().map(EPipeline::getName).collect(toList());
				if(pipelineNames.contains(newName))
					return "A pipeline named " + newName + " already exists";
			} else if(resource instanceof ETerminology) {
				List<String> terminologyNames = ((ETerminology)resource).getCorpus().getTerminologies().stream().map(ETerminology::getName).collect(toList());
				if(terminologyNames.contains(newName))
					return "A terminology named " + newName + " already exists";
			} 
		}
		return null;
	}

	@Override
	public Path asFilePath(EObject object) {
		if(object instanceof ECorpus)
			return context.get(CorpusService.class).getWorkspacePath((ECorpus)object);
		else if(object instanceof ESingleLanguageCorpus)
			return context.get(CorpusService.class).getWorkspacePath((ESingleLanguageCorpus)object);
		if(object instanceof ETerminology)
			return context.get(CorpusService.class).getWorkspacePath((ETerminology)object);
		if(object instanceof EPipeline)
			return getPath((EPipeline)object);
		else throw new IllegalArgumentException("A resource of type "+object.getClass().getSimpleName()+" cannot have a filepath.");
	}

	@Override
	public void rename(EObject object, String newName) {
		Preconditions.checkArgument(isRenameable(object.getClass()), "Not allwed to rename a resource of class %s", object.getClass().getName());

		
		
		
		try {
			if(object instanceof ETerminology) {
				// terminology belongs to the corpus. The corpus must be saved instead of the terminology.
				CorpusService corpusService = context.get(CorpusService.class);
				ETerminology termino = (ETerminology)object;
				Path oldPath = corpusService.getWorkspacePath(termino);
				termino.setName(newName);
				Path newPath = corpusService.getWorkspacePath(termino);
				corpusService.saveCorpus(termino.getCorpus().getCorpus());
				Files.move(oldPath, newPath);
				
			} else if(object instanceof EResource) {
				/*
				 * An EResource has a file within workspace.
				 * 
				 * This piece of code cannot be applied on a corpus for example.
				 *  
				 */
				Path oldPath = asFilePath(object);
				Optional<EAttribute> a = getNameEAttribute(object.eClass());
				if(a.isPresent())
					object.eSet(a.get(), newName);
				else
					throw new IllegalArgumentException("Found no attribute \"name\" for class: " + object.eClass().getName());
				Path newPath = asFilePath(object);
				Files.move(oldPath, newPath);
				save((EResource)object);
			}
		} catch (IOException e) {
			throw new TermSuiteException("Cloud not rename the resource file: " + e.getMessage(), e);
		}
		broker.post(TermSuiteEvents.OBJECT_RENAMED, object);

	}

	private String getResourceExtension(EObject object) {
		if(object instanceof ETerminology) {
			throw new IllegalArgumentException("ETerminology is contained in corpus. No specific resource file for ETerminology.");
		} else if(object instanceof ECorpus) {
			return CorpusService.CORPUS_EXTENSION;
		} else if(object instanceof EPipeline) {
			return PIPELINE_EXTENSION;
		} else
			throw new IllegalStateException("No file serialization support for object of type " + object.getClass().getSimpleName());
	}

	@Override
	public void save(EResource resource) {
		WorkspaceUtil.saveResource(resource, asFilePath(resource));
	}

	private Optional<EAttribute> getNameEAttribute(EClass eClass) {
		return eClass.getEAllAttributes().stream().filter(a -> a.getName().equals("name")).findFirst();
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


	@Override
	public Optional<EPipeline> getPipeline(String pipelineName) {
		return pipelines.getPipelines().stream()
				.filter(p -> p.getName().equals(pipelineName))
				.findFirst();
	}


	@Override
	public Path getPath(EPipeline pipeline) {
		return WorkspaceUtil.getWorkspacePath(PIPELINE_DIR, pipeline.getName() + "." + PIPELINE_EXTENSION);
	}

}
