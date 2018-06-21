package com.revature;

public class StringDriver {
	
	public static void main(String[] args) {
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		//modifying a strings value will reference a new object, this is reflected in the hashCodes of the objects
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		//This string is created on the heap since we used the 'new' keyword
		String string3 = new String("I'm a string!");
		
		string1 += "!";
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		//System.out.println("string3 hashCode = " + string3.hashCode());
		
		System.out.println("string1 == string2: " + (string1 == string2));
		System.out.println("string1.equals(string2): " + string1.equals(string2));
		
		/*
		 * StringBuilders
		 * 
		 * 	mutable
		 * 	not thread-safe
		 */
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");
		
		System.out.println("StringBuilder1.hashCode() = " + stringBuilder1.hashCode());
		System.out.println("StringBuilder2.hashCode() = " + stringBuilder2.hashCode());
		System.out.println("stringBuilder1 == stringBuilder2: " + (stringBuilder1 == stringBuilder2));
		
		//When converted into strings their hashCodes will be equal, but they will not point to the same object in memory
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		
		System.out.println(string2);
		string2.toUpperCase();
		System.out.println(string2);
		
		//Since string builder is mutable it will append the value to the object
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(", World!");
		System.out.println(stringBuilder3);
	}

}
