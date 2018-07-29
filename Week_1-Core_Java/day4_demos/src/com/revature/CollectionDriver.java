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
		 * A List is an ordered Collection (sometimes called a sequence). Lists may contain duplicate elements.
		 * In addition to the operations inherited from Collection, the List interface includes operations for the following:
		 * 
		 * 		+ Positional access 
		 * 			— manipulates elements based on their numerical position in the list. This includes 
		 * 			  methods such as get, set, add, addAll, and remove.
		 * 
		 * 		+ Search 
		 * 			— searches for a specified object in the list and returns its numerical position. 
		 * 			  Search methods include indexOf and lastIndexOf.
		 * 
		 * 		+ Iteration 
		 * 			— extends Iterator semantics to take advantage of the list's sequential nature. 
		 * 			  The listIterator methods provide this behavior.
		 * 
		 * 		+ Range-view 
		 * 			— The sublist method performs arbitrary range operations on the list.
		 * 
		 * The Java platform contains two general-purpose List implementations. ArrayList, which performs well when adding or removing from 
		 * the collection frequently. A LinkedList which offers better performance when the collection will be accessed frequently (get and 
		 * set methods).
		 */
		List<User> users = new ArrayList<>();

		User u = new User("Genesis", "Bonds", "gbonds", "p4ssw0rd", "gbonds@gmail.com");

		users.add(u);
		users.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		users.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@revature.com"));
		users.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		users.add(u); // duplicates do not matter with Lists

		// easiest way to traverse a collection
		for(User user : users) {
			System.out.println(user);
		}

		System.out.println("+------------------------------------------------------------------+");

		// Lists have indexes
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}

		System.out.println("+------------------------------------------------------------------+");

		List<Integer> integerList = new Vector<>();
		integerList.add(0);
		integerList.add(23423);
		integerList.add(-234);
		integerList.add(34);
		integerList.add(0);

		for(int i : integerList) {
			System.out.println(i);
		}

		System.out.println("+------------------------------------------------------------------+");
		System.out.println("+------------------------------------------------------------------+");

		/*
		 * Collections Utility class
		 * 
		 * This class consists exclusively of static methods that operate on or return collections. It contains polymorphic 
		 * algorithms that operate on collections, "wrappers", which return a new collection backed by a specified collection, 
		 * and a few other odds and ends.
		 */
		System.out.println("Sorting integerList...");
		Collections.sort(integerList);
		System.out.println("integerList sorted!");

		for(int i : integerList) {
			System.out.println(i);
		}

		System.out.println("+------------------------------------------------------------------+");
		System.out.println("+------------------------------------------------------------------+");

		/*
		 * Set
		 * 
		 * A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction. The Set 
		 * interface contains only methods inherited from Collection and adds the restriction that duplicate elements are 
		 * prohibited. Set also adds a stronger contract on the behavior of the equals and hashCode operations, allowing Set 
		 * instances to be compared meaningfully even if their implementation types differ. Two Set instances are equal if they 
		 * contain the same elements.
		 */
		Set<User> userSet = new HashSet<>();

		userSet.add(u);
		userSet.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userSet.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userSet.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@revature.com"));
		userSet.add(u); // this compiles fine, it just doesn't add it to the set
		
		for(User user : userSet) {
			System.out.println(user);
		}

		System.out.println("+------------------------------------------------------------------+");
		System.out.println("+------------------------------------------------------------------+");

		/*
		 * Queue
		 * 
		 * A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide 
		 * additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws 
		 * an exception if the operation fails, the other returns a special value (either null or false, depending on the 
		 * operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue 
		 * implementations; in most implementations, insert operations cannot fail.
		 * 
		 * For the most part, queues maintain a first-in, first-out order. One exception to this rule is the PriorityQueue
		 * implementation, which order elements according to a supplied comparator, or the elements' natural ordering.
		 */
		Queue<User> userQueue = new LinkedList<>();
		
		userQueue.add(u);
		userQueue.add(new User("Wezley", "Singleton", "wsingleton", "password", "wsingleton@gmail.com"));
		userQueue.add(new User("Steve", "Kelsey", "skelsey", "bestpassword", "skelsey@gmail.com"));
		userQueue.add(new User("Blake", "Kruppa", "bkruppa", "drowssap", "bkruppa@revature.com"));
		userQueue.add(u);
		
		while(userQueue.size() != 0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll());
		}
		
		System.out.println("+------------------------------------------------------------------+");
		System.out.println("+------------------------------------------------------------------+");

		/*
		 * Map
		 * 
		 * An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
		 * Keys are allowed to null for most implementations - except Hashtable.
		 */
		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put("wsingleton", "password");
		credentialsMap.put(null, "");
		credentialsMap.put("gbonds", "p4ssw0rd");
		credentialsMap.put("bkruppa", null);
		credentialsMap.put("skelsey", null);
		credentialsMap.put("wsingleton", "betterpassword"); // this will override the existing value for this key
		credentialsMap.put(new String("wsingleton"), "hi"); // this will also override the existing value
		
		// Retrieve objects from the map using their key
		System.out.println(credentialsMap.get("bkruppa"));
		System.out.println(credentialsMap.get(null));
		
		System.out.println("+--------------------------------------------------------------+");
		
		// Iterate over a Set of Entries using a for-each loop (note that insertion order is not maintained)
		for(Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("+--------------------------------------------------------------+");
		
		/*
		 * Iterator
		 * 
		 * Iterable is an interface, which is extended by the Collection interface, and provides
		 * methods allowing for easy traversal of any concrete implementation of the sub-interfaces
		 * of Collection (List, Set, Queue, and Deque).
		 * 
		 * The method provided this interface is: iterator(), which returns a object of type Iterator
		 */
		Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
		
		while(moreEntries.hasNext()) {
			Map.Entry<String, String> entry = moreEntries.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
	}

}
