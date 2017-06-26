package fr.univnantes.termsuite.ui.parts;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;

public abstract class StatsCounterPart extends StatsPart {

	@Override
	protected void computingNewStats(ETerminology termino) {
		setTerminoHeader(termino);
		table.removeAll();
	}

	protected abstract Map<String, Integer> getCounters(TerminologyStats stats);
	
	@Override
	protected void newStatsComputed(ETerminology termino, TerminologyStats stats) {
		setTerminoHeader(termino);
		List<Entry<String, Integer>> sortedEntries = Lists.newArrayList(getCounters(stats).entrySet());
		Collections.sort(sortedEntries, (e1,e2) -> Integer.compare(e2.getValue(), e1.getValue()));
		for(Map.Entry<String, Integer> e:sortedEntries) 
			createItem(table, e.getKey()).setText(1, Integer.toString(e.getValue()));
	}
	
}
