/*
 * A package is a namespace that organizes a set of related classes and interfaces. Conceptually you can think 
 * of packages as being similar to different folders on a computer.
 */
package com.revature;

public class IntroDriver {
	/*
	 * Primitive data types
	 */
	
	byte myByte = 127;
	short myShort = 32767;
	int myInt = 76_543_678; //not actual upper limit
	long myLong = 3453456L; //'litteral' -a suffix character that ensures the JVM will allocate the 
							//appropriate memory for the field. The JVM may try to store it as an Int if it 
							//isnt necessary to be a long. Literal is useful if the number may increase later on.
	float myFloat = 3.141529f;
	double myDouble = 45.2342342d;
	char myChar = 'a';
	
	boolean myBoolean = true;
	
	
	public static void main(String[] args) {
		
		int myOtherInt = 76_543_678;
		System.out.println("Hello World!");
		System.out.println(myOtherInt);
		System.out.println();
		
		System.out.println("byte, minimum value: " + Byte.MIN_VALUE);
		System.out.println("byte, maximum value: " + Byte.MAX_VALUE);
		System.out.println("char, maximum value: " + Character.MAX_VALUE);
		System.out.println("boolen, logical Xor(true, false): " + Boolean.logicalXor(true, false));
		
		System.out.println("Cast myOtherInt to String: " + Integer.toString(myOtherInt));
		
		/*
		 * Autoboxing/Unboxing
		 */
		Character autoboxedChar = 'a';
		System.out.println(autoboxedChar);
		
		Integer[] myIntegerList = new Integer [4];
		for (int i = 0; i < 4; i++) {
			myIntegerList[i] = i;
		}
		
		
	}
	
}
