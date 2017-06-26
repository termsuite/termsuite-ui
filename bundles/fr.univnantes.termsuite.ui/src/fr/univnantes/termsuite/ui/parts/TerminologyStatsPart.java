
package fr.univnantes.termsuite.ui.parts;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.IPartListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.framework.service.TerminologyService;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.ETerminologyService;
import fr.univnantes.termsuite.ui.util.E4PartListener;

public class TerminologyStatsPart {

	public static final String ID = "fr.univnantes.termsuite.ui.part.TerminologyStats";
	
	private IPartListener partListener = new E4PartListener() {
		@Override
		public void partVisible(MPart part) {
			propagateTerminology(part);
		}
		
		public void partActivated(MPart part) {
			propagateTerminology(part);
		};
		
		@Override
		public void partBroughtToTop(MPart part) {
			propagateTerminology(part);
		}
	};

	private void propagateTerminology(MPart part) {
		if(part != null && part.getObject() != this && part.getContext().get(ETerminology.class) != null) 
			updateTerminology(part.getContext().get(ETerminology.class));
	}
	
	@Inject @Optional
	private void init(@UIEventTopic(TermSuiteEvents.EDITOR_INITIATED) Object o, MPart part) {
		if(part != null && o != this && part.getContext().get(ETerminology.class) != null) 
			updateTerminology(part.getContext().get(ETerminology.class));
	}

	
	@Inject private UISynchronize sync;
	@Inject private ETerminologyService eTerminologyService;

	
	private TableItem terminoName;
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

	@Inject
	void selectionChanged(@Named(IServiceConstants.ACTIVE_SELECTION) Object terminology) {
		if(terminology instanceof ETerminology)
			updateTerminology((ETerminology) terminology);
	}

	private void updateTerminology(ETerminology terminology) {
		sync.asyncExec(() -> setAll("-"));
		sync.asyncExec(() -> {
			terminoName.setText(1, TerminologyPart.toPartLabel(terminology));
			TerminologyStats stats = statCache.getUnchecked(terminology);
			if(stats != null)
			setStats(stats);
		});
	}
	
	/*
	 * A five sec cache for ensuring that multiple notifications 
	 * of active terminology change do not recompute multiple times the stats for nothing.
	 */
	LoadingCache<ETerminology, TerminologyStats> statCache = CacheBuilder.newBuilder()
			.expireAfterWrite(5, TimeUnit.SECONDS)
			.concurrencyLevel(1)
			.build(new CacheLoader<ETerminology, TerminologyStats>() {
				@Override
				public TerminologyStats load(ETerminology terminology) throws Exception {
					System.out.format("%s %s%n", terminology.getName(), new Date().toString());
					IndexedCorpus indexedCorpus = eTerminologyService.readTerminology(terminology);
					TerminologyService terminologyService = TermSuite.getTerminologyService(indexedCorpus);
					TerminologyStats stats = terminologyService.computeStats();
					return stats;
				}
			});

	private void setAll(String str) {
		TableItem[] allItems = new TableItem[]{terminoName, nbTermsItem, nbVariationsItem, nbWordsItem, nbCompoundWordsItem, nbSingleWords, nbSize2Words, nbSize3Words, nbSize6Words, nbSize5Words, nbSize4Words, nbExtensions, nbMorphological, nbDerivations, nbGraphical, nbSemantic, nbPrefixations, nbInfered, nbSemanticDistribOnly, nbSemanticWithDico};
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
	

	@PostConstruct
	public void createControls(IEclipseContext context, final Composite parent, MPart part, EPartService partService) {
		partService.addPartListener(partListener);
		Table table = new Table(parent, SWT.BORDER);
		new TableColumn(table, SWT.LEFT).setWidth(200);
		new TableColumn(table, SWT.RIGHT).setWidth(100);
		terminoName = createItem(table, "Terminology");
		terminoName.setFont(new Font( parent.getDisplay(), new FontData( parent.getFont().getFontData()[0].getName(), parent.getFont().getFontData()[0].getHeight(), SWT.BOLD )));
		
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
	}

	private TableItem createItem(Table table, String label) {
		TableItem item = new TableItem(table, SWT.NONE | SWT.BOLD);
		item.setText(0, label);
		return item;
	}
	
	@PreDestroy
	public void finalize(EPartService partService) {
		partService.removePartListener(partListener);
	}
	
		
}
