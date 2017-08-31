/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EBilingual Dictionary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getSourceLang <em>Source Lang</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getTargetLang <em>Target Lang</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEBilingualDictionary()
 * @model
 * @generated
 */
public interface EBilingualDictionary extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Lang</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Lang</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Lang</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #setSourceLang(ELang)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEBilingualDictionary_SourceLang()
	 * @model
	 * @generated
	 */
	ELang getSourceLang();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getSourceLang <em>Source Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Lang</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #getSourceLang()
	 * @generated
	 */
	void setSourceLang(ELang value);

	/**
	 * Returns the value of the '<em><b>Target Lang</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Lang</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Lang</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #setTargetLang(ELang)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEBilingualDictionary_TargetLang()
	 * @model
	 * @generated
	 */
	ELang getTargetLang();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getTargetLang <em>Target Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Lang</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #getTargetLang()
	 * @generated
	 */
	void setTargetLang(ELang value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEBilingualDictionary_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // EBilingualDictionary
