package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
public class AccountController {
	
	private List<Account> accounts;
	
	protected Logger logger = Logger.getLogger(AccountController.class.getName());
	
	public AccountController() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1L, 1L, 500.00));
		accounts.add(new Account(2L, 2L, 50.00));
		accounts.add(new Account(3L, 3L, 10.00));
		accounts.add(new Account(4L, 4L, 25.50));
		accounts.add(new Account(5L, 1L, 1010.93));
		accounts.add(new Account(6L, 2L, 551.13));
		accounts.add(new Account(7L, 2L, 5034.55));
	}
	
	@GetMapping(value="{accountId}")
	public Account findByAccountId(@PathVariable("accountId") Long accountId) {
		logger.info(String.format("Account.findByAccountId(%s)", accountId));
		return accounts.stream().filter(acct -> acct.getAccountId().intValue()==accountId.intValue()).findFirst().get();
	}
	
	@GetMapping(value="customer/{customerId}")
	public List<Account> findByCustomerId(@PathVariable("customerId") Long customerId) {
		logger.info(String.format("Account.findByCustomerId(%s)", customerId));
		return accounts.stream().filter(acct -> acct.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	@GetMapping
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accounts;
	}
}
