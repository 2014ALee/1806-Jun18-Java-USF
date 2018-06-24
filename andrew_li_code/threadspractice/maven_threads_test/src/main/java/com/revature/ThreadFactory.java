package com.revature;

public class ThreadFactory {
	public static class InterruptedThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 250; i++) {
				System.out.println("Thread 1: " + i);
			}
		}
		@Override
		public void interrupt() {
			super.interrupt();
			System.out.println("Thread 1 is being interrupted!");
		}
	}
	public static class InterruptingThread extends Thread {
		
		private InterruptedThread interruptedThread;
		
		public InterruptingThread() {
			super();
		}
		
		public void setInterruptedThread(InterruptedThread in) {
			this.interruptedThread = in;
		}
		
		public InterruptingThread(InterruptedThread in) {
			super();
			this.interruptedThread = in;
		}
		
		@Override
		public void run() {
			this.interruptedThread.interrupt();
			for (int i = 0; i < 50; i++) {
				System.out.println("Thread 2: " + i);
			}
			this.interruptedThread.interrupt();
			for (int i = 50; i < 100; i++) {
				System.out.println("Thread 2: " + i);
			}
			this.interruptedThread.interrupt();
			for (int i = 100; i < 150; i++) {
				System.out.println("Thread 2: " + i);
			}
			this.interruptedThread.interrupt();
			for (int i = 150; i < 200; i++) {
				System.out.println("Thread 2: " + i);
			}
			this.interruptedThread.interrupt();
			for (int i = 200; i < 250; i++) {
				System.out.println("Thread 2: " + i);
			}
		}
	}
	public static Thread createNewThread(String type) {
		switch(type) {
		case "interruptor":
			return new InterruptingThread();
		default:
			return new InterruptedThread();
		}
	}
	public static void main(String[] args) {

		Thread one = ThreadFactory.createNewThread("");
		Thread two = ThreadFactory.createNewThread("interruptor");
		{
			ThreadFactory.InterruptingThread temp = (ThreadFactory.InterruptingThread) two;
			ThreadFactory.InterruptedThread temp2 = (ThreadFactory.InterruptedThread) one;
			temp.setInterruptedThread(temp2);
		}
		one.start();
		two.start();
	}
}
