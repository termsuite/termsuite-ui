package fr.univnantes.termsuite.ui.viewers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if (object instanceof TermService) 
			return getPropertyValue(((TermService)object).getTerm());
		else if (object instanceof RelationService) 
			return getPropertyValue(((RelationService)object).getTo().getTerm());
		else if (object instanceof Term) 
			return getTermPropertyValue((Term) object);
		else if (object instanceof Relation) 
			return getRelationPropertyValue((Relation) object);
		throw new IllegalArgumentException("Not a supported type for TermLabelProvider: " + object.getClass());
		
		
	}
	@Override
	public StyledString getStyledText(Object element) {
		Pattern pattern = viewerConfig.getSearchString().trim().isEmpty() ? null
				: Pattern.compile(viewerConfig.getSearchString());
		Matcher matcher;
		int b = 0;
		int e = 0;

		Object value = getPropertyValue(element);
		if(value == null)
			return new StyledString();
		if(property.getRange().equals(String.class)) {
			String str = (String) value;
			if (pattern != null && (matcher = pattern.matcher(str)).find()) {
				b = matcher.start();
				e = matcher.end();
			}
			StyledString styledString = new StyledString();
	
			styledString.append(str.substring(0, Ints.min(b, str.length())), StyledString.COUNTER_STYLER);
			styledString.append(str.substring(Ints.min(b, str.length()), Ints.min(e, str.length())),
					TermSuiteUI.STYLE_GRAYED_BOLD);
			styledString.append(str.substring(Ints.min(e, str.length()), str.length()),
					StyledString.COUNTER_STYLER);
			return styledString;
		} else if(property.isDecimalNumber()) {
			double v = (double)value;
			return new StyledString(String.format("%.2f", v));
		}
		else 
			return new StyledString(String.format("%d", value));
	}
	
	@Override
	public String getText(Object element) {
		return getStyledText(element).getString();
	}


}
