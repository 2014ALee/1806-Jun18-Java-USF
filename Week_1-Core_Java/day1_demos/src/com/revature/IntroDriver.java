/*
 * A package is a namespace that organizes a set of related classes 
 * and interfaces. Conceptually you can think of packages as being 
 * similar to different folders on your computer.
 */
package com.revature;

public class IntroDriver {
	
	/*
	 * Primitive data types
	 */
	
	byte myByte = 127;
	short myShort = 32757;
	int myInt = 76_543_678;//underscore has no meaning, still 76 million
	long myLong = 3453456L;
	
	float myFloat = 3.14159f;
	double myDouble = 45.2342342d;
	
	char myChar = 'a';
	
	boolean myBoolean = true;
	
	/*
	 * A main class is needed and as to be public 
	 * static allows the class to be invoked without an instance of it
	 */
	public static void main(String[] args) {
		int myOtherInt = 123_456_789;
		
		System.out.println("Hello, World!");
		System.out.print("this is a statement\n");
		System.out.println("second statement");
		
		System.out.println(myOtherInt);
		
		System.out.println("byte, minimu value: " + Byte.MIN_VALUE);
		System.out.println("byte, maximum value: " + Byte.MAX_VALUE);
		
		System.out.println("short, minimum value: " + Short.MIN_VALUE);
		System.out.println("short, maximum value: " + Short.MAX_VALUE);
		
		System.out.println("long, minimum value: " + Long.MIN_VALUE);
		System.out.println("long, maximum value: " + Long.MAX_VALUE);
		
		/*
		 * Autoboxing/Unboxing
		 */
		
		Character autoboxedChar = 'a';
		System.out.println(autoboxedChar);
		
		Integer[] myIntegerList = new Integer [4];
		for (int i = 0; i < 4; i++)
		{
			myIntegerList[i] = i;
		}
	}
}
