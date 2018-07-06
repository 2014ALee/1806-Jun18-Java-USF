package com.revature.model;


public class Account {
	
	private int bank_id;
	private int user_id;
	private int user_number;
	private double credbalance;
	private String user_account;
	
	
	public Account(){}

	public Account(int bank_id, int user_id, int user_number, double credbalance, String user_account) {
		
		
		super();
		this.bank_id = bank_id;
		this.user_id = user_id;
		this.user_number = user_number;
		this.credbalance = credbalance;
		this.user_account = user_account;
	}



	public int getBank_id() {
		return bank_id;
	}


	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getUser_number() {
		return user_number;
	}


	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}


	public double getCredbalance() {
		return credbalance;
	}


	public void setCredbalance(double credbalance) {
		this.credbalance = credbalance;
	}


	public String getUser_account() {
		return user_account;
	}


	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bank_id;
		long temp;
		temp = Double.doubleToLongBits(credbalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user_account == null) ? 0 : user_account.hashCode());
		result = prime * result + user_id;
		result = prime * result + user_number;
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
		if (bank_id != other.bank_id)
			return false;
		if (Double.doubleToLongBits(credbalance) != Double.doubleToLongBits(other.credbalance))
			return false;
		if (user_account == null) {
			if (other.user_account != null)
				return false;
		} else if (!user_account.equals(other.user_account))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_number != other.user_number)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Credential [bank_id=" + bank_id + " user_account=" + user_account + "]";
	}
	
	
}
