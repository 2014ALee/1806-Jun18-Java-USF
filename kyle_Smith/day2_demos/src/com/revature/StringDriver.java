package com.revature;

public class StringDriver {

	
	public static void main(String[] args) {
		
		String str1 = "hi";
		String str2 = "hi";
		String str3 = new String("hi");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
	
		/*
		 * StringBUilder
		 * 
		 * 
		 */
		StringBuilder strBldr1 = new StringBuilder("My StringBuilder Object!");
		StringBuilder strBldr2 = new StringBuilder("My StringBuilder Object!");
		System.out.println(strBldr1 == strBldr2);
	
	
	}
}
