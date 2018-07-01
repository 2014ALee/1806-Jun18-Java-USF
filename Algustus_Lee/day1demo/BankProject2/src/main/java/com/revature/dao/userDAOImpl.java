package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;

import com.revature.models.userData;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class userDAOImpl implements userDAO {

	@Override
	public userData createUser(userData user) {
		userData newUser = new userData(); 
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection("scripttanuki", "password")){
			String sql = "{CALL register_user(?,?,?,?,?)}";// 1:firstname 2:lastname 3:username 4:password 5:email
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, user.getFirstName());
			cstmt.setString(2, user.getLastName());
			cstmt.setString(3, user.getUserName());
			cstmt.setString(4, user.getPassword());
			cstmt.setString(5, user.getEmail());
			
			ResultSet rs = cstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newUser;
	}

	@Override
	public boolean checkForUser(userData user) {
		userData newUser = new userData();
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection("scripttanuki", "password")){
			String sql = "{CALL check_username(?,?)}"; 
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, newUser.getUserName());
			cstmt.registerOutParameter(2, OracleTypes.INTEGER);
			cstmt.executeQuery();
			ResultSet rs = cstmt.executeQuery();
			System.out.println("output is: "+ (Integer) cstmt.getObject(2));
			System.out.println((Integer) cstmt.getObject(2)== (Integer) 0);
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
	public boolean checkForEmails(userData user) {
		userData newUser = new userData();
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection("scripttanuki", "password")){
			String sql = "{CALL check_email(?,?)}"; 
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, newUser.getEmail());
			cstmt.registerOutParameter(2, OracleTypes.INTEGER);
			cstmt.executeQuery();
			ResultSet rs = cstmt.executeQuery();
			System.out.println("output is: "+ (Integer) cstmt.getObject(2));
			System.out.println((Integer) cstmt.getObject(2)== (Integer) 0);
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
}
