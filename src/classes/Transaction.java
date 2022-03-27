package classes;

import java.util.ArrayList;

public class Transaction {
	
	
	
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
	
	public double getPrice() {
		return this.price;
	}
	
	public String getMerchant() {
		return this.merchant;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public String getLocation() {
		return this.location;
	}
}
