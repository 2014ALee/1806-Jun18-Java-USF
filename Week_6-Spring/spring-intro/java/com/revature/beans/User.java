package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="USERS")
@SequenceGenerator(name="userSeq", sequenceName="USER_SEQ", allocationSize=1)
public class User {

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="userSeq")
	private int user_id;

	@Column(name="USERNAME")
	private String username;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FIRST_NAME")
	private String first_name;

	@Column(name="LAST_NAME")
	private String last_name;

	public User() {
		System.out.println("LOG: User has been instantiated");
	}

	public User(String username, String email, String first_name, String last_name) {
		super();
		this.username = username;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public User(int user_id, String username, String email, String first_name, String last_name) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", first_name=" + first_name
				+ ", last_name=" + last_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + user_id;
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
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



}
