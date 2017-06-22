package fr.univnantes.termsuite.ui.services.impl;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;

import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.model.TermOccurrence;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;

public class TermSuiteSelectionServiceImpl implements TermSuiteSelectionService {

	@Inject
	private IEventBroker eventBroker;
	
	private TermService activeTerm = null;
	private TermOccurrence activeTermOccurrence = null;
	
	@Override
	public void setActiveTerm(TermService term) {
		this.activeTerm = term;
		eventBroker.post(TermSuiteEvents.ACTIVE_TERM, term);

	}

	@Override
	public void setActiveOccurrence(TermOccurrence termOccurrence) {
		this.activeTermOccurrence = termOccurrence;
		eventBroker.post(TermSuiteEvents.ACTIVE_TERM_OCCURRENCE, termOccurrence);
	}

	@Override
	public TermOccurrence getActiveTermOccurrence() {
		return this.activeTermOccurrence;
	}

	@Override
	public TermService getActiveTerm() {
		return this.activeTerm;
	}

}
