package fr.univnantes.termsuite.ui.viewers;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.ComparisonChain;

import fr.univnantes.termsuite.framework.service.RelationService;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.util.TermFilter;
import fr.univnantes.termsuite.ui.util.VariationFilter;
import fr.univnantes.termsuite.ui.util.jface.ExpandCollapseDoubleClickListener;

/**
 * 
 * The viewer for a terminology.
 * 
 * @author Damien Cram
 *
 */
public class TerminologyViewer extends TreeViewer {

	private TerminologyContentProvider contentProvider;
	
	private ViewerComparator variationComparator = new ViewerComparator() {
		public int compare(Viewer viewer, Object e1, Object e2) {
			if(e1 instanceof RelationService && e2 instanceof RelationService) {
				RelationService v1 = (RelationService) e1;
				RelationService v2 = (RelationService) e2;
				return ComparisonChain.start()
						.compare(
								v2.getVariantScore(),
								v1.getVariantScore())
						.result();
			} else
				return 0;
		};
	};
	

	public TerminologyViewer(ETerminoViewerConfig config, Composite parent, int style) {
		super(parent, style);
		config.eAdapters().add(new AdapterImpl() {
			public void notifyChanged(Notification notification) {
				refresh();
			}
		});
		
		getTree().setLinesVisible(true);
		getTree().setHeaderVisible(true);
		setComparator(variationComparator);
		contentProvider = new TerminologyContentProvider(config);
		setContentProvider(contentProvider);
		addDoubleClickListener(new ExpandCollapseDoubleClickListener(this));
	}


	public void setFilters(TermFilter termFilter, VariationFilter variationFilter) {
		contentProvider.setFilters(termFilter, variationFilter);
		refresh();
	}


	public WritableValue<Integer> getNbTermsDisplayed() {
		return contentProvider.getNbTermsDisplayed();
	}
}
