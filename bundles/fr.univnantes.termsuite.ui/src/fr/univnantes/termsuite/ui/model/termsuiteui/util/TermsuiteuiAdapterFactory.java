/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.util;

import fr.univnantes.termsuite.ui.model.termsuiteui.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage
 * @generated
 */
public class TermsuiteuiAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TermsuiteuiPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermsuiteuiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TermsuiteuiPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TermsuiteuiSwitch<Adapter> modelSwitch =
		new TermsuiteuiSwitch<Adapter>() {
			@Override
			public Adapter caseECorporaList(ECorporaList object) {
				return createECorporaListAdapter();
			}
			@Override
			public Adapter caseECorpus(ECorpus object) {
				return createECorpusAdapter();
			}
			@Override
			public Adapter caseESingleLanguageCorpus(ESingleLanguageCorpus object) {
				return createESingleLanguageCorpusAdapter();
			}
			@Override
			public Adapter caseEDocument(EDocument object) {
				return createEDocumentAdapter();
			}
			@Override
			public Adapter caseEPipeline(EPipeline object) {
				return createEPipelineAdapter();
			}
			@Override
			public Adapter caseEPipelineList(EPipelineList object) {
				return createEPipelineListAdapter();
			}
			@Override
			public Adapter caseETerminology(ETerminology object) {
				return createETerminologyAdapter();
			}
			@Override
			public Adapter caseETerminoViewerConfig(ETerminoViewerConfig object) {
				return createETerminoViewerConfigAdapter();
			}
			@Override
			public Adapter caseEResource(EResource object) {
				return createEResourceAdapter();
			}
			@Override
			public Adapter caseETaggerConfig(ETaggerConfig object) {
				return createETaggerConfigAdapter();
			}
			@Override
			public Adapter caseEBilingualDictionary(EBilingualDictionary object) {
				return createEBilingualDictionaryAdapter();
			}
			@Override
			public Adapter caseELinguisticResource(ELinguisticResource object) {
				return createELinguisticResourceAdapter();
			}
			@Override
			public Adapter caseELinguisticResourceSet(ELinguisticResourceSet object) {
				return createELinguisticResourceSetAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList <em>ECorpora List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList
	 * @generated
	 */
	public Adapter createECorporaListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus <em>ECorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus
	 * @generated
	 */
	public Adapter createECorpusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus <em>ESingle Language Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus
	 * @generated
	 */
	public Adapter createESingleLanguageCorpusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EDocument <em>EDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EDocument
	 * @generated
	 */
	public Adapter createEDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline <em>EPipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline
	 * @generated
	 */
	public Adapter createEPipelineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList <em>EPipeline List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList
	 * @generated
	 */
	public Adapter createEPipelineListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology <em>ETerminology</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology
	 * @generated
	 */
	public Adapter createETerminologyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig <em>ETermino Viewer Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig
	 * @generated
	 */
	public Adapter createETerminoViewerConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EResource <em>EResource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EResource
	 * @generated
	 */
	public Adapter createEResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig <em>ETagger Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig
	 * @generated
	 */
	public Adapter createETaggerConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary <em>EBilingual Dictionary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary
	 * @generated
	 */
	public Adapter createEBilingualDictionaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource <em>ELinguistic Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResource
	 * @generated
	 */
	public Adapter createELinguisticResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet <em>ELinguistic Resource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.univnantes.termsuite.ui.model.termsuiteui.ELinguisticResourceSet
	 * @generated
	 */
	public Adapter createELinguisticResourceSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TermsuiteuiAdapterFactory
