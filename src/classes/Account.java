package classes;

import java.util.ArrayList;
import java.util.Scanner;

import classes.DebitCard;
import classes.CreditCard;


public class Account {
	
	private String username;
	private String password;
	private String legalName;
	private String streetAddress;
	private double grossIncome;
	private ArrayList<DebitCard> debitCards;
	private ArrayList<CreditCard> creditCards;
	
	
	public Account(String username, String password, String legalName, String streetAddress, double grossIncome) {
		this.username = username;
		this.password = password;
		this.legalName = legalName;
		this.streetAddress = streetAddress;
		this.grossIncome = grossIncome;
		this.debitCards = new ArrayList<>();
		this.creditCards = new ArrayList<>();
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getName() {
		return this.legalName;
	}
	
	public String getAddress() {
		return this.streetAddress;
	}
	
	public String getIncome() {
		return Integer.toString((int)this.grossIncome);
	}
	
	public int getHashedPassword() {
		return this.password.hashCode();
	}
	
	public String toString() {
		String output = "";
		output += "Name: " + this.legalName;
		output += "\nUsername: " + this.username;
		output += "\nAddress: " + this.streetAddress;
		output += "\nIncome: " + this.grossIncome;
		output += "\nDebit Cards: ";
		for(DebitCard card : this.debitCards) {
			output += "\n\t" + card.getCardNumber();
		}
		output += "\nCredit Cards: ";
		for(CreditCard card : this.creditCards) {
			output += "\n\t" + card.getCardNumber();
		}
		return output;
	}
	
	public boolean spend(CreditCard card, Transaction transaction) {
		if (card.getAvailableBalance() >= transaction.getPrice()) {
			card.spend(transaction.getPrice());
			return true;
		}
		return false;
	}
	
	public boolean spend(DebitCard card, Transaction transaction) {
		if (card.getBalance() >= transaction.getPrice()) {
			card.withdraw(transaction.getPrice());
			return true;
		}
		return false;
	}

	public void makeDebitCard(){
		int pin = 1234;
		DebitCard newDebitCard = new DebitCard(this.legalName, pin);
		this.debitCards.add(newDebitCard);
	}
	
	public void makeCreditCard(){
		int pin = 1234; 
		CreditCard newCreditCard = new CreditCard(this.legalName, pin, this.grossIncome);
		this.creditCards.add(newCreditCard);
	}
	
	public void addExistingDebitCard(DebitCard card) {
		this.debitCards.add(card);
	}
	
	public void addExistingCreditCard(CreditCard card) {
		this.creditCards.add(card);
	}
	
	public DebitCard containsDebitCard(String cardNumber)
	{	
		for(DebitCard card : this.debitCards)
		{
			if (card.getCardNumber().equals(cardNumber))
			{
				return card;
			}
		}
		
		return null;
	}
	
	public CreditCard containsCreditCard(String cardNumber)
	{	
		for(CreditCard card : this.creditCards){
			if (card.getCardNumber().equals(cardNumber)){
				return card;
			}
		}
		
		return null;
	}
	
	public void editAccountDetail() {
		System.out.println("Enter which detail you would like to edit:\n-username\n-password\n-income\n>>>");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		try {
			if (userInput.equals("password")) {
				System.out.println("Enter new password: ");
				this.password = scan.nextLine();
			} else if (userInput.equals("username")) {
				System.out.println("Enter new username: ");
				this.username = scan.nextLine();
			} else if (userInput.equals("income")) {
				System.out.println("Enter new income: ");
				this.grossIncome = Double.parseDouble(scan.nextLine());
			} else {
				System.out.println("Edit failed!");
				return;
			}
			
		} catch (java.util.InputMismatchException e){
			System.out.println("Error: invalid input!");
		}
		
		System.out.println("Edit successful");
	}
}