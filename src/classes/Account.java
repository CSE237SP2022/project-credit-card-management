package classes;

import java.util.ArrayList;
import classes.DebitCard;
import classes.CreditCard;


public class Account {
	
	private String username;
	private String password;
	private String legalName;
	private String streetAddress;
	private double grossIncome;
	//private ArrayList<Card> cards;
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
		card.spend(transaction.getPrice());
		return true;
	}
	
	public boolean spend(DebitCard card, Transaction transaction) {
		card.withdraw(transaction.getPrice());
		return true;
	}

	public void makeDebitCard()
	{
		int pin = 1234;
		DebitCard newDebitCard = new DebitCard(this.legalName, pin);
		this.debitCards.add(newDebitCard);
	}
	
	public void makeCreditCard()
	{
		int pin = 1234; 
		CreditCard newCreditCard = new CreditCard(this.legalName, pin, this.grossIncome);
		this.creditCards.add(newCreditCard);
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
		for(CreditCard card : this.creditCards)
		{
			if (card.getCardNumber().equals(cardNumber))
			{
				return card;
			}
		}
		
		return null;
	}

	
}