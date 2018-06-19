package com.revature;

import com.revature.models.Person;
import com.revature.models.Skill;

public class Driver {

	public static void main(String[] args) {
		Person person1 = new Person();
		
		// private fields are not visible outside the class
		// System.out.println(person1.firstName);
		
		person1.setFirstName("John");
		person1.setLastName("Beineke");
		person1.setAge(23);
		person1.setPrimarySkill(Skill.JAVA);
		System.out.println(person1);
		
		Person person2 = new Person("Bradley", "Walker", 21, Skill.JAVA);
		System.out.println(person2);
		
		Person person3 = new Person("John", "Beineke", 23, Skill.JAVA);
		System.out.println(person3);
		
		// false because they aren't the same object in memory
		System.out.println(person1 == person3);
		
		// true because the overridden equals method compares the values
		System.out.println(person1.equals(person3));
		
		
	}

}
