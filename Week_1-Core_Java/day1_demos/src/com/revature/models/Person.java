package com.revature.models;
/*
 * This is a class. A class is a blueprint, or a template, from which objects are created.
 * Classes can contain variable, methods, and nested classes - which are all collectively
 * known as the 'members' of the class
 * 
 * If no parent class is explicityly extended, then the Object class is implicitly extended.
 */

public class Person {
	public String firstName = "John";
	public String lastName = "Sample";
	public int age_years = 35;
	public double height_in = 72.0;
	public double weight_lbs = 180;
	
	//Class variables
	public static final boolean IS_HUMAN = true;
	public static int someValue;
	
	/*
	 * Constructors
	 * A block of code similar to a method. 
	 * Name must match the class
	 */
	public Person() {
		
	}
	public Person(String firstName) {
		this.firstName = firstName; 
	}
	
	/*
	 * Method
	 * Set of java commands that are given a specific name.
	 * Can take parameters and return
	 */
	public double calculateBMI() {
		return this.weight_lbs / this.height_in / this.height_in * 703;
	}
	
	//Overloading method
	public double calculateBMI(double weight, double height) {
		return weight / height / height * 703;
	}
	
	public static void eat() {
		System.out.println("The person is eating.");
	}
}
