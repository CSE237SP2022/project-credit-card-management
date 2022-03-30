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
	void testDepositDecimalCorrectAmount()
	{
		double depositAmount = 14.50;
		debitCard.deposit(depositAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(depositAmount, balance);
	}
	
	@Test
	void testDepositDecimalIncorrectAmount()
	{
		double depositAmount = 14.555;
		debitCard.deposit(depositAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(0, balance);
	}
	
	@Test
	void testDepositNoDecimalAmount()
	{
		double depositAmount = 14;
		debitCard.deposit(depositAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(14, balance);
	}
	
	@Test
	void testWithdrawDecimalCorrectAmount()
	{
		double depositAmount = 14.50;
		double withdrawAmount = 4.75; 
		debitCard.deposit(depositAmount);
		debitCard.withdraw(withdrawAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(depositAmount-withdrawAmount, balance);
	}
	
	@Test
	void testWithdrawDecimalIncorrectAmount()
	{
		double depositAmount = 14.50;
		double withdrawAmount = 4.7557; 
		debitCard.deposit(depositAmount);
		debitCard.withdraw(withdrawAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(depositAmount, balance);
	}
	
	@Test
	void testWithdrawNoDecimalAmount()
	{
		double depositAmount = 14.50;
		double withdrawAmount = 4; 
		debitCard.deposit(depositAmount);
		debitCard.withdraw(withdrawAmount);
		
		double balance = debitCard.getBalance();
		assertEquals(depositAmount-withdrawAmount, balance);
	}
}
