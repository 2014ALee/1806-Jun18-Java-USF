package homework_week1.questions;

import java.util.Arrays;
import java.util.LinkedList;

public class Question13 {

	//this method uses the current line number to determine if a 1 or a 0
	//are being appended to the line to be printed out
	public static int numberToAppend(int input){
		if(input % 4 == 2 | input % 4 == 3) {
			return 1;

		} else {
			if(input % 4 == 0 | input % 4 == 1) {
				return 0;			
			}
		}
		return 0;
	}

	public static void printLinkedList(LinkedList<Integer> linkedList) {
		for(int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + " ");
		}
		System.out.println("\t");
	}

	public static LinkedList<Integer> getTriangleLine(int lineNumber){

		//the for loop below prints one line of 0's and 1's
		//we store this line as a Linked List
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		for(int i = 1; i <= lineNumber; i++) {

			int toAdd = numberToAppend(i);

			//if the line number is even, we add to the head of the list
			if(Question6.isEven(i)) {
				linkedList.addFirst(toAdd);
			//if the line is odd we add to the end of the list	
			} else {
				linkedList.addLast(toAdd);
			}
		}

		return linkedList;
	}
	
	public static void printTriangle(int numberOfLines) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		//the outter for loop prints one line of the triangle per iteration	
		for(int j = 1; j <= numberOfLines; j++) {	
			linkedList = getTriangleLine(j);
			printLinkedList(linkedList);
		}
	}

	public static void main(String[] args) {
		printTriangle(4);
	}

}
