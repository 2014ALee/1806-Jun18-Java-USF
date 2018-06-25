package com.revature.models;

/*
 * Interfaces are implicitly abstract. 
 */

public interface InterfaceA {

	int MY_INT = 35;		// fields declared are implicitly public static final
	
	// the abstract keyword is implied on any method stubs
	
	void doSomething();
	
	// Since java 8, we can declare and provide implementation for default messages
	default void doSomethingElse() {
		System.out.println("InterfaceA is doneing something else...");
	}



}
