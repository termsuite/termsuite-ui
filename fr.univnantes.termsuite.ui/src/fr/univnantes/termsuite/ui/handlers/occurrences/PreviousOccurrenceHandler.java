package fr.univnantes.termsuite.ui.handlers.occurrences;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;

import fr.univnantes.termsuite.ui.TermSuiteEvents;

public class PreviousOccurrenceHandler {
	public static final String ID = "fr.univnantes.termsuite.ui.handler.PreviousOccurrenceHandler";

	@Inject
	IEventBroker eventBroker;
		
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part) {
		eventBroker.post(TermSuiteEvents.PREVIOUS_OCCURRENCE, part.getObject());
	}


}
