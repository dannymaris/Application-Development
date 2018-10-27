package com.bank.braches;

import java.util.ArrayList;

public class Customers {
	private String name;
		private ArrayList<Double> transactions;
	
	public Customers(String name,double ammount)
	{
		this.name=name;
		this.transactions=new ArrayList<Double>();
		addTransactions(ammount);
	}
	public String getName() {
		return name;
	}

	public ArrayList<Double> getTransactions() {
		return transactions;
	}
	public void addTransactions(double ammount)
	{
		this.transactions.add(ammount);
	}
	


	
}