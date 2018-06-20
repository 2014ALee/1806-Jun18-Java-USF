package com.revature.models;
/*
 * Interfaces extend each other. Classes implement interfaces.
 * Can extend multiple interfaces
 */
public interface InterfaceB extends InterfaceA {
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("InterfaceB is doing something else.");
	}

}
