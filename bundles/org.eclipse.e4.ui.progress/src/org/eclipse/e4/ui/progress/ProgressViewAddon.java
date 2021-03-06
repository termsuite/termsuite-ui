/*******************************************************************************
 * Copyright (c) 2010, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.e4.ui.progress;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.progress.internal.PreferenceStore;
import org.eclipse.e4.ui.progress.internal.Preferences;
import org.eclipse.e4.ui.progress.internal.ProgressManager;
import org.eclipse.e4.ui.progress.internal.ProgressViewUpdater;
import org.eclipse.e4.ui.progress.internal.Services;

@SuppressWarnings("restriction")
public class ProgressViewAddon {

	@PostConstruct
	public void init(ILoggerProvider loggerProvider, MApplication application, IEclipseContext context) {
		loggerProvider.getClassLogger(this.getClass()).debug("Entering ProgressViewAddon@PostConstruct");
		IEclipseContext appContext = application.getContext();
		appContext.set(Preferences.class, ContextInjectionFactory.make(Preferences.class, appContext));
		appContext.set(PreferenceStore.class, ContextInjectionFactory.make(PreferenceStore.class, appContext));
		ContextInjectionFactory.make(Services.class, context);
		ProgressManager progressManager = ContextInjectionFactory.make(ProgressManager.class, context);
		appContext.set(ProgressManager.class, progressManager);
		// bug-fix: add a ProgressViewUpdater to the application context
		appContext.set(ProgressViewUpdater.class, ContextInjectionFactory.make(ProgressViewUpdater.class, appContext));
		loggerProvider.getClassLogger(this.getClass()).debug("Exiting ProgressViewAddon@PostConstruct");
	}
}
