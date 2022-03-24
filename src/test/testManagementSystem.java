package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Account;
import classes.ManagementSystem;


class testManagementSystem {
	
	private ManagementSystem system;
	
	@BeforeEach
	void setup() {
		system = new ManagementSystem();
	}

	@Test
	void testNumberOfAccountsEmptySystem() {		
		int numAccounts = system.getNumAccounts();
		
		assertEquals(0, numAccounts);
	}
	
	@Test
	void testNumAccountsWithExistingAccount() {
		Account dummyAccountOne = system.createAccount("","","","",1);
		int numAccountsBefore = system.getNumAccounts();
		Account dummyAccountTwo = system.createAccount("","","","",2);
		
		int numAccountsAfter = system.getNumAccounts();
		
		assertEquals(1, numAccountsAfter-numAccountsBefore);
	}
	
}