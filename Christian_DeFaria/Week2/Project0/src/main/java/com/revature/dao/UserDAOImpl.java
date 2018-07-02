package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean usernameExists(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM customers WHERE username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean emailExists(String email) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM customers WHERE email = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User addUser(User u) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO customers (username, email, pw) VALUES (?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "customerid";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				while(rs.next()) {
					user.setUserID(rs.getInt(1));
				}
//				conn.commit();
//				user = getUser(u.getUsername(), u.getPassword());
				
				user.setUsername(u.getUsername());
				user.setEmail(u.getEmail());
				user.setPassword(u.getPassword());
				conn.commit();
			} else {
				conn.rollback();
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUser(String username, String password) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM customers WHERE (username = ? or email = ?) and pw = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserID(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
