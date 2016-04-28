/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETermsuite Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETermsuiteConfig#getOutputDirectory <em>Output Directory</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETermsuiteConfig#getTaggers <em>Taggers</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETermsuiteConfig()
 * @model
 * @generated
 */
public interface ETermsuiteConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Output Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Directory</em>' attribute.
	 * @see #setOutputDirectory(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETermsuiteConfig_OutputDirectory()
	 * @model
	 * @generated
	 */
	String getOutputDirectory();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETermsuiteConfig#getOutputDirectory <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Directory</em>' attribute.
	 * @see #getOutputDirectory()
	 * @generated
	 */
	void setOutputDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Taggers</b></em>' reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Taggers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Taggers</em>' reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETermsuiteConfig_Taggers()
	 * @model
	 * @generated
	 */
	EList<ETaggerConfig> getTaggers();

} // ETermsuiteConfig
