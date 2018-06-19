package com.revature.models;

/*
 * A class is a blueprint or template from which objects are created.
 * Classes can contain variables, methods, nested classes - which are all collectively
 * known as the 'members' of the class
 * 
 * if no parent class is explicitly extended, the the object class is implicitly extended
 * 
 */

public class Person {

	// instance variable
	public String firstName = "John";
	public String lastName = "Sample";
	public int age_yrs = 35;
	public double height_in = 72.0;
	public double weight_lbs = 180;
	
	// class variables
	// class variables do not change no matter which instance 
	public static final boolean IS_HUMAN = true;
	public static int someValue = 0;
	
	/*
	 * Constructors
	 */
	
	// no-arg Constructor
	public Person() {
		
	}
	// overloaded constructor
	public Person(String fn) {
		this.firstName = fn;
	}
	
	/*
	 * Methods
	 */
	
	public double calculateBMI() {
		return (this.weight_lbs / this.height_in / this.height_in * 703);
	}
	
	public static void Eat() {
		System.out.println("The person is eating.");
	}
	
	public double calculateBMI(double height, double weight) {
		return (weight / height / height) *703;
	}
	
}
