package bank;

import java.util.Scanner;

import Customer.Customer;
import Customer.CustomerHandler;

public class AccountActionHandler {
    Scanner sc=new Scanner(System.in);
    long accountid=0;
    String password="";
    double amount=0;
    
    
	public void deposit() {
		System.out.println("enter your accountid");
		accountid=sc.nextLong();
		System.out.println("enter your password");
		sc.nextLine();
		password=sc.nextLine();
		System.out.println("enter the amount to be transferred");
		amount=sc.nextDouble();
		
		
		
		CustomerHandler chandler=CustomerHandler.getinstance();
		Customer presentcutomer=null;
		boolean accverified=chandler.authentification(accountid, password);
		if(accverified)
		{
			presentcutomer=Bank.customermap.get(accountid);
			presentcutomer.balance=presentcutomer.balance+amount;
			
			Bank.customermap.put(presentcutomer.AccountId,presentcutomer);
			System.out.println("Your Balance is "+presentcutomer.balance);
			System.out.println();
		}
		else
			return;
		
	}
	
	public void withdraw()
	{
		System.out.println("enter your accountid");
		accountid=sc.nextLong();
		System.out.println("enter your password");
		sc.nextLine();
		password=sc.nextLine();
		System.out.println("enter the amount to be transferred");
		amount=sc.nextDouble();
		
		
		
		CustomerHandler chandler=CustomerHandler.getinstance();
		Customer c=null;
		boolean accverified=chandler.authentification(accountid, password);
		if(accverified)
		{
			c=Bank.customermap.get(accountid);
			if(c.balance<1000)
			{
				System.out.println("You have an insufficient balance");
				return;
			}
			c.balance=c.balance-amount;
			Bank.customermap.put(c.AccountId,c);
			System.out.println("Your amount is successfully debited"+"\n"+"Your Balance is "+c.balance);
			System.out.println();
		}
		else
			return;
	}
	
	public void moneytransfer() {
		
		System.out.println("enter your accountid");
		long senderid=sc.nextLong();
		System.out.println("enter your password");
		sc.nextLine();
		password=sc.nextLine();
		System.out.println("enter the recieverid");
		long recieverid=sc.nextLong();
		System.out.println("enter the amount to be transferred");
		amount=sc.nextDouble();
		
		
		CustomerHandler chandler=CustomerHandler.getinstance();
		Customer sender=null,reciever=null;
		boolean accverified=chandler.authentification(senderid, password) && (Bank.customermap.containsKey(recieverid));
		
		if(accverified)
		{
			sender=Bank.customermap.get(senderid);
			reciever=Bank.customermap.get(recieverid);
			
			if(sender.balance<1000)
			{
				System.out.println("You have an insufficient balance");
				return;
			}
			sender.balance=sender.balance-amount;
			reciever.balance=reciever.balance+amount;
			
			Bank.customermap.put(sender.AccountId,sender);
			Bank.customermap.put(reciever.AccountId,reciever);
			
			System.out.println("Money transferred successfully"+"\n"+"Your Balance is "+sender.balance);
			System.out.println();
		}
		else
			return;
		
	}
	
	public void printdetails() {
		for(Customer c:Bank.customermap.values())
		{
			System.out.println(c.customerId);
		}
	}
}
