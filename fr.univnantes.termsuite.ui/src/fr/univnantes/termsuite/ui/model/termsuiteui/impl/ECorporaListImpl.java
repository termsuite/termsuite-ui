/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ECorpora List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ECorporaListImpl#getCorpora <em>Corpora</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ECorporaListImpl extends MinimalEObjectImpl.Container implements ECorporaList {
	/**
	 * The cached value of the '{@link #getCorpora() <em>Corpora</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorpora()
	 * @generated
	 * @ordered
	 */
	protected EList<ECorpus> corpora;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ECorporaListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.ECORPORA_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ECorpus> getCorpora() {
		if (corpora == null) {
			corpora = new EObjectResolvingEList<ECorpus>(ECorpus.class, this, TermsuiteuiPackage.ECORPORA_LIST__CORPORA);
		}
		return corpora;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.ECORPORA_LIST__CORPORA:
				return getCorpora();
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
			case TermsuiteuiPackage.ECORPORA_LIST__CORPORA:
				getCorpora().clear();
				getCorpora().addAll((Collection<? extends ECorpus>)newValue);
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
			case TermsuiteuiPackage.ECORPORA_LIST__CORPORA:
				getCorpora().clear();
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
			case TermsuiteuiPackage.ECORPORA_LIST__CORPORA:
				return corpora != null && !corpora.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ECorporaListImpl
