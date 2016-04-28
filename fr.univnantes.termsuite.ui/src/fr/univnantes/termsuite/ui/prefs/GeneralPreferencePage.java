package fr.univnantes.termsuite.ui.prefs;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;

public class GeneralPreferencePage extends FieldEditorPreferencePage {

	public GeneralPreferencePage() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
//		addField(new ComboFieldEditor("prefCombo", "A combo field", new String[][]{{"display1", "value1"},{"display2", "value2"}}, getFieldEditorParent()));
//		addField(new ColorFieldEditor("prefColor", "Color for table items : ", getFieldEditorParent()));
//		addField(new BooleanFieldEditor("prefBoolean", "A boolean : ", getFieldEditorParent()));
//		addField(new DirectoryFieldEditor(TermSuiteUIPreferences.OUTPUT_DIRECTORY, "Output directory : ", getFieldEditorParent()));
		addField(new BooleanFieldEditor(TermSuiteUIPreferences.WRAP_TEXT, "Wrap text by default when viewing a document", getFieldEditorParent()));
		addField(new DirectoryFieldEditor(TermSuiteUIPreferences.OUTPUT_DIRECTORY, "Termsuite output directory", getFieldEditorParent()));

	}

	
}
