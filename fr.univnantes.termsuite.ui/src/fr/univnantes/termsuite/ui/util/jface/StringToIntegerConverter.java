package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.jface.resource.StringConverter;

public class StringToIntegerConverter extends Converter {

	  public StringToIntegerConverter() {
	    // pass null for undefined fromType and toType
	    super(null, null);
	  }

	  @Override
	  public Object convert(Object fromObject) {
	    if (fromObject instanceof String) {
	    	return StringConverter.asInt(fromObject.toString());
	    } else if (fromObject instanceof Integer) {
	    	return StringConverter.asString((Integer)fromObject);
	    }
	    throw new IllegalArgumentException(fromObject.getClass() + " type cannot be converted by " + getClass());
	} 
}


