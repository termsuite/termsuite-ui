package fr.univnantes.termsuite.ui.prefs;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;

public class ResourcePreferencePage extends FieldEditorPreferencePage {

	public ResourcePreferencePage() {
		super(GRID);
		setDescription("Where to find TermSuite's linguistic resources.");
	}

	@Override
	protected void createFieldEditors() {
		addField(new DirectoryFieldEditor(TermSuiteUIPreferences.DICTIONARY_DIRECTORY, "Dictionary input directory:", getFieldEditorParent()));
	}

	
	
}
