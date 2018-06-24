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
	public static void main(String[] args)
	{
	/*
	 * List
	 * 
	 * -ordered
	 * -can contain duplicates
	 * -methods for positional access
	 * -methods for iteration (inherited from Iterable)
	 * -methods for range viewing
	 */
	
	//anything in angle brackets <> are generics, and they are used for 'type safety'
	List<User> users = new ArrayList<>();
	
	User u = new User("Genesis", "Bonds", "gbonds", "gbonds@gmai.com", "p4ssw0rd");
	
	users.add(u);
	users.add(new User("troll", "face", "problem", "trololo@gmail.com", "umad"));
	users.add(new User("pepe", "frog", "feelsbadman", "hatesymbol@gmail.com", "monkaS"));
	
	//easiest way to traverse a collection
	for(User user : users)
	{
		System.out.println(user);
	}
	System.out.println("+----------------------------------------------------------+");
	//lists have indexes
	for(int i = 0; i < users.size(); i++)
	{
		System.out.println(users.get(i));
	}
	System.out.println("+----------------------------------------------------------+");
	List<Integer> integerList = new Vector<>();
	integerList.add(0);
	integerList.add(234);
	integerList.add(4038);
	integerList.add(43);
	integerList.add(0);
	
	for(int i : integerList)
	{
		System.out.println(i);
	}
	System.out.println("+----------------------------------------------------------+");
	System.out.println("+----------------------------------------------------------+");
	
	/*
	 * Collection Utility class
	 * 
	 * Notes to go here
	 */
	
	System.out.println("Sorting integerList");
	Collections.sort(integerList); //Need to have an object that implements Compareable
	System.out.println(integerList);
	
	/*
	 * Sets
	 * 
	 * -No duplicates allowed
	 * -insertion order is not maintained
	 */
	Set<User> userSet = new HashSet<>();
	
	userSet.add(u);
	userSet.add(new User("troll", "face", "problem", "trololo@gmail.com", "umad"));
	userSet.add(new User("pepe", "frog", "feelsbadman", "hatesymbol@gmail.com", "monkaS"));
	userSet.add(new User("troll", "face", "problem", "trololo@gmail.com", "umad"));
	
	for(User user: userSet)
	{
		System.out.println(user);
	}
	System.out.println("+----------------------------------------------------------+");
	System.out.println("+----------------------------------------------------------+");
	
	/*
	 * Queues
	 * 
	 * -collection used for holding elements prior to processing
	 * - first-in, first-out ordering (FIFO)
	 * -PriorityQueue does not have FIFO rule
	 */
	Queue<User> userQueue = new LinkedList<>();
	userQueue.add(u);
	userQueue.add(new User("troll", "face", "problem", "trololo@gmail.com", "umad"));
	userQueue.add(new User("pepe", "frog", "feelsbadman", "hatesymbol@gmail.com", "monkaS"));
	userQueue.add(new User("gnome", "child", "dankmeme", "modsgay@gmail.com", "memelord"));
	
	while(userQueue.size() != 0)
	{
		System.out.println("Queue size: "+ userQueue.size());
		System.out.println("Processing: "+ userQueue.poll()); //removes from the front
	}
	//Deques work the same way, but there's also a method to pull from the end of the queue, rather than the front
	
	System.out.println("+----------------------------------------------------------+");
	System.out.println("+----------------------------------------------------------+");
	
	/*
	 * Maps
	 * 
	 * -Stores things in key/value pairs
	 * -No duplicate keys
	 * -most implementations support ONLY one null key and multiple null values (Hashtable is the exception)
	 * 
	 */
	Map<String, String> credentialsMap = new HashMap<>();
	
	credentialsMap.put("cooper", "sword");
	credentialsMap.put(null, "");
	credentialsMap.put("dasima", "ghey");
	credentialsMap.put("jeezuzchris", null);
	credentialsMap.put("pepefrog", "memes");
	credentialsMap.put("xerospectrum", null);
	credentialsMap.put("cooper", "biggersword"); //overrides the existing value if the same key is used even if the
												 //'new' keyword is used with the new key
	
	System.out.println(credentialsMap.get("jeezuzchris"));
	System.out.println(credentialsMap.get(null));
	System.out.println("+----------------------------------------------------------+");
	System.out.println("+----------------------------------------------------------+");
	
	//Iterate over a Set of Entries using a foreach loop
	for(Map.Entry<String, String> entry : credentialsMap.entrySet()) //turns the map into a set so that it can be iterated through.
	{
		System.out.println("Key: "+entry.getKey()+", Value: "+entry.getValue());
	}
	System.out.println("+----------------------------------------------------------+");
	System.out.println("+----------------------------------------------------------+");
	/*
	 * Iterator
	 * 
	 * Iterable is an interfacem which is extended by the Collection interface, and provides methods allowing
	 * for easy traversal of any concrete implementation of the sub-interfaces of Collection (List, Set, Queue, and Deque)
	 * 
	 * The method provided this interface is: iterator() which returns an Iterator object.
	 */
	
	
	Iterator<Map.Entry<String, String>> moreEntries = credentialsMap.entrySet().iterator();
	
	while(moreEntries.hasNext()) {
		Map.Entry<String, String> entry = moreEntries.next();
		System.out.println("Key: "+entry.getKey()+", Value: "+entry.getValue());
	}
	}

}
