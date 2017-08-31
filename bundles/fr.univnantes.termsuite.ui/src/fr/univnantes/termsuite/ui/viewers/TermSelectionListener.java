package fr.univnantes.termsuite.ui.viewers;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import fr.univnantes.termsuite.alignment.TranslationCandidate;
import fr.univnantes.termsuite.framework.service.RelationService;
import fr.univnantes.termsuite.framework.service.TermService;
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
	    	  TermService t;
	    	  if(sel instanceof RelationService)
	    		  t = ((RelationService)sel).getTo();
	    	  else if(sel instanceof TranslationCandidate)
	    		  t = ((TranslationCandidate)sel).getTerm();
	    	  else if(sel instanceof TermService)
	    		  t = (TermService)sel;
	    	  else
	    		  throw new IllegalStateException("No such selected type allowed: " + sel.getClass());
	    	  selectionService.setSelection(t);
	    	  termSuiteSelectionService.setActiveTerm(t);
	    	  MPart outlinePart = partService.findPart(TermOutlinePart.ID);
	    	  if(outlinePart != null)
	    		  partService.bringToTop(outlinePart);
	      }
	}
}
