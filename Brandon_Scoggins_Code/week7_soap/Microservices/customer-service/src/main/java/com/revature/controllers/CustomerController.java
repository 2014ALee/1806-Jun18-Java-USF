package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.AccountClient;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.CustomerType;

@RestController
public class CustomerController {

	@Autowired
	private AccountClient accountClient;
	
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	private List<Customer> customers;
	
	public CustomerController() {
		customers = new ArrayList<>();
		customers.add(new Customer(1L, "Veronica Marrero", "vmarrero@gmail.com", CustomerType.INDIVIDUAL, null));
		customers.add(new Customer(2L, "Genesis Bonds", "gbonds@ymail.com", CustomerType.INDIVIDUAL, null));
		customers.add(new Customer(3L, "Yosef ElSadaany", "yelsadaany@hotmail.com", CustomerType.INDIVIDUAL, null));
		customers.add(new Customer(4L, "Nahom Tsadu", "ntsadu@gmail.com", CustomerType.INDIVIDUAL, null));
	}
	
	@GetMapping(value="{customerId}")
	public Customer findByCustomerId(@PathVariable("customerId") Long customerId) {
		logger.info(String.format("Customer.findByCustomerId(%s)", customerId));
		Customer customer = customers.stream().filter(cust -> cust.getCustomerId().intValue()==customerId.intValue()).findFirst().get();
		List<Account> customerAccounts = accountClient.getAccounts(customerId);
		customer.setAccounts(customerAccounts);
		return customer;
	}
	
	@GetMapping
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customers;
	}
	
}
