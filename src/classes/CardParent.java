package classes;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class CardParent{
	
	private String name;
	private int cardNumber;
	private int CVV;
	private String expDate;
	private int pin;
	
	
	public CardParent(String name, int pin)
	{
		//Auto-generate card number, CVV, and expiration date
		this.name = name;
		this.pin = pin;
		System.out.println(java.time.LocalDate.now());
	}	
}

