package homework_week1;

import java.util.LinkedList;

public class Question13 {

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

	public static void printTriangle(int numberOfLines) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		//the outter for loop prints one line of 0's and 1's per iteration	
		for(int j = 1; j <= numberOfLines; j++) {	

			//the for loop below prints one line of 0's and 1's
			linkedList = new LinkedList<Integer>();

			for(int i = 1; i <= j; i++) {

				int toAdd = numberToAppend(i);

				if(DetermineIfEven.isEven(i)) {
					linkedList.addFirst(toAdd);
				} else {
					linkedList.addLast(toAdd);
				}
			}
			printLinkedList(linkedList);
		}
	}

	public static void main(String[] args) {
		printTriangle(4);
	}

}
