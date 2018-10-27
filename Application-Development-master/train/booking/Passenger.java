package com.train.booking;

public class Passenger {
	private String passengerName;
	private int age;
	private String trainNo;
	private String trainName;
	private int noOfSeats;
	private String ticketNumber;
	private String boardingPoint;
	private String destPoint;
	public Passenger(String passengerName, int age, String trainNo, String trainName, int noOfSeats,
			String boardingPoint, String destPoint) {
		super();
		this.passengerName = passengerName;
		this.age = age;
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.noOfSeats = noOfSeats;
		this.boardingPoint = boardingPoint;
		this.destPoint = destPoint;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public int getAge() {
		return age;
	}
	public String getTrainNo() {
		return trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public String getDestPoint() {
		return destPoint;
	}
	public Passenger createPassenger(String passengerName, int age, String trainNo, String trainName, int noOfSeats,
			String boardingPoint, String destPoint)
	{
		return new Passenger(passengerName,age,trainNo,trainName,noOfSeats,
				boardingPoint,destPoint);
	}

}
