package com.revature;

import com.revature.models.*;
import com.revature.stages.*;

public class BankAccountDriver {

	public static void main(String[] args) {
		/*
		 * At this stage, the user has yet to log in
		 * the user has just started and is definitely
		 * not finished.
		 */
		BankAccount ba = FirstStage.stage1();
		if (ba != null) {
			SecondStage.handleSession(ba);
		}
	}
}
