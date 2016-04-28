package fr.univnantes.termsuite.ui.controls;

import java.util.EventObject;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.Lists;

public class DelayableText extends Composite {

	private Text text;
	private int textStyle;
	private int delay;
	private Timer timer = new Timer();
	private List<DelayedModificationListener> delayedModificationListeners = Lists.newArrayList();
	
	public boolean addDelayedModificationListener(DelayedModificationListener e) {
		return delayedModificationListeners.add(e);
	}

	public DelayableText(int delay, Composite parent, int textStyle) {
		super(parent, SWT.NONE);
		this.delay = delay;
		this.textStyle = textStyle;

	    createContents();
		
	}

	private void createContents() {
		setLayout(new FillLayout());
		text = new Text(this, textStyle);
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(final ModifyEvent e) {
				timer.cancel();
				timer = new	Timer();
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						for(DelayedModificationListener l:DelayableText.this.delayedModificationListeners)
							l.modifyText(new EventObject(DelayableText.this));
						timer.cancel();
					}
				};
				timer.schedule(task, DelayableText.this.delay);
			}
		});
		
	}

	public void setMessage(String message) {
		text.setMessage(message);
	}

	public String getText() {
		return text.getText();
	}

	public void setText(String string) {
		this.text.setText(string);
	}
}
