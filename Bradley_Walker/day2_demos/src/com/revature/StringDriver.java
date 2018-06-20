package com.revature;

public class StringDriver {

	public static void main(String[] args) {
		// Reversing a string
//		String str = "test string";
//		String result = "";
//		for(String s : str.split(""))
//			result = s + result;
//		System.out.println(result);
		
		// str1 and 2 point to the same object in the string pool
		String str1 = "hi";
		String str2 = "hi";
		// Creates string in heap but not in string pool
		String str3 = new String("hi");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		str2 = "hello";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str3));
		
		System.out.println("\n--------------------");
		
		// replaceAll
		String test = "This is a slightly longer string";
		test = test.replaceAll("t", "c");
		System.out.println(test);
		
		// charAt
		String original = "original string";
		System.out.println(original.charAt(0));
		
		// cases
		String str = "CrAzY cAsE";
		System.out.println(str);
		str = str.toLowerCase();
		System.out.println(str);
		str = str.toUpperCase();
		System.out.println(str);
		
		// ends with
		System.out.println(str.toLowerCase().endsWith("ase"));
		
		/*
		 * StringBuilder
		 * mutable version of a string
		 */
		
		StringBuilder strBld1 = new StringBuilder("This is a string");
		StringBuilder strBld2 = new StringBuilder("This is a string");
		System.out.println(strBld1 == strBld2);
		System.out.println(strBld1.equals(strBld2));
		
	}
}
