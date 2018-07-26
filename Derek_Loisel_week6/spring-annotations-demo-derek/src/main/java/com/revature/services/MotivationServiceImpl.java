package com.revature.services;

import org.springframework.stereotype.Service;

@Service
public class MotivationServiceImpl implements MotivationService{

	public void myDestroyMethod() {
		System.out.println("in my destroy method");
	}
	@Override
	public String getMotivation() {
		return "Get motivated, ok?";
	}

	
}
