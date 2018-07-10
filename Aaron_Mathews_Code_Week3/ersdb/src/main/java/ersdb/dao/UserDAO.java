package ersdb.dao;

import java.util.ArrayList;

import ersdb.models.User;

public interface UserDAO {
	
	public User createUser(User user);
	
	public User updateUsername(User updatedUser);
	
	public User updateEmail(User updatedUser);
	
	public User updatePassword(User updatedUser);
	
	public User updatedRoleId(User updatedUser);
	
	public User getUserByUsername(String username);
	
	public User getUserByEmail(String email);
	
	public User getUserById(int id);
	
	public ArrayList<User> getUsersByRoleId(int roleid);
	
	public ArrayList<User> getAllUsers();

}
