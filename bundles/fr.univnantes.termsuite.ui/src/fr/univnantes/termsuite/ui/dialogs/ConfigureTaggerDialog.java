package fr.univnantes.termsuite.ui.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.controls.BrowseDirText;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import fr.univnantes.termsuite.ui.parts.TermsuiteImg;
import fr.univnantes.termsuite.ui.util.FormTextUtil;
import fr.univnantes.termsuite.ui.util.LangUtil;
import fr.univnantes.termsuite.ui.util.TaggerUtil;

public class ConfigureTaggerDialog extends TitleAreaDialog {

//	private TaggerService taggerService;

	private ETaggerConfig taggerConfig;
	private TableViewer languageViewer;
	private Label languageLabel;
//	private Label errorLabel;
	private ScrolledForm form;

	public ConfigureTaggerDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		parentShell.addListener(SWT.RESIZE, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				form.reflow(true);
				
			}
		});
		this.taggerConfig = TermsuiteuiFactory.eINSTANCE.createETaggerConfig();
		this.taggerConfig.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeatureID(ETaggerConfig.class) == TermsuiteuiPackage.ETAGGER_CONFIG__PATH 
						|| msg.getFeatureID(ETaggerConfig.class) == TermsuiteuiPackage.ETAGGER_CONFIG__TAGGER_TYPE)
					languageViewer.setInput(TaggerUtil.getSupportedLanguages(taggerConfig));
				if(msg.getFeatureID(ETaggerConfig.class) == TermsuiteuiPackage.ETAGGER_CONFIG__TAGGER_TYPE)
					updateTaggerName();
				refreshValidState();
			}

		});

	}
	
	private void updateTaggerName() {
		taggerConfig.setName(TaggerUtil.getTaggerName(taggerConfig.getTaggerType()));
	}
	
	@Override
	public void create() {
		super.create();
		getButton(IDialogConstants.OK_ID).setText("Save Tagger");
		getShell().setText("Tagger configuration");
		setTitle("Configure the POS tagger/lemmatizer's properties.");
		refreshValidState();
	}

	private void refreshValidState() {
		String validString = TaggerUtil.isValidInstallDir(this.taggerConfig);
		boolean isValid = validString == null;
		if(getButton(IDialogConstants.OK_ID) != null)
			getButton(IDialogConstants.OK_ID).setEnabled(isValid);
		setMessage(isValid ? "Ok" : validString, isValid ? IMessageProvider.NONE : IMessageProvider.ERROR);
		languageViewer.getControl().setVisible(isValid);
		languageLabel.setVisible(isValid);
	}
	
	private DataBindingContext dbc;
	private BrowseDirText taggerPath;
	private ComboViewer taggerComboViewer;
	
	@Override
	protected Control createDialogArea(final Composite parent) {
	    Composite container = (Composite) super.createDialogArea(parent);
	    dbc = new DataBindingContext();
	    FormToolkit toolkit = new FormToolkit(container.getDisplay());
	    form = toolkit.createScrolledForm(container);
	    GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
	    GridDataFactory.fillDefaults().grab(true, true).applyTo(form);
	    GridDataFactory.fillDefaults().grab(true, true).applyTo(form.getBody());
	    form.getBody().setLayout(new GridLayout());
//	    GridLayoutFactory.fillDefaults().margins(10,  10).numColumns(2).applyTo(form.getBody());
		Section helpSection = toolkit.createSection(form.getBody(), SWT.None);
		helpSection.setText("Help");
		helpSection.setExpanded(true);
	    GridDataFactory.fillDefaults().grab(true, true).applyTo(helpSection);

		Section configureSection = toolkit.createSection(form.getBody(),
				Section.TITLE_BAR );
		configureSection.setText("Configure");
		configureSection.setExpanded(true);
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(configureSection);

		Section errorSection = toolkit.createSection(form.getBody(),SWT.None);
		errorSection.setText("Status");
		errorSection.setExpanded(true);
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(form.getBody());
		GridDataFactory.fillDefaults().grab(false, false).span(1, 1).applyTo(errorSection);


	    // Explaination notice
		Composite helpSectionClient = toolkit.createComposite(helpSection);
		helpSection.setClient(helpSectionClient);
		helpSectionClient.setLayout(new GridLayout());
	    FormText notice = toolkit.createFormText(helpSectionClient, true);
		GridDataFactory.fillDefaults().hint(400, SWT.DEFAULT).applyTo(notice);
//	    notice.setLayoutData(new TableWrapData(TableWrapData.FILL));
//		GridDataFactory.fillDefaults().grab(false, false).span(2, 1).applyTo(notice);
		StringBuffer buf = new StringBuffer();
		buf.append("<form>");
		buf.append("<p>Due to license concerns, you need to install a 3rd party POS tagger to your computer. You need to have at least one of the two currently supported taggers installed:</p>");
		buf.append("<li>1. Tree Tagger (recommended) - download TreeTagger and its languages models. See official installation <a href=\"tt\">intructions</a></li>");
		buf.append("<li>2. Mate - download <a href=\"mate\">mate language models</a> (Mate's algorithm is already embedded in TermSuite) </li>");
		buf.append("<p>Once installed, pay a special attention to TermSuite's naming convention for TreeTagger and Mate models.</p>");
		buf.append("<p>For detailed information about 3rd party tagger installation, read TermSuite's official documentation on <a href=\"doc\">installing 3rd party tagger (and lemmatizer)</a></p>");
		buf.append("</form>");
		notice.setText(buf.toString(), true, false);
		FormTextUtil.bindToExternalLink(notice, "doc", TermSuiteUI.WEB_SITE_TAGGER_DOC_URL);
		FormTextUtil.bindToExternalLink(notice, "tt", TermSuiteUI.URL_TREE_TAGGER);
		FormTextUtil.bindToExternalLink(notice, "mate", TermSuiteUI.URL_MATE);


		Composite configureSectionClient = toolkit.createComposite(configureSection);
		configureSection.setClient(configureSectionClient);
	    GridLayoutFactory.fillDefaults().margins(10,  10).numColumns(2).applyTo(configureSectionClient);
	    // Tagger type
		toolkit.createLabel(configureSectionClient, "3rd party tagger:");
		taggerComboViewer = new ComboViewer(configureSectionClient, SWT.DROP_DOWN);
//		toolkit.adapt(taggerComboViewer.getControl(), true, true);
		taggerComboViewer.setContentProvider(ArrayContentProvider.getInstance());
		taggerComboViewer.setLabelProvider(new LabelProvider() {
		  public String getText(Object element) {
		    ETagger tagger = (ETagger) element;
		    return TaggerUtil.getTaggerName(tagger);
		  };
		});
		taggerComboViewer.setInput(ETagger.VALUES);
	
	    // Tagger path
		toolkit.createLabel(configureSectionClient, "Path to tagger's installation directory:");
		taggerPath = new BrowseDirText(configureSectionClient, SWT.NONE);
		toolkit.adapt(taggerPath, true, true);

		GridDataFactory.fillDefaults().grab(true, false).applyTo(taggerPath);
		

		Composite errorSectionClient = toolkit.createComposite(errorSection);
		errorSection.setClient(errorSectionClient);
	    GridLayoutFactory.fillDefaults().margins(10,  10).numColumns(2).applyTo(errorSectionClient);

		GridLayoutFactory.fillDefaults().margins(10,  10).numColumns(2).applyTo(errorSection);
		// Language viewer
		languageLabel = toolkit.createLabel(errorSectionClient, "Languages supported by your current tagger's installation:");
		GridDataFactory.fillDefaults().minSize(0, 20).grab(true,  true).span(2, 1).applyTo(languageLabel);
		languageViewer = new TableViewer(errorSectionClient,SWT.BORDER);
		GridDataFactory.fillDefaults().minSize(0, 100).grab(true,  true).span(2, 1).applyTo(languageViewer.getControl());
		languageViewer.setContentProvider(new ArrayContentProvider());
		TableViewerColumn column1 = new TableViewerColumn(languageViewer, SWT.LEFT);
		column1.getColumn().setWidth(200);
		column1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return LangUtil.getTermsuiteLang((ELang)element).getName();
			}
			@Override
			public Image getImage(Object element) {
				Image flag = TermsuiteImg.INSTANCE.getFlag((ELang)element);
				return flag;
			}
		});
		toolkit.adapt(languageViewer.getControl(), true, true);
		
		return form.getBody();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		dbc.bindValue(
				ViewerProperties.singleSelection().observe(taggerComboViewer), 
				EMFProperties.value(TermsuiteuiPackage.Literals.ETAGGER_CONFIG__TAGGER_TYPE).observe(this.taggerConfig));
		dbc.bindValue(
				new BrowseDirText.TextValueProperty().observe(taggerPath), 
				EMFProperties.value(TermsuiteuiPackage.Literals.ETAGGER_CONFIG__PATH).observe(this.taggerConfig));

		dbc.updateTargets();
		updateTaggerName();
	}
	public ETaggerConfig getTaggerConfig() {
		return taggerConfig;
	}
	
}
