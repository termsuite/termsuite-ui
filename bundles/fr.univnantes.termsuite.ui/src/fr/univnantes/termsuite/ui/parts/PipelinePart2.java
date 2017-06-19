
package fr.univnantes.termsuite.ui.parts;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
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
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.google.common.base.Preconditions;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import fr.univnantes.termsuite.ui.services.CorpusService;
import fr.univnantes.termsuite.ui.services.PipelineService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.jface.IntegerValidator;
import fr.univnantes.termsuite.ui.util.jface.StringToIntegerConverter;

@SuppressWarnings("restriction") 
public class PipelinePart2 {

	public static final String ID = "fr.univnantes.termsuite.ui.partdescriptor.PipelineEditor2";
	
	private static final String EDITOR_TITLE = "Terminology Extraction Pipeline";

	@Inject
	MDirtyable dirty;

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
		form.setText(EDITOR_TITLE);
		Composite body = form.getBody();
		body.setLayout(new ColumnLayout());
//		toolkit.decorateFormHeading(form.getForm());
//		toolkit.paintBordersFor(body);

		// create Preprocess section
		createPreprocessSection(toolkit, form);
		
		// Configure Tagger
		createExtractTerminoSection(toolkit, form);

	}


	
	private void createPreprocessSection(FormToolkit toolkit, final ScrolledForm form) {
		
		/*
		 * POS tagger
		 */
		Composite taggerClient = createSection(
				toolkit, 
				form, 
				"POS tagger", 
				"The tagger/lemmatizer is a 3rd-party program setting syntactic labels and lemmas to each word annotation.");		
		setTableWrapLayout(taggerClient, 1);
		

		ComboViewer taggerComboViewer = createComboEntry(
				taggerClient, 
				"Tagger: ", 
				taggerService.getTaggerConfigNames().toArray());

		dbc.bindValue(
				ViewerProperties.singleSelection().observe(taggerComboViewer), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__TAGGER_CONFIG_NAME).observeDetail(this.pipelineValue));
		
		
		/*
		 * Memory management
		 */
		Composite memoryClient = createSection(
				toolkit, 
				form, 
				"Memory management", 
				"The maximum number of terms in memory during document preprocessing. If the number of terms exceeds the limit, the innner spotted terminology will filter terms by frequency.");		
		setTableWrapLayout(memoryClient, 2);


		Text memoryText = createTextEntry(
				toolkit, 
				memoryClient, 
				"Limit: ");
		Binding memoryBinding = dbc.bindValue(
				WidgetProperties.text(SWT.Modify).observe(memoryText), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__MAX_NUM_TERMS_MEMORY).observeDetail(this.pipelineValue),
				integerUpdateStrategy(100, Integer.MAX_VALUE),
				integerUpdateStrategy(100, Integer.MAX_VALUE)
				);
		ControlDecorationSupport.create(memoryBinding, SWT.TOP | SWT.RIGHT);

		
		/*
		 * Occurrences of terms
		 */
		Composite occurrenceClient = createSection(
				toolkit, 
				form, 
				"Occurrences of terms", 
				"By default, the occurrences of all terms are indexed and kept in memory. The number of occurrences in memory can be an issue when the corpus is too large. In this case, you can either to deactivate the occurrence indexing, but no contextualizing nor distributional alignment would be possible, or to use a persistent store on the filesystem instead (impacts preprocessor and contextualizer performances)");		
		setTableWrapLayout(occurrenceClient, 1);

		
		SelectObservableValue<EOccurrenceMode> buttonMode = createRadioEntry(
				toolkit, 
				occurrenceClient,
				"Keep occurrences in memory", EOccurrenceMode.KEEP_IN_MEMORY,
				"Keep occurrences in a persistent store on the filesystem", EOccurrenceMode.KEEP_IN_FILESYSTEM,
				"Skip occurrence indexing", EOccurrenceMode.DO_NOT_KEEP
				);

		dbc.bindValue(buttonMode, EMFProperties
				.value(TermsuiteuiPackage.Literals.EPIPELINE__OCCURRENCE_MODE).observeDetail(this.pipelineValue));

		
		/*
		 * Term filtering
		 */
		Composite filterClient = createSection(
				toolkit, 
				form, 
				"Term filtering", 
				"Select how the extracted terminology is filtered to fit your needs.");		
		
		
		/*
		 * Semantic variant detection
		 */
		Composite semanticClient = createSection(
				toolkit, 
				form, 
				"Semantic variant detection", 
				"TermSuite is able to detect semantic variants of a term (synonyms, antonyms, and hyperonyms). The algorithm is based on a inner synonym dictionary and a distributional alignment, i.e. on the similarity of terms' context vectors. Activating distributional alignment detects more candidates but also impact the precision and detection time. Note that you can improve drastically the performances by using your own synonym dictionary instead of the embedded one.");		
		setTableWrapLayout(semanticClient, 2);

		Button enableSemanticButton = createCheckbox(
				toolkit, 
				semanticClient, 
				"Enable semantic variant detection");
		applyTableWrapLayout(enableSemanticButton, 1, 2);

		Button semDicoOnlyButton = createCheckbox(
				toolkit, 
				semanticClient, 
				"Dictionary only (deactivate distributional alignement)");
		applyTableWrapLayout(semDicoOnlyButton, 1, 2);

		ComboViewer semanticSimMeasureViewer = createComboEntry(
				semanticClient, 
				"Semantic similary measure", 
				ESimilarityMeasure.values());
		
		dbc.bindValue(
				ViewerProperties.singleSelection().observe(semanticSimMeasureViewer), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__SEM_MEASURE).observeDetail(this.pipelineValue));

		Text maxCandidatesText = createTextEntry(
				toolkit, 
				semanticClient, 
				"Max number of candidates per term: ");
	
		Binding maxBind = dbc.bindValue(
				WidgetProperties.text(SWT.Modify).observe(maxCandidatesText), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__SEM_NUM_CANDIDATES).observeDetail(this.pipelineValue),
				integerUpdateStrategy(1, 100),
				integerUpdateStrategy(1, 100)
				);
		ControlDecorationSupport.create(maxBind, SWT.TOP | SWT.RIGHT);

		bindEnable(enableSemanticButton, 
				maxCandidatesText, 
				semanticSimMeasureViewer.getCombo(),
				semDicoOnlyButton);

		/*
		 * Conextualizer
		 */
		Composite contextualizerClient = createSection(
				toolkit, 
				form, 
				"Contextualizer", 
				"Configure whether and how TermSuite should produce context vectors for all single-word terms. Context vectors are mandatory for distributional alignment, i.e. for semantic variant detection (except when \"dictionary only\" option is selected) and for bilingual alignment.");
		setTableWrapLayout(contextualizerClient, 2);

		Button enableContexualizerButton = createCheckbox(
				toolkit, 
				contextualizerClient, 
				"Enable contextualizer");
		applyTableWrapLayout(enableContexualizerButton, 1, 2);

		ComboViewer assocMeasureViewer = createComboEntry(
				contextualizerClient, 
				"Association measure", 
				EAssocMeasure.values());
		
		dbc.bindValue(
				ViewerProperties.singleSelection().observe(assocMeasureViewer), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__CONTEXT_ASSOC_MEASURE).observeDetail(this.pipelineValue));

		Text scopeText = createTextEntry(
				toolkit, 
				contextualizerClient, 
				"Scope: ");
	
		Binding scopeBind = dbc.bindValue(
				WidgetProperties.text(SWT.Modify).observe(scopeText), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__CONTEXT_SCOPE).observeDetail(this.pipelineValue),
				integerUpdateStrategy(1, 10),
				integerUpdateStrategy(1, 10)
				);
		ControlDecorationSupport.create(scopeBind, SWT.TOP | SWT.RIGHT);

		bindEnable(enableContexualizerButton, 
				scopeText, 
				assocMeasureViewer.getCombo());
	}

	private UpdateValueStrategy integerUpdateStrategy(int min, int max) {
		return new UpdateValueStrategy()
				.setConverter(new StringToIntegerConverter())
				.setAfterGetValidator(new IntegerValidator(min, max));
	}

	private void bindEnable(Button enableButton, Control... controls) {
		for(Control c:controls)
			dbc.bindValue(
				WidgetProperties.selection().observe(enableButton), 
				WidgetProperties.enabled().observe(c));
	}

	private Button createCheckbox(FormToolkit toolkit, Composite parent, String text) {
		return toolkit.createButton(parent, text, SWT.CHECK);
	}

	private SelectObservableValue<EOccurrenceMode> createRadioEntry(FormToolkit toolkit, Composite parent, Object... labelsAndValues) {
		Preconditions.checkArgument(labelsAndValues.length %2 == 0);
		SelectObservableValue<EOccurrenceMode> buttonMode = new SelectObservableValue<EOccurrenceMode>();

		Button[] buttons = new Button[labelsAndValues.length/2];
		for(int i=0; i< labelsAndValues.length/2; i++) {
			Button button = new Button(parent, SWT.RADIO);
			button.setText((String)labelsAndValues[2*i]);
			EOccurrenceMode occMode = (EOccurrenceMode)labelsAndValues[2*i+1];
			buttonMode.addOption(occMode, WidgetProperties.selection().observe(button));
			applyTableWrapLayout(button);
			buttons[i]=button;
		}
		return buttonMode;
	}

	private Text createTextEntry(FormToolkit toolkit, Composite parent, String label) {
		createLabel(parent, label);
		Text text = toolkit.createText(parent, "");
		text.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE));
		return text;
	}

	private Composite createSection(FormToolkit toolkit, final ScrolledForm form, String sectionTitle,
			String sectionDescription) {
		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText(sectionTitle);
		section.setDescription(sectionDescription);
		section.setExpanded(true);
		Composite sectionClient = toolkit.createComposite(section);
		section.setClient(sectionClient);
		return sectionClient;
	}

	private ComboViewer createComboEntry(Composite parent, String label, Object... values) {
		createLabel(parent, label);
		
		ComboViewer taggerComboViewer = new ComboViewer(parent, SWT.DROP_DOWN);
		applyTableWrapLayout(taggerComboViewer.getControl());
		taggerComboViewer.setContentProvider(ArrayContentProvider.getInstance());
		taggerComboViewer.setLabelProvider(new LabelProvider());
		taggerComboViewer.setInput(values);
		return taggerComboViewer;
	}

	private void createLabel(Composite parent, String label) {
		Label l = new Label(parent, SWT.NONE);
		l.setText(label);
		applyTableWrapLayout(l);
	}

	private void createExtractTerminoSection(FormToolkit toolkit, final ScrolledForm form) {
		
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
