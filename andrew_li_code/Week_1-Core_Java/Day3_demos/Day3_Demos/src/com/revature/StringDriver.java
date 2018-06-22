package com.revature;

public class StringDriver {
	public static void main(String[] args) {
		String string1 = "I\'m a string!";
		String string2 = "I\'m a string!";
		
		// Modifying a String's value will reference a new object
		// This is reflected in the .hashCode() of objects
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		// This String is created on the heap since we used the new keyword
		string1 += '!';
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		System.out.println("string1 == string2: " + (string1 == string2));
		System.out.println("string1.equals(string2): " + string1.equals(string2));
		
		
		/*
		 * StringBuilders are mutable and not thread-safe.
		 */
		String iAmAStringBuilderObject = "I\'m a string builder object!";
		StringBuilder stringbuilder1 = new StringBuilder(iAmAStringBuilderObject);
		StringBuilder stringbuilder2 = new StringBuilder(iAmAStringBuilderObject);
		System.out.println("stringbuilder1.equals(stringbuilder2)) is " 
		    + stringbuilder1.equals(stringbuilder2));
		
		System.out.println("stringbuilder1.hashCode(): " + stringbuilder1.hashCode());
		System.out.println("stringbuilder2.hashCode(): " + stringbuilder2.hashCode());
		System.out.println("stringbuilder1.toString().hashCode(): " + stringbuilder1.toString().hashCode());
		System.out.println("stringbuilder2.toString().hashCode(): " + stringbuilder2.toString().hashCode());
		
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(" World!");
		System.out.println(stringBuilder3);
	}
}
