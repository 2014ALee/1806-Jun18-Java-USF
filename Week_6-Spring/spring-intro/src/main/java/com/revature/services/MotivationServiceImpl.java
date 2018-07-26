package com.revature.services;

public class MotivationServiceImpl implements MotivationService {

	public void myDestroyMethod() {
		System.out.println("[DEBUG] - Inside MotivationServiceImpl.myDestroyMethod()");
	}
	
	@Override
	public String getMotivation() {
		return "Don't quit. Suffer now and live the rest of your life a champion.";
	}

}
