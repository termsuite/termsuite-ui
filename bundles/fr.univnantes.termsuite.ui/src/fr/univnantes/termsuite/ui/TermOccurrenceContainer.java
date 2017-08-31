package fr.univnantes.termsuite.ui;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;

import fr.univnantes.termsuite.model.TermOccurrence;

public class TermOccurrenceContainer<T> implements Comparable<TermOccurrenceContainer<T>>{
	private T container;
	private List<TermOccurrence> occurrences;

	public TermOccurrenceContainer(T form, List<TermOccurrence> occurrences) {
		super();
		Preconditions.checkNotNull(form);
		this.container = form;
		this.occurrences = occurrences;
	}
	public T getContainer() {
		return container;
	}
	public Integer getFrequency() {
		return occurrences.size();
	}
	
	@Override
	public int compareTo(TermOccurrenceContainer<T> o) {
		return ComparisonChain.start().
				compare(o.getFrequency(),getFrequency())
				.result();
	}
	public List<TermOccurrence> getOccurrences() {
		return occurrences;
	}
	
}
