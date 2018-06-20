package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {

	public static void main(String[] args) {
		/*
		 * Reflection provides ability to inspect and modify the runtime behavior of an application
		 * Reflection in java is advanced for core java. very powerful
		 * We can inspect a class, interfaces, enums, fields, methods, constructors, etc.
		 */

		//Making string mutable
		String s = "Strings are always immutable, right?";

		Class<String> stringClass = String.class;
		System.out.println(stringClass);

		System.out.println("Original value of s: " + s);

		try {

			//Get access to the value field of the string class
			Field stringValue = stringClass.getDeclaredField("value");

			//Change the accessibility of the value field in the string class to true
			//True means the reflected object should suppress Java language access checking when it is used.
			stringValue.setAccessible(true);

			//Change the value
			stringValue.set(s, "bahahaha".toCharArray());


			System.out.println(s);
		} catch (NoSuchFieldException nsfe) {
			nsfe.printStackTrace();
		} catch (SecurityException se) {
			se.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Strings are always immutable, right?");
		
		s = null;
		
		System.gc();
		
		//Eventually, values will be reset and can reassign reference
		while ("Strings are always immutable, right?".equals("bahahaha")) {
			System.out.println("Strings are always immutable, right?");
		}
		
		System.out.println("All better!");
	}

}

