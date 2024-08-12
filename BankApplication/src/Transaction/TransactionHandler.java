package Transaction;

import java.io.File;
import java.io.FileWriter;


public class TransactionHandler {

	public void writetransaction(int customerId,Transaction transaction) {
		String filename=customerId+".txt";
		System.out.println(filename);
		
		try {
			File file=new File(filename);
			if(!file.exists())
			{
				
				System.out.println("creating");
				file.createNewFile();
				
			}
			FileWriter writer=new FileWriter(file,true);
			writer.write(transaction.toString());
		}catch(Exception e){
			System.out.println("Exception "+e);
		}
		
	}
}
