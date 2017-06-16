/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
		if (eContainerFeatureID() != TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS) return null;
		return (ESingleLanguageCorpus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSingleLanguageCorpus(ESingleLanguageCorpus newSingleLanguageCorpus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSingleLanguageCorpus, TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleLanguageCorpus(ESingleLanguageCorpus newSingleLanguageCorpus) {
		if (newSingleLanguageCorpus != eInternalContainer() || (eContainerFeatureID() != TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS && newSingleLanguageCorpus != null)) {
			if (EcoreUtil.isAncestor(this, newSingleLanguageCorpus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSingleLanguageCorpus != null)
				msgs = ((InternalEObject)newSingleLanguageCorpus).eInverseAdd(this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS, ESingleLanguageCorpus.class, msgs);
			msgs = basicSetSingleLanguageCorpus(newSingleLanguageCorpus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS, newSingleLanguageCorpus, newSingleLanguageCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSingleLanguageCorpus((ESingleLanguageCorpus)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS:
				return basicSetSingleLanguageCorpus(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS:
				return eInternalContainer().eInverseRemove(this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS, ESingleLanguageCorpus.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
				return getSingleLanguageCorpus();
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
				return getSingleLanguageCorpus() != null;
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
