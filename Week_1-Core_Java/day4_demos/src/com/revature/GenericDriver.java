package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Generics
		 * 
		 * Generics were added in Java 5 to provide compile-time type checking and removing risk of ClassCastException 
		 * that was common while working with collection classes. The whole collection framework was re-written to use 
		 * Generics for type-safety.
		 */
		List myList = new ArrayList(); // Without using Generics, we can put any kind of object in here
		myList.add("abc");
		myList.add(new Integer(5));
		
		// This will likely lead to a ClassCastException, since we might not know what objects are stored inside
//		for(Object o : myList) {
//			String str = (String) o;
//			System.out.println(str);
//		}
		
		/*
		 * Using Generics allows us to avoid this exception, since the compiler will not let us
		 * add objects of an incorrect type
		 */
		List<String> strList = new ArrayList<>();
		strList.add("abc");
		strList.add("def");
//		strList.add(new Integer(6));
		
		for(String str :  strList) {
			System.out.println(str); // no need to cast here!
		}
		
		System.out.println("+------------------------------------------------+");
		
		// The data type we pass to this class will determine the data type of its members
		GenericClass<String> myGenericClass = new GenericClass();
		myGenericClass.setValue("some value");
		System.out.println(myGenericClass.getValue());
		
	}

}
