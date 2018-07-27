package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	
	@Autowired
	UserRepository userRepo;
	
	public List<User> findAllUsers(){
		return userRepo.findAll();
	}
	
	public User findUserById(int id) {
		return userRepo.getOne(id);
	}
	
	public User findUserByUsernameOrEmail(String username, String email) {
		return userRepo.findUserByUsernameOrEmail(username,  email);
	}
	
	public User addUser(User u) {
		return userRepo.save(u);
	}
	
	public User updateUser (User u) {
		
		User user = findUserById(u.getUserId());
		
		if(user == null) {
			return null;
		}
		return userRepo.save(u);
	}
	
	public int deleteUser(int id) {
		User user = findUserById(id);
		
		if(user == null) {
			return -1;
		}
		
		userRepo.delete(user);
		
			return 1;
		
	}
	
	public User loginUser(User u) {
		
		return userRepo.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
}
