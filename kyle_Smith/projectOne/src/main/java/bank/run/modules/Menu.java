package bank.run.modules;

import java.util.Scanner;

import bank.run.modules.Register;

public class Menu {
	private static Scanner sc = new Scanner(System.in); 
	
	public static void mainMenu(int count) {
		int userInput = 0;
		if(count == 0) {
			System.out.println("+-----------------------------------------------+");
			System.out.println("[1] - Login");
			System.out.println("[2] - Register");
			System.out.print("Selection: ");
			if(sc.hasNextInt()) {
				userInput = sc.nextInt();
			}else {
				System.out.println("Invalid input press ENTER to try again...");
				sc.nextLine();
				mainMenu(0);
			}

			switch(userInput) {
				case 0:
					System.out.println("No input specified try again");
					mainMenu(0);
					break;
				case 1:
					System.out.println("Navigating to Login Menu...");
					Login.login();
					break;
				case 2: 
					System.out.println("Navigating to Registration Menu...");
					Register.register();
					break;
				default: 
					System.out.println("Invalid selection, please try again.");
					mainMenu(0);
			}
		}
		if (count == 1) {
			System.out.print("Press ENTER to continue...");
			sc.nextLine();
			sc.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n");
			System.out.println("+-------------------MAIN MENU----------------------+");
			System.out.println("[1] - Account Status");
			System.out.println("[2] - Withdraw");
			System.out.println("[3] - Deposit");
			System.out.println("[4] - Logout");
			System.out.print("Selection: ");
			if(sc.hasNextInt()) {
				userInput = sc.nextInt();
			}else {
				System.out.println("Invalid input please try again...");
				sc.nextLine();
				mainMenu(1);
			}
			switch(userInput) {
				case 0:
					System.out.println("No input specified try again");
					mainMenu(1);
					break;
				case 1:
					System.out.println("\n\n\n\n\n\n\n\n\n");
					Actions.balanceCheck();
					mainMenu(1);
					break;
				case 2:
					System.out.println("\n\n\n\n\n\n\n\n\n");
					Actions.withdraw();
					break;
				case 3:
					System.out.println("\n\n\n\n\n\n\n\n\n");
					Actions.deposit();
					break;
				case 4:
					System.out.println("\n\n\n\n\n\n\n\n\n");
					Validate.logout();
					mainMenu(0);
					break;
				default: 
					System.out.println("Invalid selection, please try again.");
					mainMenu(1);
			}
		}
	}
}
