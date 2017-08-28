package fr.univnantes.termsuite.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.io.json.JsonOptions;

public class JSONOptionsDialog extends Dialog {

	private JsonOptions jsonOptions;
	private Button withContext;
	private Button withOccurrences;
	

	public JSONOptionsDialog(Shell parentShell) {
		super(parentShell);
		jsonOptions = new JsonOptions();
	}


	public JsonOptions getJsonOptions() {
		return jsonOptions;
	}
	
    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }
    
    @Override
    protected void configureShell(Shell newShell) {
    	super.configureShell(newShell);
    	newShell.setText("TSV Export Options");
    }
    
	@Override
	protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout(3, false);
        layout.marginRight = 5;
        layout.marginLeft = 10;
        container.setLayout(layout);
        
        
        Label lblProperties = new Label(container, SWT.NONE);
        lblProperties.setText("Properties:");
        GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(lblProperties);
        
        
        withContext = new Button(container, SWT.CHECK); 
        withContext.setText("Store term contexts to the exported file");
        withContext.setSelection(jsonOptions.isWithContexts());
        GridDataFactory.swtDefaults().span(3, 1).applyTo(withContext);

        withOccurrences = new Button(container, SWT.CHECK); 
        withOccurrences.setText("Store term occurrences to the exported file");
        withOccurrences.setSelection(jsonOptions.isEmbeddedOccurrences());
        GridDataFactory.swtDefaults().span(3, 1).applyTo(withOccurrences);

        return container;
	}
	
	@Override
	protected void okPressed() {
		jsonOptions
			.withOccurrences(withOccurrences.getSelection())
			.withContexts(withContext.getSelection());
		
		super.okPressed();
	}
	
}
