/*
 * A package is a namespace that organzies a set of related classes and
 * interfaces. Conceptually you can think of packages as being similar to
 * different folders on your computer.
 */
package com.revature;

public class IntroDriver {

	/*
	 * Primititve data types
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
		int myOtherInt = 76_543_678;
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
