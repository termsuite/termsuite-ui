package fr.univnantes.termsuite.ui.services.impl;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;

import fr.univnantes.termsuite.api.TermSuiteException;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;
import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.WorkspaceUtil;

public class ResourceServiceImpl implements ResourceService {
	@Inject
	private IEventBroker eventBroker;
	
	@Inject
	private IEclipseContext context;

	private ECorporaList corpora = TermsuiteuiFactory.eINSTANCE.createECorporaList();
	private EPipelineList pipelines = TermsuiteuiFactory.eINSTANCE.createEPipelineList();
	private BiMap<String, EResource> resources = HashBiMap.create();

	
	public ResourceServiceImpl() {
		// Register the XMI resource factory for the .pipeline extension
		List<EPipeline> list = WorkspaceUtil.loadResources(PIPELINE_DIR, PIPELINE_EXTENSION, EPipeline.class);
		pipelines.getPipelines().addAll(list);

		Map<String, Object> m = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		// Register the XMI resource factory for the .pipeline extension
		m.put(CORPUS_EXTENSION, new XMIResourceFactoryImpl());
	
		List<ECorpus> list2 = WorkspaceUtil.loadResources(CORPUS_DIR, CORPUS_EXTENSION, ECorpus.class);
		corpora.getCorpora().addAll(list2);

	}
	
	
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
				List<String> corpusNames = getCorporaList().getCorpora().stream().map(ECorpus::getName).collect(toList());
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
			return getWorkspacePath((ECorpus)object);
		else if(object instanceof ESingleLanguageCorpus)
			return getWorkspacePath((ESingleLanguageCorpus)object);
		if(object instanceof ETerminology)
			return getWorkspacePath((ETerminology)object);
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
				ETerminology termino = (ETerminology)object;
				Path oldPath = getWorkspacePath(termino);
				termino.setName(newName);
				Path newPath = getWorkspacePath(termino);
				saveCorpus(termino.getCorpus().getCorpus());
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
		eventBroker.post(TermSuiteEvents.OBJECT_RENAMED, object);

	}

	@Override
	public void save(EResource resource) {
		WorkspaceUtil.saveResource(resource, asFilePath(resource));
	}

	private Optional<EAttribute> getNameEAttribute(EClass eClass) {
		return eClass.getEAllAttributes().stream().filter(a -> a.getName().equals("name")).findFirst();
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
	
	

	/* (non-Javadoc)
	 * @see fr.univnantes.termsuite.ui.services.CorpusService#getCorporaList()
	 */
	@Override
	public ECorporaList getCorporaList() {
		return corpora;
	}
	
	
	@Override
	public void saveCorpus(ECorpus corpus) {
		WorkspaceUtil.saveResource(corpus, CORPUS_DIR, corpus.getName(), CORPUS_EXTENSION);
	}

	@Override
	public ETerminology createTerminology(ESingleLanguageCorpus corpus, String terminologyName, EOccurrenceMode occMode, boolean hasContexts) {
		/*
		 * Ensure that any termino with the same name is removed. 
		 * (Override behaviour)
		 */
		
		for(Iterator<ETerminology> it = corpus.getTerminologies().iterator(); it.hasNext(); )
			if(it.next().getName().equals(terminologyName))
				it.remove();
		ETerminology terminology = TermsuiteuiFactory.eINSTANCE.createETerminology();
		terminology.setName(terminologyName);
		terminology.setHasOccurrences(occMode != EOccurrenceMode.DO_NOT_KEEP);
		terminology.setHasContexts(hasContexts);
		
		corpus.getTerminologies().add(terminology);
		
		return terminology;
	}
	
	
	@Override
	public void removeTerminology(ETerminology terminology) {
		ECorpus corpus = terminology.getCorpus().getCorpus();
		getWorkspacePath(terminology).toFile().delete();
		terminology.getCorpus().getTerminologies().remove(terminology);
		saveCorpus(corpus);
		eventBroker.post(TermSuiteEvents.TERMINOLOGY_REMOVED, terminology);
	}

	@Override
	public Path getOutputDirectory(ESingleLanguageCorpus corpus) {
		return context.get(ResourceService.class).getOutputDirectory()
				.resolve(corpus.getCorpus().getName())
				.resolve(corpus.getLanguage().getName());
	}

	@Override
	public Path getOutputDirectory(ESingleLanguageCorpus corpus, EPipeline pipeline) {
		return getOutputDirectory(corpus).resolve(pipeline.getName());
	}




	@Override
	public void removeCorpus(ECorpus s) {
		corpora.getCorpora().remove(s);
		WorkspaceUtil.removeResource(CORPUS_DIR, s.getName(), CORPUS_EXTENSION);
		eventBroker.post(TermSuiteEvents.CORPUS_REMOVED, s);

	}

	@Override
	public Collection<ETerminology> getTerminologies() {
		List<ETerminology> terminologies = Lists.newArrayList();
		for(ECorpus corpus:getCorporaList().getCorpora()) {
			for(ESingleLanguageCorpus slc:corpus.getSingleLanguageCorpora()) {
				terminologies.addAll(slc.getTerminologies());
			}
		}
		return terminologies;
	}

	@Override
	public Path getWorkspacePath(ECorpus corpus) {
		return createParents(getOutputDirectory().resolve(corpus.getName()));
	}

	@Override
	public Path getWorkspacePath(ESingleLanguageCorpus slc) {
		Path corpusPath = getWorkspacePath(slc.getCorpus());
		Path slcPath = corpusPath.resolve(slc.getLanguage().toString());
		return createParents(slcPath);
	}

	@Override
	public Path getWorkspacePath(ETerminology resource) {
		Path path = getWorkspacePath(resource.getCorpus()).resolve(resource.getName() + "." + JSON_EXTENSION);
		return createParents(path);
	}
	
	private Path createParents(Path path) {
		path.toFile().getParentFile().mkdirs();
		return path;
	}
}
