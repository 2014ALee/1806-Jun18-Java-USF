package com.revature.models;

public class Person {
	
	private String firstName;
	private String lastName;
	private int ageYears;
	private double heightInches;
	private double weightPounds;
	
	public static final boolean IS_HUMAN = true;
	public static int uninitializedInt;
	
	public Person(String firstname, String lastname, 
			int ageyears, double heightinches, double weightpounds) {
		firstName = firstname;
		lastName = lastname;
		ageYears = ageyears;
		heightInches = heightinches;
		weightPounds = weightpounds;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAgeYears() {
		return ageYears;
	}
	
	public double getHeightInches() {
		return heightInches;
	}
	
	public double getWeightPounds() {
		return weightPounds;
	}
	
	public void setFirstName(String firstname) {
		firstName = firstname;
	}
	
	public void setLastName(String lastname) {
		lastName = lastname;
	}
	
	public void setAgeYears(int ageyears) {
		ageYears = ageyears;
	}
	
	public void setHeightInches(double heightinches) {
		heightInches = heightinches;
	}
	
	public void setWeightPounds(double weightpounds) {
		weightPounds = weightpounds;
	}

}
