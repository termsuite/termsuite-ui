package fr.univnantes.termsuite.ui.styles;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

public class BoldFontStyler extends Styler {
	@Override
	public void applyStyles(final TextStyle textStyle) {
		FontDescriptor boldDescriptor = FontDescriptor.createFrom(new FontData()).setStyle(SWT.BOLD);
		Font boldFont = boldDescriptor.createFont(Display.getCurrent());
		textStyle.font = boldFont;
	}
}
