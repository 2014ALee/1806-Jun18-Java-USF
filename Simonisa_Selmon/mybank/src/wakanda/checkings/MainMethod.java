package wakanda.checkings;
import java.util.Scanner;
import java.io.BufferedReader;




public class MainMethod {

	public static void main(String[] args) {
		
	}
	
	private static void mainMenu() {

		//String userInput;

		System.out.println("+--------------MAIN MENU--------------+");

		System.out.println("[1] - Create an Account");
		System.out.println("[2] - Login");
		System.out.println("[3] - Deposit funds");
		System.out.println("[4] - View your balance");
		System.out.println("[5] - Close your account");
		System.out.print("Selection: ");
	
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Selection: ");
		String userInput= scan.next();
		//userInput= br.readLine(); 

		try {
			//userInput = br.readLine();

			switch(userInput) {
			case "1":
				System.out.println("Navigating to New User Menu...");
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
		}

	}
	

}
