package classes;

import java.time.LocalDate;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class CardParent{
	
	private String name;
	private Integer[] cardNumber;
	private Integer[] CVV;
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
		
		System.out.println(java.time.LocalDate.now());
		
	}	
	
	public Integer[] generateCardNumber()
	{
		Random rand = new Random();
		
		ArrayList<Integer> cardNumberList  = new ArrayList<Integer>();
		
		int firstDigit = rand.nextInt(7 - 3) + 3;
		cardNumberList.add(firstDigit);
		
		for(int i = 0; i < 15; i++)
		{
			int randomInt = rand.nextInt(10);
			cardNumberList.add(randomInt);
		}
		
		Integer[] cardNumberArray = cardNumberList.toArray(new Integer[0]);
		
		return cardNumberArray;
	}
	
	public Integer[] generateCVV()
	{
		Random rand = new Random();
		ArrayList<Integer> cvvNumberList  = new ArrayList<Integer>();
		
		for(int i = 0; i < 3; i++)
		{
			int randomInt = rand.nextInt(10);
			cvvNumberList.add(randomInt);
		}
		
		Integer[] cvvNumberArray = cvvNumberList.toArray(new Integer[0]);
		
		return cvvNumberArray;
	}
	
	public String generateExpDate()
	{
		LocalDate today = java.time.LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String formattedString = today.format(formatter);

		return formattedString;
	}
	
}

