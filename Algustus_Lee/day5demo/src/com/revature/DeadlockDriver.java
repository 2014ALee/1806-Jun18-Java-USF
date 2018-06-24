package com.revature;

import java.util.Date;

import com.revature.models.Philosopher;

public class DeadlockDriver {
	public static void main(String[] args) {
		
		//used a Date object to format System time into something legible
//		Date myDate = new Date (System.currentTimeMillis());
//		
//		System.out.println(myDate);
		
//		Philosopher[] philosophers = new Philosopher[5];
//		Object[] forks = new Object[philosophers.length];
//		
//		for(int i = 0; i < forks.length ; i++)
//		{
//			forks[i] = new Object();
//		}
//		for(int j=0 ; j < philosophers.length; j++)
//		{
//			Object leftFork = forks[j];
//			Object rightFork = forks[(j+1)%forks.length];
//			
//			if(j == philosophers.length - 1)
//			{
//				philosophers[j] = new Philosopher(rightFork, leftFork);
//			}
//			else
//			{
//				philosophers[j] = new Philosopher(leftFork, rightFork);
//			}
//			//philosophers[j] = new Philosopher(leftFork, rightFork);
//			
//			Thread t = new Thread(philosophers[j], "Philosopher "+(j+1));
//			t.start();
//		}
		
		System.out.println("+----------------------------------------------------------------+");
		
		Runnable r = () ->{
			//System.out.println("Hi, I'm a lambda expression!");
			for(int i = 0; i<15; i++)
			{
				System.out.println("i: "+i);
			}
		}; //good if you never need to re-use code. Very little memory usage
		Thread t = new Thread(r);
		t.start();
		
	}

}
