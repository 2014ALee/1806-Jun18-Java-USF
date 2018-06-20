package com.revature;

public class ReflectionDriver {

	public static void main(String[] args) {


		/*
		 * Reflection provides ability to inspect and modify the runtime behavior of an 
		 * application. reflection in java is one the advanced Core Java topic. We can inspect 
		 * a classes, interface, enums fields, etc.  
		 */

		// Let's make a Spring mutable
		String s = "String are Always ummutable, right?";

		Class<String> stringClass = String.class;
		System.out.println(stringClass);

		System.out.println("orignal value of s" + s);

		try {
			
			// get access to the 'value field of the String Class
			Field stringValue = stringClass.getDeclaredField("value");
			
			
		
		} 

	}

}
