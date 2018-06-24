package com.revature.models;

/*
 * Interfaces are implicitly abstract. Adding it makes no difference.
 */
public interface InterfaceA {

	int MY_INT = 35; //All fields declared in an interface are implicitly public static final.

	//The abstract keyword is implied on any method stubs.
	
	void doSomething();
	
	//Since Java 8, we can declare and provide implementation for default methods.
	default void doSomethingElse()
	{
		System.out.println("InterfaceA is doing something else.");
	}

}
