package com.revature.models;

/*
 * Doesnt' make sense to have it exist on its own
 * Cannot be instantiated
 * Often contain unimplemented method that must be implemented by concrete subclass
 * Can also have all method implemented but still be abstract to prevent direct instantiation. 
 */
public abstract class Animal {

	public int numberOfLives = 1;

	public Animal() {
		System.out.println("Animal constructor called");
	}

	/*	Abstract methods are methods that don't have a body (no implementation)
	Only have method signature (method stub)
	Concrete subclasses must implement all abstract methods.
	 */


	public abstract void makeSound();

	/*
	 * Can also have concrete methods
	 * Subclasses can still override methods depending on access modifier
	 */
	
	public void exist() {
		System.out.println("The animal is existing");
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
