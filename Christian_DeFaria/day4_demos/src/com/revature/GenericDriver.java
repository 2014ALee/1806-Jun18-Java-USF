package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Generics
		 * 
		 * notes to go here
		 */
		List myList = new ArrayList();
		myList.add("abc");
		myList.add(new Integer(5));
		
		//This will likely lead to a ClassCastException because we don't know what's inside
//		for(Object o : myList) {
//			String str = (String) o;
//			System.out.println(str);
//		}
		
		/*
		 * Using generics allows us to avoid this exception
		 */
		List<String> strList = new ArrayList<>();
		strList.add("abc");
//		strList.add(new Integer(6));
		strList.add("def");
		
		for(String str : strList) {
			System.out.println(str);
		}
		
		System.out.println("----------------------------------------");
		
		GenericClass<String> myGenericClass = new GenericClass();
		myGenericClass.setValue("some value");
		System.out.println(myGenericClass.getValue());
		
		
	}

}
