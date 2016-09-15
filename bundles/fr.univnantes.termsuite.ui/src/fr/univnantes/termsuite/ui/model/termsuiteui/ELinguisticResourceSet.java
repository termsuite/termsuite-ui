/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ELinguistic Resource Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet#getLanguage <em>Language</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getELinguisticResourceSet()
 * @model
 * @generated
 */
public interface ELinguisticResourceSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #setLanguage(ELang)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getELinguisticResourceSet_Language()
	 * @model default=""
	 * @generated
	 */
	ELang getLanguage();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(ELang value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource}.
	 * It is bidirectional and its opposite is '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getResourceSet <em>Resource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getELinguisticResourceSet_Resources()
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource#getResourceSet
	 * @model opposite="resourceSet" containment="true"
	 * @generated
	 */
	EList<ELinguisticResource> getResources();

} // ELinguisticResourceSet
