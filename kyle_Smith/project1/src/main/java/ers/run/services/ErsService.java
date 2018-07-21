package ers.run.services;

import java.sql.Date;
import java.util.ArrayList;

import ers.run.dao.*;
import ers.run.models.Reimbursment;
import ers.run.models.User;
import oracle.sql.DATE;

public class ErsService {

	static UserDAO userDao = new UserDAOImpl();
	static ReimbursmentDAO reim = new ReimbursmentDAOImpl();

//	public static void main(String args[]) {
//		User admin = new User();
//		admin.setUsername("admin");
//		ErsService serv = new ErsService();
//		admin = serv.getUserByUsername(admin.getUsername());
//		System.out.println(admin.getPassword() + admin.getRoleId());
//	}

	public User createNewUser(User user) {
		System.out.println("got here bois");
		User newUser = null;

		boolean emailAddressAvailable = isEmailAvailable(user.getEmail());
		boolean usernameAvailable = isUsernameAvailable(user.getUsername());
		System.out.println("got to regServlet " + emailAddressAvailable);
		System.out.println("got to regServlet " + usernameAvailable);
		System.out.println(user.getUsername());
		if (emailAddressAvailable && usernameAvailable) {
			userDao.insertUser(user);
			newUser = getUserByUsername(user.getUsername());
		}
		System.out.println("got to regServlet " + newUser.getUsername());
		System.out.println("got to regServlet " + newUser);
		return newUser;

	}


	public User getUserById(int userId) {

		User soughtUser = userDao.getUserById(userId);
		return soughtUser;

	}


	public User getUserByUsername(String username) {
		System.out.println("username - got to getUserByUsername service" + username);
		User soughtUser = userDao.getUserByUsername(username);
		return soughtUser;

	}

	
	public User getUserByEmailAddress(String emailAddress) {

		User soughtUser = userDao.getUserByEmail(emailAddress);
		return soughtUser;

	}


//	public User updateUser(User userForUpdate) {
//
//		User updatedUser = userDao.updateUser(userForUpdate);
//		return updatedUser;
//
//	}


	public User loginUser(String username, String password) {

		User loggedInUser = null;
		System.out.println("in login");
		// stores returned User object from getUserByUsername() based on given username; ignores case
		User usernameMatch = userDao.getUserByUsername(username.toLowerCase());
		System.out.println("in login after dao");
		if (usernameMatch.getUsername() != null) {
			System.out.println("if check login after dao");
			if (usernameMatch.getPassword().equals(password)) {
				loggedInUser = usernameMatch;
				System.out.println("if check if check login after dao");
			}

			else {
				System.out.println("\nInvalid login credentials: password incorrect\nReturning to main menu.");
			}
		}

		else {
			System.out.println("\nNo records found for username: " + username + "\nReturning to main menu...");
		}

		return loggedInUser;
	}


	public void printAllUsers() {

		ArrayList<User> users = userDao.getAllUsers();

		System.out.println();
		users.forEach(user -> System.out.println(user));
		System.out.println();

	}

	
	public boolean isUsernameAvailable(String username) {

		ArrayList<User> users = userDao.getAllUsers();

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return false;
			}
		}

		return true;

	}


	public boolean isEmailAvailable(String emailAddress) {

		ArrayList<User> users = userDao.getAllUsers();
		System.out.println(emailAddress);
		System.out.println(users);
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(emailAddress)) {
				return false;
			}
		}

		return true;

	}


//	public Account createNewAccount(String accountType) {
//
//		Account newAccount = new Account();
//
//		newAccount.setAcctType(accountType);
//		newAccount.setBalance(0.0);
//
//		newAccount = accountDao.addAccount(newAccount);
//
//		return newAccount;
//
//	}
//
//
//	public Account getAccountById(int accountId) {
//
//		Account soughtAccount = accountDao.getAccountById(accountId);
//		return soughtAccount;
//
//	}
//
//	
//	public Account updateAccountBalance(Account accountForUpdate) {
//
//		Account updatedAccount = accountDao.updateBalance(accountForUpdate.getAcctId(), accountForUpdate.getBalance());
//		return updatedAccount;
//
//	}
//
//
//	public AccountRegistrar registerAccountToUser(User user, Account account, String userPrivilege) {
//
//		AccountRegistrar registeredUserAccount = new AccountRegistrar();
//
//		registeredUserAccount.setUserId(user.getId());
//		registeredUserAccount.setAcctId(account.getAcctId());
//		registeredUserAccount.setUserPrivilege(userPrivilege);
//
//		registeredUserAccount = accountRegistrarDao.registerUserToAccount(registeredUserAccount);
//
//		return registeredUserAccount;
//	}
//
//	
	//ArrayList<Reimbursment> getReimbursmentsByAuthor(int author)
	public Reimbursment getReimbursmentById(int reimId) {
		Reimbursment newReim = new Reimbursment();
		
		newReim = reim.getReimbursmentById(reimId);

		return newReim;

	}
	
	public ArrayList<Reimbursment> getReimbursmentsByAuthor(int authorId) {
		return reim.getReimbursmentsByAuthor(authorId);

	}
	
	public boolean createReim(Reimbursment newReim, User user) {
		
		Reimbursment temp = newReim;
		temp.setAuthor(user.getUserId());
		boolean created = reim.insertReimbursment(newReim);
		
		return created;
	}
	
	public ArrayList<Reimbursment> getReimMinusAuth(int authId) {
		return reim.getReimbursmentsMinusAuthor(authId);

	}
	
	public boolean getLogin(User currUser) {
		int count = 0;
		ArrayList<ArrayList<String>> users = userDao.getLogin();
		for(ArrayList<String> arrayList: users) {
			for(String val: arrayList) {
				if (val == currUser.getEmail())
					count +=1;
				if (val == currUser.getPassword())
					count +=1;
				if (val == currUser.getUsername())
					count +=1;
			}
		}
		if(count == 3) 
			return true;
		return false;
	}
	
	public boolean updateReim(Reimbursment newReim) {
		System.out.println("in update reim " + newReim.getReimbursmentId());
		Reimbursment temp = reim.getReimbursmentById(newReim.getReimbursmentId());
		temp.setResolver(newReim.getResolver());
		temp.setResolved(newReim.getResolved());
		temp.setStatusId(newReim.getStatusId());
		System.out.println("ERS SERVICE UPDATE = " + temp.toString());
		return reim.updateReimbursment(temp);
	}
}
