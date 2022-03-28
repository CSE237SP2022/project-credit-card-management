package classes;

public class DebitCard extends CardParent
{
	private double balance;
	
	
	public DebitCard(String name, int pin)
	{
		super(name, pin);
		this.balance = 0;
	}
	
	
	
}
