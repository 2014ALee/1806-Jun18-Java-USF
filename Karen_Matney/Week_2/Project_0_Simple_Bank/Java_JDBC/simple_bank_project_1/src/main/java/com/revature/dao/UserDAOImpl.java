package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public int usernameAvailable(User u) {
		ArrayList<String> usernames = new ArrayList<>();
		String temp = new String();
		
		// Get Connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			// Get usernames for comparision
			String sql = "SELECT username from clients";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// Add to the list of usernames
			while(rs.next()) {
				temp = rs.getString(1);
				
				usernames.add(temp);
			}
			
			// Check against username
			for(String s : usernames) {
				if(s.equals(u.getUsername())) {
					return 0;  // false
				}
			}
			
			// if no matches
			return 1;	// true
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return -1;  // Error
	}

	@Override
	public User createUser(User u) {
		String[] values = new String[5];
		Account account = new Account();
		AccountDAOImpl create = new AccountDAOImpl();
		String[] userid = new String[1];
		
		// Get Connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			// Values of new user
			values[0] = u.getUsername();
			values[1] = u.getPassword();
			values[2] = u.getFirstName();
			values[3] = u.getLastName();
			values[4] = u.getEMail();
			userid[0] = "clientid";
			
			// Get insert new user
			String sql = "INSERT INTO clients (username,passwd,firstname,lastname,email) VALUES (?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql,userid);
			
			for(int i = 0; i < values.length; i++) {
				pstmt.setString(i+1, values[i]);
			}
			
			int rowsUpdated = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			// Add to the list of usernames
			if(rowsUpdated != 0) {
				while(rs.next()) {
					u.setUserId(rs.getInt(1));
					account.setType("checking");
					account.deposit(0);
					account = create.createAccount(account, u);
					if(account != null) {
						return u;
					} else {
						System.out.println("Check database!");
						return null;
					}
				}
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User validateUser(User u) {
		ArrayList<User> users = new ArrayList<>();
		User temp = new User();
		
		// Get Connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			// Get password for comparision
			String sql = "SELECT * from clients WHERE username = '" + u.getUsername() + "'";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// Add to the list of passwords
			while(rs.next()) {
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEMail(rs.getString(6));
				
				users.add(temp);
			}
			
			// Check against username
			if(users.size() == 1) {
				if(users.get(0).getPassword().equals(u.getPassword())) {
					return temp;
				} else {
					return null;
				}
			} else if (users.size() == 0) {
				// There isn't a matching user
				return null;
				
			} else {
				System.out.println("Check for username duplicates");
				return null;
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
}