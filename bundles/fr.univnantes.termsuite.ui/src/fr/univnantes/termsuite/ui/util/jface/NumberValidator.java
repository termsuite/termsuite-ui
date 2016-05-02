package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.validation.IValidator;

public abstract class NumberValidator implements IValidator {

	private MinMaxValidator minMaxValidator = null;
	
	public NumberValidator() {
		super();
	}

	public NumberValidator(Number min, Number max) {
		super();
		this.minMaxValidator = new MinMaxValidator(min, max);
	}
	
	protected String validate(Number num) {
		if(minMaxValidator != null) 
			return minMaxValidator.validate(num);
		else
			return null;
	}

}
