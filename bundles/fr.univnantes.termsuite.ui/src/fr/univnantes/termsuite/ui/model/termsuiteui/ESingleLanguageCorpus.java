/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESingle Language Corpus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getLanguage <em>Language</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCorpus <em>Corpus</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getTerminologies <em>Terminologies</em>}</li>
 * </ul>
 *
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getESingleLanguageCorpus()
 * @model
 * @generated
 */
public interface ESingleLanguageCorpus extends EObject {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.ELang}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #setLanguage(ELang)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getESingleLanguageCorpus_Language()
	 * @model required="true"
	 * @generated
	 */
	ELang getLanguage();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELang
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(ELang value);

	/**
	 * Returns the value of the '<em><b>Corpus</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getSingleLanguageCorpora <em>Single Language Corpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corpus</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corpus</em>' container reference.
	 * @see #setCorpus(ECorpus)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getESingleLanguageCorpus_Corpus()
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus#getSingleLanguageCorpora
	 * @model opposite="singleLanguageCorpora" required="true" transient="false"
	 * @generated
	 */
	ECorpus getCorpus();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCorpus <em>Corpus</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corpus</em>' container reference.
	 * @see #getCorpus()
	 * @generated
	 */
	void setCorpus(ECorpus value);

	/**
	 * Returns the value of the '<em><b>Terminologies</b></em>' containment reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology}.
	 * It is bidirectional and its opposite is '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminologies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminologies</em>' containment reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getESingleLanguageCorpus_Terminologies()
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus
	 * @model opposite="corpus" containment="true"
	 * @generated
	 */
	EList<ETerminology> getTerminologies();

} // ESingleLanguageCorpus
