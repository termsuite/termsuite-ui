/**
 */
package fr.univnantes.termsuite.ui.model.termsuiteui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EOccurrence Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.univnantes.termsuite.ui.model.termsuiteui.TermsuiteuiPackage#getEOccurrenceMode()
 * @model
 * @generated
 */
public enum EOccurrenceMode implements Enumerator {
	/**
	 * The '<em><b>KEEP IN MEMORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEEP_IN_MEMORY_VALUE
	 * @generated
	 * @ordered
	 */
	KEEP_IN_MEMORY(0, "KEEP_IN_MEMORY", "KEEP_IN_MEMORY"),

	/**
	 * The '<em><b>KEEP IN FILESYSTEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEEP_IN_FILESYSTEM_VALUE
	 * @generated
	 * @ordered
	 */
	KEEP_IN_FILESYSTEM(1, "KEEP_IN_FILESYSTEM", "KEEP_IN_FILESYSTEM"),

	/**
	 * The '<em><b>DO NOT KEEP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DO_NOT_KEEP_VALUE
	 * @generated
	 * @ordered
	 */
	DO_NOT_KEEP(2, "DO_NOT_KEEP", "DO_NOT_KEEP");

	/**
	 * The '<em><b>KEEP IN MEMORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KEEP IN MEMORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KEEP_IN_MEMORY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KEEP_IN_MEMORY_VALUE = 0;

	/**
	 * The '<em><b>KEEP IN FILESYSTEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KEEP IN FILESYSTEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KEEP_IN_FILESYSTEM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KEEP_IN_FILESYSTEM_VALUE = 1;

	/**
	 * The '<em><b>DO NOT KEEP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DO NOT KEEP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DO_NOT_KEEP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DO_NOT_KEEP_VALUE = 2;

	/**
	 * An array of all the '<em><b>EOccurrence Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EOccurrenceMode[] VALUES_ARRAY =
		new EOccurrenceMode[] {
			KEEP_IN_MEMORY,
			KEEP_IN_FILESYSTEM,
			DO_NOT_KEEP,
		};

	/**
	 * A public read-only list of all the '<em><b>EOccurrence Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EOccurrenceMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EOccurrence Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOccurrenceMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EOccurrenceMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EOccurrence Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOccurrenceMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EOccurrenceMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EOccurrence Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EOccurrenceMode get(int value) {
		switch (value) {
			case KEEP_IN_MEMORY_VALUE: return KEEP_IN_MEMORY;
			case KEEP_IN_FILESYSTEM_VALUE: return KEEP_IN_FILESYSTEM;
			case DO_NOT_KEEP_VALUE: return DO_NOT_KEEP;
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
	private EOccurrenceMode(int value, String name, String literal) {
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
	
} //EOccurrenceMode
