package fr.univnantes.termsuite.ui.dialogs;

import java.util.regex.Pattern;

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

import fr.univnantes.termsuite.ui.services.PipelineService;

public class NewPipelineDialog extends TitleAreaDialog {

	PipelineService pipelineService;
	
	public NewPipelineDialog(Shell parentShell, PipelineService pipelineService) {
		super(parentShell);
		this.pipelineService = pipelineService;
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("New Pipeline...");
	    setMessage("Enter the name of the new pipeline", IMessageProvider.INFORMATION);
	}
	
	
	private Text text;
	private String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	private final Pattern startsWithChar = Pattern.compile("[a-zA-Z](\\w|-)*");
	public void validate(Object value) {
		if (value != null && startsWithChar.matcher(value.toString()).matches()) {
			if(pipelineService.canCreatePipeline(value.toString())) {
				setMessage("Ok", IMessageProvider.NONE);
				getButton(IDialogConstants.OK_ID).setEnabled(true);
			} else {
				setMessage("Pipeline " + value + " already exists", IMessageProvider.ERROR);
				getButton(IDialogConstants.OK_ID).setEnabled(false);
			}
				
		} else {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
			setMessage(value + " is not a valid file name. Valid chars : letters, digits, - and _", IMessageProvider.ERROR);
		}
		getShell().redraw();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
	    Composite p = (Composite) super.createDialogArea(parent);
	    Composite container = new Composite(p, SWT.NONE);
	    GridDataFactory.fillDefaults().grab(true, true).applyTo(container);

	    GridLayoutFactory.fillDefaults().margins(10,  10).numColumns(2).applyTo(container);
		new Label(container, SWT.NONE).setText("Pipeline name:");
		
		text = new Text(container, SWT.BORDER);
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
	protected void okPressed() {
		this.filename = this.text.getText();
		super.okPressed();
	}
}
