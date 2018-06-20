package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {

	public static void main(String[] args) {

		/*
		 * Reflection provides the ability to inspect and modify the runtime behavior of an 
		 * application. Reflection in java is one of the advanced Core Java topics. We can
		 * inspect classes, interfaces, enums, fields, constructors, etc.
		 */

		// Making Strings mutable
		String s = "Strings are immutable";

		Class<String> stringClass = String.class;
		System.out.println(stringClass);

		System.out.println("Original value of 's': " + s);

		Field stringValue;
		
		try {
			// Get access to the value field of the String class
			stringValue = stringClass.getDeclaredField("value");
			
			// Change the accessibility of the value field to true. 
			stringValue.setAccessible(true);
			
			// Change the value of 'value' to something else...
			stringValue.set("Strings are immutable", "Muahahahahaha".toCharArray());
			System.out.println("New value of 's': " + s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Hopefully we didn't break anything
		System.out.println("Strings are immutable");
		
		// Let's try to fix this by dereferencing the String object that 's' points to
		s = null;
		
		// Request garbage collection
		System.gc();
		
		// This should eventually fix it... in theory
//		while("Strings are immutable".equals("Muahahahahaha")) {
//			System.out.println("Strings are immutable");
//		}
		
		String s2 = new String("Strings are immutable");
		String s3 = s2.intern();
		
		System.out.println(s3);
		System.out.println("Strings are immutable");
	}

}
