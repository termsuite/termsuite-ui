/*******************************************************************************
 * Copyright (c) 2003, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Philipp Bumann <bumannp@gmail.com> - Bug 477602
 *******************************************************************************/
package org.eclipse.e4.ui.progress.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.progress.IDisposableAction;
import org.eclipse.e4.ui.progress.IProgressConstants;

/**
 * This singleton remembers all JobTreeElements that should be preserved (e.g.
 * because their associated Jobs have the "keep" property set).
 */
@Creatable
@Singleton
public class FinishedJobs extends EventManager {

	/*
	 * Interface for notify listeners.
	 */
	static interface KeptJobsListener {

		/**
		 * A job to be kept has finished
		 *
		 * @param jte
		 */
		void finished(JobTreeElement jte);

		/**
		 * A kept job has been removed.
		 *
		 * @param jte
		 */
		void removed(JobTreeElement jte);
	}

	private IJobProgressManagerListener listener;

	private HashSet<JobTreeElement> keptjobinfos = new HashSet<>();

	private HashMap<Object, Long> finishedTime = new HashMap<>();

	private static JobTreeElement[] EMPTY_INFOS;

	@Inject
	ProgressManager progressManager;

	@PostConstruct
	void init(MApplication application) {
		progressManager.addListener(listener);
		EMPTY_INFOS = new JobTreeElement[0];
		// TODO E4 workaround for @creatable problem
		application.getContext().set(FinishedJobs.class, this);
	}

	public FinishedJobs() {
		listener = new IJobProgressManagerListener() {
			@Override
			public void addJob(JobInfo info) {
				checkForDuplicates(info);
			}

			@Override
			public void addGroup(GroupInfo info) {
				checkForDuplicates(info);
			}

			@Override
			public void refreshJobInfo(JobInfo info) {
				checkTasks(info);
			}

			@Override
			public void refreshGroup(GroupInfo info) {
			}

			@Override
			public void refreshAll() {
			}

			@Override
			public void removeJob(JobInfo info) {
				if (keep(info)) {
					checkForDuplicates(info);
					add(info);
				}
			}

			@Override
			public void removeGroup(GroupInfo group) {
			}

			@Override
			public boolean showsDebug() {
				return false;
			}
		};
	}

	/**
	 * Returns true if JobInfo indicates that it must be kept.
	 */
	static boolean keep(JobInfo info) {
		Job job = info.getJob();
		if (job != null) {
			Object prop = job.getProperty(ProgressManagerUtil.KEEP_PROPERTY);
			if (prop instanceof Boolean) {
				if (((Boolean) prop).booleanValue()) {
					return true;
				}
			}

			prop = job.getProperty(ProgressManagerUtil.KEEPONE_PROPERTY);
			if (prop instanceof Boolean) {
				if (((Boolean) prop).booleanValue()) {
					return true;
				}
			}

			IStatus status = job.getResult();
			if (status != null && status.getSeverity() == IStatus.ERROR) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Register for notification.
	 */
	void addListener(KeptJobsListener l) {
		addListenerObject(l);
	}

	/**
	 * Deregister for notification.
	 */
	void removeListener(KeptJobsListener l) {
		removeListenerObject(l);
	}

	private void checkForDuplicates(GroupInfo info) {
		Object[] objects = info.getChildren();
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof JobInfo) {
				checkForDuplicates((JobInfo) objects[i]);
			}
		}
	}

	private void checkForDuplicates(JobTreeElement info) {
		JobTreeElement[] toBeRemoved = findJobsToRemove(info);
		if (toBeRemoved != null) {
			for (int i = 0; i < toBeRemoved.length; i++) {
				remove(toBeRemoved[i]);
			}
		}
	}

	/**
	 * Add given Job to list of kept jobs.
	 */
	private void add(JobInfo info) {
		boolean fire = false;

		synchronized (keptjobinfos) {
			if (!keptjobinfos.contains(info)) {
				keptjobinfos.add(info);

				long now = System.currentTimeMillis();
				finishedTime.put(info, new Long(now));

				GroupInfo parent = info.getParent();
				if (!(parent == null || keptjobinfos.contains(parent))) {
					keptjobinfos.add(parent);
					finishedTime.put(parent, new Long(now));
				}

				fire = true;
			}
		}

		if (fire) {
			Object l[] = getListeners();
			for (int i = 0; i < l.length; i++) {
				KeptJobsListener jv = (KeptJobsListener) l[i];
				jv.finished(info);
			}
		}
	}

	static void disposeAction(JobTreeElement jte) {
		if (jte.isJobInfo()) {
			JobInfo ji = (JobInfo) jte;
			Job job = ji.getJob();
			if (job != null) {
				Object prop = job
						.getProperty(IProgressConstants.ACTION_PROPERTY);
				if (prop instanceof IDisposableAction) {
					((IDisposableAction) prop).dispose();
				}
			}
		}
	}

	private JobTreeElement[] findJobsToRemove(JobTreeElement info) {

		if (info.isJobInfo()) {
			Job myJob = ((JobInfo) info).getJob();

			if (myJob != null) {

				Object prop = myJob
						.getProperty(ProgressManagerUtil.KEEPONE_PROPERTY);
				if (prop instanceof Boolean && ((Boolean) prop).booleanValue()) {
					ArrayList<JobTreeElement> found = null;
					JobTreeElement[] all;
					synchronized (keptjobinfos) {
						all = keptjobinfos
								.toArray(new JobTreeElement[keptjobinfos.size()]);
					}
					for (int i = 0; i < all.length; i++) {
						JobTreeElement jte = all[i];
						if (jte != info && jte.isJobInfo()) {
							Job job = ((JobInfo) jte).getJob();
							if (job != null && job != myJob
									&& job.belongsTo(myJob)) {
								if (found == null) {
									found = new ArrayList<>();
								}
								found.add(jte);
							}
						}
					}
					if (found != null) {
						return found
								.toArray(new JobTreeElement[found.size()]);
					}
				}
			}
		}
		return null;
	}

	private void checkTasks(JobInfo info) {
		if (keep(info)) {
			TaskInfo tinfo = info.getTaskInfo();
			if (tinfo != null) {
				JobTreeElement[] toBeRemoved = null;
				boolean fire = false;
				JobTreeElement element = (JobTreeElement) tinfo.getParent();
				synchronized (keptjobinfos) {
					if (element == info && !keptjobinfos.contains(tinfo)) {
						toBeRemoved = findJobsToRemove(element);
						keptjobinfos.add(tinfo);
						finishedTime.put(tinfo, new Long(System
								.currentTimeMillis()));
					}
				}

				if (toBeRemoved != null) {
					for (int i = 0; i < toBeRemoved.length; i++) {
						remove(toBeRemoved[i]);
					}
				}

				if (fire) {
					Object l[] = getListeners();
					for (int i = 0; i < l.length; i++) {
						KeptJobsListener jv = (KeptJobsListener) l[i];
						jv.finished(info);
					}
				}
			}
		}
	}

	public void removeErrorJobs() {
		JobTreeElement[] infos = getKeptElements();
		for (int i = 0; i < infos.length; i++) {
			if (infos[i].isJobInfo()) {
				JobInfo info1 = (JobInfo) infos[i];
				Job job = info1.getJob();
				if (job != null) {
					IStatus status = job.getResult();
					if (status != null && status.getSeverity() == IStatus.ERROR) {
						JobTreeElement topElement = info1.getParent();
						if (topElement == null) {
							topElement = info1;
						}
						remove(topElement);
					}
				}
			}
		}
	}

	boolean remove(JobTreeElement jte) {
		boolean fire = false;
		boolean removed = false;

		synchronized (keptjobinfos) {
			if (keptjobinfos.remove(jte)) {
				removed = true;
				finishedTime.remove(jte);
				disposeAction(jte);

				// delete all elements that have jte as their direct or indirect
				// parent
				JobTreeElement jtes[] = keptjobinfos
								.toArray(new JobTreeElement[keptjobinfos.size()]);
				for (int i = 0; i < jtes.length; i++) {
					JobTreeElement parent = (JobTreeElement) jtes[i]
							.getParent();
					if (parent != null) {
						if (parent == jte || parent.getParent() == jte) {
							if (keptjobinfos.remove(jtes[i])) {
								disposeAction(jtes[i]);
							}
							finishedTime.remove(jtes[i]);
						}
					}
				}
				fire = true;
			}
		}

		if (fire) {
			// notify listeners
			Object l[] = getListeners();
			for (int i = 0; i < l.length; i++) {
				KeptJobsListener jv = (KeptJobsListener) l[i];
				jv.removed(jte);
			}
		}
		return removed;
	}

	/**
	 * Returns all kept elements.
	 */
	JobTreeElement[] getKeptElements() {
		JobTreeElement[] all;
		if (keptjobinfos.isEmpty()) {
			return EMPTY_INFOS;
		}

		synchronized (keptjobinfos) {
			all = keptjobinfos
					.toArray(new JobTreeElement[keptjobinfos.size()]);
		}

		return all;
	}

	/**
	 * Get the date that indicates the finish time.
	 *
	 * @param jte
	 * @return Date
	 */
	public Date getFinishDate(JobTreeElement jte) {
		Object o = finishedTime.get(jte);
		if (o instanceof Long) {
			return new Date(((Long) o).longValue());
		}
		return null;
	}

	/**
	 * Return whether or not the kept infos have the element.
	 *
	 * @param element
	 * @return boolean
	 */
	public boolean isKept(JobTreeElement element) {
		return keptjobinfos.contains(element);
	}

	/**
	 * Clear all kept jobs.
	 */
	public void clearAll() {
		synchronized (keptjobinfos) {
			JobTreeElement[] all = keptjobinfos
					.toArray(new JobTreeElement[keptjobinfos.size()]);
			for (int i = 0; i < all.length; i++) {
				disposeAction(all[i]);
			}
			keptjobinfos.clear();
			finishedTime.clear();
		}

		// notify listeners
		Object l[] = getListeners();
		for (int i = 0; i < l.length; i++) {
			KeptJobsListener jv = (KeptJobsListener) l[i];
			jv.removed(null);
		}
	}

	/**
	 * Return the set of kept jobs.
	 * @return Set
	 */
	Set<JobTreeElement> getKeptAsSet() {
		return keptjobinfos;
	}
}
