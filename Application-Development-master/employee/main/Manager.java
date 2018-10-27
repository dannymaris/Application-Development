package com.employee.main;

import java.util.ArrayList;

public class Manager {
	private String managName;
	private ArrayList<Employee> employee;
	public Manager(String name) {
		this.managName = name;
		this.employee=new ArrayList<>();
	}
	public String getManagName() {
		return managName;
	}
	public ArrayList<Employee> getEmployee() {
		return employee;
	}
	
	public boolean addEmployee(String empId,String name, int age,String designation, String sex, String phno, String mailId, double salary)
	{
		if(findEmployee(empId)==null)
		{
			this.employee.add(new Employee(empId,name,age,designation,sex,phno,mailId,salary ));
			return true;
		}
		return false;
		
	}
	private Employee findEmployee(String empId)
	{
		for(int i=0;i<employee.size();i++)
		{
			Employee emp=employee.get(i);
			if(emp.getEmpId().equals(empId))
			{
				return emp;	
			}
		}
		return null;
	}

}
