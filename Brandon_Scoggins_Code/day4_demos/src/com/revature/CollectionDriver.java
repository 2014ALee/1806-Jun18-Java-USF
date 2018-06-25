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
		 * 	- ordered (indexed)
		 * 	- can contain duplicates
		 * 	- methods for positional access
		 * 	- methods for searching
		 * 	- methods for iteration (inherited from Iterable)
		 * 	- methods for range viewing
		 */
		
		List<User> users = new ArrayList<>();		// using generics
		
		User u = new User("Genesis", "Bonds", "gbonds", "password", "gbonds@gmail.com");
		
		users.add(u);
		users.add(new User("Wezley", "Singleton", "wsingleton", "newpassword", "wsingleton@gmail.com"));
		users.add(new User("Brandon", "Scoggins", "bscoggins", "bspassword", "bscoggins@gmail.com"));
		users.add(new User("Steve", "Kelsey", "skelsey", "skpassword", "skelsey@gmail.com"));
		users.add(u);
		
		// easiest way to traverse a collection
		for(User user : users) {
			System.out.println(user);
		}
		
		System.out.println("-----------------------------------------------------------------------------");
		
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}

		System.out.println("-----------------------------------------------------------------------------");
		
		List<Integer> integerList = new Vector<>();
		integerList.add(0);
		integerList.add(545);
		integerList.add(654);
		integerList.add(23456);
		integerList.add(98767);
		
		for(int i : integerList) {
			System.out.println(i);
		}

		System.out.println("-----------------------------------------------------------------------------");

		System.out.println("-----------------------------------------------------------------------------");
		
		/*
		 * Collection Utility class
		 * 
		 * Notes to go here (from github)
		 */
		
		System.out.println("Sorting integerList...");
		Collections.sort(integerList);
		System.out.println("integerList sorted!");
		
		for(int i : integerList) {
			System.out.println(i);
		}
		

		System.out.println("-----------------------------------------------------------------------------");

		System.out.println("-----------------------------------------------------------------------------");
		
		/*
		 * Sets
		 * 	- duplicates not allowed
		 * 	- insertion ordered not maintained
		 */
		
		Set<User> userSet = new HashSet<>();
		
		userSet.add(u);
		userSet.add(new User("Wezley", "Singleton", "wsingleton", "newpassword", "wsingleton@gmail.com"));
		userSet.add(new User("Brandon", "Scoggins", "bscoggins", "bspassword", "bscoggins@gmail.com"));
		userSet.add(new User("Steve", "Kelsey", "skelsey", "skpassword", "skelsey@gmail.com"));
		userSet.add(u);
		
		for(User user : userSet) {
			System.out.println(user);
		}
		
		System.out.println("-----------------------------------------------------------------------------");

		System.out.println("-----------------------------------------------------------------------------");
		
		/*
		 * Queue
		 * 	- collection use for holding elements prior to processing
		 * 	- first in first out (FIFO)
		 * 	- Priority Queue is an exception to FIFO
		 */
		
		Queue<User> userQueue = new LinkedList<>();
		
		userQueue.add(u);
		userQueue.add(new User("Wezley", "Singleton", "wsingleton", "newpassword", "wsingleton@gmail.com"));
		userQueue.add(new User("Brandon", "Scoggins", "bscoggins", "bspassword", "bscoggins@gmail.com"));
		userQueue.add(new User("Steve", "Kelsey", "skelsey", "skpassword", "skelsey@gmail.com"));
		userQueue.add(u);
		
		while(userQueue.size() != 0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll());
			
		}
		
		System.out.println("-----------------------------------------------------------------------------");

		System.out.println("-----------------------------------------------------------------------------");
		
		/*
		 * Maps
		 * - stores things in key value pairs
		 * - cannot contain duplicate keys
		 * - most implementations support one and only one null key and multiple null values
		 * 			- hashtable is the exception
		 */
		
		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put("wsingleton", "password");
		credentialsMap.put(null, "");
		credentialsMap.put("gbonds", "gbpassword");
		credentialsMap.put("bscoggins", "password");
		credentialsMap.put("wsingleton", "betterpassword"); 	// this replace the existing value
		credentialsMap.put(new String("wsingleton"), "hi");		// this will also replace the existing value
		
		// Retrieve objects from the map using their key
		System.out.println(credentialsMap.get("gbonds"));
		System.out.println(credentialsMap.get(null));

		System.out.println("-----------------------------------------------------------------------------");
	
		// Iterate over a set of entries using a for-each loop
		for(Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface which is extended by the collection interface and provides methods
		 * allowing for easy traversal of any concrete implementation of the sub interfaces of Collection
		 * (List, Set, Queue, and Dequeue)
		 * 
		 * The method provided by this interface is: iterator(), which returns an object of type Iterator
		 */
	
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		
		
		
		
		
		Map<String, String[]> myMap = new HashMap<>(); 
		
		String[] strArr = {"hey" , "there"};
		
		myMap.put("look", strArr);
		
		myMap.get("look")[1] += " babe";
		System.out.println(myMap.get("look")[1]);
		
		strArr[1] = "hlep";
		System.out.println(myMap.get("look")[1]);
		
		System.out.println(myMap.entrySet());
		
		String[] test = new String[0];
	
		
		
	}
}
