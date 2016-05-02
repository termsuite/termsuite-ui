package fr.univnantes.termsuite.ui.viewers;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.ComparisonChain;

import eu.project.ttc.models.TermVariation;
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


	private ViewerSorter variationSorter = new ViewerSorter() {
		public int compare(Viewer viewer, Object e1, Object e2) {
			if(e1 instanceof TermVariation && e2 instanceof TermVariation) {
				TermVariation v1 = (TermVariation) e1;
				TermVariation v2 = (TermVariation) e2;
				return ComparisonChain.start()
						.compare(
								v2.getScore(),
								v1.getScore())
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
		setSorter(variationSorter);
		setContentProvider(new TermIndexContentProvider(config));

		addDoubleClickListener(new ExpandCollapseDoubleClickListener(this));

	}
	
	
}
