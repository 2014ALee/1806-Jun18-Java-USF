package com.revature.models;

public class Cat extends Animal {
	
	private int numberOfLives;
	private String breed;
	private boolean hasFur;
	
	public Cat() {
		super();
		this.numberOfLives = 9;
		this.breed = "Dometic shorthair";
		this.hasFur = true;
	}
	
	public Cat(int numberOfLives, String breed, boolean hasFur) {
		super();
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		this.hasFur = hasFur;
	}
	
	public Cat(int numberOfLives, String breed) {
		super();
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		
		this.hasFur = (breed.equalsIgnoreCase("Sphinx")) ? false : true;
	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Cat is scaring ");
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
	
	
}
