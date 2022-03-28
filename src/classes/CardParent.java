package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class CardParent{
	
	private String name;
	private String cardNumber;
	private String CVV;
	private String expDate;
	private int pin;
	
	public CardParent(String name, int pin)
	{
		//Auto-generate card number, CVV, and expiration date
		this.name = name;
		this.pin = pin;
		this.cardNumber = generateCardNumber();
		this.CVV = generateCVV();
		this.expDate = generateExpDate();
	}	
	
	public String generateCardNumber()
	{
		Random rand = new Random();
		String cardNumber = "";
		
		int firstDigit = rand.nextInt(7 - 3) + 3;
		String firstDigitString = Integer.toString(firstDigit);
		cardNumber += firstDigitString;
		
		for(int i = 0; i < 15; i++)
		{
			int randomInt = rand.nextInt(10);
			String randomIntString = Integer.toString(randomInt);
			cardNumber += randomIntString;
		}
		
		return cardNumber;
	}
	
	public String generateCVV()
	{
		Random rand = new Random();
		String cardNumber = "";
		
		for(int i = 0; i < 3; i++)
		{
			int randomInt = rand.nextInt(10);
			String randomIntString = Integer.toString(randomInt);
			cardNumber += randomIntString;
		}
		
		return cardNumber;
	}
	
	public String generateExpDate()
	{
		LocalDate today = java.time.LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
		String formattedDateString = today.format(formatter);
		String date[] = formattedDateString.split("/");
		
		int currYear = Integer.parseInt(date[1]);  
		int expYear = currYear+2;
		
		String expYearString = Integer.toString(expYear);
		String expDate = date[0] + "/" + expYearString;
		
		return expDate;
	}
	
	public String getCardNumber()
	{
		return this.cardNumber;
	}
	
	public String getCardCVV()
	{
		return this.CVV;
	}
	
	public int getCardPin()
	{
		return this.pin;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getExpDate() 
	{
		return this.expDate;
	}
}

