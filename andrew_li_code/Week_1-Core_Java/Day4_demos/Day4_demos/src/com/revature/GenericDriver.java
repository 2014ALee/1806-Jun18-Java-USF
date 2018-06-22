package com.revature;

import com.revature.models.GenericClass;

public class GenericDriver {
	public static void main(String[] args) {
		GenericClass<String> myGenericClass = new GenericClass<String>();
		myGenericClass.setValue("A value");
		System.out.println(myGenericClass.getValue());
	}
}
