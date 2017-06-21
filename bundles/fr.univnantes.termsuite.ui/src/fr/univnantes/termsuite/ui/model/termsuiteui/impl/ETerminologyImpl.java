/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ETerminology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl#isHasOccurrences <em>Has Occurrences</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl#isHasContexts <em>Has Contexts</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl#getCorpus <em>Corpus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ETerminologyImpl extends EResourceImpl implements ETerminology {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasOccurrences() <em>Has Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasOccurrences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_OCCURRENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasOccurrences() <em>Has Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasOccurrences()
	 * @generated
	 * @ordered
	 */
	protected boolean hasOccurrences = HAS_OCCURRENCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasContexts() <em>Has Contexts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasContexts()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_CONTEXTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasContexts() <em>Has Contexts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasContexts()
	 * @generated
	 * @ordered
	 */
	protected boolean hasContexts = HAS_CONTEXTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCorpus() <em>Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorpus()
	 * @generated
	 * @ordered
	 */
	protected ESingleLanguageCorpus corpus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETerminologyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.ETERMINOLOGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINOLOGY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasOccurrences() {
		return hasOccurrences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasOccurrences(boolean newHasOccurrences) {
		boolean oldHasOccurrences = hasOccurrences;
		hasOccurrences = newHasOccurrences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINOLOGY__HAS_OCCURRENCES, oldHasOccurrences, hasOccurrences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasContexts() {
		return hasContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasContexts(boolean newHasContexts) {
		boolean oldHasContexts = hasContexts;
		hasContexts = newHasContexts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINOLOGY__HAS_CONTEXTS, oldHasContexts, hasContexts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESingleLanguageCorpus getCorpus() {
		if (corpus != null && corpus.eIsProxy()) {
			InternalEObject oldCorpus = (InternalEObject)corpus;
			corpus = (ESingleLanguageCorpus)eResolveProxy(oldCorpus);
			if (corpus != oldCorpus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TermsuiteuiPackage.ETERMINOLOGY__CORPUS, oldCorpus, corpus));
			}
		}
		return corpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESingleLanguageCorpus basicGetCorpus() {
		return corpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorpus(ESingleLanguageCorpus newCorpus, NotificationChain msgs) {
		ESingleLanguageCorpus oldCorpus = corpus;
		corpus = newCorpus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINOLOGY__CORPUS, oldCorpus, newCorpus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorpus(ESingleLanguageCorpus newCorpus) {
		if (newCorpus != corpus) {
			NotificationChain msgs = null;
			if (corpus != null)
				msgs = ((InternalEObject)corpus).eInverseRemove(this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES, ESingleLanguageCorpus.class, msgs);
			if (newCorpus != null)
				msgs = ((InternalEObject)newCorpus).eInverseAdd(this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES, ESingleLanguageCorpus.class, msgs);
			msgs = basicSetCorpus(newCorpus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINOLOGY__CORPUS, newCorpus, newCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				if (corpus != null)
					msgs = ((InternalEObject)corpus).eInverseRemove(this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES, ESingleLanguageCorpus.class, msgs);
				return basicSetCorpus((ESingleLanguageCorpus)otherEnd, msgs);
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
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				return basicSetCorpus(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.ETERMINOLOGY__NAME:
				return getName();
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_OCCURRENCES:
				return isHasOccurrences();
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_CONTEXTS:
				return isHasContexts();
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				if (resolve) return getCorpus();
				return basicGetCorpus();
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
			case TermsuiteuiPackage.ETERMINOLOGY__NAME:
				setName((String)newValue);
				return;
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_OCCURRENCES:
				setHasOccurrences((Boolean)newValue);
				return;
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_CONTEXTS:
				setHasContexts((Boolean)newValue);
				return;
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				setCorpus((ESingleLanguageCorpus)newValue);
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
			case TermsuiteuiPackage.ETERMINOLOGY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_OCCURRENCES:
				setHasOccurrences(HAS_OCCURRENCES_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_CONTEXTS:
				setHasContexts(HAS_CONTEXTS_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				setCorpus((ESingleLanguageCorpus)null);
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
			case TermsuiteuiPackage.ETERMINOLOGY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_OCCURRENCES:
				return hasOccurrences != HAS_OCCURRENCES_EDEFAULT;
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_CONTEXTS:
				return hasContexts != HAS_CONTEXTS_EDEFAULT;
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				return corpus != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", hasOccurrences: ");
		result.append(hasOccurrences);
		result.append(", hasContexts: ");
		result.append(hasContexts);
		result.append(')');
		return result.toString();
	}

} //ETerminologyImpl
