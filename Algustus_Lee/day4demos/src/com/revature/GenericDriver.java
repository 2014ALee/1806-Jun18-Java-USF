package com.revature;

import java.util.List;

import com.revature.models.GenericClass;

import java.util.ArrayList;

public class GenericDriver {
	public static void main(String[] args)
	{
		/*
		 * Generics
		 * 
		 * Specifies what kind of object goes into a collection
		 */
//		List myList = new ArrayList(); //Without using Generics, we can put any kind of object here
//		myList.add("abc");
//		myList.add(new Integer(4));
//		
//		for(Object o: myList)
//		{
//			String str = (String)o;  			We won't always know what kind of objects go into the arraylist, so
//			System.out.println(str);			we use generics to help us avoid any exceptions that could pop up
//		}										unexpectedly.
		/*
		 * Using Generics will cause the compiler to prevent us from adding objects of an incorrect type.
		 */
		
		List<String> strList = new ArrayList<>();
		strList.add("abc");
		strList.add("def");
		//strList.add(new Integer(6)); //not allowed with Generics.
		
		for(String str: strList)
		{
			System.out.println(str);
		}
		System.out.println("+---------------------------------------------------------+");
		
		GenericClass<String> myGenericClass = new GenericClass(); //the T was replaced with String
		myGenericClass.setValue("this value");
		System.out.println(myGenericClass.getValue()); //one can make a method generic without making the class generic.
		//look into it.
	}

}
