package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Generics
		 */
		
		List myList = new ArrayList();
		myList.add("abc");
//		myList.add(new Integer(5));
		
		
		//This will likely lead to a ClassCastException, since we might not know what ojbects are inside
//		for (Object o : myList) {
//			String str = (String) o;
//			System.out.println(str);
//		}
		
//		Using Generics allows us to avoid this excpetion, since the comipler will not let us
//		add objects of an iconrrect tyep
		List<String> strList = new ArrayList<>();
		strList.add("abc");
		strList.add("abasdfc");
//		strList.add(new Integer(6));
		
		for(String str : strList)
			System.out.println(str);
		
		//way to make methods Generic without making class Generic
		GenericClass<String> myGenericClass = new GenericClass();
		myGenericClass.setValue("some value");
		System.out.println(myGenericClass.getValue());
	}
	
}
