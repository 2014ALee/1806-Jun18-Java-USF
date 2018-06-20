package com.revature;

import com.revature.models.*;

public class Driver {
	public static void main(String[] args) {
		Person person1 = new Person();
		person1.setAge(23);
		person1.setFirstName("Andrew");
		person1.setLastName("Li");
		System.out.println(person1);
		Person person2 = new Person("Andrew", "Li", 23, Skill.JAVA);
		System.out.println(person2);
		System.out.println(person1.equals(person2));
		System.out.println(person1.toString().equals(person2.toString()));
	}
}
