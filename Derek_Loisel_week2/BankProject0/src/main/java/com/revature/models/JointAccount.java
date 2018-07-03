package com.revature.models;

public class JointAccount {
	//JointAccount POJO
	
	private int jointID;
	private int user1ID;
	private int user2ID;
	private double jointBalance;
	
	public JointAccount() {}

	public JointAccount(int jointID, int user1id, int user2id, double jointBalance) {
		super();
		this.jointID = jointID;
		user1ID = user1id;
		user2ID = user2id;
		this.jointBalance = jointBalance;
	}

	public int getJointID() {
		return jointID;
	}

	public void setJointID(int jointID) {
		this.jointID = jointID;
	}

	public int getUser1ID() {
		return user1ID;
	}

	public void setUser1ID(int user1id) {
		user1ID = user1id;
	}

	public int getUser2ID() {
		return user2ID;
	}

	public void setUser2ID(int user2id) {
		user2ID = user2id;
	}

	public double getJointBalance() {
		return jointBalance;
	}

	public void setJointBalance(double jointBalance) {
		this.jointBalance = jointBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(jointBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + jointID;
		result = prime * result + user1ID;
		result = prime * result + user2ID;
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
		JointAccount other = (JointAccount) obj;
		if (Double.doubleToLongBits(jointBalance) != Double.doubleToLongBits(other.jointBalance))
			return false;
		if (jointID != other.jointID)
			return false;
		if (user1ID != other.user1ID)
			return false;
		if (user2ID != other.user2ID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JointAccount [jointID=" + jointID + ", user1ID=" + user1ID + ", user2ID=" + user2ID + ", jointBalance="
				+ jointBalance + "]";
	}

}
