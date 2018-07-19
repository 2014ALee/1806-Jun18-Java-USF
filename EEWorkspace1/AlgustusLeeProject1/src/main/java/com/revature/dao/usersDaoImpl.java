package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class usersDaoImpl implements usersDao{

	public User newUser(String un, String pw, String fn, String ln, String email) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "{CALL newUser(?,?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, un);
			cstmt.setString(2, pw);
			cstmt.setString(3, fn);
			cstmt.setString(4, ln);
			cstmt.setString(5, email);
			
			ResultSet rs = cstmt.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	

	public void removeUser(User u) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "DELETE FROM ERS_USERS WHERE ERS_USERS_ID = ? AND USER_ROLE_ID = 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, u.getUserid());
			
			ResultSet rs = pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean login(String u, String p) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u);
			pstmt.setString(2, p);
			ResultSet rs = pstmt.executeQuery();
			int rowCount = 0;
			while(rs.next()) {
				rowCount++;
			}
			if(rowCount != 1){
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("exception "+e+" was seen here");
			e.printStackTrace();
		}
		System.out.println("everything was ignored.");
		return false;
	}
	@Override
	public boolean checkForUser(String username) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "{CALL check_username(?,?)}"; 
			CallableStatement cstmt = conn.prepareCall(sql);

			cstmt.setString(1, username);
			cstmt.registerOutParameter(2, OracleTypes.INTEGER);
			cstmt.executeQuery();
			ResultSet rs = cstmt.executeQuery();
			System.out.println("Validating Username...");
			if((Integer)cstmt.getObject(2)== (Integer)0) {
				return true; //There should be no selection when the usernames are alike. therefore the resultset
				//should be 0
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; //returns false if there is an existing user with the same name
	}
	@Override
	public boolean checkForEmails(String user) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "{CALL check_email(?,?)}"; 
			CallableStatement cstmt = conn.prepareCall(sql);

			cstmt.setString(1, user);
			cstmt.registerOutParameter(2, OracleTypes.INTEGER);
			cstmt.executeQuery();
			ResultSet rs = cstmt.executeQuery();
			System.out.println("Validating E-mail...");
			if((Integer)cstmt.getObject(2)== (Integer)0) {
				return true; //There should be no selection when the emails are alike. therefore the resultset
				//should be 0
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; //returns false if there is an existing email with the same name
	}

	@Override
	public User setUser(String username, User user) {
		System.out.println("setUser in action");
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setUserid(rs.getLong(1));
				user.setUserName(rs.getString(2));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setUserRoleId(rs.getLong(7));
			}
			System.out.println("Setuser Data: "+user.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public User newAdmin(String un, String pw, String fn, String ln, String email) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
		String sql ="INSERT INTO ERS_USERS(USER_ROLE_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL)\r\n" + 
				"    VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, 2);
		pstmt.setString(2, un);
		pstmt.setString(3, pw);
		pstmt.setString(4, fn);
		pstmt.setString(5, ln);
		pstmt.setString(6, email);
		
		ResultSet rs = pstmt.executeQuery();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
	}

}
