package fr.univnantes.termsuite.ui.events;

import java.util.List;

import fr.univnantes.termsuite.alignment.TranslationCandidate;
import fr.univnantes.termsuite.framework.service.TermService;

public class AlignmentResultPayload {
	private TermService term;
	private List<TranslationCandidate> translationCandidates;
	
	public TermService getTerm() {
		return term;
	}
	public void setTerm(TermService term) {
		this.term = term;
	}
	public List<TranslationCandidate> getTranslationCandidates() {
		return translationCandidates;
	}
	public void setTranslationCandidates(List<TranslationCandidate> translationCandidates) {
		this.translationCandidates = translationCandidates;
	}
}
