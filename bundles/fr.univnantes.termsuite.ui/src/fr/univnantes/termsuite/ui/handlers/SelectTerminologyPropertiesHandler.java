package fr.univnantes.termsuite.ui.handlers;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.framework.service.TerminologyService;
import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.ui.dialogs.SelectPropertyDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.util.PropertyUtil;

public class SelectTerminologyPropertiesHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.SelectTerminologyPropertiesHandler";

	@Execute
	public void execute(
			@Optional @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Optional TerminologyService terminologyService,
			@Optional ETerminoViewerConfig viewerConfig,
			@Optional MPart terminologyPart
			) {
		EList<String> viewerList = viewerConfig.getSelectedPropertyNames();
		List<Property<?>> selectedProperties = viewerList
				.stream()
				.map(s -> PropertyUtil.forName(s)).collect(Collectors.toList());
		
		SelectPropertyDialog dialog = new SelectPropertyDialog(shell, selectedProperties);
		if(dialog.open() == Dialog.OK) {
			List<String> propertyNames = dialog.getSelectedPropertyNames();
			viewerList.retainAll(propertyNames);
			propertyNames.removeAll(viewerList);
			viewerList.addAll(propertyNames);
		}
	}
	
}
