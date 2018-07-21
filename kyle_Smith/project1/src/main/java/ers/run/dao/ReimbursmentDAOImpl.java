package ers.run.dao;

import java.sql.Connection;
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
		ArrayList<Reimbursment> reims = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("error 1");
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			System.out.println("error 2");
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, author);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("error 3");
			
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
				System.out.println("temp to string " + temp.toString());
				reims.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("error in sql statement");
			e.printStackTrace();
		}
		return reims;
	}

	@Override
	public Reimbursment getTypeAndStatus(int reimbursmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertReimbursment(Reimbursment reim) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("creating reimDAO");
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_DESCRIPTION,"
					+ "REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID) "
					+ "VALUES (?,?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			System.out.println(reim.getSubmitted().getTime());
			System.out.println("converted timestamp: " + new java.sql.Timestamp(reim.getSubmitted().getTime()));
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, reim.getReimbursmentId());
			pstmt.setDouble(2, reim.getAmount());
			pstmt.setDate(3, new java.sql.Date(reim.getSubmitted().getTime()));
			pstmt.setString(4, reim.getDescription());
			pstmt.setInt(5, reim.getAuthor());
			pstmt.setInt(6, reim.getStatusId());
			pstmt.setInt(7, reim.getTypeId());
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					reim.setReimbursmentId(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			System.out.println("error creating reim.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateReimbursment(Reimbursment reim) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("in update reim DAO "+reim.toString());
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

	@Override
	public Reimbursment getReimbursmentById(int reimId) {
		System.out.println("in get reim id " + reimId);
		Reimbursment reimb = new Reimbursment();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, reimId);
			pstmt.setInt(1, reimId);
			System.out.println("before execute");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("in get reim execute");
			
			while(rs.next()) {
				System.out.println("in result set");
				reimb.setReimbursmentId(rs.getInt("REIMB_ID"));
				reimb.setAmount(rs.getInt("REIMB_AMOUNT"));
				reimb.setSubmitted(rs.getDate("REIMB_SUBMITTED"));
				reimb.setResolved(rs.getDate("REIMB_RESOLVED"));
				reimb.setDescription(rs.getString("REIMB_DESCRIPTION"));
				System.out.println("in result set 2");
				reimb.setReceipt(rs.getBlob("REIMB_RECEIPT"));
				reimb.setAuthor(rs.getInt("REIMB_AUTHOR"));
				reimb.setResolver(rs.getInt("REIMB_RESOLVER"));
				reimb.setStatusId(rs.getInt("REIMB_STATUS_ID"));
				reimb.setTypeId(rs.getInt("REIMB_TYPE_ID"));
				System.out.println("in result set 3");
			}
		} catch (SQLException e) {
			System.out.println("this is the error");
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public ArrayList<Reimbursment> getReimbursmentsMinusAuthor(int author) {
		ArrayList<Reimbursment> reims = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("error 1");
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR != ? AND REIMB_STATUS_ID = 1 ORDER BY REIMB_ID";
			String[] keys = new String[1];
			keys[0] = "REIMB_ID";
			System.out.println("error 2");
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, author);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("error 3");
			
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
				System.out.println("temp to string " + temp.toString());
				reims.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("error in sql statement");
			e.printStackTrace();
		}
		return reims;
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
