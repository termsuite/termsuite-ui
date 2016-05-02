package fr.univnantes.termsuite.ui.controls;

import java.util.EventObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import fr.univnantes.termsuite.ui.TermSuiteEvents;

public class SearchToolItem {
	public static final int DELAY = 1000;

	@Inject
	IEventBroker eventBroker;

	@Inject
	UISynchronize sync;

	@PostConstruct
	public void createControls(Composite parent) {
		final Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout());
		final DelayableText text = new DelayableText(DELAY, comp, SWT.SEARCH | SWT.ICON_SEARCH | SWT.CANCEL | SWT.BORDER);
		text.setMessage("Search");
		GridDataFactory.fillDefaults().hint(130, SWT.DEFAULT).applyTo(text);
		text.addDelayedModificationListener(new DelayedModificationListener() {
				
			@Override
			public void modifyText(final EventObject e) {
				sync.asyncExec(new Runnable() {
					@Override
					public void run() {
						eventBroker.post(TermSuiteEvents.SEARCH_TEXT_MODIFIED, ((DelayableText)e.getSource()).getText());
					}
				});

			}
		});

	}
}
