package com.revature.model;

public class User {
	
	private int ers_user_id;
	private String ers_username;
	private String ers_password;
	private String ers_first_name;
	private String ers_Last_name;
	private String ers_email;
	private int ers_role_id;
	
	public User() {
		
	}
	

	public User(int ers_user_id, String ers_username, String ers_password, String ers_first_name, String ers_Last_name,
			String ers_email, int ers_role_id) {
		super();
		this.ers_user_id = ers_user_id;
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.ers_first_name = ers_first_name;
		this.ers_Last_name = ers_Last_name;
		this.ers_email = ers_email;
		this.ers_role_id = ers_role_id;
	}



	public int getErs_user_id() {
		return ers_user_id;
	}

	public void setErs_user_id(int ers_user_id) {
		this.ers_user_id = ers_user_id;
	}

	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getErs_first_name() {
		return ers_first_name;
	}

	public void setErs_first_name(String ers_first_name) {
		this.ers_first_name = ers_first_name;
	}

	public String getErs_Last_name() {
		return ers_Last_name;
	}

	public void setErs_Last_name(String ers_Last_name) {
		this.ers_Last_name = ers_Last_name;
	}

	public String getErs_email() {
		return ers_email;
	}

	public void setErs_email(String ers_email) {
		this.ers_email = ers_email;
	}

	public int getErs_role_id() {
		return ers_role_id;
	}

	public void setErs_role_id(int ers_role_id) {
		this.ers_role_id = ers_role_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ers_Last_name == null) ? 0 : ers_Last_name.hashCode());
		result = prime * result + ((ers_email == null) ? 0 : ers_email.hashCode());
		result = prime * result + ((ers_first_name == null) ? 0 : ers_first_name.hashCode());
		result = prime * result + ((ers_password == null) ? 0 : ers_password.hashCode());
		result = prime * result + ers_role_id;
		result = prime * result + ers_user_id;
		result = prime * result + ((ers_username == null) ? 0 : ers_username.hashCode());
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
		if (ers_Last_name == null) {
			if (other.ers_Last_name != null)
				return false;
		} else if (!ers_Last_name.equals(other.ers_Last_name))
			return false;
		if (ers_email == null) {
			if (other.ers_email != null)
				return false;
		} else if (!ers_email.equals(other.ers_email))
			return false;
		if (ers_first_name == null) {
			if (other.ers_first_name != null)
				return false;
		} else if (!ers_first_name.equals(other.ers_first_name))
			return false;
		if (ers_password == null) {
			if (other.ers_password != null)
				return false;
		} else if (!ers_password.equals(other.ers_password))
			return false;
		if (ers_role_id != other.ers_role_id)
			return false;
		if (ers_user_id != other.ers_user_id)
			return false;
		if (ers_username == null) {
			if (other.ers_username != null)
				return false;
		} else if (!ers_username.equals(other.ers_username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [ers_user_id=" + ers_user_id + ", ers_username=" + ers_username + ", ers_password=" + ers_password
				+ ", ers_first_name=" + ers_first_name + ", ers_Last_name=" + ers_Last_name + ", ers_email=" + ers_email
				+ ", ers_role_id=" + ers_role_id + "]";
	}
	
	

}
