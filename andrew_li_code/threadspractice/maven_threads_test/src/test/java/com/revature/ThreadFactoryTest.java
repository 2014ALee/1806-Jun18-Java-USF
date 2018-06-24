package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreadFactoryTest {

	@Test
	public void testCreateNewThread() {
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
