package com.revature;

public class StringDriver {

	public static void main(String[] args) {
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		//modifying a string's value will reference a new object. This is reflected in the .hashcode() of 
		//the objects. 
		System.out.println("string1 hashcode = " + string1.hashCode());
		System.out.println("string2 hashcode = " + string2.hashCode());
		
		// this string is created on the heap since we used the new keyword
//		String string3 = new String("I'm a string!");
		
		string1 = string1 + "!";
		System.out.println("string1 hashcode = " + string1.hashCode());
		System.out.println("string2 hashcode = " + string2.hashCode());
		
		System.out.println("string1 == string2: " + (string1 == string2));
		System.out.println("string1.equals(string2): " + string1.equals(string2));
		
		System.out.println("-----------------------------------------");
		
		/*
		 * String Builders
		 * 	- mutable
		 * 	- not thread safe
		 * 
		 * String Buffers
		 * 	- mutable
		 * 	- thread safe
		 */
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");
		
		System.out.println("stringBuilder1 hashcode = " + stringBuilder1.hashCode());
		System.out.println("stringBuilder2 hashcode = " + stringBuilder2.hashCode());
		System.out.println("stringBuilder1.equals(stringBuilder2): " + stringBuilder1.equals(stringBuilder2));
		System.out.println();
		// when converted into strings, their hashcode() will be equal but they will not refer to the same string in the string pool
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());

		System.out.println("-----------------------------------------");
		
		// Executing methods on strings without capturing their return does not change the original value
		System.out.println(string2);
		string2.toUpperCase();
		System.out.println(string2);

		System.out.println("-----------------------------------------");
		
		// Since StringBuilder objects are mutable, appending to it will change to original object
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(", world!");
		System.out.println(stringBuilder3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
