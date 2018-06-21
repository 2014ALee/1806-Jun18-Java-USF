package com.revature;

public class StringDriver {
	
	public static void main(String[] args) {
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		
		/*
		 * modifying a string's value will reference a new object; this is reflected 
		 * in the .hashCode() fo the objects 
		 */
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		// this string is created on the heap since we used the 'new' keyword
		String string3 = new String("I'm a string!");
		
		string1 = string1 + "!";
		System.out.println("string1 hashCode = " + string1.hashCode());
		System.out.println("string2 hashCode = " + string2.hashCode());
		
		System.out.println("string1 == string2 " + (string1 == string2));
		System.out.println("string1.equals(string2): " + string1.equals(string2));
		
		/*
		 * StringBuilders
		 * 
		 * - mutable
		 * - not thread-safe
		 */
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm a strein builder bject!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a strein builder bject!");
		
		System.out.println("stringbuilder1 hashCode = " + stringBuilder1.hashCode());
		System.out.println("stringbuilder2 hashCode = " + stringBuilder2.hashCode());
		System.out.println("stringbuilder1.equals(strignBuilder2) = " + stringBuilder1.hashCode());
		
		//When converted into Strings, their hasCodes will be equal
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());

		// But they will NOT point to the same object in memory
		System.out.println(stringBuilder1==stringBuilder2);
		
		/*
		 * Executing methods on Strings without capturing their return does not
		 * change the 
		 */
		System.out.println(string2);
		string2.toUpperCase();
		System.out.println(string2);
		
		//Since StringBuilder
		//StringBuilder string




		
	}

}
