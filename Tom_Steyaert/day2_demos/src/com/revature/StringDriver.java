package com.revature;

public class StringDriver {

	
	public static void main(String[] args) {
		
		String str1 = "hi";
		String str2 = "hi";
		String str3 = new String("hi");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		Object k = new Object() {
			public String toString() {
				return "k";
			}
		};
		System.out.println(k);
		
		
		
		StringBuilder bldr = new StringBuilder("My string builder object");
		StringBuilder bldr2 = new StringBuilder("My string builder object");
		System.out.println(bldr==bldr2);
		System.out.println(bldr.equals(bldr2));
		
		
	}
	
	
}
