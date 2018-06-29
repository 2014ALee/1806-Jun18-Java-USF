package com.revature.models;

//abstract classes are often used when its something very generic or a general idea that doesnt make much sense to make instances of.

public abstract class Animal {

	public int numberOfLives = 1;
	
	//abstract classes have constructors for the extended classes
	public Animal() {
		System.out.println("animal constructor called!");
	}
	
	/*
	 * abstract methods are methods that have no implementation(body).  they only consist of a method signature, also known as a method stub.
	 * 
	 * any non abstract subclass that extends this class will be required to implement all of its abstract methods.
	 */
	
	//abstract method
	public abstract void makeSound();
	
	//abstract classes can have concrete methods as well(with implementation), subclasses can still override these.
	public void exist() {
		System.out.println("the animal is existing");
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
		return "Animal [numberOfLives=" + numberOfLives + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
