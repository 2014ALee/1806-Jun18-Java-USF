package com.revature.models;


/*
 * Interfaces can extend one another, and even extend multiple interfaces if desired.
 */

public interface InterfaceB extends InterfaceA {
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("Interface B is doing something else...");
	}

}
