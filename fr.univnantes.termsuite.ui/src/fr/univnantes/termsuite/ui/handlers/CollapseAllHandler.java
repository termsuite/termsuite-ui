package fr.univnantes.termsuite.ui.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.viewers.TreePath;

import fr.univnantes.termsuite.ui.util.treeviewer.TreePart;

public class CollapseAllHandler {

	public static final String ID = "fr.univnantes.termsuite.ui.handler.CollapaseAllHandler";
	
	@Execute
	public void execute(MPart part) {
		((TreePart) part.getObject()).getTreeViewer().collapseAll();
	}
	
	@CanExecute
	public boolean canExecute(MPart part) {
		if(part != null && part.getObject() instanceof TreePart) {
			TreePath[] expandedTreePaths = ((TreePart) part.getObject()).getTreeViewer().getExpandedTreePaths();
			return expandedTreePaths.length > 0;			
		} else
			return false;
	}

}
