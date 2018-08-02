package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.AccountClient;
import com.revature.models.Account;
import com.revature.models.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private AccountClient accountClient;
	
	private List<Customer> customers;
	
	public CustomerController() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "Wezley Singleton", "ws@revature.com", null));
		customers.add(new Customer(2, "Genesis Bonds", "gb@revature.com", null));
		customers.add(new Customer(3, "Christian DeFaria", "cd@revature.com", null));
		customers.add(new Customer(4, "Yosef ElSadaany", "ye@revature.com", null));
	}
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customers;
	}
	
	@GetMapping(value="{customer_id}")
	public Customer getCustomerById(@PathVariable int customer_id) {
		Customer customer = customers.stream().filter(cust -> cust.getCustomer_id() == customer_id).findFirst().get();
		List<Account> customerAccounts = accountClient.getAccounts(customer_id);
		customer.setAccounts(customerAccounts);
		return customer;
	}

}
