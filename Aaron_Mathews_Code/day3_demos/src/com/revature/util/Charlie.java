package com.revature.util;

import java.io.IOException;

import com.revature.models.Beta;
import com.revature.models.Circle;

public class Charlie extends Beta {
	
	@Override
	public double protectedDoubleGetter() {
		return 5.5;
	}
	
	
	//Method in beta is default (package level) so it can not be seen outside of the package.
	//Override is unnecessary.
//	@Override
	String packageStringGetter() {
		return " ";
	}
	
	
	//Can alter by making the return class a subclass of the original
	//Original is Shape. Circle is a subclass of Shape.
	@Override 
	public Circle getShape() {
		return new Circle();
	}
	
	@Override
	public String protectedStringThrowsException() throws IOException {
		return " ";
	}
	
	

}
