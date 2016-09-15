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
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getDocuments <em>Documents</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCollectionType <em>Collection Type</em>}</li>
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
	 * Returns the value of the '<em><b>Documents</b></em>' containment reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument}.
	 * It is bidirectional and its opposite is '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getSingleLanguageCorpus <em>Single Language Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documents</em>' containment reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getESingleLanguageCorpus_Documents()
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EDocument#getSingleLanguageCorpus
	 * @model opposite="singleLanguageCorpus" containment="true" keys="filename"
	 * @generated
	 */
	EList<EDocument> getDocuments();

	/**
	 * Returns the value of the '<em><b>Collection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Type</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType
	 * @see #setCollectionType(ECollectionType)
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getESingleLanguageCorpus_CollectionType()
	 * @model
	 * @generated
	 */
	ECollectionType getCollectionType();

	/**
	 * Sets the value of the '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus#getCollectionType <em>Collection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Type</em>' attribute.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECollectionType
	 * @see #getCollectionType()
	 * @generated
	 */
	void setCollectionType(ECollectionType value);

	/**
	 * Returns the value of the '<em><b>Terminologies</b></em>' containment reference list.
	 * The list contents are of type {@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology}.
	 * It is bidirectional and its opposite is '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminologies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminologies</em>' containment reference list.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getESingleLanguageCorpus_Terminologies()
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology#getCorpus
	 * @model opposite="corpus" containment="true" keys="name"
	 * @generated
	 */
	EList<ETerminology> getTerminologies();

} // ESingleLanguageCorpus
