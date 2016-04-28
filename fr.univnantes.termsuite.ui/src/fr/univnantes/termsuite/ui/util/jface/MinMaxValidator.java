package fr.univnantes.termsuite.ui.util.jface;

public class MinMaxValidator {
	private Number min;
	private Number max;
	
	public MinMaxValidator(Number min, Number max) {
		super();
		this.min = min;
		this.max = max;
	}

	public String validate(Number value) {
		double v = value.doubleValue();
		if(min.doubleValue() > v)
			return "Needs > " + min;
		if(max.doubleValue() < v)
			return "Needs < " + max;
		return null;
	}
}
