package com.Billing.Shop;

import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingMall {
	private static Scanner scan=new Scanner(System.in);
	private static ArrayList<Employee> employee=new ArrayList<>();
	private static ArrayList<Inventory> inventory=new ArrayList<>();
	private static String userName;
	private static String password;
	public static void main(String[] args) {
	int position;	
		employee.add(new Employee(101, "Mohan", "123","Admin",0.0));
		employee.add(new Employee(102, "Chandru", "456", "Biller", 0.0));
		employee.add(new Employee(103, "Shankar", "789", "Biller", 0.0));
		printEmployeeDetails();
		inventory.add(new Inventory(301, "I phone 7",70000.00,5, 7));
		inventory.add(new Inventory(302, "I Phone 8", 75000.25, 4.5, 8));
		inventory.add(new Inventory(302,"I Phone X",150000.50, 7.5, 10));
		printInventory();
		boolean Quit=false;
		while(!Quit)
		{
			System.out.println("Welcome To Login Page");
			System.out.println("Enter Your Details");
			System.out.println("Enter the User Name:");
			userName=scan.nextLine();
			System.out.println("Enter the Password");
			password=scan.nextLine();
			position=findEmployee();
			if(position>=0)
			{
				if(employee.get(position).getPassword().equals(password))
				{
					System.out.println("Valid Username and Password");
					
				}
				
			}
			
			
			
		}
	
	}
	public static int findEmployee()
	{
		for(int i=0;i<employee.size();i++)
		{
			if(employee.get(i).getEmpName().equals(userName))
			{
				return i;
			}
		}
		
		
		return -1;
	}
	public static void printEmployeeDetails()
	{
		System.out.println("\n/////.....Printing Employee Details...\\\\");
		System.out.println();
		System.out.println("Employee Id\t Employee Name\t password\t employeeRole\t totalSale");
		for(int i=0;i<employee.size();i++)
		{
			System.out.printf("\n%10d  %10s  %10s  %10s  %10.2f",employee.get(i).getEmpId(),employee.get(i).getEmpName(),
					employee.get(i).getPassword(),employee.get(i).getEmpRole(),employee.get(i).getTotalSale());
		}
	}
	public static void printInventory()
	{
		System.out.println("\n\n\n******.....Printing inventory Details...*****");
		System.out.println();
		System.out.println("Product Id Product Name\t Price\t Discount Quantity");
		for(int i=0;i<inventory.size();i++)
		{
			System.out.printf("\n%10d %10s %10.2f %5.1f %5d",inventory.get(i).getProductId(),inventory.get(i).getProductName(),
					inventory.get(i).getProductPrice(),inventory.get(i).getProductDiscount(),inventory.get(i).getQuantity());
		}
	}
}
