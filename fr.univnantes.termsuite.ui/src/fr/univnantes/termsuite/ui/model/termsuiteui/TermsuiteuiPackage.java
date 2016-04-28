/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory
 * @model kind="package"
 * @generated
 */
public interface TermsuiteuiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "termsuiteui";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://termsuite.univ-nantes.fr/ui/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tsui";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TermsuiteuiPackage eINSTANCE = fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorporaListImpl <em>ECorpora List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorporaListImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getECorporaList()
	 * @generated
	 */
	int ECORPORA_LIST = 0;

	/**
	 * The feature id for the '<em><b>Corpora</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPORA_LIST__CORPORA = 0;

	/**
	 * The number of structural features of the '<em>ECorpora List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPORA_LIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>ECorpora List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPORA_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorpusImpl <em>ECorpus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorpusImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getECorpus()
	 * @generated
	 */
	int ECORPUS = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPUS__PATH = 0;

	/**
	 * The feature id for the '<em><b>Single Language Corpora</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPUS__SINGLE_LANGUAGE_CORPORA = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPUS__NAME = 2;

	/**
	 * The number of structural features of the '<em>ECorpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPUS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>ECorpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPUS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl <em>ESingle Language Corpus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getESingleLanguageCorpus()
	 * @generated
	 */
	int ESINGLE_LANGUAGE_CORPUS = 2;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS__LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Corpus</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS__CORPUS = 1;

	/**
	 * The feature id for the '<em><b>Documents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS__DOCUMENTS = 2;

	/**
	 * The feature id for the '<em><b>Collection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS__COLLECTION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Terminologies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES = 4;

	/**
	 * The number of structural features of the '<em>ESingle Language Corpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>ESingle Language Corpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EResourceImpl <em>EResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EResourceImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEResource()
	 * @generated
	 */
	int ERESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE__ID = 0;

	/**
	 * The number of structural features of the '<em>EResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>EResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EDocumentImpl <em>EDocument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EDocumentImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEDocument()
	 * @generated
	 */
	int EDOCUMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT__ID = ERESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT__FILENAME = ERESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Single Language Corpus</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT__SINGLE_LANGUAGE_CORPUS = ERESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EDocument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT_FEATURE_COUNT = ERESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>EDocument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT_OPERATION_COUNT = ERESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl <em>EPipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEPipeline()
	 * @generated
	 */
	int EPIPELINE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__ID = ERESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Morphosyntactic Analysis Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED = ERESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Syntactic Variation Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__SYNTACTIC_VARIATION_ENABLED = ERESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Graphical Variation Analysis Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED = ERESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contextualizer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__CONTEXTUALIZER_ENABLED = ERESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Graphical Similarity Threshhold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD = ERESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Compost Max Component Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_MAX_COMPONENT_SIZE = ERESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Compost Min Component Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_MIN_COMPONENT_NUM = ERESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Compost Score Threshhold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_SCORE_THRESHHOLD = ERESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Compost Segment Similarity Threshhold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_SEGMENT_SIMILARITY_THRESHHOLD = ERESOURCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Compost Use Language Default Coeffs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_USE_LANGUAGE_DEFAULT_COEFFS = ERESOURCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Compost Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_ALPHA = ERESOURCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Compost Beta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_BETA = ERESOURCE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Compost Gamma</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_GAMMA = ERESOURCE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Compost Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__COMPOST_DELTA = ERESOURCE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Spot With Occurrences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__SPOT_WITH_OCCURRENCES = ERESOURCE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Filtering Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__FILTERING_ENABLED = ERESOURCE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Export Cas To Xmi Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED = ERESOURCE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Export Cas To Tsv Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED = ERESOURCE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Export Cas To Json Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED = ERESOURCE_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Export Termino To Json Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__EXPORT_TERMINO_TO_JSON_ENABLED = ERESOURCE_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Export Termino To Tbx Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED = ERESOURCE_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Export Termino To Tsv Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED = ERESOURCE_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Big Corpora Handling Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__BIG_CORPORA_HANDLING_ENABLED = ERESOURCE_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Big Corpora Cleaning Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__BIG_CORPORA_CLEANING_MODE = ERESOURCE_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Context Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__CONTEXT_SCOPE = ERESOURCE_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Contextualize On SWT Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY = ERESOURCE_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Context Allow MWT As Cooc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC = ERESOURCE_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Filtering Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__FILTERING_MODE = ERESOURCE_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Filtering Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__FILTERING_THRESHOLD = ERESOURCE_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Filtering Top N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__FILTERING_TOP_N = ERESOURCE_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Filtering Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__FILTERING_PROPERTY = ERESOURCE_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Big Corpora Filtering Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY = ERESOURCE_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Big Corpora Document Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD = ERESOURCE_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Big Corpora Filtering Property Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD = ERESOURCE_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Big Corpora Max Number Of Terms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS = ERESOURCE_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Target Terminology Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__TARGET_TERMINOLOGY_NAME = ERESOURCE_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Output Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__OUTPUT_DIR = ERESOURCE_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__FILENAME = ERESOURCE_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>Tagger Config Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__TAGGER_CONFIG_NAME = ERESOURCE_FEATURE_COUNT + 38;

	/**
	 * The number of structural features of the '<em>EPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE_FEATURE_COUNT = ERESOURCE_FEATURE_COUNT + 39;

	/**
	 * The number of operations of the '<em>EPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE_OPERATION_COUNT = ERESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineListImpl <em>EPipeline List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineListImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEPipelineList()
	 * @generated
	 */
	int EPIPELINE_LIST = 5;

	/**
	 * The feature id for the '<em><b>Pipelines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE_LIST__PIPELINES = 0;

	/**
	 * The number of structural features of the '<em>EPipeline List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE_LIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>EPipeline List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl <em>ETerminology</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETerminology()
	 * @generated
	 */
	int ETERMINOLOGY = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__ID = ERESOURCE__ID;

	/**
	 * The feature id for the '<em><b>Filepath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__FILEPATH = ERESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__NAME = ERESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Occurrences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__HAS_OCCURRENCES = ERESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Has Contexts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__HAS_CONTEXTS = ERESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Corpus</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__CORPUS = ERESOURCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>ETerminology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY_FEATURE_COUNT = ERESOURCE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>ETerminology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY_OPERATION_COUNT = ERESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl <em>ETermino Viewer Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETerminoViewerConfig()
	 * @generated
	 */
	int ETERMINO_VIEWER_CONFIG = 7;

	/**
	 * The feature id for the '<em><b>Nb Displayed Terms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS = 0;

	/**
	 * The feature id for the '<em><b>Search String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG__SEARCH_STRING = 1;

	/**
	 * The number of structural features of the '<em>ETermino Viewer Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>ETermino Viewer Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETaggerConfigImpl <em>ETagger Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETaggerConfigImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETaggerConfig()
	 * @generated
	 */
	int ETAGGER_CONFIG = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAGGER_CONFIG__NAME = 0;

	/**
	 * The feature id for the '<em><b>Tagger Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAGGER_CONFIG__TAGGER_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAGGER_CONFIG__PATH = 2;

	/**
	 * The number of structural features of the '<em>ETagger Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAGGER_CONFIG_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>ETagger Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETAGGER_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EBilingualDictionaryImpl <em>EBilingual Dictionary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EBilingualDictionaryImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEBilingualDictionary()
	 * @generated
	 */
	int EBILINGUAL_DICTIONARY = 10;

	/**
	 * The feature id for the '<em><b>Source Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBILINGUAL_DICTIONARY__SOURCE_LANG = 0;

	/**
	 * The feature id for the '<em><b>Target Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBILINGUAL_DICTIONARY__TARGET_LANG = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBILINGUAL_DICTIONARY__PATH = 2;

	/**
	 * The number of structural features of the '<em>EBilingual Dictionary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBILINGUAL_DICTIONARY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>EBilingual Dictionary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBILINGUAL_DICTIONARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang <em>ELang</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getELang()
	 * @generated
	 */
	int ELANG = 11;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType <em>ECollection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getECollectionType()
	 * @generated
	 */
	int ECOLLECTION_TYPE = 12;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETagger <em>ETagger</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETagger
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETagger()
	 * @generated
	 */
	int ETAGGER = 13;


	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode <em>EPeriodic Cleaning Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEPeriodicCleaningMode()
	 * @generated
	 */
	int EPERIODIC_CLEANING_MODE = 14;


	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode <em>EFiltering Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEFilteringMode()
	 * @generated
	 */
	int EFILTERING_MODE = 15;


	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList <em>ECorpora List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECorpora List</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList
	 * @generated
	 */
	EClass getECorporaList();

	/**
	 * Returns the meta object for the reference list '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList#getCorpora <em>Corpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Corpora</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList#getCorpora()
	 * @see #getECorporaList()
	 * @generated
	 */
	EReference getECorporaList_Corpora();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus <em>ECorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECorpus</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus
	 * @generated
	 */
	EClass getECorpus();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getPath()
	 * @see #getECorpus()
	 * @generated
	 */
	EAttribute getECorpus_Path();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getSingleLanguageCorpora <em>Single Language Corpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Single Language Corpora</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getSingleLanguageCorpora()
	 * @see #getECorpus()
	 * @generated
	 */
	EReference getECorpus_SingleLanguageCorpora();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getName()
	 * @see #getECorpus()
	 * @generated
	 */
	EAttribute getECorpus_Name();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus <em>ESingle Language Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESingle Language Corpus</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus
	 * @generated
	 */
	EClass getESingleLanguageCorpus();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getLanguage()
	 * @see #getESingleLanguageCorpus()
	 * @generated
	 */
	EAttribute getESingleLanguageCorpus_Language();

	/**
	 * Returns the meta object for the container reference '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Corpus</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCorpus()
	 * @see #getESingleLanguageCorpus()
	 * @generated
	 */
	EReference getESingleLanguageCorpus_Corpus();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getDocuments <em>Documents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documents</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getDocuments()
	 * @see #getESingleLanguageCorpus()
	 * @generated
	 */
	EReference getESingleLanguageCorpus_Documents();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Type</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCollectionType()
	 * @see #getESingleLanguageCorpus()
	 * @generated
	 */
	EAttribute getESingleLanguageCorpus_CollectionType();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getTerminologies <em>Terminologies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terminologies</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getTerminologies()
	 * @see #getESingleLanguageCorpus()
	 * @generated
	 */
	EReference getESingleLanguageCorpus_Terminologies();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument <em>EDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDocument</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EDocument
	 * @generated
	 */
	EClass getEDocument();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getFilename()
	 * @see #getEDocument()
	 * @generated
	 */
	EAttribute getEDocument_Filename();

	/**
	 * Returns the meta object for the container reference '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getSingleLanguageCorpus <em>Single Language Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Single Language Corpus</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getSingleLanguageCorpus()
	 * @see #getEDocument()
	 * @generated
	 */
	EReference getEDocument_SingleLanguageCorpus();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline <em>EPipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPipeline</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline
	 * @generated
	 */
	EClass getEPipeline();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isMorphosyntacticAnalysisEnabled <em>Morphosyntactic Analysis Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Morphosyntactic Analysis Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isMorphosyntacticAnalysisEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_MorphosyntacticAnalysisEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSyntacticVariationEnabled <em>Syntactic Variation Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Syntactic Variation Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSyntacticVariationEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_SyntacticVariationEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isGraphicalVariationAnalysisEnabled <em>Graphical Variation Analysis Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Graphical Variation Analysis Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isGraphicalVariationAnalysisEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_GraphicalVariationAnalysisEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizerEnabled <em>Contextualizer Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contextualizer Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizerEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ContextualizerEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getGraphicalSimilarityThreshhold <em>Graphical Similarity Threshhold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Graphical Similarity Threshhold</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getGraphicalSimilarityThreshhold()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_GraphicalSimilarityThreshhold();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMaxComponentSize <em>Compost Max Component Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Max Component Size</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMaxComponentSize()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostMaxComponentSize();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMinComponentNum <em>Compost Min Component Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Min Component Num</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMinComponentNum()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostMinComponentNum();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostScoreThreshhold <em>Compost Score Threshhold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Score Threshhold</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostScoreThreshhold()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostScoreThreshhold();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostSegmentSimilarityThreshhold <em>Compost Segment Similarity Threshhold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Segment Similarity Threshhold</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostSegmentSimilarityThreshhold()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostSegmentSimilarityThreshhold();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isCompostUseLanguageDefaultCoeffs <em>Compost Use Language Default Coeffs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Use Language Default Coeffs</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isCompostUseLanguageDefaultCoeffs()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostUseLanguageDefaultCoeffs();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostAlpha <em>Compost Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Alpha</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostAlpha()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostAlpha();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostBeta <em>Compost Beta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Beta</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostBeta()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostBeta();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostGamma <em>Compost Gamma</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Gamma</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostGamma()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostGamma();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostDelta <em>Compost Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compost Delta</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostDelta()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_CompostDelta();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSpotWithOccurrences <em>Spot With Occurrences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spot With Occurrences</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSpotWithOccurrences()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_SpotWithOccurrences();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isFilteringEnabled <em>Filtering Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filtering Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isFilteringEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_FilteringEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToXmiEnabled <em>Export Cas To Xmi Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Cas To Xmi Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToXmiEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ExportCasToXmiEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToTsvEnabled <em>Export Cas To Tsv Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Cas To Tsv Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToTsvEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ExportCasToTsvEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToJsonEnabled <em>Export Cas To Json Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Cas To Json Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToJsonEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ExportCasToJsonEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToJsonEnabled <em>Export Termino To Json Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Termino To Json Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToJsonEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ExportTerminoToJsonEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTbxEnabled <em>Export Termino To Tbx Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Termino To Tbx Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTbxEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ExportTerminoToTbxEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTsvEnabled <em>Export Termino To Tsv Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Termino To Tsv Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTsvEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ExportTerminoToTsvEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isBigCorporaHandlingEnabled <em>Big Corpora Handling Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Corpora Handling Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isBigCorporaHandlingEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_BigCorporaHandlingEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaCleaningMode <em>Big Corpora Cleaning Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Corpora Cleaning Mode</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaCleaningMode()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_BigCorporaCleaningMode();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextScope <em>Context Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Scope</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextScope()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ContextScope();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizeOnSWTOnly <em>Contextualize On SWT Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contextualize On SWT Only</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizeOnSWTOnly()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ContextualizeOnSWTOnly();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextAllowMWTAsCooc <em>Context Allow MWT As Cooc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Allow MWT As Cooc</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextAllowMWTAsCooc()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ContextAllowMWTAsCooc();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringMode <em>Filtering Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filtering Mode</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringMode()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_FilteringMode();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringThreshold <em>Filtering Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filtering Threshold</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringThreshold()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_FilteringThreshold();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringTopN <em>Filtering Top N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filtering Top N</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringTopN()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_FilteringTopN();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringProperty <em>Filtering Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filtering Property</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringProperty()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_FilteringProperty();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringProperty <em>Big Corpora Filtering Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Corpora Filtering Property</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringProperty()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_BigCorporaFilteringProperty();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaDocumentPeriod <em>Big Corpora Document Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Corpora Document Period</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaDocumentPeriod()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_BigCorporaDocumentPeriod();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringPropertyThreshold <em>Big Corpora Filtering Property Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Corpora Filtering Property Threshold</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringPropertyThreshold()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_BigCorporaFilteringPropertyThreshold();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaMaxNumberOfTerms <em>Big Corpora Max Number Of Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Corpora Max Number Of Terms</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaMaxNumberOfTerms()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_BigCorporaMaxNumberOfTerms();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTargetTerminologyName <em>Target Terminology Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Terminology Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTargetTerminologyName()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_TargetTerminologyName();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOutputDir <em>Output Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Dir</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOutputDir()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_OutputDir();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilename()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_Filename();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTaggerConfigName <em>Tagger Config Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tagger Config Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTaggerConfigName()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_TaggerConfigName();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList <em>EPipeline List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPipeline List</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList
	 * @generated
	 */
	EClass getEPipelineList();

	/**
	 * Returns the meta object for the reference list '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pipelines</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList#getPipelines()
	 * @see #getEPipelineList()
	 * @generated
	 */
	EReference getEPipelineList_Pipelines();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology <em>ETerminology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETerminology</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology
	 * @generated
	 */
	EClass getETerminology();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getFilepath <em>Filepath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filepath</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getFilepath()
	 * @see #getETerminology()
	 * @generated
	 */
	EAttribute getETerminology_Filepath();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getName()
	 * @see #getETerminology()
	 * @generated
	 */
	EAttribute getETerminology_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasOccurrences <em>Has Occurrences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Occurrences</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasOccurrences()
	 * @see #getETerminology()
	 * @generated
	 */
	EAttribute getETerminology_HasOccurrences();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasContexts <em>Has Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Contexts</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasContexts()
	 * @see #getETerminology()
	 * @generated
	 */
	EAttribute getETerminology_HasContexts();

	/**
	 * Returns the meta object for the container reference '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Corpus</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus()
	 * @see #getETerminology()
	 * @generated
	 */
	EReference getETerminology_Corpus();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig <em>ETermino Viewer Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETermino Viewer Config</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig
	 * @generated
	 */
	EClass getETerminoViewerConfig();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getNbDisplayedTerms <em>Nb Displayed Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Displayed Terms</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getNbDisplayedTerms()
	 * @see #getETerminoViewerConfig()
	 * @generated
	 */
	EAttribute getETerminoViewerConfig_NbDisplayedTerms();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSearchString <em>Search String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Search String</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSearchString()
	 * @see #getETerminoViewerConfig()
	 * @generated
	 */
	EAttribute getETerminoViewerConfig_SearchString();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EResource <em>EResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EResource</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EResource
	 * @generated
	 */
	EClass getEResource();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EResource#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EResource#getId()
	 * @see #getEResource()
	 * @generated
	 */
	EAttribute getEResource_Id();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig <em>ETagger Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETagger Config</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig
	 * @generated
	 */
	EClass getETaggerConfig();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig#getName()
	 * @see #getETaggerConfig()
	 * @generated
	 */
	EAttribute getETaggerConfig_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig#getTaggerType <em>Tagger Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tagger Type</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig#getTaggerType()
	 * @see #getETaggerConfig()
	 * @generated
	 */
	EAttribute getETaggerConfig_TaggerType();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig#getPath()
	 * @see #getETaggerConfig()
	 * @generated
	 */
	EAttribute getETaggerConfig_Path();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary <em>EBilingual Dictionary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EBilingual Dictionary</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary
	 * @generated
	 */
	EClass getEBilingualDictionary();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getSourceLang <em>Source Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Lang</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getSourceLang()
	 * @see #getEBilingualDictionary()
	 * @generated
	 */
	EAttribute getEBilingualDictionary_SourceLang();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getTargetLang <em>Target Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Lang</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getTargetLang()
	 * @see #getEBilingualDictionary()
	 * @generated
	 */
	EAttribute getEBilingualDictionary_TargetLang();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getPath()
	 * @see #getEBilingualDictionary()
	 * @generated
	 */
	EAttribute getEBilingualDictionary_Path();

	/**
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang <em>ELang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ELang</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @generated
	 */
	EEnum getELang();

	/**
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType <em>ECollection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ECollection Type</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType
	 * @generated
	 */
	EEnum getECollectionType();

	/**
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETagger <em>ETagger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ETagger</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETagger
	 * @generated
	 */
	EEnum getETagger();

	/**
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode <em>EPeriodic Cleaning Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EPeriodic Cleaning Mode</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode
	 * @generated
	 */
	EEnum getEPeriodicCleaningMode();

	/**
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode <em>EFiltering Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EFiltering Mode</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode
	 * @generated
	 */
	EEnum getEFilteringMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TermsuiteuiFactory getTermsuiteuiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorporaListImpl <em>ECorpora List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorporaListImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getECorporaList()
		 * @generated
		 */
		EClass ECORPORA_LIST = eINSTANCE.getECorporaList();

		/**
		 * The meta object literal for the '<em><b>Corpora</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORPORA_LIST__CORPORA = eINSTANCE.getECorporaList_Corpora();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorpusImpl <em>ECorpus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorpusImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getECorpus()
		 * @generated
		 */
		EClass ECORPUS = eINSTANCE.getECorpus();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORPUS__PATH = eINSTANCE.getECorpus_Path();

		/**
		 * The meta object literal for the '<em><b>Single Language Corpora</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORPUS__SINGLE_LANGUAGE_CORPORA = eINSTANCE.getECorpus_SingleLanguageCorpora();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORPUS__NAME = eINSTANCE.getECorpus_Name();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl <em>ESingle Language Corpus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getESingleLanguageCorpus()
		 * @generated
		 */
		EClass ESINGLE_LANGUAGE_CORPUS = eINSTANCE.getESingleLanguageCorpus();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESINGLE_LANGUAGE_CORPUS__LANGUAGE = eINSTANCE.getESingleLanguageCorpus_Language();

		/**
		 * The meta object literal for the '<em><b>Corpus</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESINGLE_LANGUAGE_CORPUS__CORPUS = eINSTANCE.getESingleLanguageCorpus_Corpus();

		/**
		 * The meta object literal for the '<em><b>Documents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESINGLE_LANGUAGE_CORPUS__DOCUMENTS = eINSTANCE.getESingleLanguageCorpus_Documents();

		/**
		 * The meta object literal for the '<em><b>Collection Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESINGLE_LANGUAGE_CORPUS__COLLECTION_TYPE = eINSTANCE.getESingleLanguageCorpus_CollectionType();

		/**
		 * The meta object literal for the '<em><b>Terminologies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES = eINSTANCE.getESingleLanguageCorpus_Terminologies();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EDocumentImpl <em>EDocument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EDocumentImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEDocument()
		 * @generated
		 */
		EClass EDOCUMENT = eINSTANCE.getEDocument();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDOCUMENT__FILENAME = eINSTANCE.getEDocument_Filename();

		/**
		 * The meta object literal for the '<em><b>Single Language Corpus</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDOCUMENT__SINGLE_LANGUAGE_CORPUS = eINSTANCE.getEDocument_SingleLanguageCorpus();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl <em>EPipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEPipeline()
		 * @generated
		 */
		EClass EPIPELINE = eINSTANCE.getEPipeline();

		/**
		 * The meta object literal for the '<em><b>Morphosyntactic Analysis Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED = eINSTANCE.getEPipeline_MorphosyntacticAnalysisEnabled();

		/**
		 * The meta object literal for the '<em><b>Syntactic Variation Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__SYNTACTIC_VARIATION_ENABLED = eINSTANCE.getEPipeline_SyntacticVariationEnabled();

		/**
		 * The meta object literal for the '<em><b>Graphical Variation Analysis Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED = eINSTANCE.getEPipeline_GraphicalVariationAnalysisEnabled();

		/**
		 * The meta object literal for the '<em><b>Contextualizer Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__CONTEXTUALIZER_ENABLED = eINSTANCE.getEPipeline_ContextualizerEnabled();

		/**
		 * The meta object literal for the '<em><b>Graphical Similarity Threshhold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD = eINSTANCE.getEPipeline_GraphicalSimilarityThreshhold();

		/**
		 * The meta object literal for the '<em><b>Compost Max Component Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_MAX_COMPONENT_SIZE = eINSTANCE.getEPipeline_CompostMaxComponentSize();

		/**
		 * The meta object literal for the '<em><b>Compost Min Component Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_MIN_COMPONENT_NUM = eINSTANCE.getEPipeline_CompostMinComponentNum();

		/**
		 * The meta object literal for the '<em><b>Compost Score Threshhold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_SCORE_THRESHHOLD = eINSTANCE.getEPipeline_CompostScoreThreshhold();

		/**
		 * The meta object literal for the '<em><b>Compost Segment Similarity Threshhold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_SEGMENT_SIMILARITY_THRESHHOLD = eINSTANCE.getEPipeline_CompostSegmentSimilarityThreshhold();

		/**
		 * The meta object literal for the '<em><b>Compost Use Language Default Coeffs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_USE_LANGUAGE_DEFAULT_COEFFS = eINSTANCE.getEPipeline_CompostUseLanguageDefaultCoeffs();

		/**
		 * The meta object literal for the '<em><b>Compost Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_ALPHA = eINSTANCE.getEPipeline_CompostAlpha();

		/**
		 * The meta object literal for the '<em><b>Compost Beta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_BETA = eINSTANCE.getEPipeline_CompostBeta();

		/**
		 * The meta object literal for the '<em><b>Compost Gamma</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_GAMMA = eINSTANCE.getEPipeline_CompostGamma();

		/**
		 * The meta object literal for the '<em><b>Compost Delta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__COMPOST_DELTA = eINSTANCE.getEPipeline_CompostDelta();

		/**
		 * The meta object literal for the '<em><b>Spot With Occurrences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__SPOT_WITH_OCCURRENCES = eINSTANCE.getEPipeline_SpotWithOccurrences();

		/**
		 * The meta object literal for the '<em><b>Filtering Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__FILTERING_ENABLED = eINSTANCE.getEPipeline_FilteringEnabled();

		/**
		 * The meta object literal for the '<em><b>Export Cas To Xmi Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED = eINSTANCE.getEPipeline_ExportCasToXmiEnabled();

		/**
		 * The meta object literal for the '<em><b>Export Cas To Tsv Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED = eINSTANCE.getEPipeline_ExportCasToTsvEnabled();

		/**
		 * The meta object literal for the '<em><b>Export Cas To Json Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED = eINSTANCE.getEPipeline_ExportCasToJsonEnabled();

		/**
		 * The meta object literal for the '<em><b>Export Termino To Json Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__EXPORT_TERMINO_TO_JSON_ENABLED = eINSTANCE.getEPipeline_ExportTerminoToJsonEnabled();

		/**
		 * The meta object literal for the '<em><b>Export Termino To Tbx Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED = eINSTANCE.getEPipeline_ExportTerminoToTbxEnabled();

		/**
		 * The meta object literal for the '<em><b>Export Termino To Tsv Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED = eINSTANCE.getEPipeline_ExportTerminoToTsvEnabled();

		/**
		 * The meta object literal for the '<em><b>Big Corpora Handling Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__BIG_CORPORA_HANDLING_ENABLED = eINSTANCE.getEPipeline_BigCorporaHandlingEnabled();

		/**
		 * The meta object literal for the '<em><b>Big Corpora Cleaning Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__BIG_CORPORA_CLEANING_MODE = eINSTANCE.getEPipeline_BigCorporaCleaningMode();

		/**
		 * The meta object literal for the '<em><b>Context Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__CONTEXT_SCOPE = eINSTANCE.getEPipeline_ContextScope();

		/**
		 * The meta object literal for the '<em><b>Contextualize On SWT Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY = eINSTANCE.getEPipeline_ContextualizeOnSWTOnly();

		/**
		 * The meta object literal for the '<em><b>Context Allow MWT As Cooc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC = eINSTANCE.getEPipeline_ContextAllowMWTAsCooc();

		/**
		 * The meta object literal for the '<em><b>Filtering Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__FILTERING_MODE = eINSTANCE.getEPipeline_FilteringMode();

		/**
		 * The meta object literal for the '<em><b>Filtering Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__FILTERING_THRESHOLD = eINSTANCE.getEPipeline_FilteringThreshold();

		/**
		 * The meta object literal for the '<em><b>Filtering Top N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__FILTERING_TOP_N = eINSTANCE.getEPipeline_FilteringTopN();

		/**
		 * The meta object literal for the '<em><b>Filtering Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__FILTERING_PROPERTY = eINSTANCE.getEPipeline_FilteringProperty();

		/**
		 * The meta object literal for the '<em><b>Big Corpora Filtering Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY = eINSTANCE.getEPipeline_BigCorporaFilteringProperty();

		/**
		 * The meta object literal for the '<em><b>Big Corpora Document Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD = eINSTANCE.getEPipeline_BigCorporaDocumentPeriod();

		/**
		 * The meta object literal for the '<em><b>Big Corpora Filtering Property Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD = eINSTANCE.getEPipeline_BigCorporaFilteringPropertyThreshold();

		/**
		 * The meta object literal for the '<em><b>Big Corpora Max Number Of Terms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS = eINSTANCE.getEPipeline_BigCorporaMaxNumberOfTerms();

		/**
		 * The meta object literal for the '<em><b>Target Terminology Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__TARGET_TERMINOLOGY_NAME = eINSTANCE.getEPipeline_TargetTerminologyName();

		/**
		 * The meta object literal for the '<em><b>Output Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__OUTPUT_DIR = eINSTANCE.getEPipeline_OutputDir();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__FILENAME = eINSTANCE.getEPipeline_Filename();

		/**
		 * The meta object literal for the '<em><b>Tagger Config Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__TAGGER_CONFIG_NAME = eINSTANCE.getEPipeline_TaggerConfigName();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineListImpl <em>EPipeline List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineListImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEPipelineList()
		 * @generated
		 */
		EClass EPIPELINE_LIST = eINSTANCE.getEPipelineList();

		/**
		 * The meta object literal for the '<em><b>Pipelines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPIPELINE_LIST__PIPELINES = eINSTANCE.getEPipelineList_Pipelines();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl <em>ETerminology</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETerminology()
		 * @generated
		 */
		EClass ETERMINOLOGY = eINSTANCE.getETerminology();

		/**
		 * The meta object literal for the '<em><b>Filepath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINOLOGY__FILEPATH = eINSTANCE.getETerminology_Filepath();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINOLOGY__NAME = eINSTANCE.getETerminology_Name();

		/**
		 * The meta object literal for the '<em><b>Has Occurrences</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINOLOGY__HAS_OCCURRENCES = eINSTANCE.getETerminology_HasOccurrences();

		/**
		 * The meta object literal for the '<em><b>Has Contexts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINOLOGY__HAS_CONTEXTS = eINSTANCE.getETerminology_HasContexts();

		/**
		 * The meta object literal for the '<em><b>Corpus</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETERMINOLOGY__CORPUS = eINSTANCE.getETerminology_Corpus();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl <em>ETermino Viewer Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETerminoViewerConfig()
		 * @generated
		 */
		EClass ETERMINO_VIEWER_CONFIG = eINSTANCE.getETerminoViewerConfig();

		/**
		 * The meta object literal for the '<em><b>Nb Displayed Terms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS = eINSTANCE.getETerminoViewerConfig_NbDisplayedTerms();

		/**
		 * The meta object literal for the '<em><b>Search String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_VIEWER_CONFIG__SEARCH_STRING = eINSTANCE.getETerminoViewerConfig_SearchString();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EResourceImpl <em>EResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EResourceImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEResource()
		 * @generated
		 */
		EClass ERESOURCE = eINSTANCE.getEResource();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERESOURCE__ID = eINSTANCE.getEResource_Id();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETaggerConfigImpl <em>ETagger Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETaggerConfigImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETaggerConfig()
		 * @generated
		 */
		EClass ETAGGER_CONFIG = eINSTANCE.getETaggerConfig();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETAGGER_CONFIG__NAME = eINSTANCE.getETaggerConfig_Name();

		/**
		 * The meta object literal for the '<em><b>Tagger Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETAGGER_CONFIG__TAGGER_TYPE = eINSTANCE.getETaggerConfig_TaggerType();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETAGGER_CONFIG__PATH = eINSTANCE.getETaggerConfig_Path();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EBilingualDictionaryImpl <em>EBilingual Dictionary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.EBilingualDictionaryImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEBilingualDictionary()
		 * @generated
		 */
		EClass EBILINGUAL_DICTIONARY = eINSTANCE.getEBilingualDictionary();

		/**
		 * The meta object literal for the '<em><b>Source Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBILINGUAL_DICTIONARY__SOURCE_LANG = eINSTANCE.getEBilingualDictionary_SourceLang();

		/**
		 * The meta object literal for the '<em><b>Target Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBILINGUAL_DICTIONARY__TARGET_LANG = eINSTANCE.getEBilingualDictionary_TargetLang();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBILINGUAL_DICTIONARY__PATH = eINSTANCE.getEBilingualDictionary_Path();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang <em>ELang</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getELang()
		 * @generated
		 */
		EEnum ELANG = eINSTANCE.getELang();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType <em>ECollection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getECollectionType()
		 * @generated
		 */
		EEnum ECOLLECTION_TYPE = eINSTANCE.getECollectionType();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETagger <em>ETagger</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETagger
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETagger()
		 * @generated
		 */
		EEnum ETAGGER = eINSTANCE.getETagger();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode <em>EPeriodic Cleaning Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEPeriodicCleaningMode()
		 * @generated
		 */
		EEnum EPERIODIC_CLEANING_MODE = eINSTANCE.getEPeriodicCleaningMode();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode <em>EFiltering Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEFilteringMode()
		 * @generated
		 */
		EEnum EFILTERING_MODE = eINSTANCE.getEFilteringMode();

	}

} //TermsuiteuiPackage
