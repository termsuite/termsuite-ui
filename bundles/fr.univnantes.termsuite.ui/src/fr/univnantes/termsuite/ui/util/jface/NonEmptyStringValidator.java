package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class NonEmptyStringValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		String s = String.valueOf(value);
		if (s.isEmpty()) 
			return ValidationStatus.error("Name must not be empty");
		else
			return ValidationStatus.ok();
	}
}
