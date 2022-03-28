package classes;

import java.util.ArrayList;

public class Transaction {
	
	
	
	private double price;
	private String merchant;
	private String time;
	private String location;
	
	
	public Transaction(double price, String merchant, String time, String location) {
		this.price = price;
		this.merchant = merchant;
		this.time = time;
		this.location = location;
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
	
	public String toString() {
		String output = "";
		output += "Merchant: " + this.merchant;
		output += "\nPrice: " + this.price;
		output += "\nTime: " + this.time;
		output += "\nLocation: " + this.location;
		
		return output;
	}
}
