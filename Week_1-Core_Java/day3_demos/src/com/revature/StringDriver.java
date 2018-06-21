package com.revature;

import java.lang.reflect.Field;

public class StringDriver {

	public static void main(String[] args) {

		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		// this string is created on the heap since we used the 'new' keyword
		String string3 = new String("I'm a string!");

		/* 
		 * modifying a string's value will reference a new object; this is reflected 
		 * in the .hashCode() of the objects
		 */
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());

		string1 = string1 + "!";
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		System.out.println("string1 == string2: " + (string1 == string2));
		System.out.println("string1.equals(string2): " + string1.equals(string2));
		
		/*
		 * StringBuilder
		 * 
		 * - mutable
		 * - not thread-safe
		 * 
		 * StringBuffer
		 * 
		 * - mutable
		 * - thread-safe
		 */
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");

		System.out.println("stringBuilder1 hashCode = " + stringBuilder1.hashCode());
		System.out.println("stringBuilder2 hashCode = " + stringBuilder2.hashCode());
		System.out.println("stringBuilder1.equals(stringBuilder2) = " + stringBuilder1.equals(stringBuilder2));
		
		// When converted into Strings, they their hashCodes will be equal
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		
		// But they will NOT point to the same object in memory
		System.out.println(stringBuilder1 == stringBuilder2);
		
		// Executing methods on Strings without capturing their return does not change the original String value
		System.out.println(string2);
		string2.toUpperCase();
		System.out.println(string2);
		
		// Since StringBuilder objects are mutable, appending to it will change the original object's value
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(", world!");
		System.out.println(stringBuilder3);
		
		System.out.println("Strings are ALWAYS immutable, right?");
		
		for(;;) {
			
		}
	}

}
