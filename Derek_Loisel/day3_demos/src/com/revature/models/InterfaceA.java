package com.revature.models;

/*
 * Interfaces are implicitly abstract
 */
public interface InterfaceA {

	//fields in interface are implicitly public static final
	int MY_INT = 35;
	
	//the abstract keyword is implied on any method stubs
	void doSomething();
	
	// can add implementation by declaring default 
	default void doSomethingElse() {
		System.out.println("InterfaceA is doing something else...");
	}
}
