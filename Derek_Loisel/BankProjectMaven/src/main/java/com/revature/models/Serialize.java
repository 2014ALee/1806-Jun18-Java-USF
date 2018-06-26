package com.revature.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {

	// store the User object into the text file if they're registering with a valid username
	public static void serializeUser(User user) {

		// create a string to name the users file according to username
		String fileName = user.getUsername() + ".ser";

		// try with resources to autoclose after the try/catch
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			// Write the specified object to the ObjectOutputStream.
			oos.writeObject(user);

		} catch (FileNotFoundException fnfe) {
			// System.out.println("[LOG] - An error occurred while accessing the file");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			// System.out.println("[LOG] - An error occurred while writing the file");
			ioe.printStackTrace();
		}
	}


	public static User deSerializeUser(String username, User user) {

		String fileName = username + ".ser";

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

			user = (User) ois.readObject();

		}catch (FileNotFoundException fnfe) {
			//System.out.println("Invalid login");
			//fnfe.printStackTrace();

		} catch (IOException ioe) {
			//System.out.println("Invalid login");
			ioe.printStackTrace();

		} catch (ClassNotFoundException cnfe) {
			//System.out.println("Invalid login");
			cnfe.printStackTrace();

		}

		return user;

	}
}
