package com.revature.models;

public class InterfaceImpl extends Animal implements InterfaceA, InterfaceB{
	
	@Override
	public void doSomething()
	{
		System.out.println("Just do it.");
	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		
	}

}
