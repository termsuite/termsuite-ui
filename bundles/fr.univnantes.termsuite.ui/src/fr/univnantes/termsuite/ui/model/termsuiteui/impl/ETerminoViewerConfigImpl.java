/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ETermino Viewer Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl#getNbDisplayedTerms <em>Nb Displayed Terms</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl#getSearchString <em>Search String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ETerminoViewerConfigImpl extends MinimalEObjectImpl.Container implements ETerminoViewerConfig {
	/**
	 * The default value of the '{@link #getNbDisplayedTerms() <em>Nb Displayed Terms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbDisplayedTerms()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_DISPLAYED_TERMS_EDEFAULT = 500;

	/**
	 * The cached value of the '{@link #getNbDisplayedTerms() <em>Nb Displayed Terms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbDisplayedTerms()
	 * @generated
	 * @ordered
	 */
	protected int nbDisplayedTerms = NB_DISPLAYED_TERMS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSearchString() <em>Search String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchString()
	 * @generated
	 * @ordered
	 */
	protected static final String SEARCH_STRING_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSearchString() <em>Search String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchString()
	 * @generated
	 * @ordered
	 */
	protected String searchString = SEARCH_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETerminoViewerConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.ETERMINO_VIEWER_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbDisplayedTerms() {
		return nbDisplayedTerms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbDisplayedTerms(int newNbDisplayedTerms) {
		int oldNbDisplayedTerms = nbDisplayedTerms;
		nbDisplayedTerms = newNbDisplayedTerms;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS, oldNbDisplayedTerms, nbDisplayedTerms));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchString(String newSearchString) {
		String oldSearchString = searchString;
		searchString = newSearchString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING, oldSearchString, searchString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS:
				return getNbDisplayedTerms();
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING:
				return getSearchString();
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
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS:
				setNbDisplayedTerms((Integer)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING:
				setSearchString((String)newValue);
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
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS:
				setNbDisplayedTerms(NB_DISPLAYED_TERMS_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING:
				setSearchString(SEARCH_STRING_EDEFAULT);
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
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS:
				return nbDisplayedTerms != NB_DISPLAYED_TERMS_EDEFAULT;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING:
				return SEARCH_STRING_EDEFAULT == null ? searchString != null : !SEARCH_STRING_EDEFAULT.equals(searchString);
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
		result.append(" (nbDisplayedTerms: ");
		result.append(nbDisplayedTerms);
		result.append(", searchString: ");
		result.append(searchString);
		result.append(')');
		return result.toString();
	}

} //ETerminoViewerConfigImpl
