package fr.univnantes.termsuite.ui;

import java.nio.file.Paths;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import fr.univnantes.termsuite.ui.services.AlignmentService;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.services.TermIndexService;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;
import fr.univnantes.termsuite.ui.services.TerminoService;
import fr.univnantes.termsuite.ui.services.impl.AlignmentServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.CorpusServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.LinguisticResourcesServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.PipelineServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.ResourceServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TaggerServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TermIndexServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TermSuiteSelectionServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TerminoServiceImpl;
import fr.univnantes.termsuite.ui.util.FileUtil;

@SuppressWarnings("restriction")
public class LifeCycleManager {
	
	private Logger logger;
	
	@PostContextCreate
	void postContextCreate(IApplicationContext context,  IEclipseContext cont,
			 @Preference(nodePath=TermSuiteUI.PLUGIN_ID) IEclipsePreferences preferences,
			 ILoggerProvider loggerProvider
			) {
		this.logger = loggerProvider.getClassLogger(this.getClass());
		configureLogging();  
		logStartup();		
		logContextualInfo();
		addServicesToContext(cont);
		deleteTermSuiteTempFiles();
	}

	private void deleteTermSuiteTempFiles() {
		logger.debug("Removing TermSuite temp files");
		for(String file:FileUtil.removeTermSuiteTempFiles())
			logger.debug("Temp file removed: " + file);
	}

	private void addServicesToContext(IEclipseContext cont) {
		cont.set(LinguisticResourcesService.class, ContextInjectionFactory.make(LinguisticResourcesServiceImpl.class, cont));
		cont.set(TermIndexService.class, ContextInjectionFactory.make(TermIndexServiceImpl.class, cont));
		cont.set(CorpusService.class, ContextInjectionFactory.make(CorpusServiceImpl.class, cont));
		cont.set(TerminoService.class, ContextInjectionFactory.make(TerminoServiceImpl.class, cont));
		cont.set(PipelineService.class, ContextInjectionFactory.make(PipelineServiceImpl.class, cont));
		cont.set(ResourceService.class, ContextInjectionFactory.make(ResourceServiceImpl.class, cont));
		cont.set(TaggerService.class, ContextInjectionFactory.make(TaggerServiceImpl.class, cont));
		cont.set(TermSuiteSelectionService.class, ContextInjectionFactory.make(TermSuiteSelectionServiceImpl.class, cont));
		cont.set(AlignmentService.class, ContextInjectionFactory.make(AlignmentServiceImpl.class, cont));
	}

	private void logStartup() {
		logger.info("--------------------------------------------------------------------------------------------------------");
		logger.info("Starting TermSuite product");
	}

	private void configureLogging() {
		ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();  
		LoggerContext loggerContext = (LoggerContext) iLoggerFactory;  
		loggerContext.reset();  
		JoranConfigurator configurator = new JoranConfigurator();  
		configurator.setContext(loggerContext);  
		try {  
		  configurator.doConfigure(getClass().getResourceAsStream("/logback.xml"));  
		} catch (JoranException e) {
			logger.error(e);
		}
	}

	private static final String[] LOGGED_PROPS = new String[] {
			"java.version",
			"java.vendor",
			"file.separator",
			"os.arch",
			"os.name",
			"os.version"
	};
	
	private void logContextualInfo() {
		logger.info("Current directory: " + Paths.get(".").toAbsolutePath().normalize().toString());
		logger.info("Workspace location: " + Platform.getInstanceLocation().getURL().toString());
		logger.info("Install location: " + Platform.getInstallLocation().getURL().toString());
		for(String p:LOGGED_PROPS)
			logger.info(p + ": " + System.getProperty(p));
		logger.info("eclipse.commands: " + System.getProperty("eclipse.commands").replaceAll("[\n\r]+", " "));
		logger.info("Command line args: " + Joiner.on(" ").join(Platform.getCommandLineArgs()));
		logger.info("Application args: " + Joiner.on(" ").join(Platform.getApplicationArgs()));
		
		BundleContext bundleContext = Platform.getBundle(TermSuiteUI.PLUGIN_ID).getBundleContext();
		
		for(Bundle bundle:bundleContext.getBundles()) {
			if(bundle.getSymbolicName().startsWith("fr.univnantes.termsuite"))
				logger.info("Found bundle " +bundle.getSymbolicName() + ":" + bundle.getVersion());
		}
	}
}
