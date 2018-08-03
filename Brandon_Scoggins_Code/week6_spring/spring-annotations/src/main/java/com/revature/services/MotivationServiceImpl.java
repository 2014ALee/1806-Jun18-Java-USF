package com.revature.services;

import org.springframework.stereotype.Service;

@Service
public class MotivationServiceImpl implements MotivationService{

	@Override
	public String getMotivation() {
		return "Dont quit. Suffer now and live the rest of your life a champion";
	}
	
	public void myDestroyMethod() {
		System.out.println("[DEBIG] - in MotivationService myDestroyMethod()");
	}

}
