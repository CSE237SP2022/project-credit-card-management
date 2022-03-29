package test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.CreditCard;

class CreditCardTest {
	
	private CreditCard creditCard;
	
	@BeforeEach
	void setup() {
		String name = "George Washington";
		int pin = 1234;
		double annualIncome = 65000.00;
		creditCard = new CreditCard(name, pin, annualIncome);
	}
	
	@Test
	void testBalancesAddUpInitial() 
	{	
		double currentBalance = this.creditCard.getCurrentBalance();
		double avaliableBalance = this.creditCard.getAvailableBalance();
		double creditLimit = this.creditCard.getCreditLimit();
		double sum = currentBalance + avaliableBalance;
		
		assertEquals(creditLimit, sum);
	}
	
	@Test
	void testBalancesAddUpSpend() 
	{	
		this.creditCard.spend(14.99);
		
		double currentBalance = this.creditCard.getCurrentBalance();
		double avaliableBalance = this.creditCard.getAvailableBalance();
		double creditLimit = this.creditCard.getCreditLimit();
		double sum = currentBalance + avaliableBalance;
		
		assertEquals(creditLimit, sum);
	}

	@Test
	void testSpendValidDouble() 
	{	
		double spendAmount = 14.99;
		this.creditCard.spend(spendAmount);
		
		double currentBalance = this.creditCard.getCurrentBalance();
		
		assertEquals(spendAmount, currentBalance);
	}
	
	@Test
	void testSpendInvalidDouble() 
	{	
		this.creditCard.spend(16.567);
		
		double avaliableBalance = this.creditCard.getAvailableBalance();
		double creditLimit = this.creditCard.getCreditLimit();
		
		assertEquals(creditLimit, avaliableBalance);
	}
	
	@Test
	void testOverspend() 
	{	
		this.creditCard.spend(2000.00);
		this.creditCard.spend(2000.00);
		this.creditCard.spend(2000.00);
		this.creditCard.spend(2000.00);
		
		double currentBalance = this.creditCard.getCurrentBalance();
		double avaliableBalance = this.creditCard.getAvailableBalance();
		
		assertEquals(6000, currentBalance);
		assertEquals(500, avaliableBalance);
	}
	
	@Test
	void testPayBillValidAmount() 
	{	
		double amountSpent = 2500.00;
		double amountPayed = 475.50;
		this.creditCard.spend(amountSpent);
		this.creditCard.payBill(amountPayed);
		
		double currentBalance = this.creditCard.getCurrentBalance();
		double avaliableBalance = this.creditCard.getAvailableBalance();
		double creditLimit = this.creditCard.getCreditLimit();
		
		assertEquals(amountSpent-amountPayed, currentBalance);
		assertEquals(creditLimit-amountSpent+amountPayed, avaliableBalance);
	}
	
	@Test
	void testPayBillInvalidAmountExcedeBalance() 
	{	
		double amountSpent = 450.00;
		double amountPayed = 475.50;
		this.creditCard.spend(amountSpent);
		this.creditCard.payBill(amountPayed);
		
		double currentBalance = this.creditCard.getCurrentBalance();
		double avaliableBalance = this.creditCard.getAvailableBalance();
		double creditLimit = this.creditCard.getCreditLimit();
		
		assertEquals(amountSpent, currentBalance);
		assertEquals(creditLimit-amountSpent, avaliableBalance);
	}
	
	@Test
	void testPayBillInvalidAmountDecimalError() 
	{	
		double amountSpent = 450.00;
		double amountPayed = 250.666;
		this.creditCard.spend(amountSpent);
		this.creditCard.payBill(amountPayed);
		
		double currentBalance = this.creditCard.getCurrentBalance();
		double avaliableBalance = this.creditCard.getAvailableBalance();
		double creditLimit = this.creditCard.getCreditLimit();
		
		assertEquals(amountSpent, currentBalance);
		assertEquals(creditLimit-amountSpent, avaliableBalance);
	}
	
}
