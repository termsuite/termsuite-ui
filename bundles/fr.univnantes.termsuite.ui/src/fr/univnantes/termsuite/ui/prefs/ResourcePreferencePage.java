package fr.univnantes.termsuite.ui.prefs;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary;
import fr.univnantes.termsuite.ui.services.impl.AlignmentServiceImpl;
import fr.univnantes.termsuite.ui.services.impl.NLPServiceImpl;
import fr.univnantes.termsuite.ui.util.LangUtil;

public class ResourcePreferencePage extends FieldEditorPreferencePage {

	public ResourcePreferencePage() {
		super(GRID);
	}

	private DirectoryFieldEditor linguisticPathField = null;
	private DirectoryFieldEditor synonymPathField = null;
	private DirectoryFieldEditor bilingualPathField = null;
	
	private BooleanFieldEditor activeCustomResourcesEditor;
	private Label detectedBilingualDictionaries;
	private Label detectedSynonymDictionaries;
	private Composite linguisticPathFieldEditorParent;

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();

		/*
		 * Bilingual dictionaries
		 */

		labelWithHelpButton(parent, 
				"Bilingual dictionaries", 
				SWT.BOLD, 
				"You need bilingual dictionaries to get bilingual alignment working. A bilingual dictionary file is a tab-separated file containing two columns. The file name must be of the form xx-yy.txt, where xx is the source language and yy the target language, eg. en-fr.txt for english to french dictionary. Put all your bilingual dictionaries into a directory and enter the directory location.");

		Label l1 = label(parent, "You need bilingual dictionaries to get bilingual alignment working.", SWT.ITALIC);
		GridDataFactory.fillDefaults().span(3, 1).applyTo(l1);

		
		bilingualPathField = new DirectoryFieldEditor(TermSuiteUIPreferences.BILINGUAL_DICTIONARY_DIRECTORY, 
				"Location of bilingual dict.:", 
				parent);
		addField(bilingualPathField);		


		detectedBilingualDictionaries = new Label(parent, SWT.HORIZONTAL );
		GridDataFactory.fillDefaults().span(3, 1).applyTo(detectedBilingualDictionaries);

		
		separator();

		/*
		 * Synonym dictionaries
		 */
		labelWithHelpButton(parent, 
				"Synonym dictionaries", 
				SWT.BOLD, 
				"Synonym dictionaries embedded in TermSuite are free, but very poor. If you own a synonym dictionary, it is advised to use it instead of TermSuite's. A synonym dictionary is a tab-separated file containing two columns. The file name must be of the form xx-synonyms.txt, where xx is the language, eg. en-synonyms.txt for english. Put all your synonym dictionaries into a directory and enter the directory location.");
		Label l2 = label(parent, "You can override synonym dictionaries already embedded in TermSuite.", SWT.ITALIC);
		GridDataFactory.fillDefaults().span(3, 1).applyTo(l2);

		synonymPathField = new DirectoryFieldEditor(TermSuiteUIPreferences.SYNONYM_DICTIONARY_DIRECTORY, 
				"Location of custom synonym dict.:", 
				parent);
		addField(synonymPathField);		

		detectedSynonymDictionaries = new Label(parent, SWT.HORIZONTAL );
		GridDataFactory.fillDefaults().span(3, 1).applyTo(detectedSynonymDictionaries);
		
		separator();
		
		
		/*
		 * Activate custom resource button
		 */
		label(parent, "Customize other lingustic ressources", SWT.BOLD);

		activeCustomResourcesEditor = new BooleanFieldEditor(TermSuiteUIPreferences.ACTIVATE_CUSTOM_RESOURCES, "Use custom linguistic resources", parent);
		addField(activeCustomResourcesEditor);

		/*
		 * Directory to custom resources
		 */
		linguisticPathFieldEditorParent = parent;
		linguisticPathField = new DirectoryFieldEditor(TermSuiteUIPreferences.LINGUISTIC_RESOURCES_DIRECTORY, "Location of linguistic resources:", linguisticPathFieldEditorParent);
		addField(linguisticPathField);
		

	}

	private Label label(Composite parent, String text, int style) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		font(label, style);
		return label;
	}
	
	private void labelWithHelpButton(Composite parent, String text, int style, String helpText) {
		Composite container = new Composite(parent, SWT.None);
		GridDataFactory.fillDefaults().span(3, 1).applyTo(container);

		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(container);
		label(container, text, style);
		addHelpButton(
				container,
				text,
				helpText);


	}

	private void separator() {
		Label sep = new Label(getFieldEditorParent(), SWT.HORIZONTAL | SWT.SEPARATOR);
		GridDataFactory.fillDefaults().span(3, 1).applyTo(sep);
	}

	private void addHelpButton(Composite parent, String title, String helpMessage) {
		Button help = new Button(parent, SWT.PUSH);
		help.setImage(TermSuiteUI.getImg(TermSuiteUI.IMG_HELP).createImage());
		help.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(getShell(), 
						title, 
						helpMessage
						);
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		GridDataFactory.swtDefaults().applyTo(help);
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		setStatusMessages();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		setStatusMessages();
	}


	private void setStatusMessages() {
		setOk();
		setSynonymStatusMessages();
		setBilingualStatusMessages();
		setCustomResourceMessage();
	}

	
	private void setBilingualStatusMessages() {
		if(bilingualPathField.getStringValue().isEmpty()) {
			detectedBilingualDictionaries.setText("");			
			font(detectedBilingualDictionaries, SWT.None);
		} else if(!bilingualPathField.isValid()) {
			detectedBilingualDictionaries.setText(bilingualPathField.getErrorMessage());
			detectedBilingualDictionaries.setForeground(TermSuiteUI.COLOR_RED);
			font(detectedBilingualDictionaries, SWT.BOLD);
			setError("Bilingual dictionary directory: " + bilingualPathField.getErrorMessage());
		} else if(bilingualPathField.isValid()){
			Path dir = Paths.get(bilingualPathField.getStringValue());
			
			List<EBilingualDictionary> dicos = AlignmentServiceImpl.findDictionaries(dir);
			
			if(dicos.isEmpty()) {
				String msg = "No bilingual dictionary detected in directory " + dir;
				detectedBilingualDictionaries.setText(msg);
				detectedBilingualDictionaries.setForeground(TermSuiteUI.COLOR_RED);
				font(detectedBilingualDictionaries, SWT.BOLD);
				setError("Bilingual dictionary directory: " + msg);
			} else {
				String languageString = dicos.stream().map(d -> String.format("%s-%s", d.getSourceLang().getName(), d.getTargetLang().getName()).toLowerCase()).collect(Collectors.joining(", "));
				detectedBilingualDictionaries.setText(dicos.size() + " bilingual dictionaries detected: " + languageString);
				detectedBilingualDictionaries.setForeground(TermSuiteUI.COLOR_GREEN);
				font(detectedBilingualDictionaries, SWT.ITALIC);
			}
		}
		
	}

	private void setSynonymStatusMessages() {
		if(synonymPathField.getStringValue().isEmpty()) {
			detectedSynonymDictionaries.setText("");			
			font(detectedSynonymDictionaries, SWT.None);
		} else if(!synonymPathField.isValid()) {
			detectedSynonymDictionaries.setText(synonymPathField.getErrorMessage());
			detectedSynonymDictionaries.setForeground(TermSuiteUI.COLOR_RED);
			font(detectedSynonymDictionaries, SWT.BOLD);
			setError("Synonym dictionaries  directory: " + synonymPathField.getErrorMessage());
		} else if(synonymPathField.isValid()){
			detectedSynonymDictionaries.setText("Ok");
			Path dir = Paths.get(synonymPathField.getStringValue());
			List<Path> detectedLanguages = LangUtil.getSupportedLanguages().stream()
				.map(l -> NLPServiceImpl.getCustomSynonymDictionaryFile(dir, l))
				.filter(o -> o.isPresent())
				.map(Optional::get)
				.collect(Collectors.toList())
			;
			if(detectedLanguages.isEmpty()) {
				String msg = "No synonym dictionary detected in directory " + dir;
				detectedSynonymDictionaries.setText(msg);
				detectedSynonymDictionaries.setForeground(TermSuiteUI.COLOR_RED);
				font(detectedSynonymDictionaries, SWT.BOLD);
				setError("Synonym dictionaries directory: " + msg);
			} else {
				String languageString = detectedLanguages.stream().map(p -> p.getFileName().toString()).collect(Collectors.joining(", "));
				detectedSynonymDictionaries.setText(detectedLanguages.size() + " synonym dictionaries detected: " + languageString);
				detectedSynonymDictionaries.setForeground(TermSuiteUI.COLOR_GREEN);
				font(detectedSynonymDictionaries, SWT.ITALIC);
			}
		}
	}

	private void setCustomResourceMessage() {
		if(linguisticPathField != null) {
			boolean active = activeCustomResourcesEditor.getBooleanValue();
			linguisticPathField.setEnabled(active, linguisticPathFieldEditorParent);
			if(active) {
				File file = Paths.get(linguisticPathField.getStringValue()).toFile();
				if(!file.exists())
					setError("Custom resources directory: Directory does not exist: \""+file.getPath()+"\"");
				else if(!file.isDirectory())
					setError("Custom resources directory: Not a directory: \""+file.getPath()+"\"");
			}
		} 
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
	
	private void font(Control control, int style) {
		FontData fontData = control.getFont().getFontData()[0];
		Font font = new Font(getShell().getDisplay(), new FontData(fontData.getName(), fontData
		    .getHeight(), style));
		control.setFont(font);
	}
}
