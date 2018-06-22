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

import com.revature.models.User;

public class CollectionDriver {

	public static void main(String[] args) {
		/*
		 * list
		 * 
		 * 	ordered
		 * 	can have duplicates
		 *  methods for positional access
		 *  methods for searching
		 *  methods for iteration
		 *  methods for range viewing
		 */
		
		List<User> users = new ArrayList<>();
		
		User u = new User("Genesis", "Bonds", "gbonds", "p4ssw0rd", "gbonds@gmail.com");
		
		users.add(u);
		users.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		users.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@gmail.com"));
		users.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		users.add(u);
		
		for(User user:users) {
			System.out.println(user);
		}
		
		/*
		 * collection utility class
		 * 
		 * 
		 * 
		 */
	
		/* Sets
		 *  no duplicates allowed
		 *	insertion order not maintained 
		 */
		
		Set<User> userSet = new HashSet<>();
		
		userSet.add(u);
		userSet.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userSet.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@gmail.com"));
		userSet.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userSet.add(u);
		
		for(User user : userSet) {
			System.out.println(user);
		}
		

		Queue<User> userQueue = new LinkedList<>();

		userQueue.add(u);
		userQueue.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userQueue.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@gmail.com"));
		userQueue.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userQueue.add(u);
		
		/*
		 * Maps
		 * 	key/value pairs
		 * 	no duplicate keys
		 * 	most implementations support one and only one null key (not hashtable)
		 * 	and multiple null values
		 * 
		 */
		Map<String,String> credentialsMap = new HashMap<>();
		
		credentialsMap.put("wsingleton", "password");
		credentialsMap.put("null", "");
		credentialsMap.put("gbonds", "p4ssword");
		credentialsMap.put("bkruppa", null);
		credentialsMap.put("skelsey", null);
		credentialsMap.put("wsingleton", "betterpassword");
		
		System.out.println("\n\n");
		
		for(Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		};
		
		System.out.println("\n\n");
		
		/*
		 * iterator
		 * 
		 * iterable is an interface which is extended by the collection interface, and provides methods allowing for
		 * easy traversal of any concrete implementation of the sub interfaces of collection (List, set, queue, deque)
		 * 
		 * The method provided by this interface is iterator, which returns a object of type iterator.
		 * 
		 */
		
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
		}
		
		
		
	}
	
	
	/*
	 * queues
	 * 
	 * -collection used for holding elements prior to processing
	 * -first in first out
	 * -priorityqueue is the exce[tion to FIFO
	 * 
	 */
	
	
	
	
	
	
	
}
