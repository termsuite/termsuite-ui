/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.univnantes.termsuite.ui.model.termsuiteui.EAssocMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.EOccurrenceMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.EPipeline;
import fr.univnantes.termsuite.ui.model.termsuiteui.ESimilarityMeasure;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isContextualizerEnabled <em>Contextualizer Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getOccurrenceMode <em>Occurrence Mode</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getTaggerConfigName <em>Tagger Config Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getMaxNumTermsMemory <em>Max Num Terms Memory</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getContextScope <em>Context Scope</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getContextAssocMeasure <em>Context Assoc Measure</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isSemEnabled <em>Sem Enabled</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getSemMeasure <em>Sem Measure</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#isSemDicoOnly <em>Sem Dico Only</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getSemNumCandidates <em>Sem Num Candidates</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EPipelineImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EPipelineImpl extends EResourceImpl implements EPipeline {
	/**
	 * The default value of the '{@link #isContextualizerEnabled() <em>Contextualizer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextualizerEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTEXTUALIZER_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContextualizerEnabled() <em>Contextualizer Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContextualizerEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean contextualizerEnabled = CONTEXTUALIZER_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOccurrenceMode() <em>Occurrence Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurrenceMode()
	 * @generated
	 * @ordered
	 */
	protected static final EOccurrenceMode OCCURRENCE_MODE_EDEFAULT = EOccurrenceMode.KEEP_IN_MEMORY;

	/**
	 * The cached value of the '{@link #getOccurrenceMode() <em>Occurrence Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurrenceMode()
	 * @generated
	 * @ordered
	 */
	protected EOccurrenceMode occurrenceMode = OCCURRENCE_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaggerConfigName() <em>Tagger Config Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaggerConfigName()
	 * @generated
	 * @ordered
	 */
	protected static final String TAGGER_CONFIG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaggerConfigName() <em>Tagger Config Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaggerConfigName()
	 * @generated
	 * @ordered
	 */
	protected String taggerConfigName = TAGGER_CONFIG_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected ETerminoFilter filter;

	/**
	 * The default value of the '{@link #getMaxNumTermsMemory() <em>Max Num Terms Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNumTermsMemory()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_NUM_TERMS_MEMORY_EDEFAULT = 500000;

	/**
	 * The cached value of the '{@link #getMaxNumTermsMemory() <em>Max Num Terms Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNumTermsMemory()
	 * @generated
	 * @ordered
	 */
	protected int maxNumTermsMemory = MAX_NUM_TERMS_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextScope() <em>Context Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextScope()
	 * @generated
	 * @ordered
	 */
	protected static final int CONTEXT_SCOPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getContextScope() <em>Context Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextScope()
	 * @generated
	 * @ordered
	 */
	protected int contextScope = CONTEXT_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContextAssocMeasure() <em>Context Assoc Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextAssocMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final EAssocMeasure CONTEXT_ASSOC_MEASURE_EDEFAULT = EAssocMeasure.MUTUAL_INFORMATION;

	/**
	 * The cached value of the '{@link #getContextAssocMeasure() <em>Context Assoc Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextAssocMeasure()
	 * @generated
	 * @ordered
	 */
	protected EAssocMeasure contextAssocMeasure = CONTEXT_ASSOC_MEASURE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSemEnabled() <em>Sem Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSemEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEM_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSemEnabled() <em>Sem Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSemEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean semEnabled = SEM_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSemMeasure() <em>Sem Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final ESimilarityMeasure SEM_MEASURE_EDEFAULT = ESimilarityMeasure.COSINE;

	/**
	 * The cached value of the '{@link #getSemMeasure() <em>Sem Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemMeasure()
	 * @generated
	 * @ordered
	 */
	protected ESimilarityMeasure semMeasure = SEM_MEASURE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSemDicoOnly() <em>Sem Dico Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSemDicoOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEM_DICO_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSemDicoOnly() <em>Sem Dico Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSemDicoOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean semDicoOnly = SEM_DICO_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSemNumCandidates() <em>Sem Num Candidates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemNumCandidates()
	 * @generated
	 * @ordered
	 */
	protected static final int SEM_NUM_CANDIDATES_EDEFAULT = 5;

	/**
	 * The cached value of the '{@link #getSemNumCandidates() <em>Sem Num Candidates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemNumCandidates()
	 * @generated
	 * @ordered
	 */
	protected int semNumCandidates = SEM_NUM_CANDIDATES_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPipelineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.EPIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContextualizerEnabled() {
		return contextualizerEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextualizerEnabled(boolean newContextualizerEnabled) {
		boolean oldContextualizerEnabled = contextualizerEnabled;
		contextualizerEnabled = newContextualizerEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED, oldContextualizerEnabled, contextualizerEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOccurrenceMode getOccurrenceMode() {
		return occurrenceMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccurrenceMode(EOccurrenceMode newOccurrenceMode) {
		EOccurrenceMode oldOccurrenceMode = occurrenceMode;
		occurrenceMode = newOccurrenceMode == null ? OCCURRENCE_MODE_EDEFAULT : newOccurrenceMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__OCCURRENCE_MODE, oldOccurrenceMode, occurrenceMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getContextScope() {
		return contextScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextScope(int newContextScope) {
		int oldContextScope = contextScope;
		contextScope = newContextScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE, oldContextScope, contextScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAssocMeasure getContextAssocMeasure() {
		return contextAssocMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextAssocMeasure(EAssocMeasure newContextAssocMeasure) {
		EAssocMeasure oldContextAssocMeasure = contextAssocMeasure;
		contextAssocMeasure = newContextAssocMeasure == null ? CONTEXT_ASSOC_MEASURE_EDEFAULT : newContextAssocMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__CONTEXT_ASSOC_MEASURE, oldContextAssocMeasure, contextAssocMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSemEnabled() {
		return semEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemEnabled(boolean newSemEnabled) {
		boolean oldSemEnabled = semEnabled;
		semEnabled = newSemEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__SEM_ENABLED, oldSemEnabled, semEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESimilarityMeasure getSemMeasure() {
		return semMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemMeasure(ESimilarityMeasure newSemMeasure) {
		ESimilarityMeasure oldSemMeasure = semMeasure;
		semMeasure = newSemMeasure == null ? SEM_MEASURE_EDEFAULT : newSemMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__SEM_MEASURE, oldSemMeasure, semMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSemDicoOnly() {
		return semDicoOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemDicoOnly(boolean newSemDicoOnly) {
		boolean oldSemDicoOnly = semDicoOnly;
		semDicoOnly = newSemDicoOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__SEM_DICO_ONLY, oldSemDicoOnly, semDicoOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSemNumCandidates() {
		return semNumCandidates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemNumCandidates(int newSemNumCandidates) {
		int oldSemNumCandidates = semNumCandidates;
		semNumCandidates = newSemNumCandidates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__SEM_NUM_CANDIDATES, oldSemNumCandidates, semNumCandidates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTaggerConfigName() {
		return taggerConfigName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaggerConfigName(String newTaggerConfigName) {
		String oldTaggerConfigName = taggerConfigName;
		taggerConfigName = newTaggerConfigName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME, oldTaggerConfigName, taggerConfigName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETerminoFilter getFilter() {
		if (filter != null && filter.eIsProxy()) {
			InternalEObject oldFilter = (InternalEObject)filter;
			filter = (ETerminoFilter)eResolveProxy(oldFilter);
			if (filter != oldFilter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TermsuiteuiPackage.EPIPELINE__FILTER, oldFilter, filter));
			}
		}
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETerminoFilter basicGetFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(ETerminoFilter newFilter) {
		ETerminoFilter oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__FILTER, oldFilter, filter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxNumTermsMemory() {
		return maxNumTermsMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxNumTermsMemory(int newMaxNumTermsMemory) {
		int oldMaxNumTermsMemory = maxNumTermsMemory;
		maxNumTermsMemory = newMaxNumTermsMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EPIPELINE__MAX_NUM_TERMS_MEMORY, oldMaxNumTermsMemory, maxNumTermsMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				return isContextualizerEnabled();
			case TermsuiteuiPackage.EPIPELINE__OCCURRENCE_MODE:
				return getOccurrenceMode();
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				return getTaggerConfigName();
			case TermsuiteuiPackage.EPIPELINE__FILTER:
				if (resolve) return getFilter();
				return basicGetFilter();
			case TermsuiteuiPackage.EPIPELINE__MAX_NUM_TERMS_MEMORY:
				return getMaxNumTermsMemory();
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				return getContextScope();
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ASSOC_MEASURE:
				return getContextAssocMeasure();
			case TermsuiteuiPackage.EPIPELINE__SEM_ENABLED:
				return isSemEnabled();
			case TermsuiteuiPackage.EPIPELINE__SEM_MEASURE:
				return getSemMeasure();
			case TermsuiteuiPackage.EPIPELINE__SEM_DICO_ONLY:
				return isSemDicoOnly();
			case TermsuiteuiPackage.EPIPELINE__SEM_NUM_CANDIDATES:
				return getSemNumCandidates();
			case TermsuiteuiPackage.EPIPELINE__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				setContextualizerEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__OCCURRENCE_MODE:
				setOccurrenceMode((EOccurrenceMode)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				setTaggerConfigName((String)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTER:
				setFilter((ETerminoFilter)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__MAX_NUM_TERMS_MEMORY:
				setMaxNumTermsMemory((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				setContextScope((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ASSOC_MEASURE:
				setContextAssocMeasure((EAssocMeasure)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_ENABLED:
				setSemEnabled((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_MEASURE:
				setSemMeasure((ESimilarityMeasure)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_DICO_ONLY:
				setSemDicoOnly((Boolean)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_NUM_CANDIDATES:
				setSemNumCandidates((Integer)newValue);
				return;
			case TermsuiteuiPackage.EPIPELINE__NAME:
				setName((String)newValue);
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
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				setContextualizerEnabled(CONTEXTUALIZER_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__OCCURRENCE_MODE:
				setOccurrenceMode(OCCURRENCE_MODE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				setTaggerConfigName(TAGGER_CONFIG_NAME_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__FILTER:
				setFilter((ETerminoFilter)null);
				return;
			case TermsuiteuiPackage.EPIPELINE__MAX_NUM_TERMS_MEMORY:
				setMaxNumTermsMemory(MAX_NUM_TERMS_MEMORY_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				setContextScope(CONTEXT_SCOPE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ASSOC_MEASURE:
				setContextAssocMeasure(CONTEXT_ASSOC_MEASURE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_ENABLED:
				setSemEnabled(SEM_ENABLED_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_MEASURE:
				setSemMeasure(SEM_MEASURE_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_DICO_ONLY:
				setSemDicoOnly(SEM_DICO_ONLY_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__SEM_NUM_CANDIDATES:
				setSemNumCandidates(SEM_NUM_CANDIDATES_EDEFAULT);
				return;
			case TermsuiteuiPackage.EPIPELINE__NAME:
				setName(NAME_EDEFAULT);
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
			case TermsuiteuiPackage.EPIPELINE__CONTEXTUALIZER_ENABLED:
				return contextualizerEnabled != CONTEXTUALIZER_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__OCCURRENCE_MODE:
				return occurrenceMode != OCCURRENCE_MODE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__TAGGER_CONFIG_NAME:
				return TAGGER_CONFIG_NAME_EDEFAULT == null ? taggerConfigName != null : !TAGGER_CONFIG_NAME_EDEFAULT.equals(taggerConfigName);
			case TermsuiteuiPackage.EPIPELINE__FILTER:
				return filter != null;
			case TermsuiteuiPackage.EPIPELINE__MAX_NUM_TERMS_MEMORY:
				return maxNumTermsMemory != MAX_NUM_TERMS_MEMORY_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_SCOPE:
				return contextScope != CONTEXT_SCOPE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__CONTEXT_ASSOC_MEASURE:
				return contextAssocMeasure != CONTEXT_ASSOC_MEASURE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__SEM_ENABLED:
				return semEnabled != SEM_ENABLED_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__SEM_MEASURE:
				return semMeasure != SEM_MEASURE_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__SEM_DICO_ONLY:
				return semDicoOnly != SEM_DICO_ONLY_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__SEM_NUM_CANDIDATES:
				return semNumCandidates != SEM_NUM_CANDIDATES_EDEFAULT;
			case TermsuiteuiPackage.EPIPELINE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (contextualizerEnabled: ");
		result.append(contextualizerEnabled);
		result.append(", occurrenceMode: ");
		result.append(occurrenceMode);
		result.append(", taggerConfigName: ");
		result.append(taggerConfigName);
		result.append(", maxNumTermsMemory: ");
		result.append(maxNumTermsMemory);
		result.append(", contextScope: ");
		result.append(contextScope);
		result.append(", contextAssocMeasure: ");
		result.append(contextAssocMeasure);
		result.append(", semEnabled: ");
		result.append(semEnabled);
		result.append(", semMeasure: ");
		result.append(semMeasure);
		result.append(", semDicoOnly: ");
		result.append(semDicoOnly);
		result.append(", semNumCandidates: ");
		result.append(semNumCandidates);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EPipelineImpl
