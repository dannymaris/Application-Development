package com.bank.demo;

import java.util.Scanner;

public class Customer {
	public static int accNo;
	public static float balance;
	public static String customerName;
	public static String email;
	public static int phNo;
	public static float deposit;
	public static float withdrawl;
	public static void main(String[] args) {
		BankAccount acc=new BankAccount(123,0.2,"asd","Asd",1235);
		System.out.println("Create Your Account");
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter The Account No");
		accNo=scan.nextInt();
		System.out.println("Enter The Balance");
		balance=scan.nextFloat();
		System.out.println("Enter The Email Id");
		email=scan.next();

		System.out.println("Enter The Customer Name");
		customerName=scan.next();
		System.out.println("Enter The Ph No");
		phNo=scan.nextInt();
		acc.setAccNo(accNo);
		acc.setBalance(balance);
		acc.setCustomerName(customerName);
		acc.setEmail(email);
		acc.setPhNo(phNo);
		
		System.out.println("For Deposit Enter Your Ammount");
		deposit=scan.nextFloat();
		acc.depositFunds(deposit);
		System.out.println("Your New Balance is "+acc.getAccNo());
		System.out.println("For Withdrawl Enter The Ammount");
		withdrawl=scan.nextFloat();
		
		acc.withdraw(withdrawl);
	}

}
