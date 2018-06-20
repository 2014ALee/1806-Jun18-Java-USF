package com.revature;

public class StringDriver {

	public static void main(String[] args) {
		
		String str1 = "hi";
		String str2 = "hi";
		String str3 = new String("hi");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);

		str2 = "Hello";
		
		System.out.println(str1.equals(str3)); // .equals test the actual value of the strings
		
		// replaceAll
		String test = "Hi how are you?";
		test.replaceAll(" ", "_");// this won't work, string is immutable. can print or assign tho

		// ends with
		
		String mystr = "running";
		boolean endsWithING = mystr.endsWith(ing);
		System.out.println(endsWithING);
		
		/*
		 * StringBuilder
		 * 
		 */
		StringBuilder strbldr1 = new StringBuilder("My STring Builder Object");
		StringBuilder strbldr2 = new StringBuilder("My STring Builder Object");
		
		// These are two different object with the stringbuilder class
		System.out.println(strbldr1 == strbldr2);
		System.out.println(strbldr1.equals(strbldr2));
		
	}

}
