package com.revature;

import java.util.ArrayList;
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
		
		List<User> users = new ArrayList<>();
		
		User u = new User("Genesis", "Bonds", "gbonds", "p4ssw0rd", "gbonds@gmail.com");
		
		users.add(u);
		users.add(new User("bob", "greg", "bobg", "p4ssw0rd", "gbonds@gmail.com"));
		users.add(new User("blake", "Kruppa", "bkruppa", "p4ssw0rd", "gbonds@gmail.com"));
		users.add(new User("bob", "gr2eg", "bobg", "p4ssw0rd", "gbonds@gmail.com"));
		users.add(u);
		
		for(User user : users) {
			System.out.println(user);
		}
		
		List<Integer> integerList = new Vector<>();
		integerList.add(0);
		integerList.add(23423);
		integerList.add(-234);
		integerList.add(34);
		integerList.add(0);
		
		for(int i : integerList)
			System.out.println(i);
		
		System.out.println("Sorting integerList...");
		
		/*
		 * Sets 
		 * 
		 * -duplicates are not allowed!
		 * -insertion order is not maintained
		 */
		
		Set<User> userSet = new HashSet<>();
		
		userSet.add(u);
		userSet.add(new User("bob", "greg", "bobg", "p4ssw0rd", "gbonds@gmail.com"));
		userSet.add(new User("blake", "Kruppa", "bkruppa", "p4ssw0rd", "gbonds@gmail.com"));
		userSet.add(new User("bob", "gr2eg", "bobg", "p4ssw0rd", "gbonds@gmail.com"));
		userSet.add(u);
		
		for(User user : userSet) {
			System.out.println(user);
		}
		
		
		/*
		 * Queues
		 * 
		 * - collection used for holding eleemnts prior to processing
		 * -first-in first-out ordering (FIFO)
		 * - PriorityQueue is the exception to the FIFO rule
		 * 
		 */
		
		Queue<User> userQueue = new LinkedList<>();
		
		userQueue.add(u);
		userQueue.add(new User("bob", "greg", "bobg", "p4ssw0rd", "gbonds@gmail.com"));
		userQueue.add(new User("blake", "Kruppa", "bkruppa", "p4ssw0rd", "gbonds@gmail.com"));
		userQueue.add(new User("bob", "gr2eg", "bobg", "p4ssw0rd", "gbonds@gmail.com"));
		userQueue.add(u);
		
		while(userQueue.size() != 0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll());
		}
		
		/*
		 * Maps
		 * 
		 * - key/value pairs
		 * - cannot contain duplicate keys
		 * - most implementations support one and only one null key (hashtable being the exception)
		 */
		
		Map<String, String> credentialsMap = new HashMap();
		credentialsMap.put("wsingleton", "password");
		credentialsMap.put(null, "password");
		credentialsMap.put("df", "passwasdfrd");
		credentialsMap.put("wsingasdfleton", null);
		credentialsMap.put("wsingleton", "password");
		
		System.out.println(credentialsMap.get("wsingasdfleton"));
		System.out.println(credentialsMap.get(null));
		
		for(Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key" + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface, which is extended by the Collection interface, and provides
		 * methods allowing for easy traversal of any concrete implementation of the 
		 * sub-iterfaces of Collection (List, Set, Queue, and Deque).
		 * 
		 * The method provided by this interface is: iterator(), which returns a object of type Iterator
		 */
		
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
	}
	
}
