package ers.run.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ers.run.util.ConnectionFactory;
import oracle.jdbc.internal.OracleTypes;
import ers.run.models.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public ArrayList<User> getAllUsers() {

		ArrayList<User> users = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM ERS_USERS";
			
			Statement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt("ERS_USERS_ID"));
				temp.setUsername(rs.getString("ERS_USERNAME"));
				temp.setPassword(rs.getString("ERS_PASSWORD"));
				temp.setFirstName(rs.getString("USER_FIRST_NAME"));
				temp.setLastName(rs.getString("USER_LAST_NAME"));
				temp.setEmail(rs.getString("USER_EMAIL"));
				temp.setRoleId(rs.getInt("USER_ROLE_ID"));
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
			
			String sql = "SELECT ERS_USERNAME FROM ERS_USERS";
			
			String[] keys = new String[1];
			keys[0] = "ERS_USERS_ID";
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				usernames.add(rs.getString("ERS_USERNAME"));
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
			
			String sql = "SELECT USER_EMAIL FROM ERS_USERS";
			
			String[] keys = new String[1];
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			//pstmt.setString(1, "email");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emails.add(rs.getString("USER_EMAIL"));
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
			
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
	
			String[] keys = new String[1];
			keys[0] = "ERS_USERS_ID";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, username);
			System.out.println(sql);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("username - got to getUserByUsername DAO " + username);
			while(rs.next()) {
				System.out.println("username - got to getUserByUsername DAO " + rs.getString("ERS_USERNAME"));
				user.setUserId(rs.getInt("ERS_USERS_ID"));
				user.setUsername(rs.getString("ERS_USERNAME"));
				user.setPassword(rs.getString("ERS_PASSWORD"));
				user.setFirstName(rs.getString("USER_FIRST_NAME"));
				user.setLastName(rs.getString("USER_LAST_NAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setRoleId(rs.getInt("USER_ROLE_ID"));
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
			
			String sql = "SELECT * FROM ERS_USERS WHERE USER_EMAIL = ?";
			
			String[] keys = new String[1];
			keys[0] = "ERS_USERS_ID"; 
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, userEmail);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getInt("ERS_USERS_ID"));
				user.setUsername(rs.getString("ERS_USERNAME"));
				user.setPassword(rs.getString("ERS_PASSWORD"));
				user.setFirstName(rs.getString("USER_FIRST_NAME"));
				user.setLastName(rs.getString("USER_LAST_NAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setRoleId(rs.getInt("USER_ROLE_ID"));
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
			
			
			String sql = "INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES (?,?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "ERS_USERS_ID";
					
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, newUser.getUserId());
			pstmt.setString(2, newUser.getUsername());
			pstmt.setString(3, newUser.getPassword());
			pstmt.setString(4, newUser.getFirstName());
			pstmt.setString(5, newUser.getLastName());
			pstmt.setString(6, newUser.getEmail());
			pstmt.setInt(7, newUser.getRoleId());
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					newUser.setUserId(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("error creating user." + e);
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
	public ArrayList<ArrayList<String>> getLogin() {
		User user = new User();
		ArrayList<String> usernames = new ArrayList<>();
		ArrayList<String> emails = new ArrayList<>();
		ArrayList<String> passwords = new ArrayList<>();
		ArrayList<ArrayList<String>> usremailpass = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{CALL get_loggin_user_proc(?,?,?)}";

			String[] keys = new String[1];
			keys[0] = "ERS_USERS_ID";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			
			ResultSet rs = cstmt.executeQuery();
			
			while(rs.next()) {
				emails.add(rs.getString("USER_EMAIL"));
				usernames.add(rs.getString("ERS_USERNAME"));
				passwords.add(rs.getString("ERS_PASSWORD"));
//				usernames.add(rs.getString("ERS_USERNAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usremailpass;
	}

	@Override
	public boolean deleteUser(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "DELETE FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			String[] keys = new String[1];
			keys[0] = "ERS_USERS_ID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, user.getUserId());
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
