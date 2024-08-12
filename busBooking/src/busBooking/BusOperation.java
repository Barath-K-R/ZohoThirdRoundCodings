package busBooking;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BusOperation {
	
	

	Scanner sc=new Scanner(System.in);
	 
	public static HashMap<Integer,String> bus1=new HashMap<Integer,String>();
	public static HashMap<Integer,String> bus2=new HashMap<Integer,String>();
	public static HashMap<Integer,String> bus3=new HashMap<Integer,String>();
	public static HashMap<Integer,String> bus4=new HashMap<Integer,String>();
	
	public  void booking() {
		
		BusDao b=new BusDao();
		Date date = null;
		BookingDao bd=new BookingDao();
		b.displaybusinfo();
		
		System.out.println("enter your name");
		String passengername=sc.nextLine();
		System.out.println("enter your prefrred bus no");
		int busno=sc.nextInt();
		
		
		sc.nextLine();
		System.out.println("enter the date in dd/mm/yy");
		String inputdate=sc.nextLine();
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		
		try {
			date = sdf.parse(inputdate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		this.setbookedseats(busno, date);
		this.displayavialseats(busno);
		System.out.println("enter the seat no");
		int seatno=sc.nextInt();
		if(bd.bookedcount(busno, date)<b.getCapacity(busno)) {
			boolean booked=bd.booking(passengername, busno, date,seatno);
		    if(booked)
		    	System.out.println("seat "+seatno+" in bus "+busno+" is confirmed");
		}
		else 
		{
			System.out.println("tickets are not available");
			return;
		}
	}
	
	public void initializemaps() {
		BusDao b=new BusDao();
		int capacity=b.getCapacity(1);
		for(int i=1;i<=capacity;++i)
		{
			bus1.put(i,Integer.toString(i));
			bus2.put(i, Integer.toString(i));
			bus3.put(i,Integer.toString(i));
			bus4.put(i, Integer.toString(i));
		}
	}
	
	public void setbookedseats(int busno,Date date) {
		
		BookingDao bd=new BookingDao();
		BusDao b=new BusDao();
		ArrayList<Integer> i=new ArrayList<Integer>();
		int temp=0;
		i=bd.getbookedseats(busno, date);
		for(int k=0;k<i.size();++k)
		{
			System.out.println(i.get(k));
		}
		if(i.isEmpty())
		return;
		
			
	    
		for(int k=1;k<=b.getCapacity(busno);++k)
		{
			if(temp>=i.size())
				break;
			if(busno==1)
			{
				if(k==i.get(temp))
				{
					bus1.put(k, "B");
					temp++;
				}
				else
				{
					bus1.put(k, Integer.toString(k));
					continue;
				}
			}
			else if(busno==2) {
				if(k==i.get(temp))
				{
					bus2.put(temp, "B");
					temp++;
				}
				else
				{
					bus2.put(k, Integer.toString(k));
					continue;
				}
			}
			else if(busno==3) {
				if(k==i.get(temp))
				{
					bus3.put(temp, "B");
					temp++;
				}
				else
				{
					bus3.put(k, Integer.toString(k));
					continue;
				}
			}
			else if(busno==4) {
				if(k==i.get(temp))
				{
					bus4.put(temp, "B");
					temp++;
				}
				else {
					bus4.put(k, Integer.toString(k));
					continue;
				}
				
			}
		}
	    
	    
		
		
	}
	
	public void displayavialseats(int busno) {
		BusDao b=new BusDao();
		int temp=1;
		for(int k=1;k<=b.getCapacity(busno);++k)
		{
			if(busno==1)
	        System.out.print(bus1.get(k)+" ");
			else if(busno==2)
				 System.out.print(bus2.get(k)+" ");
			else if(busno==3)
			System.out.print(bus3.get(k)+" "); 
			else if(busno==4)
				 System.out.print(bus4.get(k)+" ");
			
			
			
			if(temp==2)
				System.out.print("  ");
			else if(temp==4)
				System.out.println();
			if(temp==4)
			{
				temp=1;
				continue;
			}
			temp++;
		}
		System.out.println();
			
		}
	

}
