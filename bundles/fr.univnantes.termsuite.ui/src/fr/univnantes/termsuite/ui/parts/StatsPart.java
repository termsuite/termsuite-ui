package fr.univnantes.termsuite.ui.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.ETerminologyService;
import fr.univnantes.termsuite.ui.util.PartAdapter;

public abstract class StatsPart {

	@Inject private ETerminologyService eTerminologyService;
	@Inject private UISynchronize sync;

	protected ETerminology activeTermino;
	
	private Job updatingJob = null;
	
	private void updateActiveTerminology(ETerminology termino) {
		this.activeTermino = termino;
		setTerminoHeader(termino);
		computingNewStats(termino);
		if(updatingJob != null)
			updatingJob.cancel();
		updatingJob = new Job("Computing statistics for terminology " + TerminologyPart.toPartLabel(termino)){
			public IStatus run(IProgressMonitor monitor) {
				TerminologyStats stats = eTerminologyService.getStats(termino);
				if(monitor.isCanceled())
					return Status.CANCEL_STATUS;
				else if(stats != null) {
					sync.asyncExec(() -> {
						setTerminoHeader(termino);	
						newStatsComputed(termino, stats);
					});
				}
				return Status.OK_STATUS;
			}
			
		};
		updatingJob.schedule();
	}

	protected abstract void computingNewStats(ETerminology termino);

	protected abstract void newStatsComputed(ETerminology termino, TerminologyStats stats);

//	protected TableItem terminoNameItem;

	protected void setTerminoHeader(ETerminology termino) {
		column2.setImage(TermsuiteImg.INSTANCE.getFlag(termino.getCorpus().getLanguage()));
		column2.setText(TerminologyPart.toPartLabel(termino));
	}

//	@Inject @Optional
//	public void raisedToTop(@UIEventTopic(UIEvents.UILifeCycle.BRINGTOTOP) MPart part) {
//		if(part != null)
//			processActivePart(part);
//	}
//	
	

//	@Inject
//	void activePartChanged(@Named(IServiceConstants.ACTIVE_PART) MPart part, EPartService partService) {
//		processActivePart(part);
//	}

//	@Inject
//	void selectionChanged(@Named(IServiceConstants.ACTIVE_SELECTION) Object o) {
//		if(o != null && o instanceof ETerminology)
//			updateActiveTerminology((ETerminology) o);
//	}
	

	protected TableItem createItem(Table table, String label) {
		TableItem item = new TableItem(table, SWT.NONE | SWT.BOLD);
		item.setText(0, label);
		return item;
	}
	
	protected TableColumn column1;
	protected TableColumn column2;
	protected Table table;

	@PostConstruct
	public void createControls(IEclipseContext context, final Composite parent, MPart part, EPartService partService, EModelService modelService, MApplication application) {
		table = new Table(parent, SWT.BORDER | getSelectionStyle());
		column1 = new TableColumn(table, SWT.LEFT);
		column1.setText("Terminology");
		column1.setWidth(200);
		column2 = new TableColumn(table, SWT.RIGHT);
		column2.setWidth(100);
		table.setHeaderVisible(true);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Table table = (Table)e.getSource();
				if(activeTermino != null)
					itemsSelected(Lists.newArrayList(table.getSelection()));
			}

		});

		tableCreated();
		
		partService.addPartListener(new PartAdapter() {
			@Override
			public void partActivated(MPart part) {
				if(part != null) {
					if(part.getObject() instanceof TerminologyPart && part.getContext().get(ETerminology.class) != null) 
						updateActiveTerminology(part.getContext().get(ETerminology.class));

				}
			}
		});
		
		
		setActiveTerminology(modelService, application);

	}

	private void setActiveTerminology( EModelService modelService, MApplication application) {
		MPartStack stack = (MPartStack) modelService.find(TermSuiteUI.UI_MAIN_PART_STACK, application);
		MStackElement element = stack.getSelectedElement();
		if(element != null && element instanceof MPart) {
			MPart activePart = (MPart) element;
			if(activePart.getObject() instanceof TerminologyPart)
				updateActiveTerminology((activePart.getContext().get(ETerminology.class)));
		}
	}
	
	@Inject @Optional
	private void updatedTermino(@UIEventTopic(TermSuiteEvents.TERMINOLOGY_MODIFIED) ETerminology terminology) {
		if(Objects.equal(activeTermino, terminology)) 
			updateActiveTerminology(terminology);
	}
	
	protected abstract int getSelectionStyle();

	protected void tableCreated() {
		
	}

	protected void itemsSelected(List<TableItem> selection) {
		
	}
}
