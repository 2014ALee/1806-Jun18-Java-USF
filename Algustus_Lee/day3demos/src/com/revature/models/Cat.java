package com.revature.models;

public class Cat extends Animal {

	private int numberOfLives;
	private String breed;
	private boolean hasFur;
	
	public Cat() {
		this.numberOfLives = 9;
		this.breed = "Domestic Shorthair";
		this.hasFur = true;
	}
	
	public Cat(int numberOfLives, String breed, boolean hasFur) {
		super(); //not required, is implied.
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		this.hasFur = hasFur;
	}

	public Cat(int numberOfLives, String breed)
	{
//		this.numberOfLives = numberOfLives;
//		this.breed = breed;
//		
//		if(breed.equalsIgnoreCase("Sphinx"))
//		{
//			this.hasFur = false;
//		}
//		else
//		{
//			this.hasFur = true;
//		}
		this.hasFur = (breed.equalsIgnoreCase("Sphinx")) ? false : true; //Ternary Operators
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public void makeSound() {
		System.out.println("nyan");
		
	}
	
	
}
