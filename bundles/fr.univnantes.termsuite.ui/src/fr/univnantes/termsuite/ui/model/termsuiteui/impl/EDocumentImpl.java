/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDocument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EDocumentImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EDocumentImpl#getSingleLanguageCorpus <em>Single Language Corpus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EDocumentImpl extends EResourceImpl implements EDocument {
	/**
	 * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected String filename = FILENAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSingleLanguageCorpus() <em>Single Language Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleLanguageCorpus()
	 * @generated
	 * @ordered
	 */
	protected ESingleLanguageCorpus singleLanguageCorpus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.EDOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilename(String newFilename) {
		String oldFilename = filename;
		filename = newFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EDOCUMENT__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESingleLanguageCorpus getSingleLanguageCorpus() {
		if (singleLanguageCorpus != null && singleLanguageCorpus.eIsProxy()) {
			InternalEObject oldSingleLanguageCorpus = (InternalEObject)singleLanguageCorpus;
			singleLanguageCorpus = (ESingleLanguageCorpus)eResolveProxy(oldSingleLanguageCorpus);
			if (singleLanguageCorpus != oldSingleLanguageCorpus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS, oldSingleLanguageCorpus, singleLanguageCorpus));
			}
		}
		return singleLanguageCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESingleLanguageCorpus basicGetSingleLanguageCorpus() {
		return singleLanguageCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleLanguageCorpus(ESingleLanguageCorpus newSingleLanguageCorpus) {
		ESingleLanguageCorpus oldSingleLanguageCorpus = singleLanguageCorpus;
		singleLanguageCorpus = newSingleLanguageCorpus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS, oldSingleLanguageCorpus, singleLanguageCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.EDOCUMENT__FILENAME:
				return getFilename();
			case TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS:
				if (resolve) return getSingleLanguageCorpus();
				return basicGetSingleLanguageCorpus();
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
			case TermsuiteuiPackage.EDOCUMENT__FILENAME:
				setFilename((String)newValue);
				return;
			case TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS:
				setSingleLanguageCorpus((ESingleLanguageCorpus)newValue);
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
			case TermsuiteuiPackage.EDOCUMENT__FILENAME:
				setFilename(FILENAME_EDEFAULT);
				return;
			case TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS:
				setSingleLanguageCorpus((ESingleLanguageCorpus)null);
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
			case TermsuiteuiPackage.EDOCUMENT__FILENAME:
				return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
			case TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS:
				return singleLanguageCorpus != null;
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
		result.append(" (filename: ");
		result.append(filename);
		result.append(')');
		return result.toString();
	}

} //EDocumentImpl
