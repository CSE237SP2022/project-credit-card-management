package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {
	
	private ArrayList<Account> accounts;
	private int numAccounts;
	
	public ManagementSystem() {
		this.accounts = new ArrayList<Account>();
		this.numAccounts = 0;
	}

	public ManagementSystem(FileHandler fileHandler) {
		this.accounts = new ArrayList<Account>();
		this.numAccounts = 0;
		
		File accountsFile = fileHandler.getAccountsFile();
		File debitCardsFile = fileHandler.getCreditCardsFile();
		File creditCardsFile = fileHandler.getDebitCardsFile();
		
		try {
			Scanner fileScanner = new Scanner(accountsFile);
			createAccountsFromFile(fileScanner);
			fileScanner.close();
			
			fileScanner = new Scanner(debitCardsFile);
			createCardsFromFile(fileScanner);
			
			fileScanner = new Scanner(creditCardsFile);
			createCardsFromFile(fileScanner);
			
			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Account createAccount(String username, String password, String legalName, String streetAddress, int grossIncome) {
		Account account = new Account(username, password, legalName, streetAddress, grossIncome);
		accounts.add(account);
		this.numAccounts++;
		return account;
	}
	
	public void createAccountsFromFile(Scanner fileScanner) {
		String[] accountInformation = null;
		while(fileScanner.hasNextLine()) {
			 accountInformation = fileScanner.nextLine().split(";");
			 if(accountInformation != null && accountInformation.length == 5) {
					String username = accountInformation[0].replace(";", "");
					String password = accountInformation[1].replace(";", "");
					String legalName = accountInformation[2].replace(";", "");
					String streetAddress = accountInformation[3].replace(";", "");
					int grossIncome = Integer.parseInt(accountInformation[4]);
					Account account = this.createAccount(username, password, legalName, streetAddress, grossIncome);
			}
		}
	}
	
	public void createCardsFromFile(Scanner fileScanner) {
		String[] cardInformation = null;
		while(fileScanner.hasNextLine()) {
			 cardInformation = fileScanner.nextLine().split(";");
			 if(cardInformation == null) continue;
			 
			 Card card = null;
			 String username = cardInformation[0].replace(";", "");
			 int pin = Integer.parseInt(cardInformation[1]);
			 String cardNumber = cardInformation[2].replace(";", "");
			 String CVV = cardInformation[3].replace(";", "");
			 String expDate = cardInformation[4].replace(";", "");
			 
			 if(cardInformation.length == 5) {
				card = new DebitCard(username, pin, cardNumber, CVV, expDate);
			 }
			 else if(cardInformation.length == 6){
				Double limit = Double.parseDouble(cardInformation[5]);
				card = new CreditCard(username, pin, cardNumber, CVV, expDate, limit);
			 }
			 
			 this.addCardToAccount(username, card);

		}
	}
	
	public Account verifyUserCredentials(String username, String password) {
		if(this.numAccounts == 0) return null;
		
		for(Account account : this.accounts) {
			if(username.equals(account.getUsername()) && password.hashCode() == account.getHashedPassword()) {
				return account;
			}
		}
		
		return null;
	}
	
	public int getNumAccounts() {
		return numAccounts;
	}
	
	public Account getAccountFromUsername(String username) {
		for(Account account : this.accounts) {
			if(account.getUsername().equals(username)) {
				return account;
			}
		}
		return null;
	}

	public void addCardToAccount(String username, Card card) {
		if(card == null) return;
		Account account = getAccountFromUsername(username);
		if(account == null) return;
		if(card.isCreditCard()) {
			account.addExistingCreditCard((CreditCard) card);
		}
		else {
			account.addExistingDebitCard((DebitCard) card);
		}
	}

	
}