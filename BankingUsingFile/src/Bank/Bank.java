package Bank;
import java.util.ArrayList;
import java.util.HashMap;

import Customers.Customer;

public class Bank {
	
     private static ArrayList<Customer>customers=new ArrayList<Customer>();
     private static HashMap<Long,Customer>customermap=new HashMap<Long,Customer>();
	
     public  ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public HashMap<Long,Customer> getcustomermap() {
		return this.customermap;
	}
	public void setcustomermap(HashMap<Long,Customer>customermap) {
		this.customermap=customermap;
	}
     
}
