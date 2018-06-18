package com.revature;

import come.revature.models.Person;

public class PersonDriver {

	public static void main(String[] args) {
		
		//create a Person object
		Person myPerson = new Person();
		System.out.println(myPerson.firstName);
		System.out.println(myPerson.calculateBMI());
		
	}
}
