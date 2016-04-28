package fr.univnantes.termsuite.ui.prefs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.ListEditor;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.dialogs.ConfigureTaggerDialog;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.util.TaggerUtil;

public class TaggerPreferencePage extends FieldEditorPreferencePage {

	public TaggerPreferencePage() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
		addField(new ListEditor(TermSuiteUIPreferences.TAGGERS, "Installed POS taggers/lemmatizers: ", getFieldEditorParent()) {
			@Override
			protected String createList(String[] items) {
				return Joiner.on(TermSuiteUIPreferences.LIST_SEPARATOR_CHAR).join(items);
			}

			@Override
			protected String getNewInputObject() {
				ConfigureTaggerDialog dialog = new ConfigureTaggerDialog(getShell());
				
				if(dialog.open() == Dialog.OK) {
					ETaggerConfig config = dialog.getTaggerConfig();
					return TaggerUtil.toPreferenceString(config);
				} else
					return null;
			}

			@Override
			protected String[] parseString(String stringList) {
				List<String> list = Splitter.on(TermSuiteUIPreferences.LIST_SEPARATOR_CHAR).splitToList(stringList);
				return list.toArray(new String[list.size()]);
			}
		});
		
	}

	
}
