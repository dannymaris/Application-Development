package com.taxi.arraylist.booking;

public class Taxi {
	private int taxiNo;
	private int customerId;
	private char currentPos='A';
	private int currentTime=0;
	private char pickupPoint;
	private char dropPoint;
	private int pickupTime;
	private int dropTime;
	private double earnings;
	public Taxi(int taxiNo, int customerId, char pickupPoint, char dropPoint,
			int pickupTime, int dropTime, double earnings) {
		super();
		this.taxiNo = taxiNo;
		this.customerId = customerId;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.currentPos = this.dropPoint;
		this.currentTime = this.dropTime;
		this.earnings = earnings;
	}
	public int getTaxiNo() {
		return taxiNo;
	}
	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public char getCurrentPos() {
		return currentPos;
	}
	public void setCurrentPos(char currentPos) {
		this.currentPos = currentPos;
	}
	public int getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}
	public char getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public char getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}
	public int getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}
	public int getDropTime() {
		return dropTime;
	}
	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}
	public double getEarnings() {
		return earnings;
	}
	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}
	
	
}
