package operations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import employee.Employee;
import employee.EmployeeDB;

public class EmployeeOperation {

	public void displayall() {
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
		// TODO Auto-generated method stub
		
	}

	public void printreportingtree() {
		// TODO Auto-generated method stub
		
	}

	public void query() {
		// TODO Auto-generated method stub
		
	}

	public void addEmployee() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the employee name");
		String name=sc.nextLine();
		
		System.out.println("enter the employee age");
		int age=sc.nextInt();
		
		System.out.println("enter the employee designation");
		String designation=sc.nextLine();
		
		System.out.println("enter the employee department name");
		String department=sc.nextLine();
		
		System.out.println("enter the employee reportingto manager");
		String reportingto=sc.nextLine();
		
		Employee curremployee=new Employee(name,age,designation,department,reportingto);
		
		if(reportingto=="null")
			EmployeeDB.employeelist.add(curremployee);
		else
		{
			Employee manager=null;
			for(int i=0;i<EmployeeDB.employeelist.size();++i)
			{
				if(EmployeeDB.employeelist.get(i).getName().contains(reportingto))
				{
					EmployeeDB.employeelist.add(curremployee);
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
								emp.getEmplist().add(curremployee);
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
