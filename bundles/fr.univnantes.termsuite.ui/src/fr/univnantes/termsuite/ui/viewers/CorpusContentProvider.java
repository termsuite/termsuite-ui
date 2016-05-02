package fr.univnantes.termsuite.ui.viewers;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;

public class CorpusContentProvider implements ITreeContentProvider {
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}
	
	@Override
	public void dispose() {
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
		return ((Collection<?>) inputElement).toArray();
	}
	
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ECorpus) {
			ECorpus c = (ECorpus) parentElement;
			return c.getSingleLanguageCorpora().toArray();
		} 
		return null;
	}
	
	@Override
	public Object getParent(Object element) {
		return null;
	}
	
	@Override
	public boolean hasChildren(Object element) {
		if(element instanceof ECorpus)
			return true;
		else
			return false;
	}
}
