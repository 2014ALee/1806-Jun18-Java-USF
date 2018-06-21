package com.revature;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.models.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionDriver {
	public static void main(String[] args) {

		/*
		 * List
		 * 
		 * ordered can contain duplicates methods for positional access, searching,
		 * iteration, and range viewing
		 */

		List<User> users = new ArrayList<>();

		User u = new User("Genesis", "Bonds", "gbonds", "p4ssw0rd", "gbonds@gmail.com");

		users.add(u);
		users.add(new User("wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		users.add(new User("boo", "doo", "boodoo", "passy", "wboo@gmail.com"));
		users.add(new User("rang", "chow", "rangy77", "passydog", "rang@gmail.com"));
		users.add(u); // duplicates are accepted with lists

		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}

		System.out.println("+-----------------------------------------+");

		List<Integer> integerList = new Vector<>();
		integerList.add(0);
		integerList.add(234234);
		integerList.add(-234);
		integerList.add(34);
		integerList.add(0);

		for (int i : integerList) {
			System.out.println(i);
		}

		System.out.println("sorting integerList...");
		Collections.sort(integerList);
		System.out.println(integerList);

		/*
		 * Sets
		 * 
		 * duplicates are not allowed insertion order is not maintained
		 */

		Set<User> userSet = new HashSet<>();

		userSet.add(new User("wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userSet.add(new User("boo", "doo", "boodoo", "passy", "wboo@gmail.com"));
		userSet.add(new User("rang", "chow", "rangy77", "passydog", "rang@gmail.com"));

		/*
		 * Queues
		 * 
		 * collection used for holding elements prior to processing fifo priority que is
		 * the exception to fifo
		 * 
		 * 
		 */
		Queue<User> userQueue = new LinkedList<>();

		userQueue.add(new User("wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userQueue.add(new User("boo", "doo", "boodoo", "passy", "wboo@gmail.com"));
		userQueue.add(new User("rang", "chow", "rangy77", "passydog", "rang@gmail.com"));

		while (userQueue.size() != 0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll()); // retrieves and removes the head of this queue or
																	// returns null if empty
		}

		/*
		 * Maps
		 * 
		 * key/value pairs cannot contain duplicate keys most implementations support
		 * one and only one null key; hashtable wont support any nulls
		 */

		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put("wsingleton", "password");
		credentialsMap.put("null", "");
		credentialsMap.put("blake", "p4ssword");
		credentialsMap.put("bae", "null");
		credentialsMap.put("wsingleton", "password"); // this will override the existing value for the key

		// retrieve objects from the map using their key
		System.out.println(credentialsMap.get("blake"));
		System.out.println(credentialsMap.get(null));
		System.out.println(credentialsMap.get("bae"));

		// iterate over a set of map entries using a foreach loop
		for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface, which is extended by the collection interface, and provides methods allowing for easy trversal of 
		 * any concrete implementation of the sub-interfaces of Collection (List, Set, Queue, and Deque)
		 * The method provided by this interface is : iterator(); which returnsn an object of type Iterator.
		 */
		
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		//hasNext, next; get these methods from the iterator object
		//says while there are more entries, go ahead and go through it
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}
}
