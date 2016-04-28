package fr.univnantes.termsuite.ui.viewers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.StyledString;

import com.google.common.primitives.Ints;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.UITermProperty;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;

public class TermLabelProvider extends ColumnLabelProvider implements IStyledLabelProvider {

	private UITermProperty property;
	private ETerminoViewerConfig viewerConfig;
	
	public TermLabelProvider(UITermProperty property, ETerminoViewerConfig viewerConfig) {
		super();
		this.property = property;
		this.viewerConfig = viewerConfig;
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		Pattern pattern = viewerConfig.getSearchString().trim().isEmpty() ? null
				: Pattern.compile(viewerConfig.getSearchString());
		Matcher matcher;
		int b = 0;
		int e = 0;

		Object value = property.getValue(element);
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
