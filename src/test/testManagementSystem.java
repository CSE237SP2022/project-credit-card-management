package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Account;
import classes.Card;
import classes.ManagementSystem;
import classes.CommandLineApp;
import classes.CreditCard;
import classes.DebitCard;


class testManagementSystem {
	
	private ManagementSystem emptySystem;
	private ManagementSystem existingSystem;
	
	@BeforeEach
	void setup() {
		emptySystem = new ManagementSystem();
		existingSystem = new ManagementSystem("test.txt");
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
	void testGetCardFromFileDebit() {		
		String fileName = "testDebitCard.txt";
		Card card = existingSystem.getCardsFromFile(fileName).get(0);
		
		
		
		assertEquals("testDebit", card.getName());
		assertEquals(1234, card.getCardPin());
		assertEquals("4000000000000000", card.getCardNumber());
		
	}
	
	@Test
	void testGetCardFromFileCredit() {
		String fileName = "testCreditCard.txt";		
		Card card = existingSystem.getCardsFromFile(fileName).get(0);
		
		assertEquals("testCredit", card.getName());
		assertEquals(5678, card.getCardPin());
		assertEquals("3000000000000000", card.getCardPin());
		assertEquals(1000, ((CreditCard) card).getAvailableBalance());
	}
	
	
	@Test
	void testLoadCardIntoFile() {
		
	}
	
	
	
}