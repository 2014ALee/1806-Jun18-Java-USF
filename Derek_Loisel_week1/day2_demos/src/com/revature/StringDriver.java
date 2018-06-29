package com.revature;

public class StringDriver {
	public static void main(String[] args) {
		String str1 = "hi";
		String str2 = "hi";
		String str3 = new String("hi");
		
		System.out.println(str1 == str2); //true
		System.out.println(str2 == str3); //false
		System.out.println(str1 == str3); //false
		System.out.println(str1 == str3.intern()); //true because of intern method checking the pool first
		System.out.println(str1.equals(str3)); //true, dont need to override String to compare values unless its StringBuilder object
		
		/*
		 * intern method
		 */		
		
		//replaceAll
		String test = "Here is my string. Isn't it cool?";
		System.out.println(test.replaceAll(" ", "_"));//replace spaces with underscores
		
		//lowercase and upercase
		String stri = "craZy CaSe";
		stri = stri.toLowerCase();
		System.out.println(stri);
		
		//ends with
		String myStr = "running";
		boolean endsWithING = myStr.endsWith("ing");
		System.out.println(endsWithING); //true
		
		/*
		 * StringBuilder
		 */
		StringBuilder strBldr1 = new StringBuilder("My object");
		StringBuilder strBldr2 = new StringBuilder("My object");
		
		System.out.println(strBldr1 == strBldr2); //false
		System.out.println(strBldr1.equals(strBldr1.equals(strBldr2))); //false, need to override like other objects or else it just compares location in memory
		

	
	}
}
