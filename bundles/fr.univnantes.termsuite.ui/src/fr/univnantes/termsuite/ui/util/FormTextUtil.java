package fr.univnantes.termsuite.ui.util;

import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormText;

public class FormTextUtil {

	public static void bindToExternalLink(final FormText formText, final String key, final String webSiteTaggerDocUrl) {
		formText.addHyperlinkListener(new HyperlinkAdapter(){
			@Override
			public void linkActivated(HyperlinkEvent e) {
				if(e.getHref().equals(key)) {
					try {
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(webSiteTaggerDocUrl));
					} catch (IOException e1) {
						MessageDialog.openInformation(formText.getShell(), "No browser found", "Could not open the url in your Web browser.");
					}
				}
			}
		});
	}

}
