package com.revature.services;

public class MotivationServiceImpl implements MotivationService{

	public void myDestroyMethod() {
		System.out.println("in my destroy method");
	}
	@Override
	public String getMotivation() {
		return "Get motivated, ok?";
	}

	
}
