/*
 * A package is a namespace that organizes a set of related classes and 
 * interfaces. Conceptually you can think of packages as being similar to
 * different folder on your computer.
 */
package com.revature;

public class IntroDriver {
	
	/*
	 * Primitive data types
	 */
	byte myByte = 127;
	short myShort = 32_767;
	int myInt = 76_543_678;
	long myLong = 4444444L; //Add a "L" to the end so it is not treated as an int.
	float myFloat = 2.34234F; //Add a "F" to the end.
	double myDouble = 3.423423444433D;
	char myChar = 'a';
	boolean myBoolean = true;
	
	
	/*
	 * Main class needed to run 
	 */
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		
		System.out.println("byte, minimum value: " + Byte.MIN_VALUE);
		System.out.println("byte, maximum value " + Byte.MAX_VALUE);
		
		System.out.println("char, maximum value " + Character.MAX_VALUE);
		
		/*
		 * Autoboxing/Unboxing
		 */
		
		Character autoboxedChar = 'a';
		
		Integer[] myIntegerList = new Integer [4];
		for(int i = 0; i < myIntegerList.length; i++) {
			myIntegerList[i] = i;
			System.out.println(i);
		}
	}
}
