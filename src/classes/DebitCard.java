package classes;

public class DebitCard extends Card
{
	private double balance;
	
	public DebitCard(String name, int pin){
		super(name, pin);
		this.balance = 0;
		this.setIsCreditCard(false);
	}
	
	public DebitCard(String name, int pin, String cardNumber, String CVV, String expDate) {
		super(name, pin, cardNumber, CVV, expDate);
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public void deposit(double depositAmount)
	{
		String depositString = Double.toString(depositAmount);
		String depositValueList[] = depositString.split("\\.");
	
		if (validateAmount(depositValueList)) {
			this.balance += depositAmount;
		} else {
			System.out.println("Deposit a valid amount");
			return;
		}
	}
	
	public void withdraw(double withdrawAmount)
	{
		String withdrawString = Double.toString(withdrawAmount);
		String withdrawValueList[] = withdrawString.split("\\.");
		
		if (validateAmount(withdrawValueList)) {
			this.balance -= withdrawAmount;
		} else {
			System.out.println("Withdraw a valid amount");
			return;
		}

	}
	
	private boolean validateAmount(String[] amount) {
		if (amount.length > 1 && amount[1].length() > 2) {
			return false;
		}
		
		return true;
	}
}
