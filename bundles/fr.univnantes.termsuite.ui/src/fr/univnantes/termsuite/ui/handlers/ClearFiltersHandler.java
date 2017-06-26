package fr.univnantes.termsuite.ui.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.parts.TerminologyPart;

public class ClearFiltersHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.ClearFilters";
	
	@Execute
	public void execute(MPart part, IEventBroker eventBroker) {
		((TerminologyPart) part.getObject()).getViewerConfig().setSearchString("");
		eventBroker.post(TermSuiteEvents.TERMINO_FILTER_CLEARED, null);
	}
	
	@CanExecute
	public boolean canExecute(MPart part) {
		return part != null && part.getObject() instanceof TerminologyPart;
	}

}
