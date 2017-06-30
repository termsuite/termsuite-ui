package fr.univnantes.termsuite.ui.dialogs;

import java.util.Optional;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.Lists;

import fr.univnantes.termsuite.engines.cleaner.TerminoFilterOptions;
import fr.univnantes.termsuite.engines.cleaner.TerminoFilterOptions.FilterType;
import fr.univnantes.termsuite.model.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteUI;

public class FilterTerminologyDialog extends Dialog {

	private TerminoFilterOptions filterOptions;
	private Label statusLabel;
	private Text propertyName;
	private Button topNButton;
	private Text topNValue;
	private Text maxVariantNum;

	private Button alwaysKeepVariants;

	private Button thresholdButton;
	private Text thresholdValue;

	public FilterTerminologyDialog(Shell parentShell) {
		super(parentShell);
		filterOptions = new TerminoFilterOptions();
	}

	public TerminoFilterOptions getFilterOptions() {
		return filterOptions;
	}
	
    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }
    
	@Override
	protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout(3, false);
        layout.marginRight = 5;
        layout.marginLeft = 10;
        container.setLayout(layout);
        
        
        Label propertyLabel = new Label(container, SWT.NONE);
        propertyLabel.setText("On property:");
        GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(propertyLabel);
        
        propertyName = new Text(container, SWT.NONE);
        propertyName.setEditable(false);
        propertyName.setText(filterOptions.getFilterProperty().getPropertyName());
        propertyName.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDown(MouseEvent e) {
        		selectProperty();
        	}
		});
        GridDataFactory.fillDefaults().grab(true, false).applyTo(propertyName);
        
        Button selectPropertyButton = new Button(container, SWT.PUSH);
        selectPropertyButton.setText("Change...");
        selectPropertyButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		selectProperty();
        	}
		});

        GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(selectPropertyButton);
        
        /*
         * Top n
         */
        topNButton = new Button(container, SWT.RADIO); 
        topNButton.setText("Keep top n terms:");
		topNButton.setSelection(filterOptions.getFilterType() == FilterType.TOP_N);
		topNButton.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		refresh();
        	};
		});
        topNValue = new Text(container, SWT.BORDER);
        topNValue.setText(Integer.toString(filterOptions.getTopN()));
        topNValue.addModifyListener(e -> {
        	refresh();
        });
        GridDataFactory.swtDefaults().span(2, 1).applyTo(topNValue);

        /*
         * Threshold
         */
        thresholdButton = new Button(container, SWT.RADIO); 
        thresholdButton.setText("Keep over threshold:");
		thresholdButton.setSelection(filterOptions.getFilterType() == FilterType.THRESHOLD);
        thresholdButton.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		refresh();
        	};
        });
        thresholdValue = new Text(container, SWT.BORDER);
		thresholdValue.setText(filterOptions.getThreshold().toString());
        thresholdValue.addModifyListener(e -> {
        	refresh();
        });
        GridDataFactory.swtDefaults().span(2, 1).applyTo(thresholdValue);

        
        /*
         * Max varianty number
         */
        new Label(container, SWT.NONE).setText("Maximum number of variants per term:");
        
        maxVariantNum = new Text(container, SWT.BORDER);
        maxVariantNum.setText(Integer.toString(filterOptions.getMaxVariantNum()));
        maxVariantNum.addModifyListener(e -> {
        	refresh();
        });
        GridDataFactory.swtDefaults().span(2, 1).applyTo(maxVariantNum);

        
        /*
         * Keep Variants ?
         */
        alwaysKeepVariants = new Button(container, SWT.CHECK);
        alwaysKeepVariants.setSelection(filterOptions.isKeepVariants());
        alwaysKeepVariants.setText("Always keep term variants even if they should be filtered");
        alwaysKeepVariants.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		refresh();
        	};
        });
        GridDataFactory.fillDefaults().grab(true, true).span(3, 1).applyTo(alwaysKeepVariants);

        
        statusLabel = new Label(container, SWT.NONE);
        statusLabel.setForeground(TermSuiteUI.COLOR_RED);
        GridDataFactory.fillDefaults().grab(true, true).span(3, 1).applyTo(statusLabel);

        return container;
	}
	
	private void selectProperty() {
		SelectPropertyDialog dialog = new SelectPropertyDialog(
				getParentShell(), 
				Lists.newArrayList(filterOptions.getFilterProperty()), 
				p -> p instanceof TermProperty && p.isNumeric(),
				true);
		if(dialog.open() == Dialog.OK && dialog.getSelectedProperties().size() == 1) {
			TermProperty p = (TermProperty)dialog.getSelectedProperties().iterator().next();
			propertyName.setText(p.getPropertyName());
			refresh();
		}
	}

	private void refresh() {
		thresholdValue.setEnabled(thresholdButton.getSelection());
		topNValue.setEnabled(!thresholdButton.getSelection());
		getButton(IDialogConstants.OK_ID).setEnabled(isValid());
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
        refresh();
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Filter options");
	}
	
	private String getValidationStatus() {
		try {
			if(topNButton.getSelection())
				filterOptions.keepTopN(Integer.parseInt(topNValue.getText()));
		} catch (Exception e) {
			return "Top N must be an integer.";
		}
		try {
			filterOptions.setMaxVariantNum(Integer.parseInt(maxVariantNum.getText()));
		} catch (Exception e) {
			return "The maximum number of variants must be an integer.";
		}
		try {
			if(thresholdButton.getSelection())
				filterOptions.keepOverTh(Double.parseDouble(thresholdValue.getText()));
		} catch (Exception e) {
			return "Bad number format for threshold.";
		}
		Optional<TermProperty> termProperty = TermProperty.forNameOptional(propertyName.getText());
		if(!termProperty.isPresent()) {
			return "Not a term property: " + termProperty.get();
		} else if(!termProperty.get().isNumeric()) {
			return "Not a numeric term property: " + termProperty.get();
		} else 
			filterOptions.setProperty(termProperty.get());
		filterOptions.setKeepVariants(alwaysKeepVariants.getSelection());
		filterOptions.setFilterType(topNButton.getSelection() ? FilterType.TOP_N : FilterType.THRESHOLD);
		return null;
	}

	private boolean isValid() {
		String validationStatus = getValidationStatus();
		statusLabel.setText(validationStatus == null ? "" : validationStatus);
		return validationStatus == null;
	}


	@Override
	protected void okPressed() {
		
		super.okPressed();
	}
	
}
