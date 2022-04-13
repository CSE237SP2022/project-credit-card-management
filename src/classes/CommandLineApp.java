package classes;

import java.util.Scanner;

public class CommandLineApp {
	
	public static void main(String[] args) {
		final String accountsFile = "accounts.txt";
		final String debitCardsFile = "debitCards.txt";
		final String creditCardsFile = "creditCards.txt";
		ManagementSystem system = new ManagementSystem(accountsFile, debitCardsFile, creditCardsFile);
		runUserAccountMenu(loginUser(system));
	}
	
	private static void runUserAccountMenu(Account userAccount) {
		if(userAccount == null) return;
		String userInput = "";
		promptUserMenuOptions();
		userInput = getUserInfoString();
		while(!userInput.equals("QUIT")) {
			try{
				int choice = Integer.parseInt(userInput);
				if(choice == 0) {
					System.out.println(userAccount.toString());
				}
				else if(choice == 1) {
					userAccount.makeDebitCard();
					
				}
				
				else if(choice == 2) {
					userAccount.makeCreditCard();
				}
				
				else if(choice == 3) {
					accessDebitCard(userAccount);
				}
				
				else if(choice == 4) {
					accessCreditCard(userAccount);
				}
				
				else if (choice == 5) {
					userAccount.editAccountDetail();
				}
				
			}
			catch(NumberFormatException e) {
				System.out.println("Pick a valid menu option!");
			}
			
			promptUserMenuOptions();
			userInput = getUserInfoString();
		}
	}
	
	public static void accessDebitCard(Account userAccount)
	{
		System.out.println("Enter Debit Card Number: ");
		String cardNumberString = getUserInfoString();
		DebitCard retriveDebitCard = userAccount.containsDebitCard(cardNumberString);
		if (retriveDebitCard!=null)
		{
			System.out.println("Accessed Debit Card");
			String userInput = "";
			promptDebitCardOptions();
			userInput = getUserInfoString();
			
			while(!userInput.equals("QUIT")) 
			{
				try
				{
					int choice = Integer.parseInt(userInput);
					if(choice == 0) 
					{
						System.out.println("Card number = " + retriveDebitCard.getCardNumber());
						System.out.println("Balance = " + retriveDebitCard.getBalance());
					}
					else if(choice == 1) 
					{
						System.out.println("Enter deposit amount: ");
						String depositAmount = getUserInfoString();
						retriveDebitCard.deposit(Double.valueOf(depositAmount));
					}
					
					else if(choice == 2) 
					{
						System.out.println("Enter withdraw amount: ");
						String withdrawAmount = getUserInfoString();
						retriveDebitCard.withdraw(Double.valueOf(withdrawAmount));
					}
				}
				catch(NumberFormatException e) 
				{
					System.out.println("Pick a valid menu option!");
				}
				promptDebitCardOptions();
				userInput = getUserInfoString();
			}
		}
	}
	
	public static void accessCreditCard(Account userAccount)
	{
		System.out.println("Enter Credit Card Number: ");
		String cardNumberString = getUserInfoString();
		CreditCard retriveCreditCard = userAccount.containsCreditCard(cardNumberString);
		if (retriveCreditCard!=null)
		{
			System.out.println("Accessed Credit Card");
			String userInput = "";
			promptCreditCardOptions();
			userInput = getUserInfoString();
			
			while(!userInput.equals("QUIT")) 
			{
				try
				{
					int choice = Integer.parseInt(userInput);
					if(choice == 0) 
					{
						System.out.println("Card number = " + retriveCreditCard.getCardNumber());
						System.out.println("Available Balance = " + retriveCreditCard.getAvailableBalance());
						System.out.println("Current Balance = " + retriveCreditCard.getCurrentBalance());
					}
					else if(choice == 1) 
					{
						System.out.println("Amount to spend: ");
						String spendAmount = getUserInfoString();
						retriveCreditCard.spend(Double.valueOf(spendAmount));
					}
					
					else if(choice == 2) 
					{
						System.out.println("Amount to pay balance: ");
						String payAmount = getUserInfoString();
						retriveCreditCard.payBill(Double.valueOf(payAmount));
					}
				}
				catch(NumberFormatException e) 
				{
					System.out.println("Pick a valid menu option!");
				}
				promptCreditCardOptions();
				userInput = getUserInfoString();
			}
		}
	}
	
	public static Account loginUser(ManagementSystem system) {
		String username = "";
		String password = "";
		while(username.equals("")) {
			promptUserForUsername();
			username = getUserInfoString();
		}
		while(password.equals("")) {
			promptUserForPassword();
			password = getUserInfoString();
		}	
		
		return system.verifyUserCredentials(username, password);
	}
	
	public static String getUserInfoString() {
		Scanner scanner = new Scanner(System.in);
		String infoString = scanner.nextLine();
		return infoString;
	}

	private static void promptUserMenuOptions() {
		System.out.println();
		System.out.println("Options:");
		System.out.println("0 - view account details");
		System.out.println("1 - make debit card");
		System.out.println("2 - make credit card");
		System.out.println("3 - access debit card");
		System.out.println("4 - access credit card");
		System.out.println("5 - edit account details");
		System.out.println("QUIT - exit this menu");
		System.out.print(">>> ");
	}
	
	private static void promptDebitCardOptions() {
		System.out.println();
		System.out.println("Options:");
		System.out.println("0 - view debit card details");
		System.out.println("1 - deposit into debit card");
		System.out.println("2 - withdraw from debit card");
		System.out.println("QUIT - exit this menu");
		System.out.print(">>> ");
	}

	private static void promptCreditCardOptions() {
		System.out.println();
		System.out.println("Options:");
		System.out.println("0 - view credit card details");
		System.out.println("1 - spend credit card");
		System.out.println("2 - pay credit card balance");
		System.out.println("QUIT - exit this menu");
		System.out.print(">>> ");
	}
	
	public static void promptUserForUsername() {
		System.out.print("Enter your username: ");
	}
	
	public static void promptUserForPassword() {
		System.out.print("Enter your password: ");
	}

}
