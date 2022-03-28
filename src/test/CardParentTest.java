package test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.CardParent;



class CardParentTest {
	
	private CardParent card;

	@BeforeEach
	void setup() {
		String name = "George Washington";
		int pin = 1234;
		card = new CardParent(name, pin);
	}
	
	@Test
	void testHasValidCardNumber() 
	{
		//Must be certain length: 16 digits
		//Card Cannot start with the number 0
		
		int cardNumber = this.card.getCardNumber();
		String cardNumberString = String.valueOf(cardNumber);
		int cardNumberDigits = cardNumberString.length();
		
		char firstDigit = cardNumberString.charAt(0);
		
		assertEquals(16, cardNumberDigits);
		assertNotEquals("0", firstDigit);
	}
	
	@Test
	void testHasValidCVVCode()
	{
		//Must be certain length: 3 digits
		
		int cvvCode = this.card.getCardCVV();
		String cardCVVString = String.valueOf(cvvCode);
		int cvvCodeDigits = cardCVVString.length();
		
		assertEquals(3, cvvCodeDigits);
	}
	
	@Test
	void testHasValidPinNumber()
	{
		int pin = this.card.getCardPin();
		String cardPinString = String.valueOf(pin);
		int pinDigits = cardPinString.length();
		
		assertEquals(3, pinDigits);
	}
	
	@Test
	void testHasValidName()
	{
		String name = this.card.getName();
		
		String nameList[] = name.split(" ");
		int intNameSize = nameList.length;
		
		if (intNameSize == 2)
		{
			String firstName = nameList[0];
			String LastName = nameList[1];
			
			boolean isFirstNameCapitalized = false;
			boolean isLastNameCapitalized = false;
			
			if (Character.isUpperCase(firstName.charAt(0)))
			{
				
			}
			

		}
		
	}
	
	@Test
	void testHasValidExpirationDate()
	{
		
	}

}
