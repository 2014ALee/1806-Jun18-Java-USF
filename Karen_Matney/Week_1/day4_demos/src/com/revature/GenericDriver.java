package com.revature;

import java.util.List;
import java.util.ArrayList;

import com.revature.models.GenericClass;

public class GenericDriver {
	public static void main(String[] args) {
		/*
		 * Generics
		 * 
		 * notes to go here
		 */
		List myList = new ArrayList(); // Without using Generics, we can put any kind of object in here
		myList.add("abc");
		myList.add(new Integer(5));
		
		// This will likely lead to a ClassCastException, wince we might not know what objects are stored inside
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
		// strList.add(new Integer(6)); // Doesn't work
		
		for(String str : strList) {
			System.out.println(str); // no need to cast here
		}
		
		System.out.println("+-----------------------------------+");
		
		GenericClass<String> myGenericClass = new GenericClass();
		myGenericClass.setValue("some value");
		System.out.println(myGenericClass.getValue());
	}
}