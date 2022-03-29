package classes;

public class DebitCard extends CardParent
{
	private double balance;
	
	public DebitCard(String name, int pin)
	{
		super(name, pin);
		this.balance = 0;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void deposit(double depositAmount)
	{
		String depositString = Double.toString(depositAmount);
		String depositValueList[] = depositString.split("\\.");
		
		if (depositValueList.length > 1)
		{
			String cents = depositValueList[1];
			
			if (cents.length() > 2)
			{
				System.out.println("Deposit a valid amount");
				return;
			}
			
			else
			{
				this.balance += depositAmount;
			}
		}
		
		else if (depositValueList.length == 1)
		{
			this.balance += depositAmount;
		}
	}
	
	public void withdraw(double withdrawAmount)
	{
		String withdrawString = Double.toString(withdrawAmount);
		String withdrawValueList[] = withdrawString.split("\\.");
		
		if (withdrawValueList.length > 1)
		{
			String cents = withdrawValueList[1];
			
			if (cents.length() > 2)
			{
				System.out.println("Withdraw a valid amount");
				return;
			}
			
			else
			{
				this.balance -= withdrawAmount;
			}
		}
		
		else if (withdrawValueList.length == 1)
		{
			this.balance -= withdrawAmount;
		}
	}
}
