package com.revature.models;

/*
 * Interfaces are implicitly abstract, you can add it, but it makes no difference
 */

public interface InterfaceA {
	
	//it's public static final int
	//all fields declared in an interface are public static final, implicitly
	int MY_INT = 35;
	
	void doSomething();
	
	//since java 8 we can declare and provide implentation for default methods
	default void doSomethingElse() {
		System.out.println("Interface A is doing something else...");
	}
	

}
