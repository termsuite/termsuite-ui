/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage
 * @generated
 */
public interface TermsuiteuiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TermsuiteuiFactory eINSTANCE = fr.univnantes.termsuite.ui.model.termsuiteui.impl.TermsuiteuiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>ECorpora List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ECorpora List</em>'.
	 * @generated
	 */
	ECorporaList createECorporaList();

	/**
	 * Returns a new object of class '<em>ECorpus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ECorpus</em>'.
	 * @generated
	 */
	ECorpus createECorpus();

	/**
	 * Returns a new object of class '<em>ESingle Language Corpus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESingle Language Corpus</em>'.
	 * @generated
	 */
	ESingleLanguageCorpus createESingleLanguageCorpus();

	/**
	 * Returns a new object of class '<em>EDocument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDocument</em>'.
	 * @generated
	 */
	EDocument createEDocument();

	/**
	 * Returns a new object of class '<em>EPipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPipeline</em>'.
	 * @generated
	 */
	EPipeline createEPipeline();

	/**
	 * Returns a new object of class '<em>EPipeline List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPipeline List</em>'.
	 * @generated
	 */
	EPipelineList createEPipelineList();

	/**
	 * Returns a new object of class '<em>ETerminology</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ETerminology</em>'.
	 * @generated
	 */
	ETerminology createETerminology();

	/**
	 * Returns a new object of class '<em>ETermino Viewer Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ETermino Viewer Config</em>'.
	 * @generated
	 */
	ETerminoViewerConfig createETerminoViewerConfig();

	/**
	 * Returns a new object of class '<em>EResource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EResource</em>'.
	 * @generated
	 */
	EResource createEResource();

	/**
	 * Returns a new object of class '<em>ETagger Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ETagger Config</em>'.
	 * @generated
	 */
	ETaggerConfig createETaggerConfig();

	/**
	 * Returns a new object of class '<em>EBilingual Dictionary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EBilingual Dictionary</em>'.
	 * @generated
	 */
	EBilingualDictionary createEBilingualDictionary();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TermsuiteuiPackage getTermsuiteuiPackage();

} //TermsuiteuiFactory
