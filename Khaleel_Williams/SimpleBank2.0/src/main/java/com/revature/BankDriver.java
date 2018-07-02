package com.revature;

import java.sql.Connection;
import java.util.ArrayList;

import com.revature.dao.ImplementCustomerInt;
import com.revature.model.*;
import com.revature.util.MakeConnection;

public class BankDriver {
	
	public static void main(String[] args) {
		
		//Bank.mainMenu();
//		MakeConnection connect = MakeConnection.getConnectionInstance();
//		Connection conn = connect.makeConnection();
		
		//prints all customers
		Customers customer = new Customers();
		ImplementCustomerInt db = new ImplementCustomerInt();
		
		ArrayList<Customers> cus = db.getAllCustomers();
		
		for (Customers c : cus) {
			System.out.println(c);
		}
		
//		Customers cus = new Customers("testing", "open");
//		
//		ImplementCustomerInt customers = new ImplementCustomerInt();
//		customer = db.getCustomerByUsername("khaleel");
//		customer.add((float) 800.00);
//		db.updateBalance(customer);

	}

}
