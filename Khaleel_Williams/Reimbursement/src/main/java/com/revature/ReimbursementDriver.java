package com.revature;

import java.sql.Connection;

import com.revature.util.MakeConnection;

public class ReimbursementDriver {
	
	public static void main(String[] args) {
		 
		MakeConnection connectInst = MakeConnection.getConnectionInstance();
		Connection conn = connectInst.createConnection();
		
		System.out.println("ok");
	}

}
