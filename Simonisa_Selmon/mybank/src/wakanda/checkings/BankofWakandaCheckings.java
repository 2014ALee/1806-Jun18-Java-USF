package wakanda.checkings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import wakanda.checkings.CustomerUse;



public class BankofWakandaCheckings {

	
	private static CustomerUse user = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner scan= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		mainMenu();
		

	} //main function closes here
	
	/*all of the below is a part of my superclass who will have imported my Customer
	 * Use Information
	 */
	
	private static void mainMenu() {

		//String userInput;

		System.out.println("+--------------MAIN MENU--------------+");

		System.out.println("[1] - Create an Account");
		System.out.println("[2] - Login");
		System.out.println("[3] - Deposit funds");
		System.out.println("[4] - View your balance");
		System.out.println("[5] - Close your account");
		System.out.println("[6] - Withdraw Funds");
		System.out.print("Selection: ");
	
		
		Scanner scan= new Scanner(System.in);
		//System.out.println("Selection: ");
		String userInput= scan.next();
		//userInput= br.readLine(); 

		//try {
			
			//userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("Navigating to New User Menu...");
				createAcc();
				break;
			case "2":
				System.out.println("Navigating to Returning User Menu...");
				returningUser("nope");
				break;
			case "3":
				System.out.println("Please Login");
				returningUser("deposit");
			case "4:":
				System.out.println("Please Login");
				returningUser("withdraw");
			case "5":
				System.out.println("Please visit your local branch.");
				mainMenu();
			case "6":
				System.out.println("Please Login");
				returningUser("withdraw");
			default:
				System.out.println("Invalid selection, please try again.\n");
				mainMenu();
			//}

		/*//} /*catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}*/
	}

	}// end of main menu method
	
			
			private static void createAcc() {
				
				String firstName, lastName, username, password, email;
				
				System.out.println("\n+--------------REGISTRATION--------------+");
				
				
				try {
					
					System.out.print("First name: ");
					firstName = br.readLine();
					
					System.out.print("Last name: ");
					lastName = br.readLine();
					
					System.out.print("Username: ");
					username = br.readLine();
					
					System.out.print("Password: ");
					password = br.readLine();
					
					System.out.print("Email Address: ");
					email = br.readLine();
					
					CustomerUse u = new CustomerUse(firstName, lastName, username, password, email, 0.0, 0.0);
					System.out.println("Checking username availability...");
					
					if(usernameAvailable(user)) {
						System.out.println("Username available!");
						System.out.println("Creating new account, " + user.getUsername() + "...\n");
						serializeUser(user);
					} else {
						System.out.println("Username is not available. Please try again...");
						createAcc();
					}
					
					
				} catch (IOException e) {
					System.out.println("[LOG] - Error while reading from console");
					e.printStackTrace();
				}
				
			}	
			
			
			private static void serializeUser(CustomerUse u) {
				
				String fileName = u.getUsername() + ".ser";
				
				try (FileOutputStream fos = new FileOutputStream(fileName);
						ObjectOutputStream oos = new ObjectOutputStream(fos);) {
					
					
					oos.writeObject(u);
					
					
				} catch (FileNotFoundException e) {
					System.out.println("[LOG] - An error occurred while accessing the file");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("[LOG] - An error occurred while writing the file");
					e.printStackTrace();
				}
			}
			
			private static boolean usernameAvailable(CustomerUse u) {
				
				String fileName = u.getUsername() + ".ser";
				File file = new File(fileName);
				
				if(file.exists()) {
					return false;
				} else {
					return true;
				}
			//}

		//}

	}
			private static void returningUser(String str) { //this is where I am passing in Sring str
				
				String username, password;
				
				System.out.println("\n+--------------LOGIN--------------+");
				
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
						mainMenu();
					}
					
				switch(str) { // so that my user will be prompted to deposit after logging in
				
					case "3":
						depositFunds();
				}
					
				} catch (IOException e) {
					System.out.println("[LOG] - Error while reading from console");
					e.printStackTrace();
				}
			}
			
			private static boolean credentialsValid(String username, String password) {
				
				String fileName = username + ".ser";
				
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
					
					user = (CustomerUse) ois.readObject();
					
					if(user != null) {
						
						if(username.equals(user.getUsername()) & password.equals(user.getPassword())) {
							return true;
						}
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("[LOG] - An error occurred while accessing the file");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("[LOG] - An error occurred while writing the file");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("[LOG] - An error occurred while deserializing the object");
					e.printStackTrace();
				}
				
				return false;
			}

			private static void depositFunds() {
			
	
					System.out.println("Deposit Amount: ");
					Double amt = 0.0;
					Double balance = 0.0;
					try {
						amt= Double.valueOf(br.readLine());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (amt<= 0) {
						System.out.println("Invalid Amount");
					} else {
						balance += amt;
						System.out.println(amt + "has been deposited");
					}
			}	
			private static void withdraw() {
				System.out.println("Withdrawal Amount: ");
				
				Double amt= 0.0;
				Double balance= 0.0;
			
				try {
					amt= Double.valueOf(br.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				//amt= scan.nextDouble();
				if (amt<= 0 || amt> balance)
					System.out.println("Insufficient Amount");
				else { 
					balance -= amt;
					System.out.println(amt + "has been withdrawn");
	
			}

			}
}// end of my superclass
