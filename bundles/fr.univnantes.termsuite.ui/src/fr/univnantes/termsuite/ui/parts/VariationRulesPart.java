package fr.univnantes.termsuite.ui.parts;

import java.util.Map;

import fr.univnantes.termsuite.api.TerminologyStats;

public class VariationRulesPart extends StatsCounterPart {

	public static final String ID = "fr.univnantes.termsuite.ui.part.VariationRules";

	@Override
	protected Map<String, Integer> getCounters(TerminologyStats stats) {
		return stats.getRuleDistribution();
	}

}
