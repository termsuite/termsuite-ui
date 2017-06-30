package fr.univnantes.termsuite.ui.dialogs;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.model.RelationProperty;
import fr.univnantes.termsuite.model.TermProperty;


public class SelectPropertyDialog extends Dialog {
	
	
	private Predicate<Property<?>> selectableProperties;
	private boolean onlyOneAllowed;
	private List<Property<?>> selectedProperies;
	
	public SelectPropertyDialog(Shell parent, List<Property<?>> selectedProperies, Predicate<Property<?>> selectableProperties, boolean onlyOneAllowed) {
		super(parent);
		this.onlyOneAllowed = onlyOneAllowed;
		this.selectableProperties = selectableProperties;
		this.selectedProperies = selectedProperies;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select term and variation properties");
	}
	
	private Table table;
	
	@Override
	protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        FillLayout layout = new FillLayout();
        layout.marginHeight = 5;
        layout.marginWidth = 10;
        container.setLayout(layout);
 
        int style = SWT.FULL_SELECTION;

        style = onlyOneAllowed ? style | SWT.SINGLE : style | SWT.CHECK | SWT.HIDE_SELECTION;
		table = new Table(container, style);
        TableColumn column1 = new TableColumn(table, SWT.LEFT);
		column1.setText("Property");
		column1.setWidth(130);
		TableColumn column2 = new TableColumn(table, SWT.CENTER);
		column2.setText("Applies to");
		column2.setWidth(80);
		TableColumn column3 = new TableColumn(table, SWT.CENTER);
		column3.setText("Type");
		column3.setWidth(80);
		TableColumn column4 = new TableColumn(table, SWT.LEFT);
		column4.setText("Description");
		column4.setWidth(500);
		table.setHeaderVisible(true);

        for(TermProperty p:TermProperty.values())
        	addItem(p);
        for(RelationProperty p:RelationProperty.values())
        	addItem(p);
        
        return container;
	}

	private void addItem(Property<?> p) {
		if(selectableProperties.test(p)) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, p.getPropertyName());
			item.setText(1, p instanceof TermProperty ? "Term" : "Variation");
			item.setText(2, p.isNumeric() ? "Numeric" : p.getRange().equals(Boolean.class) ? "Boolean" : "String");
			item.setText(3, p.getDescription());
			item.setData(p);
			item.setChecked(selectedProperies.contains(p));
			if(selectedProperies.size() == 1 && selectedProperies.get(0).equals(p))
				table.setSelection(item);
		}
	}

	@Override
	protected Point getInitialSize() {
		return new Point(800, 600);
	}

	
	public List<Property<?>> getSelectedProperties() {
		List<Property<?>> l = new ArrayList<>();
		if(onlyOneAllowed && table.getSelection().length == 1) {
			l.add((Property<?>)table.getSelection()[0].getData());
		} else {
			for(TableItem item:table.getItems()) {
				if(item.getChecked()) 
					l.add((Property<?>)item.getData());
			}
		}
		return l;
	}

	public List<String> getSelectedPropertyNames() {
		return getSelectedProperties().stream().map(Property::getPropertyName).collect(Collectors.toList());
	}

}
