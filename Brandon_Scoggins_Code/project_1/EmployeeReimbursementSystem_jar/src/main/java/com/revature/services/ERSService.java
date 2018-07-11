package com.revature.services;

import com.revature.dao.ERSUsersDAO;
import com.revature.dao.ERSUsersDAOImpl;
import com.revature.models.ERSUser;

public class ERSService {

	ERSUsersDAO usersDao = new ERSUsersDAOImpl();
	
	public ERSUser logInUser(String userNameOrEmail, String passWord) {
		return usersDao.logInUser(userNameOrEmail, passWord);
	}

}
