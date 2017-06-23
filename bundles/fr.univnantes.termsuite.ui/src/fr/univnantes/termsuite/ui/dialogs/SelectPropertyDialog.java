package fr.univnantes.termsuite.ui.dialogs;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.ui.viewers.PropertyContentProvider;
import fr.univnantes.termsuite.ui.viewers.PropertyLabelProvider;


public class SelectPropertyDialog extends CheckedTreeSelectionDialog {
	
	public SelectPropertyDialog(Shell parent, List<Property<?>> selectedProperies) {
		super(parent, new PropertyLabelProvider(), new PropertyContentProvider());
		setContainerMode(true);
		setEmptyListMessage("No property to display.");
		setTitle("Select term and variation properties to show as columns");
		setInput(new Object());
		setInitialElementSelections(selectedProperies);
//		setExpandedElements(Iterables.toArray(inputCorpus, ECorpus.class));
	}

	
	public List<Property<?>> getSelectedProperties() {
		List<Property<?>> l = new ArrayList<>();
		for(Object o:getResult())
			if(o instanceof Property<?>)
				l.add((Property<?>)o);
		return l;
	}
//	@Override
//	public void create() {
//		super.create();
//		setTitle("");
//	}
//	
//	
//	public EList<String> getSelectedProperies() {
//		return selectedProperies;
//	}
//	
//	
//	@Override
//	protected Control createDialogArea(Composite parent) {
//	    Composite p = (Composite) super.createDialogArea(parent);
//	    Composite container = new Composite(p, SWT.NONE);
//	    GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
//	    create(container);
//		return container;
//	}
//
//	private void create(Composite parent) {
//	    Table table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION| SWT.CHECK);
//	    table.setLinesVisible(true);
//	    table.setHeaderVisible(true);
//	    String[] titles = { "Name", "Applies to", "Description"};
//	    for (int i = 0; i < titles.length; i++) {
//	      TableColumn column = new TableColumn(table, SWT.NONE);
//	      column.setText(titles[i]);
//	    }
//		
//	    for(TermProperty p:TermProperty.values()) {
//	    	String string = "Term";
//	        addPropertyItem(table, p, string);
//	    }
//	    for(RelationProperty p:RelationProperty.values()) {
//	    	String string = "Variation";
//	        addPropertyItem(table, p, string);
//	    }
//	}
//
//	private void addPropertyItem(Table table, Property<?> property, String appliesTo) {
//		TableItem item = new TableItem(table, SWT.NONE);
//		item.setChecked(selectedProperies.contains(property.getPropertyName()));
//		item.setText(0, property.getPropertyName());
//		item.setText(1, appliesTo);
//		item.setText(2, property.getDescription());
//	}


	public List<String> getSelectedPropertyNames() {
		return getSelectedProperties().stream().map(Property::getPropertyName).collect(Collectors.toList());
	}
}
