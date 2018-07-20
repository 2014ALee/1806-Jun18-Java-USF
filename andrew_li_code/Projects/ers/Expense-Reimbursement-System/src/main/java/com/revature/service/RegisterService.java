package com.revature.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.dao.ERSUserDAO;
import com.revature.dao.ERSUserDAOImplementation;
import com.revature.util.BasicHelpers;
import com.revature.util.RegistrationValidityCheck;

public class RegisterService {
	public static String register(String userObject, HttpSession session) throws ServletException, IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    String[] userInputs = null;
	    System.out.println("Registering...");
	    try {
	    	userInputs = mapper.readValue(userObject, String[].class);
	    } catch (MismatchedInputException e) {
	    	System.out.println("Mismatched Input");
			return "error:Invalid Request";
	    }
	    if (userInputs == null || userInputs.length != 6) {
			System.out.println(userInputs);
			return "error:Invalid Request";
	    }
	    if (!userInputs[3].equals(userInputs[4])) {
	    	return "error:Passwords don't match!";
	    }
	    String firstName = userInputs[0];
	    String lastName = userInputs[1];
	    String username = userInputs[2];
	    String password = userInputs[3];
	    String email = userInputs[5];
	    String error = RegistrationValidityCheck.check(username, password, firstName, lastName, email);
	    if (error.length() > 4) {
	    	return error;
	    }
		ERSUserDAO usrDAO = new ERSUserDAOImplementation();
		if (usrDAO.getERSUserByUsername(username) != null) {
			return "error:There is already an account registered with that username!";
		}
		if (usrDAO.getERSUserByEmail(email) != null) {
			return "error:There is already an account registered with that email!";
		}

		password = BasicHelpers.hash(password);
		usrDAO.makeUser(firstName, lastName, username, password, email);
		return "";
	}
}
