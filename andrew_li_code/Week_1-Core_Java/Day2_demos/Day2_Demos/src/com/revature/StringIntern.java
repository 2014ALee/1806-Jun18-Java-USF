package com.revature;

public class StringIntern {
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = new String("Hello");
		str2 = str2.intern();
		System.out.println("str1 == str2: " + (str1 == str2));
		System.out.println("str2: " + str2);
		String str3 = new String("Yooo!!!");
		String str4 = "Yooo!!!";
		System.out.println("str3 == str4: " + (str3 == str4));
		System.out.println("str3.equals(str4)): " + str3.equals(str4));
		
		String blue = new String("blue");
		String blue2 = blue.intern();
		String blue3 = "blue";
		
		System.out.println("blue == blue2: " + (blue == blue2));
		System.out.println("blue == blue3: " + (blue == blue3));
		System.out.println("blue2 == blue3: " + (blue2 == blue3));
	}
}
