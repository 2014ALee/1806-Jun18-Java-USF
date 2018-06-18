package com.revature;

import com.revature.models.Person;

public class PersonDriver {
	
	public static void main(String[] args) {
		Person myPerson1 = new Person();
		System.out.println(myPerson1.firstName);

		Person myPerson2 = new Person("Brandon");
		System.out.println(myPerson2.firstName);
		System.out.println(myPerson2.calculateBMI());
		System.out.println(myPerson2.calculateBMI(73, 170));
		myPerson2.eat();
		Person.eat();
	}
}
