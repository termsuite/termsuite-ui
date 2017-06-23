package fr.univnantes.termsuite.ui.viewers;

import org.eclipse.jface.viewers.LabelProvider;

import fr.univnantes.termsuite.model.Property;

public class PropertyLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if(element instanceof Property<?>) {
			Property<?> property = (Property<?>)element;
			return String.format("%s: %s", property.getPropertyName(), property.getDescription());
		} else
			return super.getText(element);
	}

}
