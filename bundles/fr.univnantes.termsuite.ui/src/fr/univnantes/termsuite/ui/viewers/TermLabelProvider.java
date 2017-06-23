package fr.univnantes.termsuite.ui.viewers;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.StyledString;

import com.google.common.primitives.Ints;

import fr.univnantes.termsuite.framework.service.RelationService;
import fr.univnantes.termsuite.framework.service.TermService;
import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.model.Relation;
import fr.univnantes.termsuite.model.RelationProperty;
import fr.univnantes.termsuite.model.Term;
import fr.univnantes.termsuite.model.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;

public class TermLabelProvider extends ColumnLabelProvider implements IStyledLabelProvider {

	private Property<?> property;
	private ETerminoViewerConfig viewerConfig;
	
	public TermLabelProvider(Property<?> property, ETerminoViewerConfig viewerConfig) {
		super();
		this.property = property;
		this.viewerConfig = viewerConfig;
	}
	
	public Object getRelationPropertyValue(Relation relation) {
		if (property instanceof RelationProperty) {
			RelationProperty p = (RelationProperty) property;
			if(relation.isPropertySet(p))
				return relation.get(p);
		} 
		return null;
	}
	public Object getTermPropertyValue(Term term) {
		if (property instanceof TermProperty) {
			TermProperty p = (TermProperty) property;
			if(term.isPropertySet(p))
				return term.get(p);
		} 
		return null;
	}
	
	public Object getPropertyValue(Object object) {
		if(property instanceof TermProperty) {
			//get the property value from the term if TermProperty or from the target term
			if (object instanceof TermService) 
				return getPropertyValue(((TermService)object).getTerm());
			else if (object instanceof RelationService) 
				return getPropertyValue(((RelationService)object).getTo().getTerm());
			else if (object instanceof Term) 
				return getTermPropertyValue((Term) object);
			else if (object instanceof Relation) 
				return getRelationPropertyValue((Relation) object);
		} else if(property instanceof RelationProperty) {
			//get the property value from the term if TermProperty or from the target term
			if (object instanceof TermService) 
				return null;
			else if (object instanceof RelationService) 
				return getPropertyValue(((RelationService)object).getRelation());
			else if (object instanceof Term) 
				return null;
			else if (object instanceof Relation) 
				return getRelationPropertyValue((Relation) object);
		}
		throw new IllegalArgumentException("Not a supported type for TermLabelProvider: " + object.getClass());
		
	}
	@Override
	public StyledString getStyledText(Object element) {
		Pattern pattern = viewerConfig.getSearchString().trim().isEmpty() ? null
				: Pattern.compile(viewerConfig.getSearchString());

		Object value = getPropertyValue(element);
		if(value == null)
			return new StyledString();
		
		String stringValue = property.getRange().equals(String.class) ?
				(String)value 
					: Collection.class.isAssignableFrom(property.getRange()) ?
							((Collection<?>)value).stream().map(Object::toString).collect(Collectors.joining(", ")) :
								null;
		
		if(stringValue != null) {
			Matcher matcher;
			int b = 0;
			int e = 0;
			if (pattern != null && (matcher = pattern.matcher(stringValue)).find()) {
				b = matcher.start();
				e = matcher.end();
			}
			StyledString styledString = new StyledString();
	
			styledString.append(stringValue.substring(0, Ints.min(b, stringValue.length())), StyledString.COUNTER_STYLER);
			styledString.append(stringValue.substring(Ints.min(b, stringValue.length()), Ints.min(e, stringValue.length())),
					TermSuiteUI.STYLE_GRAYED_BOLD);
			styledString.append(stringValue.substring(Ints.min(e, stringValue.length()), stringValue.length()),
					StyledString.COUNTER_STYLER);
			return styledString;
		} else if(property.isDecimalNumber()) {
			double v = (double)value;
			return new StyledString(String.format("%.2f", v));
		} else if(property.getRange().equals(Boolean.class))
			return new StyledString(String.format("%d", (boolean)value ? 1 : 0));
		else 
			return new StyledString(String.format("%d", value));
	}
	
	@Override
	public String getText(Object element) {
		return getStyledText(element).getString();
	}


}
