package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Reflection provides the ability to inspect and modify the runtime behavior of an
		 * application. Reflection in Java is one of the advanced Core Java topic. We can inspect
		 * a class, interfaces, enums, fields, methods, constructors, etc.
		 */
		
		//Let's make strings mutable
		String s = "Strings are always immutable, right?";
		
		Class<String> stringClass = String.class;
		System.out.println(stringClass);
		
		System.out.println("Original value of s: " + s);
		
		Field stringValue;
		try {
			//Get access to the 'value' field in the String class
			stringValue = stringClass.getDeclaredField("value");
			
			/*
			 * Change the accessibility of the 'value' field in the String class
			 */
			stringValue.setAccessible(true);
			
			//Change the value of value to something else
			stringValue.set(s, "Bahahahaha!".toCharArray());
			
			//print new s
			System.out.println(s);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Fingers crossed
		System.out.println("Strings are always immutable, right?");

		s = null;
		stringValue = null;
		
		//Suggest JVM runs garbage collection
		System.gc();
		
		//Eventually...maybe...probably not though
		while("Strings are always immutable, right?".equals("Bahahahaha!")) {
			System.out.println("Strings are always immutable, right?");
		}
		System.out.println("Strings are always immutable, right?");
		System.out.println("All better!");

	}

}
