package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
public class AccountController {
	private List<Account> accounts;
	
	public AccountController() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1,1,500.00));
		accounts.add(new Account(2,2,50.00));
		accounts.add(new Account(3,3,10.00));
		accounts.add(new Account(4,4,25.50));
		accounts.add(new Account(5,1,1010.93));
		accounts.add(new Account(6,2,551.13));
		accounts.add(new Account(7,2,5043.23));
	}
	
	@GetMapping
	public List<Account> getAllAccounts() {
		return accounts;
	}
	
	@GetMapping(value="/{accountId}")
	public Account findAccountById(@PathVariable int accountId) {
		return accounts.stream().filter(acct -> acct.getAccountId() == accountId).findFirst().get();
	}
	
	//@GetMapping(value="customer/{customerId}")
	
	
}
