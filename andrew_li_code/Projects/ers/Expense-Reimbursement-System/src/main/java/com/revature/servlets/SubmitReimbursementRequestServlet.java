package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.SubmitReimbursementRequestService;


@WebServlet("/submitrequest")
public class SubmitReimbursementRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost SubmitRequest");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
	    String requestInput = "";
	    if(reader != null) {
		    requestInput = reader.readLine();
	    }
	    System.out.println(requestInput);
	    System.out.println("That was the input.");
	    String responseString = SubmitReimbursementRequestService.makeRequest(requestInput, req.getSession());
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(responseString);
	}
}
