
package fr.univnantes.termsuite.ui.parts;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import fr.univnantes.termsuite.ui.TermSuiteEvents;
import fr.univnantes.termsuite.ui.TermSuiteUI;
import fr.univnantes.termsuite.ui.TermSuiteUIPreferences;
import fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import fr.univnantes.termsuite.ui.services.NLPService;
import fr.univnantes.termsuite.ui.services.ResourceService;
import fr.univnantes.termsuite.ui.services.TaggerService;
import fr.univnantes.termsuite.ui.util.jface.IntegerValidator;
import fr.univnantes.termsuite.ui.util.jface.StringToIntegerConverter;

@SuppressWarnings("restriction") 
public class PipelinePart {

	public static final String ID = "fr.univnantes.termsuite.ui.partdescriptor.PipelineEditor";
	
	private static final String EDITOR_TITLE = "Terminology Extraction Pipeline";

	@Inject
	MDirtyable dirty;
	
	/*
	 * An observable value for the current pipeline
	 */
	private WritableValue<EPipeline> pipelineValue = new WritableValue<>();
	
	/*
	 * An observable value containing the validation status message
	 */
	private WritableValue<String> pipelineStatusValue = new WritableValue<>();
	
	/*
	 * An observable value telling if the pipeline is valid
	 */
	private WritableValue<Boolean> pipelineValidValue = new WritableValue<>();

	private DataBindingContext dbc = new DataBindingContext();

	// Widgets

	IEclipseContext context;
	ScrolledForm form;

	@Inject @Optional
	private void init(@UIEventTopic(TermSuiteEvents.EDITOR_INITIATED) Object part, MPart mPart) {
		if(this == part) {
			EPipeline pipeline = (EPipeline) context.get(TermSuiteUI.INPUT_OBJECT);
			this.pipelineValue.setValue(pipeline);
			this.context.set(EPipeline.class, pipeline);
			pipeline.eAdapters().add(new EContentAdapter() {
				public void notifyChanged(Notification notification) {
					super.notifyChanged(notification);
					if(notification.getFeature().equals(TermsuiteuiPackage.eINSTANCE.getEPipeline_Name())) {
						mPart.setLabel(notification.getNewStringValue());
					} else {
						// set dirty, unless this is a pipeline rename
						dirty.setDirty(true);
						validatePipeline();
					}
				}
			});
			validatePipeline();
		}
	}

	
	@PostConstruct
	public void createControls(Composite parent,
			IEclipseContext context) {
		
		this.pipelineValidValue.setValue(false);
		this.context = context;
		
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
	    form = toolkit.createScrolledForm(parent);
		form.setText(EDITOR_TITLE);
		Composite body = form.getBody();
		body.setLayout(new ColumnLayout());


		/*
		 * Create the content
		 */
		createPipelineContent(toolkit, form);
	}

	private void validatePipeline() {
		EPipeline pipeline = pipelineValue.getValue();
		if(pipelineValue.getValue() == null) {
			this.pipelineValidValue.setValue(false);
			this.pipelineStatusValue.setValue("No pipeline value");
			form.setMessage("No pipeline value", IMessageProvider.ERROR);
		} else {
			String msg = context.get(NLPService.class).validatePipeline(pipeline);
			this.pipelineStatusValue.setValue(msg);
			this.pipelineValidValue.setValue(msg == null);
			if(this.pipelineStatusValue.getValue() == null)
				form.setMessage("Ok", IMessageProvider.NONE);
			else
				form.setMessage(this.pipelineStatusValue.getValue(), IMessageProvider.ERROR);
		}
	}

	
	@SuppressWarnings("unchecked")
	private void createPipelineContent(FormToolkit toolkit, final ScrolledForm form) {
		
		/*
		 * POS tagger
		 */
		Composite taggerClient = createSection(
				toolkit, 
				form, 
				"POS tagger", 
				"The tagger/lemmatizer is a 3rd-party program setting syntactic labels and lemmas to each word annotation.");		
		setTableWrapLayout(taggerClient, 3);
		

		// The pos tagger
		ComboViewer taggerComboViewer = createComboEntry(
				taggerClient, 
				"Tagger: ", 
				context.get(TaggerService.class).getTaggerConfigNames().toArray());
		Binding binding = dbc.bindValue(
				ViewerProperties.singleSelection().observe(taggerComboViewer), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__TAGGER_CONFIG_NAME).observeDetail(this.pipelineValue));

		Link refresh = new Link(taggerClient, SWT.BORDER);
		refresh.setText("<a>refresh</a>");
		
		Link installTagger = new Link(taggerClient, SWT.BORDER);
		installTagger.setText("You must <a>install an  external tagger</a>");
		installTagger.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Command command = context.get(ECommandService.class).getCommand("fr.univnantes.termsuite.ui.command.preferences");
			    ParameterizedCommand pCmd = new ParameterizedCommand(command, null);
			    if (context.get(EHandlerService.class).canExecute(pCmd)) 
					context.get(EHandlerService.class).executeHandler(pCmd);
			}
		});
		installTagger.setForeground(TermSuiteUI.COLOR_RED);
		installTagger.setVisible(context.get(TaggerService.class).getTaggerConfigNames().isEmpty());
		applyTableWrapLayout(installTagger, 1, 3);

		refresh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Collection<String> taggerConfigNames = context.get(TaggerService.class).getTaggerConfigNames();
				taggerComboViewer.setInput(taggerConfigNames.toArray());
				binding.updateModelToTarget();
				installTagger.setVisible(taggerConfigNames.isEmpty());
			}
		});


		
		InstanceScope.INSTANCE
			.getNode(TermSuiteUIPreferences.NODE_GENERAL)
			.addPreferenceChangeListener(this::taggerConfigUpdated);

		/*
		 * Memory management
		 */
		Composite memoryClient = createSection(
				toolkit, 
				form, 
				"Memory management", 
				"The maximum number of terms in memory during document preprocessing. If the number of terms exceeds the limit, the innner spotted terminology will filter terms by frequency.");		
		setTableWrapLayout(memoryClient, 2);

		
		// Text: Maximum number of terms in memory
		Text memoryText = createTextEntry(
				toolkit, 
				memoryClient, 
				"Maximum number of terms in memory: ");
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

		
		// Radio: the occurrence mode
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
		 * Semantic variant detection
		 */
		Composite semanticClient = createSection(
				toolkit, 
				form, 
				"Semantic variant detection", 
				"TermSuite is able to detect semantic variants of a term (synonyms, antonyms, and hyperonyms). The algorithm is based on a inner synonym dictionary and a distributional alignment, i.e. on the similarity of terms' context vectors. Activating distributional alignment detects more candidates but also impact the precision and detection time. Note that you can improve drastically the performances by using your own synonym dictionary instead of the embedded one.");		
		setTableWrapLayout(semanticClient, 2);

		// Checkbox: enabled semantic variant detection
		Button enableSemanticButton = createCheckbox(
				toolkit, 
				semanticClient, 
				"Enable semantic variant detection");
		applyTableWrapLayout(enableSemanticButton, 1, 2);
		dbc.bindValue(
				WidgetProperties.selection().observe(enableSemanticButton),
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__SEM_ENABLED).observeDetail(this.pipelineValue)
				);

		// Checkbox: the dico only method
		Button semDicoOnlyButton = createCheckbox(
				toolkit, 
				semanticClient, 
				"Dictionary only (deactivate distributional alignement)");
		applyTableWrapLayout(semDicoOnlyButton, 1, 2);
		dbc.bindValue(
				WidgetProperties.selection().observe(semDicoOnlyButton),
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__SEM_DICO_ONLY).observeDetail(this.pipelineValue)
				);

		// Combo: the similarity measure
		ComboViewer semanticSimMeasureViewer = createComboEntry(
				semanticClient, 
				"Semantic similary measure", 
				ESimilarityMeasure.values());
		dbc.bindValue(
				ViewerProperties.singleSelection().observe(semanticSimMeasureViewer), 
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__SEM_MEASURE).observeDetail(this.pipelineValue));

		// Text: max number of candidates
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
		 * Contextualizer
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
		dbc.bindValue(
				WidgetProperties.selection().observe(enableContexualizerButton),
				EMFProperties.value(TermsuiteuiPackage.Literals.EPIPELINE__CONTEXTUALIZER_ENABLED).observeDetail(this.pipelineValue)
				);

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
		
		
		
		/*
		 * Run
		 */
		Composite runClient = createSection(
				toolkit, 
				form, 
				"Run pipeline", 
				null);
		setTableWrapLayout(runClient, 1);


		// The ok status message
		Label okStatus = toolkit.createLabel(runClient, "The pipeline is valid", SWT.NONE);
		okStatus.setForeground(TermSuiteUI.COLOR_GREEN);
		dbc.bindValue(
				WidgetProperties.visible().observe(okStatus),
				pipelineValidValue
			);

		
		// The preprocessing cache
		Button reuseCache = toolkit.createButton(runClient, "Reuse NLP preprocessings (spotted terms) if they are in cache ", SWT.CHECK);

		
		// The run link
	    Composite composite = new Composite(runClient, SWT.NONE);
	    composite.setLayout(new RowLayout(SWT.HORIZONTAL));
	    Label imageLabel = new Label(composite, SWT.NONE);
	    imageLabel.setImage(TermSuiteUI.getImg("icons/run_exc.png").createImage());
	    Link runLink = new Link(composite, SWT.BORDER);
		runLink.setText("<a>Run</a> this pipeline...");
		dbc.bindValue(
				pipelineValidValue, 
				WidgetProperties.enabled().observe(runLink));
		runLink.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Map<String, Object> parameters = ImmutableMap.of(
						TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_PIPELINE_ID, 
						pipelineValue.getValue().getName(),
						TermSuiteUI.COMMAND_RUN_PIPELINE_PARAMETER_USE_CACHE,
						Boolean.toString(reuseCache.getSelection())
						);
				ParameterizedCommand command = context.get(ECommandService.class).createCommand(
						TermSuiteUI.COMMAND_RUN_PIPELINE_ID, 
						parameters);
				context.get(EHandlerService.class).executeHandler(command);
			}
		});
		
	}

	private void taggerConfigUpdated(PreferenceChangeEvent e) {
		if(e.getKey().equals(TermSuiteUIPreferences.TAGGERS)) {
			Collection<String> configNames = context.get(TaggerService.class).getTaggerConfigNames();
			EPipeline pipeline = this.pipelineValue.getValue();
			if(!configNames.isEmpty()
					&& pipeline.getTaggerConfigName() == null) {
				pipeline.setTaggerConfigName(configNames.iterator().next());
				
			}
		}
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
				 sectionDescription == null ? Section.TITLE_BAR : Section.TITLE_BAR | Section.DESCRIPTION);
		section.setText(sectionTitle);
		if(sectionDescription != null)
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
	public void save(MDirtyable dirty, ResourceService resourceService,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			EPipeline pipeline) {
		// save changes via ITodoService for example
		try {
			resourceService.savePipeline(pipeline);
			
			// save was successful
			dirty.setDirty(false);
		} catch (IOException e) {
			MessageDialog.openError(shell, "Save error", e.getMessage());
		}
	}

}
