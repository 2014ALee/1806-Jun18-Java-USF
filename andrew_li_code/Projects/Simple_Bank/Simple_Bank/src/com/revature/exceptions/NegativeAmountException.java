package com.revature.exceptions;

public class NegativeAmountException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NegativeAmountException() {
		super("Cannot input a negative amount.");
	}

}
