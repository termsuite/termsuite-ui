package fr.univnantes.termsuite.ui.util;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.TableWrapData;

public class TableWrapDataFactory {

	private TableWrapData data;
	
	private TableWrapDataFactory() {
		super();
		this.data = new TableWrapData();
	}

	public static TableWrapDataFactory defaults() {
		return new TableWrapDataFactory();
	}
	
	public TableWrapDataFactory span(int x, int y) {
		this.data.rowspan = x;
		this.data.colspan = y;
		return this;
	}
	
	public TableWrapDataFactory grab(boolean horizontal, boolean vertical) {
		this.data.grabHorizontal = horizontal;
		this.data.grabVertical = vertical;
		return this;
	}
	
	public void applyTo(Control control) {
		control.setData(data);
	}

	public TableWrapDataFactory minHeight(int pixels) {
		this.data.heightHint = pixels;
		return this;
	}
}
