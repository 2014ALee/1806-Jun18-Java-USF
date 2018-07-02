package com.revature.models;

public class User {
	
	private int userID;
	private String username;
	private String pwHash;
	private String pwSalt;
	private String email;
	private String phone;
	
	public User() {}

	public User(int userID, String username, String pwHash, String pwSalt, String email, String phone) {
		super();
		this.userID = userID;
		this.username = username;
		this.pwHash = pwHash;
		this.pwSalt = pwSalt;
		this.email = email;
		this.phone = phone;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwHash() {
		return pwHash;
	}

	public void setPwHash(String pwHash) {
		this.pwHash = pwHash;
	}

	public String getPwSalt() {
		return pwSalt;
	}

	public void setPwSalt(String pwSalt) {
		this.pwSalt = pwSalt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pwHash == null) ? 0 : pwHash.hashCode());
		result = prime * result + ((pwSalt == null) ? 0 : pwSalt.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (pwHash == null) {
			if (other.pwHash != null)
				return false;
		} else if (!pwHash.equals(other.pwHash))
			return false;
		if (pwSalt == null) {
			if (other.pwSalt != null)
				return false;
		} else if (!pwSalt.equals(other.pwSalt))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", pwHash=" + pwHash + ", pwSalt=" + pwSalt
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
