package fr.univnantes.termsuite.ui.styles;

import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.TextStyle;

public class ColoredFontStyler extends Styler {
	
	private Color foregroundColor = null;
	private Color backgroundColor = null;
	private Font font = null;

	ColoredFontStyler() {
		super();
	}

	@Override
	public void applyStyles(final TextStyle textStyle) {
		textStyle.font = font;
		textStyle.foreground = foregroundColor;
		textStyle.background = backgroundColor;
	}
	
	void setFont(Font font) {
		this.font = font;
	}
	
	void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
	}
	
	void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
}
