package com.revature.util;

import com.revature.models.Beta;
import com.revature.models.Circle;

public class Charlie extends Beta {
	
	@Override
	public double protectedDoubleGetter() {
		return 5.5;
	}
	
	/*
	 * Methods with pa
	 */
	
//	@Override
//	String packageStringGetter() {
//		return "nope";
//	}
	
	@Override
	public Circle getShape() {
		return new Circle();
	}
	
	@Override
	public Shape getCircle() {
		return new Circle();
	}
}
