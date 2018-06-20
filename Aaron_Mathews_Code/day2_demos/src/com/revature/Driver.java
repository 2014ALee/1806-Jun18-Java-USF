package com.revature;

import com.revature.models.Person;
import com.revature.models.Skill;

public class Driver {

	public static void main(String[] args) {
		
		Person person1 = new Person(); 
		//String firstName was not initialized. Will print null
		System.out.println(person1.getFirstName());
		
		//Gives NullPointerException as firstName is null
		//System.out.println(person1.getFirstName().toString());
		person1.setFirstName("John");
		person1.setLastName("Beineke");
		person1.setAge(23);
		person1.setPrimarySkill(Skill.JAVA);
		
		System.out.println(person1.toString());
		
		Person person2 = new Person("Wezley", "Singleton", 27, Skill.JAVA);
		System.out.println(person2.toString());
		
		Person person3 = new Person("John", "Beineke", 23, Skill.JAVA);
		System.out.println(person3);
		
		System.out.println(person1 == person3);
		System.out.println(person1.equals(person3));
		
		
	}
}
