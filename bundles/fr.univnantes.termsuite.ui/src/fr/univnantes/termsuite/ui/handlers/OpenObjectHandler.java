package fr.univnantes.termsuite.ui.handlers;

import java.io.File;

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

import com.google.common.base.Objects;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.parts.FileEditorPart;
import fr.univnantes.termsuite.ui.parts.FileInput;
import fr.univnantes.termsuite.ui.parts.PipelinePart;
import fr.univnantes.termsuite.ui.parts.TerminologyPart;
import fr.univnantes.termsuite.ui.parts.TermsuiteImg;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.LinguisticResourcesService;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class OpenObjectHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.OpenObject";

	public static final String COMMAND_ID = "fr.univnantes.termsuite.ui.command.OpenObject";
	
	public static final String PARAM_INPUT_OBJECT_ID = "fr.univnantes.termsuite.ui.commandparameter.InputResourceId";
	public static final String PARAM_INPUT_OBJECT_PATH = "fr.univnantes.termsuite.ui.commandparameter.InputObjectPath";
	
	@Execute
	public void execute(               
			@Optional @Named(PARAM_INPUT_OBJECT_ID) String inputObjectId,
			@Optional @Named(PARAM_INPUT_OBJECT_PATH) String inputObjectPath,
			ResourceService resourceService,
			LinguisticResourcesService linguisticResourcesService,
			EPartService partService, 
			final CorpusService corpusService, 
			MApplication application,
			EModelService modelService,
			IEventBroker eventBroker) {
		Object inputObject = null;
		if(inputObjectId != null)
			inputObject = resourceService.getResource(inputObjectId);
		else if(inputObjectPath != null)
			inputObject = linguisticResourcesService.getResource(inputObjectPath);
//		Object inputObject = selectionService.getSelection();
		for(MPart part:partService.getParts()) {
			IEclipseContext context = part.getContext();
			
			if(context != null && Objects.equal(context.get(TermSuiteUI.INPUT_OBJECT),inputObject)) {
				partService.bringToTop(part);
				return;
			}
		}
		MPartStack stack = (MPartStack) modelService.find(TermSuiteUI.UI_MAIN_PART_STACK, application);
		String partId;
		String label;
		boolean editable = true;
		String iconURI = null;

		if(inputObject instanceof EDocument) {
			editable = false;
			partId = FileEditorPart.ID;
			inputObject = new FileInput<EDocument>((EDocument)inputObject) {
				@Override
				public File asFile() {
					return corpusService.asFile(this.inputObject);
				}
			};
			label = ((FileInput<?>)inputObject).getFile().getName();
		} else if(inputObject instanceof ELinguisticResource) {
			partId = FileEditorPart.ID;
			inputObject = new FileInput<ELinguisticResource>((ELinguisticResource)inputObject) {
				@Override
				public File asFile() {
					return new File(this.inputObject.getPath());
				}
			};
			label = ((FileInput<?>)inputObject).getFile().getName();
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
		part.getContext().set(TermSuiteUI.EDITABLE,editable);
		eventBroker.send(TermSuiteEvents.EDITOR_INITIATED, part.getObject());
		partService.activate(part);
	}
	
	@CanExecute
	public boolean canExecute(
			@Optional @Named(PARAM_INPUT_OBJECT_ID) String inputObjectId,
			@Optional @Named(PARAM_INPUT_OBJECT_PATH) String inputObjectPath,
			LinguisticResourcesService linguisticResourcesService,
			ResourceService resourceService) {
		if(inputObjectId != null)
			return resourceService.getResource(inputObjectId) != null;
		if(inputObjectPath != null)
			return linguisticResourcesService.getResource(inputObjectPath) != null;
		return false;

	}
}
