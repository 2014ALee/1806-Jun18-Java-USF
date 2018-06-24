package com.revature.models;

/*
 * An abstract is a class that cannot be instantiated. Abstract classes often contain unimplemented methods that
 * MUST be overridden by a concrete subclass. Although there are cases where an abstract class has no unimplemented
 * methods and is declared as abstract simply to prevent direct instantiation.
 */
public abstract class Animal {
	public int numberOfLives = 1;
	
	public Animal()
	{
		System.out.println("Animal Constructor called");
	}
	/*
	 * Abstract methods are methods that have no implementation (the body, or what goes in the curly braces).
	 * They only consist of a method signature - also known as a method stub.
	 * 
	 * Any concrete subclass that extends this class will be required to implement all of its abstract methods.
	 */
	
	public abstract void makeSound();
	
	/*
	 * Abstract methods can have concrete methods (methods with implementation). However, subclasses can still override
	 * these concrete methods with their own implementation if desired. (@Override)
	 */
	
	public void exist()
	{
		System.out.println("The animal is extant.");
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
