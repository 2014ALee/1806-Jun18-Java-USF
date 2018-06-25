package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {

	public static void main(String[] args) {
		
		/*
		 * Generics
		 * 
		 * notes go here
		 */
		
		List myList = new ArrayList(); 		// Without using generics, we can add any kind of object here
		
		myList.add("abc");
		myList.add(new Integer(5));
		
		// This will likely lead to a class cast exception since we might not not what types of objects 
		// are stored inside. Using Generics allows us to avoid this exception, since the compiler will 
		// not let us add objects of an incorrect type
//		for(Object o : myList) {
//			String str = (String) o;
//			System.out.println(str);
//		}
		
		
		
		List<String> strList = new ArrayList(); 		// Using generics provides type safety
		
		strList.add("abc");
//		strList.add(new Integer(5));
		
		for(String str : strList) {
			System.out.println(str);
		}
		
		System.out.println("---------------------------------------------------");
		
		GenericClass<String> myGenericClass = new GenericClass();
		myGenericClass.setValueT("some value");
		System.out.println(myGenericClass.getValue());
		
		
		
		
		
		
	}
}
