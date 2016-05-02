package fr.univnantes.termsuite.ui.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.ui.di.UISynchronize;

import eu.project.ttc.models.TermIndex;
import eu.project.ttc.tools.PipelineListener;
import eu.project.ttc.tools.TermSuitePipeline;
import fr.univnantes.termsuite.ui.TermSuiteUI;

public class RunPipelineJob extends Job {

	public static final ISchedulingRule MUTEX_RULE = new ISchedulingRule() {
		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}

		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}
	};

	
	private TermSuitePipeline tsp;
	private UISynchronize sync;
	
	public RunPipelineJob(String name, 
			TermSuitePipeline tsp,
			UISynchronize sync) {
		super(name);
		this.sync = sync;
		this.tsp = tsp;
		setPriority(Job.BUILD);
		
		/*
		 * Prevents two RunPipelineJob to execute at the same time.
		 */
		setRule(MUTEX_RULE);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		final int totalWork = 10000;
		final SubMonitor subMonitor = SubMonitor.convert(monitor, totalWork);
		try {
			PipelineListener pipelineListener = new PipelineListener() {
				private int lastProgress = 0;
				@Override
				public void statusUpdated(final double progress, final String status) {
					if(subMonitor.isCanceled()) {
						throw new OperationCanceledException();
					}
					sync.asyncExec(new Runnable() {
						@Override
						public void run() {
							int newProgress = (int)(progress * totalWork);
							int worked = newProgress - lastProgress;
							lastProgress = newProgress;
							subMonitor.newChild(worked).setTaskName(status);
						}
					});
				}
			};
			tsp.addPipelineListener(pipelineListener);
			tsp.run();
			terminologyCreated(tsp.getTermIndex());
			return Status.OK_STATUS;
		} catch(Exception e) {
			if(e.getCause() != null && e.getCause() instanceof OperationCanceledException)
				return Status.CANCEL_STATUS;
			else if(e.getCause() != null && e.getCause().getCause() != null && e.getCause().getCause() instanceof OperationCanceledException)
				return Status.CANCEL_STATUS;
			else
				return new Status(Status.ERROR, TermSuiteUI.PLUGIN_ID, e.getMessage(), e);
		} finally {
			subMonitor.done();
		}
		// If you want to update the UI
	}
	

	public void terminologyCreated(TermIndex termIndex) {
		
	}
}
