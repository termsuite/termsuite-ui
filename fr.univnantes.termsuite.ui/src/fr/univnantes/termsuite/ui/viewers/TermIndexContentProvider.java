package fr.univnantes.termsuite.ui.viewers;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import eu.project.ttc.models.Term;
import eu.project.ttc.models.TermVariation;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;

public class TermIndexContentProvider implements ITreeContentProvider {

	private ETerminoViewerConfig viewerConfig;

	public TermIndexContentProvider(ETerminoViewerConfig viewerConfig) {
		super();
		this.viewerConfig = viewerConfig;
	}

	Predicate<Object> isMatchingSearchText = new Predicate<Object>() {
		public boolean apply(Object termOrVariant) {
			if(!viewerConfig.getSearchString().trim().isEmpty()) {
				Pattern pattern = Pattern.compile(viewerConfig.getSearchString());
				if(termOrVariant instanceof Term) {
					Term t = (Term)termOrVariant;
					return pattern.matcher(t.getGroupingKey()).find()
							|| pattern.matcher(t.getPilot()).find();
				} else if (termOrVariant instanceof TermVariation) {
					TermVariation v = (TermVariation)termOrVariant;
					return pattern.matcher(v.getVariant().getGroupingKey()).find()
							|| pattern.matcher(v.getVariant().getPilot()).find();
				} else
					return false;
			} else
				return true;
		}
	};

	
	@Override
	public void dispose() {
	}

	private Collection<Term> sortedTerms;
	
	@SuppressWarnings("unchecked")
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.sortedTerms = (Collection<Term>)newInput;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		List<Term> terms = Lists.newArrayListWithCapacity(viewerConfig.getNbDisplayedTerms());
		int selected = 0;
		for(Term t:this.sortedTerms) {
			if(!isMatchingSearchText.apply(t))
				continue;
			else {
				selected++;
				if(selected > viewerConfig.getNbDisplayedTerms())
					break;
				terms.add(t);
			}
		}
		return terms.toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Term) {
			List<TermVariation> variations = Lists.newArrayList(((Term)parentElement).getVariations());
			return variations.toArray();
		}
		return null;
	}


	@Override
	public Object getParent(Object element) {
		if (element instanceof TermVariation) {
			return ((TermVariation)element).getBase();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Term) {
			Term term = (Term) element;
			return !term.getVariations().isEmpty();
		} else
			return false;

	}
}
