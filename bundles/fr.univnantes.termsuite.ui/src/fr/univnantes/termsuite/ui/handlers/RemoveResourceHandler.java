package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class RemoveResourceHandler {

	public static final String PARAM_RESOURCE_TYPE = "fr.univnantes.termsuite.ui.commandparameter.ResourceType";
	public static final String ID = "fr.univnantes.termsuite.ui.handler.RemoveResource";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell, 
			ResourceService resourceService, 
			ESelectionService selectionService, EPartService partService) {
		Object s = selectionService.getSelection();

		boolean ok = MessageDialog.openConfirm(shell, "Confirmation", String.format(
				"Are you sure that you want to remove the %s \"%s\" ?", getResourceTypeName(s), getResourceName(s)));

		if (ok) {
			if (s instanceof EPipeline) {
				resourceService.remove((EPipeline) s);
			} else if (s instanceof ECorpus) {
				resourceService.removeCorpus((ECorpus) s);
			} else if (s instanceof ETerminology) {
				resourceService.removeTerminology((ETerminology) s);
			}

			for (MPart p : partService.getParts()) {
				if (p != null && p.getContext() != null) {
					Object inputObject = p.getContext().get(TermSuiteUI.INPUT_OBJECT);
					if (inputObject != null && inputObject == s) {
						partService.hidePart(p, true);
					}
				}
			}

		}

	}

	@CanExecute
	public boolean canExecute(ESelectionService selectionService,
			@Optional @Named(PARAM_RESOURCE_TYPE) String resourceType) {
		Object s = selectionService.getSelection();
		if (resourceType == null) {
			return s != null && (s instanceof ECorpus || s instanceof EPipeline || s instanceof ETerminology);
		} else {
			if (resourceType.equals(EPipeline.class.getName()))
				return s != null && s instanceof EPipeline;
			else if (resourceType.equals(ECorpus.class.getName()))
				return s != null && s instanceof ECorpus;
			else if (resourceType.equals(ETerminology.class.getName()))
				return s != null && s instanceof ETerminology;
		}
		return false;
	}

	private String getResourceName(Object s) {
		if (s instanceof EPipeline) {
			return ((EPipeline) s).getName();
		} else if (s instanceof ECorpus) {
			return ((ECorpus) s).getName();
		} else if (s instanceof ETerminology) {
			return ((ETerminology) s).getName();
		} else
			return "resource";
	}

	private String getResourceTypeName(Object s) {
		if (s instanceof EPipeline) {
			return "pipeline";
		} else if (s instanceof ECorpus) {
			return "corpus";
		} else if (s instanceof ETerminology) {
			return "terminology";
		} else
			return "resourceType";
	}

}
