package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Account;

@FeignClient(name="account-service")
public interface AccountClient {
	
	@GetMapping(value="customers/{customer_id}")
	List<Account> getAccounts(@PathVariable int customer_id);

}
