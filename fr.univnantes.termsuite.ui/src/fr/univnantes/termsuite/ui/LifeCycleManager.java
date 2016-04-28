package fr.univnantes.termsuite.ui;

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

import com.google.common.base.Joiner;

import fr.univnantes.termsuite.ui.services.AlignmentService;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.services.TermIndexService;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;
import fr.univnantes.termsuite.ui.services.TerminoService;
import fr.univnantes.termsuite.ui.services.impl.AlignmentServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.CorpusServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.PipelineServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.ResourceServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TaggerServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TermIndexServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TermSuiteSelectionServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.TerminoServiceImpl;

@SuppressWarnings("restriction")
public class LifeCycleManager {
	
	@PostContextCreate
	void postContextCreate(IApplicationContext context,  IEclipseContext cont,
			 @Preference(nodePath=TermSuiteUI.PLUGIN_ID) IEclipsePreferences preferences,
			 ILoggerProvider loggerProvider
			) {
		loggerProvider.getClassLogger(this.getClass()).info("----------------------------------------------------------------");
		loggerProvider.getClassLogger(this.getClass()).info("Starting TermSuite product");
		logContextualInfo(loggerProvider.getClassLogger(this.getClass()));

		cont.set(TermIndexService.class, ContextInjectionFactory.make(TermIndexServiceImpl.class, cont));
		cont.set(CorpusService.class, ContextInjectionFactory.make(CorpusServiceImpl.class, cont));
		cont.set(TerminoService.class, ContextInjectionFactory.make(TerminoServiceImpl.class, cont));
		cont.set(PipelineService.class, ContextInjectionFactory.make(PipelineServiceImpl.class, cont));
		cont.set(ResourceService.class, ContextInjectionFactory.make(ResourceServiceImpl.class, cont));
		cont.set(TaggerService.class, ContextInjectionFactory.make(TaggerServiceImpl.class, cont));
		cont.set(TermSuiteSelectionService.class, ContextInjectionFactory.make(TermSuiteSelectionServiceImpl.class, cont));
		cont.set(AlignmentService.class, ContextInjectionFactory.make(AlignmentServiceImpl.class, cont));

	}

	private static final String[] LOGGED_PROPS = new String[] {
			"java.version",
			"java.vendor",
			"file.separator",
			"os.arch",
			"os.name",
			"os.version",
			"eclipse.commands"
			
	};
	
	private void logContextualInfo(Logger l) {
		for(String p:LOGGED_PROPS)
			l.info(p + ": " + System.getProperty(p));
		l.info("Command line args: " + Joiner.on(" ").join(Platform.getCommandLineArgs()));
		l.info("Application args: " + Joiner.on(" ").join(Platform.getApplicationArgs()));
		
		BundleContext bundleContext = Platform.getBundle(TermSuiteUI.PLUGIN_ID).getBundleContext();
		
		for(Bundle bundle:bundleContext.getBundles()) {
			if(bundle.getSymbolicName().startsWith("fr.univnantes.termsuite"))
				l.info("Found bundle " +bundle.getSymbolicName() + ":" + bundle.getVersion());
		}
	}
}
