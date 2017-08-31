package fr.univnantes.termsuite.ui.dialogs;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Charsets;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.services.CorpusService;

public class ImportCorpusDialog extends Dialog {

	private CorpusService corpusService;

	private Set<String> forbiddenNames;
	private List<String> availableCharsets;

	public ImportCorpusDialog(Shell parentShell, Set<String> forbiddenNames, CorpusService corpusService) {
		super(parentShell);
		this.forbiddenNames = forbiddenNames;
		availableCharsets = new ArrayList<>();
		availableCharsets.add(Charset.defaultCharset().name());
		for(Charset c:new Charset[]{Charsets.UTF_8, Charsets.ISO_8859_1})
			if(!availableCharsets.contains(c.name()))
				availableCharsets.add(c.name());
		this.corpusService = corpusService;
	}
	
	
    @Override
    protected Point getInitialSize() {
    	return new Point(500, 200);
    }

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Import a new corpus");
	}
	
	private Text nameText;
	private Combo encodingCombo;
	private Text pathText;
	private Label statusText;
    KeyAdapter updateAdapater = new KeyAdapter() {
	      @Override
	      public void keyReleased(KeyEvent e) {
	    	  update();
	      }
	    };

	
	@Override
	protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout(3, false);
        layout.marginRight = 5;
        layout.marginLeft = 10;
        container.setLayout(layout);

		
		
		/*
		 * Corpus name
		 */
		new Label(container, SWT.NONE).setText("Name:");
	    nameText = new Text(container, SWT.BORDER | SWT.SINGLE);
	    nameText.setText("");
	    nameText.addKeyListener(updateAdapater);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(nameText);
	    
	    
		/*
		 * Corpus path
		 */
	    new Label(container, SWT.NONE).setText("Root directory of corpus:");
	    pathText = new Text(container, SWT.BORDER | SWT.SINGLE);
	    pathText.setText("");
		pathText.addKeyListener(updateAdapater);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(pathText);
	    
	    Button browse = new Button(container, SWT.NONE);
	    browse.setText("Browse...");
	    browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog directoryDialog = new DirectoryDialog(parent.getShell());
				directoryDialog.setMessage("Select a multi-lingual corpus.");
				directoryDialog.setText("Import multilingual Corpus");
				pathText.setText(directoryDialog.open());
				update();
			}
		});
		GridDataFactory.swtDefaults().applyTo(browse);

		
	    /*
		 * Corpus encoding
		 */
		new Label(container, SWT.NONE).setText("Encoding of the corpus:");
		encodingCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.SINGLE);
		encodingCombo.setItems(availableCharsets.toArray(new String[availableCharsets.size()]));
		encodingCombo.setText(availableCharsets.get(0));
		GridDataFactory.fillDefaults().span(2, 1).applyTo(encodingCombo);

	    
		/*
		 * Status message
		 */
	    statusText = new Label(container, SWT.NONE);
	    statusText.setText("");
	    statusText.setForeground(TermSuiteUI.COLOR_RED);
	    GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.END).span(3, 1).applyTo(statusText);
	    
		return container;
	}
	
	
	private void update() {
		if(getNameValidityMessage() != null) {
			statusText.setText(getNameValidityMessage());
			getButton(OK).setEnabled(false);
		} else if(getMultilingualCorpusValidityMessage() != null) {
			statusText.setText(getMultilingualCorpusValidityMessage());
			getButton(OK).setEnabled(false);
		} else {
			statusText.setText("");
			getButton(OK).setEnabled(true);
		}
	}

	private String getNameValidityMessage() {
		if(nameText.getText().trim().isEmpty()) 
			return "Corpus name cannot be empty";
		if(forbiddenNames.contains(nameText.getText().trim()))
			return "A corpus named " + nameText.getText().trim() + " already exists";
		return null;
	}

	private String getMultilingualCorpusValidityMessage() {
		String path = this.pathText.getText().trim();
		File f = new File(path);
		if (!f.exists())
			return String.format("Directory %s does not exist", path);
		else if (!f.isDirectory())
			return String.format("Not a directory: %s", path);
		else {
			if (corpusService.candidateSLCChildrenForPath(f.getPath()).length == 0)
				return String.format("Not a valid Termsuite corpus: %s (contains no single-language corpus)", path);
		}
		return null;
	}

	
	private ECorpus corpus;
	
	public ECorpus getCorpus() {
		return corpus;
	}
	
	@Override
	protected void okPressed() {
		this.corpus = TermsuiteuiFactory.eINSTANCE.createECorpus();
		corpus.setName(nameText.getText().trim());
		corpus.setPath(pathText.getText().trim());
		corpus.setEncoding(encodingCombo.getText().trim());
		super.okPressed();
	}
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
	    update();
	}
}
