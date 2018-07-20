package com.revature.models;

public class ERSUser {
	private int id;
	private String username;
	private String hashedPassword;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;

	public ERSUser(int id, String username, String hashedPassword, String firstName, String lastName, String email,
			UserRole role) {
		super();
		this.id = id;
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public UserRole getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "ERSUser [id=" + id + ", username=" + username + ", hashedPassword=" + hashedPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
	}
	
	public String toJSON() {
		return "{ \"id\":\"" + id + "\", \"username=\":\"" + username + "\", \"firstName\":\""
				+ firstName + "\", \"lastName\":\"" + lastName + "\", \"email\":\"" + email
				+ "\", \"role\":\"" + role + "\" }";
	}
	
	
	
	
}
