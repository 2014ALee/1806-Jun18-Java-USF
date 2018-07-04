package bank.run.modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

import bank.run.dao.AccountDAOImpl;
import bank.run.dao.JointAccDAOImpl;
import bank.run.dao.UserDAOImpl;
import bank.run.util.Account;
import bank.run.util.User;

public class Register {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner sc = new Scanner(System.in);  
	private static UserDAOImpl userImpl = new UserDAOImpl();
	private static AccountDAOImpl accountImpl = new AccountDAOImpl();
	private static JointAccDAOImpl jointImpl = new JointAccDAOImpl();

	public static void register() {
		String firstName, lastName, username, password, email;
		double checking, savings;
		savings = 0;
		checking = 0;
		System.out.println("+-------------------Registration----------------------+");

		try {
			System.out.println("First name: ");
			firstName = br.readLine();

			System.out.println("Last name: ");
			lastName = br.readLine();

			System.out.println("Username: ");
			username = br.readLine();
			
			if(!(username.matches("[A-Za-z0-9+_-]+"))) {
				for(int i =0;i > -1;i++) {
					System.out.println("Invalid username:" + username +"  re-register...");
					System.out.println("username: ");
					username = br.readLine();
					if(!(username.matches("[A-Za-z0-9+_.-]+@.+"))) {
						continue;
					}else if(i >= 7) {
						System.out.println("To many attempts...");
						Menu.mainMenu(0);
					}else {
						if(!(available(1, username))) {
							System.out.println("username: " + username + " unavailable re-register...");
						}else
							i = -1;
					}
				}
			}
			
			System.out.println("Password: ");
			password = br.readLine();

			System.out.println("Email: ");
			email = br.readLine();
			if(!(email.matches("[A-Za-z0-9+_.-]+@.+"))) {
				for(int i =0;i > -1;i++) {
					System.out.println("Invalid email:" + email +"  re-register...");
					System.out.println("Email: ");
					email = br.readLine();
					if(!(email.matches("[A-Za-z0-9+_.-]+@.+"))) {
						continue;
					}else if(i >= 7) {
						System.out.println("To many attempts...");
						Menu.mainMenu(0);
					}else {
						if(!(available(1, email))) {
							System.out.println("Email: " + email + " unavailable re-register...");
						}else
							i = -1;
					}
				}
			}
			
			DecimalFormat df = new DecimalFormat("###.##");
			
			for(int i = 0; i <=3; i++) {
				System.out.println("Depoist into checking: ");
				if(sc.hasNextDouble()) {
					checking = 	Double.valueOf(df.format(Math.abs(sc.nextDouble())));
					break;
				}else if(i == 3) {
					System.out.println("To many atempts please try again");
					register();
				}else {
					System.out.println("Please enter money in correct format...");
					sc.next();
				}
			}
			
			for(int i = 0; i <=3; i++) {
				System.out.println("Depoist into savings: ");
				if(sc.hasNextDouble()) {
					savings = Double.valueOf(df.format(Math.abs(sc.nextDouble())));
					break;
				}else if(i == 3) {
					System.out.println("To many atempts please try again");
					register();
				}else {
					System.out.println("Please enter money in correct format...");
					sc.next();
				}
			}
			User user = new User(1,firstName, lastName, username, password, email);
			System.out.println("Creating new user, " + user.getUsername() + "...\n");
			if(userImpl.insertUser(user))
				System.out.println("User Created!");
			else {
				System.out.println("Error creating user try again...");
				Menu.mainMenu(0);
			}
			Account acc = new Account(1,user.getUserID(),checking,savings);
			if(accountImpl.insertAccount(acc))
				System.out.println("Account Created!");
			else {
				System.out.println("Error creating account try again...");
				Menu.mainMenu(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu.mainMenu(0);
	}
	private static boolean available(int i, Object... arg) {
		if( i == 1)
			return userImpl.getAllUsernames().contains(arg[0]);
		else if(i == 2)
			return userImpl.getAllEmails().contains(arg[0]);
		return false;
	}

	private static void serializeUser(User u) {
		String fileName = new File("src/main/java/bank/run/util/data/" + u.getUsername() + ".ser").getAbsolutePath();
		/*
		 * Try-with-Resources block
		 */
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){

			/*
			 * Write the specified object to the ObjectOutputStream. the class of the object, the 
			 * signature of the class, and the values of the non-transient and
			 * non-static fields of the class and all of its supertypes are written.
			 */
			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occured while accessing the file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occured while writing the file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static boolean isFilenameValid(String file) {
		File f = new File(new File("src/main/java/bank/run/util/data/" + file + ".ser").getAbsolutePath());
		try {
			f.getCanonicalPath();
			return true;
		}
		catch (IOException e) {
			return false;
		}
	}
}
