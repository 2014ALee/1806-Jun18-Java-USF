package com.revature;

public class StringDriver {
	
	public static void main(String[] args) {
		
		String str1 = "I'm a string.";
		String str2 = "I'm a string.";
		
		//Modifying a string's value simply creates a new string and changes the reference
		//in memory. This is reflected in the hashcode of the object.
		
		System.out.println("str1.hashCode() = " + str1.hashCode());
		System.out.println("str2.hashCode() = " + str2.hashCode());
		
		String str3 = new String("I'm a string."); //Stored in the heap but not in the string pool.
		System.out.println("str3.hashCode() = " + str3.hashCode());
		
		str1 = str1 + "!";
		
		System.out.println("str1.hashCode() = " + str1.hashCode());
		System.out.println("str2.hashCode() = " + str2.hashCode());
		
		/*
		 * String Builder
		 * 
		 * - Mutable
		 * - Not thread-safe
		 * - Cant be instantiated with string literals
		 */
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object.");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object.");
		
		//String builders do not have the same string pool functionality like regular string objects.
		System.out.println("stringBuilder1 hashCode = " + stringBuilder1.hashCode());
		System.out.println("stringBuilder2 hashCode = " + stringBuilder2.hashCode());
		System.out.println("stringBuilder1.equals(strtingBuilder2) " + stringBuilder1.equals(stringBuilder2));
		
		//Converting into strings, their hashCodes will be the same but they won't point to the same object in memory.
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		
		System.out.println("---------------------------------");
		
		//Executing methods on Strings without capturing the return values does not change the value of the string.
		System.out.println(str2);
		str2.toUpperCase();
		System.out.println(str2);
		
		System.out.println("---------------------------------");
		
		//StringBuilders are very much mutable and can be changed in place.
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(", world!");
		System.out.println(stringBuilder3);
		
		/*
		 * String Buffer
		 * 
		 * - Same functionality as string builders
		 * - Thread safe
		 */

		
	}
	

}
