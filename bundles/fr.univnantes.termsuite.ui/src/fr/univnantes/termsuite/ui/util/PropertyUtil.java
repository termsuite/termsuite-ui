package fr.univnantes.termsuite.ui.util;

import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.model.RelationProperty;
import fr.univnantes.termsuite.model.TermProperty;

public class PropertyUtil {

	public static Property<?> forName(String propertyName) {
		if(TermProperty.forNameOptional(propertyName).isPresent())
			return TermProperty.forName(propertyName);
		else
			return RelationProperty.forName(propertyName);
	}
}
