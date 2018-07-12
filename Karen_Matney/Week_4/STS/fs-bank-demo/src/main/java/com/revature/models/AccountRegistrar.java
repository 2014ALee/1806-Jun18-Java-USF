package com.revature.models;

import java.io.Serializable;

public class AccountRegistrar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int userId;
	private int acctId;
	private String userPrivilege;
	
	public AccountRegistrar() {}

	public AccountRegistrar(int userId, int acctid) {
		super();
		this.userId = userId;
		this.acctId = acctid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctid) {
		this.acctId = acctid;
	}
	
	public String getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(String userPrivilege) {
		this.userPrivilege = userPrivilege;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acctId;
		result = prime * result + userId;
		result = prime * result + ((userPrivilege == null) ? 0 : userPrivilege.hashCode());
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
		AccountRegistrar other = (AccountRegistrar) obj;
		if (acctId != other.acctId)
			return false;
		if (userId != other.userId)
			return false;
		if (userPrivilege == null) {
			if (other.userPrivilege != null)
				return false;
		} else if (!userPrivilege.equals(other.userPrivilege))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountRegistrar [userId=" + userId + ", acctId=" + acctId + ", userPrivilege=" + userPrivilege + "]";
	}
	
}
