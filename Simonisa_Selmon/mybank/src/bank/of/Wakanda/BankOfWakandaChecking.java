/*package bank.of.Wakanda;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankOfWakandaChecking {
	
	//private static User user= null;
	private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	

	System.out.println("Welcome To Bank Of Wankanda!");
	System.out.println("What would you like to do today?");
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		mainMenu();
	}
		
		public static void mainMenu() {
		
		System.out.println("+--------------MAIN MENU--------------+");
		
		System.out.println("[1]- Create an account");
		System.out.println("[2]- Log In");
		System.out.println("[3]- Deposit Funds");
		System.out.println("[4]- Withdraw Funds");
		System.out.println("[5]- View your balance");
		System.out.println("[6]- Close your account");
			
		@SuppressWarnings("unused")
		Scanner scan= new Scanner(System.in);
		System.out.println("Selection: ");
		String userInput= scan.next();
		userInput= br.readLine();

		try {
			
			switch (userInput) {
			
				double amt;
				 
			case "1":
				System.out.println("Navigating to Create Account Menu...");
				createAcc();
				break;
			case "2":
				System.out.println("Navigating to Returning User Menu...");
				login();
				break;
			default:
				System.out.println("Invalid selection, please try again.\n");
				mainMenu();
			}

		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
			
		
					
					
					
				
				
			case 3:
				System.out.println("Deposit Amount: ");
				amt= scan.nextDouble();
				if (amt<= 0) ;
					System.out.println("Invalid Amount");
				else {
					balance += amt;
					System.out.println(amt + "has been deposited");
					break;
				}
			case 4:
				System.out.println("Withdrawal Amount: ");
				amt= scan.nextDouble();
				if (amt<= 0 || amt> balance)
					System.out.println("Insufficient Amount");
				else { 
					balance -= amt;
					System.out.println(amt + "has been withdrawn");
					break;
				}
				
			default:
				System.out.println("");
				break;
				
			}
	}
}		
	
	private static void login() {
		
		String username, password;
		
		System.out.println("\n+ ----------------LOGIN-----------------+");
		
try {
			
			System.out.print("Username: ");
			username = br.readLine();
			
			System.out.print("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password)) {
				System.out.println("Login successful!");
				return;
			} else {
				System.out.println("Login unsuccessful!\n");
				mainMenu();//create a main menu method in order to halt error
			}
			
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}
	}
	}

*/