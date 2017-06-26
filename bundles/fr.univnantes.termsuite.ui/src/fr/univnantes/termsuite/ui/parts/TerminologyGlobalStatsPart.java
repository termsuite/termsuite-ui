
package fr.univnantes.termsuite.ui.parts;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;

import com.google.common.collect.Maps;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.framework.service.RelationService;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.util.TermFilter;
import fr.univnantes.termsuite.ui.util.VariationFilter;

public class TerminologyGlobalStatsPart extends StatsPart {

	public static final String ID = "fr.univnantes.termsuite.ui.part.TerminologyStats";
	
	private TableItem nbTermsItem;
	private TableItem nbVariationsItem;
	private TableItem nbWordsItem;
	private TableItem nbCompoundWordsItem;
	private TableItem nbSingleWords;
	private TableItem nbSize2Words;
	private TableItem nbSize3Words;
	private TableItem nbSize6Words;
	private TableItem nbSize5Words;
	private TableItem nbSize4Words;
	private TableItem nbExtensions;
	private TableItem nbMorphological;
	private TableItem nbDerivations;
	private TableItem nbGraphical;
	private TableItem nbSemantic;
	private TableItem nbPrefixations;
	private TableItem nbInfered;
	private TableItem nbSemanticDistribOnly;
	private TableItem nbSemanticWithDico;

	private void setAll(String str) {
		TableItem[] allItems = new TableItem[]{nbTermsItem, nbVariationsItem, nbWordsItem, nbCompoundWordsItem, nbSingleWords, nbSize2Words, nbSize3Words, nbSize6Words, nbSize5Words, nbSize4Words, nbExtensions, nbMorphological, nbDerivations, nbGraphical, nbSemantic, nbPrefixations, nbInfered, nbSemanticDistribOnly, nbSemanticWithDico};
		for(TableItem tableItem:allItems)
			tableItem.setText(1, str);
	}
	
	private void setStats(TerminologyStats stats) {
		nbTermsItem.setText(1, Integer.toString(stats.getNbTerms()));
		nbVariationsItem.setText(1, Integer.toString(stats.getNbVariations()));
		nbWordsItem.setText(1, Integer.toString(stats.getNbWords()));
		nbCompoundWordsItem.setText(1, Integer.toString(stats.getNbCompounds()));
		nbSingleWords.setText(1, Integer.toString(stats.getNbSingleWords()));
		nbSize2Words.setText(1, Integer.toString(stats.getNbSize2Words()));
		nbSize3Words.setText(1, Integer.toString(stats.getNbSize3Words()));
		nbSize4Words.setText(1, Integer.toString(stats.getNbSize4Words()));
		nbSize5Words.setText(1, Integer.toString(stats.getNbSize5Words()));
		nbSize6Words.setText(1, Integer.toString(stats.getNbSize6Words()));
		nbExtensions.setText(1, Integer.toString(stats.getNbExtensions()));
		nbMorphological.setText(1, Integer.toString(stats.getNbMorphological()));
		nbDerivations.setText(1, Integer.toString(stats.getNbDerivations()));
		nbPrefixations.setText(1, Integer.toString(stats.getNbPrefixations()));
		nbGraphical.setText(1, Integer.toString(stats.getNbGraphical()));
		nbSemantic.setText(1, Integer.toString(stats.getNbSemantic()));
		nbInfered.setText(1, Integer.toString(stats.getNbInfered()));
		nbSemanticWithDico.setText(1, Integer.toString(stats.getNbSemanticWithDico()));
		nbSemanticDistribOnly.setText(1, Integer.toString(stats.getNbSemanticDistribOnly()));
	}

	@Override
	protected void tableCreated() {
		nbTermsItem = createItem(table, "Terms");
		nbWordsItem = createItem(table, "Words");
		nbCompoundWordsItem = createItem(table, "Compound words");
		nbSingleWords = createItem(table, "Singe-word terms");
		nbSize2Words = createItem(table, "Size-2 terms");
		nbSize3Words = createItem(table, "Size-3 terms");
		nbSize4Words = createItem(table, "Size-4 terms");
		nbSize5Words = createItem(table, "Size-5 terms");
		nbSize6Words = createItem(table, "Size-6 terms");
		nbVariationsItem = createItem(table, "Variations");
		nbInfered = createItem(table, "Infered variations");
		nbExtensions = createItem(table, "Extensions");
		nbMorphological = createItem(table, "Morphological variations");
		nbDerivations = createItem(table, "Derivations");
		nbPrefixations = createItem(table, "Prefixations");
		nbGraphical = createItem(table, "Graphical variations");
		nbSemantic = createItem(table, "Semantic variations");
		nbSemanticWithDico = createItem(table, "Semantic var. with dico");
		nbSemanticDistribOnly = createItem(table, "Semantic var. distrib.");
		
		setFilters();
	}
	
	private void setFilters() {
		termFilters.put(nbCompoundWordsItem, t -> t.isCompound());
		termFilters.put(nbSingleWords, t -> t.isSingleWord());
		termFilters.put(nbSize2Words, t -> t.getSwts().count() == 2);
		termFilters.put(nbSize3Words, t -> t.getSwts().count() == 3);
		termFilters.put(nbSize4Words, t -> t.getSwts().count() == 4);
		termFilters.put(nbSize5Words, t -> t.getSwts().count() == 5);
		termFilters.put(nbSize6Words, t -> t.getSwts().count() == 6);
		variationFilters.put(nbInfered, RelationService::isInfered);
		variationFilters.put(nbExtensions, RelationService::isExtension);
		variationFilters.put(nbMorphological, RelationService::isMorphological);
		variationFilters.put(nbDerivations, RelationService::isDerivation);
		variationFilters.put(nbPrefixations, RelationService::isPrefixation);
		variationFilters.put(nbGraphical, RelationService::isGraphical);
		variationFilters.put(nbSemantic, RelationService::isSemantic);
		variationFilters.put(nbSemanticWithDico, v -> v.isSemantic() && v.isDico());
		variationFilters.put(nbSemanticDistribOnly, v -> v.isSemantic() && !v.isDico());
	}

	@Override
	protected void itemsSelected(List<TableItem> selection) {
		if(selection.isEmpty())
			eventBroker.post(TermSuiteEvents.TERMINO_FILTER_CLEARED, null);
		else {
			TableItem selectedItem = selection.get(0);
			if(termFilters.containsKey(selectedItem))
				eventBroker.post(TermSuiteEvents.NEW_TERM_FILTER, termFilters.get(selectedItem));
			else if(variationFilters.containsKey(selectedItem))
				eventBroker.post(TermSuiteEvents.NEW_VARIATION_FILTER, variationFilters.get(selectedItem));
		}
	}
	
	@Inject private IEventBroker eventBroker;
	
	private Map<TableItem, TermFilter> termFilters = Maps.newConcurrentMap();
	private Map<TableItem, VariationFilter> variationFilters = Maps.newConcurrentMap();
	
	@Override
	protected void newStatsComputed(ETerminology termino, TerminologyStats stats) {
		setTerminoHeader(termino);
		setStats(stats);
	}
	@Override
	protected void computingNewStats(ETerminology termino) {
		setTerminoHeader(termino);
		setAll("-");
	}

	@Override
	protected int getSelectionStyle() {
		return SWT.SINGLE;
	}
}
