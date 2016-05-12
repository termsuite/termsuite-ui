package fr.univnantes.termsuite.ui.prefs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.util.LinguisticResourceUtil;
import fr.univnantes.termsuite.ui.util.ValidationException;

public class ResourcePreferencePage extends FieldEditorPreferencePage {

	public ResourcePreferencePage() {
		super(GRID);
	}

	private DirectoryFieldEditor linguisticPathField = null;
	
	private BooleanFieldEditor activeCustomResourcesEditor;
	private BooleanFieldEditor copyBuiltinResourcesIfEmptyEditor;
	private Composite linguisticPathFieldEditorParent;
	private Composite copyBuiltinResourcesIfEmptyEditorParent;
	
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
		
		
		copyBuiltinResourcesIfEmptyEditorParent = getFieldEditorParent();
		copyBuiltinResourcesIfEmptyEditor = new BooleanFieldEditor(
				TermSuiteUIPreferences.COPY_BUILTIN_RESOURCES_IF_EMPTY, 
				"Copy built-in resources to directory if target directory is empty.", 
				copyBuiltinResourcesIfEmptyEditorParent);
		addField(copyBuiltinResourcesIfEmptyEditor);

		
		
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
		String errorMsg = null;
		if(linguisticPathField != null) {
			boolean active = activeCustomResourcesEditor.getBooleanValue();
			linguisticPathField.setEnabled(active, linguisticPathFieldEditorParent);
			copyBuiltinResourcesIfEmptyEditor.setEnabled(activeCustomResourcesEditor.getBooleanValue(), copyBuiltinResourcesIfEmptyEditorParent);
			if(activeCustomResourcesEditor.getBooleanValue()) {
				try {
					String path = (String) linguisticPathField.getTextControl(linguisticPathFieldEditorParent).getText();
					LinguisticResourceUtil.getLinguisticResourceSets(
							path, 
							copyBuiltinResourcesIfEmptyEditor.getBooleanValue());
					errorMsg = null;
				} catch(ValidationException e) {
					errorMsg = e.getMessage();	
				}
			} else 
				errorMsg = null;
		}
		if(errorMsg == null) {
			setMessage(null);
			setErrorMessage(null);
			setValid(true);
		} else {
			setErrorMessage(errorMsg);
			setValid(false);
		}
			
		
	}
}
