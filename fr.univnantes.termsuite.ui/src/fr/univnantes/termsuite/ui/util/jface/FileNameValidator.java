package fr.univnantes.termsuite.ui.util.jface;

import java.io.File;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class FileNameValidator implements IValidator {
	
	private String extension;
	
	public FileNameValidator(String extension) {
		super();
		this.extension = extension;
	}

	@Override
	public IStatus validate(Object value) {
		String s = String.valueOf(value);
		if (s.contains(File.pathSeparator)) 
			return ValidationStatus.error("Forbidden character: " + File.pathSeparator);
		else if (s.endsWith(extension)) {
			return ValidationStatus.ok();
		} else
			return ValidationStatus.error("Bad file name: " + s);
	}
}
