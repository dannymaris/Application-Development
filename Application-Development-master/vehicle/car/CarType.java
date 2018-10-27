package com.vehicle.car;

public class CarType extends Car{
	
	public CarType(int licenceNo, String ownerName, int speed) {
		super(licenceNo, ownerName, speed);
	}

	public static void main(String[] args) {
		CarType car=new CarType(5201346, "Mohan",122);
		Vehicle veh=new Vehicle("Bmw", "white", 6,4, "left");
		car.changeGears(4);
		car.movingSpeed(125);
		car.steering("right");
	}

}
