package fr.univnantes.termsuite.ui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TreeColumn;

import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.framework.service.TerminologyService;
import fr.univnantes.termsuite.index.Terminology;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.model.RelationProperty;
import fr.univnantes.termsuite.model.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.controls.DelayableText;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import fr.univnantes.termsuite.ui.services.ETerminologyService;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;
import fr.univnantes.termsuite.ui.util.PropertyUtil;
import fr.univnantes.termsuite.ui.util.TermFilter;
import fr.univnantes.termsuite.ui.util.VariationFilter;
import fr.univnantes.termsuite.ui.util.treeviewer.TreePart;
import fr.univnantes.termsuite.ui.viewers.TermLabelProvider;
import fr.univnantes.termsuite.ui.viewers.TermSelectionListener;
import fr.univnantes.termsuite.ui.viewers.TerminologyViewer;

public class TerminologyPart implements TreePart {
	
	public static final String ID = "fr.univnantes.termsuite.ui.partdescriptor.terminology";
	public static final String POPUP_MENU_ID = "fr.univnantes.termsuite.ui.popupmenu.terminology";

	private TerminologyViewer viewer;
	private ETerminoViewerConfig viewerConfig;

	@Inject
	private IEclipseContext context;
	
	@Inject
	private IEventBroker eventBroker; 

	@Inject 
	private EMenuService menuService;
	
	@Inject 
	private ETerminologyService eTerminologyService;
	
	@Inject
	TermSuiteSelectionService termSuiteSelectionService;

	@Inject
	private UISynchronize sync;

	private DelayableText numOfTermsToShow;
	private TreeColumnLayout layout;
	private Label totalDisplayedTerms;
	private DelayableText searchText;
	
	@PostConstruct
	public void createControls(final IEclipseContext context, 
			final ESelectionService selectionService,
			final EMenuService menuService,
			final EPartService partService,
			final Composite parent, MPart part) {
		parent.setLayout(new GridLayout(7, false));

		viewerConfig = createDefaultViewerConfig();
		context.set(ETerminoViewerConfig.class, viewerConfig);
		this.eventBroker.subscribe(
				TermSuiteEvents.SEARCH_TEXT_MODIFIED, 
				event -> viewerConfig.setSearchString((String)event.getProperty(IEventBroker.DATA))
			);
		viewerConfig.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if(msg.getFeatureID(ETerminoViewerConfig.class) == TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES) {
					switch(msg.getEventType()) {
					case Notification.REMOVE:
						Property<?> removedProperty = PropertyUtil.forName(msg.getOldStringValue());
						for(TreeColumn column:viewer.getTree().getColumns()) {
							if(column.getData().equals(removedProperty))
								column.dispose();
						}
						break;
					case Notification.ADD:
						createColumn(PropertyUtil.forName(msg.getNewStringValue()));
					}
					viewer.getControl().getParent().layout();
				}
			}
		});

		
		// populate headers
	    createFilterHeader(parent);
	    
		// populate viewer
	    Composite container = new Composite(parent, SWT.None);
	    GridDataFactory.fillDefaults().span(7, 1).grab(true, true).applyTo(container);
		createViewer(container);
		
		viewer.getNbTermsDisplayed().addChangeListener(e -> {
			ETerminology eTerminology = context.get(ETerminology.class);
			totalDisplayedTerms.setText(getTotalText(
					viewer.getNbTermsDisplayed().getValue(),
					eTerminologyService.readTerminology(eTerminology).getTerminology().getTerms().size()));
		});
	}

	private String getTotalText(int nbDisplay, int nbTotal) {
		return String.format(
				"%d - Number of terms in terminology: %d", 
				nbDisplay, 
				nbTotal);
	}
	
	private void createViewer(Composite container) {
		
		layout = new TreeColumnLayout(true);
		container.setLayout(layout);
		this.viewer = new TerminologyViewer(viewerConfig, container, SWT.SINGLE| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		GridDataFactory.fillDefaults().span(4, 1).grab(true, true).applyTo(viewer.getControl());
        
		for(String pName:viewerConfig.getSelectedPropertyNames()) 
			createColumn(PropertyUtil.forName(pName));
		viewerConfig.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeatureID(ETerminoViewerConfig.class) == TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING
					&& msg.getNewValue() != null && !msg.getNewValue().toString().isEmpty())
					/*
					 * This is a non empty search string filter. Expand all nodes
					 * in order to make selected variant appear.
					 */
					viewer.expandToLevel(1);

			}
		});
		
		// attach a selection listener to our jface viewer
		TermSelectionListener listener = ContextInjectionFactory.make(TermSelectionListener.class, context);
		viewer.addSelectionChangedListener(listener);
		  
		menuService.registerContextMenu(viewer.getControl(), POPUP_MENU_ID);
	}

	private ColumnLayoutData getRecommendedSize(Property<?> property) {
		if(property == TermProperty.PILOT || property == TermProperty.GROUPING_KEY ) 
			return new ColumnWeightData(100, 100, true);
		else if(property == RelationProperty.VARIATION_RULES) 
			return new ColumnPixelData(100, true, true);
		else if(property.getRange().equals(Boolean.class)) 
			return new ColumnPixelData(40, true, true);
		else if(property.getRange().equals(String.class)) 
			return new ColumnPixelData(70, true, true);
		else
			return new ColumnPixelData(50,true, true);
	}

	private ETerminoViewerConfig createDefaultViewerConfig() {
		ETerminoViewerConfig viewerConfig = TermsuiteuiFactory.eINSTANCE.createETerminoViewerConfig();
		viewerConfig.setSortingPropertyName(TermProperty.RANK.getJsonField());
		viewerConfig.setSortingAsc(true);
		viewerConfig.setSearchString("");
		viewerConfig.setNbDisplayedTerms(100);
		viewerConfig.getSelectedPropertyNames().add(TermProperty.RANK.getPropertyName());
		viewerConfig.getSelectedPropertyNames().add(TermProperty.PILOT.getPropertyName());
		viewerConfig.getSelectedPropertyNames().add(TermProperty.PATTERN.getPropertyName());
		viewerConfig.getSelectedPropertyNames().add(TermProperty.SPECIFICITY.getPropertyName());
		viewerConfig.getSelectedPropertyNames().add(TermProperty.FREQUENCY.getPropertyName());
		viewerConfig.getSelectedPropertyNames().add(TermProperty.DOCUMENT_FREQUENCY.getPropertyName());
		viewerConfig.getSelectedPropertyNames().add(RelationProperty.VARIATION_RULES.getPropertyName());
		return viewerConfig;
	}


	public ETerminoViewerConfig getViewerConfig() {
		return viewerConfig;
	}
	
	/*
	 * Good link for TreeViewerColumn applications :
	 * 
	 * http://www.programcreek.com/java-api-examples/index.php?api=org.eclipse.jface.viewers.TreeViewerColumn
	 */
	private TreeViewerColumn createColumn(final Property<?> property) {
		TreeViewerColumn column1 = new TreeViewerColumn(viewer, property.getRange().equals(String.class) ? SWT.LEFT : SWT.RIGHT);
		column1.setLabelProvider(new DelegatingStyledCellLabelProvider(new TermLabelProvider(property, viewerConfig)));
		column1.getColumn().setMoveable(true);
		column1.getColumn().setData(property);
		column1.getColumn().setText(property.getPropertyName());
		column1.getColumn().setToolTipText(String.format("%s%n%s", property.getPropertyName(), property.getDescription()));
		if(property instanceof TermProperty && property.isNumeric()) {
			column1.getColumn().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					/*
					 * Good link to Sort examples
					 * 
					 * http://www.programcreek.com/java-api-examples/index.php?api=org.eclipse.jface.viewers.TreeViewerColumn
					 */
					updateSortingProperty(property);
					viewer.refresh();
				}
			});
		}
		layout.setColumnData(column1.getColumn(), getRecommendedSize(property));
		return column1;
	}

	private Property<?> sortingProperty = TermProperty.RANK;
	boolean desc = false;
	
	private void updateSortingProperty(Property<?> property) {
		if(sortingProperty == property) 
			this.desc = !desc;
		else {
			this.sortingProperty = property;
			this.desc = true;
		}
		viewerConfig.setSortingPropertyName(sortingProperty.getJsonField());
		viewerConfig.setSortingAsc(!desc);

	}
	private void createFilterHeader(Composite infoContainer) {
		// maxNumOfterm filter
	    Label label = new Label(infoContainer, SWT.NONE);
	    label.setText("Showing");
		GridDataFactory.fillDefaults().grab(false, false).applyTo(label);
		numOfTermsToShow = new DelayableText(500, infoContainer, SWT.NONE);
		numOfTermsToShow.setText(Integer.toString(viewerConfig.getNbDisplayedTerms()));
		GridDataFactory.fillDefaults().hint(50, SWT.DEFAULT).grab(false, false).applyTo(numOfTermsToShow);
		numOfTermsToShow.addDelayedModificationListener(e -> {
			sync.asyncExec(() -> {
				try {
					int maxTerms = Integer.parseInt(((DelayableText)e.getSource()).getText());
					viewerConfig.setNbDisplayedTerms(maxTerms);
				} catch(NumberFormatException nfe) {}
			});
		});
		label = new Label(infoContainer, SWT.NONE);
	    label.setText("terms on ");
		GridDataFactory.fillDefaults().grab(false, false).applyTo(label);
		totalDisplayedTerms = new Label(infoContainer, SWT.NONE);
		totalDisplayedTerms.setText(getTotalText(100000,100000));
		GridDataFactory.fillDefaults().grab(false, false).applyTo(totalDisplayedTerms);
		Button clearButton = new Button(infoContainer, SWT.PUSH);
		clearButton.setImage(TermSuiteUI.getImg(TermSuiteUI.IMG_CLEAR_CO).createImage());
		clearButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clearFilters(null);
			}
		});
		
		// The search filter
		Label searchLabel = new Label(infoContainer, SWT.NONE);
	    searchLabel.setText("Search:");
		GridDataFactory.fillDefaults().grab(false, false).applyTo(searchLabel);
		searchText = new DelayableText(1000, infoContainer, SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL | SWT.BORDER);
		searchText.setMessage("Search");
		GridDataFactory.fillDefaults().hint(150, SWT.DEFAULT).grab(true, false).applyTo(searchText);
		searchText.addDelayedModificationListener(e -> 
				sync.asyncExec(() -> 
					viewerConfig.setSearchString((String)((DelayableText)e.getSource()).getText()))
			);
	}
	
	
	@Inject @Optional
	private void clearFilters(@UIEventTopic(TermSuiteEvents.TERMINO_FILTER_CLEARED) Object nullValue) {
		viewer.setFilters(null, null);
		searchText.setText("");
	}


	@Inject @Optional
	private void filterTerms(@UIEventTopic(TermSuiteEvents.NEW_VARIATION_FILTER) VariationFilter filter) {
		viewer.setFilters(null, filter);
		viewer.expandToLevel(1);
	}

	@Inject @Optional
	private void filterTerms(@UIEventTopic(TermSuiteEvents.NEW_TERM_FILTER) TermFilter filter) {
		viewer.setFilters(filter, null);
	}


	@Inject @Optional
	private void init(@UIEventTopic(TermSuiteEvents.EDITOR_INITIATED) Object part, MPart mPart) {
		if(this == part) {
			ETerminology terminology = (ETerminology)context.get(TermSuiteUI.INPUT_OBJECT);
			terminology.eAdapters().add(new EContentAdapter() {
				public void notifyChanged(Notification notification) {
					super.notifyChanged(notification);
					if(notification.getFeature().equals(TermsuiteuiPackage.eINSTANCE.getETerminology_Name())) {
						mPart.setLabel(toPartLabel(terminology));
					} else {
						// set dirty
//						dirty.setDirty(true);
					}
				}
			});
			final IndexedCorpus indexedCorpus = eTerminologyService.readTerminology(terminology);
			context.set(IndexedCorpus.class, indexedCorpus);
			context.set(Terminology.class, indexedCorpus.getTerminology());
			final TerminologyService terminologyService = TermSuite.getTerminologyService(indexedCorpus.getTerminology());
			context.set(TerminologyService.class, terminologyService);
			Job job = Job.create("Open terminology", monitor -> {
				sync.asyncExec(() -> viewer.setInput(terminologyService));
				return Status.OK_STATUS;
			});
			job.schedule();
		}
	}
	
	@Override
	public TreeViewer getTreeViewer() {
		return this.viewer;
	}

	public static  String toPartLabel(ETerminology termino) {
		return String.format("%s/%s/%s", 
				termino.getCorpus().getCorpus().getName(), 
				termino.getCorpus().getLanguage().getName().toLowerCase(), 
				termino.getName());
	}
}
