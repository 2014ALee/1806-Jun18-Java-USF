package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAOInterfaces.UserDAO;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO{

	//we do this upon account creation
	//it only needs to be accessed from within this class, so it's private
	private boolean addToRoleTable(User newUser) {

		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			//at first we will not enter our primary key ID or our user role ID
			String sql = "INSERT INTO ERS_USER_ROLES(USER_ROLE)\r\n" + 
					"VALUES(?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, newUser.getUserRole().getUserRoleName());

			statement.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	//see if we can even create account
	public boolean validRegistrationCredentials(User newUser) {

		String currentUserName = newUser.getUserName();
		String currentEmail = newUser.getEmailName();
		String currentPassword = newUser.getPassword();
		String firstName = newUser.getFirstName();
		String lastName = newUser.getLastName();

		//first we do string length tests
		if(currentUserName.length() > 50) {
			return false;
		} else if(currentEmail.length() > 150) {
			return false;
		} else if(currentPassword.length() > 50) {
			return false;
		} else if(firstName.length() > 100) {
			return false;
		} else if(lastName.length() > 100) {
			return false;
		}

		//then we see if the username or email is already taken
		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT ERS_USERNAME, USER_EMAIL"
					+ " FROM ERS_USERS";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			//we use this to store our users for username and email comparison
			ArrayList<User> userList = new ArrayList<>();			

			while(rs.next()) {
				User currentUser = new User();

				String userName = rs.getString("ERS_USERNAME");
				String email = rs.getString("USER_EMAIL");

				currentUser.setUserName(userName);
				currentUser.setEmailName(email);

				userList.add(currentUser);
			}

			//now we do our username and email validation
			for(int i = 0; i < userList.size(); i++) {
				if(currentUserName == userList.get(i).getUserName()) {
					return false;
				} else if(currentEmail == userList.get(i).getEmailName()) {
					return false;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}


	//we assume the checks needed have been done by this point
	@Override
	public boolean registerUser(User newUser) {

		//first we add them to User_roles table 
		//the id is implicitly added to that table, so we can use it in our statement
		addToRoleTable(newUser);

		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			//we user currval because we create the FK and PK consecutively so the sequence
			//will be in the correct place
			String sql = "INSERT INTO USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)\r\n" + 
					"VALUES(?, ?, ?, ?, ?, userRoleIdSequence.CURRVAL)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, newUser.getUserName());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getFirstName());
			statement.setString(4, newUser.getLastName());			
			statement.setString(5, newUser.getEmailName());

			statement.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean userExists(String userName, String password) {


		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT ERS_USERNAME, ERS_PASSWORD"
					+ " FROM ERS_USERS";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			//we grab all our users so we can see if the person logging in exists in here
			//then we compare passwords
			ArrayList<User> userList = new ArrayList<>();			

			while(rs.next()) {
				User currentUser = new User();

				String currentUserName = rs.getString("ERS_USERNAME");
				String currentPassword = rs.getString("USER_PASSWORD");

				currentUser.setUserName(currentUserName);
				currentUser.setPassword(currentPassword);

				userList.add(currentUser);
			}

			//now we do our username and password validation
			for(int i = 0; i < userList.size(); i++) {
				//first if tells is if we have the username
				if(userName == userList.get(i).getUserName()) {
					//second if tells us if the password is right
					if(password == userList.get(i).getPassword()) {
						return true;
					}	
				}
			}

			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//here we assume that we already have checked if they exist
	@Override
	public User getUser(String userName) {

		User newUser = new User();


		//we do all of this after we are sure they exist
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, userName);

			ResultSet rs = statement.executeQuery();

			UserRole userRole = new UserRole();

			//here we get and set all of the relevant user information
			while(rs.next()) {
				newUser.setUserID(rs.getInt(1));
				newUser.setUserName(rs.getString(2));
				newUser.setPassword(rs.getString(3));
				newUser.setFirstName(rs.getString(4));
				newUser.setLastName(rs.getString(5));
				newUser.setEmailName(rs.getString(6));

				//at this point we don't have the user role name, just the ID
				userRole.setUserRoleID(rs.getInt(7));				
				newUser.setUserRole(userRole);
			}

			//now we get the user role name from the user roles table using the id we generated
			sql = "SELECT USER_ROLE FROM ERS_USER_ROLES WHERE ERS_USER_ROLE_ID = ?";
			
			statement = con.prepareStatement(sql);
			statement.setInt(1, newUser.getUserRole().getUserRoleID());

			 rs = statement.executeQuery();
			
			 while(rs.next()) {
				newUser.getUserRole().setUserRoleName(rs.getString(1)); 
			 }
			
			return newUser;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
