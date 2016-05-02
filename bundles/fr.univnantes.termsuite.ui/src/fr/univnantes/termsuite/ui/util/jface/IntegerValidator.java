package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class IntegerValidator extends NumberValidator {
	
	public IntegerValidator() {
		super();
	}

	public IntegerValidator(Number min, Number max) {
		super(min, max);
	}

	@Override
	public IStatus validate(Object value) {
		String s = String.valueOf(value);
		if (s.matches("\\d+")) {
			String msg = super.validate(Integer.parseInt(s));
			return msg != null ? ValidationStatus.error(msg) : ValidationStatus.ok();
		}
		return ValidationStatus.error("Not a number");
	}
}
