package ers.run.dao;

import java.util.ArrayList;
import ers.run.models.User;

public interface UserDAO {
	
	ArrayList<User> getAllUsers();
    ArrayList<String> getAllUsernames();
    ArrayList<String> getAllEmails();
    ArrayList<ArrayList<String>> getLogin();
    
    User getUserByUsername(String username);
    User getUserByEmail(String userEmail);
    User getUserById(int userId);
    
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
