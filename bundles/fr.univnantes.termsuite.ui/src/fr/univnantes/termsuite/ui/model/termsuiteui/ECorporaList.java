/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECorpora List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList#getCorpora <em>Corpora</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getECorporaList()
 * @model
 * @generated
 */
public interface ECorporaList extends EObject {
	/**
	 * Returns the value of the '<em><b>Corpora</b></em>' reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corpora</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corpora</em>' reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getECorporaList_Corpora()
	 * @model
	 * @generated
	 */
	EList<ECorpus> getCorpora();

} // ECorporaList
