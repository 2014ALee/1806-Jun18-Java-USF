package com.revature.models;

public class Cat extends Animal {

	private int numberOfLives;
	private String breed;
	private boolean hasFur;
	
	public Cat() {
		this.numberOfLives= 9;
		this.breed= "domestic shorthair";
		this.hasFur= ;
	}
	public Cat(int numberOfLives, String breed, boolean hasFur) {
		super();
		this.numberOfLives = numberOfLives;
		this.breed = breed;
		this.hasFur = hasFur;
		
		
	}
	
	
}
