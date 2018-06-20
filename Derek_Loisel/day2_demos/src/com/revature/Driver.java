package com.revature;

import com.revature.models.Person;
import com.revature.models.Skill;

public class Driver {

	public static void main(String[] args) {
		
		Person person1 = new Person();
		
		System.out.println(person1.getFirstName()); //gives us null because value hasnt been set
		//System.out.println(person1.getFirstName().toUpperCase()); //gives a null point exception because its invoking a method on a null object
	
		person1.setAge(29);
		person1.setFirstName("Derek");
		person1.setLastName("Loisel");
		person1.setPrimarySkill(Skill.JAVA);
		
		System.out.println(person1); //toString is overridden in Person class, doesnt need to call overridded toString because its implicit in println
	
	Person person2 = new Person("Wezley", "Singleton", 27, Skill.JAVA);
	
	Person person3 = new Person("Derek", "Loisel", 29, Skill.JAVA);
	
	System.out.println(person1 == person3); // false because just references memory location
	System.out.println(person1.equals(person3)); //true because its checking the actual values with the overridden hash and equals, if not overriden it behaves same as ==
	}
	
}
