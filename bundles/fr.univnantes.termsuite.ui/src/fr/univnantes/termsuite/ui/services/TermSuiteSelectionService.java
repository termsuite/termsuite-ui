package fr.univnantes.termsuite.ui.services;

import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.model.TermOccurrence;

public interface TermSuiteSelectionService {
	public TermOccurrence getActiveTermOccurrence();
	public TermService getActiveTerm();
	public void setActiveTerm(TermService scoredTerm);
	public void setActiveOccurrence(TermOccurrence termOccurrence);
}
