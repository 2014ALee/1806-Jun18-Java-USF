package com.revature;

import java.util.LinkedList;

public  class Producer{
	
		LinkedList<Integer> list = new LinkedList<>();
		
		int capacity = 2;
		
		public void Producer() throws InterruptedException {
			
			int value = 0;
			 
			while(true) {
				synchronized (this)
				{
					while(list.size()==capacity)
						wait();
					System.out.println("Producer produces-" + value);
					
					list.add(value++);
					
					notify();
					
					Thread.sleep(1000);
					
				}
			}

	}
		public void Consumer() throws InterruptedException {
			
			while(true) {
				
				synchronized (this)
				{
					while(list.size()==0)
						wait();
					
					int val = list.removeFirst();
					
					System.out.println("Consumer consumed-" + val);
					
					notify();
					
					Thread.sleep(1000);
				}
				}

			}

}
