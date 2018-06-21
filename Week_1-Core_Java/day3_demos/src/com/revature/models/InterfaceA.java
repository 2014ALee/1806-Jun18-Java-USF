package com.revature.models;

//Interfaces are implicitly abstract, you can add it - but it makes no difference.
public interface InterfaceA {

	// All fields declared within an interface are implicitly public static final
	int MY_INT = 35;
	
	// the abstract keyword is implied on any method stubs
	void doSomething();
	
	// Since Java 8, we can declare and provide implementation for default methods
	default void doSomethingElse() {
		System.out.print("InterfaceA is doing something else...");
	}
}