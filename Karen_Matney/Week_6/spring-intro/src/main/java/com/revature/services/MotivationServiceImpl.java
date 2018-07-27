package com.revature.services;

public class MotivationServiceImpl implements MotivationService {
	public void myDestroyMethod() {
		System.out.println("[Debug] - Inside MotivationService.myDestroyMethod()");
	}
	
	@Override
	public String getMotivation() {
		return "Don't quit. Suffer now and life the rest of your life a champion";
	}

}
