
package com.revature;

import java.util.LinkedList;

//Producer/Consumer Solution

public class Driver
{
 public static void main(String[] args)
                     throws InterruptedException
 {
     // Object of a class that has both produce() and consume() methods
     final ProducerConsumer pc = new ProducerConsumer();

     // Create producer thread including the run method
     Thread t1 = new Thread(new Runnable()
     {
         @Override
         public void run()
         {
             try
             {
                 pc.produce();
             }
             catch(InterruptedException ie)
             {
                 ie.printStackTrace();
             }
         }
     });

     // Create consumer thread including the run method
     Thread t2 = new Thread(new Runnable()
     {
         @Override
         public void run()
         {
             try
             {
                 pc.consume();
             }
             catch(InterruptedException ie)
             {
                 ie.printStackTrace();
             }
         }
     });

     // Start both threads
     t1.start();
     t2.start();

     //close both threads when they end
//     t1.join();
//     t2.join();
 }

 // This class has a list, producer adds items to list and consumer removes items.
 public static class ProducerConsumer
 {
     // Create a list shared by producer and consumer
     LinkedList<Integer> list = new LinkedList<>();
     // The max size of the list is 3
     int capacity = 3;

     // Function called by producer thread
     public void produce() throws InterruptedException
     {
    	 //arbitrary value to add and remove to list by producer and consumer
         int value = 1;
         
         while (true)
         {
             synchronized (this)
             {
                 // producer thread waits while list is full
                 while (list.size()==capacity) {
                     wait();
                 }
                 
                 // insert a value into the list
                 list.add(value);

                 System.out.println("Producer produced-" + list.size());
                 
                 // notifies the consumer thread that now it can start consuming
                 notify();

                 //slow it down thread for viewing purposes
                 Thread.sleep(500);
             }
         }
     }

     // Function called by consumer thread
     public void consume() throws InterruptedException
     {
         while (true)
         {
             synchronized (this)
             {
                 // consumer thread waits while list is empty
                 while (list.size()==0)
                     wait();

                 //remove an element from the list
                 list.remove();

                 System.out.println("Consumer consumed-" + list.size());

                 // Wake up producer thread
                 notify();

                 //slow down thread for viewing purposes
                 Thread.sleep(500);
             }
         }
     }
 }
}
