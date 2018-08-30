package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.AccountClient;
import com.revature.models.Customer;

@RestController
public class CustomerController {
	@Autowired
	private AccountClient accountClient;
	private List<Customer> customers;
	
	public CustomerController() {
		customers = new ArrayList<>();
		customers.add(new Customer());
		customers.add(new Customer());
		customers.add(new Customer());
		customers.add(new Customer());
	}
	
	@GetMapping(value="{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		Customer customer = customers.stream().filter(cust -> cust.getCustomerId() == customerId).findFirst().get();
		List<Account> customerAccounts = accountClient.getAccounts(customerId);
		customer.setAccounts(customerAccounts);
		return customer;
	}
}
