package com.revature;

import com.revature.models.Person;
import com.revature.models.Skill;

public class Driver {
	public static void main(String[] args) {
		Person person1 = new Person();

		// private fields are not visible outside of the class declaration
		// person1.firstName;

		// As an Object, default value is null
		// System.out.println(person1.getFirstName());

		// Following gives an exception (NullPointer - invoke a method on an object that doesn't exist)
		// System.out.println(person1.getFirstName().toUpperCase());

		person1.setFirstName("Jon");
		person1.setLastName("Smith");
		person1.setAge(28);
		person1.setPrimarySkill(Skill.PYTHON);

		// Prints out "where" it it in memory, without toString() defined in class
		System.out.println(person1);

		Person person2 = new Person("Karen","Matney",27,Skill.JAVA);
		System.out.println(person2);

		Person person3 = new Person("Jon","Smith",28,Skill.PYTHON);
		System.out.println(person3);

		System.out.println(person1 == person2); // False, different in memory. Twins, but different memory
		System.out.println(person1.equals(person3)); // Behaves as above if not overridden	
	}
}