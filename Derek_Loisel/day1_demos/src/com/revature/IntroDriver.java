/*
 * A package is a namespace that organizes a set of related classes and
 * interfaces. Conceptually you can think of packages as being similar to
 * different folders on your computer.
 */
package com.revature;

public class IntroDriver {
	
	/*
	 * Primitive data types
	 */
	
	byte myByte = 127;
	short myShort = 32_767;
	int myInt = 76_543_678;
	long myLong = 3453456L;
	
	float myFloat = 3.14159f;
	double myDouble = 45.23423d;
	
	char myChar = 'a';
	
	boolean myBoolean = true;
	
	public static void main(String[] args) {
		
		int myOtherInt = 123_456_789;
		
		System.out.println("Hello, World!");
		System.out.print("this is another statement");
		System.out.print(" this is on the same line\n");
		
		System.out.println(myOtherInt);
		
		System.out.println("byte, minimum value: " + Byte.MIN_VALUE);
		System.out.println("byte, maximum value: " + Byte.MAX_VALUE);
		
		System.out.println("char, maximum value: " + Character.MAX_VALUE);
		
		System.out.println("boolean, logicalXor(true, true): " + Boolean.logicalXor(true,  true));
		
		/*
		 * Autoboxing/Unboxing
		 */
		Character autoboxedChar = 'a';
		System.out.println(autoboxedChar);
		
		Integer[] myIntegerList = new Integer [4];
		for(int i = 0; i < 4; i++) {
			myIntegerList[i] = i;
		}
	}

}