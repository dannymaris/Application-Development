package com.employee.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner scan=new Scanner(System.in);
	private static ArrayList<Department> department=new ArrayList<>();
	private static String empId;
	private static String name;
	private static int age;
	private static String designation;
	private static String sex;
	private static String phno;
	private static String mailId;
	private static double salary;
	private static String managerName;
	private static String deptName;
	public static void main(String[] args) {
		System.out.println("Employee Management System");
		int action;
		boolean quit=false;
		printActions();
		while(!quit)
		{
			action=scan.nextInt();
			scan.nextLine();
			switch(action)
			{
			case 0:
				quit=true;
				break;
			case 1:
				addEmployee();
				break;
			case 2:
				addManager();
				break;
			case 3:
				searchEmployee();
				break;
			case 4:
				printEmployeeDetails();
				break;
			case 5:
				printActions();
				break;
			case 6:
				addDepartment();
				break;

			}
		}

		}
	public static void addDepartment()
	{
		System.out.println("Enter the Department name:");
		String dept=scan.nextLine();
		Department depObj=findDepartment(dept);
		if(depObj==null)
		{
			System.out.println("Department Added ");
			department.add(new Department(dept));
		}
		else
		{
			System.out.println("already exist");
		}
		
	}
	
	public static void  addEmployee()
	{
		System.out.println("Enter the Following Details");
		System.out.println("Enter the Department name:");
		String dept=scan.nextLine();
		Department depObj=findDepartment(dept);
		if(depObj!=null)
		{
			
			System.out.println("Valid Department \t Proceed..");
			System.out.println("Enter the Manager Name:");
			String managerName=scan.nextLine();
			Manager managObj=depObj.queryManager(managerName);
			if(managObj!=null)
			{
				System.out.println("Enter the employee id");
				String id=scan.nextLine();
				System.out.println("Enter the name");
				String name=scan.nextLine();
				System.out.println("Enter the age");
				int age=scan.nextInt();
				scan.hasNextLine();
				System.out.println("Enter the designation");
				String designation=scan.nextLine();
				System.out.println("Enter the sex");
				String sex=scan.nextLine();
				System.out.println("Enter the phone number");
				String phno=scan.nextLine();
				System.out.println("Enter the mail Id");
				String mailId=scan.nextLine();
				System.out.println("Enter the Salary");
				double salary=scan.nextDouble();
				depObj.addEmployee("Mohan", id, name, age, designation, sex, phno, mailId, salary);
				department.add(depObj);
			}
			
		}
	}
		public static void addManager()
		{
			System.out.println("Enter the Department name:");
			String dept=scan.nextLine();
			Department depObj=findDepartment(dept);
			if(depObj!=null)
			{
				
				System.out.println("Valid Department \t Proceed..");
				System.out.println("Enter the Manager Name:");
				String managerName=scan.nextLine();
				Manager managObj=depObj.queryManager(managerName);
				if(managObj==null)
				{
					depObj.addManager(managerName);
				}
			}
			
		}
		public static Employee searchEmployee()
		{
			System.out.println("Enter the name to search");
			String qName=scan.nextLine();
			for(Department depObj:department)
			{
				ArrayList<Manager> managList=depObj.getManagers();
				for(Manager managObj:managList)
				{
					ArrayList<Employee> empList=managObj.getEmployee();
					for(Employee emp:empList)
					{
						if(emp.getName().equals(qName))
						{
							System.out.println("Found");
							return emp;
						}
					}
				}
			}
			System.out.println("Not Found");
			return null;
		}
		public static void printEmployeeDetails()
		{
			
			for(Department depObj:department)
			{
				depObj.printEmployee(depObj.getManagers());
//				System.out.println("Department name: "+depObj.getDepName());
//				ArrayList<Manager> managList=depObj.getManagers();
//				for(Manager managObj:managList)
//				{
//					System.out.println("Manager Name: "+managObj.getManagName());
//					ArrayList<Employee> empList=managObj.getEmployee();
//					
//					for(Employee emp:empList)
//					{
//						System.out.println("Employee name:"+emp.getName());
//						System.out.println(emp.getAge());
//						System.out.println(emp.getPhno());
//						
//						}
//					}
//				}
			}
		}
		
		public static void printActions()
		{
			
		System.out.println("Available Actions\nPress\n");
		System.out.println("0-to quit\n"+
					"1-to add emloyee\n"+
					"2-to add manager\n"+
					"3-to search employee details \n"+
					"4-to print employee details\n"+
					"5- to print Actions\n"+
					"6-to add department");
		System.out.println("Enter Your Choice :");
		}
		public static Department findDepartment(String name)
		{
			for(Department depObj:department)
			{
				if(depObj.getDepName().equals(name))
				{
					return depObj;
				}
			}
			return null;
		}
}
