package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {

	public static void main(String[] args) {
		
		/*
		 * reflection provides ability to inspect and modify the runtime behavior of an application.
		 * Reflection in Java is one of the advanced Core Java topics. we can inspect a class, interfaces, enums,
		 * fields, methods, constructors, etc.
		 */
		
		//let's make Strings mutable
		
		String s = "Strings are ALWAYS immutable, right?";
		
		Class<String> stringClass = String.class;
		System.out.println(stringClass);
		
		System.out.println("Original value of 's': " + s);
		
	
			try {
				
				//get access to the 'value' field of the String class
				Field stringValue = stringClass.getDeclaredField("value");

				
				//change the accessibility of the value field in the string class
				//to true. The value of the true indicates that the reflected object should
				//suppress Java language access checking when it is used.
				
				stringValue.setAccessible(true);
				//change the value of 'value' to something else...
				stringValue.set(s, "something else".toCharArray());
				//print the new value of 's'
				System.out.println(s);
				
				
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			

		//maybe broke it
		System.out.println("Strings are ALWAYS immutable, right?");
		
		//maybe fix it by dereferencing the string object that s points to
		s=null;
		
		//Suggest that the JVM run garbage collector
		System.gc();
		
		//may not work, but should
		
		//while("Strings are ALWAYS immutable, right?".equals("something else")){
			//System.out.println("Changes made");
	//	}
		System.out.println("Better");
	}
	
	
}
