package com.revature;

import java.util.*;
import java.util.ArrayList;

import com.revature.models.GenericClass;

public class GenericDriver {

	public static void main(String[] args) {
		
		/*
		 * Genericsds
		 */
		
		List myList = new ArrayList(); //without using generics, we can put any kind of object in here
		myList.add("abc");
		myList.add(new Integer(5));
		
		List<String> strList = new ArrayList<>();
		strList.add("abc");
		//strList.add(new Integer("lamine"));
		strList.add("Lamine");
		
		for(String str:strList) {
			System.out.println(str); // no need to cast here
		}
		
		System.out.println("-----------------------------------------------");
		
		GenericClass<String> myGenericClass = new GenericClass<String>();
		myGenericClass.setValue("some value");
		System.out.println(myGenericClass.getValue());

	}

}
