package com.vehicle.car;

public class Vehicle {
	private String name;
	private String color;
	private int gears;
	private int wheels;
	private String move;
	public Vehicle(String name, String color, int gears, int wheels, String move) {
		super();
		this.name = name;
		this.color = color;
		this.gears = gears;
		this.wheels = wheels;
		this.move = move;
	}
	public void changeGears(int gear)
	{
		this.gears=gear;
		System.out.println("Gears Changed to "+gears);
	}
	public void steering(String pos)
	{
		this.move=pos;
		System.out.println("Sterring has Changed "+move);
	}
	
}
