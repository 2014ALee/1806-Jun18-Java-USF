package com.revature;

public class StringDriver {
	
	public static void main(String[] args) {
		
		String string1 = "I am a string ";
		String string2 = "I am a string ";
		
		
		// modifying a strings value will reference a new 
		// object this is reflected in the hash.Code( of the objects)
		
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		
		// This string is created on the heap sice we create a  new keyword.
		
		//String string3 = new String("I'm a string");
		
		string1 = string1 + "!";
		
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		System.out.println("string2 == string2 " + (string1  == string2));
		System.out.println("string2.equals(string2): " + string1.equals(string2));
		
		
		
		
		
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");
		
		System.out.println("stringbuilder1 hashCode = " + stringBuilder1.hashCode());
		System.out.println("stringbuilder2 hashCode = " + stringBuilder2.hashCode());
		System.out.println("stringbuilder1.equals(stringBuilder2) = " + stringBuilder1.equals(stringBuilder2));
		
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		
		System.out.println(stringBuilder1 == stringBuilder2);
		
		System.out.println(string2);
		string2.toUpperCase();
		System.out.println(string2);
		
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(", world!");
		System.out.println(stringBuilder3);
		
		
	
	
		
	}

}
