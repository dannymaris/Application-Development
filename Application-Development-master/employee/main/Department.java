package com.employee.main;

import java.util.ArrayList;

public class Department {
	private String depName;
	private ArrayList<Manager> managers;
	public Department(String name) {
		this.depName = name;
		this.managers=new ArrayList<Manager>();
	}
	public String getDepName() {
		return depName;
	}
	public ArrayList<Manager> getManagers() {
		return managers;
	}
	public boolean addEmployee(String managerName,String empId,String name, int age,String designation, String sex, String phno, String mailId, double salary)
	{
		Manager manager=findManager(managerName);
		if(manager!=null)
		{
			manager.addEmployee(empId, name, age, designation, sex, phno, mailId, salary);
			return true;
		}
		return false;
	}
	public boolean addManager(String name)
	{
		if(findManager(name)==null)
		{
			this.managers.add(new Manager(name));
			return true;
		}
		return false;
	}
	private Manager findManager(String name)
	{
		for(Manager obj:managers)
		{
			if(obj.getManagName().equals(name))
			{
				return obj;
			}
		}
		return null;
	}
	public void printEmployee(ArrayList<Manager> manag)
	{
		for(int i=0;i<manag.size();i++)
		{
			System.out.println("Mangers Name: "+managers.get(i).getManagName());
			ArrayList<Employee> emp=managers.get(i).getEmployee();
			for(int j=0;j<emp.size();j++)
			{
				System.out.println("Employee name"+emp.get(j).getName());
			}
		}
	}
	public Manager queryManager(String name)
	{
		for(Manager managObj:managers)
		{
			if(managObj.getManagName().equals(name))
			{
				return managObj;
			}
		}
		return null;
	}

}
