package com.revature;

public class PracticeSet1 {

	public static void main(String[] args) {
		String name = "Andrew, balance=1000000.0]";
		BankAccount ba = new BankAccount(name);
		System.out.println("Bank account before storage is " + ba);
		String saveToFile = ba.toString();
		BankAccount ba2 = BankAccount.parse(saveToFile);
		System.out.println("Bank account after storing to file and retrieving it is " + ba2);
		
	}
	
	public static class BankAccount {
		private String name;
		private double balance;
		
		public BankAccount(String name) {
			this.name = name;
			this.balance = 0;
		}
		public BankAccount(String name, double balance) {
			this.name = name;
			this.balance = balance;
		}
		public String getName() {
			return name;
		}
		public double getBalance() {
			return balance;
		}
		@Override
		public String toString() {
			return "BankAccount [name=" + name + ", balance=" + balance + "]";
		}
		public static BankAccount parse(String str) {
			String nm = str.substring(str.indexOf("[name=") + 6, str.length());
			nm = nm.substring(0, nm.indexOf(","));
			String balance = str.substring(str.indexOf("balance=") + 8, str.length());
			balance = balance.substring(0, balance.indexOf("]"));
			return new BankAccount(nm, Double.parseDouble(balance));
		}
	}

}
