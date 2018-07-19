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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.ErsService;
import com.revature.util.SendEmailHelper;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to RegistrationServlet.doPost()");

		ErsService service = new ErsService();

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		User temp = mapper.readValue(json, User.class);

		//check for null values in temp to make sure its a full user
		if(temp.getUsername() == "" || temp.getUsername() == null
				|| temp.getPassword() == "" || temp.getPassword() == null
				|| temp.getFirstname() == "" || temp.getFirstname() == null
				|| temp.getLastname() == "" || temp.getLastname() == null
				|| temp.getEmail() == "" || temp.getEmail() == null){
			temp = null;			
		}else {

			//here call service methods to check username and email availability
			boolean userAvail = service.isUsernameAvailable(temp.getUsername());
			boolean emailAvail = service.isEmailAvailable(temp.getEmail());
			//if statement here to either add user or set temp as null
			if(userAvail && emailAvail) {
				//add user to database
				temp = service.addUser(temp);
				
				//if it's an admin creating a manager account, send them an email with their user and pass
				HttpSession sessionUser = req.getSession(false);		
				User u = (User)sessionUser.getAttribute("user");
				if(u.getUserRoleID() == 3) {
					SendEmailHelper.sendEmail(u.getEmail(), temp.getEmail(), temp.getUsername(), temp.getPassword());
				}
				
			}else {
				temp = null;
			}	

		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}

}