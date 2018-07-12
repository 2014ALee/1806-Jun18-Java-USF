package ers.run.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ers.run.models.Reimbursment;
import ers.run.util.ConnectionFactory;

public class ReimbursmentDAOImpl implements ReimbursmentDAO {

	@Override
	public ArrayList<Reimbursment> getAllReimbursments() {

		ArrayList<Reimbursment> reims = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT";
			
			Statement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Reimbursment temp = new Reimbursment();
				temp.setReimbursmentId(rs.getInt("REIMB_ID"));
				temp.setAmount(rs.getInt("REIMB_AMOUNT"));
				temp.setSubmitted(rs.getDate("REIMB_SUBMITTED"));
				temp.setResolved(rs.getDate("REIMB_RESOLVED"));
				temp.setDescription(rs.getString("REIMB_DESCRIPTION"));
				temp.setReceipt(rs.getBlob("REIMB_RECEIPT"));
				temp.setAuthor(rs.getInt("REIMB_AUTHOR"));
				temp.setResolver(rs.getInt("REIMB_RESOLVER"));
				temp.setStatusId(rs.getInt("REIMB_STATUS_ID"));
				temp.setTypeId(rs.getInt("REIMB_TYPE_ID"));
			
				reims.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reims;
	}

	@Override
	public ArrayList<Reimbursment> getReimbursmentsByAuthor(int author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursment getTypeAndStatus(int reimbursmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertReimbursment(Reimbursment reim) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_RESOLVED,REIMB_DESCRIPTION,REIMB_RECEIPT,REIMB_AUTHOR,REIMB_RESOLVER,REIMB_STATUS_ID,REIMB_TYPE_ID) VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
					
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, reim.getReimbursmentId());
			pstmt.setDouble(2, reim.getAmount());
			pstmt.setDate(3, reim.getSubmitted());
			pstmt.setDate(4, reim.getResolved());
			pstmt.setString(5, reim.getDescription());
			pstmt.setBlob(6, reim.getReceipt());
			pstmt.setInt(7, reim.getAuthor());
			pstmt.setInt(8, reim.getResolver());
			pstmt.setInt(9, reim.getStatusId());
			pstmt.setInt(10, reim.getTypeId());
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					reim.setReimbursmentId(rs.getInt(1));
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
	public boolean updateReimbursment(Reimbursment reim) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
//			
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_ID = ?, REIMB_AMOUNT = ?, REIMB_SUBMITTED = ?,"
					+ "REIMB_RESOLVED = ?, REIMB_DESCRIPTION = ?, REIMB_RECEIPT = ?, REIMB_AUTHOR = ?, "
					+ "REIMB_RESOLVER = ?, REIMB_STATUS_ID = ?, REIMB_TYPE_ID = ? WHERE REIMB_ID = ?";
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, reim.getReimbursmentId());
			pstmt.setDouble(2, reim.getAmount());
			pstmt.setDate(3, reim.getSubmitted());
			pstmt.setDate(4, reim.getResolved());
			pstmt.setString(5, reim.getDescription());
			pstmt.setBlob(6, reim.getReceipt());
			pstmt.setInt(7, reim.getAuthor());
			pstmt.setInt(8, reim.getResolver());
			pstmt.setInt(9, reim.getStatusId());
			pstmt.setInt(10, reim.getTypeId());
			pstmt.setInt(11, reim.getReimbursmentId());
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
	public boolean deleteReimbursment(Reimbursment reim) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "DELETE FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, reim.getReimbursmentId());
			//pstmt.setInt(2, acc.getJointId());
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
//REIMB_ID            NUMBER PRIMARY KEY,
//REIMB_AMOUNT        NUMBER,
//REIMB_SUBMITTED     TIMESTAMP,
//REIMB_RESOLVED      TIMESTAMP,
//REIMB_DESCRIPTION   VARCHAR2(250),
//REIMB_RECEIPT       BLOB,
//REIMB_AUTHOR        NUMBER,
//REIMB_RESOLVER      NUMBER,
//REIMB_STATUS_ID     NUMBER,
//REIMB_TYPE_ID       NUMBER,
//private int reimbursmentId;
//private double amount;
//private Date submitted;
//private Date resolved;
//private String description;
//private Blob receipt;
//private int author;
//private int resolver;
//private int statusId;
//private int typeId;
//private String reimStatus;
//private String reimType;
