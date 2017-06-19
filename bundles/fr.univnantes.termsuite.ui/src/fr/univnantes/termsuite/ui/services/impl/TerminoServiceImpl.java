package fr.univnantes.termsuite.ui.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.TerminoService;

public class TerminoServiceImpl implements TerminoService {
	@Inject 
	IEclipseContext context;

	@Inject 
	IEventBroker eventBroker;


	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL) 
	private Shell parent;
	


	@Override
	public ETerminology createTerminology(ESingleLanguageCorpus corpus, String terminologyName, String filepath, EOccurrenceMode occMode, boolean hasContexts) {
		/*
		 * Ensure that any termino with the same name is removed. 
		 * (Override behaviour)
		 */
		
		for(Iterator<ETerminology> it = corpus.getTerminologies().iterator(); it.hasNext(); )
			if(it.next().getName().equals(terminologyName))
				it.remove();
		ETerminology terminology = TermsuiteuiFactory.eINSTANCE.createETerminology();
		terminology.setFilepath(filepath);
		terminology.setName(terminologyName);
		terminology.setHasOccurrences(occMode != EOccurrenceMode.DO_NOT_KEEP);
		terminology.setHasContexts(hasContexts);
		
		corpus.getTerminologies().add(terminology);
		
		return terminology;
	}
	
	
	@Override
	public void removeTerminology(ETerminology s) {
		ECorpus corpus = s.getCorpus().getCorpus();
		s.getCorpus().getTerminologies().remove(s);
		try {
			context.get(CorpusService.class).saveCorpus(corpus);
			new File(s.getFilepath()).delete();
			eventBroker.post(TermSuiteEvents.TERMINOLOGY_REMOVED, s);
		} catch (IOException e) {
			e.printStackTrace();
			MessageDialog.openError(parent, "Error", "Could not remove the terminology. Error: " + e.getMessage());
		}
	}

}
