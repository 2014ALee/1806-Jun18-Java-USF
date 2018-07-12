package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;

public class UserAccounts implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	private ArrayList<Account> userAccounts;
	
	public UserAccounts() { }
	
	public UserAccounts(User user, ArrayList<Account> userAccounts) {
		super();
		this.user = user;
		this.userAccounts = userAccounts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Account> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(ArrayList<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userAccounts == null) ? 0 : userAccounts.hashCode());
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
		UserAccounts other = (UserAccounts) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userAccounts == null) {
			if (other.userAccounts != null)
				return false;
		} else if (!userAccounts.equals(other.userAccounts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAccounts [user=" + user + ", userAccounts=" + userAccounts + "]";
	}

}
