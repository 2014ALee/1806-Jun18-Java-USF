package ersdb.services;

import java.util.ArrayList;

import ersdb.dao.ReimbursementDAO;
import ersdb.dao.ReimbursementDAOImpl;
import ersdb.dao.UserDAO;
import ersdb.dao.UserDAOImpl;
import ersdb.models.Reimbursement;
import ersdb.models.User;

public class ERSService {
	
	static UserDAO userDAO = new UserDAOImpl();
	static ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();

	
	public User createNewUser(User user) {
		User newUser = null;
		
		boolean emailAvail = emailAvailable(user.getEmail());
		boolean unAvail = unameAvailable(user.getUsername());
		
		if (emailAvail && unAvail) {
			newUser = userDAO.createUser(user);
		}
		
		return newUser;
	}
	
	public Reimbursement createReimbursement(Reimbursement newReimb) {
		Reimbursement reimb = reimbDAO.createReimbursement(newReimb);
		if (reimb.getAuthor() == 0) {
			return null;
		}
		return reimb;
	}
	
	public User getUserById(int userId) {
		User user = userDAO.getUserById(userId);
		
		return user;
	}
	
	public Reimbursement getReimbursementById(int reimbid) {
		Reimbursement reimb = reimbDAO.getReimbursementById(reimbid);
		return reimb;
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
	
	public Reimbursement resolveReimbursement(Reimbursement updatedReimb) {
		Reimbursement reimb = reimbDAO.resolveReimbursement(updatedReimb);
		return reimb;
	}
	
	public ArrayList<User> getUsersByRoleId(int roleId) {
		ArrayList<User> usersByRole = userDAO.getUsersByRoleId(roleId);
		
		return usersByRole;
	}
	
	public ArrayList<User> getAllUsers() {
		ArrayList<User> allUsers = userDAO.getAllUsers();
		
		return allUsers;
	}
	
	public ArrayList<Reimbursement> getReimbursementsByAuthor(int authorId) {
		ArrayList<Reimbursement> reimbs = reimbDAO.getReimbursementByAuthorId(authorId);
		return reimbs;
	}
	
	public ArrayList<Reimbursement> getAllReimbursements() {
		ArrayList<Reimbursement> reimbs = reimbDAO.getAllReimbursements();
		return reimbs;
	}

	public boolean unameAvailable(String username) {
		User user = null;
		
		user = userDAO.getUserByUsername(username);
		
		//Test if object itself is null or just values inside
		//System.out.println(user.getUsername());
		
		if(user.getUsername() == null) {
			return true;
		}
		return false;
 	}

	public boolean emailAvailable(String email) {
		User user = null;
		user = userDAO.getUserByEmail(email);
		
		if (user.getEmail() == null) {
			return true;
		}
		return false;
	}

}
