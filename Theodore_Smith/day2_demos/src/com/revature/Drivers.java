package com.revature;

import day2_demos.Person;

import day2_demos.Skill;



public class Drivers {



	public static void main(String[] args) {

		

		Person person1 = new Person();



		// private fields are not visible outside of the class declaration!

//		person1.firstName;

		

		System.out.println(person1.getFirstName());

		

		// this gives a NullPointerException

//		System.out.println(person1.getFirstName().toUpperCase());

		

		person1.setFirstName("John");

		person1.setLastName("Beineke");

		person1.setAge(23);

		person1.setPrimarySkill(Skill.JAVA);

		

		System.out.println(person1);

		

		Person person2 = new Person("Wezley", "Singleton", 27, Skill.JAVA);

//		System.out.println(person2);

		

		Person person3 = new Person("John", "Beineke", 23, Skill.JAVA);

		System.out.println(person3);

		

		System.out.println(person1 == person3);

		System.out.println(person1.equals(person3));

		

		

	}

}