package Customers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

import Bank.Bank;

public class CustomerFileHandler {
	   String filename="bank_db.txt";
	   Bank bank=new Bank();
	   
	   public void initialize() {
		   File file=new File(filename);
		   try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			
				try {
					while(reader!=null) {
					      String customerinfo=reader.readLine();
					      
					      if(customerinfo==null)
						   break;
					      Customer c=stringtocustomer(customerinfo);
					      
					      bank.getCustomers().add(c);
					      bank.getcustomermap().put(c.getAccno(), c);
					}
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	   }
	   
	   
       public void addcustomertofile(Customer c) {
    	   File file=new File(filename);
    	   FileWriter writer=null;
    	   
    	   try {
			writer=new FileWriter(file,true);
			System.out.println(c.toString());
			if(c.getCustomerId()==1)
			writer.write(c.toString());
			else
				writer.write("\n"+c.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   finally {
    		   if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	   }
      }
       
       public void updateFile() {
    	   File file=new File(filename);
    	   FileWriter writer=null;
    	   try {
    		    writer=new FileWriter(file);
			for(int i=0;i<bank.getCustomers().size();++i)
			{
				
				Customer c=bank.getCustomers().get(i);
				System.out.println(c.toString());
				if(c.getCustomerId()==1)
				    writer.write(c.toString());
				else
					writer.write("\n"+c.toString());
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   finally {
    		   if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	   }
       }
       
       public Customer stringtocustomer(String customerinfo) {
    	  
    	   String[] trimmedinfo=customerinfo.split(" ");
    	   
    	   Customer c=new Customer(Integer.parseInt(trimmedinfo[0]),
    			                   Long.parseLong(trimmedinfo[1]),trimmedinfo[2],Integer.parseInt(trimmedinfo[3]), Double.parseDouble(trimmedinfo[4]),trimmedinfo[5]);
    	   return c;
       }
}
