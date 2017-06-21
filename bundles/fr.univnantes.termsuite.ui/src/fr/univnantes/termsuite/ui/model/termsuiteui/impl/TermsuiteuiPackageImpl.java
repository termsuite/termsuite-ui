/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;
import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TermsuiteuiPackageImpl extends EPackageImpl implements TermsuiteuiPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eCorporaListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eCorpusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSingleLanguageCorpusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePipelineListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTerminologyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTerminoViewerConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTaggerConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eBilingualDictionaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLinguisticResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLinguisticResourceSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTerminoFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eLangEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eTaggerEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eFilteringModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eOccurrenceModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eAssocMeasureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eSimilarityMeasureEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TermsuiteuiPackageImpl() {
		super(eNS_URI, TermsuiteuiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TermsuiteuiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TermsuiteuiPackage init() {
		if (isInited) return (TermsuiteuiPackage)EPackage.Registry.INSTANCE.getEPackage(TermsuiteuiPackage.eNS_URI);

		// Obtain or create and register package
		TermsuiteuiPackageImpl theTermsuiteuiPackage = (TermsuiteuiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TermsuiteuiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TermsuiteuiPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTermsuiteuiPackage.createPackageContents();

		// Initialize created meta-data
		theTermsuiteuiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTermsuiteuiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TermsuiteuiPackage.eNS_URI, theTermsuiteuiPackage);
		return theTermsuiteuiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECorporaList() {
		return eCorporaListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECorporaList_Corpora() {
		return (EReference)eCorporaListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECorpus() {
		return eCorpusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECorpus_Path() {
		return (EAttribute)eCorpusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECorpus_SingleLanguageCorpora() {
		return (EReference)eCorpusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getECorpus_Name() {
		return (EAttribute)eCorpusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESingleLanguageCorpus() {
		return eSingleLanguageCorpusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESingleLanguageCorpus_Language() {
		return (EAttribute)eSingleLanguageCorpusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESingleLanguageCorpus_Corpus() {
		return (EReference)eSingleLanguageCorpusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESingleLanguageCorpus_Terminologies() {
		return (EReference)eSingleLanguageCorpusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDocument() {
		return eDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDocument_Filename() {
		return (EAttribute)eDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDocument_SingleLanguageCorpus() {
		return (EReference)eDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPipeline() {
		return ePipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_ContextualizerEnabled() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_OccurrenceMode() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_ContextScope() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_ContextAssocMeasure() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_SemEnabled() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_SemMeasure() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_SemDicoOnly() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_SemNumCandidates() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_Name() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_TaggerConfigName() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPipeline_Filter() {
		return (EReference)ePipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPipeline_MaxNumTermsMemory() {
		return (EAttribute)ePipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPipelineList() {
		return ePipelineListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPipelineList_Pipelines() {
		return (EReference)ePipelineListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETerminology() {
		return eTerminologyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminology_Name() {
		return (EAttribute)eTerminologyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminology_HasOccurrences() {
		return (EAttribute)eTerminologyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminology_HasContexts() {
		return (EAttribute)eTerminologyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETerminology_Corpus() {
		return (EReference)eTerminologyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETerminoViewerConfig() {
		return eTerminoViewerConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminoViewerConfig_NbDisplayedTerms() {
		return (EAttribute)eTerminoViewerConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminoViewerConfig_SearchString() {
		return (EAttribute)eTerminoViewerConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEResource() {
		return eResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEResource_Id() {
		return (EAttribute)eResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETaggerConfig() {
		return eTaggerConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETaggerConfig_Name() {
		return (EAttribute)eTaggerConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETaggerConfig_TaggerType() {
		return (EAttribute)eTaggerConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETaggerConfig_Path() {
		return (EAttribute)eTaggerConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEBilingualDictionary() {
		return eBilingualDictionaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBilingualDictionary_SourceLang() {
		return (EAttribute)eBilingualDictionaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBilingualDictionary_TargetLang() {
		return (EAttribute)eBilingualDictionaryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBilingualDictionary_Path() {
		return (EAttribute)eBilingualDictionaryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELinguisticResource() {
		return eLinguisticResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getELinguisticResource_ResourceSet() {
		return (EReference)eLinguisticResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELinguisticResource_Name() {
		return (EAttribute)eLinguisticResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELinguisticResource_Path() {
		return (EAttribute)eLinguisticResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELinguisticResource_Description() {
		return (EAttribute)eLinguisticResourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELinguisticResourceSet() {
		return eLinguisticResourceSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELinguisticResourceSet_Language() {
		return (EAttribute)eLinguisticResourceSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getELinguisticResourceSet_Resources() {
		return (EReference)eLinguisticResourceSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETerminoFilter() {
		return eTerminoFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminoFilter_PropertyName() {
		return (EAttribute)eTerminoFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminoFilter_TopN() {
		return (EAttribute)eTerminoFilterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminoFilter_Threshold() {
		return (EAttribute)eTerminoFilterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminoFilter_KeepVariants() {
		return (EAttribute)eTerminoFilterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETerminoFilter_Mode() {
		return (EAttribute)eTerminoFilterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getELang() {
		return eLangEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getETagger() {
		return eTaggerEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEFilteringMode() {
		return eFilteringModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEOccurrenceMode() {
		return eOccurrenceModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEAssocMeasure() {
		return eAssocMeasureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getESimilarityMeasure() {
		return eSimilarityMeasureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermsuiteuiFactory getTermsuiteuiFactory() {
		return (TermsuiteuiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eCorporaListEClass = createEClass(ECORPORA_LIST);
		createEReference(eCorporaListEClass, ECORPORA_LIST__CORPORA);

		eCorpusEClass = createEClass(ECORPUS);
		createEAttribute(eCorpusEClass, ECORPUS__PATH);
		createEReference(eCorpusEClass, ECORPUS__SINGLE_LANGUAGE_CORPORA);
		createEAttribute(eCorpusEClass, ECORPUS__NAME);

		eSingleLanguageCorpusEClass = createEClass(ESINGLE_LANGUAGE_CORPUS);
		createEAttribute(eSingleLanguageCorpusEClass, ESINGLE_LANGUAGE_CORPUS__LANGUAGE);
		createEReference(eSingleLanguageCorpusEClass, ESINGLE_LANGUAGE_CORPUS__CORPUS);
		createEReference(eSingleLanguageCorpusEClass, ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES);

		eDocumentEClass = createEClass(EDOCUMENT);
		createEAttribute(eDocumentEClass, EDOCUMENT__FILENAME);
		createEReference(eDocumentEClass, EDOCUMENT__SINGLE_LANGUAGE_CORPUS);

		ePipelineEClass = createEClass(EPIPELINE);
		createEAttribute(ePipelineEClass, EPIPELINE__CONTEXTUALIZER_ENABLED);
		createEAttribute(ePipelineEClass, EPIPELINE__OCCURRENCE_MODE);
		createEAttribute(ePipelineEClass, EPIPELINE__TAGGER_CONFIG_NAME);
		createEReference(ePipelineEClass, EPIPELINE__FILTER);
		createEAttribute(ePipelineEClass, EPIPELINE__MAX_NUM_TERMS_MEMORY);
		createEAttribute(ePipelineEClass, EPIPELINE__CONTEXT_SCOPE);
		createEAttribute(ePipelineEClass, EPIPELINE__CONTEXT_ASSOC_MEASURE);
		createEAttribute(ePipelineEClass, EPIPELINE__SEM_ENABLED);
		createEAttribute(ePipelineEClass, EPIPELINE__SEM_MEASURE);
		createEAttribute(ePipelineEClass, EPIPELINE__SEM_DICO_ONLY);
		createEAttribute(ePipelineEClass, EPIPELINE__SEM_NUM_CANDIDATES);
		createEAttribute(ePipelineEClass, EPIPELINE__NAME);

		ePipelineListEClass = createEClass(EPIPELINE_LIST);
		createEReference(ePipelineListEClass, EPIPELINE_LIST__PIPELINES);

		eTerminologyEClass = createEClass(ETERMINOLOGY);
		createEAttribute(eTerminologyEClass, ETERMINOLOGY__NAME);
		createEAttribute(eTerminologyEClass, ETERMINOLOGY__HAS_OCCURRENCES);
		createEAttribute(eTerminologyEClass, ETERMINOLOGY__HAS_CONTEXTS);
		createEReference(eTerminologyEClass, ETERMINOLOGY__CORPUS);

		eTerminoViewerConfigEClass = createEClass(ETERMINO_VIEWER_CONFIG);
		createEAttribute(eTerminoViewerConfigEClass, ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS);
		createEAttribute(eTerminoViewerConfigEClass, ETERMINO_VIEWER_CONFIG__SEARCH_STRING);

		eResourceEClass = createEClass(ERESOURCE);
		createEAttribute(eResourceEClass, ERESOURCE__ID);

		eTaggerConfigEClass = createEClass(ETAGGER_CONFIG);
		createEAttribute(eTaggerConfigEClass, ETAGGER_CONFIG__NAME);
		createEAttribute(eTaggerConfigEClass, ETAGGER_CONFIG__TAGGER_TYPE);
		createEAttribute(eTaggerConfigEClass, ETAGGER_CONFIG__PATH);

		eBilingualDictionaryEClass = createEClass(EBILINGUAL_DICTIONARY);
		createEAttribute(eBilingualDictionaryEClass, EBILINGUAL_DICTIONARY__SOURCE_LANG);
		createEAttribute(eBilingualDictionaryEClass, EBILINGUAL_DICTIONARY__TARGET_LANG);
		createEAttribute(eBilingualDictionaryEClass, EBILINGUAL_DICTIONARY__PATH);

		eLinguisticResourceEClass = createEClass(ELINGUISTIC_RESOURCE);
		createEReference(eLinguisticResourceEClass, ELINGUISTIC_RESOURCE__RESOURCE_SET);
		createEAttribute(eLinguisticResourceEClass, ELINGUISTIC_RESOURCE__NAME);
		createEAttribute(eLinguisticResourceEClass, ELINGUISTIC_RESOURCE__PATH);
		createEAttribute(eLinguisticResourceEClass, ELINGUISTIC_RESOURCE__DESCRIPTION);

		eLinguisticResourceSetEClass = createEClass(ELINGUISTIC_RESOURCE_SET);
		createEAttribute(eLinguisticResourceSetEClass, ELINGUISTIC_RESOURCE_SET__LANGUAGE);
		createEReference(eLinguisticResourceSetEClass, ELINGUISTIC_RESOURCE_SET__RESOURCES);

		eTerminoFilterEClass = createEClass(ETERMINO_FILTER);
		createEAttribute(eTerminoFilterEClass, ETERMINO_FILTER__PROPERTY_NAME);
		createEAttribute(eTerminoFilterEClass, ETERMINO_FILTER__TOP_N);
		createEAttribute(eTerminoFilterEClass, ETERMINO_FILTER__THRESHOLD);
		createEAttribute(eTerminoFilterEClass, ETERMINO_FILTER__KEEP_VARIANTS);
		createEAttribute(eTerminoFilterEClass, ETERMINO_FILTER__MODE);

		// Create enums
		eLangEEnum = createEEnum(ELANG);
		eTaggerEEnum = createEEnum(ETAGGER);
		eFilteringModeEEnum = createEEnum(EFILTERING_MODE);
		eOccurrenceModeEEnum = createEEnum(EOCCURRENCE_MODE);
		eAssocMeasureEEnum = createEEnum(EASSOC_MEASURE);
		eSimilarityMeasureEEnum = createEEnum(ESIMILARITY_MEASURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eDocumentEClass.getESuperTypes().add(this.getEResource());
		ePipelineEClass.getESuperTypes().add(this.getEResource());
		eTerminologyEClass.getESuperTypes().add(this.getEResource());

		// Initialize classes, features, and operations; add parameters
		initEClass(eCorporaListEClass, ECorporaList.class, "ECorporaList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getECorporaList_Corpora(), this.getECorpus(), null, "corpora", null, 0, -1, ECorporaList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eCorpusEClass, ECorpus.class, "ECorpus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getECorpus_Path(), ecorePackage.getEString(), "path", "", 1, 1, ECorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getECorpus_SingleLanguageCorpora(), this.getESingleLanguageCorpus(), this.getESingleLanguageCorpus_Corpus(), "singleLanguageCorpora", null, 0, -1, ECorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getECorpus_SingleLanguageCorpora().getEKeys().add(this.getESingleLanguageCorpus_Language());
		initEAttribute(getECorpus_Name(), ecorePackage.getEString(), "name", null, 0, 1, ECorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSingleLanguageCorpusEClass, ESingleLanguageCorpus.class, "ESingleLanguageCorpus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESingleLanguageCorpus_Language(), this.getELang(), "language", null, 1, 1, ESingleLanguageCorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESingleLanguageCorpus_Corpus(), this.getECorpus(), this.getECorpus_SingleLanguageCorpora(), "corpus", null, 1, 1, ESingleLanguageCorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESingleLanguageCorpus_Terminologies(), this.getETerminology(), this.getETerminology_Corpus(), "terminologies", null, 0, -1, ESingleLanguageCorpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDocumentEClass, EDocument.class, "EDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDocument_Filename(), ecorePackage.getEString(), "filename", null, 1, 1, EDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEDocument_SingleLanguageCorpus(), this.getESingleLanguageCorpus(), null, "singleLanguageCorpus", null, 1, 1, EDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePipelineEClass, EPipeline.class, "EPipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEPipeline_ContextualizerEnabled(), ecorePackage.getEBoolean(), "contextualizerEnabled", "false", 0, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_OccurrenceMode(), this.getEOccurrenceMode(), "occurrenceMode", "KEEP_IN_MEMORY", 1, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_TaggerConfigName(), ecorePackage.getEString(), "taggerConfigName", null, 0, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPipeline_Filter(), this.getETerminoFilter(), null, "filter", null, 0, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_MaxNumTermsMemory(), ecorePackage.getEInt(), "maxNumTermsMemory", "500000", 1, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_ContextScope(), ecorePackage.getEInt(), "contextScope", "3", 0, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_ContextAssocMeasure(), this.getEAssocMeasure(), "contextAssocMeasure", "MUTUAL_INFORMATION", 1, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_SemEnabled(), ecorePackage.getEBoolean(), "semEnabled", "false", 1, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_SemMeasure(), this.getESimilarityMeasure(), "semMeasure", "COSINE", 1, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_SemDicoOnly(), ecorePackage.getEBoolean(), "semDicoOnly", "false", 1, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_SemNumCandidates(), ecorePackage.getEInt(), "semNumCandidates", "5", 0, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPipeline_Name(), ecorePackage.getEString(), "name", null, 0, 1, EPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePipelineListEClass, EPipelineList.class, "EPipelineList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEPipelineList_Pipelines(), this.getEPipeline(), null, "pipelines", null, 0, -1, EPipelineList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTerminologyEClass, ETerminology.class, "ETerminology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getETerminology_Name(), ecorePackage.getEString(), "name", "", 0, 1, ETerminology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETerminology_HasOccurrences(), ecorePackage.getEBoolean(), "hasOccurrences", "false", 1, 1, ETerminology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETerminology_HasContexts(), ecorePackage.getEBoolean(), "hasContexts", "false", 1, 1, ETerminology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getETerminology_Corpus(), this.getESingleLanguageCorpus(), this.getESingleLanguageCorpus_Terminologies(), "corpus", null, 1, 1, ETerminology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTerminoViewerConfigEClass, ETerminoViewerConfig.class, "ETerminoViewerConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getETerminoViewerConfig_NbDisplayedTerms(), ecorePackage.getEInt(), "nbDisplayedTerms", "500", 0, 1, ETerminoViewerConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETerminoViewerConfig_SearchString(), ecorePackage.getEString(), "searchString", "", 1, 1, ETerminoViewerConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eResourceEClass, EResource.class, "EResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEResource_Id(), ecorePackage.getEString(), "id", null, 0, 1, EResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTaggerConfigEClass, ETaggerConfig.class, "ETaggerConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getETaggerConfig_Name(), ecorePackage.getEString(), "name", null, 0, 1, ETaggerConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETaggerConfig_TaggerType(), this.getETagger(), "taggerType", "TREE_TAGGER", 1, 1, ETaggerConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETaggerConfig_Path(), ecorePackage.getEString(), "path", null, 0, 1, ETaggerConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eBilingualDictionaryEClass, EBilingualDictionary.class, "EBilingualDictionary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEBilingualDictionary_SourceLang(), this.getELang(), "sourceLang", null, 0, 1, EBilingualDictionary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEBilingualDictionary_TargetLang(), this.getELang(), "targetLang", null, 0, 1, EBilingualDictionary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEBilingualDictionary_Path(), ecorePackage.getEString(), "path", null, 0, 1, EBilingualDictionary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLinguisticResourceEClass, ELinguisticResource.class, "ELinguisticResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getELinguisticResource_ResourceSet(), this.getELinguisticResourceSet(), this.getELinguisticResourceSet_Resources(), "resourceSet", null, 1, 1, ELinguisticResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELinguisticResource_Name(), ecorePackage.getEString(), "name", null, 0, 1, ELinguisticResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELinguisticResource_Path(), ecorePackage.getEString(), "path", "", 0, 1, ELinguisticResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELinguisticResource_Description(), ecorePackage.getEString(), "description", null, 0, 1, ELinguisticResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLinguisticResourceSetEClass, ELinguisticResourceSet.class, "ELinguisticResourceSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELinguisticResourceSet_Language(), this.getELang(), "language", "en", 0, 1, ELinguisticResourceSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getELinguisticResourceSet_Resources(), this.getELinguisticResource(), this.getELinguisticResource_ResourceSet(), "resources", null, 0, -1, ELinguisticResourceSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTerminoFilterEClass, ETerminoFilter.class, "ETerminoFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getETerminoFilter_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, ETerminoFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETerminoFilter_TopN(), ecorePackage.getEInt(), "topN", "500", 0, 1, ETerminoFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETerminoFilter_Threshold(), ecorePackage.getEDouble(), "threshold", "0.9", 0, 1, ETerminoFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETerminoFilter_KeepVariants(), ecorePackage.getEBoolean(), "keepVariants", "true", 0, 1, ETerminoFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getETerminoFilter_Mode(), this.getEFilteringMode(), "mode", null, 1, 1, ETerminoFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eLangEEnum, ELang.class, "ELang");
		addEEnumLiteral(eLangEEnum, ELang.FR);
		addEEnumLiteral(eLangEEnum, ELang.EN);
		addEEnumLiteral(eLangEEnum, ELang.ES);
		addEEnumLiteral(eLangEEnum, ELang.DE);
		addEEnumLiteral(eLangEEnum, ELang.RU);
		addEEnumLiteral(eLangEEnum, ELang.DA);
		addEEnumLiteral(eLangEEnum, ELang.ZH);
		addEEnumLiteral(eLangEEnum, ELang.LV);
		addEEnumLiteral(eLangEEnum, ELang.IT);

		initEEnum(eTaggerEEnum, ETagger.class, "ETagger");
		addEEnumLiteral(eTaggerEEnum, ETagger.TREE_TAGGER);
		addEEnumLiteral(eTaggerEEnum, ETagger.MATE);

		initEEnum(eFilteringModeEEnum, EFilteringMode.class, "EFilteringMode");
		addEEnumLiteral(eFilteringModeEEnum, EFilteringMode.TOP_N);
		addEEnumLiteral(eFilteringModeEEnum, EFilteringMode.THRESHOLD);

		initEEnum(eOccurrenceModeEEnum, EOccurrenceMode.class, "EOccurrenceMode");
		addEEnumLiteral(eOccurrenceModeEEnum, EOccurrenceMode.KEEP_IN_MEMORY);
		addEEnumLiteral(eOccurrenceModeEEnum, EOccurrenceMode.KEEP_IN_FILESYSTEM);
		addEEnumLiteral(eOccurrenceModeEEnum, EOccurrenceMode.DO_NOT_KEEP);

		initEEnum(eAssocMeasureEEnum, EAssocMeasure.class, "EAssocMeasure");
		addEEnumLiteral(eAssocMeasureEEnum, EAssocMeasure.LOG_LIKELYHOOD);
		addEEnumLiteral(eAssocMeasureEEnum, EAssocMeasure.MUTUAL_INFORMATION);

		initEEnum(eSimilarityMeasureEEnum, ESimilarityMeasure.class, "ESimilarityMeasure");
		addEEnumLiteral(eSimilarityMeasureEEnum, ESimilarityMeasure.COSINE);
		addEEnumLiteral(eSimilarityMeasureEEnum, ESimilarityMeasure.JACCARD);

		// Create resource
		createResource(eNS_URI);
	}

} //TermsuiteuiPackageImpl
