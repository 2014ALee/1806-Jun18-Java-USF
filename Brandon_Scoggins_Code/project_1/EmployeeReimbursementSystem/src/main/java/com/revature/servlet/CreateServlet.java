package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ERSUser;
import com.revature.services.ERSService;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("[LOG] - Request sent to CreateServlet.doPost()");

		ERSService service = new ERSService();

		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";

		if (br != null) {	
			json = br.readLine();
		}

		// 2) Initiate the Jackson object mapper which will allow conversion to and from java objects to JSON
		ObjectMapper mapper = new ObjectMapper();

		// 3) Convert received JSON to String array 
		String[] newReimInfo = mapper.readValue(json, String[].class);
		double reimAmount = Double.parseDouble(newReimInfo[0]);
		int reimType = Integer.parseInt(newReimInfo[1]);
		String reimDesc = newReimInfo[2];

		HttpSession session = req.getSession();
		ERSUser sessionUser = (ERSUser) session.getAttribute("user");
		
		boolean success = service.createReimbursement(sessionUser.getUserId(), reimAmount, reimDesc, reimType);

		if (!success) {
			System.out.println("[LOG] - Unable to insert new reimbursement case into database");
		} else {
			System.out.println("[LOG] - Successfully inserted new reimbursement case into database");
		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String successJSON = mapper.writeValueAsString(success);

		pw.write(successJSON);
	}
}
