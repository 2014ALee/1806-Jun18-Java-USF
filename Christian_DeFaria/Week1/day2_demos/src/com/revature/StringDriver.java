package com.revature;

public class StringDriver{
	public static void main(String[] args) {
		String str1 = "hi";
		String str2 = "hi";
		String str3 = new String("hi");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		str2 = "hello";
		
		System.out.println(str1 == str2);
		System.out.println(str1);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		String test = "Here is my string, isn't it cool?";
		test.replaceAll(" ", "_");
		System.out.println(test);
		System.out.println(test.replaceAll(" ", "_"));
		
		String original = "original string";
		System.out.println(original.charAt(1));
		
		String str = "CrAzY cAsE!";
		System.out.println(str);
		System.out.println(str.toUpperCase());
		
		String myStr = "running";
		boolean endsWithING = myStr.endsWith("ing");
		System.out.println(endsWithING);
		
		/*
		 * String Builder
		 */
		StringBuilder strBldr1 = new StringBuilder("My StringBuilder Object!");
		StringBuilder strBldr2 = new StringBuilder("My StringBuilder Object!");
		System.out.println(strBldr1 == strBldr2);
		System.out.println(strBldr1.equals(strBldr2));
		
		System.out.println("--------------");
		str2 = "hi";
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println("--------------");
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		System.out.println("--------------");
		System.out.println(str1.intern() == str2.intern());
		System.out.println(str2.intern() == str3.intern());
		System.out.println(str1.intern() == str3.intern());
	}
}
