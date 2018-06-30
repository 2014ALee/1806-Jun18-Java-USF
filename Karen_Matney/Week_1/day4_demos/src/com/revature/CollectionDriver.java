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
		 * - can contain duplicates
		 * - methods for positional access
		 * - methods for searching
		 * - methods for iteration (inherited from Iterable)
		 * - methods for range viewing
		 */
		List<User> users = new ArrayList<>();
		
		User u = new User("Genesis", "Bonds", "gbonds", "p4assw0rd", "gbonds@gmail.com");
		users.add(u);
		users.add(new User("Wezley", "Singleton", "wsingleton", "password","wsingleton@gmail.com"));
		users.add(new User("Blake", "Kruppa", "bkruppa", "drowssap","bkruppa@revature.com"));
		users.add(new User("Steve", "Kelse", "skelsey", "bestpassword", "skelsey@gmail.com"));
		users.add(u); //Duplicates do not matter with lists
		
		// easiest way to traverse a collection
		for(User user : users) {
			System.out.println(user);
		}
		
		System.out.println("+-----------------------------------+");
		
		// Lists have indices
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
		
		System.out.println("+-----------------------------------+");
		
		List<Integer> integerList = new Vector<>();
		integerList.add(123);
		integerList.add(30);
		integerList.add(425);
		integerList.add(2341);
		integerList.add(30);
		integerList.add(439052);
		
		for(int i : integerList) {
			System.out.println(i);
		}
		
		System.out.println("+-----------------------------------+");
		System.out.println("+-----------------------------------+");
		
		/*
		 * Collection Utility class
		 * 
		 * NOTES TO GO HERE
		 */
		System.out.println("Sorting integerList...");
		Collections.sort(integerList);
		System.out.println("IntegerList sorted!");
		
		for(int i : integerList) {
			System.out.println(i);
		}
		
		System.out.println("+-----------------------------------+");
		System.out.println("+-----------------------------------+");
		
		/*
		 * Sets
		 * 
		 * - duplicates are not allowed!
		 * - insertion order is not maintained
		 */
		Set<User> userSet = new HashSet<>();

		userSet.add(u);
		userSet.add(new User("Wezley", "Singleton", "wsingleton", "password","wsingleton@gmail.com"));
		userSet.add(new User("Blake", "Kruppa", "bkruppa", "drowssap","bkruppa@revature.com"));
		userSet.add(new User("Steve", "Kelse", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userSet.add(u); // Duplicates do not get added to set
		
		for(User user : userSet) {
			System.out.println(user);
		}
		
		System.out.println("+-----------------------------------+");
		System.out.println("+-----------------------------------+");
		
		/*
		 * Queues
		 * 
		 * - collection used for holding elements prior to processing
		 * - first-in, first-out ordering (FIFO)
		 * - PriorityQueue is teh exception to the FIFO rule
		 */
		Queue<User> userQueue = new LinkedList<>();
		
		userQueue.add(u);
		userQueue.add(new User("Wezley", "Singleton", "wsingleton", "password","wsingleton@gmail.com"));
		userQueue.add(new User("Blake", "Kruppa", "bkruppa", "drowssap","bkruppa@revature.com"));
		userQueue.add(new User("Steve", "Kelse", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userQueue.add(u); // Duplicates do not get added to set
		
		while(userQueue.size() != 0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.peek());
			System.out.println("Polling: " + userQueue.poll());
		}
		
		System.out.println("+-----------------------------------+");
		System.out.println("+-----------------------------------+");
		
		/*
		 * Mays
		 * 
		 * - key/value pairs
		 * - cannot contain duplicate keys
		 * - most implementations support one and only one null key
		 * 		and mulitiple null values (Hashtable, being the exception)
		 */
		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put("wsingleton", "password");
		credentialsMap.put(null, "");
		credentialsMap.put("gebonds", "p4ssw0rd");
		credentialsMap.put("bkruppa", null);
		credentialsMap.put("skelsey", null);
		credentialsMap.put("wsingleton", "betterpassword"); // This will override the existing value
		credentialsMap.put(new String("wsingleton"), "hi"); // This still overrides the existing value
		
		// Retrieve objects from the map using their key
		System.out.println(credentialsMap.get("bkruppa"));
		System.out.println(credentialsMap.get(null));
		
		System.out.println("+-----------------------------------+");
		
		// Iterate over a set of entries using a for-each loop (note that insertion order is not maintained)
		for(Map.Entry<String,String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		System.out.println("+-----------------------------------+");
		System.out.println("+-----------------------------------+");
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface, which is extended by the Collection interface, and provides
		 * methods allowing for easy traversal of any concrete implementation of the sub-interfaces 
		 * of Collection (List, Set,Queue, and Deque)
		 * 
		 * The method provided this interface is: iterator(), which returns a object of type Iterator
		 */
		
		Iterator<Map.Entry<String,String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}
}