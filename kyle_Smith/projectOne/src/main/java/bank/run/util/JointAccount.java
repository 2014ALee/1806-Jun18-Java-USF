package bank.run.util;

public class JointAccount {
	
	private int jointID;
	private double checking;
	private double savings;
	
	public JointAccount() {}

	public JointAccount(int jointID, double checking, double savings) {
		super();
		this.jointID = jointID;
		this.checking = checking;
		this.savings = savings;
	}

	public int getJointID() {
		return jointID;
	}

	public void setJointID(int jointID) {
		this.jointID = jointID;
	}

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
		long temp;
		temp = Double.doubleToLongBits(checking);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + jointID;
		temp = Double.doubleToLongBits(savings);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(checking) != Double.doubleToLongBits(other.checking))
			return false;
		if (jointID != other.jointID)
			return false;
		if (Double.doubleToLongBits(savings) != Double.doubleToLongBits(other.savings))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JointAccount [jointID=" + jointID + ", checking=" + checking + ", savings=" + savings + "]";
	}
}
