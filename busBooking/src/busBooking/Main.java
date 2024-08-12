package busBooking;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	BusOperation b=new BusOperation();
	b.initializemaps();
		while(true)
		{
			System.out.println("1.Booking"+"\n"
					+ "2.Cancellation"+"\n"
					+"3.Print bus booking details");
			int option=sc.nextInt();
			
			switch(option)
			{
			    case 1:
			    	b.booking();
			}
		}

	}

}
