package com.train.booking;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class Train  {
	private String name;
	private ArrayList<Passenger> passenger=new ArrayList<>();
	private ArrayList<Seats> seats=new ArrayList<>();
	public Train()
	{
		int lastRow='A'+12;
		String classInfo;
		for(char row='A';row<lastRow;row++)
		{
			
			for(int seatNum=1;seatNum<12;seatNum++)
			{
				classInfo="second";
				double price=12.00;
			
				if(row=='A' ||row=='B')
				{
				classInfo="first";
				price=16.00;
				}
				Seats seat=new Seats(row+String.format("%02d", seatNum),price,classInfo);
				seats.add(seat);
				}}}
	public boolean booking(String seatNum)
	{
		Seats requestedSeat=new Seats(seatNum);
		int foundSeat=Collections.binarySearch(seats, requestedSeat,null);
		if(foundSeat>=0)
		{
			return seats.get(foundSeat).reserve();
		}
		return false;
		
	}
	public boolean availabeCheck(String seatNum)
	{
		Seats requestedSeat=new Seats(seatNum);
		int foundSeat=Collections.binarySearch(seats, requestedSeat,null);
		if(foundSeat>=0)
		{
			return seats.get(foundSeat).isReserved();
		}
		return false;
		
	}
	public boolean cancelTicket(String seatNum)
	{
		Seats requestedSeat=new Seats(seatNum);
		int foundSeat=Collections.binarySearch(seats, requestedSeat,null);
		if(foundSeat>=0)
		{
			return seats.get(foundSeat).cancelTicket();
		}
		return false;
		
	}
	public void printTicketDetails()
	{
		for(int j=1;j<=12;j++)
		System.out.print("  "+j+"  ");
		System.out.println();
		for(int i=0;i<seats.size()-1;)
		{
			Seats seat=seats.get(i);
			++i;
			if(seat.isReserved())
			System.out.print("  1  ");
			else
			System.out.print("  0  ");
//			++i;
//			Seats seat1=seats.get(i);
//			if(seat1.isReserved())
//			System.out.print("1");
//			else
//			System.out.print("0");
			if(i%12==0)
			System.out.println();
		}
	}
}
