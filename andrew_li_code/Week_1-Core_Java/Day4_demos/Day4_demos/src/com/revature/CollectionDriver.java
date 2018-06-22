package com.revature;

import com.revature.models.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class CollectionDriver {

	public static void main(String[] args) {
		/*
		 * Lists are 
		 * -
		 * -
		 * -
		 * -
		 * -
		 * -
		 * 
		 */
		List<User> users = new ArrayList<User>();
		User u = new User("Genesis", "Bonds", "gbonds",
				"p4ssw0rd", "gbonds@gmail.com");
		users.add(u);
		users.add(new User("Andrew", "Li", "andrewli",
				"andrew", "andrewli.gatech@gmail.com"));
		users.add(new User("Tom", "Steyaert", "Toms",
				"karaqw", "tsteyaert@gmail.com"));
		users.add(u);
		for (User user : users) {
			System.out.println(user);
		}
		
		/*
		 * Collection Utility Class
		 */
		System.out.println("Sorting integerList...");
		Collections.sort(users, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o1.hashCode() - o2.hashCode();
			}
			
		});
		
		Set<User> userSet = new HashSet<User>();
		userSet.add(u);
		userSet.add(new User("Andrew", "Li", "andrewli",
				"andrew", "andrewli.gatech@gmail.com"));
		userSet.add(new User("Tom", "Steyaert", "Toms",
				"karaqw", "tsteyaert@gmail.com"));
		userSet.add(u);
		for (User user : userSet) {
			System.out.println(user);
		}
		
		/*
		 * Queues
		 * 
		 * - Collection used for holding elements prior to processing.
		 * - first-in first-out ordering (FIFO)
		 * - Priority Queue is the exception to FIFO rule
		 */
		
		/*
		 * Maps store key/value pairs
		 * cannot scontain duplicate keys
		 * most implementations support one and only one key,
		 * hashtable being only exception
		 */
		Map<String, String> credentialsMap = new HashMap<String, String>();
		credentialsMap.put("wsingletone", "password");
		credentialsMap.put("wsingletone", "password1");
		credentialsMap.put("wsingletone", "password2");
		credentialsMap.put("wsingletone", "password3");
		credentialsMap.put("wsingletone", "password4");
		credentialsMap.put("wsingletone", "password5");
		credentialsMap.put("gbonds", "hat");
		credentialsMap.put("bkruppa", null);
		credentialsMap.put("skelsey", "tal");
		credentialsMap.put("wsingletone", "password6"); // This will override
		// the existing value for this key.
		credentialsMap.put(new String("wsingletone"), "password6");
		System.out.println(credentialsMap.get("bkruppa"));
		for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface, which is extended by the Collection interface,
		 * and provides methods allowing for easy traversal of any concrete
		 * implementation of the sub-interfaces of Collection (List, Set, Queue, Deque).
		 * 
		 * The method provided this interface is: iterator(), which returns a object
		 * of type Iterator
		 * 
		 */
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		while (moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.print("Key: ");
			System.out.println(entry.getKey());
			System.out.print("Value: ");
			System.out.println(entry.getValue());
			
		}
	}

}
