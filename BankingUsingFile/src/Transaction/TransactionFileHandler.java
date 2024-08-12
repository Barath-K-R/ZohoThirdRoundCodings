package Transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Customers.Customer;

public class TransactionFileHandler {
	public static ArrayList<Transaction>transactionlist=new ArrayList<Transaction>();
	
        
	
        public void updatetransaction(Transaction t ) {
        	System.out.println("updating transaction file");
        	String filename=t.getAccno()+".txt";
        	System.out.println(filename);
        	File file=new File(filename);
        	
        	if(!file.exists())
        	{
        	try {
        		
				file.createNewFile();
				FileWriter writer=new FileWriter(file,true);
				for(int i=0;i<TransactionFileHandler.transactionlist.size();++i)
				{
					if(t.getTransactionid()==1)
					writer.write(t.toString());
					else
						writer.write("\n"+t.toString());
				}
				writer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        	else
        	{
        		try {
        			System.out.println("file exists");
					FileWriter writer=new FileWriter(file);
					System.out.println(TransactionFileHandler.transactionlist.size());
					for(int i=0;i<TransactionFileHandler.transactionlist.size();++i)
					{
						System.out.println(t.toString());
						if(t.getTransactionid()==1)
						writer.write(t.toString());
						else
							writer.write("\n"+t.toString());
					}
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        		
        	
        }
        
        
        public void displaytransaction(Customer c) {
        	String filename=c.getAccno()+".txt";
        	File file=new File(filename);
        	
        	try {
				BufferedReader reader=new BufferedReader(new FileReader(file));
				try {
				while(reader!=null)
				{
				    System.out.println(reader.readLine());
				}
				reader.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
}
