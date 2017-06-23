/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETermino Viewer Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getNbDisplayedTerms <em>Nb Displayed Terms</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSearchString <em>Search String</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSortingPropertyName <em>Sorting Property Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#isSortingAsc <em>Sorting Asc</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSelectedPropertyNames <em>Selected Property Names</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminoViewerConfig()
 * @model
 * @generated
 */
public interface ETerminoViewerConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Nb Displayed Terms</b></em>' attribute.
	 * The default value is <code>"500"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Displayed Terms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Displayed Terms</em>' attribute.
	 * @see #setNbDisplayedTerms(int)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminoViewerConfig_NbDisplayedTerms()
	 * @model default="500"
	 * @generated
	 */
	int getNbDisplayedTerms();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getNbDisplayedTerms <em>Nb Displayed Terms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Displayed Terms</em>' attribute.
	 * @see #getNbDisplayedTerms()
	 * @generated
	 */
	void setNbDisplayedTerms(int value);

	/**
	 * Returns the value of the '<em><b>Search String</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search String</em>' attribute.
	 * @see #setSearchString(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminoViewerConfig_SearchString()
	 * @model default="" required="true"
	 * @generated
	 */
	String getSearchString();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSearchString <em>Search String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search String</em>' attribute.
	 * @see #getSearchString()
	 * @generated
	 */
	void setSearchString(String value);

	/**
	 * Returns the value of the '<em><b>Sorting Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sorting Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sorting Property Name</em>' attribute.
	 * @see #setSortingPropertyName(String)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminoViewerConfig_SortingPropertyName()
	 * @model
	 * @generated
	 */
	String getSortingPropertyName();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#getSortingPropertyName <em>Sorting Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sorting Property Name</em>' attribute.
	 * @see #getSortingPropertyName()
	 * @generated
	 */
	void setSortingPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Sorting Asc</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sorting Asc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sorting Asc</em>' attribute.
	 * @see #setSortingAsc(boolean)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminoViewerConfig_SortingAsc()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isSortingAsc();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig#isSortingAsc <em>Sorting Asc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sorting Asc</em>' attribute.
	 * @see #isSortingAsc()
	 * @generated
	 */
	void setSortingAsc(boolean value);

	/**
	 * Returns the value of the '<em><b>Selected Property Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Property Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Property Names</em>' attribute list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getETerminoViewerConfig_SelectedPropertyNames()
	 * @model default=""
	 * @generated
	 */
	EList<String> getSelectedPropertyNames();

} // ETerminoViewerConfig
