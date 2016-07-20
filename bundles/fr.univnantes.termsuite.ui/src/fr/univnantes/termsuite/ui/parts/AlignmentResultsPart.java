 
package fr.univnantes.termsuite.ui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import eu.project.ttc.engines.BilingualAligner.TranslationCandidate;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.events.AlignmentResultPayload;
import fr.univnantes.termsuite.ui.viewers.TermSelectionListener;

public class AlignmentResultsPart {
	public static final String ID = "fr.univnantes.termsuite.ui.part.alignment";
	
	private TableViewer viewer;
	
	@PostConstruct
	public void postConstruct(IEclipseContext context, Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

		// create the columns
		// not yet implemented
		createColumns(viewer);

		// make lines and header visible
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		// attach a selection listener to our jface viewer
		viewer.addSelectionChangedListener(ContextInjectionFactory.make(TermSelectionListener.class, context));

	}


	private void createColumns(TableViewer viewer2) {
		TableViewerColumn colRank = new TableViewerColumn(viewer, SWT.NONE);
		colRank.getColumn().setWidth(40);
		colRank.getColumn().setText("#");
		colRank.setLabelProvider(new ColumnLabelProvider() {
			
			@Override
			public String getText(Object element) {
				TranslationCandidate c = (TranslationCandidate) element;
				return Integer.toString(c.getRank());
			}
		});

		
		
		TableViewerColumn colTerm = new TableViewerColumn(viewer, SWT.NONE);
		colTerm.getColumn().setWidth(200);
		colTerm.getColumn().setText("Term");
		colTerm.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				TranslationCandidate c = (TranslationCandidate) element;
				return c.getTerm().getPilot();
			}
		});

		// create more text columns if required...

		// create column for married property of Person
		// uses getImage() method instead of getText()
		// CHECKED and UNCHECK are fields of type Image

		TableViewerColumn colScore = new TableViewerColumn(viewer, SWT.NONE);
		colScore.getColumn().setWidth(50);
		colScore.getColumn().setText("Score");
		colScore.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				TranslationCandidate c = (TranslationCandidate) element;
				return String.format("%.1f", c.getScore()*100);
			}
		});
		
		TableViewerColumn colMethod = new TableViewerColumn(viewer, SWT.NONE);
		colMethod.getColumn().setWidth(80);
		colMethod.getColumn().setText("Method");
		colMethod.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				TranslationCandidate c = (TranslationCandidate) element;
				return c.getMethod().getShortName();
			}
		});

	}

	@Inject @Optional
	private void setAlignmentResults(
			@UIEventTopic(TermSuiteEvents.ALIGNEMENT_RESULT) AlignmentResultPayload payload
			) {
		viewer.setInput(payload.getTranslationCandidates());
	}
}