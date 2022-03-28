package classes;

import java.util.ArrayList;

public class Card {
	
	private String cardNumber;
	private double balance;
	private ArrayList<Transaction> transactionHistory;
	
	
	public Card() {
		this.cardNumber = "";
		this.balance = 0;
		this.transactionHistory = new ArrayList<Transaction>();
	}

	public String getCardNumber() {
		return this.cardNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
//	public boolean spend(Transaction transaction) {
//		double price = transaction.getPrice();
//		
//		if (price <= this.balance) {
//			this.balance -= price;
//			this.transactionHistory.add(transaction);
//			
//			return true;
//		} else {
//			return false;
//		}
//	}
	

}
