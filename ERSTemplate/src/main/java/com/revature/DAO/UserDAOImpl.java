package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.revature.DAO.UserDAO;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO{

	public boolean validEmail(String email) {

		if (email == null || email.length() > 150) {
			return false;
		}
	
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";

		Pattern check = Pattern.compile(emailRegex);
		boolean validFormat = check.matcher(email).matches();
		

		if(validFormat) {
		//we do all of this after we are sure they exist
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			String currentEmail = "";
			
			String sql = "SELECT USER_EMAIL FROM ERS_USERS WHERE USER_EMAIL = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);

			ResultSet rs = statement.executeQuery(); 
			
			//here we get and set all of the relevant user information
			while(rs.next()) {
			currentEmail = rs.getString(1);
			}
	
			if(email.equals(currentEmail)){
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		} else {
			return false;
		}
		return false;
	
	}

	//see if we can even create account
	public boolean validRegistration(User newUser) {

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

		if(validUserName(currentUserName) && validEmail(currentEmail)) {
			return true;
		}
		
		return false;
	}


	//we assume the checks needed have been done by this point
	@Override
	public boolean registerUser(User newUser) {

		try(Connection con = ConnectionFactory.getInstance().getConnection();){


			//we user currval because we create the FK and PK consecutively so the sequence
			//will be in the correct place

			String userRole = newUser.getRoleName();
			if(userRole == "employee") {
				newUser.setRoleID(1);;
			} else if(userRole == "manager") {
				newUser.setRoleID(2);
			}
			//if role == manager
			//roleID = 2
			//else if role == employee
			//roleID = 1

			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)\r\n" + 
					"VALUES(?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, newUser.getUserName());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getFirstName());
			statement.setString(4, newUser.getLastName());			
			statement.setString(5, newUser.getEmailName());
			statement.setInt(6, newUser.getRoleID());


			statement.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}


	public boolean validLogin(String userName, String password) {

		try(Connection con = ConnectionFactory.getInstance().getConnection();){


			String sql = "SELECT ERS_USERNAME, USER_EMAIL, ERS_PASSWORD"
					+ " FROM ERS_USERS";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			//we use this to store our users for username and email comparison
			ArrayList<User> userList = new ArrayList<>();			

			while(rs.next()) {
				User currentUser = new User();

				String currentUserName = rs.getString(1);
				String currentEmail = rs.getString(2);
				String currentPassword = rs.getString(3);

				currentUser.setUserName(currentUserName);
				currentUser.setEmailName(currentEmail);
				currentUser.setPassword(currentPassword);

				userList.add(currentUser);
			}

			//now we do our username and email validation
			for(int i = 0; i < userList.size(); i++) {
				if(userName.equals(userList.get(i).getUserName())) {
						if(password.equals(userList.get(i).getPassword())){
							return true;
						}	
				} 
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	//here we assume that we already have checked if they exist
	public User getUser(User newUser) {

		//we do all of this after we are sure they exist
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, newUser.getUserName());

			ResultSet rs = statement.executeQuery();

			//here we get and set all of the relevant user information
			while(rs.next()) {
				newUser.setUserID(rs.getInt("ERS_USERS_ID"));
				newUser.setUserName(rs.getString(2));
				newUser.setPassword(rs.getString(3));
				newUser.setFirstName(rs.getString(4));
				newUser.setLastName(rs.getString(5));
				newUser.setEmailName(rs.getString(6));
				//at this point we don't have the user role name, just the ID
				newUser.setRoleID(rs.getInt(7));

				int roleID = newUser.getRoleID();
				if(roleID == 1) {
					newUser.setRoleName("employee");
				} else if(roleID == 2) {
					newUser.setRoleName("manager");
				}

				System.out.println(newUser);
			}
			return newUser;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean validUserName(String userName) {

		if(userName.length() > 50) {
			return false;
		}
		
		//we do all of this after we are sure they exist
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT ERS_USERNAME FROM ERS_USERS WHERE ERS_USERNAME = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, userName);

			ResultSet rs = statement.executeQuery();
			String currentUserName = ""; 
			
			//here we get and set all of the relevant user information
			while(rs.next()) {
			currentUserName = rs.getString(1);
			}
			
			if(userName.equals(currentUserName)){
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return true;
	}

}

