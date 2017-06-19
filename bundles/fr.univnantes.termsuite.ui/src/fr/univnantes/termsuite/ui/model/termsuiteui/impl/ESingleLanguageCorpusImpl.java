/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESingle Language Corpus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl#getCorpus <em>Corpus</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl#getDocuments <em>Documents</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ESingleLanguageCorpusImpl#getTerminologies <em>Terminologies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ESingleLanguageCorpusImpl extends MinimalEObjectImpl.Container implements ESingleLanguageCorpus {
	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final ELang LANGUAGE_EDEFAULT = ELang.FR;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected ELang language = LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDocuments() <em>Documents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocuments()
	 * @generated
	 * @ordered
	 */
	protected EList<EDocument> documents;

	/**
	 * The cached value of the '{@link #getTerminologies() <em>Terminologies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminologies()
	 * @generated
	 * @ordered
	 */
	protected EList<ETerminology> terminologies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESingleLanguageCorpusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.ESINGLE_LANGUAGE_CORPUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELang getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(ELang newLanguage) {
		ELang oldLanguage = language;
		language = newLanguage == null ? LANGUAGE_EDEFAULT : newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECorpus getCorpus() {
		if (eContainerFeatureID() != TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS) return null;
		return (ECorpus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorpus(ECorpus newCorpus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCorpus, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorpus(ECorpus newCorpus) {
		if (newCorpus != eInternalContainer() || (eContainerFeatureID() != TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS && newCorpus != null)) {
			if (EcoreUtil.isAncestor(this, newCorpus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCorpus != null)
				msgs = ((InternalEObject)newCorpus).eInverseAdd(this, TermsuiteuiPackage.ECORPUS__SINGLE_LANGUAGE_CORPORA, ECorpus.class, msgs);
			msgs = basicSetCorpus(newCorpus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS, newCorpus, newCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDocument> getDocuments() {
		if (documents == null) {
			documents = new EObjectContainmentWithInverseEList<EDocument>(EDocument.class, this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS, TermsuiteuiPackage.EDOCUMENT__SINGLE_LANGUAGE_CORPUS);
		}
		return documents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ETerminology> getTerminologies() {
		if (terminologies == null) {
			terminologies = new EObjectContainmentWithInverseEList<ETerminology>(ETerminology.class, this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES, TermsuiteuiPackage.ETERMINOLOGY__CORPUS);
		}
		return terminologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCorpus((ECorpus)otherEnd, msgs);
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDocuments()).basicAdd(otherEnd, msgs);
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTerminologies()).basicAdd(otherEnd, msgs);
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
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS:
				return basicSetCorpus(null, msgs);
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS:
				return ((InternalEList<?>)getDocuments()).basicRemove(otherEnd, msgs);
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES:
				return ((InternalEList<?>)getTerminologies()).basicRemove(otherEnd, msgs);
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
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS:
				return eInternalContainer().eInverseRemove(this, TermsuiteuiPackage.ECORPUS__SINGLE_LANGUAGE_CORPORA, ECorpus.class, msgs);
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
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__LANGUAGE:
				return getLanguage();
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS:
				return getCorpus();
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS:
				return getDocuments();
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES:
				return getTerminologies();
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
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__LANGUAGE:
				setLanguage((ELang)newValue);
				return;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS:
				setCorpus((ECorpus)newValue);
				return;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS:
				getDocuments().clear();
				getDocuments().addAll((Collection<? extends EDocument>)newValue);
				return;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES:
				getTerminologies().clear();
				getTerminologies().addAll((Collection<? extends ETerminology>)newValue);
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
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS:
				setCorpus((ECorpus)null);
				return;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS:
				getDocuments().clear();
				return;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES:
				getTerminologies().clear();
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
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__LANGUAGE:
				return language != LANGUAGE_EDEFAULT;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__CORPUS:
				return getCorpus() != null;
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__DOCUMENTS:
				return documents != null && !documents.isEmpty();
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES:
				return terminologies != null && !terminologies.isEmpty();
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
		result.append(" (language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}

} //ESingleLanguageCorpusImpl
