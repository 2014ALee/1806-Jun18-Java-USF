package com.revature.models;

public class Person {

	//if no parent class is explicitly extended, Object is
	
	//instance vars
	public String firstName = "John";
	public String lastName = "Sample";
	public int age_yrs = 35;
	public double height_in = 72.0;
	public double weight_lbs = 180;
	
	
	//class vars
	public static final boolean IS_HUMAN = true;
	 
	
	
	//constructors
	
	public Person() {
		
	}
	
	public double calculateBMI() {
		double BMI = (this.weight_lbs/this.height_in/this.height_in)*703;
		
		return BMI;
	}
	
	public static void eat() {
		System.out.println("Person is eating");		
	}
	
	
	
	
	//method
	
}
