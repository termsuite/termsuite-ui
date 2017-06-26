package fr.univnantes.termsuite.ui.parts;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.util.TermFilter;

public class TermPatternsPart extends StatsCounterPart {
	public static final String ID = "fr.univnantes.termsuite.ui.part.TermPatternsPart";

	@Override
	protected Map<String, Integer> getCounters(TerminologyStats stats) {
		return stats.getPatternDistribution();
	}
	
	@Inject private IEventBroker eventBroker;
	
	@Override
	protected void valuesSelected(List<String> values) {
		if(values.isEmpty()) {
			eventBroker.post(TermSuiteEvents.TERMINO_FILTER_CLEARED, null);
		} else {
			TermFilter filter = t -> values.contains(t.getPattern());
			eventBroker.post(TermSuiteEvents.NEW_TERM_FILTER, filter);
		}
	}
}
