package com.revature.models;

public abstract class Animal {
	public int numberOfLives = 1;
	
	public Animal() {
		System.out.println("Animal constructor called");
	}
	
	public abstract void makeSound();
	
	public void exist() {
		System.out.println("The animal is existing...");
	}
}
