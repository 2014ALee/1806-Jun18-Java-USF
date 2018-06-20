package com.revature;

public class StringDriver {
	
	public static void main(String[] args) {
		String str1 = "hi";
		String str2 = "hi";
		String str3 = new String("hi");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		str2 = "hello";
		
		System.out.println(str1.equals(str3));
		
		//replaceAll
		String test = "Here is my test. Isn't it cool.";
		test = test.replaceAll(" ", "_");
		System.out.println(test);
		
		//charAt
		String original = "original string";
		System.out.println(original.charAt(1));
		
		
		String crazy = "CrAzY CaSe";
		//lowercase
		crazy = crazy.toLowerCase();
		System.out.println(crazy);
		
		//uppercase
		crazy = crazy.toUpperCase();
		System.out.println(crazy);
		
		//String Builder
		/*
		 * Builder and buffer mutable versions of strings
		 */
		
		StringBuilder strBuilder1 = new StringBuilder("My String Builder Object");
		StringBuilder strBuilder2 = new StringBuilder("My String Builder Object");
		System.out.println(strBuilder1 == strBuilder2); //false
		System.out.println(strBuilder1.equals(strBuilder2)); //false. .equals is not overridden
	}

}
