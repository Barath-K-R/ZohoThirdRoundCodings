package Customer;


public class Customer {

	public int customerId;
	public String name;
	public double balance;
	public String password;
	public long AccountId;
	
	

	public Customer(int customerId, long AccountId, String name, double balance, String password) {
		// TODO Auto-generated constructor stub
		this.customerId=customerId;
		this.name=name;
		this.balance=balance;
		this.password=password;
		this.AccountId=AccountId;
	}



	@Override
	public String toString() {
		
		return this.customerId+" "+this.AccountId+" "+this.name+" "+this.balance+" "+this.password;
	}

   
   
   

	

	

	
}
