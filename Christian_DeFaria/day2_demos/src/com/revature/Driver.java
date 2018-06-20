package com.revature;

import com.revature.models.Person;
import com.revature.models.Skill;

public class Driver {

	public static void main(String[] args) {

		Person person1 = new Person();
		
		//Private fields are not visable
		//person1.firstName;
		
		System.out.println(person1.getFirstName());
		
		//Null pointer exception
		//System.out.println(person1.getFirstName().toUpperCase());
		
		person1.setFirstName("John");
		person1.setLastName("Beineke");
		person1.setAge(23);
		person1.setPrimarySkill(Skill.JAVA);
		
		System.out.println(person1);
		
		Person person2 = new Person("Wezley", "Singleton", 27, Skill.JAVA);
		System.out.println(person2);
		
		Person person3 = new Person("John", "Beineke", 23, Skill.JAVA);
		System.out.println(person3);
		
		System.out.println(person1 == person3);
		System.out.println(person1.equals(person3));
		
		
	}
}
