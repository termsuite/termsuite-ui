package fr.univnantes.termsuite.ui.control;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.services.NLPService;
import fr.univnantes.termsuite.ui.util.FileUtil;

public class WorskpaceSizeControl {

	public WorskpaceSizeControl() {
		// No default behavior.
	}

	Label l;

	@PostConstruct
	public Control createContents(Composite parent, NLPService nlpService, ECommandService commandService, EHandlerService handlerService) {
		l = new Label(parent, SWT.None);
		int size = 0;
		updateSize(nlpService);
		Button b = new Button(parent, SWT.PUSH);
		b.setImage(TermSuiteUI.getImg(TermSuiteUI.IMG_CLEAR_CO).createImage());
		b.setSize(50, -1);
		b.setToolTipText("Clear all preprocessed corpus save in cache");
		b.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Command command = commandService.getCommand(TermSuiteUI.COMMAND_CLEAR_CACHE_ID);
			    ParameterizedCommand pCmd = new ParameterizedCommand(command, null);
			    if (handlerService.canExecute(pCmd)) 
			    	handlerService.executeHandler(pCmd);
			}
		});
		return parent;
	}
	
	@Inject @Optional
	private void corpusPreprocessed(@UIEventTopic(TermSuiteEvents.CORPUS_PREPROCESSED) Object object, NLPService nlpService) {
		updateSize(nlpService);
	}

	@Inject @Optional
	private void cacheCleared(@UIEventTopic(TermSuiteEvents.CACHE_CLEARED) Object object, NLPService nlpService) {
		updateSize(nlpService);
	}

	private void updateSize(NLPService nlpService) {
		long sizeInMb = FileUtil.folderSize(nlpService.getNlpCachePath().toFile()) / (1024*1024);
		l.setText(String.format("Preprocessing cache: %dMb ", sizeInMb));
	}
}
