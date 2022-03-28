package classes;

import java.util.Scanner;

public class CommandLineApp {
	
	public static void main(String[] args) {
		final String accountsFile = "accounts.txt";
		ManagementSystem system = new ManagementSystem(accountsFile);
		runUserAccountMenu(loginUser(system));
	}
	
	private static void runUserAccountMenu(Account userAccount) {
		if(userAccount == null) return;
		String userInput = "";
		while(!userInput.equals("QUIT")) {
			promptUserMenuOptions();
			userInput = getUserInfoString();
			if(Integer.parseInt(userInput) == 0) {
				System.out.println(userAccount.toString());
			}
		}
	}
	
	public static Account loginUser(ManagementSystem system) {
		String username = "";
		String password = "";
		while(username.equals("")) {
			promptUserForUsername();
			username = getUserInfoString();
		}
		while(password.equals("")) {
			promptUserForPassword();
			password = getUserInfoString();
		}	
		
		return system.verifyUserCredentials(username, password);
	}
	
	public static String getUserInfoString() {
		Scanner scanner = new Scanner(System.in);
		String infoString = scanner.nextLine();
		return infoString;
	}

	private static void promptUserMenuOptions() {
		System.out.println("Options:");
		System.out.println("0 - view account details");
		System.out.println("QUIT - exit this menu");
		System.out.print(">>> ");
	}

	public static void promptUserForUsername() {
		System.out.print("Enter your username: ");
	}
	
	public static void promptUserForPassword() {
		System.out.print("Enter your password: ");
	}

}