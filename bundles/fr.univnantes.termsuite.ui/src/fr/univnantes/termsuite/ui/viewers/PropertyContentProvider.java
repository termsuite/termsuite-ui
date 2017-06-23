package fr.univnantes.termsuite.ui.viewers;

import org.eclipse.jface.viewers.ITreeContentProvider;

import fr.univnantes.termsuite.model.RelationProperty;
import fr.univnantes.termsuite.model.TermProperty;

public class PropertyContentProvider implements ITreeContentProvider{

	private static enum CNode{TERM, VARIATION}
	@Override
	public Object[] getElements(Object inputElement) {
		return new CNode[]{CNode.TERM, CNode.VARIATION};
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return parentElement == CNode.TERM ? 
				TermProperty.values() :
					RelationProperty.values();
	}

	@Override
	public Object getParent(Object element) {
		return element instanceof TermProperty ? CNode.TERM : CNode.VARIATION;
	}

	@Override
	public boolean hasChildren(Object element) {
		return element instanceof CNode;
	}

}
