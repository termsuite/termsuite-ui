package fr.univnantes.termsuite.ui.parts;

import java.util.Map;

import fr.univnantes.termsuite.api.TerminologyStats;

public class TermPatternsPart extends StatsCounterPart {
	public static final String ID = "fr.univnantes.termsuite.ui.part.TermPatternsPart";

	@Override
	protected Map<String, Integer> getCounters(TerminologyStats stats) {
		return stats.getPatternDistribution();
	}
}
