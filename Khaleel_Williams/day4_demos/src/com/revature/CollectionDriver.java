package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class CollectionDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Generics, anything inside the angle bracket <>
		 * used for compile time type checking
		 */
		
		List<User> users = new ArrayList<>();
		
		User u = new User("Genesis", "Bonds", "gbonds", "p4ssw0rd", "bgonds@gmial.com");
		
		users.add(u);
		users.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmial.com"));
		users.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@gmial.com"));
		users.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmial.com"));
		users.add(u); // duplicates do not matter with Lists
		
		//easiest way to traverse
		
		
	}

}
