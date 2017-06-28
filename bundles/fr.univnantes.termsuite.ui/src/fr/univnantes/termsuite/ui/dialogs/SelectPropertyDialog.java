package fr.univnantes.termsuite.ui.dialogs;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.ui.viewers.PropertyContentProvider;
import fr.univnantes.termsuite.ui.viewers.PropertyLabelProvider;


public class SelectPropertyDialog extends CheckedTreeSelectionDialog {
	
	
	
	public SelectPropertyDialog(Shell parent, List<Property<?>> selectedProperies, Predicate<Property<?>> selectableProperties) {
		super(parent, new PropertyLabelProvider(), new PropertyContentProvider(selectableProperties));
		setContainerMode(true);
		setEmptyListMessage("No property to display.");
		setTitle("Select term and variation properties");
		setInput(new Object());
		setInitialElementSelections(selectedProperies);
	}
	
	
	@Override
	protected Point getInitialSize() {
		return new Point(800, 600);
	}
	@Override
	protected Control createDialogArea(Composite parent) {
		Control createDialogArea = super.createDialogArea(parent);
		getTreeViewer().expandAll();
		return createDialogArea;
	}

	
	public List<Property<?>> getSelectedProperties() {
		List<Property<?>> l = new ArrayList<>();
		for(Object o:getResult())
			if(o instanceof Property<?>)
				l.add((Property<?>)o);
		return l;
	}

	public List<String> getSelectedPropertyNames() {
		return getSelectedProperties().stream().map(Property::getPropertyName).collect(Collectors.toList());
	}


	public void setSingleSelection() {
		setStyle(SWT.SINGLE);
		
	}
}
