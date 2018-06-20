package com.revature.models;

public abstract class Animal {
	
	public int numberOfLives = 1;
	
	public Animal() {
		System.out.println("Animal successfully created");
	}
	
	/*
	 * Abstract methods are methods that have no implementation. They only have 
	 * a method signature. a.k.a. method stub.
	 * 
	 * Any concrete subclass must implement the abstract methods
	 */
	public abstract void makeSound();
	
	/*
	 * Abstract classes can have concrete methods. (methods with implementations)
	 * However, subclasses can still override these methods
	 */
	public void die() {
		System.out.println("Who wants to live forever");
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
