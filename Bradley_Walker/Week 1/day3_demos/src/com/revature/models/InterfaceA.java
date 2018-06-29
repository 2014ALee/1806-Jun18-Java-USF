package com.revature.models;

// Interfaces are implicitly abstract

public interface InterfaceA {
	
	// All fields declared in interfaces are implicitly public static final
	int MY_INT = 35;
	
	// All methods are implicitly abstract
	void doSomething();
	
	// Since java 8, interfaces can define method implementations
	default void doSomethingElse() {
		System.out.println("InterfaceA is doing something else");
	}

}
