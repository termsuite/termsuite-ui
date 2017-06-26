package fr.univnantes.termsuite.ui.parts;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;

public abstract class StatsCounterPart extends StatsPart {

	@Override
	protected void computingNewStats(ETerminology termino) {
		setTerminoHeader(termino);
		while(table.getItemCount() > 1)
			table.remove(1);
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
	
	
	private Table table;
	
	@PostConstruct
	public void createControls(IEclipseContext context, final Composite parent, MPart part, EPartService partService) {
		table = new Table(parent, SWT.BORDER);
		new TableColumn(table, SWT.LEFT).setWidth(200);
		new TableColumn(table, SWT.RIGHT).setWidth(100);
		computeTitle();
	}

	private void computeTitle() {
		terminoNameItem = createItem(table, "Terminology");
		terminoNameItem.setFont(new Font( table.getDisplay(), new FontData( table.getFont().getFontData()[0].getName(), table.getFont().getFontData()[0].getHeight(), SWT.BOLD )));
	}

}
