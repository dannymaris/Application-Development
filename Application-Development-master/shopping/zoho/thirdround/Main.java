package com.shopping.zoho.thirdround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static Scanner scan=new Scanner(System.in);
	private static ArrayList<Administrators> admin=new ArrayList<Administrators>();
	private static ArrayList<Transactions> transactions=new ArrayList<>();
	private static ArrayList<Inventory> inventory=new ArrayList<>();
	private static String userName;
	private static String password;
	public static void main(String[] args) {
		admin.add(new Administrators("Mohan", "Admin","1234",0.0));
		admin.add(new Administrators("Raj","Biller","4321",0.0));
		
		inventory.add(new Inventory(1000, "I phone 7",57060.70, 5,2));
		inventory.add(new Inventory(1001,"I Pad",47000.60,7,3));
		inventory.add(new Inventory(1002,"I Pod", 12503.50, 8,5));
		
		printAdmin();
		printInventory();
		printTransaction();
		
		boolean quit=false;
		
		while(!quit)
		{
			System.out.println("Enter User Name");
			userName=scan.nextLine();
			int userNamePos=findAdminUserName();
			if(userNamePos>=0)
			{
				
				System.out.println("Enter the Password");
				password=scan.nextLine();
				if(admin.get(userNamePos).getPassword().equals(password))
				{
					System.out.println("Valid Password And User Name");
					if(admin.get(userNamePos).getUserRole().equals("Admin"))
					{
						System.out.println("You Are An admin");
						boolean quitAdmin=false;
						while(!quitAdmin)
						{
							printAdminMenu();
							int action=scan.nextInt();
							scan.nextLine();
							switch(action)
							{
							case 0:
								printAdminMenu();
								break;
							case 1:
								addInventory();
								break;
							case 2:
								updateInventory();
								break;
							case 3:
								removeInventory();
								break;
							case 4:
								billing();
								break;
							case 5:
								printInventory();
								break;
							case 6:
								transactionMethod();
								break;
							case 7:
								quitAdmin=true;
								break;
							case 8:
								printAdmin();
								break;
							
							}
							
							
							
						}
						
					}
					else if(admin.get(userNamePos).getUserRole().equals("Biller"))
					{
						boolean billerQuit=false;
						System.out.println("You are an Biller");
						while(!billerQuit)
						{
							printBillerMenu();
							int billerAction=scan.nextInt();
							scan.nextLine();
							
							switch(billerAction)
							{
							case 1:
								billing();
								break;
							case 2:
								printInventory();
								break;
							case 3:
								transactionMethod();
								break;
							case 4:
								billerQuit=true;
								break;
							 
							}
						
						}
							
					}
				}
				else
				{
					System.out.println("Invalid Password!");
				}
				
			}
			else
			{
				System.out.println("Invalid User Name");
			}
		}
	}
	private static boolean transactionMethod()
	{
		System.out.println("Welcome To Transaction Method");
		boolean quit =false;
		while(!quit)
		{
			printTransactionMenu();
			int action=scan.nextInt();
			scan.nextLine();
			switch(action)
			{
			case 1:
				printTransaction();
				break;
			case 2:
				System.out.println("Enter the Name: ");
				String name=scan.nextLine();
				printTransactionByName(name);
				break;
			case 3:
				System.out.println("Enter the Action: ");
				String actionName=scan.nextLine();
				printTransactionByAction(actionName);
				break;
			case 4:
				quit=true;
				break;
			}
			
			
		}
		
		
		
		return false;
	}
	private static boolean billing()
	{
		int[] productQuantity=new int[inventory.size()];
		for(int i=0;i<inventory.size();i++)
			productQuantity[i]=0;
		
		System.out.println("Welcome To Billing");
		boolean quit=false;
		double currAmmount=0.0;
		while(!quit)
		{
			System.out.println("Current Amount "+currAmmount);
			System.out.println("1.Add Item");
			System.out.println("2.Procceed");
			System.out.println("3.Cancel and Exit");
			int action=scan.nextInt();
			scan.nextLine();
			switch(action)
			{
			case 1:
				System.out.println("Enter the Product ID");
				int tempProductId=scan.nextInt();
				int productPos=checkProductId(tempProductId);
				
				if(productPos>=0)
				{
					System.out.println("Enter the Quantity");
					int Quantity=scan.nextInt();
					scan.nextLine();
					if(inventory.get(productPos).getProductQuantity()>=Quantity)
					{
						productQuantity[productPos]+=Quantity;
						System.out.println("Available !! Added To Cart");
						System.out.println("Product Id \t Product Name \t Product Rate \t Product Quantity \t Product Discount \t Price");
						for(int i=0;i<inventory.size();i++)
						{
							if(productQuantity[i]!=0)
							{

								double discount=inventory.get(i).getProductRate()*((double)inventory.get(i).getDiscount()/100);
								discount=(double)productQuantity[i]*discount;
								double ammount=inventory.get(i).getProductRate()*(double)productQuantity[i];
								ammount=ammount-discount;
								currAmmount+=ammount;
								
								System.out.printf("%10d \t %10s \t %10f \t %10d \t %17f \t %16.2f ",inventory.get(i).getProductId(),inventory.get(i).getProductName(),inventory.get(i).getProductRate(),
										productQuantity[i],discount,ammount);
								System.out.println();
							}
						}
					}
					else
					{
						System.out.println("Invalid !! Not Enough Quantity Available");
					}
					
				}
				else
				{
					System.out.println("Invalid Product Id!!");
				}
				
				break;
			case 2:
				System.out.println("Billing...");
				System.out.println("Product Id \t Product Name \t Product Rate \t Product Quantity \t Product Discount \t Price");
				for(int i=0;i<inventory.size();i++)
				{
					if(productQuantity[i]!=0)
					{
						double discount=inventory.get(i).getProductRate()*((double)inventory.get(i).getDiscount()/100);
						discount=(double)productQuantity[i]*discount;
						double ammount=inventory.get(i).getProductRate()*(double)productQuantity[i];
						ammount=ammount-discount;
						
						System.out.printf("%10d \t %10s \t %10f \t %10d \t %10f \t %16f ",inventory.get(i).getProductId(),inventory.get(i).getProductName(),inventory.get(i).getProductRate(),
								productQuantity[i],discount,ammount);
						System.out.println();
						int Quantity=inventory.get(i).getProductQuantity();
						inventory.get(i).setProductQuantity(Quantity-productQuantity[i]);
						transactions.add(new Transactions(inventory.get(i).getProductId(),inventory.get(i).getProductName(),inventory.get(i).getProductRate(),
								inventory.get(i).getDiscount(),"SALE", userName,productQuantity[i],ammount));
					}
				}
				
				int adminPos=findAdminUserName();
				double totalSale=admin.get(adminPos).getTotalSale()+currAmmount;
				admin.get(adminPos).setTotalSale(totalSale);
			
				
				printInventory();
				quit=true;
				break;
			case 3:
				quit=true;
				break;
			
			}
			
		}
		return false;
	}
	private static boolean removeInventory()
	{
		System.out.println("Welcome To Removing Inventory");
		System.out.println("Enter the Product Id");
		int productId=scan.nextInt();
		scan.nextLine();
		int productPos=checkProductId(productId);
		if(productPos>=0)
		{
			transactions.add(new Transactions(inventory.get(productPos).getProductId(), inventory.get(productPos).getProductName(),inventory.get(productPos).getProductRate(),
					inventory.get(productPos).getDiscount(),"REMOVE", userName,0,0.0));
			inventory.remove(productPos);
			System.out.println("Removed Successfully");
			printInventory();
		}
		else
		{
			System.out.println("Invalid ProductId!!No Such Product");
		}
		
		
		return false;
	}
	private static boolean updateInventory()
	{
		System.out.println("Welcome To Updating Inventory");
		System.out.println("Enter the Product Id:");
		int productId=scan.nextInt();
		scan.nextLine();
		int productPos=checkProductId(productId);
		if(productPos>=0)
		{	
			String productName;
			double productRate;
			int discount;
			int productQuantity;
			System.out.println("Exisiting Product");
			System.out.println("Enter the New Product Name");
			productName=scan.nextLine();
			System.out.println("Enter the New Product Rate");
			productRate=scan.nextDouble();
			scan.nextLine();
			System.out.println("Enter the New discount");
			discount=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the New Product Quantity");
			productQuantity=scan.nextInt();
			scan.nextLine();
			Inventory invenObj=new Inventory(productId, productName, productRate, discount, productQuantity);
			inventory.set(productPos,invenObj);
			transactions.add(new Transactions(productId, productName, productRate, discount,"UPDATE", userName,productQuantity,0.0));
			System.out.println("Updated Successfully");
			printInventory();
					
		}
		else
		{
			System.out.println("Invalid Product Id! Seems to be new one");
			
			
		}
		
		return false;
	}
	private static boolean addInventory()
	{
		System.out.println("Welcome To Adding Inventory");
		System.out.println("Enter the New product Id");
		int productId=scan.nextInt();
		scan.nextLine();
		int productPos=checkProductId(productId);
		if(productPos<0)
		{
			String productName;
			double productRate;
			int discount;
			int productQuantity;
			System.out.println("Seems to be new Item");
			System.out.println("Enter the Product Name");
			productName=scan.nextLine();
			System.out.println("Enter thr Product Rate");
			productRate=scan.nextDouble();
			scan.nextLine();
			System.out.println("Enter the discount");
			discount=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Product Quantity");
			productQuantity=scan.nextInt();
			scan.nextLine();
			inventory.add(new Inventory(productId, productName, productRate, discount, productQuantity));
			transactions.add(new Transactions(productId, productName, productRate, discount, "ADD", userName,productQuantity,0.0));
			System.out.println("Added Successfully");
			printInventory();
		}
		else
		{
			System.out.println("Invalid Product Id!Already Existing");
		}
		
		return false;
	}
	private static int checkProductId(int productId)
	{
		for(int i=0;i<inventory.size();i++)
		{
			if(inventory.get(i).getProductId()==productId)
			{
				return i;
			}
		}
		return -1;
	}
	private static int findAdminUserName()
	{
		for(int i=0;i<admin.size();i++)
		{
			if(admin.get(i).getUserName().equals(userName))
			{
				return i;
			}
			
		}
		
		return -1;
	}
	private static void printAdminMenu()
	{
		System.out.println("Enter Your Actions\nPress:\n");
		System.out.println("0.Print Menu Again\n"+
							"1.to add inventory\n"+
							"2.to update inventory\n"+
							"3.to remove inventory\n"+
							"4.to billing\n"+
							"5.to view inventory\n"+
							"6.to transaction details\n"+
							"7.to logout\n"+
							"8.to print Admin Details"
							);
	}
	private static void printBillerMenu()
	{
		System.out.println("Enter your Actions \nPress:\n");
		System.out.println("0.Print Menu again\n"+
							"1.to billing\n"+
							"2.to view inventory\n"+
							"3.to transaction Details\n"+
							"4.to logout\n");
		
	}
	private static void printAdmin()
	{
		System.out.println("User Name \t User Role \t User Password \t Total Sale");
		for(int i=0;i<admin.size();i++)
		{
			System.out.printf("%10s \t %10s \t %10s \t %10f", admin.get(i).getUserName(),
					admin.get(i).getUserRole(),admin.get(i).getPassword(),admin.get(i).getTotalSale());
			System.out.println();
		}
	}
	private static void printInventory()
	{
		System.out.println("Product Id \t Product Name \t Product Rate \t Product Discount \t Product Quantity");
		for(int i=0;i<inventory.size();i++)
		{
			System.out.printf("%10d \t %10s \t %10.2f \t %10d \t %10d",inventory.get(i).getProductId(),inventory.get(i).getProductName(),
					inventory.get(i).getProductRate(),inventory.get(i).getDiscount(),inventory.get(i).getProductQuantity());
			System.out.println();
		}
	}
	private static void printTransaction()
	{
		System.out.println("Product Id \t Product Name \t Product Rate \t Discount \t Actions \t User Name \t Product Quantity \t Total Ammount");
		for(int i=0;i<transactions.size();i++)
		{	System.out.printf("%10d \t %10s \t %10.2f \t %10d \t %10s \t %10s \t %10d \t %10f",transactions.get(i).getProductId(),transactions.get(i).getProductName(),transactions.get(i).getProductRate(),
					transactions.get(i).getDiscount(),transactions.get(i).getActions(),transactions.get(i).getUserName(),transactions.get(i).getProductQuantity(),transactions.get(i).getTotalAmmount());
			System.out.println();
		}
	}
	private static void printTransactionByName(String name)
	{

		System.out.println("Product Id \t Product Name \t Product Rate \t Discount \t Actions \t User Name \t Product Quantity \t Total Ammount");
		for(int i=0;i<transactions.size();i++)
		{
			if(transactions.get(i).getUserName().equals(name))
			{
			System.out.printf("%10d \t %10s \t %10.2f \t %10d \t %10s \t %10s \t %10d \t %10f",transactions.get(i).getProductId(),transactions.get(i).getProductName(),transactions.get(i).getProductRate(),
					transactions.get(i).getDiscount(),transactions.get(i).getActions(),transactions.get(i).getUserName(),transactions.get(i).getProductQuantity(),transactions.get(i).getTotalAmmount());
			System.out.println();
			}
		}
	}
	private static void printTransactionByAction(String action)
	{

		System.out.println("Product Id \t Product Name \t Product Rate \t Discount \t Actions \t User Name \t Product Quantity \t Total Ammount");
		for(int i=0;i<transactions.size();i++)
		{
			if(transactions.get(i).getActions().equals(action))
			{
			System.out.printf("%10d \t %10s \t %10.2f \t %10d \t %10s \t %10s \t %10d \t %10f",transactions.get(i).getProductId(),transactions.get(i).getProductName(),transactions.get(i).getProductRate(),
					transactions.get(i).getDiscount(),transactions.get(i).getActions(),transactions.get(i).getUserName(),transactions.get(i).getProductQuantity(),transactions.get(i).getTotalAmmount());
			System.out.println();
			}
		}
	}
	private static void printTransactionMenu()
	{
		System.out.println("Enter Your Action\nPress:\n");
		System.out.println("1.to Print All Transactions");
		System.out.println("2.to print By User Name");
		System.out.println("3.to print By Acion Method \tADD UPDATE REMOVE SALE");
		System.out.println("4.Back to Main Menu");
	}
}
