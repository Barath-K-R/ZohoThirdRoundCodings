package operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import employee.Employee;
import employee.EmployeeDB;

public class EmployeeOperations {

	public static HashMap<String,String>conditions=new HashMap<String,String>();
	Scanner sc=new Scanner(System.in);
	public void initialiseconditions() {
		conditions.put("=", "");
		conditions.put("!=", "");
		conditions.put("c", "");
		conditions.put("nc", "");
		conditions.put("sw", "");
		conditions.put("ew", "");
		conditions.put("<", "");
		conditions.put(">", "");
		conditions.put("bet", "");
	}
	public void displayall() {
		System.out.println("displaying all empoyes");
		for(int j=0;j<EmployeeDB.employeelist.size();++j)
		{
			Queue<Employee>q=new LinkedList<Employee>();
			q.add(EmployeeDB.employeelist.get(j));
			while(!q.isEmpty())
			{
				Employee emp=q.poll();
				System.out.println(emp.toString());
				for(int i=0;i<emp.getEmplist().size();++i)
				{
					q.add(emp.getEmplist().get(i));
				}
			}
		}
		
	}

	public void printsummary() {
		// TODO Auto-generated method stub
		
	}

	public void printmanagertree() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the reportingto manager name");
		String manager=sc.nextLine();
		
		boolean findmanager=false;
		for(int i=0;i<EmployeeDB.employeelist.size();++i)
		{
			Queue<Employee>q=new LinkedList<Employee>();
			q.add(EmployeeDB.employeelist.get(i));
			
			while(!q.isEmpty())
			{
				Employee emp=q.poll();
				if(emp.getName().contains(manager))
				findmanager=true;
				if(findmanager==true)
					System.out.println(emp.toString());
				
				for(int j=0;j<emp.getEmplist().size();++j)
				{
					if(findmanager==false && emp.getEmplist().get(j).getName().contains(manager))
					{
						findmanager=true;
						q.add(emp.getEmplist().get(j));
						break;
					}
					else if(findmanager==true)
					{
					   q.add(emp.getEmplist().get(j));

					}
				}
				
			}
			if(findmanager==true)
				break;
		}
		System.out.println();
		
	}

	public void printreportingemployees() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the reportingto manager name");
		String manager=sc.nextLine();
		
		Employee findmanager=null;
		for(int i=0;i<EmployeeDB.employeelist.size();++i)
		{
			Queue<Employee>q=new LinkedList<Employee>();
			q.add(EmployeeDB.employeelist.get(i));
			
			while(!q.isEmpty() && findmanager==null)
			{
				Employee emp=q.poll();
				System.out.println("checking "+emp.getName());
				if(emp.getName().contains(manager))
				{
					System.out.println("manager="+emp.getName()+" "+emp.getEmplist());
					EmployeeOperations.printlist(emp.getEmplist());;
					break;
				}
				
				
				for(int j=0;j<emp.getEmplist().size();++j)
				{
					System.out.println("checking "+emp.getEmplist().get(j).getName());
					if(emp.getEmplist().get(j).getName().contains(manager))
					{
						System.out.println("manager "+emp.getEmplist().get(j).getName());
						EmployeeOperations.printlist(emp.getEmplist().get(j).getEmplist());
						findmanager=emp.getEmplist().get(j);
						break;
					}
					q.add(emp.getEmplist().get(j));
				}
				
			}
		}
		
	}

	private static void printlist(ArrayList<Employee> emplist) {
		System.out.println("printing"+emplist);
		for(int i=0;i<emplist.size();++i)
		{
			System.out.println(emplist.get(i).toString());
		}
		
	}

	public void query() {
		// TODO Auto-generated method stub
		boolean exit=false;
		while(!exit)
		{
			System.out.println("1.= equal operation"+"\n"+
		                        "2.!= not equal operation"+"\n"+
					             "3.contains"+"\n"+
		                           "4.not contains"+"\n"+
					              "5.starts with"+"\n"+
		                           "6.ends with"+"\n"+
					              "7.< opeartor"+"\n"+
		                           "8.> operator"+"\n"+
					              "9.between"+"\n"+
		                           "10.exit");
			  int option=sc.nextInt();
			  sc.nextLine();
			  String s="";
			  switch(option)
			  {
			     case 1:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put("=", s);
			    	 break;
			     case 2:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put("!=", s);
			    	 break;
			     case 3:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put("c", s);
			    	 break;
			     case 4:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put("nc", s);
			    	 break;
			     case 5:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put("sw", s);
			    	 break;
			     case 6:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put("ew", s);
			    	 break;
			     case 7:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 System.out.println(s);
			    	 conditions.put("<", s);
			    	 break;
			     case 8:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put(">", s);
			    	 break;
			     case 9:
			    	 System.out.println("enter the query");
			    	 s=sc.nextLine();
			    	 conditions.put("bet", s);
			    	 break;
			     case 10:
			    	 exit=true;
			    	 break;
			    	 
			    	 
			  }
			  
			 
		}
		System.out.println( SearchOperation.querycondition());
	}

	public void addEmployee() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the employee name");
		String name=sc.nextLine();
		
		System.out.println("enter the employee age");
		int age=sc.nextInt();
		
		sc.nextLine();
		System.out.println("enter the employee designation");
		String designation=sc.nextLine();
		
		System.out.println("enter the employee department name");
		String department=sc.nextLine();
		
		System.out.println("enter the employee reportingto manager");
		String reportingto=sc.nextLine();
		
		Employee curremployee=new Employee(name,age,designation,department,reportingto);
		
		if(reportingto.contains("null"))
		{
			System.out.println("reportingto is null");
			EmployeeDB.employeelist.add(curremployee);
		}
		else
		{
			System.out.println("reportingto not null");
			Employee manager=null;
			for(int i=0;i<EmployeeDB.employeelist.size();++i)
			{
				if(EmployeeDB.employeelist.get(i).getName().contains(reportingto))
				{
					EmployeeDB.employeelist.get(i).getEmplist().add(curremployee);
					break;
				}
				else if(EmployeeDB.employeelist.get(i).getDepartment().contains(department))
				{
					Queue <Employee>q=new LinkedList<Employee>();
					q.add(EmployeeDB.employeelist.get(i));
					
					while(!q.isEmpty() && manager==null)
					{
						Employee emp=q.poll();
						for(int j=0;j<emp.getEmplist().size();++j)
						{
							if(emp.getEmplist().get(i).getName().contains(reportingto))
							{
								emp.getEmplist().get(i).getEmplist().add(curremployee);
								manager=emp.getEmplist().get(i);
								break;
							}
							else
								q.add(emp.getEmplist().get(i));
						}
					}
				}
				else
					continue;
			}
		}
		
				
	}
}
