package com.revature.models;

public class InterfaceImpl extends Animal implements InterfaceA, InterfaceB {
	
	// Which interface is this inheriting from?
	@Override
	public void doSomething() {
		System.out.println("Do some stuff...");
	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		
	}
	
	

}
