import java.util.Scanner;

import Customers.CustomerFileHandler;
import Customers.CustomerHandler;
import Transaction.AccountAction;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean loop=true,login=false;
		CustomerHandler ch=new CustomerHandler();
		CustomerFileHandler cf=new CustomerFileHandler();
		AccountAction ac=new AccountAction();
		
		while(true) {
		  cf.initialize();
			System.out.println("->||    Welcome to Tamil Bank   ||<-"+ "\n"
		                            +"1.Create Account"+ "\n"
		                            + "2.Login Account");
			int option1=sc.nextInt();
			
			switch(option1) {
			case 1:
				ch.createAccount();
				break;
			case 2:
				login=ch.AccountLogin();
			}
			while(login) {
				System.out.println("1.Deposit"+"\n"
						+ "2.Withdrawal"+"\n"
								+ "3.Transfer money"+"\n"
										+ "4.View Balance"+"\n"
												+ "5.View Transaction Hitory"+"\n"
														+ "6.logout");
				int option2=sc.nextInt();
				
				switch(option2)
				{
				case 1:
					ac.deposit();
					break;
				case 2:
					ac.withdrawal();
					break;
				case 3:
					ac.transfermoney();
					break;
				case 4:
					System.out.println("Your active balance is "+ch.getLoggedcustomer().getBalance());
					break;
				case 6:
					login=false;
					break;
					
				}
		    }
		}

	}

}
