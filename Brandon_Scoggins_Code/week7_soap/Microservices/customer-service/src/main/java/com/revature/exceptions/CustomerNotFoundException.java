package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(Long customerId) {
		super("No customer found with id: " + customerId);
	}
	
	public CustomerNotFoundException(String email) {
		super("No customer found with email: " + email);
	}
}
