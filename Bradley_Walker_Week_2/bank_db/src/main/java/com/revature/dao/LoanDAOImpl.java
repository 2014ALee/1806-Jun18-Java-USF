package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Loan;
import com.revature.util.ConnectionFactory;

public class LoanDAOImpl implements LoanDAO {

	@Override
	public boolean addLoan(Loan loan) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Loans (user_id, amount_loaned, amount_repaid, pay_by) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, loan.getUserID());
			ps.setDouble(2, loan.getAmountLoaned());
			ps.setDouble(3, loan.getAmountRepaid());
			ps.setTimestamp(4, loan.getPayBy());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Loan> getAllLoans() {
		ArrayList<Loan> loans = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Loans";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Loan temp = new Loan(rs.getInt("loan_id"),
									rs.getInt("user_id"),
									rs.getDouble("amount_loaned"),
									rs.getDouble("amount_repaid"),
									rs.getTimestamp("pay_by"),
									rs.getTimestamp("timestamp"));
				
				loans.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loans;
	}

	@Override
	public ArrayList<Loan> getLoansForUser(int id) {
		ArrayList<Loan> loans = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Loans WHERE user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Loan temp = new Loan(rs.getInt("loan_id"),
						rs.getInt("user_id"),
						rs.getDouble("amount_loaned"),
						rs.getDouble("amount_repaid"),
						rs.getTimestamp("pay_by"),
						rs.getTimestamp("timestamp"));
	
				loans.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loans;
	}

	@Override
	public boolean updateLoan(Loan loan) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE Loans "
					+ "SET user_id = ?, amount_loaned = ?, amount_repaid = ? "
					+ "WHERE loan_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, loan.getUserID());
			ps.setDouble(2, loan.getAmountLoaned());
			ps.setDouble(3, loan.getAmountRepaid());
			
			int rowsUpdated = ps.executeUpdate();
			
			if(rowsUpdated > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
