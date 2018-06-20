/*
 * Notes:
 * A package is a namespace that organizes a set of related classes and interfaces.
 * You can think of Packages like folders on your computer.
 */
package com.revature;

public class IntroDriver {

	byte myByte = 127;
	short myShort = 32767;
	int myInt = 76_543_678; //Underscores mean nothing but can help you read numbers.
	long myLong = 203948L; //the L at the end of a number signifies it as a Long.
	float myFloat = 3.14159f; //the f at the end of a number signifies it as a float.
	double myDouble = 45.1432134d; //the d at the end of a number signifies it as a double.
	char mychar = 'a';
	boolean mybool = true; //Unlike c++, boolean must be spelled out. can't just say bool.
	
	public static void main(String[] args)
	{
		int myOtherInt = 309_342_809;
		System.out.println("hello world"); //println is like endl in c++. It ends the line and starts a new one.
		System.out.print("lol this string will tell you how long an int is: ");
		System.out.println(myOtherInt);
		System.out.println("byte, minimum value: " + Byte.MIN_VALUE);
		System.out.println("byte, maximum value: " + Byte.MAX_VALUE);
		System.out.println("Long max value: " + Long.MAX_VALUE);	
	/*
	 * Autoboxing and Unboxing
	 */
	Character autoboxedChar = 'a';
	System.out.println(autoboxedChar);
	Integer[] myIntegerList = new Integer [4];
	for(int i = 0; i < 4; i++)
	{
		myIntegerList[i]=i;
	}
	}
	}
	

}
