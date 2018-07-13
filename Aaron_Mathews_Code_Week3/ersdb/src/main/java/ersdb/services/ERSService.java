package ersdb.services;

import java.util.ArrayList;

import ersdb.dao.ReimbursementDAO;
import ersdb.dao.ReimbursementDAOImpl;
import ersdb.dao.UserDAO;
import ersdb.dao.UserDAOImpl;
import ersdb.models.User;

public class ERSService {
	
	static UserDAO userDAO = new UserDAOImpl();
	static ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();
	
	public static void main(String[] args) {
		unameAvailable("hello");
	}
	
	public User createNewUser(User user) {
		User newUser = null;
		
		boolean emailAvail = emailAvailable(user.getEmail());
		boolean unAvail = unameAvailable(user.getUsername());
		
		if (emailAvail && unAvail) {
			newUser = userDAO.createUser(user);
		}
		
		return newUser;
	}
	
	public User getUserById(int userId) {
		User user = userDAO.getUserById(userId);
		
		return user;
	}
	
	public User getUserByUsername(String username) {
		User user = userDAO.getUserByUsername(username);
		
		return user;
	}
	
	public User getUserByEmail(String email) {
		User user = userDAO.getUserByEmail(email);
		
		return user;
	}
	
	public User updateUsername(User updatedUser) {
		User user = userDAO.updateUsername(updatedUser);
		
		return user;
	}
	
	public User updateEmail(User updatedUser) {
		User user = userDAO.updateEmail(updatedUser);
		
		return user;
	}
	
	public User updatePassword(User updatedUser) {
		User user = userDAO.updatePassword(updatedUser);
		
		return user;
	}
	
	public User updateRoleId(User updatedUser) {
		User user = userDAO.updateRoleId(updatedUser);
		
		return user;
	}
	
	public ArrayList<User> getUsersByRoleId(int roleId) {
		ArrayList<User> usersByRole = userDAO.getUsersByRoleId(roleId);
		
		return usersByRole;
	}
	
	public ArrayList<User> getAllUsers() {
		ArrayList<User> allUsers = userDAO.getAllUsers();
		
		return allUsers;
	}

	private static boolean unameAvailable(String username) {
		User user = null;
		
		user = userDAO.getUserByUsername(username);
		
		//Test if object itself is null or just values inside
		//System.out.println(user.getUsername());
		
		if(user.getUsername() == null) {
			return true;
		}
		return false;
 	}

	private static boolean emailAvailable(String email) {
		User user = null;
		user = userDAO.getUserByEmail(email);
		
		if (user.getEmail() == null) {
			return true;
		}
		return false;
	}

}
