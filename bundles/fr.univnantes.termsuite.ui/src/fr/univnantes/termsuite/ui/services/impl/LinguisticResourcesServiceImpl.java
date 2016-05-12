package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.util.FileUtil;
import fr.univnantes.termsuite.ui.util.LangUtil;
import fr.univnantes.termsuite.ui.util.LinguisticResourceUtil;
import fr.univnantes.termsuite.ui.util.ValidationException;
import fr.univnantes.termsuite.ui.util.WorkspaceUtil;

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

	@Override
	public Bundle getLinguisticResourceBundle() {
		if(this.withCustomResources) 
			return getCustomResourcesBundle();
		else 
			return getBuiltinResourcesBundle();
	}
	
	private Bundle getCustomResourcesBundle(){
		Preconditions.checkState(this.withCustomResources, "Custom resources are not activated");
		if(this.customResourcesBundle == null) {
			this.customResourcesBundle = loadCustomResourcesToClasspath();
			
		}
		return this.customResourcesBundle;
	}
	
	public Bundle loadCustomResourcesToClasspath() {
		Preconditions.checkState(withCustomResources, "The use of custom resources is not allowed");
		logger.info("Stopping built-in linguistic resources from classpath");
		try {
			
			Bundle bundle = getBuiltinResourcesBundle();
			bundle.stop();
		} catch (Exception e) {
			logger.error(e);
			logger.error("Built-in linguistic resources could not be unloaded.");
			logger.warn("Using built-in resources instead of custom resources.");
			MessageDialog.openError(
					(Shell)context.get(IServiceConstants.ACTIVE_SHELL), 
					"Error",
					"Custom linguistic resources could not be loaded. Using built-in resources instead of custom resources.");
			return null;
		}
		try {
			logger.info("Loading custom linguistic resources at "+customResourcePath+" to classpath");
			Bundle bundle = getBundleCtx().installBundle("reference:file:" + this.customResourcePath);
			bundle.start();
			return bundle;
		} catch (Exception e) {
			logger.error(e);
			logger.error("Custom linguistic resources could not be loaded.");
			logger.warn("Reloading built-in resources instead of custom resources.");
			try {
				 getBuiltinResourcesBundle().start();
			} catch (BundleException e1) {
				logger.error("Unable to restart the built-in resources plugin " + getBuiltinResourcesBundle().getSymbolicName());
				logger.error(e);
			}
			MessageDialog.openError(
					(Shell)context.get(IServiceConstants.ACTIVE_SHELL), 
					"Error",
					"Custom linguistic resources could not be loaded. Using built-in resources instead of custom resources.");
			return null;
		}
	}

	private Bundle getBuiltinResourcesBundle() {
		return Platform.getBundle(TermSuiteUI.PLUGIN_TERMSUITE_RESOURCES_ID);
	}

	private BundleContext getBundleCtx() {
		return Platform.getBundle(TermSuiteUI.PLUGIN_ID).getBundleContext();
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
				resourceSets = LinguisticResourceUtil.getLinguisticResourceSets(
						this.customResourcePath, 
						this.copyIfEmpty);
				if(resourceSets.isEmpty() && this.copyIfEmpty) {
					logger.info("Custom resource path is empty. Copying built-in resources to directory: " + customResourcePath);
					if(!createLinguisticResourceDirectory())
						logger.warn("Custom resource directory could not be created");
					else {
						/*
						 * Resources have been copied. Reloads the resource sets.
						 */
						resourceSets = LinguisticResourceUtil.getLinguisticResourceSets(
								this.customResourcePath, 
								false);
					}
				} 
				ensureMetainfPresent(this.customResourcePath);
				logger.debug(resourceSets.size() + " resource sets loaded from path: " + customResourcePath);
			} catch(ValidationException e) {
				logger.error("Could not load resources", e);
				return Lists.newArrayList();
			}
		}
		return resourceSets;
	}

	private void ensureMetainfPresent(String customResourcePath) {
		try {
			Path metaInf = Paths.get(customResourcePath, "META-INF");
			if(metaInf.toFile().exists()) {
				logger.debug("META-INF/ directory found at " + customResourcePath);
				Preconditions.checkArgument(metaInf.toFile().isDirectory(), "META-INF is not a directory");
			} else 
				metaInf.toFile().mkdirs();
	
			Path manifest = Paths.get(customResourcePath, "META-INF", "MANIFEST.MF");
			if(manifest.toFile().exists()) {
				logger.info("META-INF/MANIFEST.MF file found at " + customResourcePath);
				Preconditions.checkArgument(manifest.toFile().isFile(), "MANIFEST.MF is not a file");
			} else  {
				URL skeletonURL = new URL("platform:/plugin/"+TermSuiteUI.PLUGIN_ID+"/resources/MANIFEST.MF.skeleton");
			    
				logger.info("Creating META-INF/MANIFEST.MF file found at " + customResourcePath);
				ByteStreams.copy(skeletonURL.openStream(), new FileOutputStream(manifest.toFile()));
			}
		} catch (Exception e) {
			logger.error("Could not create the META-INF/MANIFEST.MF file");
			logger.error(e);
		}

	}

	private boolean createLinguisticResourceDirectory() {
		try {
			Stopwatch swTotal = Stopwatch.createStarted();
			logger.info("Creating a custom resource directory at " + this.customResourcePath);
			URL resourceJarUrl = new URL("platform:/plugin/"+TermSuiteUI.PLUGIN_TERMSUITE_RESOURCES_ID+"/termsuite-resources.jar");
			File tmpJarFile = File.createTempFile("termsuite-resources", ".jar", WorkspaceUtil.getTempDir());
			FileUtil.inputStreamToFile(
					resourceJarUrl.openConnection().getInputStream(), 
					tmpJarFile);
			
			JarFile jarFile = new JarFile(tmpJarFile);
			Enumeration<JarEntry> enumEntries = jarFile.entries();
			while (enumEntries.hasMoreElements()) {
			    JarEntry srcFile = enumEntries.nextElement();
			    if(!isResourceNameValid(srcFile.getName()))
			    	continue;
			    java.io.File targetFile = new java.io.File(this.customResourcePath + java.io.File.separator + srcFile.getName());
				if(srcFile.isDirectory()) {
					targetFile.mkdir();
					continue;
			    }
			    InputStream is = jarFile.getInputStream(srcFile); // get the input stream
			    FileOutputStream fos = new java.io.FileOutputStream(targetFile);
			    ByteStreams.copy(is, fos);
			    fos.close();
			    is.close();
			}
			jarFile.close();
			tmpJarFile.deleteOnExit();
			swTotal.stop();
			logger.debug("Total jar extraction time: " + swTotal.elapsed(TimeUnit.MILLISECONDS) + "ms" );
			return true;
		} catch (Exception e) {
			logger.error("Could not intiliaze custom resource directory from built-in termsuite-resources.jar");
			logger.error(e);
			return false;
		}
	}

	
	private boolean isResourceNameValid(String name) {
	    for(String allowedStartPattern:LangUtil.getSupportedLanguagesAsResourcePatterns()) {
	    	if(name.startsWith(allowedStartPattern))
	    		return true;
	    }
	    return false;
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
	
}
