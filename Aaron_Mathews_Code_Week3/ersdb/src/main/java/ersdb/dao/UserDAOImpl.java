package ersdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ersdb.models.User;
import ersdb.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public User createUser(User newUser) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "ers_users_id";
			
			PreparedStatement pstat = conn.prepareStatement(sql, keys);
			
			pstat.setString(1, newUser.getUsername());
			pstat.setString(2, newUser.getPassword());
			pstat.setString(3, newUser.getFirstname());
			pstat.setString(4, newUser.getLastname());
			pstat.setString(5, newUser.getEmail());
			pstat.setInt(6, newUser.getRoleid());
			
			int success = pstat.executeUpdate();
			
			ResultSet rs = pstat.getGeneratedKeys();
			
			if (success != 0) {
				while(rs.next()) {
					user.setUserid(rs.getInt(1));
				}
				user.setFirstname(newUser.getFirstname());
				user.setLastname(newUser.getFirstname());
				user.setUsername(newUser.getUsername());
				user.setEmail(newUser.getEmail());
				user.setPassword(newUser.getPassword());
				user.setRoleid(newUser.getRoleid());
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User updateUsername(User updatedUser) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "UPDATE ers_users SET ers_username = ? WHERE ers_users_id = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, updatedUser.getUsername());
			pstat.setInt(2, updatedUser.getUserid());
			
			int success = pstat.executeUpdate();
			
			if (success != 0) {
				user.setEmail(updatedUser.getEmail());
				user.setFirstname(updatedUser.getFirstname());
				user.setLastname(updatedUser.getLastname());
				user.setPassword(updatedUser.getPassword());
				user.setRoleid(updatedUser.getRoleid());
				user.setUserid(updatedUser.getUserid());
				user.setUsername(updatedUser.getUsername());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public User getUserByUsername(String username) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, username);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString("user_first_name"));
				user.setLastname(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("ers_password"));
				user.setUsername(rs.getString("ers_username"));
				user.setRoleid(rs.getInt("user_role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_users WHERE user_email = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, email);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString("user_first_name"));
				user.setLastname(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("ers_password"));
				user.setUsername(rs.getString("ers_username"));
				user.setRoleid(rs.getInt("user_role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, id);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString("user_first_name"));
				user.setLastname(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("ers_password"));
				user.setUsername(rs.getString("ers_username"));
				user.setRoleid(rs.getInt("user_role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_users";
			
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserid(rs.getInt(1));
				temp.setFirstname(rs.getString("user_first_name"));
				temp.setLastname(rs.getString("user_last_name"));
				temp.setEmail(rs.getString("user_email"));
				temp.setPassword(rs.getString("ers_password"));
				temp.setUsername(rs.getString("ers_username"));
				temp.setRoleid(rs.getInt("user_role_id"));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User updateEmail(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatePassword(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatedRoleId(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getUsersByRoleId(int roleid) {
		ArrayList<User> users = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_users WHERE user_role_id = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, roleid);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserid(rs.getInt(1));
				temp.setFirstname(rs.getString("user_first_name"));
				temp.setLastname(rs.getString("user_last_name"));
				temp.setEmail(rs.getString("user_email"));
				temp.setPassword(rs.getString("ers_password"));
				temp.setUsername(rs.getString("ers_username"));
				temp.setRoleid(rs.getInt("user_role_id"));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
