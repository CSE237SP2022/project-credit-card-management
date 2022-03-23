package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import client.Account;
import client.ManagementSystem;


class testManagementSystem {
	
	private ManagementSystem system;
	
	@BeforeEach
	void setup() {
		system = new ManagementSystem();
	}

	@Test
	void testNumberOfAccountsEmptySystem() {
		Account dummyAccount = system.createAccount();
		
		int numAccounts = system.getNumAccounts();
		
		assertEquals(1, numAccounts);
	}
	
	@Test
	void testNumAccountsWithExistingAccount() {
		Account dummyAccountOne = system.createAccount();
		int numAccountsBefore = system.getNumAccounts();
		Account dummyAccountTwo = system.createAccount();
		
		int numAccountsAfter = system.getNumAccounts();
		
		assertEquals(1, numAccountsAfter-numAccountsBefore);
	}
	
}