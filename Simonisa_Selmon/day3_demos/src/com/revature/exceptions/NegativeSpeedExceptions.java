package com.revature.exceptions;

public class NegativeSpeedExceptions extends Exception {
	
	private static final long serialVersonUID =1L;
			
	public NegativeSpeedException() {
		super("cannot go a negative speed");
	}

}
