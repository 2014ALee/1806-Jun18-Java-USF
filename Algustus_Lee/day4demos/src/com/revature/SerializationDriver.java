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

import com.revature.models.User;

public class SerializationDriver {

	private static User user = null;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args)
	{
		mainMenu();
		//register();
		//login();
	}
	private static void mainMenu()
	{
		String userInput;

		System.out.println("+-----------------------------------MAIN MENU-----------------------------------+");

		System.out.println("[1]) - Login");
		System.out.println("[2] - Register");
		System.out.println("Selection: ");

		try {
			userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("Navigating to Login Menu\n");
				login();
				break;
			case "2":
				System.out.println("Navigating to Registration Menu\n");
				register();
				break;
			default:
				System.out.println("Invalid input, try again.");
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}
	}
	private static void register()
	{
		String firstName, lastName, username, password, email;
		System.out.println("+-----------------------------------REGISTRATION-----------------------------------+");

		try {
			System.out.println("First Name: ");
			firstName = br.readLine();

			System.out.println("Last Name: ");
			lastName = br.readLine();

			System.out.println("Username: ");
			username = br.readLine();

			System.out.println("Password: ");
			password = br.readLine();

			System.out.println("Email Address: ");
			email = br.readLine();

			user = new User(firstName, lastName, username, password, email);

			if(usernameAvailable(user))
			{
				System.out.println("Username available!");
				System.out.println("Creating new user, " + user.getUserName() + "...\n");
				serializeUser(user);
			}
			else
			{
				System.out.println("Username unavailable.");
				register();
			}
			System.out.println(user);



		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console");
			e.printStackTrace();
		}
	}

	private static boolean usernameAvailable(User u) {
		String fileName = u.getUserName() + ".ser";
		File file = new File(fileName);

		if(file.exists())
		{
			return false;
		}
		else {
			return true;
		}

	}
	private static void serializeUser(User u)
	{
		String fileName = u.getUserName()+".ser";
		/*
		 * Try-with-Resources block
		 */
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			/*
			 * Write the specified object to the ObjectiveOutputStream. The class of the object, the signature of
			 * the class, and the values of the non-transient and non-static fields of the class and all of its
			 * supertypes are written.
			 */
			oos.writeObject(u);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("[LOG] - An Error occurred while accessing the file");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("[LOG] - An Error occurred while accessing the file");
			e.printStackTrace();
		}
	}
	private static void login()
	{
		System.out.println("+------------------------------LOGIN------------------------------+");
		String username, password;
		
		try 
		{
			System.out.println("Username: ");
			username = br.readLine();
			
			System.out.println("Password: ");
			password = br.readLine();
			
			if(credentialsValid(username, password))
			{
				System.out.println("Login successful");
				return;
			}
			else {
				System.out.println("Login unsuccessful! \n");
				mainMenu();
			}
		}
		catch(IOException e)
		{
			System.out.println("[LOG] - An Error occurred while accessing the file");
			e.printStackTrace();
		}
		
	}
	private static boolean credentialsValid(String username, String password)
	{
		String fileName = username + ".ser";
		User user = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
		{
			user = (User) ois.readObject();
			
			if (user != null)
			{
				if(username.equals(user.getUserName()) & password.equals(user.getPassword()))
				{
					return true;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("[LOG] - An Error occurred while accessing the file");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("[LOG] - An Error occurred while accessing the file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[LOG] - An Error occurred while accessing the file");
			e.printStackTrace();
		}
		return false;
		
	}
}
