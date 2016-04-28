package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.resource.StringConverter;

public class DoubleValidator extends NumberValidator {
	
	public DoubleValidator() {
		super();
	}

	public DoubleValidator(Number min, Number max) {
		super(min, max);
	}

	@Override
	public IStatus validate(Object value) {
		try {
			double v = StringConverter.asDouble(String.valueOf(value));
			String msg = super.validate(v);
			return msg != null ? ValidationStatus.error(msg) : ValidationStatus.ok();
		} catch (Exception e) {
			return ValidationStatus.error("Not a number");
		}
	}
}
