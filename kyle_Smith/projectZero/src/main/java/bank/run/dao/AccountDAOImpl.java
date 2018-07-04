package bank.run.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bank.run.util.Account;
import bank.run.util.ConnectionFactory;
import oracle.jdbc.internal.OracleTypes;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public Account getAccountByUserId(int userId) {
		Account acc = new Account();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM Account WHERE userID = ?";

			String[] keys = new String[1];
			keys[0] = "AccountID";

			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				acc.setAccountID(rs.getInt("AccountID"));
				acc.setUserID(rs.getInt("userID"));
				//acc.setJointID(rs.getInt("jointAccID"));
				acc.setChecking(rs.getDouble("Checking"));
				acc.setSavings(rs.getDouble("Savings"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public boolean insertAccount(Account acc) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			//String sql = "INSERT INTO Account (AccountID,userID,jointAccID,Checking,Savings) VALUES (?,?,?,?,?)";
			String sql = "INSERT INTO Account (AccountID,userID,Checking,Savings) VALUES (?,?,?,?)";

			String[] keys = new String[1];
			keys[0] = "AccountID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, acc.getAccountID());
			pstmt.setInt(2, acc.getUserID());
			//if((acc.getJointID()) >= 0)
			//pstmt.setInt(3, acc.getJointID());
			pstmt.setDouble(3, acc.getChecking());
			pstmt.setDouble(4, acc.getSavings());
			int rowsUpdated = pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if(rowsUpdated != 0) {

				while(rs.next()) {
					acc.setAccountID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateAccount(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			//String sql = "UPDATE Account SET userID = ?, jointAccID = ?, Checking = ?, Savings = ? WHERE AccountID = ?";
			String sql = "UPDATE Account SET userID = ?, Checking = ?, Savings = ? WHERE AccountID = ?";
			String[] keys = new String[1];
			keys[0] = "AccountID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, acc.getUserID());
			//pstmt.setInt(2, acc.getJointID());
			pstmt.setDouble(2, acc.getChecking());
			pstmt.setDouble(3, acc.getSavings());
			pstmt.setInt(4, acc.getAccountID());
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

	@Override
	public Account totalBankSum() {
		Account acc = new Account();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{CALL get_total_checking_proc(?)}";

			String[] keys = new String[1];
			keys[0] = "AccountID";
			CallableStatement cstmt = conn.prepareCall(sql);
			// Setting parameters is the same as we would if we were working with a PreparedStatement
			//define the index of our second parameter, and its type
			cstmt.registerOutParameter(1, OracleTypes.NUMBER);
			
			// execute our callable statement
			cstmt.execute();
			acc.setChecking(cstmt.getDouble(1));
			
			sql = "{CALL get_total_savings_proc(?)}";

			cstmt = conn.prepareCall(sql);
			// Setting parameters is the same as we would if we were working with a PreparedStatement
			//define the index of our second parameter, and its type
			cstmt.registerOutParameter(1, OracleTypes.NUMBER);
			
			// execute our callable statement
			cstmt.execute();
			acc.setSavings(cstmt.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public boolean deleteAccount(Account acc) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			//String sql = "UPDATE Account SET userID = ?, jointAccID = ?, Checking = ?, Savings = ? WHERE AccountID = ?";
			String sql = "DELETE FROM Account WHERE AccountID = ?";
			String[] keys = new String[1];
			keys[0] = "AccountID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, acc.getAccountID());
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
