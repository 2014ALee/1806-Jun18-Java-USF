package com.revature.util;

import com.revature.models.*;

public class Charlie extends Beta {
	@Override
	public double myProtectedDoubleGetter() {
		return 5.5;
	}
	
	@Override
	public Oval getShape() {
		return new Circle();
	}
}
