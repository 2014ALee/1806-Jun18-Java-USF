package com.revature.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class Account {
	
	private int accountid;
	private double checking;
	private double saving;
	private int userid;
	
	public Account() { }

	public Account(int accountid, double checking, double saving, int userid) {
		super();
		this.accountid = accountid;
		this.checking = checking;
		this.saving = saving;
		this.userid = userid;
	}

	public int getAccountid() {
		
		Account account = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "Select *From account Where account_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountid);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				account.setAccountid(accountid);
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSaving() {
		return saving;
	}

	public void setSaving(double saving) {
		this.saving = saving;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountid;
		long temp;
		temp = Double.doubleToLongBits(checking);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saving);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountid != other.accountid)
			return false;
		if (Double.doubleToLongBits(checking) != Double.doubleToLongBits(other.checking))
			return false;
		if (Double.doubleToLongBits(saving) != Double.doubleToLongBits(other.saving))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", checking=" + checking + ", saving=" + saving + ", userid="
				+ userid + "]";
	}
	
	
	
}
