package ers.run.services;

import java.util.ArrayList;

import ers.run.dao.*;
import ers.run.models.User;

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

		User newUser = null;

		boolean emailAddressAvailable = isEmailAvailable(user.getEmail());
		boolean usernameAvailable = isUsernameAvailable(user.getUsername());

		if (emailAddressAvailable && usernameAvailable) {
			userDao.insertUser(user);
			newUser = getUserByUsername(user.getUsername());
		}

		return newUser;

	}


	public User getUserById(int userId) {

		User soughtUser = userDao.getUserById(userId);
		return soughtUser;

	}


	public User getUserByUsername(String username) {

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

		// stores returned User object from getUserByUsername() based on given username; ignores case
		User usernameMatch = userDao.getUserByUsername(username.toLowerCase());

		if (usernameMatch.getUsername() != null) {

			if (usernameMatch.getPassword().equals(password)) {
				loggedInUser = usernameMatch;
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
//	public ArrayList<Account> getUserAccounts(User user) {
//
//		ArrayList<Integer> userAccountIds = new ArrayList<Integer>();
//
//		for(AccountRegistrar userAcct_reg : accountRegistrarDao.getUserAccounts(user.getId())) {
//			userAccountIds.add(userAcct_reg.getAcctId());
//		}
//
//		ArrayList<Account> userAccounts = new ArrayList<Account>();
//
//		for(int acctId : userAccountIds) {
//			Account temp = new Account();
//			temp = getAccountById(acctId);
//			userAccounts.add(temp);
//		}
//
//		return userAccounts;
//
//	}
//
//	public ArrayList<AccountRegistrar> getUsersOnAccount(Account acct) {
//
//		ArrayList<AccountRegistrar> usersOnAccount = accountRegistrarDao.getUsersOnAccount(acct.getAcctId());
//		return usersOnAccount;
//
//	}

}
