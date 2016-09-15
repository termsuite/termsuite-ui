/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPipeline List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList#getPipelines <em>Pipelines</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipelineList()
 * @model
 * @generated
 */
public interface EPipelineList extends EObject {
	/**
	 * Returns the value of the '<em><b>Pipelines</b></em>' reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pipelines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipelines</em>' reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEPipelineList_Pipelines()
	 * @model
	 * @generated
	 */
	EList<EPipeline> getPipelines();

} // EPipelineList
