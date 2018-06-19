package com.revature;

public class StringDriver {
	public static void main(String[] args) {
		String str1 = "hi";
		String str2 = "hi";
		String str3 = new String("hi");
		String str4 = "hi";
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		str2 = "hello";
		System.out.println("str2 changed to be 'hello'");
		
		System.out.println(str1 == str2);
		System.out.println(str1);
		System.out.println(str1 == str4);
		
		str4 = str3;
		System.out.println(str3 == str4);
		System.out.println(str1.equals(str3));
		
		// replaceAll
		String test = "Here is my string. Isn't it cool?";
		// test.replaceAll(" ", "_"); // returns a String b/c immutable
		System.out.println(test.replaceAll(" ", "_"));
		
		// charAt
		String original = "original string";
		System.out.println(original.charAt(1));
		
		// lowercase & uppercase
		String str = "CrAzY cAsE!";
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		// ends with
		String myStr = "running";
		boolean endsWithING = myStr.endsWith("ing");
		System.out.println(endsWithING);
		
		/*
		 * StringBuilder
		 */
		
		// Can't use literals
		StringBuilder strBldr1 = new StringBuilder("My StringBuilder Object!");
		StringBuilder strBldr2 = new StringBuilder("My StringBuilder Object!");
		
		System.out.println(strBldr1 == strBldr2);
		System.out.println(strBldr1.equals(strBldr2)); // Apparently not overridden
		
		// Trying to play with String intern method
		System.out.println(strBldr1.toString().intern() == strBldr2.toString().intern());
		System.out.println(strBldr1.toString().equals(strBldr2.toString()));
		
		String anotherString = "My StringBuilder Object!".intern();
		System.out.println(anotherString);
	}
}
