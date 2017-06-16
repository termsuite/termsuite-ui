package fr.univnantes.termsuite.ui.viewers;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.ComparisonChain;

import fr.univnantes.termsuite.framework.service.RelationService;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import fr.univnantes.termsuite.ui.util.jface.ExpandCollapseDoubleClickListener;

/**
 * 
 * The viewer for a terminology.
 * 
 * @author Damien Cram
 *
 */
public class TermIndexViewer extends TreeViewer {


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
	

	public TermIndexViewer(ETerminoViewerConfig config, Composite parent, int style) {
		super(parent, style);
		config.eAdapters().add(new AdapterImpl() {
			public void notifyChanged(Notification notification) {
				switch (notification.getFeatureID(ETerminoViewerConfig.class)) {
				case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS:
					refresh();
					break;
				case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING:
					refresh();
				}
			}
		});
		
		getTree().setLinesVisible(true);
		getTree().setHeaderVisible(true);
		setComparator(variationComparator);
		setContentProvider(new TerminologyContentProvider(config));

		addDoubleClickListener(new ExpandCollapseDoubleClickListener(this));

	}
	
	
}
