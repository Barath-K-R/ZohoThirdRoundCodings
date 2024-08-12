package Customers;

import java.util.Scanner;
import Customers.Customer;
import Transaction.AccountAction;
import Transaction.TransactionFileHandler;
import Bank.Bank;

public class CustomerHandler {
    Scanner sc=new Scanner(System.in);
    Bank bank=new Bank();
    TransactionFileHandler tf=new TransactionFileHandler();
    private static Customer loggedcustomer=null;
    
    
	

	public static Customer getLoggedcustomer() {
		return loggedcustomer;
	}

	public static void setLoggedcustomer(Customer loggedcustomer) {
		CustomerHandler.loggedcustomer = loggedcustomer;
	}

	public void createAccount() {
		System.out.println("enter your name");
		String name=sc.nextLine();
		System.out.println("enter your age");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("enter a strong passowrd");
		String password=sc.nextLine();
		
		Customer newcustomer=null;
		String encryptedpassword=encryptpassword(password);
		//adding new customer in bank customer arraylist
		if(!bank.getCustomers().isEmpty())
		{
		    int lastcustomerid=bank.getCustomers().get(bank.getCustomers().size()-1).getCustomerId();
		    long lastaccno=bank.getCustomers().get(bank.getCustomers().size()-1).getAccno();
		    newcustomer=new Customer(lastcustomerid+1,lastaccno+1,name,age,1000,encryptedpassword);
		}
		else
		{
			newcustomer=new Customer(1,100101,name,age,1000,encryptedpassword);
		}
		
		
		
		
		bank.getCustomers().add(newcustomer);
		bank.getcustomermap().put(newcustomer.getAccno(), newcustomer);
		
		//adding new customer to file
		CustomerFileHandler ch=new CustomerFileHandler();
		ch.addcustomertofile(newcustomer);
		
		
	
	}
	
	public boolean AccountLogin() {
		System.out.println("enter your accno");
		long accno=sc.nextLong();
		sc.nextLine();
		System.out.println("enter your password");
		String password=sc.nextLine();
		
		String encryptedpassword=encryptpassword(password);
		
		if(!bank.getcustomermap().containsKey(accno)) 
		{
			System.out.println("invalid accno");
			return false;
		}
		else 
		{
			Customer c=bank.getcustomermap().get(accno);
			
			if(!c.getPassword().equals(encryptedpassword))
			{
				System.out.println("Wrong password");
				return false;
			}
			else {
				this.setLoggedcustomer(c);
				
				System.out.println("Hi "+c.getName()+", You have successfully logged in");
				return true;
			}
		}
	
		
}
	
	public String encryptpassword(String password) {
		String encryptedpassword="";
		Character tempc=' ';
		for(int i=0;i<password.length();++i)
		{
			if((password.charAt(i)>=97 && password.charAt(i)<=122) || (password.charAt(i)>=65 && password.charAt(i)<=90)||(password.charAt(i)>=48 && password.charAt(i)<=57))
			{
				if(password.charAt(i)=='Z' || password.charAt(i)=='z'|| password.charAt(i)=='9')
				{
					if(password.charAt(i)=='Z')
						tempc='A';
					else if(password.charAt(i)=='z')
						tempc='a';
					else if(password.charAt(i)=='9')
						tempc='0';
				}
				
				tempc=(char) (password.charAt(i)+1);
				String temps=Character.toString(tempc);
				encryptedpassword=encryptedpassword+temps;
			}
		}
		
		return encryptedpassword;
	}
}
