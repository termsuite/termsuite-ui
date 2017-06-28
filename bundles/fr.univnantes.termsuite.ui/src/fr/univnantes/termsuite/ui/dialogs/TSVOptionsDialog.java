package fr.univnantes.termsuite.ui.dialogs;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.io.tsv.TsvOptions;
import fr.univnantes.termsuite.io.tsv.TsvPropertyConfig;
import fr.univnantes.termsuite.model.Property;

public class TSVOptionsDialog extends Dialog {

	private TsvOptions tsvOptions;
	private Button showHeaders;
	private Button showVariants;
	private org.eclipse.swt.widgets.List propertyList;
	

	public TSVOptionsDialog(Shell parentShell) {
		super(parentShell);
		tsvOptions = new TsvOptions();
	}


	public TsvOptions getTsvOptions() {
		return tsvOptions;
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
        
        propertyList = new org.eclipse.swt.widgets.List(container, SWT.NONE);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(propertyList);
        Button selectPropertiesButton = new Button(container, SWT.PUSH);
        selectPropertiesButton.setText("Select...");
        selectPropertiesButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		List<Property<?>> properties2 = tsvOptions.properties()
        				.stream()
        				.map(TsvPropertyConfig::getProperty)
        				.collect(Collectors.toList());
        		
				SelectPropertyDialog dialog = new SelectPropertyDialog(parent.getShell(), properties2);
				if(dialog.open() == Dialog.OK) {
					tsvOptions.setProperties(dialog.getSelectedProperties());
					fillPropertyList();
				}
        	}

		});
        GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(selectPropertiesButton);
        fillPropertyList();
        
        showHeaders = new Button(container, SWT.CHECK); 
        showHeaders.setText("Show property names as first row");
        showHeaders.setSelection(tsvOptions.showHeaders());
        GridDataFactory.swtDefaults().span(3, 1).applyTo(showHeaders);

        showVariants = new Button(container, SWT.CHECK); 
        showVariants.setText("Export variants");
        showVariants.setSelection(tsvOptions.isShowVariants());
        GridDataFactory.swtDefaults().span(3, 1).applyTo(showVariants);

        return container;
	}
	
	@Override
	protected void okPressed() {
		tsvOptions
			.setShowVariants(showVariants.getSelection())
			.showHeaders(showHeaders.getSelection());
		
		super.okPressed();
	}
	
	private void fillPropertyList() {
		propertyList.removeAll();
		for(TsvPropertyConfig tsvPC:tsvOptions.properties())
			propertyList.add(tsvPC.getProperty().getPropertyName());
	}
}
