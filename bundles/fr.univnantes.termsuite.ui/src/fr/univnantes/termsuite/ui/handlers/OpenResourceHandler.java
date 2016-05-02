package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.parts.FileEditorPart;
import fr.univnantes.termsuite.ui.parts.PipelinePart;
import fr.univnantes.termsuite.ui.parts.TerminologyPart;
import fr.univnantes.termsuite.ui.parts.TermsuiteImg;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class OpenResourceHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.OpenResource";

	public static final String COMMAND_ID = "fr.univnantes.termsuite.ui.command.OpenResource";
	
	public static final String PARAM_INPUT_OBJECT_ID = "fr.univnantes.termsuite.ui.commandparameter.InputObjectId";
	
	@Execute
	public void execute(               
			@Optional @Named(PARAM_INPUT_OBJECT_ID) String inputObjectId,
			ResourceService resourceService,
			EPartService partService, 
			CorpusService corpusService, 
			MApplication application,
			EModelService modelService,
			IEventBroker eventBroker) {
		Object inputObject = resourceService.getResource(inputObjectId);
//		Object inputObject = selectionService.getSelection();
		for(MPart part:partService.getParts()) {
			IEclipseContext context = part.getContext();
			
			if(context != null && context.get(TermSuiteUI.INPUT_OBJECT) == inputObject) {
				partService.bringToTop(part);
				return;
			}
		}
		MPartStack stack = (MPartStack) modelService.find(TermSuiteUI.UI_MAIN_PART_STACK, application);
		String partId;
		String label;
		String iconURI = null;

		if(inputObject instanceof EDocument) {
			partId = FileEditorPart.ID;
			label = corpusService.asFile((EDocument)inputObject).getName();
		} else if(inputObject instanceof ETerminology) {
			partId = TerminologyPart.ID;
			ETerminology termino = (ETerminology)inputObject;
			iconURI = TermsuiteImg.INSTANCE.getFlaggedTerminoURI(termino.getCorpus().getLanguage());
			label = String.format("%s/%s/%s", 
					termino.getCorpus().getCorpus().getName(), 
					termino.getCorpus().getLanguage().getName().toLowerCase(), 
					termino.getName());	
		} else if(inputObject instanceof EPipeline) {
			partId = PipelinePart.ID;
			label = ((EPipeline)inputObject).getFilename();
		} else {
			// do nothing
			return;
		}
		MPart part = partService.createPart(partId);
		part.setLabel(label);
		if(iconURI != null)
			part.setIconURI(iconURI);
		part.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
		stack.getChildren().add(part);
		partService.showPart(part, PartState.CREATE);
		part.getContext().set(TermSuiteUI.INPUT_OBJECT,inputObject);
		eventBroker.send(TermSuiteEvents.EDITOR_INITIATED, part.getObject());
		partService.activate(part);
	}
	
	@CanExecute
	public boolean canExecute(
			@Optional @Named(PARAM_INPUT_OBJECT_ID) String inputObjectId,
			ResourceService resourceService) {
		return resourceService.getResource(inputObjectId) != null;
	}
}
