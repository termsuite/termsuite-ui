package fr.univnantes.termsuite.ui.wizards;

import java.io.File;

import javax.inject.Inject;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.ResourceService;

public class ImportCorpusWizard extends Wizard {
	
	@Inject ResourceService resourceService;
	@Inject CorpusService corpusService;

	private SelectRootDirectoryPage page1 = new SelectRootDirectoryPage();

	@Override
	public void addPages() {
		addPage(page1);
	}
	
	@Override
	public boolean performFinish() {
		return true;
	}
	
	
	/*
	 * Page 1
	 */
	private class SelectRootDirectoryPage extends  WizardPage {

		private String corpusName;
		private String corpusPath;


		private Text textPath;
		private Text textName;

		protected SelectRootDirectoryPage() {
			super("Select Root Directory");
			setTitle("Select Root Directory");
			setDescription("Select a directory that has a valid TermSuite multilingual corpus directory hierarchy.");
		}
		
		public String getCorpusName() {
			return corpusName;
		}



		@Override
		public void createControl(Composite parent) {
			final DirectoryDialog directoryDialog = new DirectoryDialog(this.getShell());
			directoryDialog.setMessage("Select a multi-lingual corpus.");
			directoryDialog.setText("Import multilingual Corpus");
			
			parent.setLayout(new GridLayout(3, false));
			Label label2 = new Label(parent, SWT.NONE);
		    label2.setText("Name:");

		    textName = new Text(parent, SWT.BORDER | SWT.SINGLE);
		    textName.setText("");

		    textName.addKeyListener(new KeyListener() {

		      @Override
		      public void keyPressed(KeyEvent e) {
		      }

		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  update();
		      }
		    });

		    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		    textName.setLayoutData(gd);
		    new Label(parent, NONE);
		    
		    
		    Label label1 = new Label(parent, SWT.NONE);
		    label1.setText("Root directory of corpus:");

		    textPath = new Text(parent, SWT.BORDER | SWT.SINGLE);
		    textPath.setText("");

		    textPath.addKeyListener(new KeyListener() {

		      @Override
		      public void keyPressed(KeyEvent e) {
		      }

		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  update();
		      }
		    });

		    gd = new GridData(GridData.FILL_HORIZONTAL);
		    textPath.setLayoutData(gd);
		    
		    Button browse = new Button(parent, NONE);
		    browse.setText("Browse...");
		    browse.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					textPath.setText(directoryDialog.open());
					update();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}
			});

		    
		    // required to avoid an error in the system
		    setControl(parent);
		    setPageComplete(false);
		}
		
		private void update() {
			if(textName.getText().trim().isEmpty()) {
				setPageComplete(false);
				setErrorMessage(String.format("Corpus name cannot be empty"));
				return;
			}
			for(ECorpus c:resourceService.getCorporaList().getCorpora()) {
				if(c.getName().equals(textName.getText())) {
					setPageComplete(false);
					setErrorMessage(String.format("Corpus %s already exists in workspace", c.getName()));
					return;
				}
			}
			String message = getMultilingualCorpusValidityMessage(this.textPath.getText());
			setPageComplete(message == null);
			setErrorMessage(message);
			corpusName = textName.getText();
			corpusPath = textPath.getText();
			
		}
		
		private String getMultilingualCorpusValidityMessage(String path) {
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

		
		public String getCorpusPath() {
			return this.corpusPath;
		}
	}


	public String getCorpusName() {
		return page1.getCorpusName();
	}
	public String getCorpusPath() {
		return page1.getCorpusPath();
	}
}
