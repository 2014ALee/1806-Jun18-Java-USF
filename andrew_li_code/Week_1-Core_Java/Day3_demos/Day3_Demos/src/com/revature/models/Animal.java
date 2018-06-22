package com.revature.models;

/*
 * An abstract is a class that cannot be instantiated. Abstract classes often contain unimplemented
 * methods thatMUST be overridden by a concrete subclass. ALthough there are cases
 * where an abstract class has no unimplemented methods and is declared
 * as abstract simply to prevent direct instantiation.
 */
public abstract class Animal {
	
	public int numberOfLives = 1;
	
	public Animal() {
		System.out.println("Animal instantiated");
	}
	/*
	 * Abstract methods have no implementation. They only consist of a method signature and a method stub.
	 * 
	 * Any concrete subclass that extends this class will be required to implement all of its abstract methods.
	 */
	public abstract void makeSound();
	
	/*
	 * Abstract classes can have concrete methods (methods with implementation).
	 * HOwever, subclasses can still override these concrete methods with
	 * their own implementation if desired.
	 */
	
	
}
