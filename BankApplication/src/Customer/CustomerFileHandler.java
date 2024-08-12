package Customer;

import java.io.*; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import Customer.Customer;
import bank.Bank;

public class CustomerFileHandler {
	
	static CustomerFileHandler handler;
	
	public static CustomerFileHandler getinstance() {
			if(handler==null)
				handler=new CustomerFileHandler();
			return handler;
	}
	
	
     private static final String filename="bank_db.txt";
     
     public void initialize() throws IOException {
    	 
    	 
    	 File file=new File(filename);
    	 
    	 BufferedReader reader=new BufferedReader(new FileReader(file));
    	 String customerInfo="";
    	 while(customerInfo!=null)
    	 {
    		 customerInfo=reader.readLine();
    		 
    		 if(customerInfo==null)
    		 {
    			 break;
    		 }
    		 Customer presentcustomer=castStringToCustomer(customerInfo);
    		 Bank.customers.add(presentcustomer);
    		 Bank.customermap.put(presentcustomer.AccountId,presentcustomer);
    	 }
    	 
    	 
    	 
    	 reader.close();
    	
    	 
    	 
     }
    
     public Customer castStringToCustomer(String customerInfo) {
    		 String[] trimedInfo=customerInfo.split(" ");
    		 Customer customer=new Customer(
    				 Integer.parseInt(trimedInfo[0]),
    				 Long.parseLong(trimedInfo[1]),
    				 trimedInfo[2],
    				 Double.parseDouble(trimedInfo[3]),
    				 trimedInfo[4]
    				 );
    		 return customer;
    	 }
     
     public void addcustomertofile(Customer c)
     {
    	 File file=new File(filename);
    	 FileWriter writer=null;
    	 try {
			writer=new FileWriter(file,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 System.out.println(c.toString());
    	 try {
			writer.write("\n"+c.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 finally {
    		 if(writer!=null)
    		 {
    			 try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		 }
    	 }
    	 
     }
     
     public void updatefile()
     {
    	 File file=new File(filename);
    	 FileWriter writer=null;
    	 try {
			writer=new FileWriter(file);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 try {
    		 
    		 for(Long id:Bank.customermap.keySet())
    		 {
    			 Customer c=Bank.customermap.get(id);
    			if(c.customerId==1)
    				writer.write(c.toString());
    			else
    			 writer.write("\n"+c.toString());
    		 }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 finally {
    		 if(writer!=null)
    		 {
    			 try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		 }
    	 }
    	 
     }
     
}
