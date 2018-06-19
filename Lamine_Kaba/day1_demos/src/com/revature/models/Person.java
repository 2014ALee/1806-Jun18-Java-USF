package com.revature.models;

/*
 * This is a class. a class is a blueprint, or a template, from which objects are created.
 * Classes can contain variables, methods, and nested classes - which are all collectively known as the 'members' of the class.
 * 
 * If no parent class is explicitly extended, then the Object class is implicitly extended.
 */

public class Person {
	// Instance variables
	public String firstName = "john";
	public String lastName = "Sample";
	public int age_yrs = 35;
	public double heigt_in = 72.0;
	public double weigh_lbs = 100;
	
	// Class variables
	public static final boolean IS_HUMAN = true;
	public static int someValue;

	/*
	 * Constructors
	 */
	public Person() {
		
	}
	public Person(String fn) {
		this.firstName = fn;
	}
	
	/*
	 * Methods
	 */
	public double calculateBMI() {
		return (this.weigh_lbs/this.heigt_in/this.heigt_in)* 703;
	}
}


















