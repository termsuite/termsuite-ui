/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EAssoc Measure</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEAssocMeasure()
 * @model
 * @generated
 */
public enum EAssocMeasure implements Enumerator {
	/**
	 * The '<em><b>LOG LIKELYHOOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOG_LIKELYHOOD_VALUE
	 * @generated
	 * @ordered
	 */
	LOG_LIKELYHOOD(0, "LOG_LIKELYHOOD", "LOG_LIKELYHOOD"),

	/**
	 * The '<em><b>MUTUAL INFORMATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUTUAL_INFORMATION_VALUE
	 * @generated
	 * @ordered
	 */
	MUTUAL_INFORMATION(1, "MUTUAL_INFORMATION", "MUTUAL_INFORMATION");

	/**
	 * The '<em><b>LOG LIKELYHOOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOG LIKELYHOOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOG_LIKELYHOOD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOG_LIKELYHOOD_VALUE = 0;

	/**
	 * The '<em><b>MUTUAL INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MUTUAL INFORMATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUTUAL_INFORMATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MUTUAL_INFORMATION_VALUE = 1;

	/**
	 * An array of all the '<em><b>EAssoc Measure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EAssocMeasure[] VALUES_ARRAY =
		new EAssocMeasure[] {
			LOG_LIKELYHOOD,
			MUTUAL_INFORMATION,
		};

	/**
	 * A public read-only list of all the '<em><b>EAssoc Measure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EAssocMeasure> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EAssoc Measure</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAssocMeasure get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EAssocMeasure result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EAssoc Measure</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAssocMeasure getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EAssocMeasure result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EAssoc Measure</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EAssocMeasure get(int value) {
		switch (value) {
			case LOG_LIKELYHOOD_VALUE: return LOG_LIKELYHOOD;
			case MUTUAL_INFORMATION_VALUE: return MUTUAL_INFORMATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EAssocMeasure(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EAssocMeasure
