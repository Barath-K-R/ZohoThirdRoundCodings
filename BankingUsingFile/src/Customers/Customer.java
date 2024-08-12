package Customers;

public class Customer {

	 private int customerId;
	 private long accno;
	 private String name;
	 private int age;
	 private double balance;
	 private String password;
	 
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(int customerId, long accno, String name, int age,double balance ,String password) {
		
		this.customerId = customerId;
		this.accno = accno;
		this.name = name;
		this.age = age;
		this.balance = balance;
		this.password = password;
	}
	
	public String toString() {
		return this.customerId+" "+this.accno+" "+this.name+" "+this.age+" "+this.balance+" "+this.password;
	}
	 
	 
	 
}
