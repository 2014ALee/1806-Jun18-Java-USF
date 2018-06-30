package com.revature.models;

/*
 * This is a class. A class is a blueprint, or template, from which objects are created.
 * Classes can contain variables, methods, and nested classes - which are all collectively
 *  known as the 'members' of the class.
 * 
 *  If no parent class is explicitly extended, then the Object class is implicitly extended.
 */

public class Person {
	/*
	 * Instance variables are unique values sp
	 */
	public String firstName = "John";
	public String lastName = "Sample";
	public int age_yrs = 35;
	public double height_in = 72.0;
	public double weight_lbs = 180;

	// Class variables (or static), belong to that class
	public static final boolean IS_HUMAN = true;
	public static int someValue; // Default value of 0;

	/*
	 * Constructors
	 */

	// No args/Default constructor, needs to be defined if another constructor created
	// public Person()
	public Person() {

	}

	// need to be unique in method signatures
	public Person(String fn) {
		this.firstName = fn;
	}

	/*
	 * Methods
	 */

	public double calculateBMI() {
		return (this.weight_lbs / this.height_in / this.height_in)* 703; 
	}

	public static void eat() {
		// System.out.println(this.iseating()); // makes no sense because referencing an instance variable
		System.out.println("This person is eating.");
	}

	// Overloaded method: public double calculateBMI(double height, double weight)
}