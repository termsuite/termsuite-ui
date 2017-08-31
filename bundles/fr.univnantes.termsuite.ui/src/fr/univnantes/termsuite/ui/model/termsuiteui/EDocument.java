/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDocument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getFilename <em>Filename</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getSingleLanguageCorpus <em>Single Language Corpus</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEDocument()
 * @model
 * @generated
 */
public interface EDocument extends EResource {
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
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEDocument_Filename()
	 * @model required="true"
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Single Language Corpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Language Corpus</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Language Corpus</em>' reference.
	 * @see #setSingleLanguageCorpus(ESingleLanguageCorpus)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEDocument_SingleLanguageCorpus()
	 * @model required="true"
	 * @generated
	 */
	ESingleLanguageCorpus getSingleLanguageCorpus();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getSingleLanguageCorpus <em>Single Language Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Single Language Corpus</em>' reference.
	 * @see #getSingleLanguageCorpus()
	 * @generated
	 */
	void setSingleLanguageCorpus(ESingleLanguageCorpus value);

} // EDocument
