package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineApp {
	
	public static void main(String[] args) {
		ManagementSystem system = new ManagementSystem(new FileHandler());
		CommandLineApp app = new CommandLineApp();
		app.displayFirstPage(system);
	}
	
	private void runUserAccountMenu(Account userAccount) {
		if(userAccount == null) return;
		String userInput = "";
		promptUserMenuOptions();
		userInput = getUserInfoString();
		while(!userInput.equals("QUIT")) {
			try{
				int choice = Integer.parseInt(userInput);
				userAccountMenu(userAccount, choice);
			}
			catch(NumberFormatException e) {
				System.out.println("Pick a valid menu option!");
			}
			
			promptUserMenuOptions();
			userInput = getUserInfoString();
		}
	}
	
	public void userAccountMenu(Account userAccount, int choice) {
		switch(choice) {
			case 0: System.out.println(userAccount.toString()); break;
			case 1: userAccount.makeDebitCard(); break;
			case 2: userAccount.makeCreditCard(); break;
			case 3: accessDebitCard(userAccount); break;
			case 4: accessCreditCard(userAccount); break;
			case 5: userAccount.editAccountDetail(); break;
		}
	}
	
	public void accessDebitCard(Account userAccount){
		System.out.println("Enter Debit Card Number: ");
		String cardNumberString = getUserInfoString();
		DebitCard retrievedDebitCard = userAccount.containsDebitCard(cardNumberString);
		if (retrievedDebitCard == null) return;
		
		System.out.println("Accessed Debit Card");
		String userInput = "";
		promptDebitCardOptions();
		userInput = getUserInfoString();
		
		while(!userInput.equals("QUIT")) {
			try{
				int choice = Integer.parseInt(userInput);
				accessDebitCardMenu(retrievedDebitCard, choice);
			}catch(NumberFormatException e) {
				System.out.println("Pick a valid menu option!");
			}
			promptDebitCardOptions();
			userInput = getUserInfoString();
		}
	}
	
	public void accessDebitCardMenu(DebitCard card, int choice) {
		switch(choice) {
			case 0: System.out.println("Card number = " + card.getCardNumber());
					System.out.println("Balance = " + card.getBalance()); break;
			case 1: System.out.println("Enter deposit amount: ");
					String depositAmount = getUserInfoString();
					card.deposit(Double.valueOf(depositAmount)); break;
			case 2: System.out.println("Enter withdraw amount: ");
					String withdrawAmount = getUserInfoString();
					card.withdraw(Double.valueOf(withdrawAmount)); break;
		}
	}
	
	public void accessCreditCard(Account userAccount)
	{
		System.out.println("Enter Credit Card Number: ");
		String cardNumberString = getUserInfoString();
		CreditCard retrievedCreditCard = userAccount.containsCreditCard(cardNumberString);
		if (retrievedCreditCard == null) return;
		
		System.out.println("Accessed Credit Card");
		String userInput = "";
		promptCreditCardOptions();
		userInput = getUserInfoString();
		
		while(!userInput.equals("QUIT")) {
			try{
				int choice = Integer.parseInt(userInput);
				accessCreditCardMenu(retrievedCreditCard, choice);
			}catch(NumberFormatException e) {
				System.out.println("Pick a valid menu option!");
			}
			promptCreditCardOptions();
			userInput = getUserInfoString();
		}
	}
	
	public void accessCreditCardMenu(CreditCard card, int choice) {
		switch(choice) {
		case 0: System.out.println("Card number = " + card.getCardNumber());
				System.out.println("Available Balance = " + card.getAvailableBalance());
				System.out.println("Current Balance = " + card.getCurrentBalance()); break;
		case 1: System.out.println("Amount to spend: ");
				String spendAmount = getUserInfoString();
				card.spend(Double.valueOf(spendAmount)); break;
		case 2: System.out.println("Amount to pay balance: ");
				String payAmount = getUserInfoString();
				card.payBill(Double.valueOf(payAmount)); break;
		}
	}
	
	public String askNewUserName() {
		String name = "";
		while(name.equals("")) {
			System.out.print("Enter your name: ");
			name = getUserInfoString();
		}
		return name;
	}
	
	public String askNewAddress() {
		String address = "";
		while(address.equals("")) {
			System.out.print("Enter your address: ");
			address = getUserInfoString();
		}
		return address;
	}
	
	public String askNewIncome() {
		String income = "";
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
		return income;
	}
	
	public String askNewUsername(ManagementSystem system) {
		String username = "";
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
		return username;
	}
	
	public String askNewPassword() {
		String password = "";
		while(password.equals("")) {
			System.out.print("Create new password: ");
			password = getUserInfoString();
		}	
		return password;
	}
	
	public Account createUser(ManagementSystem system) {
		String name = askNewUserName();
		String address = askNewAddress();
		String income = askNewIncome();
		String username = askNewUsername(system);
		String password = askNewPassword();
		
		System.out.print("Re-Enter your username: ");
		String reEnterUsername = getUserInfoString();
		System.out.print("Re-Enter your password: ");
		String reEnterPassword = getUserInfoString();
		
		if (!username.equals(reEnterUsername) || !password.equals(reEnterPassword)){
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
	
	public Account loginUser(ManagementSystem system) {
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
	
	public String getUserInfoString() {
		Scanner scanner = new Scanner(System.in);
		String infoString = scanner.nextLine();
		return infoString;
	}
	
	private void displayFirstPage(ManagementSystem system) {
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
	
	private void firstPageSelectionProcess(String userInput, ManagementSystem system) {
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

	private void promptUserMenuOptions() {
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
	
	private void promptDebitCardOptions() {
		System.out.println();
		System.out.println("Options:");
		System.out.println("0 - view debit card details");
		System.out.println("1 - deposit into debit card");
		System.out.println("2 - withdraw from debit card");
		System.out.println("QUIT - exit this menu");
		System.out.print(">>> ");
	}

	private void promptCreditCardOptions() {
		System.out.println();
		System.out.println("Options:");
		System.out.println("0 - view credit card details");
		System.out.println("1 - spend credit card");
		System.out.println("2 - pay credit card balance");
		System.out.println("QUIT - exit this menu");
		System.out.print(">>> ");
	}
	
	public void promptUserStartPage() {
		System.out.println();
		System.out.println("Welcome to the Card Management Service!");
		System.out.println("Enter Option Number and Hit Enter:");
		System.out.println("0 - login existing account");
		System.out.println("1 - create new account");
		System.out.print(">>> ");
	}
	
	public void promptUserForUsername() {
		System.out.print("Enter your username: ");
	}
	
	public void promptUserForPassword() {
		System.out.print("Enter your password: ");
	}

}
