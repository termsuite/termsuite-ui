package fr.univnantes.termsuite.ui.handlers;

import java.io.IOException;

import javax.inject.Named;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.api.TerminologyFilterer;
import fr.univnantes.termsuite.framework.service.TerminologyService;
import fr.univnantes.termsuite.model.IndexedCorpus;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.dialogs.FilterTerminologyDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.parts.TerminologyPart;
import fr.univnantes.termsuite.ui.services.ETerminologyService;

public class FilterTerminologyHandler {
	public static final String ID="fr.univnantes.termsuite.ui.handler.FilterTerminologyHandler";

	@Execute
	public void execute(
			@Optional @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Optional TerminologyService terminologyService,
			@Optional ETerminologyService eTerminologyService,
			ILoggerProvider loggerProvider,
			UISynchronize sync,
			@Optional ETerminology terminology,
			IEventBroker broker,
			@Optional IndexedCorpus indexedCorpus
			) throws IOException {
		
		FilterTerminologyDialog filterDialog = new FilterTerminologyDialog(shell);
		if(filterDialog.open() == Dialog.OK){
			Job job = Job.create("Filtering terminology " + TerminologyPart.toPartLabel(terminology), (monitor) -> {
				new TerminologyFilterer(filterDialog.getFilterOptions()).filter(indexedCorpus);
			});
			
			job.addJobChangeListener(new JobChangeAdapter(){
				
				@Override
				public void done(IJobChangeEvent event) {
					if(event.getResult().getSeverity() == Status.OK) {
						try {
							eTerminologyService.saveTerminologyJson(terminology, indexedCorpus, true, true);
							broker.post(TermSuiteEvents.TERMINOLOGY_MODIFIED, terminology);
							eTerminologyService.invalidateCaches(terminology);
						} catch (IOException e) {
							String message = "Failed to save terminology " + TerminologyPart.toPartLabel(terminology);
							loggerProvider.getClassLogger(getClass()).error(e, message);
							sync.asyncExec(() -> MessageDialog.openError(shell, "Error saving terminology: " + e.getMessage(), message));
						}
					}
					super.done(event);
				}
			});
			job.schedule();
			
		}
	}

}
