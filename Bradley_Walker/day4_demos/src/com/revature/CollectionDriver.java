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
		 * - positional access
		 * - searchable
		 * - iterable
		 * - methods for range viewing
		 */
		List<User> users = new ArrayList<User>();
		
		User u = new User("Genesis", "Bonds", "gbinds", "p$ssw0rd", "gbonds@gmail.com");
		users.add(u);
		users.add(new User("Wezley", "Singleton", "wsingleton", "p$ssw0rd", "wsingleton@gmail.com"));
		users.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@gmail.com"));
		users.add(new User("Steve", "Kelsey", "skelsey", "bestPassword", "skelsey@gmail.com"));
		users.add(u);
		
		for(User user : users)
			System.out.println(user);
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < users.size(); i++)
			System.out.println(users.get(i));
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		// Vector is thread safe
		List<Integer> intList = new Vector<>();
		intList.add(5);
		intList.add(1);
		intList.add(3);
		intList.add(2);
		intList.add(0);
		intList.add(4);
		
		for(int i : intList)
			System.out.println(i);
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		/*
		 * Collection Utility Class
		 */
		System.out.println("Sorting intList...");
		Collections.sort(intList);
		System.out.println("intList sorted");
		for(int i : intList)
			System.out.println(i);
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		/*
		 * Sets
		 * 
		 * - no duplicates
		 * - insertion order is not maintained
		 */
		Set<User> u2 = new HashSet<>();
		u2.add(u);
		u2.add(new User("Wezley", "Singleton", "wsingleton", "p$ssw0rd", "wsingleton@gmail.com"));
		u2.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@gmail.com"));
		u2.add(new User("Steve", "Kelsey", "skelsey", "bestPassword", "skelsey@gmail.com"));
		u2.add(u); // Compiles but doesn't actually add it to the set
		
		for(User user : u2)
			System.out.println(user);
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		/*
		 * Queues
		 * 
		 * - collection used for holding elements prior to processing
		 * - FIFO
		 * - PriorityQueue is exception to FIFO
		 */
		Queue<User> userQueue = new LinkedList<>();
		
		userQueue.add(u);
		userQueue.add(new User("Wezley", "Singleton", "wsingleton", "p$ssw0rd", "wsingleton@gmail.com"));
		userQueue.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@gmail.com"));
		userQueue.add(new User("Steve", "Kelsey", "skelsey", "bestPassword", "skelsey@gmail.com"));
		userQueue.add(u);

		System.out.println(userQueue.size() + " users ahead of you");
		while(userQueue.size() != 0) {
			System.out.println("Now Serving: " + userQueue.poll());
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		/*
		 * Maps
		 * 
		 * - stores key/value pairs
		 * - no duplicate keys
		 * - 1 null key (except for Hashtable)
		 * - null values (except for Hashtable)
		 * - mathematical function
		 */
		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put("Wezley", "password");
		credentialsMap.put("Bradley", "password1");
		credentialsMap.put("Aaron", null);
		credentialsMap.put("Skoll", "password2");
		credentialsMap.put("Wezley", "better_password"); // This overrides the existing key
		credentialsMap.put(new String("Wezley"), "best_password"); // This also overrides the existing value
		
		System.out.println(credentialsMap.get("Bradley"));
		System.out.println(credentialsMap.get("Aaron"));
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		// Iterate over set of entries
		for(Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
			System.out.println();
		}
		
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface, which is extended by the Collection interface and proivides methods allowing
		 * for easy travesral of any concrete implementation of the sub-interfaces of COllection.
		 * 
		 * The method provided by this interface is iterator() which returns an object of type Iterator.
		 */
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
			System.out.println();
		}
	}

}
