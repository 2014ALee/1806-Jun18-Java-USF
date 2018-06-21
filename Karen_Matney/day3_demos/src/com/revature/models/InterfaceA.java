package com.revature.models;
/*
 * Interfaces are implicitly abstract.
 */
public interface InterfaceA {
	//All fields declared within an interface are implicitly public static final
	int MY_INT = 35;

	// The abstract keyword is implied on any method stubs
	void doSomething();

	// Do need to specify not abstract (with the default keyword), since Java 8
	default void doSomethingElse() {
		System.out.print("InterfaceA is doing something else...");
	}
}