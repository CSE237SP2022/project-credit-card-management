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

	

	
}