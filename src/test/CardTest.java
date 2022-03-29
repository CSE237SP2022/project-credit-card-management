package test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Card;

class CardTest {
	
	private Card card;
	

	@BeforeEach
	void setup() {
		String name = "George Washington";
		int pin = 1234;
		card = new Card(name, pin);
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
			String lastName = nameList[1];
			
			boolean isFirstNameCapitalized = false;
			boolean isLastNameCapitalized = false;
			
			if (Character.isUpperCase(firstName.charAt(0)))
			{
				isFirstNameCapitalized = true;
			}
			
			if (Character.isUpperCase(lastName.charAt(0)))
			{
				isLastNameCapitalized = true;
			}
			
			assertEquals(true, isFirstNameCapitalized);
			assertEquals(true, isLastNameCapitalized);
		}
		
		else if (intNameSize == 3)
		{
			String firstName = nameList[0];
			String middleName = nameList[1];
			String lastName = nameList[2];
			
			boolean isFirstNameCapitalized = false;
			boolean isMiddleNameCapitalized = false;
			boolean isLastNameCapitalized = false;
			
			if (Character.isUpperCase(firstName.charAt(0)))
			{
				isFirstNameCapitalized = true;
			}
			
			if (Character.isUpperCase(middleName.charAt(0)))
			{
				isMiddleNameCapitalized = true;
			}
			
			if (Character.isUpperCase(lastName.charAt(0)))
			{
				isLastNameCapitalized = true;
			}
			
			assertEquals(true, isFirstNameCapitalized);
			assertEquals(true, isMiddleNameCapitalized);
			assertEquals(true, isLastNameCapitalized);
		}
	}
	
	@Test
	void testHasValidExpirationDate()
	{
		//2022-03-27
		
		String date = this.card.getExpDate();
		
		String dateList[] = date.split("-");
		
		String year = dateList[0];
		String month = dateList[1];
		String day = dateList[2];
		
		int yearDigits = year.length();
		int monthDigits = month.length();
		int dayDigits = day.length();
		
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);
		int dayInt = Integer.parseInt(day);
		
		boolean isMonthValid = false;
		boolean isDayValid = false;
		
		if (monthInt>0 && monthInt<13)
		{
			isMonthValid = true;
		}
		
		if (dayInt>0 && dayInt<32)
		{
			isDayValid = true;
		}
		
		assertEquals(true, isMonthValid);
		assertEquals(true, isDayValid);
		
		assertEquals(4, yearDigits);
		assertEquals(2, monthDigits);
		assertEquals(2, dayDigits);
	}

}
