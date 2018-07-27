package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.beans.UserErrorResponse;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsers(){
		
		System.out.println("debug - in userController.findAllUsers()...");
		return userService.findAllUsers();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User findUserById(int id) {
		System.out.println("debug - in UserController.findUserbyid()");
		
		User user = userService.findUserById(id);
		
		if(user == null) {
			throw new UserNotFoundException("No user with id " + id + " found");
		}
		
		return user;
	}
	
	@PostMapping (produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@Valid @RequestBody User newUser){
		User user = userService.addUser(newUser);
		return new ResponseEntity<User>(user, HttpStatus.CREATED	);
	}
	
	@PatchMapping (produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User updatedUser) {
		System.out.println("debug in usercontroller.updateuser()");
		User user = userService.updateUser(updatedUser);
		
		if(user == null) {
			throw new UserNotFoundException("No user with id " + updatedUser.getUserId() + " found");
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<User> dleteUser(@PathVariable int id) 	{
		int deleted = userService.deleteUser(id);
		if(deleted == -1) {
			throw new UserNotFoundException("No user with id " + id + " found");

		}
		
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> loginUser(@Valid @RequestBody User user){
		user = userService.loginUser(user);		
		if(user ==null) {
			throw new InvalidCredentialsException("invalid credentials");	
		}		
		return new ResponseEntity<User>	(user,HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse>	handleException(InvalidCredentialsException e){
		UserErrorResponse error = new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse>	handleException(UserNotFoundException e){
		UserErrorResponse error = new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
