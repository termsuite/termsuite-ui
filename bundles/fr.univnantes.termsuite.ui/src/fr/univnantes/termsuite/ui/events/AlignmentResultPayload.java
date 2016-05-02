package fr.univnantes.termsuite.ui.events;

import java.util.List;

import eu.project.ttc.engines.BilingualAligner.TranslationCandidate;
import eu.project.ttc.models.Term;

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
