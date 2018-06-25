package w1r.procon.models;

import java.util.LinkedList;

/*
 * A superclass for Consumer and Producer to share certain variables.
 */

public class ProCon extends Thread {
	// Lazy defaulting
	static int size;
	static int maxSize;
	static LinkedList<Integer> buffer;
	
	ProCon() {
		
	}
	
	public ProCon(int size, int maxSize, LinkedList<Integer> buffer) {
		setSize(size);
		setMaxSize(maxSize);
		setList(buffer);
	}
	
	private static void setSize(int s) {
		size = s;
	}
	
	private static void setMaxSize(int ms) {
		maxSize = ms;
	}
	
	private static void setList(LinkedList<Integer> l) {
		buffer = l;
	}
	
	@Override
	public void run() {
		
	}
}
