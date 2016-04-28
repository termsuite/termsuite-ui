package fr.univnantes.termsuite.ui.services;

import eu.project.ttc.models.Term;
import eu.project.ttc.models.TermOccurrence;

public interface TermSuiteSelectionService {
	public TermOccurrence getActiveTermOccurrence();
	public Term getActiveTerm();
	public void setActiveTerm(Term scoredTerm);
	public void setActiveOccurrence(TermOccurrence termOccurrence);
}
