package fr.univnantes.termsuite.ui.util.jface;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;

public class ExpandCollapseDoubleClickListener implements IDoubleClickListener {

	TreeViewer viewer;

	public ExpandCollapseDoubleClickListener(TreeViewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		if (selection == null || selection.isEmpty())
			return;
		final Object sel = selection.getFirstElement();

		final ITreeContentProvider provider = (ITreeContentProvider) viewer.getContentProvider();

		if (!provider.hasChildren(sel))
			return;

		if (viewer.getExpandedState(sel))
			viewer.collapseToLevel(sel, AbstractTreeViewer.ALL_LEVELS);
		else
			viewer.expandToLevel(sel, 1);

	}
}
