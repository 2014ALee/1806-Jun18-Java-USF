package com.revature;


import java.util.*;
import java.util.ArrayList;

import com.revature.models.User;

public class CollectionDriver{

	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		
		User u = new User("Lamine", "Kaba", "lkaba", "kaquev", "Lkaba@g.com");
		
		users.add(u);
		
		users.add(new User("Lamine", "Kaba", "lkaba", "kaquev", "Lkaba@g.com"));
		users.add(new User("Lamine", "Kaba", "lkaba", "kaquev", "Lkaba@g.com"));
		users.add(new User("Lamine", "Kaba", "lkaba", "kaquev", "Lkaba@g.com"));
		users.add(u);//duplicates do not matter with Lists
		
		// easiest way to traverse a collection
		
		for(User user : users) {
			System.out.println(user);
		}
		
		System.out.println("-----------------------------------------");
		
		/*
		 * Collection Utility class
		 */
		
		System.out.println("Sorting integerList...");
		//Collections.sort(integerList);
		
		Queue<User> userQueue = new LinkedList<>();
		
		userQueue.add(u);
		userQueue.add(new User("Lamine", "Kaba", "lkaba", "kaquev", "Lkaba@g.com"));
		userQueue.add(new User("Lamine", "Kaba", "lkaba", "kaquev", "Lkaba@g.com"));
		userQueue.add(new User("Lamine", "Kaba", "lkaba", "kaquev", "Lkaba@g.com"));
		userQueue.add(u);
		
		while(userQueue.size() !=0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll());	
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		
		Map<String, String> credentialsMap = new HashMap<>();
		
		credentialsMap.put("lamine", "kabal");
		credentialsMap.put(null, " ");
		credentialsMap.put("lamine", "kabal");
		credentialsMap.put("lamine", null);
		credentialsMap.put("lamine", null);
		credentialsMap.put("lamine", "hassNorma");
		
		System.out.println(credentialsMap.get("kabal"));
		System.out.println(credentialsMap.get(null));
		
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		
		/*
		 * Iterable is an interface, which is extended by the collection interface, and provides methods
		 * allowing for easy traversal of any concrete implementation of the sub-interfaces of collection
		 * (list, set, queue, and dequeue).
		 */
		
		Iterator<Map.Entry<String, String>> moreEntrises = credentialsMap.entrySet().iterator();
		
		while(moreEntrises.hasNext()) {
			Map.Entry<String, String> entry = moreEntrises.next();
			System.out.println("Key: " +entry.getKey() + ", value, " +entry.getValue());
		}

		
	}

}
