package com.revature.models;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	private Skill primarySkill;
	
	public Person() {
		this.firstName = "N/A";
		this.lastName = "N/A";
		this.age = 0;
		this.primarySkill = Skill.JAVA;
	}
	
	public Person(String firstName, String lastName, int age, Skill primarySkill) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
		setPrimarySkill(primarySkill);
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", primarySkill="
				+ primarySkill + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Skill getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(Skill primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}