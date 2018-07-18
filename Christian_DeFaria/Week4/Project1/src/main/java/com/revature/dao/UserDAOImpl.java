package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public Users getUser(int id) {
		Users u = new Users();
		u.setUser_id(id);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_users WHERE ers_user_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstname(rs.getString(4));
				u.setLastname(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRole_id(rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Users getUserByName(String username) {
		Users u = new Users();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				u.setUser_id(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstname(rs.getString(4));
				u.setLastname(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRole_id(rs.getInt(7));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users getUserByEmail(String email) {
		Users u = new Users();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_users WHERE user_email = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				u.setUser_id(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstname(rs.getString(4));
				u.setLastname(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRole_id(rs.getInt(7));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users addUser(Users user) {
//		Users u = new Users();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES (?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "ers_users_id";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstname());
			pstmt.setString(4, user.getLastname());
			pstmt.setString(5, user.getEmail());
			pstmt.setInt(6, user.getRole_id());
			
//			System.out.println(user.toString());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				while(rs.next()) {
					user.setUser_id(rs.getInt(1));
					return user;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
