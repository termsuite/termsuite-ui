/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;
import java.util.Collection;

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
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl#getSortingPropertyName <em>Sorting Property Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl#isSortingAsc <em>Sorting Asc</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoViewerConfigImpl#getSelectedPropertyNames <em>Selected Property Names</em>}</li>
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
	protected static final int NB_DISPLAYED_TERMS_EDEFAULT = 100;

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
	 * The default value of the '{@link #getSortingPropertyName() <em>Sorting Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortingPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String SORTING_PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSortingPropertyName() <em>Sorting Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortingPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String sortingPropertyName = SORTING_PROPERTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isSortingAsc() <em>Sorting Asc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSortingAsc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SORTING_ASC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSortingAsc() <em>Sorting Asc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSortingAsc()
	 * @generated
	 * @ordered
	 */
	protected boolean sortingAsc = SORTING_ASC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSelectedPropertyNames() <em>Selected Property Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedPropertyNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> selectedPropertyNames;

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
	public String getSortingPropertyName() {
		return sortingPropertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortingPropertyName(String newSortingPropertyName) {
		String oldSortingPropertyName = sortingPropertyName;
		sortingPropertyName = newSortingPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_PROPERTY_NAME, oldSortingPropertyName, sortingPropertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSortingAsc() {
		return sortingAsc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortingAsc(boolean newSortingAsc) {
		boolean oldSortingAsc = sortingAsc;
		sortingAsc = newSortingAsc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_ASC, oldSortingAsc, sortingAsc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSelectedPropertyNames() {
		if (selectedPropertyNames == null) {
			selectedPropertyNames = new EDataTypeUniqueEList<String>(String.class, this, TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES);
		}
		return selectedPropertyNames;
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
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_PROPERTY_NAME:
				return getSortingPropertyName();
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_ASC:
				return isSortingAsc();
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES:
				return getSelectedPropertyNames();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__NB_DISPLAYED_TERMS:
				setNbDisplayedTerms((Integer)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SEARCH_STRING:
				setSearchString((String)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_PROPERTY_NAME:
				setSortingPropertyName((String)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_ASC:
				setSortingAsc((Boolean)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES:
				getSelectedPropertyNames().clear();
				getSelectedPropertyNames().addAll((Collection<? extends String>)newValue);
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
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_PROPERTY_NAME:
				setSortingPropertyName(SORTING_PROPERTY_NAME_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_ASC:
				setSortingAsc(SORTING_ASC_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES:
				getSelectedPropertyNames().clear();
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
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_PROPERTY_NAME:
				return SORTING_PROPERTY_NAME_EDEFAULT == null ? sortingPropertyName != null : !SORTING_PROPERTY_NAME_EDEFAULT.equals(sortingPropertyName);
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SORTING_ASC:
				return sortingAsc != SORTING_ASC_EDEFAULT;
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG__SELECTED_PROPERTY_NAMES:
				return selectedPropertyNames != null && !selectedPropertyNames.isEmpty();
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
		result.append(", sortingPropertyName: ");
		result.append(sortingPropertyName);
		result.append(", sortingAsc: ");
		result.append(sortingAsc);
		result.append(", selectedPropertyNames: ");
		result.append(selectedPropertyNames);
		result.append(')');
		return result.toString();
	}

} //ETerminoViewerConfigImpl
