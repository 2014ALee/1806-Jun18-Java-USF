package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	@Override
	public void Login(String username, String pw) {
		// TODO Auto-generated method stub

	}

	//	@Override
	//	public User AddUser(User newUser) {
	//
	//		User user = new User();
	//		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	//			conn.setAutoCommit(false);
	//			String sql = ("INSERT INTO USER (username, password) VALUES(?, ?)");
	//			// make a string array of keys 
	//			String[] keys = new String[1];
	//			// which column i want to get back
	//			keys[0] = "user_id";
	//			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
	//			pstmt.setString(5, newUser.getUserName());
	//			pstmt.setString(6, newUser.getPassword());
	//			// use execute update because insert is not a query
	//			// returns  an int value of updated rows
	//			int rowsUpdated = pstmt.executeUpdate();
	//			// once executed we get back a list of generated keys from db (artistid)
	//			ResultSet rs = pstmt.getGeneratedKeys();
	//
	//			if(rowsUpdated != 0) {
	//				while (rs.next()) {
	//					// get the artistid from the result set
	//					newUser.setUserid(rs.getInt(1));
	//				}
	//				
	//				user.setUserName(newUser.getUserName());
	//				conn.commit();	
	//			}
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return user;
	//	}

	@Override
	public User GetUser(User u) {

		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "SELECT * FROM customer WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUserName());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setUserName(u.getUserName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User AddUser(User newUser) {

		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			// set false so we can make sure it was successful before we commit
			conn.setAutoCommit(false);
			String sql = "INSERT INTO customer VALUES (?, ?, ?, ?)";
			// make a string array of keys 
			String[] keys = new String[1];
			// which column i want to get back
			keys[0] = "cust_id";
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, 0);
			pstmt.setString(2, newUser.getUserName());
			pstmt.setString(3, newUser.getPassword());
			pstmt.setString(4, newUser.getEmail());
			// use execute update because insert is not a query
			// returns  an int value of updated rows
			int rowsUpdated = pstmt.executeUpdate();
			// once executed we get back a list of generated keys from db (userid)
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rowsUpdated != 0) {
				while (rs.next()) {
					// get the userid from the result set
					newUser.setUserid(rs.getInt(1));
				}
				
				
				conn.commit();
			}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return newUser;
		}

	}
