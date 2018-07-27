package com.revature.exceptions;

public class InvalidCreditialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCreditialsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidCreditialsException(String arg0) {
		super(arg0);
	}

	public InvalidCreditialsException(Throwable arg0) {
		super(arg0);
	}
	
	

}
