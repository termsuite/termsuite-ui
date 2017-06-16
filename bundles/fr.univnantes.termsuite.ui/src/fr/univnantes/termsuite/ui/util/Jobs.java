package fr.univnantes.termsuite.ui.util;

import org.eclipse.core.runtime.jobs.ISchedulingRule;

public class Jobs {

	/*
	 * A mutex lock for preventing two jobs to execute at the same time.
	 */
	public static final ISchedulingRule MUTEX_RULE = new ISchedulingRule() {
		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}

		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}
	};

}
