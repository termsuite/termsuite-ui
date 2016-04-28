package fr.univnantes.termsuite.ui;

import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.LoggerFactory;

import fr.univnantes.termsuite.ui.logging.Slf4jLoggerWrapper;

@SuppressWarnings("restriction")
public class TermSuiteUIActivator implements BundleActivator {
	private ServiceRegistration<?> registration;
	@Override
	public void start(BundleContext context) throws Exception {
		ILoggerProvider service = new ILoggerProvider() {
			@Override
			public org.eclipse.e4.core.services.log.Logger getClassLogger(Class<?> clazz) {
				return new Slf4jLoggerWrapper(LoggerFactory.getLogger(clazz));
			}
		};
		registration = context.registerService(ILoggerProvider.class, service, null);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		registration = null;
	}

}
