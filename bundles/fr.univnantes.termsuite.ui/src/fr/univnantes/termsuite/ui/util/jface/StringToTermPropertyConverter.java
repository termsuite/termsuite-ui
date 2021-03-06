package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.conversion.Converter;

import fr.univnantes.termsuite.model.TermProperty;

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
	    } else if(fromObject == null)
	    	return null;
	    throw new IllegalArgumentException(fromObject.getClass() + " type cannot be converted by " + getClass());
	} 
}


