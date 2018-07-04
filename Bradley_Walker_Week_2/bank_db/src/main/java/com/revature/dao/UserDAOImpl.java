package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class UserDAOImpl implements UserDAO {

	@Override
	public User addUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Users (username, pw_hash, pw_salt, email, phone) VALUES (?, ?, ?, ?, ?)";

			
			String[] keys = {"user_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPwHash());
			ps.setString(3, user.getPwSalt());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			

			int rowsAffected = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if(rowsAffected > 0) {
				rs.next();
				user.setUserID(rs.getInt(1));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Users";

			Statement s = conn.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				User temp = new User();
				temp.setUserID(rs.getInt("user_id"));
				temp.setUsername(rs.getString("username"));
				temp.setPwHash(rs.getString("pw_hash"));
				temp.setPwSalt(rs.getString("pw_salt"));
				temp.setEmail(rs.getString("email"));
				temp.setPhone(rs.getString("phone"));
				temp.setFrozen(rs.getInt("frozen") == 1);

				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	@Override
	public ArrayList<User> getAllUsersExcept(int id){
		ArrayList<User> users = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{CALL get_all_users_except(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, id);
			
			cs.registerOutParameter(2, OracleTypes.CURSOR);

			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);

			while(rs.next()) {
				User temp = new User();
				temp.setUserID(rs.getInt("user_id"));
				temp.setUsername(rs.getString("username"));
				temp.setPwHash(rs.getString("pw_hash"));
				temp.setPwSalt(rs.getString("pw_salt"));
				temp.setEmail(rs.getString("email"));
				temp.setPhone(rs.getString("phone"));
				temp.setFrozen(rs.getInt("frozen") == 1);

				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	// Returns the desired user. If user doesn't exists in the database, returns null.
	@Override
	public User getUserByID(int id) {
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Users WHERE user_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				user.setUserID(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPwHash(rs.getString("pw_hash"));
				user.setPwSalt(rs.getString("pw_salt"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setFrozen(rs.getInt("frozen") == 1);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	// Returns the desired user. If user doesn't exists in the database, returns null.
	@Override
	public User getUserByUsername(String username) {
		User user = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Users WHERE username = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				user.setUserID(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPwHash(rs.getString("pw_hash"));
				user.setPwSalt(rs.getString("pw_salt"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setFrozen(rs.getInt("frozen") == 1);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public ArrayList<Account> getUserAccounts(User user) {
		ArrayList<Account> accounts = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM UserHasAccount WHERE user_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getUserID());

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Account temp = new AccountDAOImpl().getAccountByID(rs.getInt("account_id"));
				
				if(temp != null) {
					accounts.add(temp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accounts;
	}

	@Override
	public boolean updateUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE Users "
					+ "SET username = ?, pw_hash = ?, pw_salt = ?, email = ?, phone = ?, frozen = ? "
					+ "WHERE user_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPwHash());
			ps.setString(3, user.getPwSalt());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setInt(6, (user.isFrozen()) ? 1 : 0);
			ps.setInt(7, user.getUserID());

			int rowsAffected = ps.executeUpdate();

			if(rowsAffected > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
