package com.revature.servlets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.service.ErsService;

@WebServlet("/adminSubmit")
public class AdminSubmitServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		////System.out.println("Submitted reimbursement Servlet called");
		ErsService eservice = new ErsService();
		HttpSession session = req.getSession();
		Scanner scan = new Scanner(new InputStreamReader(req.getInputStream()));
		User currentUser = (User)session.getAttribute("user");
		int returnCode = 0;
		String json = "";
		if(scan != null) {
			json = scan.nextLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement[] reimbs = (Reimbursement[]) mapper.readValue(json, Reimbursement[].class);
		
		for(Reimbursement reimb : reimbs) {
			////System.out.println(reimb);
			////System.out.println(reimb.getAction().equals("Approve"));
			if(reimb.getAction().equals("Approve")) {
				//System.out.println("One Approved");
				eservice.resolveReimbursement(currentUser, reimb, 2);
			}
			else if(reimb.getAction().equals("Deny")) {
				//System.out.println("One Denied");
				eservice.resolveReimbursement(currentUser, reimb, 3);
			}
			else {
				//System.out.println("Somehow, the action wasn't approve or deny. Error");
				returnCode = 1;
			}
		}
		
//		//System.out.println("reimb length: "+reimb.length);
//		//System.out.println("reimb tostring: "+reimb.toString());
//		for (int i = 0; i < reimb.length; i++) {
//			//System.out.println("number of reimbs "+ i);
//			//System.out.println("reimb: "+(Reimbursement[i]) reimb);
//		}
		
		PrintWriter pw1 = res.getWriter();
		res.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(returnCode);
		pw1.write(userJSON);
		scan.close();
	}

}
