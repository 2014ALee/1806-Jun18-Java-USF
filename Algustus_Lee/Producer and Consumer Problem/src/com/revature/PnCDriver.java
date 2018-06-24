package com.revature;

import com.revature.models.PnCModel;

public class PnCDriver extends Thread{
	public static void main(String[] args)
	{
		PnCModel pnc = new PnCModel();
		
		Thread producer = new Thread()
		{
			@Override
			public void run()
			{
					pnc.makeData();
			}
			
		};
		Thread consumer = new Thread()
		{
			@Override
			public void run()
			{
				try {
					pnc.eatData();
				}
				catch(IllegalMonitorStateException e)
				{
					System.out.println("continue, exception handled.");
					e.printStackTrace();
				}
			}
		};
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		
		

	}

