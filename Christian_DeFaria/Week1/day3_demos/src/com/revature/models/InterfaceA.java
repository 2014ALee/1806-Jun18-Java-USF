package com.revature.models;

//Interfaces are implicitly abstract, you can added it, but it doesn't matter

public interface InterfaceA {
	
	//All fields declared in an interface are implicitly public static final
	int MY_INT = 35;

	//the abstract keyword is implied on any method stubs
	void doSomething();
	
	//Since java 8 wecan declare and provide implementation for default methods
	default void doSomethingElse() {
		System.out.println("InterfaceA is doing something else");
	}
}
