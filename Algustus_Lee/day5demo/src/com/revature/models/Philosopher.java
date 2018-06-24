package com.revature.models;

import java.util.Date;

public class Philosopher implements Runnable{

	private Object leftFork;
	private Object rightFork;
	
	public Philosopher(Object leftFork, Object rightFork)
	{
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	private void doAction(String action) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((long) (Math.random()* 1000));
	}
	
	private String currentTime()
	{
		return new Date(System.currentTimeMillis()).toString().substring(11, 19);
	}
	/*
	 * 
	 */
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				doAction(currentTime() + ": Contemplating the meaning of existence");
				
				//synchronized blocks restrict access to the code. only one thread at a time can access
				synchronized(rightFork)
				{
					doAction(currentTime()+": Picked up right fork");
				}
				synchronized(leftFork)
				{
					doAction(currentTime()+ ": Picked up left fork, started eating");
					doAction(currentTime()+ ": Put down left fork");
					
				}
				doAction(currentTime()+ "Put down right fork, thinking some more");
				return;
			}
			
		}
		catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
	

}
