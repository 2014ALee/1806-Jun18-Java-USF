package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Role;

public interface RoleDAO {
	
	public Role getRole(int id);
	public Role getRole(String role);
	public ArrayList<Role> getAllRoles();

	public Role addRole(Role r);
	
}
