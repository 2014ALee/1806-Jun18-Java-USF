package com.revature.exceptions;

public class TooManyDigitsPastDecimalException extends Exception {
	private static final long serialVersionUID = 1L;

	public TooManyDigitsPastDecimalException() {
		super("No more than two digits past the decimal allowed");
	}

}
