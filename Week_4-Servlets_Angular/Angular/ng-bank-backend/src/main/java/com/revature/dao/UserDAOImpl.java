package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public User addUser(User u) {
		
		User user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO users (username, password, first_name, last_name, email, role_id, status_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "user_id";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getFirstName());
			pstmt.setString(4, u.getLastName());
			pstmt.setString(5, u.getEmail());
			pstmt.setInt(6, u.getRoleId());
			pstmt.setInt(7, u.getStatusId());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				user = u;
				while(rs.next()) {
					user.setUserId(rs.getInt(1));
				}
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUserById(int userId) {
		
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM users WHERE user_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserId(userId);
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setRoleId(rs.getInt(7));
				user.setStatusId(rs.getInt(8));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		
		System.out.println(username);
		
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM users WHERE username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(username);
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setRoleId(rs.getInt(7));
				user.setStatusId(rs.getInt(8));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		System.out.println(user);
		return user;
		
	}

	@Override
	public User getUserByEmailAddress(String email) {
		
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM users WHERE email = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(email);
				user.setRoleId(rs.getInt(7));
				user.setStatusId(rs.getInt(8));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		
		ArrayList<User> users = new ArrayList<User>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			String sql = "SELECT * FROM users";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setEmail(rs.getString(4));
				temp.setUsername(rs.getString(5));
				temp.setPassword(rs.getString(6));
				users.add(temp);
				
			}
			
		} 

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User updateUser(User u) {
		
		User updatedUser = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE users SET username = ?, password = ?, first_name = ?, "
					+ "last_name = ?, email = ?, role_id = ?, status_id = ? WHERE user_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getFirstName());
			pstmt.setString(4, u.getLastName());
			pstmt.setString(5, u.getEmail());
			pstmt.setInt(6, u.getRoleId());
			pstmt.setInt(7, u.getStatusId());
			pstmt.setInt(8, u.getUserId());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				updatedUser = getUserById(u.getUserId());
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updatedUser;
	}

}
