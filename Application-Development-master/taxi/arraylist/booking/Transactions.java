package com.taxi.arraylist.booking;

public class Transactions {
	private int taxiNo;
	private int customerId;
	private char pickupPoint;
	private char dropPoint;
	private int pickupTime;
	private int dropTime;
	private double earnings;
	public Transactions(int taxiNo, int customerId, char pickupPoint, char dropPoint, int pickupTime, int dropTime,
			double earnings) {
		super();
		this.taxiNo = taxiNo;
		this.customerId = customerId;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
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
