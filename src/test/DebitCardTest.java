package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import classes.DebitCard;

class DebitCardTest {

	private DebitCard debitCard;
	
	@BeforeEach
	void setup() {
		String name = "George Washington";
		int pin = 1234;
		debitCard = new DebitCard(name, pin);
	}
	
	@Test
	void testInitializedDebitCardHasZeroBalance() 
	{	
		double balance = debitCard.getBalance();
		assertEquals(0.0, balance);
	}
	
	
	@Test
	void testDeposit()
	{
		double depositAmount = 14.50;
		debitCard.deposit(depositAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(depositAmount, balance);
	}
	
	@Test
	void testWithdraw()
	{
		double depositAmount = 14.50;
		double withdrawAmount = 4.75; 
		debitCard.deposit(depositAmount);
		debitCard.withdraw(withdrawAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(depositAmount-withdrawAmount, balance);
	}
	
	

}
