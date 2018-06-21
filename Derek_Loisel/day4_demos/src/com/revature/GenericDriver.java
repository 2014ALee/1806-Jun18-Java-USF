package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {

	
	public static void main(String[] args) {
		
		/*
		 * Generics
		 * 
		 * added in java 5 to give us compile time checking  of types
		 */
		
		List<String> strList = new ArrayList<>();
		strList.add("abc");
		System.out.println(strList.get(0));
		
		
		GenericClass<String> myGenericClass = new GenericClass();
		myGenericClass.setValue("some value");
		System.out.println(myGenericClass.getValue());
	}
	
}
