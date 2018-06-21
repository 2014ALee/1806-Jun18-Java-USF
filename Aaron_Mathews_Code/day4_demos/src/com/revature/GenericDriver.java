package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {
	
	public static void main(String[] args) {
		/*
		 * Generics
		 * 
		 *- Added in java 5
		 *- Removed risk of class cast exceptions 
		 *- Can be used to define classes
		 */
		
		List myList = new ArrayList(); //without generics, can add any kind of object. Generics guarantee object type
		myList.add("abd");
		//myList.add(new Integer(5));
		
		//This will likely lead to class cast exception
		for (Object o : myList) {
			String str = (String) o;
			System.out.println(str);
		}
		
		//Using generics avoids the exception since the compiler won't let us add objs of the incorrect type.
		
		List<String> strList = new ArrayList<>();
		strList.add("abc");
		//strList.add(new Integer(4));
		
		for (String str : strList) {
			System.out.println(str);
		}
		
		System.out.println("---------------------------------");
		
		GenericClass<String> myGenericClass = new GenericClass(); 
		myGenericClass.setValue("Some Value");
		System.out.println(myGenericClass.getValue());
	}

}
