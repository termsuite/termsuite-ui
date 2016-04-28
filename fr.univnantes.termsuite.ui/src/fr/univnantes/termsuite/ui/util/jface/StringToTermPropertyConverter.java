package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.conversion.Converter;

import eu.project.ttc.engines.cleaner.TermProperty;

public class StringToTermPropertyConverter extends Converter {

	  public StringToTermPropertyConverter() {
	    super(null, null);
	  }

	  @Override
	  public Object convert(Object fromObject) {
	    if (fromObject instanceof String) {
	    	return TermProperty.forName(String.valueOf(fromObject));
	    } else if (fromObject instanceof TermProperty) {
	    	return ((TermProperty)fromObject).getPropertyName();
	    }
	    throw new IllegalArgumentException(fromObject.getClass() + " type cannot be converted by " + getClass());
	} 
}


