/*
 * A package is a namescape that organizes a set of related classes
 * and interfaces. Conceptually you can think of packages as being 
 * similar to different folders on your computer.
 */
package com.revature;

public class IntroDriver {
	/*
	 * Primitive data types
	 */
	byte myByte 		= 127;
	short myShort 		= 32767;
	int myInt 			= 2147483647;
	int myInt1 			= 76_543_678;
	long myLong 		= 345325324;
	
	float myFloat 		= 3.14159f;
	double myDouble 	= 45.32321d;
	
	char myChar 		= 'a';
	
	boolean myBoolean 	= true;
	
	
	
	public static void main(String[] args) {
		int myOtherInt = 123_123_456;
		System.out.println("Hello, World!");
		System.out.print("test\n");
		
		System.out.println(myOtherInt);
		System.out.println("byte,minimum value: " + Byte.MIN_VALUE);
		System.out.println("byte,maximum value: " + Byte.MAX_VALUE);
	
		/*
		 * Autoboxing/Unboxing
		 */
		Character autoboxedChar = 'a';
		System.out.println(autoboxedChar);
		
		Integer[] myIntegerList = new Integer [4];
		for(int i = 0; i < 4;i++) {
			myIntegerList[i] = i;
		}
	
	}
}
