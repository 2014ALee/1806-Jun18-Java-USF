package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.models.User;

public class CollectionDriver {
	
	public static void main(String[] args) {
		
		/*
		 * List
		 * 
		 * - ordered (indexed)
		 * - can contain duplicated
		 * - methods for position access 
		 * - methods for searching
		 * - methods for iteration (inherited from Iterable)
		 * - methods for range viewing
		 */
		
		List<User> users = new ArrayList<>();
		
		User u = new User("Genesis", "Bonds", "gbonds", "p4ssw0rd", "gbonds@gmail.com");
		
		users.add(u);
		users.add(new User("Aaron", "Mathews", "amath", "pass", "amath@gmail.com"));
		users.add(new User("Hi", "Bye", "hibye", "hibye", "goodbye@gmail.com"));
		users.add(new User("Steve", "Kelsey", "skelsey", "passw0rd", "skelsey@gmail.com"));
		users.add(u);
		
		//Easiest way to traverse a collection
		for (User user: users) {
			System.out.println(user);
		}
		
		System.out.println("---------------------------");
		
		//Lists have indexes
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
		System.out.println("---------------------------");
		
		List<Integer> integerList = new Vector<>();
		
		integerList.add(0);
		integerList.add(23423);
		integerList.add(433);
		
		for (Integer i : integerList) {
			System.out.println(i);
		}
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		
		/*
		 * Collection Utility Class
		 * 
		 * Notes
		 */
		
		System.out.println("Sorting integer list....");
		Collections.sort(integerList);
		
		for (Integer i : integerList) {
			System.out.println(i);
		}
		
		/*
		 * Sets
		 * 
		 * - No duplicates
		 * - Insertion order not maintained
		 */
		
		Set<User> userSet = new HashSet<>();
		
		userSet.add(u);
		userSet.add(new User("Aaron", "Mathews", "amath", "pass", "amath@gmail.com"));
		userSet.add(new User("Hi", "Bye", "hibye", "hibye", "goodbye@gmail.com"));
		userSet.add(new User("Steve", "Kelsey", "skelsey", "passw0rd", "skelsey@gmail.com"));
		
		for (User user : userSet) {
			System.out.println(user);
		}
		
		/*
		 * Queues
		 * 
		 * - collection used to for holding elements prior to processing first in, first out.
		 * - priority is the exception to fifo.
		 */
		
		Queue<User> userQueue = new LinkedList<>();
		
		userQueue.add(u);
		userQueue.add(new User("Aaron", "Mathews", "amath", "pass", "amath@gmail.com"));
		userQueue.add(new User("Hi", "Bye", "hibye", "hibye", "goodbye@gmail.com"));
		userQueue.add(new User("Steve", "Kelsey", "skelsey", "passw0rd", "skelsey@gmail.com"));
		userQueue.add(u);
		
		while (userQueue.size() != 0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll());
		}
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		
		/*
		 * Maps
		 * - Stores in key, value pairs
		 * - No duplicate keys
		 * - Keys can be null except Hashtable
		 */
		
		Map<String, String> credentialsMap = new HashMap<>(); 
		credentialsMap.put("amath", "pass");
		credentialsMap.put("null", "");
		credentialsMap.put("asdf", "asdf");
		credentialsMap.put("hi", "bye");
		credentialsMap.put("blake", null);
		credentialsMap.put("amath", "passasdf"); //Replaces existing value
		
		for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
		}
		
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface which is extend by the collection interface, and provides 
		 * methods allowing for easy transveral of any concrete implementation of the sub-
		 * interfaces of Collection (List, Set, Queue, and Deque).
		 * 
		 * The method provided by this interface is "iterator()", which returns an object of 
		 * type Iterator.
		 */
		
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
		}
	}
}
