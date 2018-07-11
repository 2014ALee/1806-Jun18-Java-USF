package com.revature;

import java.util.ArrayList;

import com.activities.*;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
//import com.revature.models.Account;
import com.revature.models.User;


public class BankDriver {	

	public static void main(String[] args) {


		Main.mainMenu();

		System.out.println("\nSpining out the application.....");

		System.out.println("========================================== Get User by id =============================================");

		UserDAO userDAO = new UserDAOImpl();

		ArrayList<User> users = userDAO.getAllUsers();

		for(User art : users) {
			System.out.println(art);
		}
	}
}




