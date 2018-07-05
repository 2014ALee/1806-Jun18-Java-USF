package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.MainMenu;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getUserById(User newUser) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM users WHERE userid = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, newUser.getUserId());
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				user.setUserId(newUser.getUserId());
				user.setFirstname(newUser.getFirstname());
				user.setLastname(newUser.getLastname());
				user.setEmail(newUser.getEmail());
				user.setUsername(newUser.getUsername());
			}
		} catch (SQLException e) {
			System.out.println("An error occurred while retrieving user. Please try again");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
			MainMenu.mainMenu();
		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM users WHERE username = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, username);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt("userId"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("pass"));
				temp.setFirstname(rs.getString("firstname"));
				temp.setLastname(rs.getString("lastname"));
				temp.setEmail(rs.getString("email"));
				
				user = temp;
			}
		} catch (SQLException e) {
			System.out.println("An error occurred while retrieving user. Please try again");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
			MainMenu.mainMenu();
		}
		return user;
	}

	@Override
	public User createUser(User newUser) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO users (firstname, lastname, username, email, pass) " +
					"VALUES (?, ?, ?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "userId";
			
			PreparedStatement pstat = conn.prepareStatement(sql, keys);
			
			pstat.setString(1, newUser.getFirstname());
			pstat.setString(2, newUser.getLastname());
			pstat.setString(3, newUser.getUsername());
			pstat.setString(4, newUser.getEmail());
			pstat.setString(5, newUser.getPassword());
			
			int success = pstat.executeUpdate();
			
			ResultSet rs = pstat.getGeneratedKeys();
			if (success != 0) {
				while(rs.next()) {
					user.setUserId(rs.getInt(1));
				}
				user.setUsername(newUser.getUsername());
				user.setFirstname(newUser.getFirstname());
				user.setLastname(newUser.getLastname());
				user.setEmail(newUser.getEmail());
				user.setPassword(newUser.getPassword());
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("An error occurred while retrieving user. Please try again");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
			}
			MainMenu.mainMenu();
		}
		return user;
	}

}
