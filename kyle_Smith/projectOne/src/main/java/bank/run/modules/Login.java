package bank.run.modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void login() {

		System.out.println("\n\n\n\n");
		String username, password;
		System.out.println("+-------------------LOGIN----------------------+");
		System.out.println("\n\n\n\n");
		//username thorws io file not found if given wrong user fix this logic.
		try {
			System.out.print("Username: ");
			username = br.readLine();
			System.out.print("Password: ");
			password = br.readLine();

			if(Validate.validate(username, password)) {
				System.out.println("Login successful!");
				Menu.mainMenu(1);
			}else {
				System.out.println("Login unsuccessful!\n");
				Menu.mainMenu(0);
			}
		} catch (IOException e) {
			System.out.println("[LOG] - Error while reading from console.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
