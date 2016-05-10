package fr.univnantes.termsuite.ui;

import java.io.IOException;

import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import fr.univnantes.termsuite.ui.logging.Slf4jLoggerWrapper;

@SuppressWarnings("restriction")
public class TermSuiteUIActivator implements BundleActivator {
	private ServiceRegistration<?> registration;
	@Override
	public void start(BundleContext context) throws Exception {
		initLogback();
		ILoggerProvider service = new ILoggerProvider() {
			@Override
			public org.eclipse.e4.core.services.log.Logger getClassLogger(Class<?> clazz) {
				return new Slf4jLoggerWrapper(LoggerFactory.getLogger(clazz));
			}
		};
		registration = context.registerService(ILoggerProvider.class, service, null);
		
	}

	private void initLogback() throws IOException {
		ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
		LoggerContext loggerContext = (LoggerContext) iLoggerFactory;
		loggerContext.reset();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(loggerContext);
		try {
			configurator.doConfigure(getClass().getResourceAsStream("/logback.xml"));
		} catch (JoranException e) {
			throw new IOException(e.getMessage(), e);
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		registration = null;
	}

}
