package com.revature;

import java.util.ArrayList;

import com.revature.models.QuestionEleven;

public class QuestionElevenDriver {

	public static void main(String[] args) {			
		
		//call the method to return an array list of floats, put it into an array list to print
		ArrayList<Float> myFloats = retrieveTwoFloats();
		System.out.println(myFloats);
	}
	
	public static ArrayList<Float> retrieveTwoFloats(){
		
		//create an array list to hold the flots
		ArrayList<Float> alf = new ArrayList<Float>();
		
		QuestionEleven qe = new QuestionEleven();
		//get the floats and put them into the array list
		float fl1 = qe.getMyFloat1();
		alf.add(fl1);
		float fl2 = qe.getMyFloat2();
		alf.add(fl2);
		
		//return the array list
		return alf;
	}
	
}
