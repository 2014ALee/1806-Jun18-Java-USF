package com.revature;

public class StringDriver {

	
	public static void main(String[] args) {
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		//modifying a string's value will reference a new object; this is reflected in
		//the .hashcode() of the objects
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		//this string is created on the heap since we used the 'new' keyword
		String string3 = new String("I'm a string!");
		
		string1 = string1 + "!";
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		System.out.println("string1 == string2: " + (string1 == string2));
		System.out.println("string1.equals(string2): " + string1.equals(string2));
	
		/*
		 * StringBuilders
		 * 
		 *  - mutable
		 *  - not thread-safe
		 *  
		 */
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");
		
		System.out.println("stringbuilder1 hashCode = " + stringBuilder1.hashCode());
		System.out.println("stringbuilder2 hashCode = " + stringBuilder2.hashCode());
		System.out.println("stringbuilder2.equals(stringBuilder1) = " + stringBuilder2.equals(stringBuilder1));
		
		//When converted into Strings, their hashCodes will be equal
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		//but they will NOT point to the same object in memory
		
		//Executing methods on Strings without capturing their return does not change the original String value
		System.out.println(string2);
		string2.toUpperCase();
		System.out.println(string2);
		
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(", world!");
		System.out.println(stringBuilder3);
		
		//StringBuffer all the same methods as StringBuilder but they are thread safe
		
	}
	
}
