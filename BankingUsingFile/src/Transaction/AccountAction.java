package Transaction;

import java.util.Scanner;
import Transaction.Transaction;

import Bank.Bank;
import Customers.Customer;
import Customers.CustomerFileHandler;
import Customers.CustomerHandler;

public class AccountAction {
    Scanner sc=new Scanner(System.in);
    Bank bank=new Bank();
    CustomerFileHandler cf=new CustomerFileHandler();
    CustomerHandler ch=new CustomerHandler();
    TransactionFileHandler tf=new TransactionFileHandler();
    
	public void deposit() {
		System.out.println("enter the amount to deposit");
		double amount=sc.nextDouble();
		
		Transaction t=null;
	    Customer currentcustomer=ch.getLoggedcustomer();
	    System.out.println(currentcustomer.getBalance()+" "+amount);
	    currentcustomer.setBalance(currentcustomer.getBalance()+amount);
	    
	    bank.getcustomermap().put(currentcustomer.getAccno(), currentcustomer);
	    
	    int index=bank.getCustomers().indexOf(currentcustomer);
	    bank.getCustomers().set(index, currentcustomer);
	    
	    cf.updateFile();
	    
	    if(TransactionFileHandler.transactionlist.isEmpty()) {
	    	
	    	 t=new Transaction(1,currentcustomer.getAccno(),"credit",amount,0);
	    	 TransactionFileHandler.transactionlist.add(t);
	    	 System.out.println(t.toString());
	    }
	    else {
	    	
	    	int lasttransactionid=TransactionFileHandler.transactionlist.get(TransactionFileHandler.transactionlist.size()-1).getTransactionid();
	    	long lasttransactionaccno=TransactionFileHandler.transactionlist.get(TransactionFileHandler.transactionlist.size()-1).getAccno();
	    	
	    	t=new Transaction(lasttransactionid+1,lasttransactionaccno,"credit",amount,0);
	    	System.out.println(t.toString());
	    	TransactionFileHandler.transactionlist.add(t);
	    	
	    
	    }
	    tf.updatetransaction(t);
	    	
		
	}
	
	public void withdrawal() {
		System.out.println("enter the amount to be withdraw");
		double amount=sc.nextDouble();
		Transaction t=null;
		Customer c=ch.getLoggedcustomer();
		if(c.getBalance()<amount)
		{
			System.out.println("you have an insufficient balance");
			return;
		}
		c.setBalance(c.getBalance()-amount);
		bank.getcustomermap().put(c.getAccno(), c);
		int index=bank.getCustomers().indexOf(c);
		
		bank.getCustomers().set(index, c);
		
		cf.updateFile();
		
		if(TransactionFileHandler.transactionlist.isEmpty()) {
	    	
	    	 t=new Transaction(1,c.getAccno(),"credit",amount,0);
	    	 TransactionFileHandler.transactionlist.add(t);
	    	 System.out.println(t.toString());
	    }
	    else {
	    	
	    	int lasttransactionid=TransactionFileHandler.transactionlist.get(TransactionFileHandler.transactionlist.size()-1).getTransactionid();
	    	long lasttransactionaccno=TransactionFileHandler.transactionlist.get(TransactionFileHandler.transactionlist.size()-1).getAccno();
	    	
	    	t=new Transaction(lasttransactionid+1,lasttransactionaccno,"credit",amount,0);
	    	System.out.println(t.toString());
	    	TransactionFileHandler.transactionlist.add(t);
	    	
	    
	    }
		tf.updatetransaction(t);
		
	}
	
	public void transfermoney() {
		System.out.println("enter the reciever accno");
		long recieveraccno=sc.nextLong();
		System.out.println("enter the amount to be transfered");
		double amount=sc.nextDouble();
		Transaction t=null;
		Customer sender=ch.getLoggedcustomer(),reciever=bank.getcustomermap().get(recieveraccno);
		if(sender.getBalance()<amount)
		{
			System.out.println("insufficient balance");
			return;
		}
		sender.setBalance(sender.getBalance()-amount);
		reciever.setBalance(reciever.getBalance()+amount);
		
		//updating sender object
		bank.getcustomermap().put(sender.getAccno(), sender);
		
		int senderindex=bank.getCustomers().indexOf(sender);
		bank.getCustomers().set(senderindex, sender);
		
		//updating reciever object
		bank.getcustomermap().put(reciever.getAccno(), reciever);
		int recieverindex=bank.getCustomers().indexOf(reciever);
		bank.getCustomers().set(recieverindex, reciever);
		
		cf.updateFile();
		
		if(TransactionFileHandler.transactionlist.isEmpty()) {
	    	
	    	 t=new Transaction(1,sender.getAccno(),"credit",amount,0);
	    	 TransactionFileHandler.transactionlist.add(t);
	    	 System.out.println(t.toString());
	    }
	    else {
	    	
	    	int lasttransactionid=TransactionFileHandler.transactionlist.get(TransactionFileHandler.transactionlist.size()-1).getTransactionid();
	    	long lasttransactionaccno=TransactionFileHandler.transactionlist.get(TransactionFileHandler.transactionlist.size()-1).getAccno();
	    	
	    	t=new Transaction(lasttransactionid+1,lasttransactionaccno,"credit",amount,0);
	    	System.out.println(t.toString());
	    	TransactionFileHandler.transactionlist.add(t);
	    	
	    
	    }
	    tf.updatetransaction(t);
		
		
		
		
	}
}
