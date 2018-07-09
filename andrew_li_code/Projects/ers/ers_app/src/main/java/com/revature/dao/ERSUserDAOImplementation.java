package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.models.ERSUser;
import com.revature.models.UserRole;
import com.revature.utils.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ERSUserDAOImplementation implements ERSUserDAO {

	@Override
	public ERSUser getERSUserByUsername(String username) {
		ArrayList<ERSUser> users = new ArrayList<ERSUser>();
		
		/* 
		 * Try block (same layout as from demo) to get the account based
		 * on the username. This is useful because we want to know if user
		 * exists (when an account is being registered) and compare
		 * login information while a user is logging on. This is currently
		 * case insensitive since we don't want two accounts to have usernames
		 * with such an extent of similarity.
		 */
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL FETCH_ERS_USER_BY_USERNAME(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, username);
			cstmt.registerOutParameter(2,  OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			while (rs.next()) {
				int id = rs.getInt("ERS_USER_ID");
				String uname = rs.getString("ERS_USER_USERNAME");
				String hashedPW = rs.getString("ERS_USER_PASSWORD");
				String fName = rs.getString("ERS_USER_FIRST_NAME");
				String lName = rs.getString("ERS_USER_LAST_NAME");
				String email = rs.getString("ERS_USER_EMAIL");
				int roleid = rs.getInt("ERS_USER_ROLE_ID");
				UserRole userRole = null;
				if (roleid == 1) {
					userRole = UserRole.REGULAR;
				} else if (roleid == 2) {
					userRole = UserRole.FINANCE_MANAGER;
				}
				if (userRole != null) {
					users.add(new ERSUser(id, uname, hashedPW, fName, lName, email, userRole));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// If the user doesn't exist we'll get a null
		if (users.size() == 0) {
			return null;
		}
		// If there is somehow more than one user
		// with the same name then we see if there
		// is one with matching upper/lower case.
		for (ERSUser ersUser : users) {
			if (ersUser.getUsername().equals(username)) {
				return ersUser;
			}
		}
		// Otherwise we just return the first one we got.
		return users.get(0);
	}

	@Override
	public ERSUser getERSUserById(int id) {
		ArrayList<ERSUser> users = new ArrayList<ERSUser>();
		
		/* 
		 * Try block (same layout as from demo) to get the account based
		 * on the username. This is useful because we want to know if user
		 * exists (when an account is being registered) and compare
		 * login information while a user is logging on. This is currently
		 * case insensitive since we don't want two accounts to have usernames
		 * with such an extent of similarity.
		 */
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USER WHERE ERS_USER_ID=" + id;
			Statement statement = conn.createStatement();
			statement.execute(sql);
			
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()) {
				String uname = rs.getString("ERS_USER_USERNAME");
				String hashedPW = rs.getString("ERS_USER_PASSWORD");
				String fName = rs.getString("ERS_USER_FIRST_NAME");
				String lName = rs.getString("ERS_USER_LAST_NAME");
				String email = rs.getString("ERS_USER_EMAIL");
				int roleid = rs.getInt("ERS_USER_ROLE_ID");
				UserRole userRole = null;
				if (roleid == 1) {
					userRole = UserRole.REGULAR;
				} else if (roleid == 2) {
					userRole = UserRole.FINANCE_MANAGER;
				}
				if (userRole != null) {
					users.add(new ERSUser(id, uname, hashedPW, fName, lName, email, userRole));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// If the user doesn't exist we'll get a null
		if (users.size() == 0) {
			return null;
		}
		
		// Otherwise we just return the first one we got.
		return users.get(0);
	}

}
