/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETerminology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getName <em>Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasOccurrences <em>Has Occurrences</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasContexts <em>Has Contexts</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus <em>Corpus</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminology()
 * @model
 * @generated
 */
public interface ETerminology extends EResource {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminology_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Has Occurrences</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Occurrences</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Occurrences</em>' attribute.
	 * @see #setHasOccurrences(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminology_HasOccurrences()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isHasOccurrences();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasOccurrences <em>Has Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Occurrences</em>' attribute.
	 * @see #isHasOccurrences()
	 * @generated
	 */
	void setHasOccurrences(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Contexts</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Contexts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Contexts</em>' attribute.
	 * @see #setHasContexts(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminology_HasContexts()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isHasContexts();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#isHasContexts <em>Has Contexts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Contexts</em>' attribute.
	 * @see #isHasContexts()
	 * @generated
	 */
	void setHasContexts(boolean value);

	/**
	 * Returns the value of the '<em><b>Corpus</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getTerminologies <em>Terminologies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corpus</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corpus</em>' reference.
	 * @see #setCorpus(ESingleLanguageCorpus)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminology_Corpus()
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getTerminologies
	 * @model opposite="terminologies" required="true"
	 * @generated
	 */
	ESingleLanguageCorpus getCorpus();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus <em>Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corpus</em>' reference.
	 * @see #getCorpus()
	 * @generated
	 */
	void setCorpus(ESingleLanguageCorpus value);

} // ETerminology
