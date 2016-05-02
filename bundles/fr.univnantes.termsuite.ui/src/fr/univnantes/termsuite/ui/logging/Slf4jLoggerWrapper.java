package fr.univnantes.termsuite.ui.logging;

import org.eclipse.e4.core.services.log.Logger;

@SuppressWarnings("restriction")
public class Slf4jLoggerWrapper extends Logger {

	private org.slf4j.Logger logger;

	public Slf4jLoggerWrapper(org.slf4j.Logger logger) {
		this.logger = logger;
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	@Override
	public void error(Throwable t, String message) {
		logger.error(message, t);
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	@Override
	public void warn(Throwable t, String message) {
		logger.warn(message, t);
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public void info(Throwable t, String message) {
		logger.info(message, t);
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	@Override
	public void trace(Throwable t, String message) {
		logger.trace(message, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public void debug(Throwable t) {
		logger.debug(null, t);
	}

	@Override
	public void debug(Throwable t, String message) {
		logger.debug(message, t);
	}
}