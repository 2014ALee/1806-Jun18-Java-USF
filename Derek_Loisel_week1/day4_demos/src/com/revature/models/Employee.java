package com.revature.models;

public class Employee extends Thread{

	//run defines what work or logic the thread is going to do
	//start says begin

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println(Thread.currentThread().getName() + " is working...");
		}
	}
}
