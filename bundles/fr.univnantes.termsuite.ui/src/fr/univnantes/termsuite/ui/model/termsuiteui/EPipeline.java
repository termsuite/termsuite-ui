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
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isContextualizerEnabled <em>Contextualizer Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOccurrenceMode <em>Occurrence Mode</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getTaggerConfigName <em>Tagger Config Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilter <em>Filter</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getMaxNumTermsMemory <em>Max Num Terms Memory</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextScope <em>Context Scope</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextAssocMeasure <em>Context Assoc Measure</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemEnabled <em>Sem Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemMeasure <em>Sem Measure</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemDicoOnly <em>Sem Dico Only</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemNumCandidates <em>Sem Num Candidates</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline()
 * @model
 * @generated
 */
public interface EPipeline extends EResource {
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
	 * Returns the value of the '<em><b>Occurrence Mode</b></em>' attribute.
	 * The default value is <code>"KEEP_IN_MEMORY"</code>.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occurrence Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occurrence Mode</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode
	 * @see #setOccurrenceMode(EOccurrenceMode)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_OccurrenceMode()
	 * @model default="KEEP_IN_MEMORY" required="true"
	 * @generated
	 */
	EOccurrenceMode getOccurrenceMode();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getOccurrenceMode <em>Occurrence Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occurrence Mode</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode
	 * @see #getOccurrenceMode()
	 * @generated
	 */
	void setOccurrenceMode(EOccurrenceMode value);

	/**
	 * Returns the value of the '<em><b>Context Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Scope</em>' attribute.
	 * @see #setContextScope(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ContextScope()
	 * @model
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
	 * Returns the value of the '<em><b>Context Assoc Measure</b></em>' attribute.
	 * The default value is <code>"MUTUAL_INFORMATION"</code>.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Assoc Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Assoc Measure</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure
	 * @see #setContextAssocMeasure(EAssocMeasure)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_ContextAssocMeasure()
	 * @model default="MUTUAL_INFORMATION" required="true"
	 * @generated
	 */
	EAssocMeasure getContextAssocMeasure();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getContextAssocMeasure <em>Context Assoc Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Assoc Measure</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure
	 * @see #getContextAssocMeasure()
	 * @generated
	 */
	void setContextAssocMeasure(EAssocMeasure value);

	/**
	 * Returns the value of the '<em><b>Sem Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sem Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sem Enabled</em>' attribute.
	 * @see #setSemEnabled(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_SemEnabled()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isSemEnabled();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemEnabled <em>Sem Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sem Enabled</em>' attribute.
	 * @see #isSemEnabled()
	 * @generated
	 */
	void setSemEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Sem Measure</b></em>' attribute.
	 * The default value is <code>"COSINE"</code>.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sem Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sem Measure</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure
	 * @see #setSemMeasure(ESimilarityMeasure)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_SemMeasure()
	 * @model default="COSINE" required="true"
	 * @generated
	 */
	ESimilarityMeasure getSemMeasure();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemMeasure <em>Sem Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sem Measure</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure
	 * @see #getSemMeasure()
	 * @generated
	 */
	void setSemMeasure(ESimilarityMeasure value);

	/**
	 * Returns the value of the '<em><b>Sem Dico Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sem Dico Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sem Dico Only</em>' attribute.
	 * @see #setSemDicoOnly(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_SemDicoOnly()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isSemDicoOnly();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#isSemDicoOnly <em>Sem Dico Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sem Dico Only</em>' attribute.
	 * @see #isSemDicoOnly()
	 * @generated
	 */
	void setSemDicoOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Sem Num Candidates</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sem Num Candidates</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sem Num Candidates</em>' attribute.
	 * @see #setSemNumCandidates(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_SemNumCandidates()
	 * @model default="5"
	 * @generated
	 */
	int getSemNumCandidates();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getSemNumCandidates <em>Sem Num Candidates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sem Num Candidates</em>' attribute.
	 * @see #getSemNumCandidates()
	 * @generated
	 */
	void setSemNumCandidates(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' reference.
	 * @see #setFilter(ETerminoFilter)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_Filter()
	 * @model
	 * @generated
	 */
	ETerminoFilter getFilter();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getFilter <em>Filter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' reference.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(ETerminoFilter value);

	/**
	 * Returns the value of the '<em><b>Max Num Terms Memory</b></em>' attribute.
	 * The default value is <code>"500000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Num Terms Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Num Terms Memory</em>' attribute.
	 * @see #setMaxNumTermsMemory(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipeline_MaxNumTermsMemory()
	 * @model default="500000" required="true"
	 * @generated
	 */
	int getMaxNumTermsMemory();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline#getMaxNumTermsMemory <em>Max Num Terms Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Num Terms Memory</em>' attribute.
	 * @see #getMaxNumTermsMemory()
	 * @generated
	 */
	void setMaxNumTermsMemory(int value);

} // EPipeline
