package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {

	public static void main(String[] args) {
		/*
		 * Reflection provides ability to inspect and modity the runtime behavior of an application. 
		 * Reflection in Java is on the advanced Core Java topic. We can inspect a classes, interfaces,
		 * methods, constructors, etc...
		 */

		// Let's make Strings mutable!
		String s = "Strings are ALWAYS immutable, right?";

		Class<String> stringClass = String.class;
		System.out.println(stringClass);

		System.out.println("Original value of 's': " + s);

		try {
			// Get access to the 'value' field of the String class
			Field stringValue = stringClass.getDeclaredField("value");
			
			/*
			 * Change the accessibility of the 'value' field in the String class
			 * to true. the value of true indicates that the reflected object should suppress 
			 * Java language access checking when it is used.
			 */
			stringValue.setAccessible(true);
			
			//Change the value of 'value' to something else....
			stringValue.set(s,  "Bahahahahaaah!".toCharArray());
			
			//Print the new value of 's'
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
		} finally {

		}
		
		//Hopefully we didn't break naything...
		System.out.println("Strings are ALWAYS immutable, right?");
		
		// Let's try to fix this by dereferencing the String object that 's' points to 
		s = null;
		
		// Suggest that the JVM run the garbage collector
		System.gc();
		
		//Eventually...maybe...probably not
		while("Strings are ALWAYS immutable, right?".equals("Bahahahahaaah!")) {
			System.out.println("Strings are ALWAYS immutable, right?");
			// Suggest that the JVM run the garbage collector
			System.gc();
		}
		
		//one day this will get executed...
		System.out.println("All better now");
	}

}
