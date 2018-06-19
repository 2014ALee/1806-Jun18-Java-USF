package com.revature;

public class StringDriver {

	public static void main(String[] args) {
		String str1 = "hi";
		String str2 = "hi";		// references same object in string pool
		String str3 = new String("hi");		// creates new object in the heap but not in the string pool
		
		System.out.println(str1 == str2);			// == checks if reference is the same
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		str2 = "hello";
		System.out.println(str1 == str2);
		System.out.println(str1);
		
		System.out.println(str1.equals(str3));		// .equals() checks if values are the same

		System.out.println("------------------");
		
		//replace all
		String test = "Here is my string. Isn't it cool?";
		test.replaceAll(" ", "_");
		System.out.println(test);
		
		System.out.println(test.replaceAll(" ", "_"));

		System.out.println("------------------");
		
		// charAt
		String original = "original string";
		System.out.println(original.charAt(1));
		
		System.out.println("------------------");
		
		// lowercase and uppercase
		String str = "CraZY caSe";
		System.out.println(str);
		str = str.toLowerCase();
		System.out.println(str);
		System.out.println(str.toUpperCase());

		System.out.println("------------------");
		
		// ends with
		String myStr = "running";
		boolean endsWithING = myStr.endsWith("ing");
		System.out.println(endsWithING);

		System.out.println("------------------");
		
		
		
		
		/*
		 * String Builder
		 */
		
		StringBuilder strBldr1 = new StringBuilder("My string builder object.");
		StringBuilder strBldr2 = new StringBuilder("My string builder object.");
		
		System.out.println(strBldr1 == strBldr2);
		System.out.println(strBldr1.equals(strBldr2));
		

		System.out.println("------------------");
		
		String strA = "heyo";
		String strB = new String("heyo");
		strB = strB.intern();
		System.out.println(strA == strB);
		
		
		
		
	}
}
