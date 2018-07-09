package com.revature.exceptions;

public class InvalidNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidNumberException() {
		super("Invalid Number");
	}
}
