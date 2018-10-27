package com.taxi.arraylist.booking;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
	private static Scanner scan=new Scanner(System.in);
	private static ArrayList<Taxi> taxi=new ArrayList<>();
	
	private static ArrayList<Transactions> trans=new ArrayList<>();
	private static int taxiNo=0;
	private static int customerNo=0;
	public static void main(String[] args) {
		int customerId;
		char pickupPoint;
		char dropPoint;
		int pickupTime;
		int dropTime;
		double earnings;
		int dist;
		int pos=0;
		boolean quit=false;
		while(!quit)
		{
			System.out.println("enter your choice");
			System.out.println("1.to booking");
			System.out.println("2.to display taxi details");
			System.out.println("3.to display transaction details");
			System.out.println("4.to exit");
			int ch=scan.nextInt();
			scan.nextLine();
			switch(ch)
			{
				case 1:
					System.out.println("enter the customer id:");
					customerId=scan.nextInt();
					scan.nextLine();
					System.out.println("enter the pickup Point:");
					pickupPoint=scan.nextLine().charAt(0);
					System.out.println("enter the drop Point:");
					dropPoint=scan.nextLine().charAt(0);
					System.out.println("enter the pickup time:");
					pickupTime=scan.nextInt();
					scan.nextLine();
					
					dropTime=Math.abs(pickupPoint-dropPoint)+pickupTime;
					dist=Math.abs(pickupPoint-dropPoint);
					earnings=((dist-5)*10)+100;
					Customer customer=new Customer(customerId, pickupPoint, dropPoint, pickupTime,dropTime);
					pos=checkAvailabaility(customer);
					if(pos==-1)
						pos=0;
					else
						System.out.println("booking rejected");
					taxi.add(pos,new Taxi(taxiNo, customerId, pickupPoint, dropPoint, pickupTime, dropTime, earnings));
					break;
				case 2:
					printTransaction();
					break;
				case 3:
					printTaxi();
					break;
				case 4:
					quit=true;
					break;
			}
					
		}
	}
	private static int checkAvailabaility(Customer customer)
	{
		int res=-1;
		double min=0;
		for(int i=0;i<taxi.size();i++)
		{
			if(taxi.get(i).getCurrentTime()<=customer.getPickupTime())
			{
				if(taxi.get(i).getEarnings()<min)
				{
					min=taxi.get(i).getEarnings();
					res=i;
				}
			}
		}
		return res;
	}
	private static void printTaxi()
	{
		System.out.println("Taxi details");
		System.out.println("taxiNo customerId pickupPoint dropPoint pickupTime dropTime earnings");
		for(int i=0;i<taxi.size();i++)
		{
		System.out.printf("%5d %5d %5c %5c %5d %5d %f",	taxi.get(i).getTaxiNo(),taxi.get(i).getCustomerId(),taxi.get(i).getPickupPoint(),
				taxi.get(i).getDropPoint(),taxi.get(i).getPickupTime(),taxi.get(i).getDropTime(),taxi.get(i).getEarnings());
				
	}
	}
	private static void printTransaction()
	{
		System.out.println("Transaction Details");
	}

}
