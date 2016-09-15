/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECorpus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getPath <em>Path</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getSingleLanguageCorpora <em>Single Language Corpora</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getECorpus()
 * @model
 * @generated
 */
public interface ECorpus extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getECorpus_Path()
	 * @model default="" required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Single Language Corpora</b></em>' containment reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus}.
	 * It is bidirectional and its opposite is '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Language Corpora</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Language Corpora</em>' containment reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getECorpus_SingleLanguageCorpora()
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCorpus
	 * @model opposite="corpus" containment="true" keys="language"
	 * @generated
	 */
	EList<ESingleLanguageCorpus> getSingleLanguageCorpora();

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
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getECorpus_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ECorpus
