package com.revature.models;

public class Employee extends Thread {
	@Override
	public void run(){ //Run defines what work must be executed. the Start() method tells it to begin using run.
		for(int i = 0; i < 10; i++){
			System.out.println(Thread.currentThread().getName() + " is working...");
			try 
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				break;
			}
		}
	}
}
