package com.revature;

public class ReflectionDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Reflection provides ability to inspect and modify the runtime behavior of an application.
		 * Reflection in java is one the advanced core java  topic. We can inspect a classes, 
		 * interfaces, enums, fields, methods, constructors, etcl
		 */
	
	// Let's make string mutable
	
		String s = "String are AlWAYS immutable, right?";
		
		Class<String> stringClass = String.class;
		System.out.println(stringClass);
		
		System.out.println("Original value of 's': " +s);
		
		try{
			java.lang.reflect.Field stringValue = stringClass.getDeclaredField("Value");
		}catch(NoSuchFieldException e){
			e.printStackTrace();
		}catch(SecurityException e) {
			e.printStackTrace();
		}
	}
}
