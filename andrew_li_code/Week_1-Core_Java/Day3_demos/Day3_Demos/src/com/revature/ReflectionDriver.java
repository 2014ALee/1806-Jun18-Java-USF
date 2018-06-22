package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {
	public static void main(String[] args) {
		/*
		 * Reflection provides ability to inspect and modify the runtime behavior
		 * of an application. Reflection in Java is oneof the advanced Core Java topic.
		 * We can inspect classes, interfaces, enums, fields, methods, constructors, etc.
		 */
		
		// Let's make Strings mutable!!
		
		String s = "Strings are ALWAYS immutable, right?";
		
		Class<String> stringClass = String.class;
		
		System.out.println("Original value of \"s\": " + s);
		
		try {
			Field stringValue = stringClass.getDeclaredField("value");
			/*
			 * Change the accessibility of the 'value' field in the String class
			 * to true. The value of true indicates that the reflected object should
			 * suppress Java language access checking when it is used.
			 */
			stringValue.setAccessible(true);
			stringValue.set(s, "Hehe!!!!".toCharArray());
		} catch (NoSuchFieldException nsfe) {
			nsfe.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		System.out.println(s);
		System.out.println("Strings are ALWAYS immutable, right?");
		System.out.println("Strings are ALWAYS immutable, right?".equals("Hehe!!!!"));
		s = null;
		System.gc();
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
			System.out.println(i);
			System.out.println(i);
			System.out.println(i);
		}
		System.out.println("Strings are ALWAYS immutable, right?");
		System.out.println("Strings are ALWAYS immutable, right?".equals("Hehe!!!!"));
	}
}
