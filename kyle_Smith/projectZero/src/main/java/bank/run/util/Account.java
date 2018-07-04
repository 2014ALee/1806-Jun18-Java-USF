package bank.run.util;

public class Account {

	private int accountID;
	private int userID;
	//private int jointID;
	private double checking;
	private double savings;
	
	public Account() {}

//	public Account(int accountID, int userID, int jointID, double checking, double savings) {
//		super();
//		this.accountID = accountID;
//		this.userID = userID;
//		this.jointID = jointID;
//		this.checking = checking;
//		this.savings = savings;
//	}
	public Account(int accountID, int userID, double checking, double savings) {
		super();
		this.accountID = accountID;
		this.userID = userID;
		this.checking = checking;
		this.savings = savings;
		
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

//	public int getJointID() {
//		return jointID;
//	}
//
//	public void setJointID(int jointID) {
//		this.jointID = jointID;
//	}

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		long temp;
		temp = Double.doubleToLongBits(checking);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result;// + jointID;
		temp = Double.doubleToLongBits(savings);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userID;
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
		if (accountID != other.accountID)
			return false;
		if (Double.doubleToLongBits(checking) != Double.doubleToLongBits(other.checking))
			return false;
//		if (jointID != other.jointID)
//			return false;
		if (Double.doubleToLongBits(savings) != Double.doubleToLongBits(other.savings))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", userID=" + userID + ", checking="
				+ checking + ", savings=" + savings + "]";
	}
//	", jointID=" + jointID +
}
