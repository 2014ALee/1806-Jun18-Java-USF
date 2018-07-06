package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import com.revature.dao.ImplementCustomerInt;
import com.revature.model.Customers;

public class BankTest {
	ImplementCustomerInt cus = new ImplementCustomerInt();
	
	@Test
	public void TestAddCustomer() {
		ImplementCustomerInt cus = new ImplementCustomerInt();
		Customers c = new Customers("kill", "bill");
		assertEquals("Test Failed", false, cus.addCustomer(c));
		
	}
	
	@After
	public void DeleteCustomer() {
		
	}
	
//	@Test
//	public void TestAddCustomer1() {
//		ImplementCustomerInt cus = new ImplementCustomerInt();
//		Customers c = new Customers("kill", "bill");
//		assertEquals("Test Failed", true, cus.addCustomer(c));
//		
//	}

}
