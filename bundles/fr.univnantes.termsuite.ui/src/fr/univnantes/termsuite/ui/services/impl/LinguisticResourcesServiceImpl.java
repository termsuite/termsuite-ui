package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.osgi.service.prefs.Preferences;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import fr.univnantes.termsuite.api.ResourceConfig;
import fr.univnantes.termsuite.api.TermSuiteException;
import fr.univnantes.termsuite.model.Lang;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.LinguisticResource;
import fr.univnantes.termsuite.ui.model.LinguisticResourceSet;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.util.LangUtil;
import fr.univnantes.termsuite.uima.ResourceType;

@SuppressWarnings("restriction")
public class LinguisticResourcesServiceImpl implements LinguisticResourcesService {

	private static final List<ResourceType> EDITABLE_RESOURCES = Lists.newArrayList(
			ResourceType.MWT_RULES,
			ResourceType.VARIANTS,
			ResourceType.PREFIX_BANK,
			ResourceType.PREFIX_EXCEPTIONS,
			ResourceType.NEOCLASSICAL_PREFIXES,
			ResourceType.SUFFIX_DERIVATIONS,
			ResourceType.SUFFIX_DERIVATION_EXCEPTIONS
			);
	
	@Inject
	@Preference(value = TermSuiteUIPreferences.ACTIVATE_CUSTOM_RESOURCES)
	private boolean withCustomResources = false;

	@Inject
	@Preference(value = TermSuiteUIPreferences.COPY_BUILTIN_RESOURCES_IF_EMPTY)
	private boolean copyIfEmpty = false;

	
	@Inject
	IEclipseContext context;

	/*
	 * Cache fields
	 */
	private List<LinguisticResourceSet> resourceSets = null;

	Logger logger;
	
	@PostConstruct
	public void init(ILoggerProvider loggerProvider) {
		this.logger = loggerProvider.getClassLogger(LinguisticResourcesServiceImpl.class);
		logger.debug("Loading service " + LinguisticResourcesServiceImpl.class);		
	}
	
	private void resetCache() {
		resourceSets = null;
	}
	
	@Inject
	@Optional
	public void reactOnCustomResourceActiveChange( 
			LinguisticResourcesService lingueeService, 
			@Preference(value = TermSuiteUIPreferences.ACTIVATE_CUSTOM_RESOURCES) boolean active
			) {
		this.withCustomResources = active;
		logger.debug("Modification detected in preferences: custom resources are now " + (this.withCustomResources ? "activated": "deactivated") );
		resetCache();
	}

	@Inject
	@Optional
	public void reactOnCustomResourceChange( 
			LinguisticResourcesService lingueeService, 
			@Preference(value = TermSuiteUIPreferences.COPY_BUILTIN_RESOURCES_IF_EMPTY) boolean copyIfEmpty
			) {
		this.copyIfEmpty = copyIfEmpty;
		logger.debug("Modification detected in preferences: copy built-in resources if target dir empty: " + this.copyIfEmpty);
		resetCache();
	}

	@Inject
	@Optional
	public void reactOnCustomResourceChange( 
			LinguisticResourcesService lingueeService
			) {
		resetCache();
	}


	@Override
	public boolean areCustomResourcesActivated() {
		return withCustomResources;
	}

	@Override
	public Path getCustomResourceDirectoryPath() {
		Preconditions.checkState(withCustomResources, "Custom resources are not activated");
		Preferences preferences = InstanceScope.INSTANCE.getNode(TermSuiteUI.PLUGIN_ID);
		String string = preferences.get(TermSuiteUIPreferences.LINGUISTIC_RESOURCES_DIRECTORY, "");
		if(string.equals("")) {
			preferences.put(
					TermSuiteUIPreferences.LINGUISTIC_RESOURCES_DIRECTORY, 
					TermSuiteUIPreferences.LINGUISTIC_RESOURCES_DIRECTORY_DEFAULT);
		}
		return Paths.get(string);
	}


	@Override
	public Collection<ResourceType> getEditableResources() {
		return EDITABLE_RESOURCES;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinguisticResourceSet> getResourceSets() {
		if(withCustomResources) {
			if(resourceSets == null)
				resourceSets = LangUtil.getSupportedLanguages().stream()
					.map(lang -> { 
						List<LinguisticResource> resources = new ArrayList<LinguisticResource>();
						LinguisticResourceSet set = new LinguisticResourceSet(lang, resources);
						for(ResourceType t:getEditableResources())
							resources.add(new LinguisticResource(set, t));
						return set;
					})
					.collect(Collectors.toList());
			return resourceSets;
		} else
			return Collections.EMPTY_LIST;
	}

	
	public Path getPath(LinguisticResource r, boolean createIfAbsent) {
		Lang l = LangUtil.getTermsuiteLang(r.getResourceSet().getLang());
		Path resPath = getCustomResourceDirectoryPath().resolve(r.getResourceType().getPath(l));
		if(!resPath.toFile().exists() && createIfAbsent) {
			resPath.getParent().toFile().mkdirs();
			try {
				FileUtils.copyURLToFile(
						r.getResourceType().fromClasspath(l), 
						resPath.toFile());
			} catch (IOException e) {
				String msg = String.format("Could not copy built-in linguistic resource %s to file %s. Cause %s: %s", 
						r.getResourceType().getPath(l),
						resPath.toString(),
						e.getClass().getSimpleName(),
						e.getMessage()
						);
				throw new TermSuiteException(msg, e);
			}
		}
		return resPath;
	}

	@Override
	public File asFile(LinguisticResource r, boolean createIfAbsent) {
		return getPath(r, createIfAbsent).toFile();
	}

	@Override
	public LinguisticResource getResourceFromString(String linguisticResourceString) {
		for(LinguisticResourceSet set:getResourceSets())
			for(LinguisticResource r:set.getResources())
				if(getResourceAsString(r).equals(linguisticResourceString))
					return r;
		throw new IllegalArgumentException("No linguistic resource with such serialized string value: " + linguisticResourceString);
	}

	private static final String RESOURCE_AS_STRING_FORMAT = "LingueeResource_%s_%s";
	@Override
	public String getResourceAsString(LinguisticResource linguisticResource) {
		return String.format(RESOURCE_AS_STRING_FORMAT, 
				linguisticResource.getResourceSet().getLang().getName(), 
				linguisticResource.getResourceType().toString());
	}

	public LinguisticResourceSet getResourceSet(ELang lang) {
		Preconditions.checkState(areCustomResourcesActivated(), "Operation only allowed when custom linguistic resources are enabled.");
		for(LinguisticResourceSet set:getResourceSets())
			if(set.getLang() == lang)
				return set;
		throw new IllegalArgumentException("No linguistic resource set found for lang " + lang);
	}

	@Override
	public ResourceConfig getResourceConfig(ELang lang) {
		ResourceConfig config = new ResourceConfig();
		if(areCustomResourcesActivated()) {
			for(LinguisticResource res:getResourceSet(lang).getResources()) {
				File file = asFile(res, false);
				if(file.exists())
					config.addCustomResourcePath(res.getResourceType(), getPath(res, true));
			}
		}
		return config;
	}
}
