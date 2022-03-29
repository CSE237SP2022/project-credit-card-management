package classes;

public class CreditCard extends CardParent
{
	private double currentBalance;//Amount spent
	private double availableBalance;//Amount available
	private double creditLimit;
	
	public CreditCard(String name, int pin, double annualIncome)
	{
		super(name, pin);
		this.currentBalance = 0;
		this.creditLimit = 0.1 * annualIncome;
		this.availableBalance = this.creditLimit;
	}
	
	public double getCurrentBalance()
	{
		return this.currentBalance;
	}
	
	public double getAvailableBalance()
	{
		return this.availableBalance;
	}
	
	public double getCreditLimit()
	{
		return this.creditLimit;
	}
	
	public void spend(double amountSpent)
	{
		if (this.availableBalance >= amountSpent)
		{
			String amountSpentString = Double.toString(amountSpent);
			String amountSpentValueList[] = amountSpentString.split("\\.");
			
			if (amountSpentValueList.length > 1)
			{
				String cents = amountSpentValueList[1];
				
				if (cents.length() > 2)
				{
					System.out.println("Spend a valid amount");
					return;
				}
				
				else
				{
					this.availableBalance -= amountSpent;
					this.currentBalance += amountSpent;
				}
			}
			
			else if (amountSpentValueList.length == 1)
			{
				this.availableBalance -= amountSpent;
				this.currentBalance += amountSpent;
			}
		}
		
		else
		{
			System.out.println("Insufficient Funds");
			return;
		}
	}
	
}