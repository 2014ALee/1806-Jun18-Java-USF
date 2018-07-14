package com.revature.models.interfaces;

public interface UserInterface {
	
	public boolean setUserID(int userID);	
	public boolean setUserName(String userName);
	public boolean setPassword(String password);
	public boolean setFirstName(String firstName);
	public boolean setLastName(String lastName);
	public boolean setEmailName(String email);	
	
	public int getUserID();	
	public String getUserName();
	public String getPassword();
	public String getFirstName();
	public String getLastName();
	public String getEmailName();	
	
}
