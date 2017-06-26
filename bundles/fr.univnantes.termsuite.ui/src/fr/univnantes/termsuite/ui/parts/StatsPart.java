package fr.univnantes.termsuite.ui.parts;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.UIEvents;

import fr.univnantes.termsuite.api.TerminologyStats;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.ETerminologyService;

public abstract class StatsPart {

	@Inject private ETerminologyService eTerminologyService;
	@Inject private UISynchronize sync;

	private void updateActiveTerminology(ETerminology termino) {
		sync.asyncExec(() -> computingNewStats(termino));
		new Thread(){
			public void run() {
				TerminologyStats stats = eTerminologyService.getStats(termino);
				if(stats != null)
					sync.asyncExec(() -> newStatsComputed(termino, stats));
			}

		}.start();
	}

	protected abstract void computingNewStats(ETerminology termino);

	protected abstract void newStatsComputed(ETerminology termino, TerminologyStats stats);

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

}
