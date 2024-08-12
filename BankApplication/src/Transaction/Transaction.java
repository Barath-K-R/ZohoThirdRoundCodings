package Transaction;

public class Transaction {
      public int transactionid;
      public String type;
      double amount;
      double balance;
      
      public Transaction(int transactionid,String type,double amount,double balance) {
    	  this.transactionid=transactionid;
    	  this.type=type;
    	  this.amount=amount;
    	  this.balance=balance;
    	  
      }

	@Override
	public String toString() {
		return transactionid + " " + type + " " + amount + " "+ balance;
	}
      
      
}
