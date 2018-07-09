package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Type;

public interface TypeDAO {
	
	public Type getType(int id);
	public Type getType(String type);
	public ArrayList<Type> getAllTypes();
	
	public Type addType(Type t);
	
}
