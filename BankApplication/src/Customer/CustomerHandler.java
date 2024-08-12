package Customer;

import java.io.IOException;
import java.util.Scanner;

import Transaction.Transaction;
import Transaction.TransactionHandler;
import bank.Bank;

public class CustomerHandler {

	
static CustomerHandler handler;
	
	public static CustomerHandler getinstance() {
			if(handler==null)
				handler=new CustomerHandler();
			return handler;
	}
	
	public void addcustomer() throws IOException {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the name");
	String name=sc.nextLine();
	System.out.println("enter the password");
	String password=sc.nextLine();
	System.out.println("enter the dupppassword");
	String duppassowrd=sc.nextLine();
	
	if(!password.equals(duppassowrd))
	{
		System.out.println("password is incorrect recheck your password");
		return ;
	}
	int noofid=Bank.customers.size();
	
	long lastaccid=Bank.customers.get(noofid-1).AccountId;
	
	
	password=this.encryptpassword(password);
	
	Customer c=new Customer(
			noofid+1,
			lastaccid+1,
			name,
			10000,
			password
			
			);
	
	
	boolean isvalid=isvalidpassword(password);
	
	if(isvalid)
	{
		password=this.encryptpassword(password);
	}
	else
	{
		System.out.println("invlaidpassword");
		return;
	}
	
	Bank.customers.add(c); 
	Bank.customermap.put(c.AccountId, c);
	CustomerFileHandler.getinstance().addcustomertofile(c);
	
	logtransaction(c.customerId);
	
	} 
	
	public boolean isvalidpassword(String password) {
		
		for(int k=0;k<password.length();++k)
		{
			if((password.charAt(k)>=97 && password.charAt(k)<=122) || (password.charAt(k)>=65 && password.charAt(k)<=90) || (password.charAt(k)>=48 && password.charAt(k)<=57))
			continue;
			else
			return false;
		}
		return true;
	}
	
	
	public String encryptpassword(String password) {
		String encryptpassword="";
		Character c='a';
		for(int k=0;k<password.length();++k)
		{
			if(password.charAt(k)=='Z')
			{
				c='A';
			}
			else if(password.charAt(k)=='z')
				c='a';
			else if(password.charAt(k)=='9')
				c='0';
			else
		    c=(char) (password.charAt(k)+1);
			encryptpassword=encryptpassword+c.toString();
		}
		return encryptpassword;
	}
	
	public boolean authentification(long accountid,String password) {
		
		
		Customer c=Bank.customermap.get(accountid);
		
		if(c==null)
		{
			System.out.println("invalid customerid");
			return false;
		}
		
		if(c.password.equals(this.encryptpassword(password)))
		{
			System.out.println("Wrong Passsword");
			return false;
		}
			
		
		
		return true;
	}
	
	public void logtransaction(int cutomerid) {
		
		Transaction trans=new Transaction(1,"opening",1000,1000);
		TransactionHandler handler=new TransactionHandler();
		handler.writetransaction(cutomerid, trans);
	}
	
}
