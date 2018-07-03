package com.revature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.models.User;

public class SerializationDriver {

		static Scanner input = new Scanner(System.in);
		// Create static user
		private static User user = null;
		private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		public static void main(String[] args) {
			
			// Prompt the user with the main menu
			mainMenu();
		}
		
		public static void mainMenu() {
			String userInput;
			System.out.println("---------Welcome to the main menu!-----------");
			
			System.out.println("[1] - Login");
			System.out.println("[2] - Register");
			System.out.println("[3] - Exit");
			System.out.print("You selected: ");
			
			try {
				userInput = br.readLine();

				switch(userInput) {
				case "1":
					System.out.println("\n Please enter your credentials:");
					login();
					break;
				case "2":
					System.out.println("\n Create your username and password:");
					register();
					break;
				case "3":
					System.out.println("Thank you! Goodbye!");
					System.exit(0);
				default:
					System.out.println("Invalid selection. Please try again. \n");
					mainMenu();
				}

			} catch (IOException e) {
				System.out.println("[Log] - Error while reading from console.");
				e.printStackTrace();
			}
		}	
		
		
		private static void login(){
			String username, password;

			try {
				System.out.println("Username: ");
				username = br.readLine();
				
				System.out.println("Password: ");
				password = br.readLine();
				
				if(credentialsValid(username, password)) {
					System.out.println("\nLogin successful!\n");
					loginMenu();
							
				}else {
					System.out.println("Login unsuccessful! Please try again.\n");
					mainMenu();
				}
				
			} catch (IOException e) {
				System.out.println("[Log] - Error while reading from console.");
				e.printStackTrace();
			}
		}
		
			private static void loginMenu() {
				String loginMenuInput;

				System.out.println("Welcome to the login menu! Please select what you would"
					+ " like to do from here.");
			    
			    System.out.println("[1] Deposit");
			    System.out.println("[2] Withdraw");
			    System.out.println("[3] View Balance");
			    System.out.println("[4] Logout");
			    System.out.println("Option: ");
			    
			    try {
			    loginMenuInput = br.readLine();
			    
			    switch(loginMenuInput) {
			    case "1":
			    	System.out.println("How much would you like to deposit?");
			    	double depositAmount = (input.nextDouble());
			    	user.setBalance((user.getBalance() + depositAmount));
			    	System.out.println("Depositing...");
			    	serializeUser(user);
			    	System.out.println("You successfully deposited: " + depositAmount + " dollars! \n");
			    	loginMenu();
			    	break;
			    case "2":
			    	System.out.println("How much would you like to withdraw?");
			    	double withdrawalAmount = input.nextDouble();
			    	if((user.getBalance()) - (withdrawalAmount) >= 0) {
			    	user.setBalance((user.getBalance() - withdrawalAmount));
			    	System.out.println("Withdrawing...");
			    	serializeUser(user);
			    	System.out.println("You successfully withdrew " + withdrawalAmount + " dollars! \n");
			    	} else {
			    		System.out.println("You may not overdraft! Please check your balance before withdrawing.\n");
			    		loginMenu();
				    	break;
			    	}
			    	
			    	loginMenu();
			    	break;
			    case "3":
			    	System.out.println("\n Balance: ");
			    	System.out.println(user.getBalance() + "\n");
			    	loginMenu();
			    	break;
			    case "4":
			    	System.out.println("Are you sure you would like to log out?\n"
			    			+ "[1] - Yes\n"
			    			+ "[2] - No");
			    	String status = br.readLine();
			    	if (status.equals("1")) {
			    	System.out.println(" You have successfully Logged out! \n");
			    	mainMenu();
			    	}else {
			    		loginMenu();
			    	}
			    	break;
			    default:
					System.out.println("Invalid selection. Please try again. \n");
					loginMenu();
			    }
			    }catch (IOException e) {
					System.out.println("[Log] - Error while reading from console.");
					e.printStackTrace();
				} 
			
		}

			public static void register() {
				String firstName, lastName, username, password, email;
				double balance;
				
				System.out.println("+-------REGISTER-------+");
				
				
				try {
					System.out.print("First Name: ");
					firstName = br.readLine();
					
					System.out.print("Last Name: ");
					lastName = br.readLine();
					
					System.out.print("Username: ");
					username = br.readLine();
					
					System.out.print("Password: ");
					password = br.readLine();
					
					System.out.print("Email Address: ");
					email = br.readLine();
					
					balance = 0;

					user = new User(firstName, lastName, username, password, email, balance);
					System.out.println("Checking username availability... \n");
					
					
					if (usernameAvailable(user)) {
						System.out.println("Username Available!\n");
						System.out.println("Creating new user, " + user.getUserName() + "...\n");
						serializeUser(user);
						loginMenu();
					} else {
						System.out.println("Username is not available. Please try again...");
						register();
					}
				
					
				} catch (IOException e) {
					System.out.println("[Log] - Error while reading from console.");
					e.printStackTrace();
				}	
			}
			
			private static boolean usernameAvailable(User u) {
				String fileName = u.getUserName() + ".ser";
				File file = new File(fileName);
				
				if(file.exists()) {
					return false;
				}else {
					return true;
				}
			}
			
			private static void serializeUser(User u) {
				
				String fileName = u.getUserName() + ".ser";
				// FileOutPut stream reads bytes
				try (FileOutputStream fos = new FileOutputStream(fileName);
						// writes primitive types of objects
						ObjectOutputStream oos = new ObjectOutputStream(fos);){
					
					//write the object to our file
					oos.writeObject(u);
					
				}catch (FileNotFoundException e) {
					System.out.println("[LOG] - An error occurred while accessing the file.");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("[LOG] - An error occurred while writing the file.");
					e.printStackTrace();
				}	
				
			}
			
			private static boolean credentialsValid(String username, String password) {
				
				String fileName = username + ".ser";
				
				/*
				 * Create ObjectInputStream to use FileInputStream to read in data
				 * File input stream reads bytes
				 */
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
					
					// Set our user = to our file data object(casted to a user Object)
					user = (User) ois.readObject();
					
					if(user != null) {
						if(username.equals(user.getUserName()) && password.equals(user.getPassword())) {
							return true;
						}
					} else {
						return false;
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("[LOG] - An error occurred while accessing the file.");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("[LOG] - An error occurred while writing the file.");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("[LOG] - An error occurred while de-serializing the object.");
					e.printStackTrace();
				}
				
				return false;
			}
			
		}

	
		
	


