package fr.univnantes.termsuite.ui.viewers;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ITreeContentProvider;

import fr.univnantes.termsuite.model.Property;
import fr.univnantes.termsuite.model.RelationProperty;
import fr.univnantes.termsuite.model.TermProperty;

public class PropertyContentProvider implements ITreeContentProvider{

	private Predicate<Property<?>> predicate = p -> true;
	
	public PropertyContentProvider(Predicate<Property<?>> predicate) {
		super();
		this.predicate = predicate;
	}

	private static enum CNode{TERM, VARIATION}
	@Override
	public Object[] getElements(Object inputElement) {
		return new CNode[]{CNode.TERM, CNode.VARIATION};
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return Arrays.stream(parentElement == CNode.TERM ? TermProperty.values() : RelationProperty.values())
					.filter(predicate)
					.collect(Collectors.toList()).toArray();
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
