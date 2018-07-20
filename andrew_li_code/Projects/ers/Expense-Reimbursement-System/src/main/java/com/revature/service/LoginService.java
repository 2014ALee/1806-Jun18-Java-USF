package com.revature.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.dao.ERSUserDAO;
import com.revature.dao.ERSUserDAOImplementation;
import com.revature.models.ERSUser;
import com.revature.util.BasicHelpers;
import com.revature.util.JSONifier;

public class LoginService {
	public static String login(String userObject, HttpSession session) throws ServletException, IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    String[] userInputs = null;
	    try {
	    	userInputs = mapper.readValue(userObject, String[].class);
	    } catch (MismatchedInputException e) {
			return "error:Invalid Request";
	    }
	    if (userInputs == null || userInputs.length != 2) {
			return "error:Invalid Request";
	    }
	    String username = userInputs[0];
	    String password = userInputs[1];
		password = BasicHelpers.hash(password);
		ERSUserDAO usrDAO = new ERSUserDAOImplementation();
		ERSUser ersUser = usrDAO.getERSUserByNameAndPassword(username, password);
		if (ersUser == null) {
			return "error:Invalid Username or Password";
		}
		session.setAttribute("user", ersUser);
		return JSONifier.ersUserToJSON(ersUser);
	}
}