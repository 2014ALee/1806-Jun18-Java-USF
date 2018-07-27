package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//needs very specific function names here that uses keywords like find, By, Or.  
	//the username user, username, and email need to match your pojo name and field names
	User findUserByUsernameOrEmail(String username, String email);
	
	User findUserByUsernameAndPassword(String username, String password);
	/*
	//craft out own hql queries if you cant do it in method name
	@Query("from Users u where (u.username = :username Or u.email = :email) And u.password = :password")
	User findUserByUsernameOrEmailAndPassword(@Param("username") String username, @Param("email") String email, @Param("password") String password);
	*/
	
}
