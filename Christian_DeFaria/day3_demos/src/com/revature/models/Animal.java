package com.revature.models;

public abstract class Animal {
	
	public int numberOfLives = 1;
	public Animal() {
		System.out.println("Animal construtor called");
	}

	/*
	 * Abstract methods are methods that have no implementation(body). They only consist of a method
	 * signature - also known as a method stub.
	 * 
	 * Any concrete subclass that extends this class will be required to implement all of its abstract
	 * methods.
	 */
	public abstract void makeSound();
	
	/*
	 * As was mentioned, abstract classes can have concrete methods. However,
	 * subclasses can still override these concrete methods with their own implementation if desired.
	 */
	public void exist() {
		System.out.println("The animal is existing...");
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
}
