/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPipeline List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineListImpl#getPipelines <em>Pipelines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EPipelineListImpl extends MinimalEObjectImpl.Container implements EPipelineList {
	/**
	 * The cached value of the '{@link #getPipelines() <em>Pipelines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipelines()
	 * @generated
	 * @ordered
	 */
	protected EList<EPipeline> pipelines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPipelineListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.EPIPELINE_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPipeline> getPipelines() {
		if (pipelines == null) {
			pipelines = new EObjectResolvingEList<EPipeline>(EPipeline.class, this, TermsuiteuiPackage.EPIPELINE_LIST__PIPELINES);
		}
		return pipelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.EPIPELINE_LIST__PIPELINES:
				return getPipelines();
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
			case TermsuiteuiPackage.EPIPELINE_LIST__PIPELINES:
				getPipelines().clear();
				getPipelines().addAll((Collection<? extends EPipeline>)newValue);
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
			case TermsuiteuiPackage.EPIPELINE_LIST__PIPELINES:
				getPipelines().clear();
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
			case TermsuiteuiPackage.EPIPELINE_LIST__PIPELINES:
				return pipelines != null && !pipelines.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EPipelineListImpl
