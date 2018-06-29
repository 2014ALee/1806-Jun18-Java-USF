package com.revature;

public class StringDriver {

	public static void main(String[] args) {
		
		String str1 = "I'm a string";
		String str2 = "I'm a string";
		
		/*
		 * Modifying a string's value will reference a new object.
		 * This is reflected in the hash code.
		 */
		
		System.out.println("String 1 hashCode = " + str1.hashCode());
		System.out.println("String 2 hashCode = " + str2.hashCode());
		
		// This is on the heap but not in the string pool
		String str3 = new String("I'm also a string");
		
		// This is a new object in the string pool
		str1 = str1 + str3;
		System.out.println("String 1 hashCode = " + str1.hashCode());
		System.out.println("String 2 hashCode = " + str2.hashCode());
		System.out.println("str1 == str2: " + (str1 == str2));
		System.out.println("str1.equals(str2): " + str1.equals(str2));
		
		/*
		 * StringBuilder
		 * mutable
		 * not thread-safe
		 */
		
		StringBuilder strB1 = new StringBuilder("I'm a StringBuilder object");
		StringBuilder strB2 = new StringBuilder("I'm a StringBuilder object");
		
		System.out.println("strB1 hashCode = " + strB1.hashCode());
		System.out.println("strB2 hashCode = " + strB2.hashCode());
		System.out.println("strB1.equals(strB2): " + strB1.equals(strB2));
		
		System.out.println(strB1.toString().hashCode());
		System.out.println(strB2.toString().hashCode());
		System.out.println(strB1.toString() == strB2.toString());
		
		// String is immutable
		System.out.println("str2 = " + str2);
		str2.toUpperCase();
		System.out.println(str2);
		
		// StringBuilder is mutable
		StringBuilder strB3 = new StringBuilder("Hello");
		System.out.println(strB3);
		strB3.append(", world!");
		System.out.println(strB3);
		
		
	}

}
