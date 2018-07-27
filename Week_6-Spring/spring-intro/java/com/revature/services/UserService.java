package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	static {
		System.out.println("[DEBUG] - UserService instantiated...");
	}
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> getAll() {
		System.out.println("[DEBUG] - In UserService.getAll()...");
		return userRepo.getAll();
	}

}