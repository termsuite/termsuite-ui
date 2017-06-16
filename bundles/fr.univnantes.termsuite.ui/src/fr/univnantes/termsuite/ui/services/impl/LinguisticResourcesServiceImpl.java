package fr.univnantes.termsuite.ui.services.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import fr.univnantes.termsuite.api.ResourceConfig;
import fr.univnantes.termsuite.tools.ResourceExporter;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.util.LinguisticResourceUtil;
import fr.univnantes.termsuite.ui.util.ValidationException;

@SuppressWarnings("restriction")
public class LinguisticResourcesServiceImpl implements LinguisticResourcesService {

	@Inject
	@Preference(value = TermSuiteUIPreferences.ACTIVATE_CUSTOM_RESOURCES)
	private boolean withCustomResources = false;

	@Inject
	@Preference(value = TermSuiteUIPreferences.COPY_BUILTIN_RESOURCES_IF_EMPTY)
	private boolean copyIfEmpty = false;

	@Inject
	@Preference(value = TermSuiteUIPreferences.LINGUISTIC_RESOURCES_DIRECTORY)
	private String customResourcePath;
	
	@Inject
	IEclipseContext context;

	/*
	 * Cache fields
	 */
	private Map<String, ELinguisticResource> resourcesByPath = null;
	private Collection<ELinguisticResourceSet> resourceSets = null;
	private Bundle customResourcesBundle = null;

	Logger logger;
	
	@PostConstruct
	public void init(ILoggerProvider loggerProvider) {
		this.logger = loggerProvider.getClassLogger(LinguisticResourcesServiceImpl.class);
		logger.debug("Loading service " + LinguisticResourcesServiceImpl.class);		
	}
	
	private void resetCache() {
		customResourcesBundle = null;
		resourcesByPath = null;
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
		if(this.withCustomResources == false) {
			this.unloadCustomResourcesFromClasspath();
		}
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
			LinguisticResourcesService lingueeService, 
			@Preference(value = TermSuiteUIPreferences.LINGUISTIC_RESOURCES_DIRECTORY) String customResourcePath
			) {
		this.customResourcePath = customResourcePath;
		logger.debug("Modification detected in preferences: customResourcePath is " + this.customResourcePath);
		resetCache();
	}

	private Bundle getBuiltinResourcesBundle() {
		return Platform.getBundle(TermSuiteUI.PLUGIN_TERMSUITE_RESOURCES_ID);
	}

	public void unloadCustomResourcesFromClasspath() {
		if(customResourcesBundle != null)
			try {
				logger.info("Unloading custom linguistic resources ["+customResourcePath+"] from classpath");
				customResourcesBundle.stop();
				logger.info("Loading built-in linguistic resources to classpath");
				getBuiltinResourcesBundle().start();
			} catch (BundleException e) {
				logger.error("Could not reload custom resources.");
				logger.error(e);
				MessageDialog.openError(
						(Shell)context.get(IServiceConstants.ACTIVE_SHELL), 
						"Error",
						"Custom linguistic resources could not be loaded. Using built-in resources instead of custom resources.");
			}
	}

	@Override
	public Collection<ELinguisticResourceSet> getLinguisticResourceSets() {
		Preconditions.checkState(withCustomResources, "The use of custom resources is not allowed");
		
		if(resourceSets == null) {
			try {
				logger.info("Creating a custom resource directory at " + this.customResourcePath);
					new ResourceExporter().exportTo(Paths.get(this.customResourcePath));
				resourceSets = LinguisticResourceUtil.getLinguisticResourceSets(this.customResourcePath, false);
				logger.debug(resourceSets.size() + " resource sets loaded from path: " + customResourcePath);
			} catch(ValidationException e) {
				logger.error("Could not load resources", e);
				return Lists.newArrayList();
			} catch (IOException e) {
				logger.error("Unable to create linguistic resource directory");
				return Lists.newArrayList();
			}
		}
		return resourceSets;
	}

	@Override
	public ELinguisticResource getResource(String path) {
		Preconditions.checkState(withCustomResources, "The use of custom resources is not allowed");
		if(resourcesByPath == null) {
			resourcesByPath = Maps.newHashMap();
			for(ELinguisticResourceSet resourceSet:getLinguisticResourceSets())
				for(ELinguisticResource linguisticResource:resourceSet.getResources())
					resourcesByPath.put(linguisticResource.getPath(), linguisticResource);
		}
		return resourcesByPath.get(path);
	}

	@Override
	public boolean areCustomResourcesActivated() {
		return withCustomResources;
	}

	@Override
	public Path getCustomResourcesPath() {
		Preconditions.checkState(withCustomResources, "Custom resources are not activated");
		return Paths.get(this.customResourcePath);
	}

	@Override
	public ResourceConfig getResourceConfig() {
		ResourceConfig config = new ResourceConfig();
		if(areCustomResourcesActivated())
			config.addDirectory(getCustomResourcesPath());
		return config;
	}
}
