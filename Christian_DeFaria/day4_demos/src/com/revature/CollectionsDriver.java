package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.models.User;

public class CollectionsDriver {
	
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		
		User u = new User("Genesis", "Bonds", "gbonds", "p4ssw0rd", "gbonds@gmail.com");
		users.add(u);
		users.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		users.add(new User("Blake", "Kruppa", "bkruppa", "dorwssap", "bkruppa@revature.com"));
		users.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		users.add(u);
		
		for(User user : users) {
			System.out.println(user);
		}
		
		System.out.println("-------------------------------------");
		
		for(int i = 0; i<users.size(); i++) {
			System.out.println(users.get(i));
		}
		
		System.out.println("-------------------------------------");
		
		List<Integer> integerList= new Vector<>();
		integerList.add(0);
		integerList.add(23423);
		integerList.add(-234);
		integerList.add(34);
		integerList.add(0);
		
		for(int i : integerList) {
			System.out.println(i);
		}
		
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		System.out.println("Sorting integer list...");
		Collections.sort(integerList);
		System.out.println("Integer list sorted");
		for(int i : integerList) {
			System.out.println(i);
		}
		
		/*
		 * Sets
		 *  - no duplicate values
		 *  - insertion order is not maintained
		 */
		Set<User> userSet = new HashSet<>();
		userSet.add(u);
		userSet.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userSet.add(new User("Blake", "Kruppa", "bkruppa", "dorwssap", "bkruppa@revature.com"));
		userSet.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userSet.add(u);
		for(User user : userSet) {
			System.out.println(user);
		}
		
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		/*
		 * Queues
		 *  - collection used for holding elements prior to processing
		 *  - first-in, first-out ordering ()
		 *  - PriorityQueue is the exception to FIFO rule
		 */
		Queue<User> userQueue = new LinkedList<>();
		userQueue.add(u);
		userQueue.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userQueue.add(new User("Blake", "Kruppa", "bkruppa", "dorwssap", "bkruppa@revature.com"));
		userQueue.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userQueue.add(u);
		
		while(userQueue.size()!=0) {
			System.out.println("Queue Size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		/*
		 * Maps
		 *  - Key/Value pairs
		 *  - No duplicate keys
		 *  - most implementations 1 null key and multiple null values (not Hashtable)
		 */
		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put(null, "");
		credentialsMap.put("gbonds", "p4ssw0rd");
		credentialsMap.put("bkruppa", null);
		credentialsMap.put("skelsey", null);
		credentialsMap.put("wsingleton", "betterpassword");	//overrides existing value
		credentialsMap.put(new String("wsingleton"), "hi"); //overrides existing value
		
		//Retrive objects from the map using their key
		System.out.println(credentialsMap.get("bkruppa"));
		System.out.println(credentialsMap.get(null));
		
		System.out.println("-------------------------------------");
		
		//Iterate over a set of entries using a for-each loop
		for(Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface, which is extended by the Collection interface, and provides
		 * methods allowing for easy traversal of any concrete implementation of the sub-interfaces
		 * of the Collection (List, Set, Queue, Deque)
		 * 
		 * The method provided the interface is: iterator(), which returns an object of type Iterator
		 */
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
	}
}
