package fr.univnantes.termsuite.ui.menu;

import java.util.List;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.ILoggerProvider;
//import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Joiner;

import fr.univnantes.termsuite.alignment.TranslationCandidate;
import fr.univnantes.termsuite.model.Term;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.events.AlignmentResultPayload;
import fr.univnantes.termsuite.ui.exceptions.DictionaryException;
import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.parts.AlignmentResultsPart;
import fr.univnantes.termsuite.ui.services.AlignmentService;
import fr.univnantes.termsuite.ui.services.ResourceService;

@SuppressWarnings("restriction") 
public class AlignHandler {
	@Execute
	public void execute(
			final @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			final @Named(IServiceConstants.ACTIVE_SELECTION) Term term,
			final @Named(TermSuiteUI.SOURCE_TERMINOLOGY) ETerminology sourceTerminology,
			final UISynchronize sync,
			final IEventBroker eventBroker,
			EPartService partService,
			final ILoggerProvider loggerProvider,
			MMenuItem menuItem,
			ResourceService resourceService,
			final AlignmentService alignmentService
		) {
		EResource resource = resourceService.fromModelTag(menuItem.getTags());
		if(resource == null) {
			String msg = "Could not find a model tag in menu item's tags: [" + Joiner.on(", ").join(menuItem.getTags()) + "]";
			loggerProvider.getClassLogger(this.getClass()).error(msg);
			MessageDialog.openError(shell, "Alignment Error", "An error occurred during alignment. See TermSuite log file and contact us if necessary.");
		} else {
			
			final ETerminology targetTerminology = (ETerminology) resource;
			MPart outlinePart = partService.findPart(AlignmentResultsPart.ID);
	
			if(outlinePart != null)
	  		  partService.bringToTop(outlinePart);
	  	  
			Job job = new Job("Aligning " + term.getGroupingKey()) {
	
				@Override
				@SuppressWarnings("unchecked")
				protected IStatus run(IProgressMonitor monitor) {
					try {
						Object results = alignmentService.align(term, sourceTerminology, targetTerminology);
						AlignmentResultPayload payload = new AlignmentResultPayload();
						payload.setTerm(term);
						payload.setTranslationCandidates((List<TranslationCandidate>) results);
						eventBroker.post(TermSuiteEvents.ALIGNEMENT_RESULT, payload);
					} catch(final DictionaryException e) {
						final String msgDictionaryError = "An dictionary error occurred during alignment";
						loggerProvider.getClassLogger(this.getClass()).error(msgDictionaryError, e);
						sync.asyncExec(new Runnable() {
							@Override
							public void run() {
								MessageDialog.openError(shell, msgDictionaryError, e.getMessage());
							}
						});
						return new Status(Status.ERROR, TermSuiteUI.PLUGIN_ID, msgDictionaryError, e);
					} catch(final RuntimeException e) {
						final String msgAlignmentError = "An error occurred during alignment";
						loggerProvider.getClassLogger(this.getClass()).error(msgAlignmentError, e);
						sync.asyncExec(new Runnable() {
							@Override
							public void run() {
								MessageDialog.openError(shell, msgAlignmentError, e.getMessage());
							}
						});
						return new Status(Status.ERROR, TermSuiteUI.PLUGIN_ID, msgAlignmentError, e);
					}
					return Status.OK_STATUS;
				}
				
			};
			job.schedule();
		}

	}
}
