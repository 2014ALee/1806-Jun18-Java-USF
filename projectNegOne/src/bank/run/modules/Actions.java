package bank.run.modules;

public class Actions extends Validate{

	public static void deposit() {
		double deposit = 0;
		System.out.println("Deposit to Checking or Savings?");
		System.out.println("[1] Checking: $" + user.getChecking());
		System.out.println("[2] Savings: $" + user.getSavings());
		System.out.println("[3] Cancle");
		int read = 0;
		if(sc.hasNextInt()) {
			read = sc.nextInt();
		}else {
			System.out.println("Invalid input please try again...");
			sc.nextLine();
			deposit();
		}
		switch(read) {
			case 1:
			case 2:
				System.out.print("Enter Amount to Deposit: ");
				deposit = sc.nextDouble();
				if(read == 1) {
					user.setChecking(user.getChecking() + deposit);
					System.out.println("Deposited $" + deposit + " successfully.");
					System.out.println("New Balance: $" + user.getChecking());
				}else if (read == 2) {
					user.setSavings(user.getSavings() + deposit);
					System.out.println("Deposited $" + deposit + " successfully.");
					System.out.println("New Balance: $" + user.getSavings());
				}
			case 3:
				Menu.mainMenu(1);
			default: 
				System.out.println("Invalid selection, please try again.");
				deposit();
		}
	}

	public static void withdraw() {
		double withdraw = 0;
		System.out.println("Withdraw from Checking or Savings?");
		System.out.println("[1] Checking: $" + user.getChecking());
		System.out.println("[2] Savings: $" + user.getSavings());
		System.out.println("[3] Cancle");
		int read = 0;
		if(sc.hasNextInt()) {
			read = sc.nextInt();
		}else {
			System.out.println("Invalid input please try again...");
			sc.nextLine();
			withdraw();
		}
		switch(read) {
			case 1:
			case 2:
				System.out.print("Enter Amount to Withdraw: ");
				withdraw = sc.nextDouble();
				if(read == 1) {
					user.setChecking(user.getChecking() - withdraw);
					System.out.println("Withdrawen $" + withdraw + " successfully.");
					System.out.println("New Balance: $" + user.getChecking());
				}else if (read == 2){
					user.setSavings(user.getSavings() - withdraw);
					System.out.println("Withdrawen $" + withdraw + " successfully.");
					System.out.println("New Balance: $" + user.getSavings());
					if(user.getSavings() < 0)
						System.out.println("You have overdrafted for your convience we have issued a loan");
				}
			case 3:
				Menu.mainMenu(1);
				break;
			default: 
				System.out.println("Invalid selection, please try again.");
				withdraw();
		}
	}

	public static void balanceCheck () {
		System.out.println("Checking Balance: " + user.getChecking());
		System.out.println("Savings Balance: " + user.getSavings());
	}
}
