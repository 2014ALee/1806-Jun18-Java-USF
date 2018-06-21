package com.revature;

public class StringDriver {

	
	
	public static void main(String[] args) {
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		//modifying a string's value will reference a new object; this is reflected in the .hashcode() of the objects
		System.out.println("string 1 hashcode = " + string1.hashCode());
		System.out.println("string 2 hashcode = " + string2.hashCode());	
		
		
		//this string is created on the heap since we used the new keyword
		String string3 = new String("I'm a string!");
		
		string1 = string1 + "!";
		System.out.println("string 1 hashcode = " + string1.hashCode());
		System.out.println("string 2 hashcode = " + string2.hashCode());	
		
		/*
		 * Stringbuilders
		 * 
		 * -mutable
		 * -not thread-safe
		 */
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");
		
		System.out.println("stringBuilder1 hashcode = " + stringBuilder1.hashCode());
		System.out.println("stringBuilder2 hashcode = " + stringBuilder2.hashCode());		
		System.out.println("stringBuilder1.equals(stringBuilder2) = " + stringBuilder1.equals(stringBuilder2));
		
		//when converted into Strings, their hashcodes will be equal, but they will not point to the same object in memory
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		
		//this doesn't change the original string value unless string2 is reassigned
		System.out.println(string2);
		string2.toUpperCase();
		
		
		//StringBuilder objects are mutable, so appending to them will change the object
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);		
		stringBuilder3.append(", world!");
		System.out.println(stringBuilder3);
		
		
		
		
		
	}
	
}
