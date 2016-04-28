/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isMorphosyntacticAnalysisEnabled <em>Morphosyntactic Analysis Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSyntacticVariationEnabled <em>Syntactic Variation Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isGraphicalVariationAnalysisEnabled <em>Graphical Variation Analysis Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizerEnabled <em>Contextualizer Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getGraphicalSimilarityThreshhold <em>Graphical Similarity Threshhold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMaxComponentSize <em>Compost Max Component Size</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMinComponentNum <em>Compost Min Component Num</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostScoreThreshhold <em>Compost Score Threshhold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostSegmentSimilarityThreshhold <em>Compost Segment Similarity Threshhold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isCompostUseLanguageDefaultCoeffs <em>Compost Use Language Default Coeffs</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostAlpha <em>Compost Alpha</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostBeta <em>Compost Beta</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostGamma <em>Compost Gamma</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostDelta <em>Compost Delta</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSpotWithOccurrences <em>Spot With Occurrences</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isFilteringEnabled <em>Filtering Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToXmiEnabled <em>Export Cas To Xmi Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToTsvEnabled <em>Export Cas To Tsv Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToJsonEnabled <em>Export Cas To Json Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToJsonEnabled <em>Export Termino To Json Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTbxEnabled <em>Export Termino To Tbx Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTsvEnabled <em>Export Termino To Tsv Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isBigCorporaHandlingEnabled <em>Big Corpora Handling Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaCleaningMode <em>Big Corpora Cleaning Mode</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextScope <em>Context Scope</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizeOnSWTOnly <em>Contextualize On SWT Only</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextAllowMWTAsCooc <em>Context Allow MWT As Cooc</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringMode <em>Filtering Mode</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringThreshold <em>Filtering Threshold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringTopN <em>Filtering Top N</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringProperty <em>Filtering Property</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringProperty <em>Big Corpora Filtering Property</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaDocumentPeriod <em>Big Corpora Document Period</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringPropertyThreshold <em>Big Corpora Filtering Property Threshold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaMaxNumberOfTerms <em>Big Corpora Max Number Of Terms</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTargetTerminologyName <em>Target Terminology Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOutputDir <em>Output Dir</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilename <em>Filename</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTaggerConfigName <em>Tagger Config Name</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline()
 * @model
 * @generated
 */
public interface EPipeline extends EResource {
	/**
	 * Returns the value of the '<em><b>Morphosyntactic Analysis Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Morphosyntactic Analysis Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Morphosyntactic Analysis Enabled</em>' attribute.
	 * @see #setMorphosyntacticAnalysisEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_MorphosyntacticAnalysisEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isMorphosyntacticAnalysisEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isMorphosyntacticAnalysisEnabled <em>Morphosyntactic Analysis Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Morphosyntactic Analysis Enabled</em>' attribute.
	 * @see #isMorphosyntacticAnalysisEnabled()
	 * @generated
	 */
	void setMorphosyntacticAnalysisEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Syntactic Variation Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntactic Variation Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syntactic Variation Enabled</em>' attribute.
	 * @see #setSyntacticVariationEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_SyntacticVariationEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isSyntacticVariationEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSyntacticVariationEnabled <em>Syntactic Variation Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syntactic Variation Enabled</em>' attribute.
	 * @see #isSyntacticVariationEnabled()
	 * @generated
	 */
	void setSyntacticVariationEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Graphical Variation Analysis Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphical Variation Analysis Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphical Variation Analysis Enabled</em>' attribute.
	 * @see #setGraphicalVariationAnalysisEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_GraphicalVariationAnalysisEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isGraphicalVariationAnalysisEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isGraphicalVariationAnalysisEnabled <em>Graphical Variation Analysis Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphical Variation Analysis Enabled</em>' attribute.
	 * @see #isGraphicalVariationAnalysisEnabled()
	 * @generated
	 */
	void setGraphicalVariationAnalysisEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Contextualizer Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contextualizer Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contextualizer Enabled</em>' attribute.
	 * @see #setContextualizerEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ContextualizerEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isContextualizerEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizerEnabled <em>Contextualizer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contextualizer Enabled</em>' attribute.
	 * @see #isContextualizerEnabled()
	 * @generated
	 */
	void setContextualizerEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Graphical Similarity Threshhold</b></em>' attribute.
	 * The default value is <code>"0.9"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphical Similarity Threshhold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphical Similarity Threshhold</em>' attribute.
	 * @see #setGraphicalSimilarityThreshhold(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_GraphicalSimilarityThreshhold()
	 * @model default="0.9"
	 * @generated
	 */
	double getGraphicalSimilarityThreshhold();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getGraphicalSimilarityThreshhold <em>Graphical Similarity Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphical Similarity Threshhold</em>' attribute.
	 * @see #getGraphicalSimilarityThreshhold()
	 * @generated
	 */
	void setGraphicalSimilarityThreshhold(double value);

	/**
	 * Returns the value of the '<em><b>Compost Max Component Size</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Max Component Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Max Component Size</em>' attribute.
	 * @see #setCompostMaxComponentSize(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostMaxComponentSize()
	 * @model default="3"
	 * @generated
	 */
	int getCompostMaxComponentSize();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMaxComponentSize <em>Compost Max Component Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Max Component Size</em>' attribute.
	 * @see #getCompostMaxComponentSize()
	 * @generated
	 */
	void setCompostMaxComponentSize(int value);

	/**
	 * Returns the value of the '<em><b>Compost Min Component Num</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Min Component Num</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Min Component Num</em>' attribute.
	 * @see #setCompostMinComponentNum(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostMinComponentNum()
	 * @model default="3"
	 * @generated
	 */
	int getCompostMinComponentNum();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostMinComponentNum <em>Compost Min Component Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Min Component Num</em>' attribute.
	 * @see #getCompostMinComponentNum()
	 * @generated
	 */
	void setCompostMinComponentNum(int value);

	/**
	 * Returns the value of the '<em><b>Compost Score Threshhold</b></em>' attribute.
	 * The default value is <code>"0.7"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Score Threshhold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Score Threshhold</em>' attribute.
	 * @see #setCompostScoreThreshhold(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostScoreThreshhold()
	 * @model default="0.7"
	 * @generated
	 */
	double getCompostScoreThreshhold();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostScoreThreshhold <em>Compost Score Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Score Threshhold</em>' attribute.
	 * @see #getCompostScoreThreshhold()
	 * @generated
	 */
	void setCompostScoreThreshhold(double value);

	/**
	 * Returns the value of the '<em><b>Compost Segment Similarity Threshhold</b></em>' attribute.
	 * The default value is <code>"0.7"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Segment Similarity Threshhold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Segment Similarity Threshhold</em>' attribute.
	 * @see #setCompostSegmentSimilarityThreshhold(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostSegmentSimilarityThreshhold()
	 * @model default="0.7"
	 * @generated
	 */
	double getCompostSegmentSimilarityThreshhold();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostSegmentSimilarityThreshhold <em>Compost Segment Similarity Threshhold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Segment Similarity Threshhold</em>' attribute.
	 * @see #getCompostSegmentSimilarityThreshhold()
	 * @generated
	 */
	void setCompostSegmentSimilarityThreshhold(double value);

	/**
	 * Returns the value of the '<em><b>Compost Use Language Default Coeffs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Use Language Default Coeffs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Use Language Default Coeffs</em>' attribute.
	 * @see #setCompostUseLanguageDefaultCoeffs(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostUseLanguageDefaultCoeffs()
	 * @model
	 * @generated
	 */
	boolean isCompostUseLanguageDefaultCoeffs();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isCompostUseLanguageDefaultCoeffs <em>Compost Use Language Default Coeffs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Use Language Default Coeffs</em>' attribute.
	 * @see #isCompostUseLanguageDefaultCoeffs()
	 * @generated
	 */
	void setCompostUseLanguageDefaultCoeffs(boolean value);

	/**
	 * Returns the value of the '<em><b>Compost Alpha</b></em>' attribute.
	 * The default value is <code>"0.5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Alpha</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Alpha</em>' attribute.
	 * @see #setCompostAlpha(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostAlpha()
	 * @model default="0.5"
	 * @generated
	 */
	double getCompostAlpha();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostAlpha <em>Compost Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Alpha</em>' attribute.
	 * @see #getCompostAlpha()
	 * @generated
	 */
	void setCompostAlpha(double value);

	/**
	 * Returns the value of the '<em><b>Compost Beta</b></em>' attribute.
	 * The default value is <code>"0.1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Beta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Beta</em>' attribute.
	 * @see #setCompostBeta(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostBeta()
	 * @model default="0.1"
	 * @generated
	 */
	double getCompostBeta();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostBeta <em>Compost Beta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Beta</em>' attribute.
	 * @see #getCompostBeta()
	 * @generated
	 */
	void setCompostBeta(double value);

	/**
	 * Returns the value of the '<em><b>Compost Gamma</b></em>' attribute.
	 * The default value is <code>"0.1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Gamma</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Gamma</em>' attribute.
	 * @see #setCompostGamma(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostGamma()
	 * @model default="0.1"
	 * @generated
	 */
	double getCompostGamma();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostGamma <em>Compost Gamma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Gamma</em>' attribute.
	 * @see #getCompostGamma()
	 * @generated
	 */
	void setCompostGamma(double value);

	/**
	 * Returns the value of the '<em><b>Compost Delta</b></em>' attribute.
	 * The default value is <code>"0.3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compost Delta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compost Delta</em>' attribute.
	 * @see #setCompostDelta(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_CompostDelta()
	 * @model default="0.3"
	 * @generated
	 */
	double getCompostDelta();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getCompostDelta <em>Compost Delta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compost Delta</em>' attribute.
	 * @see #getCompostDelta()
	 * @generated
	 */
	void setCompostDelta(double value);

	/**
	 * Returns the value of the '<em><b>Spot With Occurrences</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spot With Occurrences</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spot With Occurrences</em>' attribute.
	 * @see #setSpotWithOccurrences(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_SpotWithOccurrences()
	 * @model default="true"
	 * @generated
	 */
	boolean isSpotWithOccurrences();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSpotWithOccurrences <em>Spot With Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spot With Occurrences</em>' attribute.
	 * @see #isSpotWithOccurrences()
	 * @generated
	 */
	void setSpotWithOccurrences(boolean value);

	/**
	 * Returns the value of the '<em><b>Filtering Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtering Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtering Enabled</em>' attribute.
	 * @see #setFilteringEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_FilteringEnabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isFilteringEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isFilteringEnabled <em>Filtering Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filtering Enabled</em>' attribute.
	 * @see #isFilteringEnabled()
	 * @generated
	 */
	void setFilteringEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Export Cas To Xmi Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Cas To Xmi Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Cas To Xmi Enabled</em>' attribute.
	 * @see #setExportCasToXmiEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ExportCasToXmiEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isExportCasToXmiEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToXmiEnabled <em>Export Cas To Xmi Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Cas To Xmi Enabled</em>' attribute.
	 * @see #isExportCasToXmiEnabled()
	 * @generated
	 */
	void setExportCasToXmiEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Export Cas To Tsv Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Cas To Tsv Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Cas To Tsv Enabled</em>' attribute.
	 * @see #setExportCasToTsvEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ExportCasToTsvEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isExportCasToTsvEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToTsvEnabled <em>Export Cas To Tsv Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Cas To Tsv Enabled</em>' attribute.
	 * @see #isExportCasToTsvEnabled()
	 * @generated
	 */
	void setExportCasToTsvEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Export Cas To Json Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Cas To Json Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Cas To Json Enabled</em>' attribute.
	 * @see #setExportCasToJsonEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ExportCasToJsonEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isExportCasToJsonEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportCasToJsonEnabled <em>Export Cas To Json Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Cas To Json Enabled</em>' attribute.
	 * @see #isExportCasToJsonEnabled()
	 * @generated
	 */
	void setExportCasToJsonEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Export Termino To Json Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Termino To Json Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Termino To Json Enabled</em>' attribute.
	 * @see #setExportTerminoToJsonEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ExportTerminoToJsonEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isExportTerminoToJsonEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToJsonEnabled <em>Export Termino To Json Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Termino To Json Enabled</em>' attribute.
	 * @see #isExportTerminoToJsonEnabled()
	 * @generated
	 */
	void setExportTerminoToJsonEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Export Termino To Tbx Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Termino To Tbx Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Termino To Tbx Enabled</em>' attribute.
	 * @see #setExportTerminoToTbxEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ExportTerminoToTbxEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isExportTerminoToTbxEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTbxEnabled <em>Export Termino To Tbx Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Termino To Tbx Enabled</em>' attribute.
	 * @see #isExportTerminoToTbxEnabled()
	 * @generated
	 */
	void setExportTerminoToTbxEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Export Termino To Tsv Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Termino To Tsv Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Termino To Tsv Enabled</em>' attribute.
	 * @see #setExportTerminoToTsvEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ExportTerminoToTsvEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isExportTerminoToTsvEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isExportTerminoToTsvEnabled <em>Export Termino To Tsv Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Termino To Tsv Enabled</em>' attribute.
	 * @see #isExportTerminoToTsvEnabled()
	 * @generated
	 */
	void setExportTerminoToTsvEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Big Corpora Handling Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Corpora Handling Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Big Corpora Handling Enabled</em>' attribute.
	 * @see #setBigCorporaHandlingEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_BigCorporaHandlingEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isBigCorporaHandlingEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isBigCorporaHandlingEnabled <em>Big Corpora Handling Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Big Corpora Handling Enabled</em>' attribute.
	 * @see #isBigCorporaHandlingEnabled()
	 * @generated
	 */
	void setBigCorporaHandlingEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Big Corpora Cleaning Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Corpora Cleaning Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Big Corpora Cleaning Mode</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode
	 * @see #setBigCorporaCleaningMode(EPeriodicCleaningMode)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_BigCorporaCleaningMode()
	 * @model required="true"
	 * @generated
	 */
	EPeriodicCleaningMode getBigCorporaCleaningMode();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaCleaningMode <em>Big Corpora Cleaning Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Big Corpora Cleaning Mode</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPeriodicCleaningMode
	 * @see #getBigCorporaCleaningMode()
	 * @generated
	 */
	void setBigCorporaCleaningMode(EPeriodicCleaningMode value);

	/**
	 * Returns the value of the '<em><b>Context Scope</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Scope</em>' attribute.
	 * @see #setContextScope(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ContextScope()
	 * @model default="3" required="true"
	 * @generated
	 */
	int getContextScope();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextScope <em>Context Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Scope</em>' attribute.
	 * @see #getContextScope()
	 * @generated
	 */
	void setContextScope(int value);

	/**
	 * Returns the value of the '<em><b>Contextualize On SWT Only</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contextualize On SWT Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contextualize On SWT Only</em>' attribute.
	 * @see #setContextualizeOnSWTOnly(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ContextualizeOnSWTOnly()
	 * @model default="true"
	 * @generated
	 */
	boolean isContextualizeOnSWTOnly();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizeOnSWTOnly <em>Contextualize On SWT Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contextualize On SWT Only</em>' attribute.
	 * @see #isContextualizeOnSWTOnly()
	 * @generated
	 */
	void setContextualizeOnSWTOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Context Allow MWT As Cooc</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Allow MWT As Cooc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Allow MWT As Cooc</em>' attribute.
	 * @see #setContextAllowMWTAsCooc(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ContextAllowMWTAsCooc()
	 * @model default="false"
	 * @generated
	 */
	boolean isContextAllowMWTAsCooc();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextAllowMWTAsCooc <em>Context Allow MWT As Cooc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Allow MWT As Cooc</em>' attribute.
	 * @see #isContextAllowMWTAsCooc()
	 * @generated
	 */
	void setContextAllowMWTAsCooc(boolean value);

	/**
	 * Returns the value of the '<em><b>Filtering Mode</b></em>' attribute.
	 * The default value is <code>"Threshold"</code>.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtering Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtering Mode</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode
	 * @see #setFilteringMode(EFilteringMode)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_FilteringMode()
	 * @model default="Threshold"
	 * @generated
	 */
	EFilteringMode getFilteringMode();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringMode <em>Filtering Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filtering Mode</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode
	 * @see #getFilteringMode()
	 * @generated
	 */
	void setFilteringMode(EFilteringMode value);

	/**
	 * Returns the value of the '<em><b>Filtering Threshold</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtering Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtering Threshold</em>' attribute.
	 * @see #setFilteringThreshold(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_FilteringThreshold()
	 * @model default="1"
	 * @generated
	 */
	double getFilteringThreshold();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringThreshold <em>Filtering Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filtering Threshold</em>' attribute.
	 * @see #getFilteringThreshold()
	 * @generated
	 */
	void setFilteringThreshold(double value);

	/**
	 * Returns the value of the '<em><b>Filtering Top N</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtering Top N</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtering Top N</em>' attribute.
	 * @see #setFilteringTopN(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_FilteringTopN()
	 * @model default="100"
	 * @generated
	 */
	int getFilteringTopN();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringTopN <em>Filtering Top N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filtering Top N</em>' attribute.
	 * @see #getFilteringTopN()
	 * @generated
	 */
	void setFilteringTopN(int value);

	/**
	 * Returns the value of the '<em><b>Filtering Property</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtering Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtering Property</em>' attribute.
	 * @see #setFilteringProperty(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_FilteringProperty()
	 * @model default="1"
	 * @generated
	 */
	String getFilteringProperty();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilteringProperty <em>Filtering Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filtering Property</em>' attribute.
	 * @see #getFilteringProperty()
	 * @generated
	 */
	void setFilteringProperty(String value);

	/**
	 * Returns the value of the '<em><b>Big Corpora Filtering Property</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Corpora Filtering Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Big Corpora Filtering Property</em>' attribute.
	 * @see #setBigCorporaFilteringProperty(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_BigCorporaFilteringProperty()
	 * @model default="1"
	 * @generated
	 */
	String getBigCorporaFilteringProperty();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringProperty <em>Big Corpora Filtering Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Big Corpora Filtering Property</em>' attribute.
	 * @see #getBigCorporaFilteringProperty()
	 * @generated
	 */
	void setBigCorporaFilteringProperty(String value);

	/**
	 * Returns the value of the '<em><b>Big Corpora Document Period</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Corpora Document Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Big Corpora Document Period</em>' attribute.
	 * @see #setBigCorporaDocumentPeriod(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_BigCorporaDocumentPeriod()
	 * @model default="100" required="true"
	 * @generated
	 */
	int getBigCorporaDocumentPeriod();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaDocumentPeriod <em>Big Corpora Document Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Big Corpora Document Period</em>' attribute.
	 * @see #getBigCorporaDocumentPeriod()
	 * @generated
	 */
	void setBigCorporaDocumentPeriod(int value);

	/**
	 * Returns the value of the '<em><b>Big Corpora Filtering Property Threshold</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Corpora Filtering Property Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Big Corpora Filtering Property Threshold</em>' attribute.
	 * @see #setBigCorporaFilteringPropertyThreshold(double)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_BigCorporaFilteringPropertyThreshold()
	 * @model default="1"
	 * @generated
	 */
	double getBigCorporaFilteringPropertyThreshold();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaFilteringPropertyThreshold <em>Big Corpora Filtering Property Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Big Corpora Filtering Property Threshold</em>' attribute.
	 * @see #getBigCorporaFilteringPropertyThreshold()
	 * @generated
	 */
	void setBigCorporaFilteringPropertyThreshold(double value);

	/**
	 * Returns the value of the '<em><b>Big Corpora Max Number Of Terms</b></em>' attribute.
	 * The default value is <code>"100000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Corpora Max Number Of Terms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Big Corpora Max Number Of Terms</em>' attribute.
	 * @see #setBigCorporaMaxNumberOfTerms(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_BigCorporaMaxNumberOfTerms()
	 * @model default="100000" required="true"
	 * @generated
	 */
	int getBigCorporaMaxNumberOfTerms();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getBigCorporaMaxNumberOfTerms <em>Big Corpora Max Number Of Terms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Big Corpora Max Number Of Terms</em>' attribute.
	 * @see #getBigCorporaMaxNumberOfTerms()
	 * @generated
	 */
	void setBigCorporaMaxNumberOfTerms(int value);

	/**
	 * Returns the value of the '<em><b>Target Terminology Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Terminology Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Terminology Name</em>' attribute.
	 * @see #setTargetTerminologyName(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_TargetTerminologyName()
	 * @model
	 * @generated
	 */
	String getTargetTerminologyName();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTargetTerminologyName <em>Target Terminology Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Terminology Name</em>' attribute.
	 * @see #getTargetTerminologyName()
	 * @generated
	 */
	void setTargetTerminologyName(String value);

	/**
	 * Returns the value of the '<em><b>Output Dir</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Dir</em>' attribute.
	 * @see #setOutputDir(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_OutputDir()
	 * @model default=""
	 * @generated
	 */
	String getOutputDir();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOutputDir <em>Output Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Dir</em>' attribute.
	 * @see #getOutputDir()
	 * @generated
	 */
	void setOutputDir(String value);

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_Filename()
	 * @model
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Tagger Config Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tagger Config Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tagger Config Name</em>' attribute.
	 * @see #setTaggerConfigName(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_TaggerConfigName()
	 * @model
	 * @generated
	 */
	String getTaggerConfigName();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTaggerConfigName <em>Tagger Config Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tagger Config Name</em>' attribute.
	 * @see #getTaggerConfigName()
	 * @generated
	 */
	void setTaggerConfigName(String value);

} // EPipeline
