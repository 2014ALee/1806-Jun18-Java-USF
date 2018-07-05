package com.revature;

import com.revature.models.BankAccount;
import com.revature.stages.*;

public class Start {

	public static void main(String[] args) {
		boolean notExited = true;
		while (notExited) {
			BankAccount bankAccount = IntroStage.intro();
			if (bankAccount != null) {
				SessionStage.session(bankAccount);
			}
			else {
				notExited = false;
			}
		}
	}

}
