package operations;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		EmployeeOperations e=new EmployeeOperations();
		e.initialiseconditions();
		boolean exit=false;
		while(!exit)
		{
			System.out.println("1.print all the employees"+"\n"+
		                          "2.query the employees"+"\n"+
					                "3.print the reporting tree"+"\n"+
		                              "4.print the employees reporting to manager"+"\n"+
					                    "5.print the summary of department,designation,reportingto "+"\n"+
		                                  "6.add employee");
			System.out.println("enter the option");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				e.displayall();
				break;
			case 2:
				e.query();
				break;
			case 3:
				e.printmanagertree();
				break;
			case 4:
				e.printreportingemployees();
				break;
			case 5:
				e.printsummary();
				break;
			case 6:
				e.addEmployee();
				break;
			}
		}

	}

}
