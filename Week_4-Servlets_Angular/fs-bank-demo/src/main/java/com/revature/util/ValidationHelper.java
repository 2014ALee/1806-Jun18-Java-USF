package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.BankService;

public class ValidationHelper {
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("[LOG] - Processing request with ValidationHelper: " + req.getRequestURI());
		
		BankService service = new BankService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		switch(req.getRequestURI()) {
		case "/fs-bank-demo/email.validate":
			String email = mapper.readValue(json, String.class);
			
			if(service.isEmailAvailable(email)) {
				return email;
			} else {
				return null;
			}
			
		case "/fs-bank-demo/username.validate":
			String username = mapper.readValue(json, String.class);
			
			if(service.isUsernameAvailable(username)) {
				return username;
			} else {
				return null;
			}
			
		default:
			return null;
		}
	}
}
