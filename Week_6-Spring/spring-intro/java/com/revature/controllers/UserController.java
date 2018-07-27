package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;	

@RestController
@RequestMapping(value="/users")
public class UserController {
	static {
		System.out.println("[DEBUG] - In UserController");
	}
		
	
	@Autowired
	private UserService userService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll() {
		System.out.println("[DEBUG] - In UserController.getAll()");
		return userService.getAll();
	}
	

}
