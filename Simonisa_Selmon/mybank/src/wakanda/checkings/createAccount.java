package wakanda.checkings;

public class createAccount {

	public static void main(String[] args) {
		
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
				
				user = new User(firstName, lastName, username, password, email);
				System.out.println("Checking username availability...");
				
				if(usernameAvailable(user)) {
					System.out.println("Username available!");
					System.out.println("Creating new user, " + user.getUsername() + "...\n");
					serializeUser(user);
				} else {
					System.out.println("Username is not available. Please try again...");
					register();
				}
				
				
			} catch (IOException e) {
				System.out.println("[LOG] - Error while reading from console");
				e.printStackTrace();
			}
			
			
		}
		
		private static void serializeUser(User u) {
			
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
		
		private static boolean usernameAvailable(User u) {
			
			String fileName = u.getUsername() + ".ser";
			File file = new File(fileName);
			
			if(file.exists()) {
				return false;
			} else {
				return true;
			}
		}

	}

}
