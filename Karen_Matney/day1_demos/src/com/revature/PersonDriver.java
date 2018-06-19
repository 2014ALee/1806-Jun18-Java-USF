package com.revature;

import com.revature.models.Person;

public class PersonDriver {
	public static void main(String[] args) {
		
		// Create a Person object
		Person myPerson = new Person();
		System.out.println(myPerson.firstName);
		System.out.println(myPerson.calculateBMI());
		
		Person.eat();
	}
	


}
