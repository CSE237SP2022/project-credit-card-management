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

	public ManagementSystem(String accountsFileName) {
		this.accounts = new ArrayList<Account>();
		this.numAccounts = 0;
		
		String filePath = "systemFiles/"+accountsFileName;
		File accountsFile = new File(filePath);
		
		try {
			Scanner fileScanner = new Scanner(accountsFile);
			createAccountsFromFile(fileScanner);
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

	public ArrayList<Card> getCardsFromFile(String fileName) {
		ArrayList<Card> cards = new ArrayList<Card>();
		String path = "systemFiles/" + fileName;
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		scan.nextLine();
		
		while (scan.hasNextLine()) {
			String[] cardInfo = scan.nextLine().split(";");
			cards.add(createCardFromInfo(cardInfo));
		}
		
		scan.close();
		return cards;
	}
	
	private Card createCardFromInfo(String[] cardInfo) {
		String name = cardInfo[1].replace(";", "");
		int pin = Integer.parseInt(cardInfo[2].replace(";", ""));
		String cardNumber = cardInfo[3].replace(";", "");
		String cvv = cardInfo[4].replace(";", "");
		
		if (cardInfo[0].replace(";", "") == "debit") {
			DebitCard card = new DebitCard(name, pin);
			card.setCardNumber(cardNumber);
			card.setCardCVV(cvv);
			
			return card;
			
		} else if (cardInfo[0].replace(";", "") == "debit") {
			double income = Double.parseDouble(cardInfo[5].replace(";",""));
			CreditCard card = new CreditCard(name, pin, income);
			card.setCardNumber(cardNumber);
			card.setCardCVV(cvv);
			
			return card;
		}
		
		return null;
	}
	
}