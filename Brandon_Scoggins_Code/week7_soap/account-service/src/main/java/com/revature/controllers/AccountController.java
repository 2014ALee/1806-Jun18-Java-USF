package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
public class AccountController {

	private List<Account> accounts;
	
	public AccountController() {
		accounts = new ArrayList<>(); 
		accounts.add(new Account(1, 25.00, 4));
		accounts.add(new Account(5, 24.40, 5));
		accounts.add(new Account(2, 20.00, 7));
		accounts.add(new Account(4, 55.66, 8));
		accounts.add(new Account(3, 27.33, 5));
	}
	
	@GetMapping(value="{accountId}")
	public Account findAccountById(@PathVariable int accountId) {
		return accounts.stream().filter(acct -> acct.getAccountId() == accountId).findFirst().get();
	}
	
	@GetMapping
	public List<Account> getAllAccounts() {
		return accounts;
	}
	
	@GetMapping(value="customer/{customerId}")
	public List<Account> findAccountsByCustomerId(@PathVariable int customerId) {
		return accounts.stream().filter(acct -> acct.getCustomerId() == customerId).collect(Collectors.toList());
	}
}
