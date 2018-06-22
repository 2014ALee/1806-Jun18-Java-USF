package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GenericClass;

public class GenericDriver {

	public static void main(String[] args) {
		List myList = new ArrayList();
		myList.add("abc");
		myList.add(new Integer(5));
		
		//likely lead to a ClassCastException
		//for(Object o : myList) {
			//String str = (String) 0;
			//System.out.println(str);
		
		//using generics allows us to avoid this exception since the compiler will not let us add
		//objects of an incorrect type
		
		
		System.out.println("\n\n");
		
		
		GenericClass<String> myGenericClass = new GenericClass();
		myGenericClass.setValue("some value");
		System.out.println(myGenericClass.getValue());
		
		//make methods generic
		
		
		}
		
		
	}
	
	
	

