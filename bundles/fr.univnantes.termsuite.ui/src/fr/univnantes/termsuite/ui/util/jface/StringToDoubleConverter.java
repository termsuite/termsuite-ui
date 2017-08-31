package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.jface.resource.StringConverter;

public class StringToDoubleConverter extends Converter {

	  public StringToDoubleConverter() {
	    // pass null for undefined fromType and toType
	    super(null, null);
	  }

	  @Override
	  public Object convert(Object fromObject) {
	    if (fromObject instanceof String) {
	    	return StringConverter.asDouble(fromObject.toString());
	    } else if (fromObject instanceof Double) {
	    	return StringConverter.asString((Double)fromObject);
	    } else if(fromObject == null)
	    	return null;
	    throw new IllegalArgumentException(fromObject.getClass() + " type cannot be converted by " + getClass());
	} 
}


