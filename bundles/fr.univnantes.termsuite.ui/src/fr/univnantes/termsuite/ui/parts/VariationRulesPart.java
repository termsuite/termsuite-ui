package fr.univnantes.termsuite.ui.parts;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.util.VariationFilter;

public class VariationRulesPart extends StatsCounterPart {

	public static final String ID = "fr.univnantes.termsuite.ui.part.VariationRules";

	@Inject private IEventBroker eventBroker;

	@Override
	protected Map<String, Integer> getCounters(TerminologyStats stats) {
		return stats.getRuleDistribution();
	}

	@Override
	protected void valuesSelected(List<String> values) {
		if(values.isEmpty()) {
			eventBroker.post(TermSuiteEvents.TERMINO_FILTER_CLEARED, null);
		} else {
			VariationFilter filter = v -> v.getVariationRules().stream().anyMatch(vRule -> values.contains(vRule));
			eventBroker.post(TermSuiteEvents.NEW_VARIATION_FILTER, filter);
		}
	}

}
