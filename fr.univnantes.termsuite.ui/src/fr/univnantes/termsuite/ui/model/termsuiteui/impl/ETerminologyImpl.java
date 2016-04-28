/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminologyImpl#getFilepath <em>Filepath</em>}</li>
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
	 * The default value of the '{@link #getFilepath() <em>Filepath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilepath()
	 * @generated
	 * @ordered
	 */
	protected static final String FILEPATH_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFilepath() <em>Filepath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilepath()
	 * @generated
	 * @ordered
	 */
	protected String filepath = FILEPATH_EDEFAULT;

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
	public String getFilepath() {
		return filepath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilepath(String newFilepath) {
		String oldFilepath = filepath;
		filepath = newFilepath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINOLOGY__FILEPATH, oldFilepath, filepath));
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
		if (eContainerFeatureID() != TermsuiteuiPackage.ETERMINOLOGY__CORPUS) return null;
		return (ESingleLanguageCorpus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorpus(ESingleLanguageCorpus newCorpus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCorpus, TermsuiteuiPackage.ETERMINOLOGY__CORPUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorpus(ESingleLanguageCorpus newCorpus) {
		if (newCorpus != eInternalContainer() || (eContainerFeatureID() != TermsuiteuiPackage.ETERMINOLOGY__CORPUS && newCorpus != null)) {
			if (EcoreUtil.isAncestor(this, newCorpus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				return eInternalContainer().eInverseRemove(this, TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS__TERMINOLOGIES, ESingleLanguageCorpus.class, msgs);
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
			case TermsuiteuiPackage.ETERMINOLOGY__FILEPATH:
				return getFilepath();
			case TermsuiteuiPackage.ETERMINOLOGY__NAME:
				return getName();
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_OCCURRENCES:
				return isHasOccurrences();
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_CONTEXTS:
				return isHasContexts();
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				return getCorpus();
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
			case TermsuiteuiPackage.ETERMINOLOGY__FILEPATH:
				setFilepath((String)newValue);
				return;
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
			case TermsuiteuiPackage.ETERMINOLOGY__FILEPATH:
				setFilepath(FILEPATH_EDEFAULT);
				return;
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
			case TermsuiteuiPackage.ETERMINOLOGY__FILEPATH:
				return FILEPATH_EDEFAULT == null ? filepath != null : !FILEPATH_EDEFAULT.equals(filepath);
			case TermsuiteuiPackage.ETERMINOLOGY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_OCCURRENCES:
				return hasOccurrences != HAS_OCCURRENCES_EDEFAULT;
			case TermsuiteuiPackage.ETERMINOLOGY__HAS_CONTEXTS:
				return hasContexts != HAS_CONTEXTS_EDEFAULT;
			case TermsuiteuiPackage.ETERMINOLOGY__CORPUS:
				return getCorpus() != null;
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
		result.append(" (filepath: ");
		result.append(filepath);
		result.append(", name: ");
		result.append(name);
		result.append(", hasOccurrences: ");
		result.append(hasOccurrences);
		result.append(", hasContexts: ");
		result.append(hasContexts);
		result.append(')');
		return result.toString();
	}

} //ETerminologyImpl
