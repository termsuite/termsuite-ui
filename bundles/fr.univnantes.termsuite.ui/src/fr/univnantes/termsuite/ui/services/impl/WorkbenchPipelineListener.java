package fr.univnantes.termsuite.ui.services.impl;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.e4.ui.di.UISynchronize;

import fr.univnantes.termsuite.api.PipelineListener;

public class WorkbenchPipelineListener implements PipelineListener {
	private int lastProgress;
	private int totalWork;
	private UISynchronize sync;
	private SubMonitor monitor;
	
	public WorkbenchPipelineListener(SubMonitor monitor, UISynchronize sync, int totalWork) {
		super();
		this.lastProgress = 0;
		this.monitor = monitor;
		this.sync = sync;
		this.totalWork = totalWork;
	}


	@Override
	public void statusUpdated(final double progress, final String status) {
		if(monitor.isCanceled()) 
			throw new OperationCanceledException();
		sync.asyncExec(()-> {
				int newProgress = (int)(progress * totalWork);
				int worked = newProgress - lastProgress;
				lastProgress = newProgress;
				monitor.newChild(worked).setTaskName(status);
			}
		);
	}

}
