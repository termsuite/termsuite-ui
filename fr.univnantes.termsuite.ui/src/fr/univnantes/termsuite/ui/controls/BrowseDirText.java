package fr.univnantes.termsuite.ui.controls;

import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetValueProperty;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

public class BrowseDirText extends Composite {

	private Text text;

	public BrowseDirText(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	private void createContents() {
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(this);

		text = new Text(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(text);

		Button button = new Button(this, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog fileDialog = new DirectoryDialog(getShell());
				// Set the text
				fileDialog.setText("Select directory");
				// Set filter on .txt files
				String selection = fileDialog.open();
				if (selection != null)
					text.setText(selection);
			}
		});
	}

	public static class TextValueProperty extends WidgetValueProperty {

		public TextValueProperty() {
			super(SWT.Modify);
		}

		@Override
		public Object getValueType() {
			return String.class;
		}

		@Override
		protected Object doGetValue(Object source) {
			return ((Text)source).getText();
		}

		@Override
		protected void doSetValue(Object source, Object value) {
			((Text)source).setText((String)value);
		}
		
		@Override
		public ISWTObservableValue observe(Widget widget) {
			return super.observe(((BrowseDirText)widget).text);
		}
	}

}
