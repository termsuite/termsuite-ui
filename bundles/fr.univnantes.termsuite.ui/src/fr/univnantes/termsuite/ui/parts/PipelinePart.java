package fr.univnantes.termsuite.ui.parts;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import eu.project.ttc.engines.cleaner.TermProperty;
import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.jface.DoubleValidator;
import fr.univnantes.termsuite.ui.util.jface.IntegerValidator;
import fr.univnantes.termsuite.ui.util.jface.NonEmptyStringValidator;
import fr.univnantes.termsuite.ui.util.jface.StringToDoubleConverter;
import fr.univnantes.termsuite.ui.util.jface.StringToIntegerConverter;
import fr.univnantes.termsuite.ui.util.jface.StringToTermPropertyConverter;
@SuppressWarnings("restriction") 
public class PipelinePart {

	public static final String ID = "fr.univnantes.termsuite.ui.partdescriptor.PipelineEditor";
	@Inject
	MDirtyable dirty;

//	EPipeline pipeline;

	Shell parentShell;
	
	private WritableValue<EPipeline> pipelineValue = new WritableValue<EPipeline>();
	private DataBindingContext dbc = new DataBindingContext();

	// Widgets

	EPartService partService;
	IEclipseContext context;
	
	@Inject
	TaggerService taggerService;
	
	@Inject @Optional
	private void init(@UIEventTopic(TermSuiteEvents.EDITOR_INITIATED) Object part) {
		if(this == part) {
			EPipeline pipeline = (EPipeline) context.get(TermSuiteUI.INPUT_OBJECT);
			this.pipelineValue.setValue(pipeline);
			this.context.set(EPipeline.class, pipeline);
			pipeline.eAdapters().add(new EContentAdapter() {
				public void notifyChanged(Notification notification) {
					super.notifyChanged(notification);
					dirty.setDirty(true);
				}
			});
		}
	}

	@PostConstruct
	public void createControls(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell, Composite parent,
			final ECommandService commandService, 
			CorpusService corpusService,
			final EHandlerService handlerService,
			EPartService partService, final ESelectionService selectionService,
			IEclipseContext context) {
		
		this.context = context;
		this.parentShell = shell;
		this.partService = partService;
		
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
	    ScrolledForm form = toolkit.createScrolledForm(parent);
//	    form.getToolBarManager();
		form.setText("Terminology Extraction Pipeline");
		Composite body = form.getBody();
		body.setLayout(new ColumnLayout());
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		
		// create Main Section
		createMainSection(toolkit, form);
		
//		// Configure Tagger
		createTaggerSection(toolkit, form);

		// Configure Morphosyntactic Analysis
		createRegexSpotterSection(toolkit, form);

		createMorphoSyntacticSection(toolkit, form);

		// Configure Syntactic Gathering
		createSyntacticSection(toolkit, form);
		
		// Configure Graphical Variant Gathering
		createGraphicalSection(toolkit, form);
		
		// Configure Contextualizer
		createContextualizerSection(toolkit, form);
		
		// Configure filtering and sorting
		createFilterSection(toolkit, form);

		// Configure Export
		createExportSection(toolkit, form);
		// json with occurrences

		// Configure Dealing with big corpus
		createDealingWithBigCorpusSection(toolkit, form);
		// a- set a max term index size constraint

	}


	
	private void createMainSection(FormToolkit toolkit, final ScrolledForm form) {
		Form mainSection = toolkit.createForm(form.getBody());
		toolkit.paintBordersFor(mainSection);
		
		Composite body = mainSection.getBody();
		setTableWrapLayout(body, 2);

		
		Text t = createTextField(toolkit, body, 
				"Enter the terminology name:", 
				TermsuiteuiPackage.Literals.EPIPELINE__TARGET_TERMINOLOGY_NAME, 
				new NonEmptyStringValidator(), 
				null);
		t.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
	}

	private void createTaggerSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionTagger = createExpandableSection(toolkit, form);
		sectionTagger.setText("Tagger and Lemmatizer");
		sectionTagger.setDescription("The tagger/lemmatizer is a 3rd-party program setting syntactic labels and lemmas to each word annotation.");
		Composite sectionClient = toolkit.createComposite(sectionTagger);
		setTableWrapLayout(sectionClient, 2);
		Label l = new Label(sectionClient, SWT.NONE);
		l.setText("Tagger: ");
		applyTableWrapLayout(l);
		
		ComboViewer taggerComboViewer = new ComboViewer(sectionClient, SWT.DROP_DOWN);
		applyTableWrapLayout(taggerComboViewer.getControl());
		taggerComboViewer.setContentProvider(ArrayContentProvider.getInstance());
		taggerComboViewer.setLabelProvider(new LabelProvider());
		taggerComboViewer.setInput(taggerService.getTaggerConfigNames());

		sectionTagger.setClient(sectionClient);		
		
		dbc.bindValue(
				ViewerProperties.singleSelection().observe(taggerComboViewer), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__TAGGER_CONFIG_NAME).observeDetail(this.pipelineValue));

	}

	private void createRegexSpotterSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionRegexSpotter = createExpandableSection(toolkit, form);
		sectionRegexSpotter.setText("Term spotter");
		sectionRegexSpotter.setDescription("The term spotter applies a list of syntactic patterns to detect single-word and multi-word term occurrences in corpus files.");
		Composite sectionClient = toolkit.createComposite(sectionRegexSpotter);
		sectionClient.setLayout(new GridLayout());
		Button buttonSpotWithOccurrences = toolkit.createButton(sectionClient, "Keep all term occurrences in memory while spotting", SWT.CHECK);
		sectionRegexSpotter.setClient(sectionClient);
		
		dbc.bindValue(WidgetProperties.selection().observe(buttonSpotWithOccurrences), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__SPOT_WITH_OCCURRENCES).observeDetail(this.pipelineValue));
	}


	private void createMorphoSyntacticSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionMorphoSyntactic = createExpandableSection(toolkit, form);
		sectionMorphoSyntactic.setText("Morphosyntactic analysis");
		sectionMorphoSyntactic.setDescription("Finds native, neoclassical, and prefix compounds in words. Uses algorithm Compost.");
		Composite sectionClient = toolkit.createComposite(sectionMorphoSyntactic);
		sectionClient.setLayout(new GridLayout());
		Button buttonEnable =  toolkit.createButton(sectionClient, "Enable morphosyntactic analysis", SWT.CHECK);
		sectionMorphoSyntactic.setClient(sectionClient);
		
		dbc.bindValue(WidgetProperties.selection().observe(buttonEnable), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED).observeDetail(this.pipelineValue));
	}
	
	
	private void createSyntacticSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionSyntactic = createExpandableSection(toolkit, form);
		sectionSyntactic.setText("Syntactic variant gathering");
		sectionSyntactic.setDescription("Gathers terms according to their syntactic patterns and lemmas.");
		Composite sectionClient = toolkit.createComposite(sectionSyntactic);
		sectionClient.setLayout(new GridLayout());
		Button buttonEnable = toolkit.createButton(sectionClient, "Enable syntactic variant gathering", SWT.CHECK);
		sectionSyntactic.setClient(sectionClient);
		
		dbc.bindValue(WidgetProperties.selection().observe(buttonEnable), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__SYNTACTIC_VARIATION_ENABLED).observeDetail(this.pipelineValue));
	}


	private void createGraphicalSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionGraphical = createExpandableSection(toolkit, form);
		sectionGraphical.setText("Graphical variant gathering");
		sectionGraphical.setDescription("Applies a string metric to measure the distance between two terms. Fixes misspelling, pos tagging errors and some inflexional variants.");
		Composite sectionClient = toolkit.createComposite(sectionGraphical);
		sectionGraphical.setClient(sectionClient);
		setTableWrapLayout(sectionClient, 2);

		Button buttonEnable = toolkit.createButton(sectionClient, "Enable graphical variant gathering", SWT.CHECK);
		applyTableWrapLayout(buttonEnable, 1, 2);
		
		dbc.bindValue(WidgetProperties.selection().observe(buttonEnable), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED).observeDetail(this.pipelineValue));
				
		Text textTh = createTextField(toolkit, sectionClient, 
				"Similarity threshold: ",
				TermsuiteuiPackage.Literals.EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD, 
				new DoubleValidator(0, 1), 
				new StringToDoubleConverter()
				);
				
		bindAttributeToEnables(TermsuiteuiPackage.Literals.EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED, textTh);
	}


	private void setTableWrapLayout(Composite control, int numColumns) {
		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = numColumns;
		control.setLayout(layout);
	}


	private void applyTableWrapLayout(Control control) {
		applyTableWrapLayout(control, 1, 1);
	}
	private void applyTableWrapLayout(Control control, int rowSpan, int colSpan) {
		control.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE, rowSpan, colSpan));
	}


	private void createContextualizerSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionContextualizer = createExpandableSection(toolkit, form);
		sectionContextualizer.setText("Contextualizer");
		sectionContextualizer.setDescription("Creates for each term a context vector of the co-occurring terms.");
		Composite sectionClient = toolkit.createComposite(sectionContextualizer);
		setTableWrapLayout(sectionClient, 2);
		
		Button buttonEnableContextualizer = toolkit.createButton(sectionClient, "Enable contextualizer", SWT.CHECK);
		applyTableWrapLayout(buttonEnableContextualizer, 1, 2);
		
		Text textScope = createTextField(toolkit, sectionClient, 
				"Window size: ",
				TermsuiteuiPackage.Literals.EPIPELINE__CONTEXT_SCOPE, 
				new IntegerValidator(), 
				new StringToIntegerConverter()
				);

		Button buttonContextForSWTOnly = toolkit.createButton(sectionClient, "Build context vectors for SWT only", SWT.CHECK);
		applyTableWrapLayout(buttonContextForSWTOnly, 1, 2);
		
		Button buttonAllowMWTInContexts = toolkit.createButton(sectionClient, "Allow MWT in context vectors", SWT.CHECK);
		applyTableWrapLayout(buttonAllowMWTInContexts, 1, 2);

	
		// bindings
		dbc.bindValue(WidgetProperties.selection().observe(buttonEnableContextualizer), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__CONTEXTUALIZER_ENABLED).observeDetail(this.pipelineValue));

		bindAttributeToEnables(TermsuiteuiPackage.Literals.EPIPELINE__CONTEXTUALIZER_ENABLED,
				buttonContextForSWTOnly,
				buttonAllowMWTInContexts,
				textScope);
				
		/* Context */
		dbc.bindValue(WidgetProperties.selection().observe(buttonContextForSWTOnly), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY).observeDetail(this.pipelineValue));
		dbc.bindValue(WidgetProperties.selection().observe(buttonAllowMWTInContexts), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC).observeDetail(this.pipelineValue));

		
		sectionContextualizer.setClient(sectionClient);
	}

//	private void createDirSelectionBbox(FormToolkit toolkit, final Composite parent, 
//			String label, 
//			IObservableValue model, 
//			IValidator validator,
//			Converter converter) {
//		toolkit.createLabel(parent, label)
//			.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE));
//
//		final Text textFile = toolkit.createText(parent, "");
//		textFile.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.MIDDLE));
//		
//		Binding bindValue = dbc.bindValue(
//				WidgetProperties.text(SWT.Modify).observe(textFile),
//				model,
//				new UpdateValueStrategy()
//				.setAfterGetValidator(validator)
//				.setConverter(converter),
//				new UpdateValueStrategy().setConverter(converter));
//		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.RIGHT);
//
//		
//		toolkit.createLabel(parent, ""); // empty cell
//	
//		Button button = toolkit.createButton(parent, "Browse...", SWT.PUSH);
//	    button.addSelectionListener(new SelectionAdapter() {
//	        @Override
//	        public void widgetSelected(SelectionEvent e) {
//	            DirectoryDialog fileDialog = new DirectoryDialog(parent.getShell());
//	            // Set the text
//	            fileDialog.setText("Select directory");
//	            // Set filter on .txt files
//	            String selection = fileDialog.open();
//				if(selection != null)
//					textFile.setText(selection);
//	        }
//	      });
//	}


//	private void createFileSelectionBbox(FormToolkit toolkit, final Composite parent, 
//			String label, 
//			final String fileFilter, 
//			EAttribute pipelineProp, 
//			IValidator validator,
//			Converter converter) {
//		toolkit.createLabel(parent, label)
//			.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE));
//		Composite fileZone = toolkit.createComposite(parent);
//		fileZone.setLayout(new TableWrapLayout());
//		
//		final Text textFile = toolkit.createText(fileZone, "");
//		textFile.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.MIDDLE));
//		
//		Binding bindValue = dbc.bindValue(
//				WidgetProperties.text(SWT.Modify).observe(textFile),
//				EMFProperties.value(pipelineProp).observeDetail(this.pipelineValue),
//				new UpdateValueStrategy()
//				.setAfterGetValidator(validator)
//				.setConverter(converter),
//				new UpdateValueStrategy().setConverter(converter));
//		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.RIGHT);
//
//		
//		Button button = toolkit.createButton(fileZone, "Browse...", SWT.PUSH);
//	    button.addSelectionListener(new SelectionAdapter() {
//	        @Override
//	        public void widgetSelected(SelectionEvent e) {
//	            DirectoryDialog fileDialog = new DirectoryDialog(parent.getShell());
//	            // Set the text
//	            fileDialog.setText("Select directory");
//	            // Set filter on .txt files
//	            String selection = fileDialog.open();
//				if(selection != null)
//					textFile.setText(selection);
//	        }
//	      });
//	}

	private Text createTextField(FormToolkit toolkit, Composite parent, String label, EAttribute pipelineProp, IValidator validator,
			Converter converter) {
		toolkit.createLabel(parent, label)
			.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE));
		Text textScope = toolkit.createText(parent, "");
		textScope.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE));
		Binding bindValue = dbc.bindValue(
				WidgetProperties.text(SWT.Modify).observe(textScope),
				EMFProperties.value(pipelineProp).observeDetail(this.pipelineValue),
				new UpdateValueStrategy()
				.setAfterGetValidator(validator)
				.setConverter(converter),
				new UpdateValueStrategy().setConverter(converter));
		
		// add some decorations
		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.RIGHT);
		return textScope;
	}


	private void bindAttributeToEnables(EAttribute attribute, Object... targets) {
		for(Object o:targets)
			dbc.bindValue(
					EMFProperties.value(attribute).observeDetail(pipelineValue),
					WidgetProperties.enabled().observe(o));
			
	}
	
	
	private void createFilterSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionFilter = createExpandableSection(toolkit, form);
		sectionFilter.setText("Filter");
		sectionFilter.setDescription("Applies a filter on the terminology at the end of the pipeline.");
		Composite sectionClient = toolkit.createComposite(sectionFilter);
		setTableWrapLayout(sectionClient, 2);
		sectionFilter.setClient(sectionClient);
		
		Button buttonEnableFiltering = toolkit.createButton(sectionClient, "Enable filtering", SWT.CHECK);
		applyTableWrapLayout(buttonEnableFiltering, 1, 2);
		dbc.bindValue(WidgetProperties.selection().observe(buttonEnableFiltering), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_ENABLED).observeDetail(this.pipelineValue));
		
		/* Filtering property selection */		
		Label labelProp = toolkit.createLabel(sectionClient, "Filtering property: ");
		applyTableWrapLayout(labelProp, 1, 1);
		
		ComboViewer propertyComboViewer = createSingleTermPropertySelector(
			sectionClient, 
			TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_PROPERTY);
		applyTableWrapLayout(propertyComboViewer.getControl());
							
		/* Filtering mode */		
		Label labelMode = toolkit.createLabel(sectionClient, "Filtering mode: ");
		applyTableWrapLayout(labelMode, 1, 2);
		
		SelectObservableValue buttonMode = new SelectObservableValue();
		Button buttonModeTh = new Button(sectionClient, SWT.RADIO);
		applyTableWrapLayout(buttonModeTh);
		buttonModeTh.setText("By threshold: ");
		buttonMode.addOption(EFilteringMode.THRESHOLD, WidgetProperties.selection().observe(buttonModeTh));
		Text textTh = createTextFieldWithoutLabel(toolkit, sectionClient, 
			new StringToDoubleConverter(), 
			new DoubleValidator(0, Double.MAX_VALUE), 
			TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_THRESHOLD);
		Button buttonModeTopN = new Button(sectionClient, SWT.RADIO);
		applyTableWrapLayout(buttonModeTopN);
		buttonModeTopN.setText("By keeping first n terms:");
		buttonMode.addOption(EFilteringMode.TOP_N, WidgetProperties.selection().observe(buttonModeTopN));
		Text textTopN = createTextFieldWithoutLabel(toolkit, sectionClient, 
			new StringToIntegerConverter(), 
			new IntegerValidator(1, Integer.MAX_VALUE), 
			TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_TOP_N);
		dbc.bindValue(buttonMode, EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_MODE).observeDetail(this.pipelineValue));
		dbc.bindValue(
			WidgetProperties.text(SWT.Modify).observe(textTh),
			EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_THRESHOLD).observeDetail(this.pipelineValue));
		dbc.bindValue(
			WidgetProperties.text(SWT.Modify).observe(textTopN),
			EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_TOP_N).observeDetail(this.pipelineValue));
				
		bindAttributeToEnables(
			TermsuiteuiPackage.Literals.EPIPELINE__FILTERING_ENABLED,
			textTh, textTopN, buttonModeTopN, buttonModeTh, propertyComboViewer.getCombo());
	}


	private ComboViewer createSingleTermPropertySelector(Composite sectionClient, EAttribute pipelineProp) {
		ComboViewer propertyComboViewer = new ComboViewer(sectionClient, SWT.DROP_DOWN);
		propertyComboViewer.setContentProvider(ArrayContentProvider.getInstance());
		propertyComboViewer.setLabelProvider(new LabelProvider() {
		  public String getText(Object element) {
		    TermProperty p = (TermProperty) element;
		    return p.getPropertyName();
		  };
		});
		propertyComboViewer.setInput(new TermProperty[] {
			TermProperty.FREQUENCY,
			TermProperty.FREQUENCY_NORM,
			TermProperty.DOCUMENT_FREQUENCY,
			TermProperty.GENERAL_FREQUENCY_NORM,
			TermProperty.WR,
			TermProperty.WR_LOG
		});
		dbc.bindValue(
			ViewerProperties.singleSelection().observe(propertyComboViewer), 
			EMFProperties.value(pipelineProp).observeDetail(this.pipelineValue),
			new UpdateValueStrategy().setConverter(new StringToTermPropertyConverter()),
			new UpdateValueStrategy().setConverter(new StringToTermPropertyConverter())
		);
		return propertyComboViewer;
	}


	private Text createTextFieldWithoutLabel(FormToolkit toolkit, Composite sectionClient,
			Converter converter, IValidator validator, EAttribute pipelineProp) {
		Text text = toolkit.createText(sectionClient, "");
		applyTableWrapLayout(text);
		Binding bindValue = dbc.bindValue(
				WidgetProperties.text(SWT.Modify).observe(text),
				EMFProperties.value(pipelineProp).observeDetail(this.pipelineValue),
				new UpdateValueStrategy()
				.setAfterGetValidator(validator)
				.setConverter(converter),
				new UpdateValueStrategy().setConverter(converter));
		
		// add some decorations
		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.RIGHT);
		return text;
	}
	
	private void createExportSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionExportTerminology = createExpandableSection(toolkit, form);
		sectionExportTerminology.setText("Output / Export");
		sectionExportTerminology.setDescription("TermSuite can output word annotations and terminologies in multiple formats.");
		final Composite sectionClient = toolkit.createComposite(sectionExportTerminology);
		setTableWrapLayout(sectionClient, 2);

		Label label1 = toolkit.createLabel(sectionClient, "Export terminology to:");
		label1.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE, 1, 2));

		createExportTerminoLine(toolkit, sectionClient, 
				TermsuiteuiPackage.Literals.EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED, 
				"tsv");

		createExportTerminoLine(toolkit, sectionClient,
				TermsuiteuiPackage.Literals.EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED, 
				"tbx");

		Label label2 = toolkit.createLabel(sectionClient, "Export UIMA annotations (words and term occurrences) to:");
		label2.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE, 1, 2));

		createExportCasLine(toolkit, sectionClient, 
				TermsuiteuiPackage.Literals.EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED,
				"xmi/");

		createExportCasLine(toolkit, sectionClient, 
				TermsuiteuiPackage.Literals.EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED,
				"json/");

		createExportCasLine(toolkit, sectionClient, 
				TermsuiteuiPackage.Literals.EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED,
				"tsv/");

		sectionExportTerminology.setClient(sectionClient);
	}


	private void createExportCasLine(FormToolkit toolkit, Composite parent, EAttribute enableProp, final String dir) {
		Button buttonExport = toolkit.createButton(parent, dir, SWT.CHECK);
		buttonExport.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.MIDDLE, 1, 2));

		dbc.bindValue(
				WidgetProperties.selection().observe(buttonExport), 
				EMFProperties.value(enableProp).observeDetail(this.pipelineValue));
	}

	
	private void createExportTerminoLine(FormToolkit toolkit, Composite parent, EAttribute enableProp, final String extension) {
		Button buttonExport = toolkit.createButton(parent, "", SWT.CHECK);
		buttonExport.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.MIDDLE, 1, 2));

		dbc.bindValue(
				WidgetProperties.selection().observe(buttonExport), 
				EMFProperties.value(enableProp).observeDetail(this.pipelineValue));
		dbc.bindValue(
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__TARGET_TERMINOLOGY_NAME).observeDetail(this.pipelineValue),
				WidgetProperties.text().observe(buttonExport), 
				new UpdateValueStrategy().setConverter(new Converter(null, null) {
					@Override
					public Object convert(Object fromObject) {
						return String.valueOf(fromObject) + "." + extension;
					}
				}),
				new UpdateValueStrategy());
		dbc.updateModels();
		dbc.updateTargets();
	}

	private void createDealingWithBigCorpusSection(FormToolkit toolkit, final ScrolledForm form) {
		Section sectionHandlingBigCorpora = createExpandableSection(toolkit, form);
		sectionHandlingBigCorpora.setText("Handling big corpora");
		sectionHandlingBigCorpora.setDescription("Sometimes the input corpus contains too many words for of usual pipeline. In such case, an in-process terminology cleaning procedure needs to be configured.");
		Composite sectionClient = toolkit.createComposite(sectionHandlingBigCorpora);
		sectionHandlingBigCorpora.setClient(sectionClient);
		setTableWrapLayout(sectionClient, 2);

		/* Button "enable" */
		Button buttonEnableBigCorpora = toolkit.createButton(sectionClient, "Allow to filter the terminology during the extraction process", SWT.CHECK);
		dbc.bindValue(WidgetProperties.selection().observe(buttonEnableBigCorpora), EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__BIG_CORPORA_HANDLING_ENABLED).observeDetail(this.pipelineValue));
		applyTableWrapLayout(buttonEnableBigCorpora, 1, 2);

		/* Filtering property selection */		
		Label labelProp = toolkit.createLabel(sectionClient, "Filtering property: ");
		applyTableWrapLayout(labelProp);
		
		ComboViewer propertyComboViewer = createSingleTermPropertySelector(
				sectionClient, 
				TermsuiteuiPackage.Literals.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY);
		applyTableWrapLayout(propertyComboViewer.getControl());

		/* The "mode" option button */
		SelectObservableValue buttonBigCorporaMode = new SelectObservableValue();
		dbc.bindValue(buttonBigCorporaMode, EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__BIG_CORPORA_CLEANING_MODE).observeDetail(this.pipelineValue));

		/*
		 * Mode option 1: Periodic cleaning
		 */
		Button buttonPeriodicCleaning = new Button(sectionClient, SWT.RADIO);
		buttonPeriodicCleaning.setText("Set a periodic filtering (every n documents)");
		buttonBigCorporaMode.addOption(EPeriodicCleaningMode.DOCUMENT_PERIOD, WidgetProperties.selection().observe(buttonPeriodicCleaning));
		applyTableWrapLayout(buttonPeriodicCleaning, 1, 2);

		/* Property threshold */
		Text textPropertyThreshold = createTextField(toolkit, sectionClient, "Threshold:", 
				TermsuiteuiPackage.Literals.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD, 
				new DoubleValidator(0, Double.MAX_VALUE), 
				new StringToDoubleConverter());

		/* Document period */
		Text textDocumentPeriod = createTextField(toolkit, sectionClient, "Document period:", 
				TermsuiteuiPackage.Literals.EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD, 
				new IntegerValidator(1, Integer.MAX_VALUE), 
				new StringToIntegerConverter());

		/*
		 * Mode option 2: Capped termino
		 */
		Button buttonCappedTermino = new Button(sectionClient, SWT.RADIO);
		applyTableWrapLayout(buttonCappedTermino, 1, 2);
		buttonCappedTermino.setText("Cap the terminology with a max number of terms");
		buttonBigCorporaMode.addOption(EPeriodicCleaningMode.MAX_NUMBER_OF_TERMS, WidgetProperties.selection().observe(buttonCappedTermino));
				
				
		/* Document period */
		Text textMaxNumberOfTerms = createTextField(toolkit, sectionClient, "Max number of terms:", 
				TermsuiteuiPackage.Literals.EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS, 
				new IntegerValidator(1, Integer.MAX_VALUE), 
				new StringToIntegerConverter());
		
		/* Binding enables to "Enable" button */
		bindAttributeToEnables(TermsuiteuiPackage.Literals.EPIPELINE__BIG_CORPORA_HANDLING_ENABLED,
				buttonPeriodicCleaning, textDocumentPeriod, textPropertyThreshold, propertyComboViewer.getControl(), 
				buttonCappedTermino, textMaxNumberOfTerms
			);
	}

	private Section createExpandableSection(FormToolkit toolkit, final ScrolledForm form) {
		Section s;
		s = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE);
		s.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		return s;
	}

	@Persist
	public void save(MDirtyable dirty, PipelineService pipelineService,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			EPipeline pipeline) {
		// save changes via ITodoService for example
		try {
			pipelineService.savePipeline(pipeline);

			// save was successful
			dirty.setDirty(false);
		} catch (IOException e) {
			MessageDialog.openError(shell, "Save error", e.getMessage());
		}
	}


}
