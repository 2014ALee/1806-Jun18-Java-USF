package com.revature;

import java.lang.reflect.Field;

public class ReflectionDriver {
	public static void main(String[] args)
	{
		/*
		 * Reflection provides the ability to inspect and modify the runtime behavior of an application.
		 * Reflection in Java is one of the advanced Core Java topic. We can inspect a class, interfaces, enums, fields,
		 * methods, constructors, etc.
		 */
		
		//Lets make Strings mutable!
		String s = "Strings are always immutable, right?";
		
		Class<String> stringClass = String.class;
		System.out.println(stringClass);
		System.out.println("Original value of 's': " + s);
		
		try {
			//get access to the 'value' field of the String class
			Field stringValue= stringClass.getDeclaredField("value");
			stringValue.setAccessible(true);
			/*
			 * Change the accessibility of th e'value field in the String class
			 * to true. The value of true indicates that the reflected object should
			 * suppress Java language acess checking when it is used.
			 */
			stringValue.set(s, "AHAHAHHAHAH.".toCharArray());
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
		System.out.println("Strings are always immutable, right?");
		
		s = null;
		
		System.gc();
		
		while("Strings are always immutable, right?".equals("AHAHAHHAHAH."))
		{
			System.out.println("Strings are always immutable, right?");
		}
		System.out.println("fix't");
	}

}
