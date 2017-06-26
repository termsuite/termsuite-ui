package fr.univnantes.termsuite.ui.parts;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.ETerminologyService;

public abstract class StatsPart {

	@Inject private ETerminologyService eTerminologyService;
	@Inject private UISynchronize sync;

	private void updateActiveTerminology(ETerminology termino) {
		sync.asyncExec(() -> setTerminoHeader(termino));
		sync.asyncExec(() -> computingNewStats(termino));
		new Job("Computing statistics for terminology " + TerminologyPart.toPartLabel(termino)){
			public IStatus run(IProgressMonitor monitor) {
				TerminologyStats stats = eTerminologyService.getStats(termino);
				if(stats != null) {
					sync.asyncExec(() -> setTerminoHeader(termino));
					sync.asyncExec(() -> newStatsComputed(termino, stats));
				}
				return Status.OK_STATUS;
			}

		}.schedule();
	}

	protected abstract void computingNewStats(ETerminology termino);

	protected abstract void newStatsComputed(ETerminology termino, TerminologyStats stats);

	protected TableItem terminoNameItem;

	protected void setTerminoHeader(ETerminology termino) {
		terminoNameItem.setImage(1, TermsuiteImg.INSTANCE.getFlag(termino.getCorpus().getLanguage()));
		terminoNameItem.setText(1, TerminologyPart.toPartLabel(termino));
	}

	@Inject @Optional
	public void raisedToTop(@UIEventTopic(UIEvents.UILifeCycle.BRINGTOTOP) MPart part) {
		if(part != null)
			processActivePart(part);
	}
	
	@Inject @Optional
	private void init(@UIEventTopic(TermSuiteEvents.EDITOR_INITIATED) Object o, MPart part) {
		processActivePart(part);
	}

	
	private void processActivePart(MPart part) {
		if(part != null &&  part.getContext().get(ETerminology.class) != null) 
			updateActiveTerminology(part.getContext().get(ETerminology.class));
	}

	@Inject
	void activePartChanged(@Named(IServiceConstants.ACTIVE_PART) MPart part) {
		processActivePart(part);
	}

	@Inject
	void selectionChanged(@Named(IServiceConstants.ACTIVE_SELECTION) Object o) {
		if(o != null && o instanceof ETerminology)
			updateActiveTerminology((ETerminology) o);
	}
	

	protected TableItem createItem(Table table, String label) {
		TableItem item = new TableItem(table, SWT.NONE | SWT.BOLD);
		item.setText(0, label);
		return item;
	}

}
