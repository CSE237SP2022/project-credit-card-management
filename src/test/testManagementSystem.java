package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Account;
import classes.ManagementSystem;
import classes.CommandLineApp;
import classes.FileHandler;


class testManagementSystem {
	
	private ManagementSystem emptySystem;
	private ManagementSystem existingSystem;
	
	@BeforeEach
	void setup() {
		emptySystem = new ManagementSystem();
		existingSystem = new ManagementSystem(new FileHandler());
	}

	@Test
	void testNumberOfAccountsEmptySystem() {		
		int numAccounts = emptySystem.getNumAccounts();
		
		assertEquals(0, numAccounts);
	}
	
	@Test
	void testNumAccountsWithExistingAccount() {
		Account dummyAccountOne = emptySystem.createAccount("","","","",1);
		int numAccountsBefore = emptySystem.getNumAccounts();
		Account dummyAccountTwo = emptySystem.createAccount("","","","",2);
		
		int numAccountsAfter = emptySystem.getNumAccounts();
		
		assertEquals(1, numAccountsAfter-numAccountsBefore);
	}
	
	@Test
	void testloginUserBadCredentials() {
		Account returnedAccount = emptySystem.verifyUserCredentials("6Ad", "cr3d3ntiaLs");
		assertEquals(null, returnedAccount);
	}
	
	@Test
	void testloginUserValidCredentials() {
		Account dummyAccount = emptySystem.createAccount("a", "b", "", "", 0);
		Account returnedAccount = emptySystem.verifyUserCredentials("a", "b");
		
		assertTrue(returnedAccount != null);
		assertEquals(dummyAccount.hashCode(), returnedAccount.hashCode());
	}
	
	@Test
	void testCreateAccountsFromFile(){
		int numAccounts = existingSystem.getNumAccounts();
		
		assertEquals(2, numAccounts);
		Account validAccount = existingSystem.verifyUserCredentials("username", "password12345");
		assertTrue(validAccount != null);
	}
	
	@Test
	void testCreateDebitCardsFromFile() {
		Account account = existingSystem.getAccountFromUsername("dwusername");
		assertFalse(account == null);
		assertFalse(account.containsDebitCard("4739170295563549") == null);
		assertFalse(account.containsDebitCard("4730000111224422") == null);
		assertTrue(account.containsDebitCard("0000") == null);

	}
	
	@Test
	void testCreateCreditCardsFromFile() {
		Account account = existingSystem.getAccountFromUsername("dwusername");
		assertFalse(account == null);
		assertFalse(account.containsCreditCard("6786141510068532") == null);
	}
	
}