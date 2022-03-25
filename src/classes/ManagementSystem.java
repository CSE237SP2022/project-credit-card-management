package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {
	
	private ArrayList<Account> accounts;
	private int numAccounts;
	
	public ManagementSystem() {
		this.accounts = new ArrayList<Account>();
		this.numAccounts = 0;
	}

	public ManagementSystem(String accountsFile) {
		// TODO Auto-generated constructor stub
	}

	public Account createAccount(String username, String password, String legalName, String streetAddress, int grossIncome) {
		Account account = new Account(username, password, legalName, streetAddress, grossIncome);
		accounts.add(account);
		this.numAccounts++;
		return account;
	}
	
	public Account verifyUserCredentials(String username, String password) {
		if(this.numAccounts == 0) return null;
		
		for(Account account : this.accounts) {
			if(username == account.getUsername() && password.hashCode() == account.getHashedPassword()) {
				return account;
			}
		}
		
		return null;
	}
	
	public int getNumAccounts() {
		return numAccounts;
	}


	
}