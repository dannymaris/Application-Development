package com.calltaxi.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static Scanner scan=new Scanner(System.in);
	private static ArrayList<Taxi> taxi=new ArrayList<>(4);
	private static ArrayList<Customer> customer=new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("Call taxi Booking");
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
				booking();
				break;
			case 2:
				printTaxiDetails();
				break;
			case 3:

				break;
			}
		}
	}
	public static boolean booking()
	{
		String CustomerId;
		String pickupPoint;
		String dropPoint;
		int pickupTime;
		int dropTime;
		int differ=0;
		double earnings;
		String currentPos;
		int currentTime;
		System.out.println("Enter the Customer Id:");
		CustomerId=scan.nextLine();
		System.out.println("Enter the Pickup Point");
		pickupPoint=scan.nextLine();
		System.out.println("Enter the Drop Point");
		dropPoint=scan.nextLine();
		System.out.println("Enter the Pickup Time");
		pickupTime=scan.nextInt();
		scan.nextLine();
		
		Customer newCustomer=new Customer(CustomerId,pickupPoint,dropPoint,pickupTime);
		customer.add(newCustomer);
		if(taxi.size()<=0)
		{
			dropTime=pickupTime-1;
			char dest=dropPoint.charAt(0);
			char start=pickupPoint.charAt(0);
			differ=Math.abs(start-dest)+1;
			dropTime+=differ;
			currentPos=dropPoint;
			currentTime=dropTime;
			earnings=differ*15;
			if(earnings>5)
			{
			earnings=100+((earnings-5)/10)*10;
			
			}
			Taxi newTaxi=new Taxi(pickupPoint,dropPoint,pickupTime,dropTime,earnings,currentPos,currentTime);
			taxi.add(newTaxi);
		}
		else
		{
			System.out.println("Finding Peer");
			
			Taxi taxiObj=findMinimumDistance();
			taxiObj.setFrom(pickupPoint);
			taxiObj.setTo(dropPoint);
			taxiObj.setPickupTime(pickupTime);
			System.out.println("New taxi Alloted taxi no is :"+taxiObj.getTaxiNo());
		}
		
		
		return false;
	}
	public void calculateFair()
	{
		double ammount;
		
	}
	public static Taxi findMinimumDistance()
	{
		Taxi taxiObj=Collections.min(taxi);
		System.out.println(taxiObj.getDropTime());
		return taxiObj;
		
	}
	public static void printTaxiDetails()
	{
		System.out.println("TaxiNo   From\t To \tDropTime\t PickupTime \tCurentPos\t CurrentTime\t Earnings ");
		System.out.println("Taxi Size "+taxi.size());
		if(taxi.size()<0)
		{
			System.out.println("Empty List");
		}
		else
		{
		for(Taxi taxiObj:taxi) 
		{
			System.out.print(taxiObj.getTaxiNo()+"   \t");
			System.out.print(taxiObj.getFrom()+" \t");
			System.out.print(taxiObj.getTo()+" \t");
			System.out.print(taxiObj.getDropTime()+"\t");
			System.out.print(taxiObj.getPickupTime()+"\t ");
			System.out.print(taxiObj.getCurrentPos()+" \t");
			System.out.print(taxiObj.getCurrentTime()+"\t ");
			System.out.print(taxiObj.getEarnings()+" \t");
			System.out.println();
		}
	}
	}
	public static void printActions()
	{
		System.out.println("Enter Available Actions\npress\n");
		System.out.println("0-to quit\n"+
						"1-to book taxi\n"+
				 		"2-to print taxi details");
			
	}

}
