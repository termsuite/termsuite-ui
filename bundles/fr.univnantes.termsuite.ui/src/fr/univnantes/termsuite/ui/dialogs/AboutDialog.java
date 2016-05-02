package fr.univnantes.termsuite.ui.dialogs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.util.FormTextUtil;

public class AboutDialog extends TitleAreaDialog {
//	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
//    DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
	
    public AboutDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("About TermSuite");
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormToolkit toolkit = new FormToolkit(container.getDisplay());
		ScrolledForm form = toolkit.createScrolledForm(container);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(form);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(form.getBody());
		form.getBody().setLayout(new GridLayout());
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		
	    FormText notice = toolkit.createFormText(form.getBody(), true);
		GridDataFactory.fillDefaults().hint(600, SWT.DEFAULT).applyTo(notice);
		StringBuffer buf = new StringBuffer();
		buf.append("<form>");
		buf.append("<p>"+TermSuiteUI.DESCRIPTION+"</p>");
		buf.append("<p>"+TermSuiteUI.COPYRIGHT+"</p>");
		buf.append("</form>");
		notice.setText(buf.toString(), true, false);

		GridDataFactory.fillDefaults().grab(true, false).applyTo(toolkit.createSeparator(form.getBody(), SWT.HORIZONTAL));

	    notice = toolkit.createFormText(form.getBody(), true);
		GridDataFactory.fillDefaults().hint(600, SWT.DEFAULT).applyTo(notice);
		buf = new StringBuffer();
		buf.append("<form>");
		buf.append("<p>Current version: "+Platform.getProduct().getDefiningBundle()+"</p>");
		buf.append("<p>Last modified: "+dateFormat.format(new Date(bundle.getLastModified()))+"</p>");
		buf.append("<p>Plugins:</p>");
		for(Bundle b:bundleContext.getBundles()) {
			if(b.getSymbolicName().startsWith("fr.univnantes.termsuite"))
				buf.append("<li>"+b.getSymbolicName()+":"+ b.getVersion()+"</li>");
		}
		buf.append("</form>");

		notice.setText(buf.toString(), true, false);

		GridDataFactory.fillDefaults().grab(true, false).applyTo(toolkit.createSeparator(form.getBody(), SWT.HORIZONTAL));

	    notice = toolkit.createFormText(form.getBody(), true);
		GridDataFactory.fillDefaults().hint(600, SWT.DEFAULT).applyTo(notice);
		buf = new StringBuffer();
		buf.append("<form>");
		buf.append("<p>Web site: <a href=\"web\">"+TermSuiteUI.WEB_SITE_URL+"</a></p>");
		buf.append("<p>Source code: <a href=\"github\">"+TermSuiteUI.GITHUB_URL+"</a></p>");
		buf.append("<p>Documentation: <a href=\"doc\">"+TermSuiteUI.WEB_SITE_DOC_URL+"</a></p>");
		buf.append("</form>");
		FormTextUtil.bindToExternalLink(notice, "web", TermSuiteUI.WEB_SITE_URL);
		FormTextUtil.bindToExternalLink(notice, "github", TermSuiteUI.GITHUB_URL);
		FormTextUtil.bindToExternalLink(notice, "doc", TermSuiteUI.WEB_SITE_DOC_URL);
		notice.setText(buf.toString(), true, false);

		
		return container;
	}
}
