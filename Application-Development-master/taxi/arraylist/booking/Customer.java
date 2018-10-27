package com.taxi.arraylist.booking;

public class Customer {
	private int customerId;
	private char pickupPoint;
	private char dropPoint;
	private int pickupTime;
	private int dropTime;
	public Customer(int customerId, char pickupPoint, char dropPoint, int pickupTime, int dropTime) {
		super();
		this.customerId = customerId;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
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
	
}
