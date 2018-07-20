package com.revature.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.dao.ERSReimbursementDAO;
import com.revature.dao.ERSReimbursementDAOImplementation;
import com.revature.exceptions.InvalidNumberException;
import com.revature.exceptions.NegativeAmountException;
import com.revature.exceptions.TooManyDigitsPastDecimalException;
import com.revature.models.ERSUser;
import com.revature.models.ReimbursementType;
import com.revature.models.UserRole;
import com.revature.util.BasicHelpers;
import com.revature.util.SessionCheck;

public class SubmitReimbursementRequestService {
	public static String makeRequest(String userObject, HttpSession session) throws ServletException, IOException {
		ERSUser ersUser = SessionCheck.checkSession(session);
		if (ersUser == null) {
			return "error:Invalid Session";
		}
		if (ersUser.getRole() == UserRole.FINANCE_MANAGER) {
			return "error:Managers should directly contact the administration.";
		}
	    ObjectMapper mapper = new ObjectMapper();
	    String[] userInputs = null;
	    try {
	    	userInputs = mapper.readValue(userObject, String[].class);
	    } catch (MismatchedInputException e) {
			return "error:Invalid Request";
	    }
	    if (userInputs == null || userInputs.length != 3) {
			return "error:Invalid Request";
	    }
	    int amount = 0;
	    try {
	    	long amountTemp = BasicHelpers.fromDollarString(userInputs[0]);
	    	if (amountTemp > 100000000) {
	    		return "error:Exceeded maximum request amount...";
	    	}
	    	amount = (int) amountTemp;
	    } catch (InvalidNumberException e) {
	    	return "error:Invalid Number";
	    } catch (NegativeAmountException e) {
	    	return "error:Negative values are not allowed.";
	    } catch (TooManyDigitsPastDecimalException e) {
	    	return "error:More than two digits past decimal";
	    }
	    ReimbursementType givenType = ReimbursementType.OTHER;
	    switch (userInputs[1]) {
	    case "1":
	    	givenType = ReimbursementType.LODGING;
	    	break;
	    case "2":
	    	givenType = ReimbursementType.TRAVEL;
	    	break;
	    case "3":
	    	givenType = ReimbursementType.FOOD;
	    	break;
	    case "4":
	    	break;
	    default:
	    	return "error:Invalid Option";
	    }
	    
	    String description = userInputs[2];
	    if (description.length() > 250) {
	    	return "error:Description is too long!";
	    }
		ERSReimbursementDAO reimbursementDAO = new ERSReimbursementDAOImplementation();
		reimbursementDAO.makeRequest(ersUser, amount, description, givenType.getId());
		
		return "partials/finishsubmittingrequest.html";
	}
}
