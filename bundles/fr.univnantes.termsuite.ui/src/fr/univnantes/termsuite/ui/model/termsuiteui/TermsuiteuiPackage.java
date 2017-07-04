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
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPUS__ENCODING = 3;

	/**
	 * The number of structural features of the '<em>ECorpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORPUS_FEATURE_COUNT = 4;

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
	 * The feature id for the '<em><b>Terminologies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES = 2;

	/**
	 * The number of structural features of the '<em>ESingle Language Corpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESINGLE_LANGUAGE_CORPUS_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Single Language Corpus</b></em>' reference.
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
	 * The feature id for the '<em><b>Contextualizer Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__CONTEXTUALIZER_ENABLED = ERESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Occurrence Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__OCCURRENCE_MODE = ERESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tagger Config Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__TAGGER_CONFIG_NAME = ERESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__FILTER = ERESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Num Terms Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__MAX_NUM_TERMS_MEMORY = ERESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Context Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__CONTEXT_SCOPE = ERESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Context Assoc Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__CONTEXT_ASSOC_MEASURE = ERESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Sem Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__SEM_ENABLED = ERESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Sem Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__SEM_MEASURE = ERESOURCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Sem Dico Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__SEM_DICO_ONLY = ERESOURCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Sem Num Candidates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__SEM_NUM_CANDIDATES = ERESOURCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE__NAME = ERESOURCE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>EPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIPELINE_FEATURE_COUNT = ERESOURCE_FEATURE_COUNT + 12;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__NAME = ERESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Occurrences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__HAS_OCCURRENCES = ERESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Contexts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__HAS_CONTEXTS = ERESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Corpus</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY__CORPUS = ERESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>ETerminology</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINOLOGY_FEATURE_COUNT = ERESOURCE_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Sorting Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG__SORTING_PROPERTY_NAME = 2;

	/**
	 * The feature id for the '<em><b>Sorting Asc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG__SORTING_ASC = 3;

	/**
	 * The feature id for the '<em><b>Selected Property Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES = 4;

	/**
	 * The number of structural features of the '<em>ETermino Viewer Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_VIEWER_CONFIG_FEATURE_COUNT = 5;

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
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceImpl <em>ELinguistic Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getELinguisticResource()
	 * @generated
	 */
	int ELINGUISTIC_RESOURCE = 11;

	/**
	 * The feature id for the '<em><b>Resource Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE__RESOURCE_SET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE__PATH = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>ELinguistic Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>ELinguistic Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceSetImpl <em>ELinguistic Resource Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceSetImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getELinguisticResourceSet()
	 * @generated
	 */
	int ELINGUISTIC_RESOURCE_SET = 12;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE_SET__LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE_SET__RESOURCES = 1;

	/**
	 * The number of structural features of the '<em>ELinguistic Resource Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE_SET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>ELinguistic Resource Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELINGUISTIC_RESOURCE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl <em>ETermino Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETerminoFilter()
	 * @generated
	 */
	int ETERMINO_FILTER = 13;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_FILTER__PROPERTY_NAME = 0;

	/**
	 * The feature id for the '<em><b>Top N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_FILTER__TOP_N = 1;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_FILTER__THRESHOLD = 2;

	/**
	 * The feature id for the '<em><b>Keep Variants</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_FILTER__KEEP_VARIANTS = 3;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_FILTER__MODE = 4;

	/**
	 * The number of structural features of the '<em>ETermino Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_FILTER_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>ETermino Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETERMINO_FILTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang <em>ELang</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getELang()
	 * @generated
	 */
	int ELANG = 14;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETagger <em>ETagger</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETagger
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETagger()
	 * @generated
	 */
	int ETAGGER = 15;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode <em>EFiltering Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEFilteringMode()
	 * @generated
	 */
	int EFILTERING_MODE = 16;


	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode <em>EOccurrence Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEOccurrenceMode()
	 * @generated
	 */
	int EOCCURRENCE_MODE = 17;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure <em>EAssoc Measure</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEAssocMeasure()
	 * @generated
	 */
	int EASSOC_MEASURE = 18;

	/**
	 * The meta object id for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure <em>ESimilarity Measure</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getESimilarityMeasure()
	 * @generated
	 */
	int ESIMILARITY_MEASURE = 19;


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
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getEncoding()
	 * @see #getECorpus()
	 * @generated
	 */
	EAttribute getECorpus_Encoding();

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
	 * Returns the meta object for the reference '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getSingleLanguageCorpus <em>Single Language Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Language Corpus</em>'.
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
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOccurrenceMode <em>Occurrence Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occurrence Mode</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOccurrenceMode()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_OccurrenceMode();

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
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextAssocMeasure <em>Context Assoc Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Assoc Measure</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextAssocMeasure()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_ContextAssocMeasure();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemEnabled <em>Sem Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sem Enabled</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemEnabled()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_SemEnabled();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemMeasure <em>Sem Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sem Measure</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemMeasure()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_SemMeasure();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemDicoOnly <em>Sem Dico Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sem Dico Only</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemDicoOnly()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_SemDicoOnly();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemNumCandidates <em>Sem Num Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sem Num Candidates</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemNumCandidates()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_SemNumCandidates();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getName()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_Name();

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
	 * Returns the meta object for the reference '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Filter</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilter()
	 * @see #getEPipeline()
	 * @generated
	 */
	EReference getEPipeline_Filter();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getMaxNumTermsMemory <em>Max Num Terms Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Num Terms Memory</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getMaxNumTermsMemory()
	 * @see #getEPipeline()
	 * @generated
	 */
	EAttribute getEPipeline_MaxNumTermsMemory();

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
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSortingPropertyName <em>Sorting Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sorting Property Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSortingPropertyName()
	 * @see #getETerminoViewerConfig()
	 * @generated
	 */
	EAttribute getETerminoViewerConfig_SortingPropertyName();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#isSortingAsc <em>Sorting Asc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sorting Asc</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#isSortingAsc()
	 * @see #getETerminoViewerConfig()
	 * @generated
	 */
	EAttribute getETerminoViewerConfig_SortingAsc();

	/**
	 * Returns the meta object for the attribute list '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSelectedPropertyNames <em>Selected Property Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Selected Property Names</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSelectedPropertyNames()
	 * @see #getETerminoViewerConfig()
	 * @generated
	 */
	EAttribute getETerminoViewerConfig_SelectedPropertyNames();

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
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource <em>ELinguistic Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELinguistic Resource</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource
	 * @generated
	 */
	EClass getELinguisticResource();

	/**
	 * Returns the meta object for the container reference '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getResourceSet <em>Resource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Set</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getResourceSet()
	 * @see #getELinguisticResource()
	 * @generated
	 */
	EReference getELinguisticResource_ResourceSet();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getName()
	 * @see #getELinguisticResource()
	 * @generated
	 */
	EAttribute getELinguisticResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getPath()
	 * @see #getELinguisticResource()
	 * @generated
	 */
	EAttribute getELinguisticResource_Path();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getDescription()
	 * @see #getELinguisticResource()
	 * @generated
	 */
	EAttribute getELinguisticResource_Description();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet <em>ELinguistic Resource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ELinguistic Resource Set</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet
	 * @generated
	 */
	EClass getELinguisticResourceSet();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet#getLanguage()
	 * @see #getELinguisticResourceSet()
	 * @generated
	 */
	EAttribute getELinguisticResourceSet_Language();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet#getResources()
	 * @see #getELinguisticResourceSet()
	 * @generated
	 */
	EReference getELinguisticResourceSet_Resources();

	/**
	 * Returns the meta object for class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter <em>ETermino Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ETermino Filter</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter
	 * @generated
	 */
	EClass getETerminoFilter();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getPropertyName()
	 * @see #getETerminoFilter()
	 * @generated
	 */
	EAttribute getETerminoFilter_PropertyName();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getTopN <em>Top N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top N</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getTopN()
	 * @see #getETerminoFilter()
	 * @generated
	 */
	EAttribute getETerminoFilter_TopN();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getThreshold()
	 * @see #getETerminoFilter()
	 * @generated
	 */
	EAttribute getETerminoFilter_Threshold();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#isKeepVariants <em>Keep Variants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keep Variants</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#isKeepVariants()
	 * @see #getETerminoFilter()
	 * @generated
	 */
	EAttribute getETerminoFilter_KeepVariants();

	/**
	 * Returns the meta object for the attribute '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter#getMode()
	 * @see #getETerminoFilter()
	 * @generated
	 */
	EAttribute getETerminoFilter_Mode();

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
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETagger <em>ETagger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ETagger</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETagger
	 * @generated
	 */
	EEnum getETagger();

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
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode <em>EOccurrence Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EOccurrence Mode</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode
	 * @generated
	 */
	EEnum getEOccurrenceMode();

	/**
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure <em>EAssoc Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EAssoc Measure</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure
	 * @generated
	 */
	EEnum getEAssocMeasure();

	/**
	 * Returns the meta object for enum '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure <em>ESimilarity Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESimilarity Measure</em>'.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure
	 * @generated
	 */
	EEnum getESimilarityMeasure();

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
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORPUS__ENCODING = eINSTANCE.getECorpus_Encoding();

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
		 * The meta object literal for the '<em><b>Single Language Corpus</b></em>' reference feature.
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
		 * The meta object literal for the '<em><b>Contextualizer Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__CONTEXTUALIZER_ENABLED = eINSTANCE.getEPipeline_ContextualizerEnabled();

		/**
		 * The meta object literal for the '<em><b>Occurrence Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__OCCURRENCE_MODE = eINSTANCE.getEPipeline_OccurrenceMode();

		/**
		 * The meta object literal for the '<em><b>Context Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__CONTEXT_SCOPE = eINSTANCE.getEPipeline_ContextScope();

		/**
		 * The meta object literal for the '<em><b>Context Assoc Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__CONTEXT_ASSOC_MEASURE = eINSTANCE.getEPipeline_ContextAssocMeasure();

		/**
		 * The meta object literal for the '<em><b>Sem Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__SEM_ENABLED = eINSTANCE.getEPipeline_SemEnabled();

		/**
		 * The meta object literal for the '<em><b>Sem Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__SEM_MEASURE = eINSTANCE.getEPipeline_SemMeasure();

		/**
		 * The meta object literal for the '<em><b>Sem Dico Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__SEM_DICO_ONLY = eINSTANCE.getEPipeline_SemDicoOnly();

		/**
		 * The meta object literal for the '<em><b>Sem Num Candidates</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__SEM_NUM_CANDIDATES = eINSTANCE.getEPipeline_SemNumCandidates();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__NAME = eINSTANCE.getEPipeline_Name();

		/**
		 * The meta object literal for the '<em><b>Tagger Config Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__TAGGER_CONFIG_NAME = eINSTANCE.getEPipeline_TaggerConfigName();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPIPELINE__FILTER = eINSTANCE.getEPipeline_Filter();

		/**
		 * The meta object literal for the '<em><b>Max Num Terms Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPIPELINE__MAX_NUM_TERMS_MEMORY = eINSTANCE.getEPipeline_MaxNumTermsMemory();

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
		 * The meta object literal for the '<em><b>Sorting Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_VIEWER_CONFIG__SORTING_PROPERTY_NAME = eINSTANCE.getETerminoViewerConfig_SortingPropertyName();

		/**
		 * The meta object literal for the '<em><b>Sorting Asc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_VIEWER_CONFIG__SORTING_ASC = eINSTANCE.getETerminoViewerConfig_SortingAsc();

		/**
		 * The meta object literal for the '<em><b>Selected Property Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES = eINSTANCE.getETerminoViewerConfig_SelectedPropertyNames();

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
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceImpl <em>ELinguistic Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getELinguisticResource()
		 * @generated
		 */
		EClass ELINGUISTIC_RESOURCE = eINSTANCE.getELinguisticResource();

		/**
		 * The meta object literal for the '<em><b>Resource Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELINGUISTIC_RESOURCE__RESOURCE_SET = eINSTANCE.getELinguisticResource_ResourceSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELINGUISTIC_RESOURCE__NAME = eINSTANCE.getELinguisticResource_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELINGUISTIC_RESOURCE__PATH = eINSTANCE.getELinguisticResource_Path();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELINGUISTIC_RESOURCE__DESCRIPTION = eINSTANCE.getELinguisticResource_Description();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceSetImpl <em>ELinguistic Resource Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ELinguisticResourceSetImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getELinguisticResourceSet()
		 * @generated
		 */
		EClass ELINGUISTIC_RESOURCE_SET = eINSTANCE.getELinguisticResourceSet();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELINGUISTIC_RESOURCE_SET__LANGUAGE = eINSTANCE.getELinguisticResourceSet_Language();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELINGUISTIC_RESOURCE_SET__RESOURCES = eINSTANCE.getELinguisticResourceSet_Resources();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl <em>ETermino Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETerminoFilter()
		 * @generated
		 */
		EClass ETERMINO_FILTER = eINSTANCE.getETerminoFilter();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_FILTER__PROPERTY_NAME = eINSTANCE.getETerminoFilter_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Top N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_FILTER__TOP_N = eINSTANCE.getETerminoFilter_TopN();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_FILTER__THRESHOLD = eINSTANCE.getETerminoFilter_Threshold();

		/**
		 * The meta object literal for the '<em><b>Keep Variants</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_FILTER__KEEP_VARIANTS = eINSTANCE.getETerminoFilter_KeepVariants();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ETERMINO_FILTER__MODE = eINSTANCE.getETerminoFilter_Mode();

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
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETagger <em>ETagger</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETagger
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getETagger()
		 * @generated
		 */
		EEnum ETAGGER = eINSTANCE.getETagger();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode <em>EFiltering Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEFilteringMode()
		 * @generated
		 */
		EEnum EFILTERING_MODE = eINSTANCE.getEFilteringMode();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode <em>EOccurrence Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEOccurrenceMode()
		 * @generated
		 */
		EEnum EOCCURRENCE_MODE = eINSTANCE.getEOccurrenceMode();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure <em>EAssoc Measure</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getEAssocMeasure()
		 * @generated
		 */
		EEnum EASSOC_MEASURE = eINSTANCE.getEAssocMeasure();

		/**
		 * The meta object literal for the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure <em>ESimilarity Measure</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure
		 * @see fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiPackageImpl#getESimilarityMeasure()
		 * @generated
		 */
		EEnum ESIMILARITY_MEASURE = eINSTANCE.getESimilarityMeasure();

	}

} //TermsuiteuiPackage
