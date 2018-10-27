package com.train.booking;

public class Main {

	public static void main(String[] args) {
		Train trainObj=new Train();
		if(trainObj.booking("A10"))
		{
			System.out.println("please Pay bill");
		}
		else
		{
			System.out.println("Unavailable");
		}
		if(!trainObj.availabeCheck("A10"))
		{
			System.out.println("Available");
		}
		else
		{
			System.out.println("Not Available");
		}
//		if(trainObj.cancelTicket("A10"))
//		{
//			System.out.println("Refund Initaited");
//		}
//		else
//		{
//			System.out.println("Un available");
//		}
		if(!trainObj.availabeCheck("A10"))
		{
			System.out.println("Available");
		}
		else
		{
			System.out.println("Not Available");
		}
		
		if(trainObj.booking("B06"))
		{
			System.out.println("please Pay bill");
		}
		else
		{
			System.out.println("Unavailable");
		}
		
		trainObj.printTicketDetails();
	}

}
