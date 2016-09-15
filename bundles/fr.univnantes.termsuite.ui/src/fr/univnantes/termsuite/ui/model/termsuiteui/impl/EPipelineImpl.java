/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isMorphosyntacticAnalysisEnabled <em>Morphosyntactic Analysis Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isSyntacticVariationEnabled <em>Syntactic Variation Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isGraphicalVariationAnalysisEnabled <em>Graphical Variation Analysis Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isContextualizerEnabled <em>Contextualizer Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getGraphicalSimilarityThreshhold <em>Graphical Similarity Threshhold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostMaxComponentSize <em>Compost Max Component Size</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostMinComponentNum <em>Compost Min Component Num</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostScoreThreshhold <em>Compost Score Threshhold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostSegmentSimilarityThreshhold <em>Compost Segment Similarity Threshhold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isCompostUseLanguageDefaultCoeffs <em>Compost Use Language Default Coeffs</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostAlpha <em>Compost Alpha</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostBeta <em>Compost Beta</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostGamma <em>Compost Gamma</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getCompostDelta <em>Compost Delta</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isSpotWithOccurrences <em>Spot With Occurrences</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isFilteringEnabled <em>Filtering Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isExportCasToXmiEnabled <em>Export Cas To Xmi Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isExportCasToTsvEnabled <em>Export Cas To Tsv Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isExportCasToJsonEnabled <em>Export Cas To Json Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isExportTerminoToJsonEnabled <em>Export Termino To Json Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isExportTerminoToTbxEnabled <em>Export Termino To Tbx Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isExportTerminoToTsvEnabled <em>Export Termino To Tsv Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isBigCorporaHandlingEnabled <em>Big Corpora Handling Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getBigCorporaCleaningMode <em>Big Corpora Cleaning Mode</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getContextScope <em>Context Scope</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isContextualizeOnSWTOnly <em>Contextualize On SWT Only</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isContextAllowMWTAsCooc <em>Context Allow MWT As Cooc</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getFilteringMode <em>Filtering Mode</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getFilteringThreshold <em>Filtering Threshold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getFilteringTopN <em>Filtering Top N</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getFilteringProperty <em>Filtering Property</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getBigCorporaFilteringProperty <em>Big Corpora Filtering Property</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getBigCorporaDocumentPeriod <em>Big Corpora Document Period</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getBigCorporaFilteringPropertyThreshold <em>Big Corpora Filtering Property Threshold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getBigCorporaMaxNumberOfTerms <em>Big Corpora Max Number Of Terms</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getTargetTerminologyName <em>Target Terminology Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getOutputDir <em>Output Dir</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getTaggerConfigName <em>Tagger Config Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EPipelineImpl extends EResourceImpl implements EPipeline {
	/**
	 * The default value of the '{@link #isMorphosyntacticAnalysisEnabled() <em>Morphosyntactic Analysis Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMorphosyntacticAnalysisEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MORPHOSYNTACTIC_ANALYSIS_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMorphosyntacticAnalysisEnabled() <em>Morphosyntactic Analysis Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMorphosyntacticAnalysisEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean morphosyntacticAnalysisEnabled = MORPHOSYNTACTIC_ANALYSIS_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSyntacticVariationEnabled() <em>Syntactic Variation Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSyntacticVariationEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYNTACTIC_VARIATION_ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSyntacticVariationEnabled() <em>Syntactic Variation Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSyntacticVariationEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean syntacticVariationEnabled = SYNTACTIC_VARIATION_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isGraphicalVariationAnalysisEnabled() <em>Graphical Variation Analysis Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGraphicalVariationAnalysisEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GRAPHICAL_VARIATION_ANALYSIS_ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGraphicalVariationAnalysisEnabled() <em>Graphical Variation Analysis Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGraphicalVariationAnalysisEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean graphicalVariationAnalysisEnabled = GRAPHICAL_VARIATION_ANALYSIS_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isContextualizerEnabled() <em>Contextualizer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextualizerEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTEXTUALIZER_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContextualizerEnabled() <em>Contextualizer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextualizerEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean contextualizerEnabled = CONTEXTUALIZER_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getGraphicalSimilarityThreshhold() <em>Graphical Similarity Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalSimilarityThreshhold()
	 * @generated
	 * @ordered
	 */
	protected static final double GRAPHICAL_SIMILARITY_THRESHHOLD_EDEFAULT = 0.9;

	/**
	 * The cached value of the '{@link #getGraphicalSimilarityThreshhold() <em>Graphical Similarity Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalSimilarityThreshhold()
	 * @generated
	 * @ordered
	 */
	protected double graphicalSimilarityThreshhold = GRAPHICAL_SIMILARITY_THRESHHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostMaxComponentSize() <em>Compost Max Component Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostMaxComponentSize()
	 * @generated
	 * @ordered
	 */
	protected static final int COMPOST_MAX_COMPONENT_SIZE_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getCompostMaxComponentSize() <em>Compost Max Component Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostMaxComponentSize()
	 * @generated
	 * @ordered
	 */
	protected int compostMaxComponentSize = COMPOST_MAX_COMPONENT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostMinComponentNum() <em>Compost Min Component Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostMinComponentNum()
	 * @generated
	 * @ordered
	 */
	protected static final int COMPOST_MIN_COMPONENT_NUM_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getCompostMinComponentNum() <em>Compost Min Component Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostMinComponentNum()
	 * @generated
	 * @ordered
	 */
	protected int compostMinComponentNum = COMPOST_MIN_COMPONENT_NUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostScoreThreshhold() <em>Compost Score Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostScoreThreshhold()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPOST_SCORE_THRESHHOLD_EDEFAULT = 0.7;

	/**
	 * The cached value of the '{@link #getCompostScoreThreshhold() <em>Compost Score Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostScoreThreshhold()
	 * @generated
	 * @ordered
	 */
	protected double compostScoreThreshhold = COMPOST_SCORE_THRESHHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostSegmentSimilarityThreshhold() <em>Compost Segment Similarity Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostSegmentSimilarityThreshhold()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPOST_SEGMENT_SIMILARITY_THRESHHOLD_EDEFAULT = 0.7;

	/**
	 * The cached value of the '{@link #getCompostSegmentSimilarityThreshhold() <em>Compost Segment Similarity Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostSegmentSimilarityThreshhold()
	 * @generated
	 * @ordered
	 */
	protected double compostSegmentSimilarityThreshhold = COMPOST_SEGMENT_SIMILARITY_THRESHHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #isCompostUseLanguageDefaultCoeffs() <em>Compost Use Language Default Coeffs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompostUseLanguageDefaultCoeffs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPOST_USE_LANGUAGE_DEFAULT_COEFFS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCompostUseLanguageDefaultCoeffs() <em>Compost Use Language Default Coeffs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompostUseLanguageDefaultCoeffs()
	 * @generated
	 * @ordered
	 */
	protected boolean compostUseLanguageDefaultCoeffs = COMPOST_USE_LANGUAGE_DEFAULT_COEFFS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostAlpha() <em>Compost Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPOST_ALPHA_EDEFAULT = 0.5;

	/**
	 * The cached value of the '{@link #getCompostAlpha() <em>Compost Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostAlpha()
	 * @generated
	 * @ordered
	 */
	protected double compostAlpha = COMPOST_ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostBeta() <em>Compost Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostBeta()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPOST_BETA_EDEFAULT = 0.1;

	/**
	 * The cached value of the '{@link #getCompostBeta() <em>Compost Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostBeta()
	 * @generated
	 * @ordered
	 */
	protected double compostBeta = COMPOST_BETA_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostGamma() <em>Compost Gamma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostGamma()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPOST_GAMMA_EDEFAULT = 0.1;

	/**
	 * The cached value of the '{@link #getCompostGamma() <em>Compost Gamma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostGamma()
	 * @generated
	 * @ordered
	 */
	protected double compostGamma = COMPOST_GAMMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompostDelta() <em>Compost Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostDelta()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPOST_DELTA_EDEFAULT = 0.3;

	/**
	 * The cached value of the '{@link #getCompostDelta() <em>Compost Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompostDelta()
	 * @generated
	 * @ordered
	 */
	protected double compostDelta = COMPOST_DELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #isSpotWithOccurrences() <em>Spot With Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpotWithOccurrences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPOT_WITH_OCCURRENCES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSpotWithOccurrences() <em>Spot With Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpotWithOccurrences()
	 * @generated
	 * @ordered
	 */
	protected boolean spotWithOccurrences = SPOT_WITH_OCCURRENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isFilteringEnabled() <em>Filtering Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilteringEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILTERING_ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isFilteringEnabled() <em>Filtering Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilteringEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean filteringEnabled = FILTERING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isExportCasToXmiEnabled() <em>Export Cas To Xmi Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportCasToXmiEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORT_CAS_TO_XMI_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExportCasToXmiEnabled() <em>Export Cas To Xmi Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportCasToXmiEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean exportCasToXmiEnabled = EXPORT_CAS_TO_XMI_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isExportCasToTsvEnabled() <em>Export Cas To Tsv Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportCasToTsvEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORT_CAS_TO_TSV_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExportCasToTsvEnabled() <em>Export Cas To Tsv Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportCasToTsvEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean exportCasToTsvEnabled = EXPORT_CAS_TO_TSV_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isExportCasToJsonEnabled() <em>Export Cas To Json Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportCasToJsonEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORT_CAS_TO_JSON_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExportCasToJsonEnabled() <em>Export Cas To Json Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportCasToJsonEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean exportCasToJsonEnabled = EXPORT_CAS_TO_JSON_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isExportTerminoToJsonEnabled() <em>Export Termino To Json Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportTerminoToJsonEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORT_TERMINO_TO_JSON_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExportTerminoToJsonEnabled() <em>Export Termino To Json Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportTerminoToJsonEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean exportTerminoToJsonEnabled = EXPORT_TERMINO_TO_JSON_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isExportTerminoToTbxEnabled() <em>Export Termino To Tbx Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportTerminoToTbxEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORT_TERMINO_TO_TBX_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExportTerminoToTbxEnabled() <em>Export Termino To Tbx Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportTerminoToTbxEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean exportTerminoToTbxEnabled = EXPORT_TERMINO_TO_TBX_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isExportTerminoToTsvEnabled() <em>Export Termino To Tsv Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportTerminoToTsvEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORT_TERMINO_TO_TSV_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExportTerminoToTsvEnabled() <em>Export Termino To Tsv Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExportTerminoToTsvEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean exportTerminoToTsvEnabled = EXPORT_TERMINO_TO_TSV_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isBigCorporaHandlingEnabled() <em>Big Corpora Handling Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBigCorporaHandlingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BIG_CORPORA_HANDLING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBigCorporaHandlingEnabled() <em>Big Corpora Handling Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBigCorporaHandlingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean bigCorporaHandlingEnabled = BIG_CORPORA_HANDLING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigCorporaCleaningMode() <em>Big Corpora Cleaning Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaCleaningMode()
	 * @generated
	 * @ordered
	 */
	protected static final EPeriodicCleaningMode BIG_CORPORA_CLEANING_MODE_EDEFAULT = EPeriodicCleaningMode.MAX_NUMBER_OF_TERMS;

	/**
	 * The cached value of the '{@link #getBigCorporaCleaningMode() <em>Big Corpora Cleaning Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaCleaningMode()
	 * @generated
	 * @ordered
	 */
	protected EPeriodicCleaningMode bigCorporaCleaningMode = BIG_CORPORA_CLEANING_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextScope() <em>Context Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextScope()
	 * @generated
	 * @ordered
	 */
	protected static final int CONTEXT_SCOPE_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getContextScope() <em>Context Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextScope()
	 * @generated
	 * @ordered
	 */
	protected int contextScope = CONTEXT_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isContextualizeOnSWTOnly() <em>Contextualize On SWT Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextualizeOnSWTOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTEXTUALIZE_ON_SWT_ONLY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isContextualizeOnSWTOnly() <em>Contextualize On SWT Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextualizeOnSWTOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean contextualizeOnSWTOnly = CONTEXTUALIZE_ON_SWT_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #isContextAllowMWTAsCooc() <em>Context Allow MWT As Cooc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextAllowMWTAsCooc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTEXT_ALLOW_MWT_AS_COOC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContextAllowMWTAsCooc() <em>Context Allow MWT As Cooc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextAllowMWTAsCooc()
	 * @generated
	 * @ordered
	 */
	protected boolean contextAllowMWTAsCooc = CONTEXT_ALLOW_MWT_AS_COOC_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilteringMode() <em>Filtering Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringMode()
	 * @generated
	 * @ordered
	 */
	protected static final EFilteringMode FILTERING_MODE_EDEFAULT = EFilteringMode.THRESHOLD;

	/**
	 * The cached value of the '{@link #getFilteringMode() <em>Filtering Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringMode()
	 * @generated
	 * @ordered
	 */
	protected EFilteringMode filteringMode = FILTERING_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilteringThreshold() <em>Filtering Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final double FILTERING_THRESHOLD_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getFilteringThreshold() <em>Filtering Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringThreshold()
	 * @generated
	 * @ordered
	 */
	protected double filteringThreshold = FILTERING_THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilteringTopN() <em>Filtering Top N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringTopN()
	 * @generated
	 * @ordered
	 */
	protected static final int FILTERING_TOP_N_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getFilteringTopN() <em>Filtering Top N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringTopN()
	 * @generated
	 * @ordered
	 */
	protected int filteringTopN = FILTERING_TOP_N_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilteringProperty() <em>Filtering Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTERING_PROPERTY_EDEFAULT = "1";

	/**
	 * The cached value of the '{@link #getFilteringProperty() <em>Filtering Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteringProperty()
	 * @generated
	 * @ordered
	 */
	protected String filteringProperty = FILTERING_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigCorporaFilteringProperty() <em>Big Corpora Filtering Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaFilteringProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String BIG_CORPORA_FILTERING_PROPERTY_EDEFAULT = "1";

	/**
	 * The cached value of the '{@link #getBigCorporaFilteringProperty() <em>Big Corpora Filtering Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaFilteringProperty()
	 * @generated
	 * @ordered
	 */
	protected String bigCorporaFilteringProperty = BIG_CORPORA_FILTERING_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigCorporaDocumentPeriod() <em>Big Corpora Document Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaDocumentPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final int BIG_CORPORA_DOCUMENT_PERIOD_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getBigCorporaDocumentPeriod() <em>Big Corpora Document Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaDocumentPeriod()
	 * @generated
	 * @ordered
	 */
	protected int bigCorporaDocumentPeriod = BIG_CORPORA_DOCUMENT_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigCorporaFilteringPropertyThreshold() <em>Big Corpora Filtering Property Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaFilteringPropertyThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final double BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getBigCorporaFilteringPropertyThreshold() <em>Big Corpora Filtering Property Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaFilteringPropertyThreshold()
	 * @generated
	 * @ordered
	 */
	protected double bigCorporaFilteringPropertyThreshold = BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigCorporaMaxNumberOfTerms() <em>Big Corpora Max Number Of Terms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaMaxNumberOfTerms()
	 * @generated
	 * @ordered
	 */
	protected static final int BIG_CORPORA_MAX_NUMBER_OF_TERMS_EDEFAULT = 100000;

	/**
	 * The cached value of the '{@link #getBigCorporaMaxNumberOfTerms() <em>Big Corpora Max Number Of Terms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigCorporaMaxNumberOfTerms()
	 * @generated
	 * @ordered
	 */
	protected int bigCorporaMaxNumberOfTerms = BIG_CORPORA_MAX_NUMBER_OF_TERMS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetTerminologyName() <em>Target Terminology Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTerminologyName()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TERMINOLOGY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetTerminologyName() <em>Target Terminology Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTerminologyName()
	 * @generated
	 * @ordered
	 */
	protected String targetTerminologyName = TARGET_TERMINOLOGY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputDir() <em>Output Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDir()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_DIR_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOutputDir() <em>Output Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDir()
	 * @generated
	 * @ordered
	 */
	protected String outputDir = OUTPUT_DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected String filename = FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaggerConfigName() <em>Tagger Config Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaggerConfigName()
	 * @generated
	 * @ordered
	 */
	protected static final String TAGGER_CONFIG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaggerConfigName() <em>Tagger Config Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaggerConfigName()
	 * @generated
	 * @ordered
	 */
	protected String taggerConfigName = TAGGER_CONFIG_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPipelineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.EPIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMorphosyntacticAnalysisEnabled() {
		return morphosyntacticAnalysisEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMorphosyntacticAnalysisEnabled(boolean newMorphosyntacticAnalysisEnabled) {
		boolean oldMorphosyntacticAnalysisEnabled = morphosyntacticAnalysisEnabled;
		morphosyntacticAnalysisEnabled = newMorphosyntacticAnalysisEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED, oldMorphosyntacticAnalysisEnabled, morphosyntacticAnalysisEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSyntacticVariationEnabled() {
		return syntacticVariationEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntacticVariationEnabled(boolean newSyntacticVariationEnabled) {
		boolean oldSyntacticVariationEnabled = syntacticVariationEnabled;
		syntacticVariationEnabled = newSyntacticVariationEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__SYNTACTIC_VARIATION_ENABLED, oldSyntacticVariationEnabled, syntacticVariationEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGraphicalVariationAnalysisEnabled() {
		return graphicalVariationAnalysisEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphicalVariationAnalysisEnabled(boolean newGraphicalVariationAnalysisEnabled) {
		boolean oldGraphicalVariationAnalysisEnabled = graphicalVariationAnalysisEnabled;
		graphicalVariationAnalysisEnabled = newGraphicalVariationAnalysisEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED, oldGraphicalVariationAnalysisEnabled, graphicalVariationAnalysisEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContextualizerEnabled() {
		return contextualizerEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextualizerEnabled(boolean newContextualizerEnabled) {
		boolean oldContextualizerEnabled = contextualizerEnabled;
		contextualizerEnabled = newContextualizerEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED, oldContextualizerEnabled, contextualizerEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGraphicalSimilarityThreshhold() {
		return graphicalSimilarityThreshhold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphicalSimilarityThreshhold(double newGraphicalSimilarityThreshhold) {
		double oldGraphicalSimilarityThreshhold = graphicalSimilarityThreshhold;
		graphicalSimilarityThreshhold = newGraphicalSimilarityThreshhold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD, oldGraphicalSimilarityThreshhold, graphicalSimilarityThreshhold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCompostMaxComponentSize() {
		return compostMaxComponentSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostMaxComponentSize(int newCompostMaxComponentSize) {
		int oldCompostMaxComponentSize = compostMaxComponentSize;
		compostMaxComponentSize = newCompostMaxComponentSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_MAX_COMPONENT_SIZE, oldCompostMaxComponentSize, compostMaxComponentSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCompostMinComponentNum() {
		return compostMinComponentNum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostMinComponentNum(int newCompostMinComponentNum) {
		int oldCompostMinComponentNum = compostMinComponentNum;
		compostMinComponentNum = newCompostMinComponentNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_MIN_COMPONENT_NUM, oldCompostMinComponentNum, compostMinComponentNum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompostScoreThreshhold() {
		return compostScoreThreshhold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostScoreThreshhold(double newCompostScoreThreshhold) {
		double oldCompostScoreThreshhold = compostScoreThreshhold;
		compostScoreThreshhold = newCompostScoreThreshhold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_SCORE_THRESHHOLD, oldCompostScoreThreshhold, compostScoreThreshhold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompostSegmentSimilarityThreshhold() {
		return compostSegmentSimilarityThreshhold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostSegmentSimilarityThreshhold(double newCompostSegmentSimilarityThreshhold) {
		double oldCompostSegmentSimilarityThreshhold = compostSegmentSimilarityThreshhold;
		compostSegmentSimilarityThreshhold = newCompostSegmentSimilarityThreshhold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_SEGMENT_SIMILARITY_THRESHHOLD, oldCompostSegmentSimilarityThreshhold, compostSegmentSimilarityThreshhold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompostUseLanguageDefaultCoeffs() {
		return compostUseLanguageDefaultCoeffs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostUseLanguageDefaultCoeffs(boolean newCompostUseLanguageDefaultCoeffs) {
		boolean oldCompostUseLanguageDefaultCoeffs = compostUseLanguageDefaultCoeffs;
		compostUseLanguageDefaultCoeffs = newCompostUseLanguageDefaultCoeffs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_USE_LANGUAGE_DEFAULT_COEFFS, oldCompostUseLanguageDefaultCoeffs, compostUseLanguageDefaultCoeffs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompostAlpha() {
		return compostAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostAlpha(double newCompostAlpha) {
		double oldCompostAlpha = compostAlpha;
		compostAlpha = newCompostAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_ALPHA, oldCompostAlpha, compostAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompostBeta() {
		return compostBeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostBeta(double newCompostBeta) {
		double oldCompostBeta = compostBeta;
		compostBeta = newCompostBeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_BETA, oldCompostBeta, compostBeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompostGamma() {
		return compostGamma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostGamma(double newCompostGamma) {
		double oldCompostGamma = compostGamma;
		compostGamma = newCompostGamma;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_GAMMA, oldCompostGamma, compostGamma));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompostDelta() {
		return compostDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompostDelta(double newCompostDelta) {
		double oldCompostDelta = compostDelta;
		compostDelta = newCompostDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__COMPOST_DELTA, oldCompostDelta, compostDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSpotWithOccurrences() {
		return spotWithOccurrences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpotWithOccurrences(boolean newSpotWithOccurrences) {
		boolean oldSpotWithOccurrences = spotWithOccurrences;
		spotWithOccurrences = newSpotWithOccurrences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__SPOT_WITH_OCCURRENCES, oldSpotWithOccurrences, spotWithOccurrences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilteringEnabled() {
		return filteringEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilteringEnabled(boolean newFilteringEnabled) {
		boolean oldFilteringEnabled = filteringEnabled;
		filteringEnabled = newFilteringEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__FILTERING_ENABLED, oldFilteringEnabled, filteringEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExportCasToXmiEnabled() {
		return exportCasToXmiEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportCasToXmiEnabled(boolean newExportCasToXmiEnabled) {
		boolean oldExportCasToXmiEnabled = exportCasToXmiEnabled;
		exportCasToXmiEnabled = newExportCasToXmiEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED, oldExportCasToXmiEnabled, exportCasToXmiEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExportCasToTsvEnabled() {
		return exportCasToTsvEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportCasToTsvEnabled(boolean newExportCasToTsvEnabled) {
		boolean oldExportCasToTsvEnabled = exportCasToTsvEnabled;
		exportCasToTsvEnabled = newExportCasToTsvEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED, oldExportCasToTsvEnabled, exportCasToTsvEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExportCasToJsonEnabled() {
		return exportCasToJsonEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportCasToJsonEnabled(boolean newExportCasToJsonEnabled) {
		boolean oldExportCasToJsonEnabled = exportCasToJsonEnabled;
		exportCasToJsonEnabled = newExportCasToJsonEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED, oldExportCasToJsonEnabled, exportCasToJsonEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExportTerminoToJsonEnabled() {
		return exportTerminoToJsonEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportTerminoToJsonEnabled(boolean newExportTerminoToJsonEnabled) {
		boolean oldExportTerminoToJsonEnabled = exportTerminoToJsonEnabled;
		exportTerminoToJsonEnabled = newExportTerminoToJsonEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_JSON_ENABLED, oldExportTerminoToJsonEnabled, exportTerminoToJsonEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExportTerminoToTbxEnabled() {
		return exportTerminoToTbxEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportTerminoToTbxEnabled(boolean newExportTerminoToTbxEnabled) {
		boolean oldExportTerminoToTbxEnabled = exportTerminoToTbxEnabled;
		exportTerminoToTbxEnabled = newExportTerminoToTbxEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED, oldExportTerminoToTbxEnabled, exportTerminoToTbxEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExportTerminoToTsvEnabled() {
		return exportTerminoToTsvEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportTerminoToTsvEnabled(boolean newExportTerminoToTsvEnabled) {
		boolean oldExportTerminoToTsvEnabled = exportTerminoToTsvEnabled;
		exportTerminoToTsvEnabled = newExportTerminoToTsvEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED, oldExportTerminoToTsvEnabled, exportTerminoToTsvEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBigCorporaHandlingEnabled() {
		return bigCorporaHandlingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigCorporaHandlingEnabled(boolean newBigCorporaHandlingEnabled) {
		boolean oldBigCorporaHandlingEnabled = bigCorporaHandlingEnabled;
		bigCorporaHandlingEnabled = newBigCorporaHandlingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_HANDLING_ENABLED, oldBigCorporaHandlingEnabled, bigCorporaHandlingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPeriodicCleaningMode getBigCorporaCleaningMode() {
		return bigCorporaCleaningMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigCorporaCleaningMode(EPeriodicCleaningMode newBigCorporaCleaningMode) {
		EPeriodicCleaningMode oldBigCorporaCleaningMode = bigCorporaCleaningMode;
		bigCorporaCleaningMode = newBigCorporaCleaningMode == null ? BIG_CORPORA_CLEANING_MODE_EDEFAULT : newBigCorporaCleaningMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_CLEANING_MODE, oldBigCorporaCleaningMode, bigCorporaCleaningMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getContextScope() {
		return contextScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextScope(int newContextScope) {
		int oldContextScope = contextScope;
		contextScope = newContextScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE, oldContextScope, contextScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContextualizeOnSWTOnly() {
		return contextualizeOnSWTOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextualizeOnSWTOnly(boolean newContextualizeOnSWTOnly) {
		boolean oldContextualizeOnSWTOnly = contextualizeOnSWTOnly;
		contextualizeOnSWTOnly = newContextualizeOnSWTOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY, oldContextualizeOnSWTOnly, contextualizeOnSWTOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContextAllowMWTAsCooc() {
		return contextAllowMWTAsCooc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextAllowMWTAsCooc(boolean newContextAllowMWTAsCooc) {
		boolean oldContextAllowMWTAsCooc = contextAllowMWTAsCooc;
		contextAllowMWTAsCooc = newContextAllowMWTAsCooc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC, oldContextAllowMWTAsCooc, contextAllowMWTAsCooc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFilteringMode getFilteringMode() {
		return filteringMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilteringMode(EFilteringMode newFilteringMode) {
		EFilteringMode oldFilteringMode = filteringMode;
		filteringMode = newFilteringMode == null ? FILTERING_MODE_EDEFAULT : newFilteringMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__FILTERING_MODE, oldFilteringMode, filteringMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFilteringThreshold() {
		return filteringThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilteringThreshold(double newFilteringThreshold) {
		double oldFilteringThreshold = filteringThreshold;
		filteringThreshold = newFilteringThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__FILTERING_THRESHOLD, oldFilteringThreshold, filteringThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFilteringTopN() {
		return filteringTopN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilteringTopN(int newFilteringTopN) {
		int oldFilteringTopN = filteringTopN;
		filteringTopN = newFilteringTopN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__FILTERING_TOP_N, oldFilteringTopN, filteringTopN));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilteringProperty() {
		return filteringProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilteringProperty(String newFilteringProperty) {
		String oldFilteringProperty = filteringProperty;
		filteringProperty = newFilteringProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__FILTERING_PROPERTY, oldFilteringProperty, filteringProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBigCorporaFilteringProperty() {
		return bigCorporaFilteringProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigCorporaFilteringProperty(String newBigCorporaFilteringProperty) {
		String oldBigCorporaFilteringProperty = bigCorporaFilteringProperty;
		bigCorporaFilteringProperty = newBigCorporaFilteringProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY, oldBigCorporaFilteringProperty, bigCorporaFilteringProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBigCorporaDocumentPeriod() {
		return bigCorporaDocumentPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigCorporaDocumentPeriod(int newBigCorporaDocumentPeriod) {
		int oldBigCorporaDocumentPeriod = bigCorporaDocumentPeriod;
		bigCorporaDocumentPeriod = newBigCorporaDocumentPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD, oldBigCorporaDocumentPeriod, bigCorporaDocumentPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBigCorporaFilteringPropertyThreshold() {
		return bigCorporaFilteringPropertyThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigCorporaFilteringPropertyThreshold(double newBigCorporaFilteringPropertyThreshold) {
		double oldBigCorporaFilteringPropertyThreshold = bigCorporaFilteringPropertyThreshold;
		bigCorporaFilteringPropertyThreshold = newBigCorporaFilteringPropertyThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD, oldBigCorporaFilteringPropertyThreshold, bigCorporaFilteringPropertyThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBigCorporaMaxNumberOfTerms() {
		return bigCorporaMaxNumberOfTerms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigCorporaMaxNumberOfTerms(int newBigCorporaMaxNumberOfTerms) {
		int oldBigCorporaMaxNumberOfTerms = bigCorporaMaxNumberOfTerms;
		bigCorporaMaxNumberOfTerms = newBigCorporaMaxNumberOfTerms;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS, oldBigCorporaMaxNumberOfTerms, bigCorporaMaxNumberOfTerms));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetTerminologyName() {
		return targetTerminologyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTerminologyName(String newTargetTerminologyName) {
		String oldTargetTerminologyName = targetTerminologyName;
		targetTerminologyName = newTargetTerminologyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__TARGET_TERMINOLOGY_NAME, oldTargetTerminologyName, targetTerminologyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputDir() {
		return outputDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputDir(String newOutputDir) {
		String oldOutputDir = outputDir;
		outputDir = newOutputDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__OUTPUT_DIR, oldOutputDir, outputDir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilename(String newFilename) {
		String oldFilename = filename;
		filename = newFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTaggerConfigName() {
		return taggerConfigName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaggerConfigName(String newTaggerConfigName) {
		String oldTaggerConfigName = taggerConfigName;
		taggerConfigName = newTaggerConfigName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME, oldTaggerConfigName, taggerConfigName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED:
				return isMorphosyntacticAnalysisEnabled();
			case TermsuiteuiPackage.EPIPELINE__SYNTACTIC_VARIATION_ENABLED:
				return isSyntacticVariationEnabled();
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED:
				return isGraphicalVariationAnalysisEnabled();
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				return isContextualizerEnabled();
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD:
				return getGraphicalSimilarityThreshhold();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MAX_COMPONENT_SIZE:
				return getCompostMaxComponentSize();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MIN_COMPONENT_NUM:
				return getCompostMinComponentNum();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SCORE_THRESHHOLD:
				return getCompostScoreThreshhold();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SEGMENT_SIMILARITY_THRESHHOLD:
				return getCompostSegmentSimilarityThreshhold();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_USE_LANGUAGE_DEFAULT_COEFFS:
				return isCompostUseLanguageDefaultCoeffs();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_ALPHA:
				return getCompostAlpha();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_BETA:
				return getCompostBeta();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_GAMMA:
				return getCompostGamma();
			case TermsuiteuiPackage.EPIPELINE__COMPOST_DELTA:
				return getCompostDelta();
			case TermsuiteuiPackage.EPIPELINE__SPOT_WITH_OCCURRENCES:
				return isSpotWithOccurrences();
			case TermsuiteuiPackage.EPIPELINE__FILTERING_ENABLED:
				return isFilteringEnabled();
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED:
				return isExportCasToXmiEnabled();
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED:
				return isExportCasToTsvEnabled();
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED:
				return isExportCasToJsonEnabled();
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_JSON_ENABLED:
				return isExportTerminoToJsonEnabled();
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED:
				return isExportTerminoToTbxEnabled();
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED:
				return isExportTerminoToTsvEnabled();
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_HANDLING_ENABLED:
				return isBigCorporaHandlingEnabled();
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_CLEANING_MODE:
				return getBigCorporaCleaningMode();
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				return getContextScope();
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY:
				return isContextualizeOnSWTOnly();
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC:
				return isContextAllowMWTAsCooc();
			case TermsuiteuiPackage.EPIPELINE__FILTERING_MODE:
				return getFilteringMode();
			case TermsuiteuiPackage.EPIPELINE__FILTERING_THRESHOLD:
				return getFilteringThreshold();
			case TermsuiteuiPackage.EPIPELINE__FILTERING_TOP_N:
				return getFilteringTopN();
			case TermsuiteuiPackage.EPIPELINE__FILTERING_PROPERTY:
				return getFilteringProperty();
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY:
				return getBigCorporaFilteringProperty();
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD:
				return getBigCorporaDocumentPeriod();
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD:
				return getBigCorporaFilteringPropertyThreshold();
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS:
				return getBigCorporaMaxNumberOfTerms();
			case TermsuiteuiPackage.EPIPELINE__TARGET_TERMINOLOGY_NAME:
				return getTargetTerminologyName();
			case TermsuiteuiPackage.EPIPELINE__OUTPUT_DIR:
				return getOutputDir();
			case TermsuiteuiPackage.EPIPELINE__FILENAME:
				return getFilename();
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				return getTaggerConfigName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TermsuiteuiPackage.EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED:
				setMorphosyntacticAnalysisEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__SYNTACTIC_VARIATION_ENABLED:
				setSyntacticVariationEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED:
				setGraphicalVariationAnalysisEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				setContextualizerEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD:
				setGraphicalSimilarityThreshhold((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MAX_COMPONENT_SIZE:
				setCompostMaxComponentSize((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MIN_COMPONENT_NUM:
				setCompostMinComponentNum((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SCORE_THRESHHOLD:
				setCompostScoreThreshhold((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SEGMENT_SIMILARITY_THRESHHOLD:
				setCompostSegmentSimilarityThreshhold((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_USE_LANGUAGE_DEFAULT_COEFFS:
				setCompostUseLanguageDefaultCoeffs((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_ALPHA:
				setCompostAlpha((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_BETA:
				setCompostBeta((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_GAMMA:
				setCompostGamma((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_DELTA:
				setCompostDelta((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__SPOT_WITH_OCCURRENCES:
				setSpotWithOccurrences((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_ENABLED:
				setFilteringEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED:
				setExportCasToXmiEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED:
				setExportCasToTsvEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED:
				setExportCasToJsonEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_JSON_ENABLED:
				setExportTerminoToJsonEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED:
				setExportTerminoToTbxEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED:
				setExportTerminoToTsvEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_HANDLING_ENABLED:
				setBigCorporaHandlingEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_CLEANING_MODE:
				setBigCorporaCleaningMode((EPeriodicCleaningMode)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				setContextScope((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY:
				setContextualizeOnSWTOnly((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC:
				setContextAllowMWTAsCooc((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_MODE:
				setFilteringMode((EFilteringMode)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_THRESHOLD:
				setFilteringThreshold((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_TOP_N:
				setFilteringTopN((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_PROPERTY:
				setFilteringProperty((String)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY:
				setBigCorporaFilteringProperty((String)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD:
				setBigCorporaDocumentPeriod((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD:
				setBigCorporaFilteringPropertyThreshold((Double)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS:
				setBigCorporaMaxNumberOfTerms((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__TARGET_TERMINOLOGY_NAME:
				setTargetTerminologyName((String)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__OUTPUT_DIR:
				setOutputDir((String)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILENAME:
				setFilename((String)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				setTaggerConfigName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TermsuiteuiPackage.EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED:
				setMorphosyntacticAnalysisEnabled(MORPHOSYNTACTIC_ANALYSIS_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__SYNTACTIC_VARIATION_ENABLED:
				setSyntacticVariationEnabled(SYNTACTIC_VARIATION_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED:
				setGraphicalVariationAnalysisEnabled(GRAPHICAL_VARIATION_ANALYSIS_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				setContextualizerEnabled(CONTEXTUALIZER_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD:
				setGraphicalSimilarityThreshhold(GRAPHICAL_SIMILARITY_THRESHHOLD_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MAX_COMPONENT_SIZE:
				setCompostMaxComponentSize(COMPOST_MAX_COMPONENT_SIZE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MIN_COMPONENT_NUM:
				setCompostMinComponentNum(COMPOST_MIN_COMPONENT_NUM_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SCORE_THRESHHOLD:
				setCompostScoreThreshhold(COMPOST_SCORE_THRESHHOLD_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SEGMENT_SIMILARITY_THRESHHOLD:
				setCompostSegmentSimilarityThreshhold(COMPOST_SEGMENT_SIMILARITY_THRESHHOLD_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_USE_LANGUAGE_DEFAULT_COEFFS:
				setCompostUseLanguageDefaultCoeffs(COMPOST_USE_LANGUAGE_DEFAULT_COEFFS_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_ALPHA:
				setCompostAlpha(COMPOST_ALPHA_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_BETA:
				setCompostBeta(COMPOST_BETA_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_GAMMA:
				setCompostGamma(COMPOST_GAMMA_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_DELTA:
				setCompostDelta(COMPOST_DELTA_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__SPOT_WITH_OCCURRENCES:
				setSpotWithOccurrences(SPOT_WITH_OCCURRENCES_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_ENABLED:
				setFilteringEnabled(FILTERING_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED:
				setExportCasToXmiEnabled(EXPORT_CAS_TO_XMI_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED:
				setExportCasToTsvEnabled(EXPORT_CAS_TO_TSV_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED:
				setExportCasToJsonEnabled(EXPORT_CAS_TO_JSON_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_JSON_ENABLED:
				setExportTerminoToJsonEnabled(EXPORT_TERMINO_TO_JSON_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED:
				setExportTerminoToTbxEnabled(EXPORT_TERMINO_TO_TBX_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED:
				setExportTerminoToTsvEnabled(EXPORT_TERMINO_TO_TSV_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_HANDLING_ENABLED:
				setBigCorporaHandlingEnabled(BIG_CORPORA_HANDLING_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_CLEANING_MODE:
				setBigCorporaCleaningMode(BIG_CORPORA_CLEANING_MODE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				setContextScope(CONTEXT_SCOPE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY:
				setContextualizeOnSWTOnly(CONTEXTUALIZE_ON_SWT_ONLY_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC:
				setContextAllowMWTAsCooc(CONTEXT_ALLOW_MWT_AS_COOC_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_MODE:
				setFilteringMode(FILTERING_MODE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_THRESHOLD:
				setFilteringThreshold(FILTERING_THRESHOLD_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_TOP_N:
				setFilteringTopN(FILTERING_TOP_N_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_PROPERTY:
				setFilteringProperty(FILTERING_PROPERTY_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY:
				setBigCorporaFilteringProperty(BIG_CORPORA_FILTERING_PROPERTY_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD:
				setBigCorporaDocumentPeriod(BIG_CORPORA_DOCUMENT_PERIOD_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD:
				setBigCorporaFilteringPropertyThreshold(BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS:
				setBigCorporaMaxNumberOfTerms(BIG_CORPORA_MAX_NUMBER_OF_TERMS_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__TARGET_TERMINOLOGY_NAME:
				setTargetTerminologyName(TARGET_TERMINOLOGY_NAME_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__OUTPUT_DIR:
				setOutputDir(OUTPUT_DIR_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILENAME:
				setFilename(FILENAME_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				setTaggerConfigName(TAGGER_CONFIG_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TermsuiteuiPackage.EPIPELINE__MORPHOSYNTACTIC_ANALYSIS_ENABLED:
				return morphosyntacticAnalysisEnabled != MORPHOSYNTACTIC_ANALYSIS_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__SYNTACTIC_VARIATION_ENABLED:
				return syntacticVariationEnabled != SYNTACTIC_VARIATION_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_VARIATION_ANALYSIS_ENABLED:
				return graphicalVariationAnalysisEnabled != GRAPHICAL_VARIATION_ANALYSIS_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				return contextualizerEnabled != CONTEXTUALIZER_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__GRAPHICAL_SIMILARITY_THRESHHOLD:
				return graphicalSimilarityThreshhold != GRAPHICAL_SIMILARITY_THRESHHOLD_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MAX_COMPONENT_SIZE:
				return compostMaxComponentSize != COMPOST_MAX_COMPONENT_SIZE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_MIN_COMPONENT_NUM:
				return compostMinComponentNum != COMPOST_MIN_COMPONENT_NUM_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SCORE_THRESHHOLD:
				return compostScoreThreshhold != COMPOST_SCORE_THRESHHOLD_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_SEGMENT_SIMILARITY_THRESHHOLD:
				return compostSegmentSimilarityThreshhold != COMPOST_SEGMENT_SIMILARITY_THRESHHOLD_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_USE_LANGUAGE_DEFAULT_COEFFS:
				return compostUseLanguageDefaultCoeffs != COMPOST_USE_LANGUAGE_DEFAULT_COEFFS_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_ALPHA:
				return compostAlpha != COMPOST_ALPHA_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_BETA:
				return compostBeta != COMPOST_BETA_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_GAMMA:
				return compostGamma != COMPOST_GAMMA_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__COMPOST_DELTA:
				return compostDelta != COMPOST_DELTA_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__SPOT_WITH_OCCURRENCES:
				return spotWithOccurrences != SPOT_WITH_OCCURRENCES_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_ENABLED:
				return filteringEnabled != FILTERING_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_XMI_ENABLED:
				return exportCasToXmiEnabled != EXPORT_CAS_TO_XMI_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_TSV_ENABLED:
				return exportCasToTsvEnabled != EXPORT_CAS_TO_TSV_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_CAS_TO_JSON_ENABLED:
				return exportCasToJsonEnabled != EXPORT_CAS_TO_JSON_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_JSON_ENABLED:
				return exportTerminoToJsonEnabled != EXPORT_TERMINO_TO_JSON_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TBX_ENABLED:
				return exportTerminoToTbxEnabled != EXPORT_TERMINO_TO_TBX_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__EXPORT_TERMINO_TO_TSV_ENABLED:
				return exportTerminoToTsvEnabled != EXPORT_TERMINO_TO_TSV_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_HANDLING_ENABLED:
				return bigCorporaHandlingEnabled != BIG_CORPORA_HANDLING_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_CLEANING_MODE:
				return bigCorporaCleaningMode != BIG_CORPORA_CLEANING_MODE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				return contextScope != CONTEXT_SCOPE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZE_ON_SWT_ONLY:
				return contextualizeOnSWTOnly != CONTEXTUALIZE_ON_SWT_ONLY_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ALLOW_MWT_AS_COOC:
				return contextAllowMWTAsCooc != CONTEXT_ALLOW_MWT_AS_COOC_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_MODE:
				return filteringMode != FILTERING_MODE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_THRESHOLD:
				return filteringThreshold != FILTERING_THRESHOLD_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_TOP_N:
				return filteringTopN != FILTERING_TOP_N_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__FILTERING_PROPERTY:
				return FILTERING_PROPERTY_EDEFAULT == null ? filteringProperty != null : !FILTERING_PROPERTY_EDEFAULT.equals(filteringProperty);
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY:
				return BIG_CORPORA_FILTERING_PROPERTY_EDEFAULT == null ? bigCorporaFilteringProperty != null : !BIG_CORPORA_FILTERING_PROPERTY_EDEFAULT.equals(bigCorporaFilteringProperty);
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_DOCUMENT_PERIOD:
				return bigCorporaDocumentPeriod != BIG_CORPORA_DOCUMENT_PERIOD_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD:
				return bigCorporaFilteringPropertyThreshold != BIG_CORPORA_FILTERING_PROPERTY_THRESHOLD_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__BIG_CORPORA_MAX_NUMBER_OF_TERMS:
				return bigCorporaMaxNumberOfTerms != BIG_CORPORA_MAX_NUMBER_OF_TERMS_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__TARGET_TERMINOLOGY_NAME:
				return TARGET_TERMINOLOGY_NAME_EDEFAULT == null ? targetTerminologyName != null : !TARGET_TERMINOLOGY_NAME_EDEFAULT.equals(targetTerminologyName);
			case TermsuiteuiPackage.EPIPELINE__OUTPUT_DIR:
				return OUTPUT_DIR_EDEFAULT == null ? outputDir != null : !OUTPUT_DIR_EDEFAULT.equals(outputDir);
			case TermsuiteuiPackage.EPIPELINE__FILENAME:
				return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				return TAGGER_CONFIG_NAME_EDEFAULT == null ? taggerConfigName != null : !TAGGER_CONFIG_NAME_EDEFAULT.equals(taggerConfigName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (morphosyntacticAnalysisEnabled: ");
		result.append(morphosyntacticAnalysisEnabled);
		result.append(", syntacticVariationEnabled: ");
		result.append(syntacticVariationEnabled);
		result.append(", graphicalVariationAnalysisEnabled: ");
		result.append(graphicalVariationAnalysisEnabled);
		result.append(", contextualizerEnabled: ");
		result.append(contextualizerEnabled);
		result.append(", graphicalSimilarityThreshhold: ");
		result.append(graphicalSimilarityThreshhold);
		result.append(", compostMaxComponentSize: ");
		result.append(compostMaxComponentSize);
		result.append(", compostMinComponentNum: ");
		result.append(compostMinComponentNum);
		result.append(", compostScoreThreshhold: ");
		result.append(compostScoreThreshhold);
		result.append(", compostSegmentSimilarityThreshhold: ");
		result.append(compostSegmentSimilarityThreshhold);
		result.append(", compostUseLanguageDefaultCoeffs: ");
		result.append(compostUseLanguageDefaultCoeffs);
		result.append(", compostAlpha: ");
		result.append(compostAlpha);
		result.append(", compostBeta: ");
		result.append(compostBeta);
		result.append(", compostGamma: ");
		result.append(compostGamma);
		result.append(", compostDelta: ");
		result.append(compostDelta);
		result.append(", spotWithOccurrences: ");
		result.append(spotWithOccurrences);
		result.append(", filteringEnabled: ");
		result.append(filteringEnabled);
		result.append(", exportCasToXmiEnabled: ");
		result.append(exportCasToXmiEnabled);
		result.append(", exportCasToTsvEnabled: ");
		result.append(exportCasToTsvEnabled);
		result.append(", exportCasToJsonEnabled: ");
		result.append(exportCasToJsonEnabled);
		result.append(", exportTerminoToJsonEnabled: ");
		result.append(exportTerminoToJsonEnabled);
		result.append(", exportTerminoToTbxEnabled: ");
		result.append(exportTerminoToTbxEnabled);
		result.append(", exportTerminoToTsvEnabled: ");
		result.append(exportTerminoToTsvEnabled);
		result.append(", bigCorporaHandlingEnabled: ");
		result.append(bigCorporaHandlingEnabled);
		result.append(", bigCorporaCleaningMode: ");
		result.append(bigCorporaCleaningMode);
		result.append(", contextScope: ");
		result.append(contextScope);
		result.append(", contextualizeOnSWTOnly: ");
		result.append(contextualizeOnSWTOnly);
		result.append(", contextAllowMWTAsCooc: ");
		result.append(contextAllowMWTAsCooc);
		result.append(", filteringMode: ");
		result.append(filteringMode);
		result.append(", filteringThreshold: ");
		result.append(filteringThreshold);
		result.append(", filteringTopN: ");
		result.append(filteringTopN);
		result.append(", filteringProperty: ");
		result.append(filteringProperty);
		result.append(", bigCorporaFilteringProperty: ");
		result.append(bigCorporaFilteringProperty);
		result.append(", bigCorporaDocumentPeriod: ");
		result.append(bigCorporaDocumentPeriod);
		result.append(", bigCorporaFilteringPropertyThreshold: ");
		result.append(bigCorporaFilteringPropertyThreshold);
		result.append(", bigCorporaMaxNumberOfTerms: ");
		result.append(bigCorporaMaxNumberOfTerms);
		result.append(", targetTerminologyName: ");
		result.append(targetTerminologyName);
		result.append(", outputDir: ");
		result.append(outputDir);
		result.append(", filename: ");
		result.append(filename);
		result.append(", taggerConfigName: ");
		result.append(taggerConfigName);
		result.append(')');
		return result.toString();
	}

} //EPipelineImpl
