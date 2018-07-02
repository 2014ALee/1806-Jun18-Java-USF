package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;

import com.revature.models.userData;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class userDAOImpl implements userDAO {

	@Override
	public userData createUser(userData user) {
		userData newUser = new userData(); 
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
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
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
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
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
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

	@Override
	public userData setUser(String username, userData user) {
		userData setUser = new userData();
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ALL_USERS WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				setUser.setUserName(rs.getString(1));
				setUser.setFirstName(rs.getString(3));
				setUser.setLastName(rs.getString(4));
				setUser.setEmail(rs.getString(5));
				setUser.setBalance(rs.getDouble(6));
			}
			user = setUser;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public double withdraw(userData theUser, double withdrawAmount) {
		double initAmount = theUser.getBalance();
		if((initAmount - withdrawAmount) > 0) {
			theUser.setBalance(initAmount-withdrawAmount);
			System.out.println("==========$"+withdrawAmount+"====WITHDRAWN.========");
			try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
				conn.setAutoCommit(false);
				String sql = "UPDATE ALL_USERS SET balance = ? WHERE username = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1, theUser.getBalance());
				pstmt.setString(2, theUser.getUserName());

				int RowsUpdated = pstmt.executeUpdate();
				ResultSet rs = pstmt.executeQuery();
				if(RowsUpdated != 0) {
//					while(rs.next()) {
//						theUser
//					}
					conn.commit();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			System.out.println("===============================Insufficient Funds===============================");;
		}
		return theUser.getBalance();
	}

	@Override
	public double deposit(userData theUser, double depositAmount) {
		double initAmount = theUser.getBalance();
		if(depositAmount >= 0) {
			theUser.setBalance(initAmount+depositAmount);
			System.out.println("==========$"+depositAmount+"====DEPOSITED.========");
			try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
				conn.setAutoCommit(false);
				String sql = "UPDATE ALL_USERS SET balance = ? WHERE username = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1, theUser.getBalance());
				pstmt.setString(2, theUser.getUserName());

				int RowsUpdated = pstmt.executeUpdate();
				ResultSet rs = pstmt.executeQuery();
				if(RowsUpdated != 0) {
					//					while(rs.next()) {
					//						theUser.setBalance(rs);
					//					}
					conn.commit();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return theUser.getBalance();
		}
		else {
			System.out.println("=========================INVALID INPUT=====================");
			return theUser.getBalance();
		}
	}


}
