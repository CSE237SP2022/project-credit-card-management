package classes;

import java.io.File;

public class FileHandler {

	final String systemFilePath = "systemFiles/";
	final String accountsFile = "accounts.txt";
	final String debitCardsFile = "debitCards.txt";
	final String creditCardsFile = "creditCards.txt";
	
	public FileHandler() {
		
	}
	
	public File getAccountsFile() {
		return new File(systemFilePath+accountsFile);
	}

	public File getCreditCardsFile() {
		return new File(systemFilePath+creditCardsFile);
	}

	public File getDebitCardsFile() {
		return new File(systemFilePath+debitCardsFile);
	}
}
