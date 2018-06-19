/*
 * A package is a namespace that organizes a set of related classes.
 */
package com.revature;

public class IntroDriver {
	
	public static void main(String[] args) {
		boolean myBool = true;
		byte myByte = 127;
		short myShort = 32767;
		char myChar = (char) 32767;
		int myInt = 2147483647;
		float myFloat = (float) 3.4028235E38;
		long myLong = 9223372036854775807L;
		double myDouble = 1.7976931348623157E308;
		
		System.out.println("Hello, World!!");
		System.out.println("My Boolean: " + myBool);
		System.out.println("My Byte: " + myByte);
		System.out.println("My Short: " + myShort);
		System.out.println("My Char: " + myChar);
		System.out.println("My Integer: " + myInt);
		System.out.println("My Float: " + myFloat);
		System.out.println("My Long: " + myLong);
		System.out.println("My Double: " + myDouble);
		System.out.println("My Byte: " + myByte);
		System.out.println("My Short: " + myShort);
		System.out.println("My Char: " + myChar);
		System.out.println("My Integer: " + myInt);
		System.out.println("My Float: " + myFloat);
		System.out.println("My Long: " + myLong);
		System.out.println("My Double: " + myDouble);
		
		/*
		 * Autoboxing/unboxing
		 */
		Character autoboxedChar = 'a';
		System.out.println(autoboxedChar);
		Object hello = new Object() {
			public String toString() {
				return "Hello";
			}
		};
		System.out.println(hello);
	}
	
}
