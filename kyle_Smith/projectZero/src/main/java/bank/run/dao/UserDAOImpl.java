package bank.run.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bank.run.util.ConnectionFactory;
import bank.run.util.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public ArrayList<User> getAllUsers() {

		ArrayList<User> users = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM Users";
			
			Statement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserID(rs.getInt("userID"));
				temp.setFirstName(rs.getString("firstName"));
				temp.setLastName(rs.getString("lastName"));
				temp.setUsername(rs.getString("username"));
				temp.setEmail(rs.getString("email"));
				temp.setPassword(rs.getString("password"));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public ArrayList<String> getAllUsernames() {
		ArrayList<String> usernames = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT username FROM Users";
			
			String[] keys = new String[1];
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			//pstmt.setString(1, "username");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				usernames.add(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernames;
	}
	
	@Override
	public ArrayList<String> getAllEmails() {
		ArrayList<String> emails = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT email FROM Users";
			
			String[] keys = new String[1];
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			//pstmt.setString(1, "email");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emails.add(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emails;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM Users WHERE username = ?";
			
			String[] keys = new String[1];
			keys[0] = "userID";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserID(rs.getInt("userID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM Users WHERE email = ?";
			
			String[] keys = new String[1];
			keys[0] = "userID";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, userEmail);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserID(rs.getInt("userID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User newUser) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			
			String sql = "INSERT INTO Users (userID,firstname,lastname,username,email,password) VALUES (?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "userID";
					
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, newUser.getUserID());
			pstmt.setString(2, newUser.getFirstName());
			pstmt.setString(3, newUser.getLastName());
			pstmt.setString(4, newUser.getUsername());
			pstmt.setString(5, newUser.getEmail());
			pstmt.setString(6, newUser.getPassword());
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					newUser.setUserID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("error creating user.");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			//String sql = "UPDATE Account SET userID = ?, jointAccID = ?, Checking = ?, Savings = ? WHERE AccountID = ?";
			String sql = "DELETE FROM Users WHERE UserID = ?";
			String[] keys = new String[1];
			keys[0] = "UserID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, user.getUserID());
			//pstmt.setInt(2, acc.getJointID());
			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
