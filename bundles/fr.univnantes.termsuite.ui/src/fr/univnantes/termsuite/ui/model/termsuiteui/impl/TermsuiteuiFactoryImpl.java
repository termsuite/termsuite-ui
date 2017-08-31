/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorporaList;
import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.EDocument;
import fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipelineList;
import fr.univnantes.termsuite.ui.model.termsuiteui.EResource;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESingleLanguageCorpus;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETagger;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETaggerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoViewerConfig;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminology;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiFactory;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TermsuiteuiFactoryImpl extends EFactoryImpl implements TermsuiteuiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TermsuiteuiFactory init() {
		try {
			TermsuiteuiFactory theTermsuiteuiFactory = (TermsuiteuiFactory)EPackage.Registry.INSTANCE.getEFactory(TermsuiteuiPackage.eNS_URI);
			if (theTermsuiteuiFactory != null) {
				return theTermsuiteuiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TermsuiteuiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermsuiteuiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TermsuiteuiPackage.ECORPORA_LIST: return createECorporaList();
			case TermsuiteuiPackage.ECORPUS: return createECorpus();
			case TermsuiteuiPackage.ESINGLE_LANGUAGE_CORPUS: return createESingleLanguageCorpus();
			case TermsuiteuiPackage.EDOCUMENT: return createEDocument();
			case TermsuiteuiPackage.EPIPELINE: return createEPipeline();
			case TermsuiteuiPackage.EPIPELINE_LIST: return createEPipelineList();
			case TermsuiteuiPackage.ETERMINOLOGY: return createETerminology();
			case TermsuiteuiPackage.ETERMINO_VIEWER_CONFIG: return createETerminoViewerConfig();
			case TermsuiteuiPackage.ERESOURCE: return createEResource();
			case TermsuiteuiPackage.ETAGGER_CONFIG: return createETaggerConfig();
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY: return createEBilingualDictionary();
			case TermsuiteuiPackage.ETERMINO_FILTER: return createETerminoFilter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TermsuiteuiPackage.ELANG:
				return createELangFromString(eDataType, initialValue);
			case TermsuiteuiPackage.ETAGGER:
				return createETaggerFromString(eDataType, initialValue);
			case TermsuiteuiPackage.EFILTERING_MODE:
				return createEFilteringModeFromString(eDataType, initialValue);
			case TermsuiteuiPackage.EOCCURRENCE_MODE:
				return createEOccurrenceModeFromString(eDataType, initialValue);
			case TermsuiteuiPackage.EASSOC_MEASURE:
				return createEAssocMeasureFromString(eDataType, initialValue);
			case TermsuiteuiPackage.ESIMILARITY_MEASURE:
				return createESimilarityMeasureFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TermsuiteuiPackage.ELANG:
				return convertELangToString(eDataType, instanceValue);
			case TermsuiteuiPackage.ETAGGER:
				return convertETaggerToString(eDataType, instanceValue);
			case TermsuiteuiPackage.EFILTERING_MODE:
				return convertEFilteringModeToString(eDataType, instanceValue);
			case TermsuiteuiPackage.EOCCURRENCE_MODE:
				return convertEOccurrenceModeToString(eDataType, instanceValue);
			case TermsuiteuiPackage.EASSOC_MEASURE:
				return convertEAssocMeasureToString(eDataType, instanceValue);
			case TermsuiteuiPackage.ESIMILARITY_MEASURE:
				return convertESimilarityMeasureToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECorporaList createECorporaList() {
		ECorporaListImpl eCorporaList = new ECorporaListImpl();
		return eCorporaList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECorpus createECorpus() {
		ECorpusImpl eCorpus = new ECorpusImpl();
		return eCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESingleLanguageCorpus createESingleLanguageCorpus() {
		ESingleLanguageCorpusImpl eSingleLanguageCorpus = new ESingleLanguageCorpusImpl();
		return eSingleLanguageCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDocument createEDocument() {
		EDocumentImpl eDocument = new EDocumentImpl();
		return eDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipeline createEPipeline() {
		EPipelineImpl ePipeline = new EPipelineImpl();
		return ePipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipelineList createEPipelineList() {
		EPipelineListImpl ePipelineList = new EPipelineListImpl();
		return ePipelineList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETerminology createETerminology() {
		ETerminologyImpl eTerminology = new ETerminologyImpl();
		return eTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETerminoViewerConfig createETerminoViewerConfig() {
		ETerminoViewerConfigImpl eTerminoViewerConfig = new ETerminoViewerConfigImpl();
		return eTerminoViewerConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EResource createEResource() {
		EResourceImpl eResource = new EResourceImpl();
		return eResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETaggerConfig createETaggerConfig() {
		ETaggerConfigImpl eTaggerConfig = new ETaggerConfigImpl();
		return eTaggerConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBilingualDictionary createEBilingualDictionary() {
		EBilingualDictionaryImpl eBilingualDictionary = new EBilingualDictionaryImpl();
		return eBilingualDictionary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETerminoFilter createETerminoFilter() {
		ETerminoFilterImpl eTerminoFilter = new ETerminoFilterImpl();
		return eTerminoFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELang createELangFromString(EDataType eDataType, String initialValue) {
		ELang result = ELang.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertELangToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETagger createETaggerFromString(EDataType eDataType, String initialValue) {
		ETagger result = ETagger.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertETaggerToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFilteringMode createEFilteringModeFromString(EDataType eDataType, String initialValue) {
		EFilteringMode result = EFilteringMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEFilteringModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOccurrenceMode createEOccurrenceModeFromString(EDataType eDataType, String initialValue) {
		EOccurrenceMode result = EOccurrenceMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEOccurrenceModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAssocMeasure createEAssocMeasureFromString(EDataType eDataType, String initialValue) {
		EAssocMeasure result = EAssocMeasure.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEAssocMeasureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESimilarityMeasure createESimilarityMeasureFromString(EDataType eDataType, String initialValue) {
		ESimilarityMeasure result = ESimilarityMeasure.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertESimilarityMeasureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermsuiteuiPackage getTermsuiteuiPackage() {
		return (TermsuiteuiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TermsuiteuiPackage getPackage() {
		return TermsuiteuiPackage.eINSTANCE;
	}

} //TermsuiteuiFactoryImpl
