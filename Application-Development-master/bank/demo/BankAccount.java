package com.bank.demo;

public class BankAccount {
	private int accNo;
	private float balance;
	private String customerName;
	private String email;
	private int phNo;
	
	public BankAccount(int accNo, float balance, String customerName, String email, int phNo) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.customerName = customerName;
		this.email = email;
		this.phNo = phNo;
	}
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhNo() {
		return phNo;
	}
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	
	public void depositFunds(float amt)
	{
		this.balance+=amt;
		System.out.println("Your New Balance is "+balance);
	}
	public void withdraw(float amt)
	{
		if(this.balance>=amt)
		{
			System.out.println("\nValid Ammount\n");
			this.balance-=amt;
			System.out.println("Withdrawl SusscessFull new Balance is "+balance+" available");
		}
		else
		{
			System.out.println("\nInvalid Ammount\n");
			System.out.println("Your Current Balance Ammount is "+balance);
		}
	}
	
}
