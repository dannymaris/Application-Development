package com.calltaxi.booking;

public class Taxi implements Comparable<Taxi>{
	private static int taxiNo=0;
	private String from;
	private String to;
	private int pickupTime;
	private int dropTime;
	private double earnings;
	private String currentPos;
	private int currentTime;
	public Taxi(String from, String to, int pickupTime, int dropTime,double earnings,String currentPos,int currentTime) {
//		super();
		this.taxiNo++;
		this.from = from;
		this.to = to;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.earnings = earnings;
		this.currentPos = currentPos;
		this.currentTime = currentTime;
	}
	
	public int getTaxiNo() {
		return taxiNo;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public int getPickupTime() {
		return pickupTime;
	}
	public int getDropTime() {
		return dropTime;
	}
	@Override
	public int compareTo(Taxi o) {
		Integer i=dropTime;
		Integer j=o.getDropTime();
		return i.compareTo(j);
	}

	public static void setTaxiNo(int taxiNo) {
		Taxi.taxiNo = taxiNo;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}

	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}

	public void setCurrentPos(String currentPos) {
		this.currentPos = currentPos;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	public double getEarnings() {
		return earnings;
	}
	public String getCurrentPos() {
		return currentPos;
	}
	public int getCurrentTime() {
		return currentTime;
	}
	

}
