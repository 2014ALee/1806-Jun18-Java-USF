package com.revature.services;

public class MotivationServiceImpl implements MotivationService {

	@Override
	public String getMotivation() {
		return "Don't quit. Suffer now and live the rest of your life a champion.";
	}
	
	public void myDestroyMethod() {
		System.out.println("Inside MotivationServiceImple.myDestroyMethod()");
	}

}
