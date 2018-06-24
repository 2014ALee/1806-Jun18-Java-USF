package com.revature;

public class StringDriver {

	public static void main(String[] args) {
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		//modifying a string's value references a new object, this is reflected in the .hashCode() of the objects.
		System.out.println("string1 hashcode = "+ string1.hashCode());
		System.out.println("string1 hashcode = "+ string2.hashCode());
		
		//using the 'new' keyword tells java to put the new string in the heap rather 
		String string3 = new String("I'm a string!"); //than being pointed to/put in the string pool.
		
		System.out.println("string1 == string2: "+(string1 == string2));
		System.out.println("string1.equals(string2): " +string1.equals(string2));
		
		/*
		 * StringBuilders
		 * 
		 * -mutable
		 * -not thread-safe
		 * 
		 * StringBuffer
		 * -mutable
		 * -thread-safe
		 */
		
		//must say new StringBuilder when making a stringbuilder.
		StringBuilder stringBuilder1 = new StringBuilder ("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder ("I'm a string builder object!");
		
		System.out.println("stringbuilder1 hashcode: " + stringBuilder1.hashCode());
		System.out.println("stringbuilder2 hashcode: " + stringBuilder2.hashCode());
		System.out.println("stringBuilder1.equals(stringbuilder2): " + stringBuilder1.equals(stringBuilder2));
		
		//when converted to a string, Stringbuilders will have the same hashCode, but they will not be the same.
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		
		System.out.println(stringBuilder1.toString() == stringBuilder2.toString());
		System.out.println(string1 == string2);
		
		//Executing methods on Strings without capturing their return does not change them.
		System.out.println(string2);
		string2.toUpperCase();
		System.out.println(string2);
		
		//Since StringBuilder objects are mutable, appending to it will change the original objects
		//StringBuilder stringBuilder3
	}
}
