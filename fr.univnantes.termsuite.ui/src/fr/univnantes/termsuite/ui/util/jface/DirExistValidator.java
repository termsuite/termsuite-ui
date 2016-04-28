package fr.univnantes.termsuite.ui.util.jface;

import java.io.File;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class DirExistValidator implements IValidator {
	

	@Override
	public IStatus validate(Object value) {
		if (new File(String.valueOf(value)).exists()) 
			return ValidationStatus.ok();
		else 
			return ValidationStatus.error("Directory does not exist");
	}
}
