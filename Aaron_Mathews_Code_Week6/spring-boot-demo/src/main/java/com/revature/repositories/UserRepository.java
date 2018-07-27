package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findUserByUsernameOrEmail(String username, String email);
	User findUserByUsernameAndPassword(String username, String password);
	
	@Query("from Users u where (u.username = :username OR u.email = :email) AND u.password = :password")
	User findUserByUsernameOrEmailAndPassword(@Param("username") String username, @Param("email") String email, @Param("password") String password);
}
