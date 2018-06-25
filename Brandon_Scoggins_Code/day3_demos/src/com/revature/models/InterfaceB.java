package com.revature.models;

// interfaces can extend multiple other interfaces
public interface InterfaceB extends InterfaceA {

	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("InterfaceB is doing something else.");
	}
}
