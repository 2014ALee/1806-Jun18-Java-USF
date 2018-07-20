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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		System.out.println("[LOG] - Request sent to UpdateServlet.doPost()");

		ERSService service = new ERSService();

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";

		if (br != null) {	
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();

		String[] receivedValue = mapper.readValue(json, String[].class);
		int reimId = Integer.parseInt(receivedValue[0]);
		int reimStatusId = Integer.parseInt(receivedValue[1]);

		HttpSession session = req.getSession();
		ERSUser sessionUser = (ERSUser) session.getAttribute("user");
		
		boolean success = service.updateReimCase(reimId, reimStatusId, sessionUser);

//		if (success) {
//			System.out.println("[LOG] - Reim status update successful in UpdateServlet");
//		} else {
//			System.out.println("[LOG] - Reim status update failed in UpdateServlet");
//		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(success);

		pw.write(userJSON);
	}
}
