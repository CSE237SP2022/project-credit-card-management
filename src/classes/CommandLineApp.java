package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineApp {
	
	public static void main(String[] args) {
		ManagementSystem system = new ManagementSystem(new FileHandler());
		displayFirstPage(system);
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
	
	public static Account createUser(ManagementSystem system) {
		String name = "";
		String address = "";
		String income = "";
		String username = "";
		String password = "";
		
		String reEnterUsername = "";
		String reEnterPassword = "";
		
		while(name.equals("")) {
			System.out.print("Enter your name: ");
			name = getUserInfoString();
		}
		
		while(address.equals("")) {
			System.out.print("Enter your address: ");
			address = getUserInfoString();
		}
		
		while(income.equals("")) {
			System.out.print("Enter your yearly income: ");
			income = getUserInfoString();
			
			try {
				int intValue = Integer.parseInt(income);
			} 
			catch (NumberFormatException e) {
				income="";
			    System.out.println("You did not enter a valid yearly income");
			    System.out.println();
			}
			
		}
		
		while(username.equals("")) {
			System.out.print("Create new username: ");
			username = getUserInfoString();
			
			ArrayList<String> allUsernames = system.getAllUsernames();
			for (int i = 0 ; i < allUsernames.size(); i++)
			{
				if (username.equals(allUsernames.get(i)))
				{
					username="";
				    System.out.println("Username has been taken");
				    System.out.println();
				}
			}
		}
		
		while(password.equals("")) {
			System.out.print("Create new password: ");
			password = getUserInfoString();
		}	
		
		System.out.print("Re-Enter your username: ");
		reEnterUsername = getUserInfoString();
		
		System.out.print("Re-Enter your password: ");
		reEnterPassword = getUserInfoString();
		
		if (!username.equals(reEnterUsername) || !password.equals(reEnterPassword))
		{
			System.out.println("You did not type in the correct username or password");
			displayFirstPage(system);
			return null;
		}
		
		else {
			int incomeInt = Integer.parseInt(income);  
			System.out.println("Account Successfully Created");
			return system.createAccount(username, password, name, address, incomeInt);
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
	
	private static void displayFirstPage(ManagementSystem system) {
		promptUserStartPage();
		String userInput = "";
		userInput = getUserInfoString();
		
		boolean validStartPageEntry = false;
		
		if (userInput.equals("0") || userInput.equals("1")) {
			validStartPageEntry =true; 
			firstPageSelectionProcess(userInput, system);
		}
		
		else {
			while(!validStartPageEntry) {
				firstPageSelectionProcess(userInput, system);
				
				promptUserStartPage();
				userInput = getUserInfoString();
				
				if (userInput.equals("0") || userInput.equals("1")) {
					validStartPageEntry =true; 
					firstPageSelectionProcess(userInput, system);
				}
			}
		}
		
	}
	
	private static void firstPageSelectionProcess(String userInput, ManagementSystem system) {
		try{
			int choice = Integer.parseInt(userInput);
			if(choice == 0) {
				runUserAccountMenu(loginUser(system));
			}
			else if(choice == 1) {
				createUser(system);
				displayFirstPage(system);
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Pick a valid menu option!");
		}
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
	
	public static void promptUserStartPage() {
		System.out.println();
		System.out.println("Welcome to the Card Management Service!");
		System.out.println("Enter Option Number and Hit Enter:");
		System.out.println("0 - login existing account");
		System.out.println("1 - create new account");
		System.out.print(">>> ");
	}
	
	public static void promptUserForUsername() {
		System.out.print("Enter your username: ");
	}
	
	public static void promptUserForPassword() {
		System.out.print("Enter your password: ");
	}

}
