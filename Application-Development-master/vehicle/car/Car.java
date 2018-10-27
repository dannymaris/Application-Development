package com.vehicle.car;

public class Car extends Vehicle{
	private int licenceNo;
	private String ownerName;
	private int speed;
	
	public Car(int licenceNo, String ownerName, int speed) {
		super(ownerName, ownerName, speed, speed, ownerName);
		this.licenceNo = licenceNo;
		this.ownerName = ownerName;
		this.speed = speed;
	}
	 
	public void movingSpeed(int speed)
	{
		this.speed=speed;
		System.out.println("Speed has changed "+this.speed+" kmph");
	}

	

}
