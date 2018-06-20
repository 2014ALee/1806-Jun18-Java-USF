package com.revature.util;

import com.revature.models.Beta;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Gamma extends Beta{
	
	@Override
	public double protectedDoubleGetter() {
		return 0.;
	}
	
	// This is a different package and cannot access package-level methods
	// even from the direct parent.
//	@Override
//	String packageStringGetter() {
//		return "";
//	}
	
	// This works
	@Override
	public Shape getShape() {
		return new Circle();
	}
	
	// This doesn't because we are trying to use a superclass when
	// it is expecting a specific subclass
//	@Override
//	public Shape getCircle() {
//		return new Circle();
//	}

}
