/*
 * A package is just a namespace that organizes a set of related classes and interfaces
 * Conceptually, you can think of packages as being similar to different folders on your
 * computer.
 */


package com.revature;

public class IntroDriver {

	/* 
	 * primitive data types
	 */
	
	byte myByte = 127;
	short myShort = 32_767;
	int myInt = 76_543_678;
	long myLong = 3453456L;
	float myFloat = 3.14159f;
	double myDouble = 45.83748743D;
	char mychar = 'r';
	boolean myBoolean = true;
			
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		
		// Wrapper classes
		System.out.println("byte, minimum value: " + Byte.MIN_VALUE);
		System.out.println("byte, maximum value: " + Byte.MAX_VALUE);
		
		System.out.println("boolean, logicalxor: " + Boolean.logicalXor(true, true));
		
		/*
		 * Autoboxing/Unboxing
		 */
		
		Character autoboxedChar = 'a'; 
		// Autoboxing: JVM will treat this as a Character object
		
		Integer[] myIntegerList = new Integer [4];
		for(int i = 0; i < 4; i++) {
			myIntegerList[i] = i;
		}
		// Unboxing: goes from Integer object to int
		
		
		
		
		
		
		
		
		
		
	}
}
