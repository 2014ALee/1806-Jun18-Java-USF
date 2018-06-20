package com.revature.models;
/*
 * Implicitly abstract
 * Can add abstract but it doesnt matter
 * Can declare variables. They are implicitly public static final.
 * Everything is at least final
 * 
 * Abstract is implied on all method stubs
 */
public interface InterfaceA {
	
	int MY_INT = 35;
	
	void doSomething();
	
	//Since Java8, you can declare and implement for default methods
	default void doSomethingElse() {
		System.out.println("interfaceA is doing something else.");
	}

}
