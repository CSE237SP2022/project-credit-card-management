package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import classes.Account;
import classes.CreditCard;
import classes.Transaction;

public class testAccount {
	
	private Account emptyAccount;
	private Account account;
	
	
	@BeforeEach
	void setup() {
		emptyAccount = new Account("", "", "", "", 0);
		account = new Account("dummy", "password", "John Smith", "1 Brookings Dr.", 100000);
	}
	
	void testSpendCreditNoCostNoLimit() {
		CreditCard creditCard = new CreditCard("creditNoLimit", 1234, 0);
		Transaction transaction = new Transaction(0, "", "", "");
		double balanceBefore = creditCard.getAvailableBalance();
		
		boolean success = emptyAccount.spend(creditCard, transaction);
		double balanceAfter = creditCard.getAvailableBalance();
		
		assertTrue(success);
		assertEquals(balanceBefore, balanceAfter, 0.001);
	}
	
	void testSpendCreditSmallCost() {
		CreditCard creditCard = new CreditCard("creditWithLimit", 1234, 10000);
		Transaction lunch = new Transaction(10, "BD", "Nooon", "Clayton, MO");
		
		double balanceBefore = creditCard.getAvailableBalance();
		
		boolean success = account.spend(creditCard, lunch);
		double balanceAfter = creditCard.getAvailableBalance();
		
		assertTrue(success);
		assertEquals(10, balanceBefore-balanceAfter, 0.001);
	}
	
	void testSpendCreditOverBalance() {
		CreditCard creditCard = new CreditCard("creditWithLowLimit", 1234, 1);
		Transaction car = new Transaction(20000, "Ford", "", "NYC");
		
		double balanceBefore = creditCard.getAvailableBalance();
		
		boolean success = account.spend(creditCard, car);
		double balanceAfter = creditCard.getAvailableBalance();
		
		assertTrue(!success);
		assertEquals(balanceBefore, balanceAfter, 0.001);
	}
}
