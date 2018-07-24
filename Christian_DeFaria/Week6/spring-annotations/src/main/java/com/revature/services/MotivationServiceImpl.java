package com.revature.services;

import org.springframework.stereotype.Service;

@Service
public class MotivationServiceImpl implements MotivationService {

	@Override
	public String getMotivation() {
		return "Run";
	}
	
	public void myDestroyMethod() {
		System.out.println("[DEBUG] - in myDestroyMethod");
	}

}
