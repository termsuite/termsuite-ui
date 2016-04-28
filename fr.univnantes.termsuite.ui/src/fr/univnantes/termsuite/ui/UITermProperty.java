package fr.univnantes.termsuite.ui;

import java.util.Comparator;

import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;

import eu.project.ttc.engines.cleaner.TermProperty;
import eu.project.ttc.models.Term;
import eu.project.ttc.models.TermVariation;

public enum UITermProperty {
	TERM_RANK("#", "Rank of the term", TermProperty.RANK),
	TERM_GROUPING_KEY("Key", "The grouping key of the term", TermProperty.GROUPING_KEY),
	TERM_PILOT("Pilot", "The most frequent form of the term", TermProperty.PILOT),
	TERM_LEMMA("Lemma", "The lemmatized form of the term", TermProperty.LEMMA),
	FREQUENCY("Fr.", "Frequency of the term", TermProperty.FREQUENCY),
	SPECIFICITY("Spec.", "The specificity of the term", TermProperty.SPECIFICITY),
	DOCUMENT_FREQUENCY("D-Freq", "The document frequency", TermProperty.DOCUMENT_FREQUENCY),
	VARIATION_RULE("Rule", "The variation rule", null),
	VARIATION_TYPE("V-Type", "The variation type (graphical, morphological, syntactical)", null),
	TERM_PATTERN("Pattern", "The syntaxic pattern of the term", TermProperty.PATTERN),
//	TERM_INDEPENDANCE_SCORE("Ind.", "The independance of the term", true, Double.class),
	VARIATION_SCORE("V-Score", "Strictness of the variant", null);
//	VARIATION_INDEPENDANCE_SCORE("V-Ind", "The independance of the variant compared to the other variants of the same term", true, Double.class),
//	VARIATION_EXT_GAIN_SCORE("V-ExtGain", "The gain score of the extension of the variant", true, Double.class),
//	VARIATION_EXT_SPEC_SCORE("V-ExtSpec", "The specificity score of the extension of the variant", true, Double.class),
//	VARIATION_ORTHOGRAPHIC_SCORE("V-Orth", "The orthographic score of the variant", true, Double.class),
//	VARIATION_STRICTNESS_SCORE("V-Str", "Strictness of the variant", true, Double.class),
	;
	
	private String label;
	private String tooltip;
	private TermProperty termProperty;

	public TermProperty getTermProperty() {
		return termProperty;
	}
	
	
	private UITermProperty(String label, String tooltip, TermProperty property) {
		this.label = label;
		this.tooltip = tooltip;
		this.termProperty = property;
	}

	public String getLabel() {
		return label;
	}
	
	public String getTooltip() {
		return tooltip;
	}

	public Comparator<Term> getComparator(final boolean desc) {
		return new Comparator<Term>() {
			@Override
			public int compare(Term o1, Term o2) {
				return (desc ? 1 : -1 ) *ComparisonChain.start().compare(
						getValue(o2), 
						getValue(o1))
					.result();
			}
		};
		
	}

	public Comparable<?> getValue(Object termOrVariant) {
		try {
			switch (this) {
			case FREQUENCY: return asTerm(termOrVariant).getFrequency();
			case SPECIFICITY: return asTerm(termOrVariant).getSpecificity();
			case DOCUMENT_FREQUENCY: return asTerm(termOrVariant).getDocumentFrequency();
			case TERM_LEMMA:return asTerm(termOrVariant).getLemma();
			case TERM_GROUPING_KEY:return asTerm(termOrVariant).getGroupingKey();
			case TERM_PATTERN:return asTerm(termOrVariant).getPattern();
			case TERM_PILOT: return asTerm(termOrVariant).getPilot();
			case TERM_RANK: return asTerm(termOrVariant).getRank();
			case VARIATION_RULE: return asTermVariation(termOrVariant).getLabel();
			case VARIATION_TYPE: return asTermVariation(termOrVariant).getVariationType().getShortName();
			case VARIATION_SCORE: return asTermVariation(termOrVariant).getScore();
			default:
				return null;
			}
		} catch(ClassCastException e) {
			return null;
		}
	}
	
	public boolean isVariantProperty() {
		return this.termProperty == null;
	}
	
	private Term asTerm(Object termOrVariant) {
		if (termOrVariant instanceof TermVariation)
			return ((TermVariation) termOrVariant).getVariant();
		else
			return (Term)termOrVariant;
	}
	
	private TermVariation asTermVariation(Object termOrVariant) {
		return (TermVariation)termOrVariant;
	}


	public Class<?> getRange() {
		if(isVariantProperty()) {
			switch(this) {
			case VARIATION_RULE: return String.class;
			case VARIATION_TYPE: return String.class;
			case VARIATION_SCORE: return Double.class;
			default: throw new UnsupportedOperationException();
			}
		} else
			return getTermProperty().getRange();
	}


	public boolean isDecimalNumber() {
		return getRange().equals(Double.class) || getRange().equals(Float.class);
	}


	public boolean isNumber() {
		return Number.class.isAssignableFrom(getRange());
	}
}
