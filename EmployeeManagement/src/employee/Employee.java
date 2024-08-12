package employee;

import java.util.ArrayList;

public class Employee {

	static int id=1;
	private String name;
	private int age;
	private String designation;
	private String department;
	private String reportingto;
	private ArrayList<Employee>emplist;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getReportingto() {
		return reportingto;
	}
	
	public void setReportingto(String reportingto) {
		this.reportingto = reportingto;
	}
	public Employee(String name, int age, String designation, String department, String reportingto) {
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
		this.reportingto = reportingto;
		this.emplist =new ArrayList<Employee>();
	}
	public ArrayList<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(ArrayList<Employee> emplist) {
		this.emplist = emplist;
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.age+" "+this.designation+" "+this.department+" "+this.reportingto;
	}
}
