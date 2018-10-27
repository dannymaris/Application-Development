package com.game.lift.system;

import java.util.Scanner;

public class Lift {
	private int[] floor=new int[]{0,0,0,0,0};
	private int currentFloor;
	private int destFloor;
	private int[] floorLimits=new int[3];
	private Scanner scan =new Scanner(System.in);
	public Lift()
	{
		play();
	}
	
	public void play()
	{
		boolean finish=true;
		System.out.println("Lift Floor Assignment System");
		printFloor();
		System.out.println("Enter the Details");
		
		do {
			System.out.println("Enter the current and destination floors");
			currentFloor=scan.nextInt();
			destFloor=scan.nextInt();
			findFloorLimits();
			finish=addFloor();
			printFloor();
		}while(finish);
	}
	public void findFloorLimits()
	{
		if(destFloor<=5)
		{
			floorLimits[0]=0;
			floorLimits[1]=1;
			floorLimits[2]=4;
			
		}
		else if(destFloor>=6 && destFloor<=10)
		{
			floorLimits[0]=2;
			floorLimits[1]=3;
			floorLimits[2]=4;
			
		}
		else {
			System.out.println("Enter value betwen 0 -10");
		}
	}
	public boolean addFloor()
	{
		int freeLift=isLiftFree();
		if(true)//freeLift>=0
		{
			int nearestIndex=findNearestIndex();
			System.out.println("nearestIndex "+nearestIndex);
			if(nearestIndex>=0 && nearestIndex<=4)
			{
				
				floor[nearestIndex]=destFloor;
				System.out.println("L"+(freeLift+1)+" is Assigned (nearest)");
				return true;
			}
			floor[freeLift]=destFloor;
			System.out.println("L"+(freeLift+1)+" is Assigned");
			return true;
		}
			System.out.println("No Lift are Availlable");
			return false;
	}
	
	public int findNearest(int num)
	{
		
		int currentDif=floor[0]-num;
		int diff;
		int index=-1;
		for(int i=0;i<=4;i++)
		{
			diff=Math.abs(floor[i]-num);
			if(diff<=currentDif)
			{
				currentDif=diff;
				index=i;
			}
		}
		System.out.println("Nearest index "+ index+" Current diff"+currentDif);
		return index;
	}
	public int findNearestIndex()
	{
		int j=floorLimits[0];
		int index=-1;
		int currentDiffr,rightDiffr=Math.abs(floor[j]-currentFloor),leftDiffr=rightDiffr;
		int rightNearestIndex=-1,leftNearestIndex=-1;
		for(int i=0;i<=2;i++)
		{
			j=floorLimits[i];
			currentDiffr=Math.abs(floor[j]-currentFloor);
			if(currentDiffr<=rightDiffr && floor[j]>=currentFloor)
			{
				rightDiffr=currentDiffr;
				rightNearestIndex=j;
			}
			if(currentDiffr<=leftDiffr && floor[j]<=currentFloor)
			{
				leftDiffr=currentDiffr;
				leftNearestIndex=j;
			}
		}
		System.out.println("rightNearest index= "+rightNearestIndex+"left nearest index= "+leftNearestIndex);
		if(currentFloor>destFloor && rightNearestIndex!=-1 )
			return rightNearestIndex;
		else if(currentFloor<destFloor && leftNearestIndex!=-1)
			return leftNearestIndex;
		else if(rightNearestIndex!=-1)
			return rightNearestIndex;
		else if(leftNearestIndex!=-1)
			return leftNearestIndex;
		
		
		return index;
	}
	public int maxValue()
	{
		int index=0;
		int temp=floor[0];
		for(int i=0;i<=4;i++)
		{
			if(floor[i]>temp)
			{
				temp=floor[i];
				index=i;
			}
		}
		return index;
	}
	public int isLiftFree()
	{
		for(int i=0;i<=4;i++)
		{
			if(floor[i]==0)
			{
				return i;
			}
		}
		return -1;
	}
	public void printFloor()
	{
		System.out.println("");
		System.out.println("       Lift  L1   L2   L3   L4   L5");
		System.out.print("        Floor");
		for(int i=0;i<=4;i++)
		{
			System.out.print("   "+floor[i]);
		}
		System.out.println();
		
	}
	public void printFloor(int[] floor)
	{
		System.out.println("sorted array");
		System.out.println("");
		System.out.println("       Lift  L1   L2   L3   L4   L5");
		System.out.print("        Floor");
		for(int i=0;i<=4;i++)
		{
			System.out.print("   "+floor[i]);
		}
		System.out.println();
		
	}
}
