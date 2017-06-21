package fr.univnantes.termsuite.ui.dialogs;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import fr.univnantes.termsuite.ui.services.ResourceService;

public class RenameDialog extends TitleAreaDialog {

	ResourceService resourceService;
	EObject resource;
	String newName;

	public RenameDialog(Shell parentShell, ResourceService resourceService, EObject resource) {
		super(parentShell);
		this.resourceService = resourceService;
		this.resource = resource;
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("Rename " + resourceService.getResourceName(resource));
	}
	
	private Text text;
	
	public String getNewName() {
		return newName;
	}
	
	private final Pattern startsWithChar = Pattern.compile("[a-zA-Z](\\w|-)*");
	public void validate(String value) {
		if (value == null || !startsWithChar.matcher(value.toString()).matches()) 
			error(value + " is not a valid file name. Valid chars : letters, digits, - and _");
		else {
			String status = resourceService.canRename(resource, value);
			if(status == null) {
				setMessage("Ok", IMessageProvider.NONE);
				getButton(IDialogConstants.OK_ID).setEnabled(true);
			} else
				error(status);
		}
		getShell().redraw();
	}

	private void error(String msg) {
		setMessage(msg, IMessageProvider.ERROR);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
	    Composite p = (Composite) super.createDialogArea(parent);
	    Composite container = new Composite(p, SWT.NONE);
	    GridDataFactory.fillDefaults().grab(true, true).applyTo(container);

	    GridLayoutFactory.fillDefaults().margins(10,  10).numColumns(2).applyTo(container);
		new Label(container, SWT.NONE).setText("New name:");
		
		text = new Text(container, SWT.BORDER);
		text.setText(resourceService.getResourceName(resource));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
		
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate(((Text)e.getSource()).getText());
			}
		});
		return container;
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		validate(text.getText());
		return control;
	}
	
	
	@Override
	protected void okPressed() {
		this.newName = this.text.getText();
		super.okPressed();
	}
}
