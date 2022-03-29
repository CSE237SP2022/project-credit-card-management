package test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;

import classes.Account;
import classes.Transaction;

public class testAccount {
	
	private Account emptyAccount;
	
	
	@BeforeEach
	void setup() {
		emptyAccount = new Account("", "", "", "", 0);
	}
	
	void testSpendCredit() {
		CreditCard creditCard = new CreditCard("credit", 1234, 20000);
		Transaction transactionBefore = new Transaction(0, "", "", "");
		
		Transaction transactionAfter = emptyAccount.spend(creditCard, transactionBefore);
		
		assertNotNull(transactionAfter);
	}
}
