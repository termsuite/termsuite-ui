package fr.univnantes.termsuite.ui.parts;

import java.util.EventObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

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
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import fr.univnantes.termsuite.api.TermSuite;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.model.RelationProperty;
import fr.univnantes.termsuite.model.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.controls.DelayableText;
import fr.univnantes.termsuite.ui.controls.DelayedModificationListener;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import fr.univnantes.termsuite.ui.services.ETerminologyService;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;
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
	private ETerminologyService eTerminologyService;
	
	@Inject
	TermSuiteSelectionService termSuiteSelectionService;

	@Inject
	private UISynchronize sync;

	private Composite parent;

	@PostConstruct
	public void createControls(final IEclipseContext context, 
			final ESelectionService selectionService,
			final EMenuService menuService,
			final EPartService partService,
			final Composite parent, MPart part) {
		this.parent = parent;
		parent.setLayout(new GridLayout(2, false));

		viewerConfig = TermsuiteuiFactory.eINSTANCE.createETerminoViewerConfig();
		viewerConfig.setSortingPropertyName(TermProperty.RANK.getJsonField());
		viewerConfig.setSortingAsc(true);
		viewerConfig.setSearchString("");
		viewerConfig.setNbDisplayedTerms(1000);

		// populate headers
	    populateInfoContainer(parent);
	    
		// populate viewer
		this.viewer = new TerminologyViewer(viewerConfig, parent, SWT.SINGLE| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, true).applyTo(viewer.getControl());
		
		subscribe(context, eTerminologyService, parent);
		
		addColumn(TermProperty.RANK, 50);
		addColumn(TermProperty.PILOT, 300);
		addColumn(TermProperty.PATTERN, 100);
		addColumn(TermProperty.SPECIFICITY, 60);
		addColumn(TermProperty.FREQUENCY, 60);
		addColumn(TermProperty.DOCUMENT_FREQUENCY, 60);
		addColumn(RelationProperty.VARIATION_RULES, 100);
		
	  // attach a selection listener to our jface viewer
	  viewer.addSelectionChangedListener(ContextInjectionFactory.make(TermSelectionListener.class, context));
		  
		menuService.registerContextMenu(viewer.getControl(), POPUP_MENU_ID);

	}



	/*
	 * Good link for TreeViewerColumn applications :
	 * 
	 * http://www.programcreek.com/java-api-examples/index.php?api=org.eclipse.jface.viewers.TreeViewerColumn
	 */
	private void addColumn(final Property<?> property, int width) {
		TreeViewerColumn column1 = new TreeViewerColumn(viewer, property.getRange().equals(String.class) ? SWT.LEFT : SWT.RIGHT);
		column1.setLabelProvider(new DelegatingStyledCellLabelProvider(new TermLabelProvider(property, viewerConfig)));
		column1.getColumn().setWidth(width);
		column1.getColumn().setText(property.getPropertyName());
		column1.getColumn().setToolTipText(property.getDescription());
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
	

	private DelayableText numOfTermsToShow;
	private Label numOfTermsBeforeFiltering;
	
	
	private void populateInfoContainer(Composite infoContainer) {
		
		// The total number of terms label
		new Label(infoContainer, SWT.NONE).setText("Number of terms in termino (before filtering): ");
		numOfTermsBeforeFiltering = new Label(infoContainer, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(numOfTermsBeforeFiltering);
		
		// horizontal line
	    Label separator = new Label(infoContainer, SWT.HORIZONTAL | SWT.SEPARATOR);
	    GridDataFactory.fillDefaults().span(2,1).applyTo(separator);
		
	    
		// The search filter
		new Label(infoContainer, SWT.NONE).setText("Search pattern: ");
		final DelayableText searchText = new DelayableText(1000, infoContainer, SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL | SWT.BORDER);
		searchText.setMessage("Search");
		GridDataFactory.fillDefaults().hint(150, SWT.DEFAULT).applyTo(searchText);
		searchText.addDelayedModificationListener(new DelayedModificationListener() {
			@Override
			public void modifyText(final EventObject e) {
				sync.asyncExec(new Runnable() {
					@Override
					public void run() {
						viewerConfig.setSearchString((String)((DelayableText)e.getSource()).getText());
					}
				});
			}
		});

		
		
		// maxNumOfterm filter
		new Label(infoContainer, SWT.NONE).setText("How many terms to show: ");
		numOfTermsToShow = new DelayableText(500, infoContainer, SWT.NONE);
		numOfTermsToShow.setText(Integer.toString(viewerConfig.getNbDisplayedTerms()));
		GridDataFactory.fillDefaults().applyTo(numOfTermsToShow);
		numOfTermsToShow.addDelayedModificationListener(new DelayedModificationListener() {
			@Override
			public void modifyText(final EventObject e) {
				sync.asyncExec(new Runnable() {
					@Override
					public void run() {
						try {
							int maxTerms = Integer.parseInt(((DelayableText)e.getSource()).getText());
							viewerConfig.setNbDisplayedTerms(maxTerms);
						} catch(NumberFormatException e) {}
					}
				});
				
			}
		});
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
			if(terminology != null) {
				final IndexedCorpus indexedCorpus = eTerminologyService.readTerminology(terminology);
				Job job = Job.create("Open terminology", monitor -> {
					sync.asyncExec(() -> {
						numOfTermsBeforeFiltering.setText(Integer.toString(indexedCorpus.getTerminology().getTerms().size()));
						viewer.setInput(TermSuite.getTerminologyService(indexedCorpus.getTerminology()));
					});
					return Status.OK_STATUS;
				});
				job.schedule();

			} else
				MessageDialog.openError(parent.getShell(), 
						"Could not open Terminology",
						"No termino found in context.");
		}
	}
	
	private void subscribe(final IEclipseContext context, final ETerminologyService eTerminologyService,
			final Composite parent) {
		this.eventBroker.subscribe(
			TermSuiteEvents.SEARCH_TEXT_MODIFIED, 
			event -> viewerConfig.setSearchString((String)event.getProperty(IEventBroker.DATA))
		);
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
