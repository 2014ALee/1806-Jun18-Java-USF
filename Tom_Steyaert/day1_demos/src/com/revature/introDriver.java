package com.revature;
/*
 * a package is a namespace that organizes a set of related classes and interfaceas
 */


public class introDriver {

//primitive data types with upper limits
	byte myByte = 127;
	short mtShort = 3_2767;
	int myInt = 1_1;
	
	public static void main(String[] args) {
		
		System.out.println("hello world");
		
		long myLong2 = 345345L;
		float myFloat2= 2.4534F;
		double myDouble = 45.2342342D;
		char myChar = 's';
		boolean myBoolean=true;
		 
		System.out.println("byte min value: "+Byte.MIN_VALUE);
		System.out.println("byte max value: "+Byte.MAX_VALUE);
		
		/*
		 * autoboxing/unboxing
		 */
		
		
		Character autoboxedChar = 'a';
		
		
		Integer[] myIntegerList = new Integer[4];
		for(int i=0;i<myIntegerList.length;i++) {
			myIntegerList[i]=i;
			System.out.println(i);			
		}
		
	}
	
	
}
