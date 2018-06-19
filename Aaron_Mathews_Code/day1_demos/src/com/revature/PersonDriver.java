package com.revature;

import com.revature.models.Person;

public class PersonDriver {
	
	public static void main(String[] args) {
<<<<<<< HEAD:Aaron_Mathews_Code/day1_demos/src/com/revature/PersonDriver.java
		//Create person object
=======
		
		// Create a Person object using the no-args constructor (object instantiation)
>>>>>>> 8effeda29ed8561b1be3ef7a55cf5fbada66f254:Week_1-Core_Java/day1_demos/src/com/revature/PersonDriver.java
		Person myPerson = new Person();
		
		// print out the first name of our Person object by invoking the public field 'firstName'
		System.out.println(myPerson.firstName);
		
		// print out the calculated BMI of our Person object by simply invoking the method name
		System.out.println(myPerson.calculateBMI());
		
		// We can also invoke static methods without having to directly instantiate a Person object.
		Person.eat();
	}
	
}
