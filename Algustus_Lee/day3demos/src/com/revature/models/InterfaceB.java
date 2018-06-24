package com.revature.models;

//Interfaces can inherit from one another, and they can extend multiple other interfaces if desired.

public interface InterfaceB extends InterfaceA{

	void doSomething();
	default void doSomethingElse()
	{
		System.out.println("InterfaceB is doing something else.");
	}
}
