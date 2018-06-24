package com.revature;

import java.util.Vector;

public class Q2 
{
	public static void main(String[] args)
	{
		//used a vector in case more elements would ever be wanted
		Vector<Integer> theSequence = new Vector<Integer>();
		//made the number of elements a variable in case more elements would ever be wanted
		int numOfElements = 25;
		System.out.println("The fibonacci: "+fib(theSequence, numOfElements));

	}
	public static Vector<Integer> fib(Vector<Integer> theSequence, int numOfElements)
	{

		//the loop
		for (int i = 0; i < numOfElements; i++)
		{
			//automatically sets elements one and two, which are 1 by default
			if (i <  2)
			{
				theSequence.add(1);
			}
			//takes the sum of the two previous numbers and sets them to the current element
			else
			{
				theSequence.add(i, (theSequence.get(i-1) + theSequence.get(i-2)));
			}
			//when at the end of the number of elements, breaks out
			if(i == numOfElements-1)
			{
				break;
			}
		}
		return theSequence;
		
	}


}
