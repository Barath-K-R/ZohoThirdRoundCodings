package operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import employee.Employee;
import employee.EmployeeDB;

public class SearchOperation {

	public static ArrayList<Employee> querycondition( ) {
		
		HashMap<String,String>h=EmployeeOperations.conditions;
		ArrayList<Employee>result=new ArrayList<Employee>();
		System.out.println("searching"+h);
		for(int j=0;j<EmployeeDB.employeelist.size();++j)
		{
			Queue<Employee>q=new LinkedList<Employee>();
			q.add(EmployeeDB.employeelist.get(j));
			while(!q.isEmpty())
			{
				Employee emp=q.poll();
				
				boolean satisfied=true;
				if(h.get("=").length()>1)
				{
					String s1=h.get("=").split(" ")[0],s2=h.get("=").split(" ")[1];
					if(s1.contains("name"))
						satisfied=emp.getName().contains(s2)?true:false;
					else if(s1.contains("age"))
						satisfied=emp.getAge()==Integer.parseInt(s2)?true:false;
					else if(s1.contains("designation"))
						satisfied=emp.getDesignation().contains(s2)?true:false;
					else if(s1.contains("department"))
						satisfied=emp.getDepartment().contains(s2)?true:false;
					else if(s1.contains("reportingto"))
						satisfied=emp.getReportingto().contains(s2)?true:false;
					
				}
				 if(h.get("!=").length()>1) {
					 String s1=h.get("!=").split(" ")[0],s2=h.get("!=").split(" ")[1];
						if(s1.contains("name"))
							satisfied=emp.getName().contains(s2)?false:true;
						else if(s1.contains("age"))
							satisfied=emp.getAge()!=Integer.parseInt(s2)?true:false;
						else if(s1.contains("designation"))
							satisfied=emp.getDesignation().contains(s2)?false:true;
						else if(s1.contains("department"))
							satisfied=emp.getDepartment().contains(s2)?false:true;
						else if(s1.contains("reportingto"))
							satisfied=emp.getReportingto().contains(s2)?false:true;
				}
                 if(h.get("c").length()>1) {
                	 String s1=h.get("c").split(" ")[0],s2=h.get("c").split(" ")[1];
						if(s1.contains("name"))
							satisfied=emp.getName().contains(s2)?true:false;
						else if(s1.contains("age"))
							satisfied=emp.getAge()==Integer.parseInt(s2)?true:false;
						else if(s1.contains("designation"))
							satisfied=emp.getDesignation().contains(s2)?true:false;
						else if(s1.contains("department"))
							satisfied=emp.getDepartment().contains(s2)?true:false;
						else if(s1.contains("reportingto"))
							satisfied=emp.getReportingto().contains(s2)?true:false;
				}
                 if(h.get("nc").length()>1) {
                	 String s1=h.get("nc").split(" ")[0],s2=h.get("nc").split(" ")[1];
						if(s1.contains("name"))
							satisfied=emp.getName().contains(s2)?false:true;
						else if(s1.contains("age"))
							satisfied=emp.getAge()==Integer.parseInt(s2)?false:true;
						else if(s1.contains("designation"))
							satisfied=emp.getDesignation().contains(s2)?false:true;
						else if(s1.contains("department"))
							satisfied=emp.getDepartment().contains(s2)?false:true;
						else if(s1.contains("reportingto"))
							satisfied=emp.getReportingto().contains(s2)?false:true;
				}
                 if(h.get("sw").length()>1) {
                	 String s1=h.get("sw").split(" ")[0],s2=h.get("sw").split(" ")[1];
						if(s1.contains("name"))
							satisfied=emp.getName().substring(0, s2.length()).contains(s2)?true:false;
						else if(s1.contains("designation"))
							satisfied=emp.getDesignation().substring(0, s2.length()).contains(s2)?true:false;
						else if(s1.contains("department"))
							satisfied=emp.getDepartment().substring(0, s2.length()).contains(s2)?true:false;
						else if(s1.contains("reportingto"))
							satisfied=emp.getReportingto().substring(0, s2.length()).contains(s2)?true:false;
				}
                 if(h.get("ew").length()>1) {
                	 String s1=h.get("ew").split(" ")[0],s2=h.get("ew").split(" ")[1];
						if(s1.contains("name"))
							satisfied=emp.getName().substring(emp.getName().length()-s2.length(), emp.getName().length()).contains(s2)?true:false;
						else if(s1.contains("designation"))
							satisfied=emp.getDesignation().substring(emp.getDesignation().length()-s2.length(), emp.getDesignation().length()).contains(s2)?true:false;
						else if(s1.contains("department"))
							satisfied=emp.getDepartment().substring(emp.getDepartment().length()-s2.length(), emp.getDepartment().length()).contains(s2)?true:false;
						else if(s1.contains("reportingto"))
							satisfied=emp.getReportingto().substring(emp.getReportingto().length()-s2.length(), emp.getReportingto().length()).contains(s2)?true:false;
				}
                 if(h.get("<").length()>1) {
                	 System.out.println(h.get("<"));
                	 String s1=h.get("<").split(" ")[0],s2=h.get("<").split(" ")[1];
					if(s1.contains("age"))
					satisfied=emp.getAge()<Integer.parseInt(s2)?true:false;
					
				}
                 if(h.get(">").length()>1) {
                	 String s1=h.get(">").split(" ")[0],s2=h.get(">").split(" ")[1];
 					if(s1.contains("age"))
 					satisfied=emp.getAge()>Integer.parseInt(s2)?true:false;
				}
                 if(h.get("bet").length()>1) {
                	 String s1=h.get("bet").split(" ")[0],s2=h.get("bet").split(" ")[1];
  					
  						if(emp.getAge()>=Integer.parseInt(s1) && emp.getAge()<=Integer.parseInt(s2))
  					     satisfied=true;
  						else
  							satisfied=false;
				}
                 
                 if(satisfied==true)
                	 result.add(emp);
                 satisfied=true;
				for(int i=0;i<emp.getEmplist().size();++i)
				{
					q.add(emp.getEmplist().get(i));
				}
			}
		}
		return result;
		
		
	}

}
