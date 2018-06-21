package com.revature.models;

//cannot be instantiated
//often contain unimplemented methods that must be overriden by a concrete subclass
//but, sometimes an abstract class has no implemented methods to prevent instantiation

public abstract class Animal {

	public int numberOfLives = 1;
	
	public Animal() {
		System.out.println("Animal constructor called");
	}
	
	//abstract methods have no body or implementation. Just signature (method stub), parameters and return type
	//any subclass extending this must implement all of it's abstract methods.
	
	public abstract void makeSound();
	
	//they can have concrete methods
	//subclasses can still override the concrete methods if they want to
	
	public void exist() {
		System.out.println("Animal exists");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfLives;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (numberOfLives != other.numberOfLives)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [numberOfLives=" + numberOfLives + "]";
	}
		
	
}
