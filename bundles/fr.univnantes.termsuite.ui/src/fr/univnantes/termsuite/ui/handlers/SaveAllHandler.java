package fr.univnantes.termsuite.ui.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SaveAllHandler {
	public static final String ID = "fr.univnantes.termsuite.ui.handler.SaveAll";

	@Execute
	void execute(EPartService partService) {
		partService.saveAll(true);
	}

	@CanExecute
	public boolean canExecute(EPartService partService) {
		return !partService.getDirtyParts().isEmpty();
	}
}
