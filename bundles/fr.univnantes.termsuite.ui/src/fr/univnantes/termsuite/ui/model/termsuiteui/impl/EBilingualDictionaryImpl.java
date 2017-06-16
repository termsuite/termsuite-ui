/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import fr.univnantes.termsuite.ui.model.termsuiteui.EBilingualDictionary;
import fr.univnantes.termsuite.ui.model.termsuiteui.ELang;
import fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EBilingual Dictionary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EBilingualDictionaryImpl#getSourceLang <em>Source Lang</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EBilingualDictionaryImpl#getTargetLang <em>Target Lang</em>}</li>
 *   <li>{@link fr.univnantes.termsuite.ui.model.termsuiteui.impl.EBilingualDictionaryImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EBilingualDictionaryImpl extends MinimalEObjectImpl.Container implements EBilingualDictionary {
	/**
	 * The default value of the '{@link #getSourceLang() <em>Source Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLang()
	 * @generated
	 * @ordered
	 */
	protected static final ELang SOURCE_LANG_EDEFAULT = ELang.FR;

	/**
	 * The cached value of the '{@link #getSourceLang() <em>Source Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLang()
	 * @generated
	 * @ordered
	 */
	protected ELang sourceLang = SOURCE_LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetLang() <em>Target Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLang()
	 * @generated
	 * @ordered
	 */
	protected static final ELang TARGET_LANG_EDEFAULT = ELang.FR;

	/**
	 * The cached value of the '{@link #getTargetLang() <em>Target Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLang()
	 * @generated
	 * @ordered
	 */
	protected ELang targetLang = TARGET_LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EBilingualDictionaryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermsuiteuiPackage.Literals.EBILINGUAL_DICTIONARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELang getSourceLang() {
		return sourceLang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceLang(ELang newSourceLang) {
		ELang oldSourceLang = sourceLang;
		sourceLang = newSourceLang == null ? SOURCE_LANG_EDEFAULT : newSourceLang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EBILINGUAL_DICTIONARY__SOURCE_LANG, oldSourceLang, sourceLang));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELang getTargetLang() {
		return targetLang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetLang(ELang newTargetLang) {
		ELang oldTargetLang = targetLang;
		targetLang = newTargetLang == null ? TARGET_LANG_EDEFAULT : newTargetLang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EBILINGUAL_DICTIONARY__TARGET_LANG, oldTargetLang, targetLang));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TermsuiteuiPackage.EBILINGUAL_DICTIONARY__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__SOURCE_LANG:
				return getSourceLang();
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__TARGET_LANG:
				return getTargetLang();
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__PATH:
				return getPath();
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
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__SOURCE_LANG:
				setSourceLang((ELang)newValue);
				return;
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__TARGET_LANG:
				setTargetLang((ELang)newValue);
				return;
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__PATH:
				setPath((String)newValue);
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
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__SOURCE_LANG:
				setSourceLang(SOURCE_LANG_EDEFAULT);
				return;
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__TARGET_LANG:
				setTargetLang(TARGET_LANG_EDEFAULT);
				return;
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__PATH:
				setPath(PATH_EDEFAULT);
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
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__SOURCE_LANG:
				return sourceLang != SOURCE_LANG_EDEFAULT;
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__TARGET_LANG:
				return targetLang != TARGET_LANG_EDEFAULT;
			case TermsuiteuiPackage.EBILINGUAL_DICTIONARY__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
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
		result.append(" (sourceLang: ");
		result.append(sourceLang);
		result.append(", targetLang: ");
		result.append(targetLang);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //EBilingualDictionaryImpl
