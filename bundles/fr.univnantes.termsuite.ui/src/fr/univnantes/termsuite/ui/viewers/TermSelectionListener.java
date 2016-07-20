package fr.univnantes.termsuite.ui.viewers;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import eu.project.ttc.engines.BilingualAligner.TranslationCandidate;
import eu.project.ttc.models.Term;
import eu.project.ttc.models.TermVariation;
import fr.univnantes.termsuite.ui.parts.TermOutlinePart;
import fr.univnantes.termsuite.ui.services.TermSuiteSelectionService;

public class TermSelectionListener implements ISelectionChangedListener {
	
	@Inject
	private TermSuiteSelectionService termSuiteSelectionService;

	@Inject
	private ESelectionService selectionService;

	@Inject
	private EPartService partService;

	
	 @Override
	public void selectionChanged(SelectionChangedEvent event) {
	      IStructuredSelection selection = (IStructuredSelection) event.getSelection();
	      // set the selection to the service
	      if(selection.size() == 1) {
	    	  Object sel = selection.getFirstElement();
	    	  Term t;
	    	  if(sel instanceof TermVariation)
	    		  t = ((TermVariation)sel).getVariant();
	    	  else if(sel instanceof TranslationCandidate)
	    		  t = ((TranslationCandidate)sel).getTerm();
	    	  else if(sel instanceof Term)
	    		  t = (Term)sel;
	    	  else
	    		  throw new IllegalStateException();
	    	  selectionService.setSelection(t);
	    	  termSuiteSelectionService.setActiveTerm(t);
	    	  MPart outlinePart = partService.findPart(TermOutlinePart.ID);
	    	  if(outlinePart != null)
	    		  partService.bringToTop(outlinePart);
	      }
	}
}
