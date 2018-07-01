package com.revature;

import com.revature.models.userData;

public class transactionDriver extends menuDriver{
	
	public static double withdraw(userData user, double withdrawnAmount) {
		double temp = user.getBalance();
		if((temp - withdrawnAmount) >= 0)
		{
			System.out.println("==========$"+withdrawnAmount+"====WITHDRAWN.========");
			user.setBalance(temp - withdrawnAmount);
		}
		else
		{
			System.out.println("==============Insufficient Funds===================");
		}
//		serializeData(user); DO SOMETHING ELSE HERE
		return user.getBalance();

	}

	public static double deposit(userData user, double withdrawnAmount) {
		double temp = user.getBalance();

		System.out.println("==========$"+withdrawnAmount+"====DEPOSITED.========");
		user.setBalance(temp + withdrawnAmount);
//		serializeData(user); DO SOMETHING ELSE HERE
		return user.getBalance();	
	}


}
