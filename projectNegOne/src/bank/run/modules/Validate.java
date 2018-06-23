package bank.run.modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import bank.run.util.User;

public class Validate {
	public static User user;
	public static Scanner sc = new Scanner(System.in); 
	public static boolean validate(String username, String password) {
		//	    String basePath = new File("").getAbsolutePath();
		String fileName = new File("src/bank/run/util/data/" + username + ".ser").getAbsolutePath();
		File tmp = new File(fileName);
		boolean exists = tmp.exists();

		if(exists) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){

				user = (User) ois.readObject();

				if(user != null)
					if(username.equals(user.getUsername()) & password.equals(user.getPassword()))
						return true;

			} catch (FileNotFoundException e) {
				System.out.println("[LOG] - An error occured while accessing the file");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("[LOG] - An error occured while writing the file");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("[LOG] - An error occured while deserializing the object");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static void logout() {
		double checking, savings;
		checking = user.getChecking();
		savings = user.getSavings();
		String fileName = new File("src/bank/run/util/data/" + user.getUsername() + ".ser").getAbsolutePath();
		File tmp = new File(fileName);
		boolean exists = tmp.exists();

		if(exists) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
				user = (User) ois.readObject();
				if(user != null) {
					user.setChecking(checking);
					user.setSavings(savings);
					try (FileOutputStream fos = new FileOutputStream(fileName);
							ObjectOutputStream oos = new ObjectOutputStream(fos);){
						oos.writeObject(user);
					} catch (FileNotFoundException e) {
						System.out.println("[LOG] - An error occured while accessing the file");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("[LOG] - An error occured while writing the file");
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("[LOG] - An error occured while accessing the file");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("[LOG] - An error occured while writing the file");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("[LOG] - An error occured while deserializing the object");
				e.printStackTrace();
			}
		}
	}
}
