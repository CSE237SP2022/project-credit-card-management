package classes;

import java.util.ArrayList;

import classes.Card;

public class Account {
	
	private String username;
	private String password;
	private String legalName;
	private String streetAddress;
	private int grossIncome;
	private ArrayList<Card> cards;
	
	
	public Account(String username, String password, String legalName, String streetAddress, int grossIncome) {
		this.username = username;
		this.password = password;
		this.legalName = legalName;
		this.streetAddress = streetAddress;
		this.grossIncome = grossIncome;
		this.cards = new ArrayList<Card>();
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
		output += "\nCards: ";
		for(Card card : this.cards) {
			output += "\n\t" + card.getCardNumber();
		}
		return output;
	}
	
	public boolean spend(Card card) {
		return null;
	}

	

	
}