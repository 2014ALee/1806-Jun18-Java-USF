package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {

	public static void main(String[] args) {
		/*
		 * Generics
		 */
		List list = new ArrayList(); // Without generics, we can put any kind of object in the list
		list.add("abc");
		list.add(5);
		
		// Casting exception because they aren't all the same type
//		for(Object obj : list) {
//			String s = (String) obj;
//			System.out.println(s);
//		}
		
		/*
		 * Using generics is safer because then we know for sure what the type of an
		 * object is
		 */
		List<String> strList = new ArrayList<>();
		strList.add("123");
		strList.add("456");
		strList.add("789");
//		strList.add(6); // Won't allow us to add an integer
		
		for(String str : strList)
			System.out.println(str);
		
		System.out.println("--------------------------------------------------------");
		
		GenericClass<String> myGeneric = new GenericClass<>();
		myGeneric.setValue("Some value");
		System.out.println(myGeneric.getValue());
	}

}
