package fr.univnantes.termsuite.ui.styles;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class StylerBuilder {
	
	private ColoredFontStyler styler = new ColoredFontStyler();
	private FontDescriptor fontDescriptor = FontDescriptor.createFrom(Display.getCurrent().getSystemFont());
	
	private StylerBuilder() {
		super();
	}

	public static StylerBuilder start() {
		return new StylerBuilder();
	}

	public StylerBuilder fontStyle(int fontStyle) {
		fontDescriptor = fontDescriptor.setStyle(fontStyle);
		return this;
	}

	public StylerBuilder fontHeight(int fontHeight) {
		fontDescriptor = fontDescriptor.setHeight(fontHeight);
		return this;
	}

	public StylerBuilder color(int red, int green, int blue) {
		styler.setForegroundColor(new Color(Display.getCurrent(), red, green, blue));
		return this;
	}

	public Styler create() {
		styler.setFont(fontDescriptor.createFont(Display.getCurrent()));
		return styler;
	}


}
