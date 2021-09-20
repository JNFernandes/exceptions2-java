package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			double init_bal = sc.nextDouble();
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			double with_lim = sc.nextDouble();
			sc.nextLine();
			
			Account account = new Account(number,name,init_bal,with_lim);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double with_ammount = sc.nextDouble();
			account.withdraw(with_ammount);
			System.out.println("New balance: " +String.format("%.2f", account.getBalance()));
			
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		sc.close();
	}
}
