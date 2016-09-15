/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.util;

import fr.univnantes.termsuite.ui.model.termsuiteui.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage
 * @generated
 */
public class TermsuiteuiSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TermsuiteuiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermsuiteuiSwitch() {
		if (modelPackage == null) {
			modelPackage = TermsuiteuiPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TermsuiteuiPackage.ECORPORA_LIST: {
				ECorporaList eCorporaList = (ECorporaList)theEObject;
				T result = caseECorporaList(eCorporaList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ECORPUS: {
				ECorpus eCorpus = (ECorpus)theEObject;
				T result = caseECorpus(eCorpus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS: {
				ESingleLanguageCorpus eSingleLanguageCorpus = (ESingleLanguageCorpus)theEObject;
				T result = caseESingleLanguageCorpus(eSingleLanguageCorpus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.EDOCUMENT: {
				EDocument eDocument = (EDocument)theEObject;
				T result = caseEDocument(eDocument);
				if (result == null) result = caseEResource(eDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.EPIPELINE: {
				EPipeline ePipeline = (EPipeline)theEObject;
				T result = caseEPipeline(ePipeline);
				if (result == null) result = caseEResource(ePipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.EPIPELINE_LIST: {
				EPipelineList ePipelineList = (EPipelineList)theEObject;
				T result = caseEPipelineList(ePipelineList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ETERMINOLOGY: {
				ETerminology eTerminology = (ETerminology)theEObject;
				T result = caseETerminology(eTerminology);
				if (result == null) result = caseEResource(eTerminology);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG: {
				ETerminoViewerConfig eTerminoViewerConfig = (ETerminoViewerConfig)theEObject;
				T result = caseETerminoViewerConfig(eTerminoViewerConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ERESOURCE: {
				EResource eResource = (EResource)theEObject;
				T result = caseEResource(eResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ETAGGER_CONFIG: {
				ETaggerConfig eTaggerConfig = (ETaggerConfig)theEObject;
				T result = caseETaggerConfig(eTaggerConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY: {
				EBilingualDictionary eBilingualDictionary = (EBilingualDictionary)theEObject;
				T result = caseEBilingualDictionary(eBilingualDictionary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ELINGUISTIC_RESOURCE: {
				ELinguisticResource eLinguisticResource = (ELinguisticResource)theEObject;
				T result = caseELinguisticResource(eLinguisticResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TermsuiteuiPackage.ELINGUISTIC_RESOURCE_SET: {
				ELinguisticResourceSet eLinguisticResourceSet = (ELinguisticResourceSet)theEObject;
				T result = caseELinguisticResourceSet(eLinguisticResourceSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ECorpora List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ECorpora List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECorporaList(ECorporaList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ECorpus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ECorpus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECorpus(ECorpus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESingle Language Corpus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESingle Language Corpus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESingleLanguageCorpus(ESingleLanguageCorpus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDocument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDocument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDocument(EDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPipeline(EPipeline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPipeline List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPipeline List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPipelineList(EPipelineList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETerminology</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETerminology</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseETerminology(ETerminology object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETermino Viewer Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETermino Viewer Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseETerminoViewerConfig(ETerminoViewerConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EResource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EResource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEResource(EResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETagger Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETagger Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseETaggerConfig(ETaggerConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EBilingual Dictionary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EBilingual Dictionary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEBilingualDictionary(EBilingualDictionary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELinguistic Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELinguistic Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELinguisticResource(ELinguisticResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELinguistic Resource Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELinguistic Resource Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELinguisticResourceSet(ELinguisticResourceSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TermsuiteuiSwitch
