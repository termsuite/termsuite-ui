package fr.univnantes.termsuite.ui.prefs;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;

public class ResourcePreferencePage extends FieldEditorPreferencePage {

	public ResourcePreferencePage() {
		super(GRID);
	}

	private DirectoryFieldEditor linguisticPathField = null;
	
	private BooleanFieldEditor activeCustomResourcesEditor;
	private Composite linguisticPathFieldEditorParent;
	
	@Override
	protected void createFieldEditors() {

		/*
		 * Activate custom resource button
		 */
		activeCustomResourcesEditor = new BooleanFieldEditor(TermSuiteUIPreferences.ACTIVATE_CUSTOM_RESOURCES, "Use custom linguistic resources", getFieldEditorParent());
		addField(activeCustomResourcesEditor);

		/*
		 * Directory to custom resources
		 */
		linguisticPathFieldEditorParent = getFieldEditorParent();
		linguisticPathField = new DirectoryFieldEditor(TermSuiteUIPreferences.LINGUISTIC_RESOURCES_DIRECTORY, "Location of linguistic resources:", linguisticPathFieldEditorParent);
		addField(linguisticPathField);
		
		/*
		 * separator
		 */
		Label sep = new Label(getFieldEditorParent(), SWT.HORIZONTAL | SWT.SEPARATOR);
		GridDataFactory.fillDefaults().span(3, 1).applyTo(sep);

		/*
		 * Bilingual dictionaries
		 */
		addField(new DirectoryFieldEditor(TermSuiteUIPreferences.DICTIONARY_DIRECTORY, "Location of bilingual dictionaries:", getFieldEditorParent()));		
		
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		validate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		validate();
	}

	private void validate() {
		if(linguisticPathField != null) {
			boolean active = activeCustomResourcesEditor.getBooleanValue();
			linguisticPathField.setEnabled(active, linguisticPathFieldEditorParent);
			if(active) {
				File file = Paths.get(linguisticPathField.getStringValue()).toFile();
				if(!file.exists())
					setError("Directory does not exist: \""+file.getPath()+"\"");
				else if(!file.isDirectory())
					setError("Not a directory: \""+file.getPath()+"\"");
				else
					setOk();
			} else
				setOk();
		} else 
			setOk();
	}
	
	private void setError(String message) {
		setMessage(message);
		setErrorMessage(message);
		setValid(false);
	}

	private void setOk() {
		setMessage("Ok");
		setErrorMessage(null);
		setValid(true);
		
	}
}
