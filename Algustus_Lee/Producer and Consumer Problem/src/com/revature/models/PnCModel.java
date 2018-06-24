package com.revature.models;

import java.util.LinkedList;

public class PnCModel extends Thread{
	
	LinkedList<Integer> theData = new LinkedList<>();
	int listSize = 2;
	public void makeData()
	{
		int theValue= 0;
		while(true)
		{
			synchronized(this)
			{
				while(theData.size() == listSize)
				{
					try {
						wait();
					} catch (InterruptedException e) {
						System.out.println("interrupted");
						e.printStackTrace();
					}
				}
				theData.add(theValue++);
				notify();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("interrupted");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void eatData()
	{
		while(true)
		{
			synchronized(this)
			{
				while(theData.size()==0)
				{
					try {
						wait();
					} catch (InterruptedException e) {
						System.out.println("interrupted");
						e.printStackTrace();
					}
				}
			}
			notify();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
				e.printStackTrace();
			}
		}
	}
	

}
