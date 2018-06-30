/*
 * A package is a namespace that organizes a set of related classes and
 * interfaces. Conceptually you can think of packages as being similar
 * to different folders on your computer.
 */
package com.revature;

public class IntroDriver {
	/*
	 * Primitive data types
	 * 
	 * The Java programming language is statically-typed, which means that
	 * all variables must first be declared before they can be used. This
	 * involves stating the variable's type and name.
	 * 
	 * Types:
	 * 				byte, short, int, long, float, double, char, boolean
	 */
	/*
	 * You can place underscores only between digits; you cannot place
	 * underscores in the following places:
	 * 				+ At the beginning or end of a number
	 * 				+ Adjacent to a decimal point in a floating point literal
	 * 				+ Prior to an F or L suffix
	 * 				+ In positions where a string of digits is expected
	 */
	/*
	 * Literal suffixes
	 * 
	 * For the long, float, and double primitive types, literal suffixes
	 * should be appended to these in order to distinguish them from int
	 * literals.
	 */
	byte myByte = 127;
	short myShort = 32767;
	int myInt = 76_543_678; // Underscores have no meaning in this case, only readability
	long myLong = 3453456L; // L = long literal (in case Java tries to handle it as an int)

	float myFloat = 3.14149f; // as L above, Java might handle it like a double
	double myDouble = 45.234342d; // as f and d

	char myChar = 5; // or 'a' in single quotes ("" = String)

	boolean myBoolean = true;

	public static void main(String[] args) {
		// local variable declaration
		byte byteValue;
		
		// variable initialization
		byteValue = 8;
		
		// local variable declaration and initialization
		int myOtherInt = 76_543_678;
		
		/*
		 * System is a class, like String, that is provided within the java.lang package -
		 * so we do not have to import it to use it. The System class contains several useful
		 * static methods (see Person.java for insight on static methods) that can be invoked
		 * for our uses. Here we are using the 'out' class variable (which is of type PrintStream),
		 * and then invoking the println and print commands on that object to print text to the
		 * console.
		 */
		
		System.out.println(myOtherInt);

		System.out.println("byte, minimum value: " + Byte.MAX_VALUE);
		System.out.println("byte, maximum value: " + Byte.MIN_VALUE);

		System.out.println("short, minimum value: " + Short.MAX_VALUE);
		System.out.println("short, maximum value: " + Short.MIN_VALUE);

		System.out.println("int, minimum value: " + Integer.MAX_VALUE);
		System.out.println("int, maximum value: " + Integer.MIN_VALUE);

		System.out.println("long, minimum value: " + Long.MAX_VALUE);
		System.out.println("long, maximum value: " + Long.MIN_VALUE);

		System.out.println("boolean, logicalXor(true,true): " + Boolean.logicalXor(true, true));

		/*
		 * Autoboxing/Unboxing 
		 */
		Character autoboxedChar = 'a';
		System.out.println(autoboxedChar); // Get the object itself. invokes toString (println).

		Integer[] myIntegerList = new Integer [4];
		for(int i = 0; i < 4; i++) {
			myIntegerList[i] = i;
		}
	}
}