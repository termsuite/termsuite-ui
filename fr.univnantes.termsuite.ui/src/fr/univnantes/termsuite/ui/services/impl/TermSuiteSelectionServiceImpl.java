package fr.univnantes.termsuite.ui.services.impl;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;

import eu.project.ttc.models.Term;
import eu.project.ttc.models.TermOccurrence;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;

public class TermSuiteSelectionServiceImpl implements TermSuiteSelectionService {

	@Inject
	IEventBroker eventBroker;
	
	private Term activeTerm = null;
	private TermOccurrence activeTermOccurrence = null;
	
	@Override
	public void setActiveTerm(Term term) {
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
	public Term getActiveTerm() {
		return this.activeTerm;
	}

}
