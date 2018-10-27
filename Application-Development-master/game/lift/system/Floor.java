//package com.game.lift.system;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class Floor {
//	private static ArrayList<Integer> floors=new ArrayList<Integer>(5);
//	private static int currentFloor;
//	private static int destFloor;
//	int previousFloor;
//
//	private static Scanner scan =new Scanner(System.in);
//	public Floor()
//	{
//		initializeFloors();
//		play();
//	}
//	public void initializeFloors()
//	{
//		for(int i=0;i<=4;i++)
//		{
//			floors.add(0);
//		}
//	}
//	
//	public void play()
//	{
//		
//		boolean finish=true;
//		System.out.println("Lift Floor Assignment System");
//		printFloor();
//		System.out.println("Enter the Details");
//		
//		do {
//
//			System.out.println("\tprevious floor "+previousFloor+" is indexof "+floors.indexOf(6));
//			System.out.println("Enter the current and destination floors");
//			currentFloor=scan.nextInt();
//			destFloor=scan.nextInt();
//			finish=addFloor();
//			printFloor();
//			previousFloor=destFloor;
//		}while(finish);
//	}
//	public boolean addFloor()
//	{
//		int index=floors.indexOf(0);
//		if(index>=0 && index<=4)
//		{
//			int nearestIndex=findNearestElement(floors);
//			
//			System.out.println("nearest Index= "+nearestIndex+" index="+index);
//			if(nearestIndex>=0 && nearestIndex<=4)
//			{
//				printFloor();
//				System.out.println("nearest Index= "+nearestIndex+" index="+index);
//				
//				this.floors.set(nearestIndex, destFloor);
//				System.out.println("L"+(nearestIndex+1)+" is Assigned (since it is nearest)");
//				System.out.println("nearest floor index of "+floors.indexOf(destFloor));
//
//				
//				return true;
//			}
//			printFloor();
//			floors.set(index, destFloor);
//			System.out.println("L"+(index+1)+" is Assigned");
//			System.out.println("floor index of "+floors.indexOf(destFloor));
//			
//			return true;
//		}
//		
//		
//		System.out.println("Floors are full");
//		return false;
//	}
//	public int findNearestElement(ArrayList<Integer> tempFloor)
//	{
//		int leftNearestIndex=-1,rightNearestIndex=-1;
//		int numIndex;
//		Collections.sort(tempFloor);
//		
//		numIndex=tempFloor.indexOf(currentFloor);
//		if(numIndex-1>=0 )
//		leftNearestIndex=tempFloor.get(numIndex-1);
//		if(numIndex+1<=4)
//		rightNearestIndex=tempFloor.get(numIndex+1);
//		
//
//		leftNearestIndex=floors.indexOf(leftNearestIndex);
//		rightNearestIndex=floors.indexOf(rightNearestIndex);
//		System.out.println("leftNearestIndex = "+leftNearestIndex+" rightNearest= " +rightNearestIndex+" numIndex= "+numIndex);
//		if(destFloor>currentFloor && rightNearestIndex<=4 && rightNearestIndex>=0)
//		{
//			
//			
//			System.out.println("right index="+rightNearestIndex);
//			return rightNearestIndex;
//		}
//		else if(destFloor<currentFloor && rightNearestIndex<=4 && rightNearestIndex>=0)
//		{
//			
//			
//			System.out.println("left index="+leftNearestIndex);
//			return leftNearestIndex;
//		}
//		return -5;
//	}
//	public void printFloor()
//	{
//		System.out.println("");
//		System.out.println("       Lift  L1   L2   L3   L4   L5");
//		System.out.print("        Floor");
//		for(int i=0;i<=4;i++)
//		{
//			System.out.print("   "+floors.get(i));
//		}
//		System.out.println();
//		
//	}
//
//}
