package com.train.booking;

public class Seats implements Comparable<Seats>{
	@Override
	public int compareTo(Seats seat) {
		return this.seatNo.compareToIgnoreCase(seat.getSeatNo());
	}
	private String seatNo;
	private double price;
	public Seats(String seatNo) {
		super();
		this.seatNo = seatNo;
	}
	private String classInfo;
	private boolean reserved=false;
	public Seats(String seatNo, double price, String classInfo) {
		super();
		this.seatNo = seatNo;
		this.price = price;
		this.classInfo = classInfo;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public double getPrice() {
		return price;
	}
	public String getClassInfo() {
		return classInfo;
	}
	public boolean isReserved() {
		return reserved;
	}
	public boolean cancelTicket()
	{
		if(this.reserved)
		{
			System.out.println("Seat number "+ this.seatNo+" is cancelled");
			this.reserved=false;
			return true;
		}
		return false;
	}
	public boolean reserve()
	{
		if(!this.reserved)
		{
			this.reserved=true;
			System.out.println("Seat number "+this.seatNo+" reserved");
			return true;
		}
		System.out.println("Alredy reserved");
		return false;
	}


}
