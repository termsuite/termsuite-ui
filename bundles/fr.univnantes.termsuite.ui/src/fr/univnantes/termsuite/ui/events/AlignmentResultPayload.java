package fr.univnantes.termsuite.ui.events;

import java.util.List;

import fr.univnantes.termsuite.alignment.TranslationCandidate;
import fr.univnantes.termsuite.model.Term;

public class AlignmentResultPayload {
	private Term term;
	private List<TranslationCandidate> translationCandidates;
	
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	public List<TranslationCandidate> getTranslationCandidates() {
		return translationCandidates;
	}
	public void setTranslationCandidates(List<TranslationCandidate> translationCandidates) {
		this.translationCandidates = translationCandidates;
	}
}
