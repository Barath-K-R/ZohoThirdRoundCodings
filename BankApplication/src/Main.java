import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import Customer.Customer;
import Customer.CustomerFileHandler;
import Customer.CustomerHandler;
import bank.AccountActionHandler;
import bank.Bank;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		CustomerFileHandler handler=new CustomerFileHandler();

		try {
			handler.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		CustomerHandler handler1=new CustomerHandler();
		AccountActionHandler acchandler=new AccountActionHandler();
		CustomerFileHandler fhandler=new CustomerFileHandler();
		 
		while(true)
		{
			

			System.out.println("choose any option below"
					+ "\n"+"1-create a user"+"\n"+
					"2-deposit"+"\n"+
				     "3-withdraw"+"\n"+
					"4-Fund Transfer"+"\n"+
				     "5-print acc details");
			
			int option=sc.nextInt();
			
		switch(option)
		{
		case 1:
			handler1.addcustomer();
			break;
		case 2:
			acchandler.deposit();
			fhandler.updatefile();
			break;
		case 3:
			acchandler.withdraw();
			fhandler.updatefile();
			break;
		case 4:
			acchandler.moneytransfer();
			fhandler.updatefile();
			break;
		case 5:
			acchandler.printdetails();
			
		}
		}
		
	}
	
}
