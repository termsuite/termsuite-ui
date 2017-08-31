/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import fr.univnantes.termsuite.ui.model.termsuiteui.EFilteringMode;
import fr.univnantes.termsuite.ui.model.termsuiteui.ETerminoFilter;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ETermino Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl#getTopN <em>Top N</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl#isKeepVariants <em>Keep Variants</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.ETerminoFilterImpl#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ETerminoFilterImpl extends MinimalEObjectImpl.Container implements ETerminoFilter {
	/**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTopN() <em>Top N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopN()
	 * @generated
	 * @ordered
	 */
	protected static final int TOP_N_EDEFAULT = 500;

	/**
	 * The cached value of the '{@link #getTopN() <em>Top N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopN()
	 * @generated
	 * @ordered
	 */
	protected int topN = TOP_N_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final double THRESHOLD_EDEFAULT = 0.9;

	/**
	 * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreshold()
	 * @generated
	 * @ordered
	 */
	protected double threshold = THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #isKeepVariants() <em>Keep Variants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeepVariants()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEEP_VARIANTS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isKeepVariants() <em>Keep Variants</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeepVariants()
	 * @generated
	 * @ordered
	 */
	protected boolean keepVariants = KEEP_VARIANTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final EFilteringMode MODE_EDEFAULT = EFilteringMode.TOP_N;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected EFilteringMode mode = MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETerminoFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.ETERMINO_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_FILTER__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTopN() {
		return topN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopN(int newTopN) {
		int oldTopN = topN;
		topN = newTopN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_FILTER__TOP_N, oldTopN, topN));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThreshold() {
		return threshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreshold(double newThreshold) {
		double oldThreshold = threshold;
		threshold = newThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_FILTER__THRESHOLD, oldThreshold, threshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKeepVariants() {
		return keepVariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeepVariants(boolean newKeepVariants) {
		boolean oldKeepVariants = keepVariants;
		keepVariants = newKeepVariants;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_FILTER__KEEP_VARIANTS, oldKeepVariants, keepVariants));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFilteringMode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(EFilteringMode newMode) {
		EFilteringMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.ETERMINO_FILTER__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.ETERMINO_FILTER__PROPERTY_NAME:
				return getPropertyName();
			case TermsuiteuiPackage.ETERMINO_FILTER__TOP_N:
				return getTopN();
			case TermsuiteuiPackage.ETERMINO_FILTER__THRESHOLD:
				return getThreshold();
			case TermsuiteuiPackage.ETERMINO_FILTER__KEEP_VARIANTS:
				return isKeepVariants();
			case TermsuiteuiPackage.ETERMINO_FILTER__MODE:
				return getMode();
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
			case TermsuiteuiPackage.ETERMINO_FILTER__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__TOP_N:
				setTopN((Integer)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__THRESHOLD:
				setThreshold((Double)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__KEEP_VARIANTS:
				setKeepVariants((Boolean)newValue);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__MODE:
				setMode((EFilteringMode)newValue);
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
			case TermsuiteuiPackage.ETERMINO_FILTER__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__TOP_N:
				setTopN(TOP_N_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__THRESHOLD:
				setThreshold(THRESHOLD_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__KEEP_VARIANTS:
				setKeepVariants(KEEP_VARIANTS_EDEFAULT);
				return;
			case TermsuiteuiPackage.ETERMINO_FILTER__MODE:
				setMode(MODE_EDEFAULT);
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
			case TermsuiteuiPackage.ETERMINO_FILTER__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case TermsuiteuiPackage.ETERMINO_FILTER__TOP_N:
				return topN != TOP_N_EDEFAULT;
			case TermsuiteuiPackage.ETERMINO_FILTER__THRESHOLD:
				return threshold != THRESHOLD_EDEFAULT;
			case TermsuiteuiPackage.ETERMINO_FILTER__KEEP_VARIANTS:
				return keepVariants != KEEP_VARIANTS_EDEFAULT;
			case TermsuiteuiPackage.ETERMINO_FILTER__MODE:
				return mode != MODE_EDEFAULT;
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
		result.append(" (propertyName: ");
		result.append(propertyName);
		result.append(", topN: ");
		result.append(topN);
		result.append(", threshold: ");
		result.append(threshold);
		result.append(", keepVariants: ");
		result.append(keepVariants);
		result.append(", mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //ETerminoFilterImpl
