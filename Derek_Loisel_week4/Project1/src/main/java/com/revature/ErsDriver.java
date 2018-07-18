package com.revature;

import com.revature.models.User;
import com.revature.services.ErsService;
import com.revature.util.SendEmailHelper;

public class ErsDriver {

	public static void main(String[] args) {

		
		//testing sendEmail()
		String fromEmail = "djloisel19@gmail.com";
		String toEmail = "djloisel@yahoo.com";
		String username = "CoolUsername";
		String password = "p4ssw0rd";
		
		SendEmailHelper.sendEmail(fromEmail, toEmail, username, password);
				
		//testing DAO
		
//		User temp = new User();
//		temp.setUserID(0);
//		temp.setFirstname(null);
//		temp.setLastname(null);
//		temp.setEmail(null);
//		temp.setUsername(null);
//		temp.setPassword(null);
//		temp.setUserRoleID(1);
//		
//		UserDAO userDAO = new UserDAOImpl();
//		userDAO.addUser(temp);
		
		
//		ErsService service = new ErsService();
//		
//		boolean userAvail = service.isUsernameAvailable("jack");
//		System.out.println(userAvail);
//		System.out.println("-----------");
//		
//		User u = service.getUserByUsernameCallable("admin");
//		System.out.println(u.getUserID());
//		System.out.println(u.getUsername());
//		System.out.println(u.getPassword());
//		System.out.println(u.getFirstname());
//		
//		User u2 = service.getUserByUsername("admin");
//		System.out.println("--------------");
//		System.out.println(u2.getUserID());
//		System.out.println(u2.getUsername());
	}
	
}
