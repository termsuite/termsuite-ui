package fr.univnantes.termsuite.ui.util.jface;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;

public class DirNameValidator implements IValidator {
	
	private String parent;

	public DirNameValidator() {
		super();
		this.parent = Platform.getLocation().toOSString();
	}

	public DirNameValidator(String parent) {
		this.parent = parent;
	}

	@Override
	public IStatus validate(Object value) {
		String s = String.valueOf(value);
		if (s.contains(File.pathSeparator)) 
			return ValidationStatus.error("Forbidden character: " + File.pathSeparator);
		else if(Paths.get(parent, s).toFile().exists())
			return ValidationStatus.error(s + " already exists");
		else
			return ValidationStatus.error("Bad name: " + s);
	}
}
