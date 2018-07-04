package bank.run.dao;

import java.util.ArrayList;

import bank.run.util.User;

public interface UserDAO {
	
	ArrayList<User> getAllUsers();
    ArrayList<String> getAllUsernames();
    ArrayList<String> getAllEmails();
    
    User getUserByUsername(String username);
    User getUserByEmail(String userEmail);
    User getUserById(int userId);
    
    boolean insertUser(User user);
    boolean updateUser(User user);
}
