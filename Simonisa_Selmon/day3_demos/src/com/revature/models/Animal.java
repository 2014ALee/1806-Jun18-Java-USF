package com.revature.models;

public abstract class Animal {
	
	public int numoflives= 1;
	
	public Animal() {
		Sys.out.println("Animal constructor called!");
	}
	public abstract void makeSound();
	
	public void exist() {
		Sys.out.println("the animal is existed...");
		
	}
}
