package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.services.IServiceConstants;

import fr.univnantes.termsuite.ui.parts.FileEditorPart;

public class WrapTextToggleHandler {
	public static final String ID = "fr.univnantes.termsuite.ui.handler.WrapTextToggleHandler";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_PART) MPart part, MToolItem item) {
		if(part != null && part.getObject() instanceof FileEditorPart) {
			((FileEditorPart)part.getObject()).wrap(item.isSelected());
		}
	}
}
