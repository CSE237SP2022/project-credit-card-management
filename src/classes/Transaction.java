package classes;

import java.util.ArrayList;

public class Transaction {
	
	/* Should the Account have a method that executes a transaction by 
	 * passing a Transaction, or vice versa? If the former, a Transaction is
	 * basically a struct
	 */
	
	
	private double price;
	private String merchant;
	private String time;
	private String location;
	
	
	public Transaction(double p, String m, String t, String l) {
		this.price = p;
		this.merchant = m;
		this.time = t;
		this.location = l;
	}
	
	
}
