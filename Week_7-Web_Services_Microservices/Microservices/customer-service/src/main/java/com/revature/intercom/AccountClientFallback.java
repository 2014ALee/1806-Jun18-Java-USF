package com.revature.intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Account;

@Component
public class AccountClientFallback implements AccountClient {

	@Override
	public List<Account> getAccounts(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
