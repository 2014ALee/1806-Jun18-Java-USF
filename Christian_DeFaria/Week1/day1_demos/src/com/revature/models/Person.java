package com.revature.models;

/*
 * This is a class. A class is a blueprint, or template, from which objects are created.
 * Classes can contain variables, methods, and nested classes - which are all collectively
 * known as the 'members' of the class
 * 
 * If no parent class is explicitly extended, the the Object class is implicitly extended.
 */

public class Person {
	public String firstName = "John";
	public String lastName = "Sample";
	public int age_yrs = 35;
	public double height_in = 72.0;
	public double weight_lbs = 180.0;
	
	//Class Variables
	public static final boolean IS_HUMAN = true;
	public static int someValue;
	
	/*
	 * Constructors
	 */
	public Person() {
		
	}
	
	public Person(String firstName) {
		this.firstName = firstName;
	}
	
	/*
	 * Methods
	 */
	public double calculateBMI() {
		return (this.weight_lbs / this.height_in / this.height_in) * 703;
	}
	
	public static void eat() {
		System.out.println("The personis eating");
	}
	
	public double calculateBMI(double height, double weight) {
		return (weight / height / height) * 703;
	}
}
