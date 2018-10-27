package com.calltaxi.booking;

public class Customer {
	private String CustomerId;
	private String pickupPoint;
	private String dropPoint;
	private int pickupTime;
	public Customer(String customerId, String pickupPoint, String dropPoint, int pickupTime) {
		super();
		CustomerId = customerId;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.pickupTime = pickupTime;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public String getPickupPoint() {
		return pickupPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public int getPickupTime() {
		return pickupTime;
	}

}
