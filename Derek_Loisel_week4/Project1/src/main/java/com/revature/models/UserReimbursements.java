package com.revature.models;

import java.util.ArrayList;

public class UserReimbursements {

	//data transfer object
	private User user;
	private ArrayList<Reimbursement> userReimbursements;
	
	public UserReimbursements() {}

	public UserReimbursements(User user, ArrayList<Reimbursement> userReimbursements) {
		super();
		this.user = user;
		this.userReimbursements = userReimbursements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getUserReimbursements() {
		return userReimbursements;
	}

	public void setUserReimbursements(ArrayList<Reimbursement> userReimbursements) {
		this.userReimbursements = userReimbursements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userReimbursements == null) ? 0 : userReimbursements.hashCode());
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
		UserReimbursements other = (UserReimbursements) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userReimbursements == null) {
			if (other.userReimbursements != null)
				return false;
		} else if (!userReimbursements.equals(other.userReimbursements))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserReimbursements [user=" + user + ", userReimbursements=" + userReimbursements + "]";
	}
	
	
}
