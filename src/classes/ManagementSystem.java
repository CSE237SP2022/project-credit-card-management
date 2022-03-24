package client;

import java.util.ArrayList;

public class ManagementSystem {
	
	private ArrayList<Account> accounts;
	private int numAccounts;
	
	public ManagementSystem() {
		this.accounts = new ArrayList<Account>();
		this.numAccounts = 0;
	}

	public Account createAccount() {
		Account account = new Account();
		accounts.add(account);
		this.numAccounts++;
		return account;
	}
	
	public int getNumAccounts() {
		return numAccounts;
	}
	

	
}